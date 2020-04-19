package org.dullbird.http.demo.file.upload;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 11:10:00
 */
public class ApacheHttpClientTimeOutDemo {
    public static void main(String[] args) throws IOException {
//        HttpGetTest();
//        HttpPostTest();
        HttpAsyncPostTest();
    }

    private static void HttpAsyncPostTest() throws FileNotFoundException {
        CloseableHttpAsyncClient asyncClient = HttpAsyncClients.createDefault();
        asyncClient.start();
        File file = new File("/Users/user01/Desktop/111.key");
        final HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/");
        /**
         * form模式提交文件
         */
        MultipartEntityBuilder entitybuilder = MultipartEntityBuilder.create();
        entitybuilder.setContentType(ContentType.MULTIPART_FORM_DATA);
        entitybuilder.addBinaryBody("file", new FileInputStream(file),
                ContentType.APPLICATION_OCTET_STREAM,"111.key");
        HttpEntity build = entitybuilder.build();
        httpPost.setEntity(build);
        //不设置回调函数
        Future<HttpResponse> execute = asyncClient.execute(httpPost, null);
        //先用阻塞的方式试一试
        try {
            HttpResponse httpResponse = execute.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void HttpPostTest() throws FileNotFoundException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**
         * 设置 socketTimeOut,这个参数可以设置在 httpClient 或者 RequestConfig
         * RequestConfig会覆盖 httpClient的参数
         * 超时时间1000ms
         */
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(100)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .setRetryHandler((exception, executionCount, context) -> false)
                .build();

        File file = new File("/Users/user01/Desktop/111.key");
        final HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/");
        /**
         * form模式提交文件
         */
        MultipartEntityBuilder entitybuilder = MultipartEntityBuilder.create();
        entitybuilder.setContentType(ContentType.MULTIPART_FORM_DATA);
        entitybuilder.addBinaryBody("file", new FileInputStream(file),
                ContentType.APPLICATION_OCTET_STREAM,"111.key");
        HttpEntity build = entitybuilder.build();
        httpPost.setEntity(build);
        httpPost.setConfig(requestConfig);
        // 用于后面时间输出
        Long startTime = System.currentTimeMillis();
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.printf("cost time:%d,content:%s\n", System.currentTimeMillis() - startTime,
                    content);
        } catch (Exception e) {
            System.out.printf("cost time:%d\n",
                    System.currentTimeMillis() - startTime);
            e.printStackTrace();
        }
    }

    private static void HttpGetTest() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig.Builder builder = RequestConfig.custom()
                .setSocketTimeout(1000);
        final HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/");
        httpGet.setConfig(builder.build());
        Long startTime = System.currentTimeMillis();
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String content = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.printf("cost time:%d,content:%s", System.currentTimeMillis() - startTime,
                    content);
        } catch (Exception e) {
            System.out.printf("cost time:%d\n",
                    System.currentTimeMillis() - startTime);
            e.printStackTrace();
        }
    }
}
