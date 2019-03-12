package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseSpek{

	@SerializedName("spek")
	private List<SpekItem> spek;

	@SerializedName("status")
	private boolean status;

	public void setSpek(List<SpekItem> spek){
		this.spek = spek;
	}

	public List<SpekItem> getSpek(){
		return spek;
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
			"ResponseSpek{" + 
			"spek = '" + spek + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}