package org.dullbird.jsoup.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月26日 14:53:00
 */
public class HtmlDemo {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        Document document = Jsoup.connect("https://blog.csdn.net/lv_hang515888/article/details/101346379").get();
        //6.Jsoup解析html
        //像js一样，通过标签获取title
        System.out.println(document.getElementsByTag("title").first());
        //像js一样，通过id 获取文章列表元素对象
        Element postList = document.getElementById("post_list");
        Elements imgs = document.select("img");
        System.out.println(imgs.first());
        System.out.println(imgs);
        System.out.println(System.currentTimeMillis() - s);

    }
}
