package com.abhishek.asset;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abhishek.asset.entity.SupportTickets;
import com.abhishek.asset.entity.TicketResolutions;
import com.abhishek.asset.repository.SupportTicketsRepository;
import com.abhishek.asset.repository.TicketResolutionsRepository;
import com.abhishek.asset.service.impl.TicketResolutionsServiceImpl;

public class TicketResolutionsServiceImplTest {

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@InjectMocks
	private TicketResolutionsServiceImpl ticketResolutionsServiceImpl;

	@Mock
	private TicketResolutionsRepository ticketResolutionsRepository;

	@Mock
	private SupportTicketsRepository supportTicketsRepository;
	
	@Mock
	TicketResolutions ticketResolutions;
	
	@Mock
	SupportTickets supportTickets;

	@Test
	public void testAddResolution() {
		
		
		when(supportTicketsRepository.findByTicketID(anyInt())).thenReturn(supportTickets);
		ticketResolutionsServiceImpl.addResolution(TestUtility.getTicketResolutionDTO());
		verify(ticketResolutionsRepository).save(any(TicketResolutions.class));
		

	}

}
