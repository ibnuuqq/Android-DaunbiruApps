package com.simple.ibnuqarib.myapplication.ResponseProduk;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseProduk{

	@SerializedName("produk")
	private List<ProdukItem> produk;

	@SerializedName("status")
	private boolean status;

	public void setProduk(List<ProdukItem> produk){
		this.produk = produk;
	}

	public List<ProdukItem> getProduk(){
		return produk;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseProduk{" + 
			"produk = '" + produk + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}