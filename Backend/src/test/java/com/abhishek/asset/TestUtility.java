package com.abhishek.asset;


import com.abhishek.asset.entity.SupportTicketDTO;
import com.abhishek.asset.entity.TicketResolutionDTO;

public class TestUtility {
	
	
	public static SupportTicketDTO getSupportTicketDTO() {
		SupportTicketDTO supportTicketDTO=new SupportTicketDTO();
		supportTicketDTO.setAssetID(1234);
		supportTicketDTO.setTicketRaisedByEmployee("Abhishek");
		return supportTicketDTO;
	}
	public static TicketResolutionDTO getTicketResolutionDTO() {
		TicketResolutionDTO ticketResolutionDTO=new TicketResolutionDTO();
		ticketResolutionDTO.setResolutionDescription("i have changed the ram now it's work");
		return ticketResolutionDTO;
	}
	
}
