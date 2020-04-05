package org.dullbird.zero.copy;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月04日 15:14:00
 */
public class demo {
    private static int fileSize = 1 * 1024 * 1024;
    private static final String number = "1";

    public static void main(String[] args) throws IOException {
        int[] sizes = {128,256,512,4096,8192,1024*16,1024*32,1024*128,1024*512};
        try {
            for (int size : sizes) {
//                normalFileWrite(size);
//                mmpWrite(size);
                fileChannelWrite(size);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ByteBuffer initBuffer(int size) {
        return ByteBuffer.allocateDirect(size);
    }

    public static void fileChannelWrite(int size) throws IOException {
        File file = createFile("/Users/user01/workcontext/idea/learnSpace/dullbird-lab/lab-2-zero-copy/src/main/resources/META-INF/fileChannel.log");
        long startTime = System.currentTimeMillis();
        FileChannel channel = new RandomAccessFile(file, "rw")
                .getChannel();
        ByteBuffer buffer = initBuffer(1);
        for (int i = 0; i < size; i++) {
            //因为buffer是复用的，写之前要先清理, position和limit = capacity
            buffer.clear();
            buffer.put(number.getBytes(Charset.defaultCharset()));
            // 切换为读模式。 buffer的position和limit互换
            buffer.flip();
            channel.write(buffer);
            channel.force(false);
        }
//        channel.force(true);
        System.out.printf("test channel total=%d, cost_times=%d\n", size, System.currentTimeMillis() -startTime);
    }
    public static void normalFileWrite(int size) throws IOException {
        File file = createFile("/Users/user01/workcontext/idea/learnSpace/dullbird-lab/lab-2-zero-copy/src/main/resources/META-INF/normal.log");
        long startTime = System.currentTimeMillis();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (int i = 0; i < size; i++) {
            fileOutputStream.write(number.getBytes(Charset.defaultCharset()));
            fileOutputStream.flush();
        }
//        fileOutputStream.flush();
        System.out.printf("test fileOutputStream total=%d, cost_times=%d\n", size, System.currentTimeMillis() -startTime);
    }

    public static void mmpWrite(int size) throws IOException {
        File file = createFile("/Users/user01/workcontext/idea/learnSpace/dullbird-lab/lab-2-zero-copy/src/main/resources/META-INF/mmp.log");
        long startTime = System.currentTimeMillis();
        MappedByteBuffer mbf = new RandomAccessFile(file, "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, size * 8 );
        for (int i = 0; i < size; i++) {
            mbf.put(number.getBytes(Charset.defaultCharset()));
            mbf.force();
//            System.out.println("=============================" + i);
        }
//        mbf.force();
        System.out.printf("test mmpWrite total=%d, cost_times=%d\n", size, System.currentTimeMillis() -startTime);
    }


    private static File createFile(String name) throws IOException {
        File file = new File(name);
        file.delete();
        file.createNewFile();
        return file;
    }
}
