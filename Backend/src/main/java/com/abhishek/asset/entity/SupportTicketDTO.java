package com.abhishek.asset.entity;


public class SupportTicketDTO {
	

	
	private String ticketRaisedByEmployee;

	private int assetID;
	
	public String getTicketRaisedByEmployee() {
		return ticketRaisedByEmployee;
	}
	public void setTicketRaisedByEmployee(String ticketRaisedByEmployee) {
		this.ticketRaisedByEmployee = ticketRaisedByEmployee;
	}

	public int getAssetID() {
		return assetID;
	}
	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}
	
	@Override
	public String toString() {
		return "SupportTicketDTO [ticketRaisedByEmployee=" + ticketRaisedByEmployee + ", assetID=" + assetID + "]";
	}
	public SupportTicketDTO(String ticketRaisedByEmployee, int assetID) {
		super();
		this.ticketRaisedByEmployee = ticketRaisedByEmployee;
		this.assetID = assetID;
	}
	public SupportTicketDTO() {
		super();
	}
	
	
}
