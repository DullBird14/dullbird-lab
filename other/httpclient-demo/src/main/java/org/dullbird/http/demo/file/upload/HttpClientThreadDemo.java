package org.dullbird.http.demo.file.upload;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 11:10:00
 */
public class HttpClientThreadDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        AtomicInteger integer = new AtomicInteger(0);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 30,
                30, TimeUnit.SECONDS, new SynchronousQueue<>(), r -> new Thread(r,
                "http Thread" + integer.getAndIncrement()));

        HttpPostTest(executor);
        Thread.sleep(100000000L);
    }

    private static void HttpPostTest(ThreadPoolExecutor executor) throws FileNotFoundException {
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
        Future<String> future = executor.submit(() -> {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        });

        try {
            future.get(30000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
            //可以关闭阻塞的http操作
            httpPost.abort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
