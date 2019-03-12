package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;


import com.google.gson.annotations.SerializedName;


public class SpekItem{

	@SerializedName("num")
	private String num;

	@SerializedName("id_sub_category")
	private String idSubCategory;

	@SerializedName("value_spek")
	private String valueSpek;

	@SerializedName("idSpek2")
	private String idSpek2;

	@SerializedName("nama_spek")
	private String namaSpek;

	public void setNum(String num){
		this.num = num;
	}

	public String getNum(){
		return num;
	}

	public void setIdSubCategory(String idSubCategory){
		this.idSubCategory = idSubCategory;
	}

	public String getIdSubCategory(){
		return idSubCategory;
	}

	public void setValueSpek(String valueSpek){
		this.valueSpek = valueSpek;
	}

	public String getValueSpek(){
		return valueSpek;
	}

	public void setIdSpek2(String idSpek2){
		this.idSpek2 = idSpek2;
	}

	public String getIdSpek2(){
		return idSpek2;
	}

	public void setNamaSpek(String namaSpek){
		this.namaSpek = namaSpek;
	}

	public String getNamaSpek(){
		return namaSpek;
	}

	@Override
 	public String toString(){
		return 
			"SpekItem{" + 
			"num = '" + num + '\'' + 
			",id_sub_category = '" + idSubCategory + '\'' + 
			",value_spek = '" + valueSpek + '\'' + 
			",idSpek2 = '" + idSpek2 + '\'' + 
			",nama_spek = '" + namaSpek + '\'' + 
			"}";
		}
}