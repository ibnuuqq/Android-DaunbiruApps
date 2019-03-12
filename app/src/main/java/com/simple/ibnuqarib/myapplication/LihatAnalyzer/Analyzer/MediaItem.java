package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;


import com.google.gson.annotations.SerializedName;


public class MediaItem{


	@SerializedName("id_sub_category")
	private String idSubCategory;

	@SerializedName("nama_sub_category")
	private String namaSubCategory;

	@SerializedName("media")
	private String media;

	@SerializedName("deskripsi")
	private String deskripsi;

	public void setIdSubCategory(String idSubCategory){
		this.idSubCategory = idSubCategory;
	}

	public String getIdSubCategory(){
		return idSubCategory;
	}

	public void setNamaSubCategory(String namaSubCategory){
		this.namaSubCategory = namaSubCategory;
	}

	public String getNamaSubCategory(){
		return namaSubCategory;
	}

	public void setMedia(String media){
		this.media = media;
	}

	public String getMedia(){
		return media;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	@Override
	public String toString(){
		return
				"MediaItem{" +
						"id_sub_category = '" + idSubCategory + '\'' +
						",nama_sub_category = '" + namaSubCategory + '\'' +
						",media = '" + media + '\'' +
						",deskripsi = '" + deskripsi + '\'' +
						"}";
	}
}