package com.abhishek.asset.entity;


import java.time.LocalDate;
//import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="ticket_resolutions")
public class TicketResolutions {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", columnDefinition="INTEGER(10)")
	private int iD;
	
	@CreatedDate
	@Column(name="resolution_date", columnDefinition="DATE", nullable= false)
	private LocalDate resolutionDate;
	
	@Column(name="resolution_description", columnDefinition="VARCHAR(100)")
	private String resolutionDescription;
	
	@ManyToOne
	@JoinColumn(name="ticket_id", columnDefinition = "INTEGER(10)")
	private SupportTickets supportTickets;

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public LocalDate getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(LocalDate resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	public String getResolutionDescription() {
		return resolutionDescription;
	}

	public void setResolutionDescription(String resolutionDescription) {
		this.resolutionDescription = resolutionDescription;
	}

	public SupportTickets getSupportTickets() {
		return supportTickets;
	}

	public void setSupportTickets(SupportTickets supportTickets) {
		this.supportTickets = supportTickets;
	}

	@Override
	public String toString() {
		return "TicketResolutions [iD=" + iD + ", resolutionDate=" + resolutionDate + ", resolutionDescription="
				+ resolutionDescription + ", supportTickets=" + supportTickets + "]";
	}
	
	
	public TicketResolutions(int iD, LocalDate resolutionDate, String resolutionDescription) {
		super();
		this.iD = iD;
		this.resolutionDate = resolutionDate;
		this.resolutionDescription = resolutionDescription;
	}

	public TicketResolutions() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
