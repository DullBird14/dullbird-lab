package org.dullbird.itext.demo;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月19日 14:04:00
 */
public class TestMain {
    public static void main(String [] args) throws Exception
    {
        String urlsource = getURLSource(new File("/Users/user01/Desktop/22222.html"));
        String cssSource = getURLSource(new File("/Users/user01/Desktop/temp.css"));
        htmlToPdf(urlsource,cssSource);
    }

    // 支持中文
    public static void htmlToPdf(String htmlstr,String cssSource) throws Exception
    {
        String outputFile = "/Users/user01/Desktop/temp.pdf";
        Document document = new Document();
        PdfWriter writer = null;
        writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
        document.open();

        InputStream bis = new ByteArrayInputStream(htmlstr.toString().getBytes());
        InputStream cssis = new ByteArrayInputStream(cssSource.toString().getBytes());
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, bis,cssis);

        document.close();
    }

    /**
     * 通过网站域名URL获取该网站的源码
     *
     * @param url
     * @return String
     * @throws Exception
     */
    public static String getURLSource(File url) throws Exception
    {
        InputStream inStream = new FileInputStream(url);
        // 通过输入流获取html二进制数据
        byte [] data = readInputStream(inStream); // 把二进制数据转化为byte字节数据
        String htmlSource = new String(data);

        inStream.close();
        return htmlSource;
    }

    /**
     * 把二进制流转化为byte字节数组
     *
     * @param instream
     * @return byte[]
     * @throws Exception
     */
    public static byte [] readInputStream(InputStream instream) throws Exception
    {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte [] buffer = new byte[1204];
        int len = 0;
        while ((len = instream.read(buffer)) != -1)
        {
            outStream.write(buffer, 0, len);
        }
        instream.close();
        return outStream.toByteArray();
    }
}
