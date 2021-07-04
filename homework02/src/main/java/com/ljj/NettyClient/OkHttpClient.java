package com.ljj.NettyClient;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpClient {
    // 缓存客户端实例
    public static okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

    // GET 调用
    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    public static void main(String[] args) throws Exception {

        String url = "http://localhost:8801";
        String text = OkHttpClient.run(url);
        System.out.println("url: " + url + " ; response: \n" + text);

        OkHttpClient.client = null;
    }
}
