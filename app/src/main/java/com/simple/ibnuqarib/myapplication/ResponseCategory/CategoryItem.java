package com.simple.ibnuqarib.myapplication.ResponseCategory;


import com.google.gson.annotations.SerializedName;

public class CategoryItem{

	@SerializedName("id_category")
	private String idCategory;

	@SerializedName("nama_category")
	private String namaCategory;


	@SerializedName("nama_sub_category")
	private String namaSubCategory;

	@SerializedName("deskripsi")
	private String deskripsi;


	public void setIdCategory(String idCategory){
		this.idCategory = idCategory;
	}

	public String getIdCategory(){
		return idCategory;
	}

	public void setNamaCategory(String namaCategory){
		this.namaCategory = namaCategory;
	}

	public String getNamaCategory(){
		return namaCategory;
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

	@Override
 	public String toString(){
		return
			"CategoryItem{" +
					"id_category = '" + idCategory + '\'' +
					",nama_sub_category = '" + namaSubCategory + '\'' +
					",deskripsi = '" + deskripsi + '\'' +
					",nama_category = '" + namaCategory + '\'' +
					"}";
		}
}