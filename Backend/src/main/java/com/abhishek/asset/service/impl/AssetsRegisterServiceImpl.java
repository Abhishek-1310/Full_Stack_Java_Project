package com.abhishek.asset.service.impl;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.asset.entity.AssetsRegister;
import com.abhishek.asset.exception.InvalidAssetTypeException;
import com.abhishek.asset.exception.MaximumDeviceLimitReachedException;
import com.abhishek.asset.repository.AssetsRegisterRepository;
import com.abhishek.asset.service.AssetsRegisterService;

@Service
public class AssetsRegisterServiceImpl implements AssetsRegisterService{
	
	@Autowired
    private AssetsRegisterRepository assetsRegisterRepository;

	@Override
	public void registerAsset(AssetsRegister assetRegister) throws MaximumDeviceLimitReachedException {
		
		String assetType = assetRegister.getAssetType();
        String issuedToEmployee =assetRegister.getIssuedToEmployee();
        int count = assetsRegisterRepository.countByIssuedToEmployee(issuedToEmployee);
        if(count >= 5) {
            throw new MaximumDeviceLimitReachedException();
        }
        if(!isAssetTypeValid(assetType)) {
            throw new InvalidAssetTypeException();
        }
        
        assetsRegisterRepository.save(assetRegister);
		
	}
	private boolean isAssetTypeValid(String assetType) {
        return Arrays.asList("Laptop", "Mobile", "DataCard", "Headphone", "Storage").contains(assetType);
    }


	
	

}
