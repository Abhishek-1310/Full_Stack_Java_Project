package com.abhishek.asset.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.asset.entity.AssetsRegister;
import com.abhishek.asset.entity.SupportTicketDTO;
import com.abhishek.asset.entity.SupportTickets;
import com.abhishek.asset.exception.AssetNotRegisteredException;
import com.abhishek.asset.repository.AssetsRegisterRepository;
import com.abhishek.asset.repository.SupportTicketsRepository;
import com.abhishek.asset.service.SupportTicketsService;

@Service
public class SupportTicketsServiceImpl implements SupportTicketsService{

	@Autowired
	private SupportTicketsRepository supportTicketsRepository;
	
	@Autowired
    private AssetsRegisterRepository assetsRegisterRepository;

	@Override
	public int createSupportTicket(SupportTicketDTO supportTicketDTO) throws AssetNotRegisteredException {
		
		
		
		
		SupportTickets supportTickets=new SupportTickets();
		
		int assetId=supportTicketDTO.getAssetID();

		Optional<AssetsRegister> assetsRegister=assetsRegisterRepository.findById(assetId);
		if (assetsRegister.isEmpty()) {
            throw new AssetNotRegisteredException();
        }
		
		int uid=UUID.randomUUID().hashCode();
		if(uid<0) {
			uid=-uid;
		}
		supportTickets.setTicketID(uid);
		
		int assetID=supportTicketDTO.getAssetID();
		AssetsRegister asset=assetsRegister.get();
		asset.setAssetID(assetID);
		
		String employee=supportTicketDTO.getTicketRaisedByEmployee();
		supportTickets.setTicketRaisedByEmployee(employee);
		
		supportTickets.setTicketRaisedOn(LocalDate.now());
		
		
		String assignedToStaff=getAvailableSupportStaff();
		supportTickets.setAssignedToEmployee(assignedToStaff);
		
		String assetType=assetsRegisterRepository.findById(assetId).get().getAssetType();
		supportTickets.setExpectedResolution(calculateExpectedResolution(assetType));
		
		supportTickets.setTicketStatus("Open");
		
		supportTicketsRepository.save(supportTickets);
		return supportTickets.getTicketID();
		
	}
	public String getAvailableSupportStaff() {
		List<SupportTickets> staffList=supportTicketsRepository.findAll();
		for(SupportTickets st:staffList) {
			int count=supportTicketsRepository.countByAssignedToEmployeeAndTicketStatus(st.getAssignedToEmployee(), "Open");
			if(count<10) {
				return st.getAssignedToEmployee();
			}
		}
		return "Raj";
	}
	@Override
	public LocalDate calculateExpectedResolution(String assetType) {
		 switch (assetType) {
         case "Laptop":
             return LocalDate.now().plusDays(2);
         case "Mobile":
             return LocalDate.now().plusDays(5);
         case "DataCard":
         case "HeadPhone":
         case "Storage":
             return LocalDate.now().plusDays(3);
         default:
        	 return LocalDate.now();
     }
		
	}
	@Override
	public List<SupportTickets> getAllTicketsForEmployee(String employee) {
		
		
		 return supportTicketsRepository.findByAssignedToEmployeeAndTicketStatus(employee,"Open");
		
	}
	@Override
	public SupportTickets getSupportTicketByID(int ticketID) {
		return supportTicketsRepository.findByTicketID(ticketID);
	}
	
	
	
	


}
