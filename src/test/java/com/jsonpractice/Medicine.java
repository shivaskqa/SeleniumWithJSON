package com.jsonpractice;

public class Medicine {
	
	private int drugId;
	private String drugName;
	private float drugPrice;
	private String availability;
	
	public Medicine(int drugId, String drugName, float drugPrice,String availability) {
	
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugPrice = drugPrice;
		this.availability=availability;
	}

	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public float getDrugPrice() {
		return drugPrice;
	}
	public void setDrugPrice(float drugPrice) {
		this.drugPrice = drugPrice;
	}

	@Override
	public String toString() {
		return "Medicine [drugId=" + drugId + ", drugName=" + drugName + ", drugPrice=" + drugPrice + ", availability="
				+ availability + "]";
	}

	

}
