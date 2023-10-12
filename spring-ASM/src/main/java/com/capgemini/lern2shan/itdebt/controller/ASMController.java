package com.capgemini.lern2shan.itdebt.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.lern2shan.itdebt.Service.ASMService;
import com.capgemini.lern2shan.itdebt.bean.Asset;


@RestController
@RequestMapping("/asset")
public class ASMController {
	
	@Autowired
	private ASMService asmService;
	
	@GetMapping("/details")
	public List<Asset> getAllAssets()
	{
		return asmService.getAllAssets();
	}
	
	@GetMapping("/count")
	public String count() {
		
		return "TOTAL ASSET COUNT: " + asmService.countAsset();
		
	}
	
	@GetMapping("/{assetName}/details")
    public ResponseEntity<ResponseEntity<List<Asset>>> searchAssetsByType(@PathVariable("assetName") String asset_name) {
		ResponseEntity<List<Asset>> asset1 =  asmService.findAssetsByType(asset_name);
		if(asset1!=null)
		{
			return ResponseEntity.ok(asset1);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
		//return (ResponseEntity<List<Asset>>) asset1;
       
    }
	   
	 @GetMapping("/assetName/count")
	    public String countAssetsByName(@RequestParam String assetName) {
		 long countasset=asmService.countAssetsByName(assetName);
	        return "Total Count Of " +assetName + " is : " +countasset;
	    }
	 
	@GetMapping("/find-by-date")
	 public List<Asset> findAssetsByDate(@RequestParam(name="provision_Date") Date provision_Date)
	 {
		 return asmService.findByProvisionDate(provision_Date);
	 }
	
	@GetMapping("/count-by-date")
	 public String countAssetsByDate(@RequestParam Date provision_Date)
	 {
		long dateCount= asmService.countByProvisionDate(provision_Date);
		 return "COUNT OF ASSET ACCORDING TO PROVISIONAL DATE: " + dateCount;
	 }
}


