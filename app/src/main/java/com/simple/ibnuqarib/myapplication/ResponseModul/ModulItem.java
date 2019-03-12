package com.simple.ibnuqarib.myapplication.ResponseModul;


import com.google.gson.annotations.SerializedName;

public class ModulItem{

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("versi")
	private String versi;

	@SerializedName("link")
	private String link;

	@SerializedName("id_sub_category")
	private String idSubCategory;

	@SerializedName("nama_dokumen")
	private String namaDokumen;

	@SerializedName("id")
	private String id;

	@SerializedName("waktu_update")
	private String waktuUpdate;

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setVersi(String versi){
		this.versi = versi;
	}

	public String getVersi(){
		return versi;
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

	public void setNamaDokumen(String namaDokumen){
		this.namaDokumen = namaDokumen;
	}

	public String getNamaDokumen(){
		return namaDokumen;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setWaktuUpdate(String waktuUpdate){
		this.waktuUpdate = waktuUpdate;
	}

	public String getWaktuUpdate(){
		return waktuUpdate;
	}

	@Override
	public String toString(){
		return
				"ModulItem{" +
						"keterangan = '" + keterangan + '\'' +
						",versi = '" + versi + '\'' +
						",link = '" + link + '\'' +
						",id_sub_category = '" + idSubCategory + '\'' +
						",nama_dokumen = '" + namaDokumen + '\'' +
						",id = '" + id + '\'' +
						",waktu_update = '" + waktuUpdate + '\'' +
						"}";
	}
}