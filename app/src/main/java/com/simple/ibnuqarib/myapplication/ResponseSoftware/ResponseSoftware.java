package com.simple.ibnuqarib.myapplication.ResponseSoftware;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseSoftware{

	@SerializedName("software")
	private List<SoftwareItem> software;

	@SerializedName("status")
	private boolean status;

	public void setSoftware(List<SoftwareItem> software){
		this.software = software;
	}

	public List<SoftwareItem> getSoftware(){
		return software;
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
			"ResponseSoftware{" + 
			"software = '" + software + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}