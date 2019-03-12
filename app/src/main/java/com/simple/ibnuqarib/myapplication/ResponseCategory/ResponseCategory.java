package com.simple.ibnuqarib.myapplication.ResponseCategory;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseCategory {

	@SerializedName("category")
	private List<CategoryItem> category;

	@SerializedName("status")
	private boolean status;

	public void setCategory(List<CategoryItem> category){
		this.category = category;
	}

	public List<CategoryItem> getCategory(){
		return category;
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
			"ResponseCategory{" + 
			"category = '" + category + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}