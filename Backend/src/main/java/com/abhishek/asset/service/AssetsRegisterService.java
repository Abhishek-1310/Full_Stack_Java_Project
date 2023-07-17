package com.abhishek.asset.service;

import com.abhishek.asset.entity.AssetsRegister;
import com.abhishek.asset.exception.MaximumDeviceLimitReachedException;

public interface AssetsRegisterService {
	
	public void registerAsset(AssetsRegister assetRegister) throws MaximumDeviceLimitReachedException;
}
