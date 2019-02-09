package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {

	@Id 
	@GeneratedValue(generator="pkgen")
	@GenericGenerator(name="pkgen",strategy="increment")
	@Column(name="sid")
	private Integer id;

	private String shipmentMode;
	@Column(name="scode")
	private String shipmentCode;
	@Column(name="senbleship")
	private String enableshipment;
	@Column(name="sgrd")
	private String shipmentGrade;
	@Column(name="sdsc")
	private String shipmentDesc;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public String getEnableshipment() {
		return enableshipment;
	}
	public void setEnableshipment(String enableshipment) {
		this.enableshipment = enableshipment;
	}
	public String getShipmentGrade() {
		return shipmentGrade;
	}
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}
	public String getShipmentDesc() {
		return shipmentDesc;
	}
	public void setShipmentDesc(String shipmentDesc) {
		this.shipmentDesc = shipmentDesc;
	}
	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
				+ ", enableshipment=" + enableshipment + ", shipmentGrade=" + shipmentGrade + ", shipmentDesc="
				+ shipmentDesc + "]";
	}





}
