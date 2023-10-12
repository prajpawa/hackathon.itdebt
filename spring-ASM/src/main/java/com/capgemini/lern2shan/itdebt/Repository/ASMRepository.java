package com.capgemini.lern2shan.itdebt.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.lern2shan.itdebt.bean.Asset;

public interface ASMRepository extends JpaRepository<Asset, String> {
	
	List<Asset> findAll();
	
	List<Asset> findByAssetNameIgnoreCase(String asset_name);

	long countByAssetNameIgnoreCase(String assetName);

	List<Asset> findByprovisionDate(Date provisionDate);

	long countByProvisionDate(Date provisionDate);

}


