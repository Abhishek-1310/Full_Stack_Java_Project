package com.abhishek.asset;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abhishek.asset.entity.AssetsRegister;
import com.abhishek.asset.exception.InvalidAssetTypeException;
import com.abhishek.asset.exception.MaximumDeviceLimitReachedException;
import com.abhishek.asset.repository.AssetsRegisterRepository;
import com.abhishek.asset.service.impl.AssetsRegisterServiceImpl;

public class AssetsRegisterServiceImplTest {
	
	@Mock
    private AssetsRegisterRepository assetsRegisterRepository;
	
	@InjectMocks
    private AssetsRegisterServiceImpl assetsRegisterServiceImpl;
	

	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testRegisterAsset_validAssetTypeAndBelowMaximumDeviceLimit_shouldSaveAsset() throws Exception {
        AssetsRegister assetRegister = new AssetsRegister(123,LocalDate.now(), "John Doe","1234","Dell","Laptop");
    	

        when(assetsRegisterRepository.countByIssuedToEmployee(anyString())).thenReturn(4);
        

        assetsRegisterServiceImpl.registerAsset(assetRegister);

        verify(assetsRegisterRepository).save(assetRegister);
    }

    @Test
    public void testRegisterAsset_aboveMaximumDeviceLimit_shouldThrowMaximumDeviceLimitReachedException() {
        AssetsRegister assetRegister = new AssetsRegister(123,LocalDate.now(), "John Doe","1234","Dell","Laptop");
        when(assetsRegisterRepository.countByIssuedToEmployee(anyString())).thenReturn(6);

        assertThrows(MaximumDeviceLimitReachedException.class, () -> {
        	assetsRegisterServiceImpl.registerAsset(assetRegister);
        });
    }

    @Test
    public void testRegisterAsset_invalidAssetType_shouldThrowInvalidAssetTypeException() {
        AssetsRegister assetRegister = new AssetsRegister(123,LocalDate.now(), "John Doe","1234","Dell","tablet");
        
        assertThrows(InvalidAssetTypeException.class, () -> {
        	assetsRegisterServiceImpl.registerAsset(assetRegister);
        });
    }
    

}
