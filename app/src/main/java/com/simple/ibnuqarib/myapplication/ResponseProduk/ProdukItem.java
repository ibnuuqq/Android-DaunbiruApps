package com.simple.ibnuqarib.myapplication.ResponseProduk;

import com.google.gson.annotations.SerializedName;

public class ProdukItem{

	@SerializedName("nama_produk")
	private String namaProduk;

	@SerializedName("harga")
	private String harga;

	@SerializedName("spesifikasi")
	private String spesifikasi;

	@SerializedName("id")
	private String id;

	@SerializedName("gambar_produk")
	private String gambarProduk;

	public String id_category;

	public ProdukItem(String id){
		this.id = id;
	}

	public void setNamaProduk(String namaProduk){
		this.namaProduk = namaProduk;
	}

	public String getNamaProduk(){
		return namaProduk;
	}

	public void setHarga(String harga){
		this.harga = harga;
	}

	public String getHarga(){
		return harga;
	}

	public void setSpesifikasi(String spesifikasi){
		this.spesifikasi = spesifikasi;
	}

	public String getSpesifikasi(){
		return spesifikasi;
	}
	public String id_categ;
	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setGambarProduk(String gambarProduk){
		this.gambarProduk = gambarProduk;
	}

	public String getGambarProduk(){
		return gambarProduk;
	}

	@Override
 	public String toString(){
		return 
			"ProdukItem{" + 
			"nama_produk = '" + namaProduk + '\'' + 
			",harga = '" + harga + '\'' + 
			",spesifikasi = '" + spesifikasi + '\'' + 
			",id = '" + id + '\'' + 
			",gambar_produk = '" + gambarProduk + '\'' + 
			"}";
		}
}