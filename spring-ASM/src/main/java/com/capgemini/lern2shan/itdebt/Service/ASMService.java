package com.capgemini.lern2shan.itdebt.Service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.lern2shan.itdebt.Exception.ResourceNotFoundException;
import com.capgemini.lern2shan.itdebt.Repository.ASMRepository;
import com.capgemini.lern2shan.itdebt.bean.Asset;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ASMService {
	
	@Autowired
	public ASMRepository asmrepo;
	
	public List<Asset> getAllAssets() {
		List<Asset> asset_mang=new ArrayList<>();
		asmrepo.findAll().forEach(asset_mang::add);
		return asset_mang;
	}

	public long countAsset() {
		//int assetCount=0;
		return +asmrepo.count();
	}
	
	public class NotFoundException extends RuntimeException {
	    public NotFoundException(String asset_name) {
	        super(asset_name);
	    }
	}

	public ResponseEntity< List<Asset>> findAssetsByType(String asset_name) 
	{
		List<Asset> assets= asmrepo.findByAssetNameIgnoreCase(asset_name);
		
		 if (assets.isEmpty()) {
	            
	            throw new ResourceNotFoundException("ASSET NOT FOUND: " +asset_name);
	        }
		 else {
			 return new ResponseEntity< List<Asset>> (assets,HttpStatus.OK);
		 }
		 
		
	}

	public long countAssetsByName(String assetName) 
	{
		return asmrepo.countByAssetNameIgnoreCase(assetName);
		  
	}

	public List<Asset> findByProvisionDate(Date provisionDate)
	{
		return asmrepo.findByprovisionDate(provisionDate);
	}

	
	public long countByProvisionDate(Date provisionDate) {
		
		return asmrepo.countByProvisionDate(provisionDate);
	}
	


}
