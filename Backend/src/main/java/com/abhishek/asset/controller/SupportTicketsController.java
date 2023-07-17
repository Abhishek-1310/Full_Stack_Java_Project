package com.abhishek.asset.controller;
import com.abhishek.asset.repository.SupportTicketsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.asset.entity.SupportTicketDTO;
import com.abhishek.asset.entity.SupportTickets;
import com.abhishek.asset.entity.TicketResolutionDTO;
import com.abhishek.asset.service.SupportTicketsService;
import com.abhishek.asset.service.TicketResolutionsService;

@RestController
@RequestMapping("/api/supportrequests")
@CrossOrigin(origins="http://localhost:4200")
public class SupportTicketsController {
	
	@Autowired
	private SupportTicketsService supportTicketsService;
	
	@Autowired
	private SupportTicketsRepository supportTicketsRepository;
	
	@Autowired
	private TicketResolutionsService ticketResolutionsService;
	
	@PostMapping("/new")
    public ResponseEntity<Object> createSupportTicket( @RequestBody SupportTicketDTO supportTicketDTO,  BindingResult result) {
        
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getAllErrors());
		}
		
        int ticketId=supportTicketsService.createSupportTicket(supportTicketDTO);
        return ResponseEntity.ok(ticketId);
    }
	
	@GetMapping("/open")
    public List<SupportTickets> getAllOpenTickets( ) {
        List<SupportTickets> tickets = supportTicketsRepository.findByTicketStatus("Open");
        
        return tickets;
        
    }

	@GetMapping("assignedToEmployee/{assignedToEmployee}")
    public List<SupportTickets> getAllTicketsForEmployee(@PathVariable("assignedToEmployee") String assignedToEmployee) {
        List<SupportTickets> tickets = supportTicketsRepository.findByAssignedToEmployeeAndTicketStatus(assignedToEmployee,"Open");
        return tickets;
        
    }
	
	
	@GetMapping("ticketId/{ticketId}")
    public SupportTickets getSupportTicketByID(@PathVariable("ticketId") int ticketId) {
		
		return this.supportTicketsRepository.findByTicketID(ticketId);
		

    }
	@PutMapping("/open/api/supportrequests/{ticketID}/resolve")
    public ResponseEntity<Object> putResolution(@PathVariable int ticketID, @RequestBody TicketResolutionDTO ticketResolutionDTO,BindingResult result) {
        
		if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        ticketResolutionsService.addResolution(ticketResolutionDTO);
        SupportTickets supportTickets=supportTicketsRepository.findByTicketID(ticketID);
        supportTickets.setTicketStatus("Resolved");
        supportTicketsRepository.save(supportTickets);
        return ResponseEntity.ok().build();
       
    }
}
