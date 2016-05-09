package com.coolweather.app.util;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by bear on 2016/5/8.
 */
public class GetResponse {
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){

            return response.body().string();
        }else {
            throw new IOException("Unexpected"+response);

        }
    }
}
