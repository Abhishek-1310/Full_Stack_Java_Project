package com.abhishek.asset.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abhishek.asset.entity.SupportTickets;


public interface SupportTicketsRepository extends JpaRepository<SupportTickets, Integer> {
	
	List<SupportTickets> findByAssignedToEmployeeAndTicketStatus(String assignedToEmployee,String ticketStatus);
    SupportTickets findByTicketID(Integer ticketID);
    int countByAssignedToEmployeeAndTicketStatus(String AssignedToEmployee,String ticketStatus);
    List<SupportTickets> findByTicketStatus(String ticketStatus);
    
}
