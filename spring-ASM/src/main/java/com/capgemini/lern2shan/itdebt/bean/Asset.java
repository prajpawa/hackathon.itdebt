package com.capgemini.lern2shan.itdebt.bean;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="asset")
public class Asset {
	@Id
	private String asset_id;
	
	@Column(name="asset_name")
	private String assetName;
	
	@DateTimeFormat(iso=ISO.DATE)
    @Column(name = "provision_date")
	private Date provisionDate;
	
	@Column(name = "patched_date")
	private LocalDate patchedDate;
	
	
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}
	public String getassetName() {
		return assetName;
	}
	public void setassetName(String assetName) {
		this.assetName = assetName;
	}
	public Date getProvisionDate() {
		return provisionDate;
	}
	public void setProvisionDate(Date provisionDate) {
		this.provisionDate = provisionDate;
	}
	public LocalDate getPatchedDate() {
		return patchedDate;
	}
	public void setPatchedDate(LocalDate patchedDate) {
		this.patchedDate = patchedDate;
	}
	
	public Asset()
	{
		
	}
	
	public Asset(String asset_id, String assetName, Date provisionDate) {
		super();
		this.asset_id = asset_id;
		this.assetName = assetName;
		this.provisionDate = provisionDate;
		
	}
	@Override
	public String toString() {
		return "AssetManagment [asset_id=" + asset_id + ", assetName=" + assetName + ","
				+ " provisionDate=" + provisionDate +"]";

	}
	
}
