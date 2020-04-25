package org.dullbird.demo;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月21日 21:41:00
 */
public class FileApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        char targetWord = 'c';
        File file = new File("/Users/user01/workcontext/idea/learnSpace/dullbird-lab/question/question-log/src/main/resources/file.log");
        int count = 0;
        try(RandomAccessFile accessFile = new RandomAccessFile(file, "r")) {
            MappedByteBuffer buffer = accessFile.getChannel().map(FileChannel.MapMode.READ_ONLY,
                    0, file.length());
            while (buffer.remaining() > 0) {
                if (buffer.get() == targetWord) {
                    count ++;
                }
            }
        }
        System.out.println(count);
//        Thread.sleep(100000);
    }
}
