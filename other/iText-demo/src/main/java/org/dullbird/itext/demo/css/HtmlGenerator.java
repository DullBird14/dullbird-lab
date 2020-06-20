package org.dullbird.itext.demo.css;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月19日 14:36:00
 */
public class HtmlGenerator {
    public static String generate(String template, Map<String,Object> variables) throws Exception{
        Configuration config = FreemarkerConfiguration.getConfiguation();
        Template tp = config.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        tp.setEncoding("UTF-8");
        tp.process(variables, writer);
        String htmlStr = stringWriter.toString();
        writer.flush();
        writer.close();
        return htmlStr;
    }
}
