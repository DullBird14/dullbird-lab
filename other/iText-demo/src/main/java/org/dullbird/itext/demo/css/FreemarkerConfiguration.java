package org.dullbird.itext.demo.css;

import freemarker.template.Configuration;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月19日 14:36:00
 */
public class FreemarkerConfiguration {
    private static Configuration config = null;

    /**
     * Static initialization.
     *
     * Initialize the configuration of Freemarker.
     */
    static{
        config = new Configuration();
        config.setClassForTemplateLoading(FreemarkerConfiguration.class, "template");
    }

    public static Configuration getConfiguation(){
        return config;
    }

}
