package com.simple.ibnuqarib.myapplication.ResponseNews;


import com.google.gson.annotations.SerializedName;

public class BeritaItem{

	@SerializedName("judul_artikel")
	private String judulArtikel;

	@SerializedName("tanggal_artikel")
	private String tanggalArtikel;

	@SerializedName("isi_artikel")
	private String isiArtikel;

	@SerializedName("penulis_artikel")
	private String penulisArtikel;

	@SerializedName("gambar_artikel")
	private String gambarArtikel;

	@SerializedName("id")
	private String id;

	public void setJudulArtikel(String judulArtikel){
		this.judulArtikel = judulArtikel;
	}

	public String getJudulArtikel(){
		return judulArtikel;
	}

	public void setTanggalArtikel(String tanggalArtikel){
		this.tanggalArtikel = tanggalArtikel;
	}

	public String getTanggalArtikel(){
		return tanggalArtikel;
	}

	public void setIsiArtikel(String isiArtikel){
		this.isiArtikel = isiArtikel;
	}

	public String getIsiArtikel(){
		return isiArtikel;
	}

	public void setPenulisArtikel(String penulisArtikel){
		this.penulisArtikel = penulisArtikel;
	}

	public String getPenulisArtikel(){
		return penulisArtikel;
	}

	public void setGambarArtikel(String gambarArtikel){
		this.gambarArtikel = gambarArtikel;
	}

	public String getGambarArtikel(){
		return gambarArtikel;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"BeritaItem{" + 
			"judul_artikel = '" + judulArtikel + '\'' + 
			",tanggal_artikel = '" + tanggalArtikel + '\'' + 
			",isi_artikel = '" + isiArtikel + '\'' + 
			",penulis_artikel = '" + penulisArtikel + '\'' + 
			",gambar_artikel = '" + gambarArtikel + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}