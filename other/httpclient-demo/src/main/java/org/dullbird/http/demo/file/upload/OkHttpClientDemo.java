package org.dullbird.http.demo.file.upload;

import okhttp3.*;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

import java.io.*;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月19日 18:05:00
 */
public class OkHttpClientDemo {
    public static void main(String[] args) throws FileNotFoundException {
        OkHttpClient httpClient = new OkHttpClient();
        // Use the imgur image upload API as documented at https://api.imgur.com/endpoints/image
        File upload = new File("/Users/user01/Desktop/111.key");
        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body1 = RequestBodyUtil.create(mediaType, new FileInputStream(upload));
        MultipartBody body = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "111.key", body1)
                .build();
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8080")
                .post(body)
                .build();
        Call call = httpClient.newCall(request);
        //1.异步请求，通过接口回调告知用户 http 的异步执行结果

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    System.out.println(response.body().string());
                }
            }
        });
    }
}
class RequestBodyUtil {

    public static RequestBody create(final MediaType mediaType, final InputStream inputStream) {
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return mediaType;
            }

            @Override
            public long contentLength() {
                //todo 此处需要自己处理
                try {
                    return inputStream.available();
//                    return 355996L;
                } catch (IOException e) {
                    return 0;
                }
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                Source source = null;
                try {
                    source = Okio.source(inputStream);
                    sink.writeAll(source);
                } finally {
                    Util.closeQuietly(source);
                }
            }
        };
    }
}
