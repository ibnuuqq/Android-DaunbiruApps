package com.simple.ibnuqarib.myapplication.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    //public static ApiServices getInstance(){
      //  return setInit().create(ApiServices.class);
    //}
//}
public class InitRetrofit {
    public static ApiServices getInstance(){
        return setInit().create(ApiServices.class);
    }

        private static Retrofit setInit() {
            String API_URL = "http://192.168.1.44/daunbiruapp/";
            return new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}