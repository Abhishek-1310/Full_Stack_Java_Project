package com.abhishek.asset.entity;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name="assets_register")
public class AssetsRegister {

	@Id
	@Column(name="asset_id", columnDefinition="INTEGER(10)")
	private int assetID;
	
	@PastOrPresent(message = "The date should not be in future")
	@Column(name="issued_on", columnDefinition="DATE", nullable= false)
	private LocalDate issuedOn;
	@Column(name="issued_to_employee", columnDefinition="VARCHAR(6)")
	private String issuedToEmployee;
	@Column(name="model_no", columnDefinition="VARCHAR(25)")
	private String modelNo;
	@Column(name="make", columnDefinition="VARCHAR(25)")
	private String make;
	@Column(name="asset_type", columnDefinition="VARCHAR(10)")
	private String assetType;
	
	@OneToMany(mappedBy ="assetsRegister", cascade=CascadeType.ALL)
	private List<SupportTickets> supportTickets=new ArrayList<>();

	public int getAssetID() {
		return assetID;
	}

	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}

	public LocalDate getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(LocalDate issuedOn) {
		this.issuedOn = issuedOn;
	}

	public String getIssuedToEmployee() {
		return issuedToEmployee;
	}

	public void setIssuedToEmployee(String issuedToEmployee) {
		this.issuedToEmployee = issuedToEmployee;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public List<SupportTickets> getSupportTickets() {
		return supportTickets;
	}

	public void setSupportTickets(List<SupportTickets> supportTickets) {
		this.supportTickets = supportTickets;
	}

	public AssetsRegister(int assetID, LocalDate issuedOn, String issuedToEmployee, String modelNo, String make,
			String assetType) {
		super();
		this.assetID = assetID;
		this.issuedOn = issuedOn;
		this.issuedToEmployee = issuedToEmployee;
		this.modelNo = modelNo;
		this.make = make;
		this.assetType = assetType;
	}
	
	public AssetsRegister() {
		super();
	}

	@Override
	public String toString() {
		return "AssetsRegister [assetID=" + assetID + ", issuedOn=" + issuedOn + ", issuedToEmployee="
				+ issuedToEmployee + ", modelNo=" + modelNo + ", make=" + make + ", assetType=" + assetType
				+ ", supportTickets=" + supportTickets + "]";
	}
	
	

	
	
	
	
	
	
	
	
}
