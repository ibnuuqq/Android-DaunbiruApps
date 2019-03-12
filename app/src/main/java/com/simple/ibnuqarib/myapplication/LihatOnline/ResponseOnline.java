package com.simple.ibnuqarib.myapplication.LihatOnline;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseOnline{

	@SerializedName("online")
	private List<OnlineItem> online;

	@SerializedName("status")
	private boolean status;

	public void setOnline(List<OnlineItem> online){
		this.online = online;
	}

	public List<OnlineItem> getOnline(){
		return online;
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
			"ResponseOnline{" + 
			"online = '" + online + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}