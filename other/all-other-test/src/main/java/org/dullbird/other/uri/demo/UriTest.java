package org.dullbird.other.uri.demo;

import java.net.URI;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月31日 10:59:00
 */
public class UriTest {
    public static void main(String[] args) {
        URI uri = URI.create("lb://a_b_c");
        System.out.println(uri);
//        URI uri2 = URI.create("lb://a-b-c");
//        System.out.println(uri2);

    }
}
