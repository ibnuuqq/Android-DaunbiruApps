package com.simple.ibnuqarib.myapplication.ResponseCategory.SUB;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSub{

	@SerializedName("subcategory")
	private List<SubcategoryItem> subcategory;

	@SerializedName("status")
	private boolean status;

	public void setSubcategory(List<SubcategoryItem> subcategory){
		this.subcategory = subcategory;
	}

	public List<SubcategoryItem> getSubcategory(){
		return subcategory;
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
			"ResponseSub{" + 
			"subcategory = '" + subcategory + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}