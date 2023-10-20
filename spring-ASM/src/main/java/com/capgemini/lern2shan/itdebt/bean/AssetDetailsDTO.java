package com.capgemini.lern2shan.itdebt.bean;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="asset")
public class AssetDetailsDTO {

	@Id
	private String asset_id;
	
	@Column(name="asset_name")
	private String assetName;
	
	@DateTimeFormat(iso=ISO.DATE)
    @Column(name = "provision_date")
	private Date provisionDate;
	
	@Column(name = "patched_date")
	private LocalDate patchedDate;
	
	@Column(name="category")
	private String category;

	public String getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
