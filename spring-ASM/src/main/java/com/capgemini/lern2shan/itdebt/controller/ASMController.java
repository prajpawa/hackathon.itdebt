package com.capgemini.lern2shan.itdebt.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.lern2shan.itdebt.Service.ASMService;
import com.capgemini.lern2shan.itdebt.bean.Asset;
import com.capgemini.lern2shan.itdebt.bean.AssetDetailsDTO;
import com.fasterxml.jackson.annotation.JsonView;


@RestController
@RequestMapping("/asset")
public class ASMController {
	
	@Autowired
	private ASMService asmService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/details")
	public List<Asset> getAllAssets()
	{
		return asmService.getAllAssets();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/count")
	public String count() {
		
		return "TOTAL ASSET COUNT: " + asmService.countAsset();
		
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	   
	// @GetMapping("/asset-count")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/assetName/count")
	    public String countAssetsByName(@RequestParam(name="assetName") String assetName) {
		 long countasset=asmService.countAssetsByName(assetName);
	        return "Total Count Of " +assetName + " is : " +countasset;
	    }
	 
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/find-by-date")
	 public List<Asset> findAssetsByDate(@RequestParam(name="provision_Date") Date provision_Date)
	 {
		 return asmService.findByProvisionDate(provision_Date);
	 }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/count-by-date")
	 public String countAssetsByDate(@RequestParam Date provision_Date)
	 {
		long dateCount= asmService.countByProvisionDate(provision_Date);
		 return "COUNT OF ASSET ACCORDING TO PROVISIONAL DATE: " + dateCount;
	 }
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/last-patch-date")
	public List<Asset> findAssetPatchDateSixMonthsAgo()
	{
		return asmService.findAssetPatchDateSixMonthsAgo();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/count-by-patch-date")
	public String countAssetPatchDateSixMonthsAgo()
	{
		long patchDateCount= asmService.countByPatchDateSixMonthsAgo();
		return "COUNT OF ASSET WHOSE PATCHED DATE IS GREATER THAN 6 MONTHS AGO:  " + patchDateCount;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/last5Years-provision-date")
	public List<Asset> findAssetByProvisionDate()
	{
		return asmService.findAssetProvisionDate5YrsAgo();
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/count-last5Years-provision-date")
	public String CountAssetByProvisionDate()
	{
		long count5YrsProvisionDate =asmService.countByProvisionDate5YrsAgo();
		return "COUNT OF ASSET WHOSE PROVISION DATE IS OF 5 YEARS BACK:  " + count5YrsProvisionDate;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	 @GetMapping("/license")
	    public ResponseEntity<List<AssetDetailsDTO>> findAssetsByLicenseType() {
		 ResponseEntity<List<Asset>> licenseAssets = asmService.findAssetsByAssetType("license");
		 
		 List<AssetDetailsDTO> dtos = new ArrayList<>();
		 
		 for (Asset asst : licenseAssets.getBody())
		 {
			 AssetDetailsDTO dto = new AssetDetailsDTO();
			 dto.setAsset_id(asst.getAsset_id());
			 dto.setAssetName(asst.getassetName());
			 dto.setProvisionDate(asst.getProvisionDate());
		 	 dto.setPatchedDate(asst.getPatchedDate());
		 	 dto.setCategory(asst.getCategory());
		 	 dtos.add(dto);
		 }
		return ResponseEntity.ok(dtos);
	 }
	 
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	 @GetMapping("/license/count")
	    public String countByLicenseType() {
		 long countlicenseasset=asmService.countLicenseAssetType("license");
	        return "Total Count Of License Asset Type is : " +countlicenseasset;
	    }
	
}


