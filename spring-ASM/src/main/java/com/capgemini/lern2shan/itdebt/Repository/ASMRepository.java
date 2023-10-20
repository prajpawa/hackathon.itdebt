package com.capgemini.lern2shan.itdebt.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.lern2shan.itdebt.bean.Asset;

@Repository
public interface ASMRepository extends JpaRepository<Asset, String> {
	
	
	List<Asset> findAll();
	
	List<Asset> findByAssetNameIgnoreCase(String asset_name);

	long countByAssetNameIgnoreCase(String assetName);

	List<Asset> findByprovisionDate(Date provisionDate);

	long countByProvisionDate(Date provisionDate);
	
	List<Asset> findBypatchedDateBefore(LocalDate sixMonthsAgo);
	
	long countBypatchedDateBefore(LocalDate countSixMonthsAgo);
	
	List<Asset> findByprovisionDateBefore(LocalDate fiveYrsAgo);
	
	long countByprovisionDateBefore(LocalDate count5YrsAgo);
	
	List<Asset> findByAssetTypeIgnoreCase(String asset_type);

	long countByAssetType(String license);
}


