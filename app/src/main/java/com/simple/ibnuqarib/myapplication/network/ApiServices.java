package com.simple.ibnuqarib.myapplication.network;


import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.MediaItem;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer.ResponseSpek;
import com.simple.ibnuqarib.myapplication.LihatAnalyzer.ResponseAnalyzer;
import com.simple.ibnuqarib.myapplication.LihatOnline.ResponseOnline;
import com.simple.ibnuqarib.myapplication.ResponseCategory.ResponseCategory;
import com.simple.ibnuqarib.myapplication.ResponseCategory.SUB.ResponseSub;
import com.simple.ibnuqarib.myapplication.ResponseModul.ResponseModul;
import com.simple.ibnuqarib.myapplication.ResponseNews.ResponseBerita;
import com.simple.ibnuqarib.myapplication.ResponseProduk.ResponseProduk;
import com.simple.ibnuqarib.myapplication.ResponseSoftware.ResponseSoftware;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("tampil_online.php")
    Call<ResponseOnline> request_show_monita();
    @GET("tampil_analyzer.php")
    Call<ResponseAnalyzer> request_show_analyzer();
    @GET("tampil_category.php")
    Call<ResponseCategory> getCategory();
    @GET("tampil_produk.php")
    Call<ResponseProduk> request_show_produk(@Query("id") String id );
    //Tipe Method ("API_END_POINT")
    @GET("tampil_berita.php")
    Call<ResponseBerita>request_show_all_berita();
    @GET("tampil_software.php")
    Call<ResponseSoftware>request_show_software();
    @GET("tampil_modul.php")
    Call<ResponseModul> request_show_modul();
    @GET("tampil_subcategory.php")
    Call<ResponseSub> request_get_sub(@Query("id_category") String id_category);
    @GET("tampil_spekk.php")
    Call<ResponseSpek> request_get_spek(@Query("id_sub_category") String id_sub_category);
    @GET("tampil_media.php")
    Call<List<MediaItem>> request_get_media(@Query("id_sub_category") String id_sub_category);
    //Model Data > Nama Method
   // @GET("tampil_sub.php")
    //Call<ResponseSub> request_show_sub(@Query("id_category")String id_category);
}
