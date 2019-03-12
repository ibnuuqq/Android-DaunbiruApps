package com.simple.ibnuqarib.myapplication.ResponseCategory.SUB;

import com.google.gson.annotations.SerializedName;


public class SubcategoryItem{

	@SerializedName("id_category")
	private String idCategory;

	@SerializedName("nama_sub_category")
	private String namaSubCategory;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("nama_category")
	private String namaCategory;

	String id_sub;
	String nama_sub;
	String deskripsi_sub;
	public SubcategoryItem (String id,String nama,String deskrip){
		this.id_sub = id;
		this.nama_sub = nama;
		this.deskripsi_sub = deskrip;
	}


	public void setIdCategory(String idCategory){
		this.idCategory = idCategory;
	}

	public String getIdCategory(){
		return idCategory;
	}

	public void setNamaSubCategory(String namaSubCategory){
		this.namaSubCategory = namaSubCategory;
	}

	public String getNamaSubCategory(){
		return namaSubCategory;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setNamaCategory(String namaCategory){
		this.namaCategory = namaCategory;
	}

	public String getNamaCategory(){
		return namaCategory;
	}

	@Override
 	public String toString(){
		return 
			"SubcategoryItem{" + 
			"id_category = '" + idCategory + '\'' + 
			",nama_sub_category = '" + namaSubCategory + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			",nama_category = '" + namaCategory + '\'' + 
			"}";
		}
}