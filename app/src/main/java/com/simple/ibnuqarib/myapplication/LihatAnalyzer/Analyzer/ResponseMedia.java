package com.simple.ibnuqarib.myapplication.LihatAnalyzer.Analyzer;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseMedia{

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("status")
	private boolean status;

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
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
			"ResponseMedia{" + 
			"media = '" + media + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}