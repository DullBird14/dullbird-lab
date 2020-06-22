package org.dullbird.es.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.*;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月20日 09:43:00
 */
@Slf4j
public class HighLevelClientDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        // 简单index request 请求
//        IndexRequestMethod();
//        BulkRequestMethod();
        LoopBulkRequestMethod();
        MultiBulkRequestMethod();
        System.out.println("============main-sleep============");
        LockSupport.park();
    }

    private static void MultiBulkRequestMethod() throws IOException {
        RestHighLevelClient restHighLevelClient = getClient();
        long startTime = System.currentTimeMillis();
        BulkRequest bulkRequest = new BulkRequest();
        for (int i = 0; i < 100; i++) {
            bulkRequest.add(createIndexRequest(String.valueOf(i)));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("=====================" + bulk.hasFailures());
        System.out.println("=========MultiBulkRequestMethod:costTime========" + (System.currentTimeMillis() - startTime));
        restHighLevelClient.close();
    }

    private static void LoopBulkRequestMethod() throws ExecutionException, InterruptedException, IOException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(100, 100,
                60L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                new ThreadFactory() {
                    private AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("es-client" + count.incrementAndGet());
                        return thread;
                    }
                });
        RestHighLevelClient restHighLevelClient = getClient();
        ArrayList<Future> taskList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Future<?> task = executorService.submit(() -> {
//                log.info("========================start:{}========================", finalI);
                IndexRequest request = createIndexRequest(String.valueOf(finalI));
                StopWatch watch = new StopWatch();
                watch.start();
                try {
                    BulkResponse bulk = restHighLevelClient.bulk(new BulkRequest()
                            .add(request), RequestOptions.DEFAULT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                watch.stop();
            });
            taskList.add(task);
        }
        for (Future future : taskList) {
            future.get();
        }
        System.out.println("=========LoopBulkRequestMethod:costTime========" + (System.currentTimeMillis() - startTime));
        restHighLevelClient.close();
    }

    private static void BulkRequestMethod() {
        try (RestHighLevelClient restHighLevelClient = getClient()) {
            IndexRequest indexRequest4 = createIndexRequest("4");
            IndexRequest indexRequest5 = createIndexRequest("5");
            BulkRequest request = new BulkRequest();
            request.add(indexRequest4);
            request.add(indexRequest5);
            StopWatch watch = new StopWatch();
            watch.start();
            BulkResponse bulk = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
            watch.stop();
            log.info("=======================================\n=====stopWatch:{}\n=======status:{}",
                    watch.prettyPrint(), bulk.status());
        } catch (IOException e) {
            log.info("exception:{}", e);
        }
    }

    private static void IndexRequestMethod() throws IOException {
        RestHighLevelClient restHighLevelClient = getClient();
        IndexRequest indexRequest = createIndexRequest("3");

        //3. 获取返回结果
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        int status = index.status().getStatus();
        log.info("status:{}", status);
        restHighLevelClient.close();
    }

    private static IndexRequest createIndexRequest(String id) {
        //2.构造index请求
        IndexRequest indexRequest = new IndexRequest("sku");
        indexRequest.id(id);
        Map skuMap = new HashMap();
        skuMap.put("name", "华为p30pro");
        skuMap.put("brandName", "华为");
        skuMap.put("categoryName", "手机");
        skuMap.put("price", 1010221);
        skuMap.put("createTime", "2019‐05‐01");
        skuMap.put("saleNum", 101021);
        skuMap.put("commentNum", 10102321);
        Map spec = new HashMap();
        spec.put("网络制式", "移动4G");
        spec.put("屏幕尺寸", "5");
        skuMap.put("spec", spec);
        //todo 这里的source是什么意思
        indexRequest.source(skuMap);
        return indexRequest;
    }

    private static RestHighLevelClient getClient() {
        //1.构造客户端
        HttpHost http = new HttpHost("127.0.0.1", 9200, "http");
        //rest构建器
        RestClientBuilder builder = RestClient.builder(http);
        //高级客户端对象
        return new RestHighLevelClient(builder);
    }
}
