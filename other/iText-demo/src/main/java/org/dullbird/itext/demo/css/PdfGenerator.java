package org.dullbird.itext.demo.css;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月19日 14:37:00
 */
public class PdfGenerator {
    public static void generate(String htmlStr, OutputStream out)
            throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(htmlStr.getBytes()));
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(doc, null);
        renderer.layout();
        renderer.createPDF(out);
        out.close();
    }
}
