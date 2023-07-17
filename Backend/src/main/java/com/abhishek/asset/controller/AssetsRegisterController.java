package com.abhishek.asset.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.asset.entity.AssetsRegister;
import com.abhishek.asset.service.AssetsRegisterService;

@RestController
@RequestMapping("/api/asset/")
@CrossOrigin(origins="http://localhost:4200")
public class AssetsRegisterController {
	
	@Autowired
	private AssetsRegisterService assetsRegisterService;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerAsset(@RequestBody AssetsRegister assetsRegister, BindingResult result) {
        if (result.hasErrors()) {
        	return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        
        assetsRegisterService.registerAsset(assetsRegister);
        return ResponseEntity.ok().build();
    }
}
