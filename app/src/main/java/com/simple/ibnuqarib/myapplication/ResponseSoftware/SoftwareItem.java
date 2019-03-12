package com.simple.ibnuqarib.myapplication.ResponseSoftware;


import com.google.gson.annotations.SerializedName;


public class SoftwareItem{

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("nama_software")
	private String namaSoftware;

	@SerializedName("versi")
	private String versi;

	@SerializedName("link")
	private String link;

	@SerializedName("id_software")
	private String idSoftware;

	@SerializedName("waktu_update")
	private String waktuUpdate;

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setNamaSoftware(String namaSoftware){
		this.namaSoftware = namaSoftware;
	}

	public String getNamaSoftware(){
		return namaSoftware;
	}

	public void setVersi(String versi){
		this.versi = versi;
	}

	public String getVersi(){
		return versi;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setIdSoftware(String idSoftware){
		this.idSoftware = idSoftware;
	}

	public String getIdSoftware(){
		return idSoftware;
	}

	public void setWaktuUpdate(String waktuUpdate){
		this.waktuUpdate = waktuUpdate;
	}

	public String getWaktuUpdate(){
		return waktuUpdate;
	}

	@Override
 	public String toString(){
		return 
			"SoftwareItem{" + 
			"keterangan = '" + keterangan + '\'' +
			",nama_software = '" + namaSoftware + '\'' +
			",versi = '" + versi + '\'' +
			",id_software = '" + idSoftware + '\'' +
			",waktu_update = '" + waktuUpdate + '\'' +
					",link = '" + link + '\'' +
			"}";
		}
}