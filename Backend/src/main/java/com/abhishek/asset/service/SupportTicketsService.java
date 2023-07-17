package com.abhishek.asset.service;

import java.time.LocalDate;
import java.util.List;

import com.abhishek.asset.entity.SupportTicketDTO;
import com.abhishek.asset.entity.SupportTickets;
import com.abhishek.asset.exception.AssetNotRegisteredException;

public interface SupportTicketsService {

	public  int createSupportTicket(SupportTicketDTO supportTicketDTO) throws AssetNotRegisteredException;
	public String getAvailableSupportStaff();
	public LocalDate calculateExpectedResolution(String assetType);
	public List<SupportTickets> getAllTicketsForEmployee(String assignedToEmployee);
	public SupportTickets getSupportTicketByID(int ticketID);
	
}
