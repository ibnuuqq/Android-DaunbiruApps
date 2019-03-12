package com.simple.ibnuqarib.myapplication.LihatOnline;


import com.google.gson.annotations.SerializedName;

public class OnlineItem{

	@SerializedName("id_category")
	private String idCategory;

	@SerializedName("link")
	private String link;

	@SerializedName("id_sub_category")
	private String idSubCategory;

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

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

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

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	@Override
 	public String toString(){
		return 
			"OnlineItem{" + 
			"id_category = '" + idCategory + '\'' + 
			",link = '" + link + '\'' + 
			",id_sub_category = '" + idSubCategory + '\'' + 
			",nama_sub_category = '" + namaSubCategory + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			"}";
		}
}