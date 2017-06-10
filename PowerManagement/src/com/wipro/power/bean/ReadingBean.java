package com.wipro.power.bean;

public class ReadingBean {
	private int serialNo;
	private String type;
	private String AssetId;
	public String getAssetId() {
		return AssetId;
	}
	public void setAssetId(String assetId) {
		AssetId = assetId;
	}
	private int presentReading;
	private int pastReading;
	private String billMonth;
	private String billYear;
	private int unitsUsed;
	private float amount;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPresentReading() {
		return presentReading;
	}
	public void setPresentReading(int presentReading) {
		this.presentReading = presentReading;
	}
	public int getPastReading() {
		return pastReading;
	}
	public void setPastReading(int pastReading) {
		this.pastReading = pastReading;
	}
	public String getBillMonth() {
		return billMonth;
	}
	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}
	public String getBillYear() {
		return billYear;
	}
	public void setBillYear(String billYear) {
		this.billYear = billYear;
	}
	public int getUnitsUsed() {
		return unitsUsed;
	}
	public void setUnitsUsed(int unitsUsed) {
		this.unitsUsed = unitsUsed;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
