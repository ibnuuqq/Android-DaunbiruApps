package com.simple.ibnuqarib.myapplication.ResponseModul;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseModul{

	@SerializedName("modul")
	private List<ModulItem> modul;

	@SerializedName("status")
	private boolean status;

	public void setModul(List<ModulItem> modul){
		this.modul = modul;
	}

	public List<ModulItem> getModul(){
		return modul;
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
			"ResponseModul{" + 
			"modul = '" + modul + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}