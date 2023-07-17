package com.abhishek.asset.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.asset.entity.TicketResolutionDTO;
import com.abhishek.asset.entity.TicketResolutions;
import com.abhishek.asset.repository.TicketResolutionsRepository;
import com.abhishek.asset.service.TicketResolutionsService;

@Service
public class TicketResolutionsServiceImpl implements TicketResolutionsService{

	@Autowired
	private TicketResolutionsRepository ticketResolutionsRepository;
	

	@Override
	public void addResolution(TicketResolutionDTO ticketResolutionDTO) {
		TicketResolutions ticketResolutions=new TicketResolutions();
		String description=ticketResolutionDTO.getResolutionDescription();
		ticketResolutions.setResolutionDate(LocalDate.now());
		ticketResolutions.setResolutionDescription(description);
		ticketResolutionsRepository.save(ticketResolutions);
	}


}
