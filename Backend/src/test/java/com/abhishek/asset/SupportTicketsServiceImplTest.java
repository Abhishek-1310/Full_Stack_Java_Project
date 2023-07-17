package com.abhishek.asset;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abhishek.asset.entity.AssetsRegister;
import com.abhishek.asset.entity.SupportTicketDTO;
import com.abhishek.asset.entity.SupportTickets;
import com.abhishek.asset.exception.AssetNotRegisteredException;
import com.abhishek.asset.repository.AssetsRegisterRepository;
import com.abhishek.asset.repository.SupportTicketsRepository;
import com.abhishek.asset.service.impl.SupportTicketsServiceImpl;

public class SupportTicketsServiceImplTest {
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
	
	@InjectMocks
	private SupportTicketsServiceImpl supportTicketsServiceImpl;
	
	@Mock
	private SupportTicketsRepository supportTicketsRepository;
	
	@Mock
	private AssetsRegisterRepository assetsRegisterRepository;
	
	@Mock
	private SupportTicketDTO supportTicketDTO;
	
	@Mock
	private SupportTickets supportTickets;
	
	@Test
    public void testCreateSupportTicketWithInvalidAsset() throws AssetNotRegisteredException {
        
        SupportTicketDTO supportTicketDTO = new SupportTicketDTO();
        when(assetsRegisterRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(AssetNotRegisteredException.class, () -> {
        	supportTicketsServiceImpl.createSupportTicket(supportTicketDTO);
        });
      
       
    }

    @Test
    public void testCreateSupportTicketWithValidAsset() throws AssetNotRegisteredException {
        
        AssetsRegister asset = new AssetsRegister(123,LocalDate.now(), "John Doe","1234","Dell","Laptop");
        
        when(assetsRegisterRepository.findById(anyInt())).thenReturn(Optional.of(asset));
        
        supportTicketsServiceImpl.createSupportTicket(TestUtility.getSupportTicketDTO());
        
        verify(supportTicketsRepository).save(any(SupportTickets.class));

        
       
    }

}
