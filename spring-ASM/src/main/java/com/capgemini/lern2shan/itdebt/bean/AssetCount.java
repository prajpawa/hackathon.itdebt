package com.capgemini.lern2shan.itdebt.bean;

public class AssetCount {
	
	private int assetCount;

	public int getAssetCount() {
		return assetCount;
	}

	public void setAssetCount(int assetCount) {
		this.assetCount = assetCount;
	}

	public AssetCount() {
	
	}

	public AssetCount(int assetCount) {
		super();
		this.assetCount = assetCount;
	}

	@Override
	public String toString() {
		return "AssetCount [assetCount=" + assetCount + "]";
	}
	
	

}
