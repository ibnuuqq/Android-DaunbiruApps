package com.simple.ibnuqarib.myapplication.LihatAnalyzer;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseAnalyzer{

	@SerializedName("analyzer")
	private List<AnalyzerItem> analyzer;

	@SerializedName("status")
	private boolean status;

	public void setAnalyzer(List<AnalyzerItem> analyzer){
		this.analyzer = analyzer;
	}

	public List<AnalyzerItem> getAnalyzer(){
		return analyzer;
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
			"ResponseAnalyzer{" + 
			"analyzer = '" + analyzer + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}