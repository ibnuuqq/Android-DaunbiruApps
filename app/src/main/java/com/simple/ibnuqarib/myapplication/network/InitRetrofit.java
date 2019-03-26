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
        //http://10.10.10.11:9991/daunbiruapp/
            // IP SERVER DAUN BIRU
            String API_URL = "http://10.10.10.11:9991/daunbiruapp/";
            return new Retrofit.Builder().baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}