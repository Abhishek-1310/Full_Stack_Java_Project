package com.abhishek.asset.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="support_tickets")
public class SupportTickets {
	
	@Id
	@Column(name="ticket_id", columnDefinition="INTEGER(10)")
	private int ticketID;
	@Column(name="ticket_raised_on", columnDefinition="DATE", nullable= false)
	private LocalDate ticketRaisedOn;
	@Column(name="ticket_raised_by_employee", columnDefinition="VARCHAR(6)")
	private String ticketRaisedByEmployee;
	
	
	@Column(name="assigned_to_employee", columnDefinition="VARCHAR(6)")
	private String assignedToEmployee;
	@Column(name="expected_resolution", columnDefinition="DATE", nullable= false)
	private LocalDate expectedResolution;
	
	
	@Column(name="ticket_status", columnDefinition="ENUM('Open', 'Resolved')" )
	private String ticketStatus;
	
	
	
	public SupportTickets(int ticketID, LocalDate ticketRaisedOn, String ticketRaisedByEmployee,
			String assignedToEmployee, LocalDate expectedResolution, String ticketStatus) {
		super();
		this.ticketID = ticketID;
		this.ticketRaisedOn = ticketRaisedOn;
		this.ticketRaisedByEmployee = ticketRaisedByEmployee;
		this.assignedToEmployee = assignedToEmployee;
		this.expectedResolution = expectedResolution;
		this.ticketStatus = ticketStatus;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "supportTickets", cascade = CascadeType.ALL)
	private List<TicketResolutions> ticketResolutions= new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="asset_id", columnDefinition="INTEGER(10)")
	private AssetsRegister assetsRegister;
	
	

	public SupportTickets() {
		super();
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public LocalDate getTicketRaisedOn() {
		return ticketRaisedOn;
	}

	public void setTicketRaisedOn(LocalDate ticketRaisedOn) {
		this.ticketRaisedOn = ticketRaisedOn;
	}

	public String getTicketRaisedByEmployee() {
		return ticketRaisedByEmployee;
	}

	public void setTicketRaisedByEmployee(String ticketRaisedByEmployee) {
		this.ticketRaisedByEmployee = ticketRaisedByEmployee;
	}

	public String getAssignedToEmployee() {
		return assignedToEmployee;
	}

	public void setAssignedToEmployee(String assignedToEmployee) {
		this.assignedToEmployee = assignedToEmployee;
	}

	public LocalDate getExpectedResolution() {
		return expectedResolution;
	}

	public void setExpectedResolution(LocalDate expectedResolution) {
		this.expectedResolution = expectedResolution;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public List<TicketResolutions> getTicketResolutions() {
		return ticketResolutions;
	}

	public void setTicketResolutions(List<TicketResolutions> ticketResolutions) {
		this.ticketResolutions = ticketResolutions;
	}

	public AssetsRegister getAssetsRegister() {
		return assetsRegister;
	}

	public void setAssetsRegister(AssetsRegister assetsRegister) {
		this.assetsRegister = assetsRegister;
	}

	@Override
	public String toString() {
		return "SupportTickets [ticketID=" + ticketID + ", ticketRaisedOn=" + ticketRaisedOn
				+ ", ticketRaisedByEmployee=" + ticketRaisedByEmployee + ", assignedToEmployee=" + assignedToEmployee
				+ ", expectedResolution=" + expectedResolution + ", ticketStatus=" + ticketStatus
				+ ", ticketResolutions=" + ticketResolutions + ", assetsRegister=" + assetsRegister + "]";
	}
	


	
	
	
	
	
	
	
	
}
