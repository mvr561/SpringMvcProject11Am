package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchase_tab")
public class Purchase {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(generator="purchase")
	@GenericGenerator(name="purchase",strategy="increment")
	private Integer orderId;
	@Column(name="order_code")
	private String orderCode;
	@Column(name="shipment_mode")
	private String shipmentMode;
	@Column(name="vendor")
	private String vendor;
	@Column(name="ref_num")
	private String refNumber;
	@Column(name="qua_check")
	private String quaCheck;
	@Column(name="order_status")
	private String orderStatus;
	@Column(name="order_desc")
	private String orderDesc;
	public Purchase() {
		super();
	}
	public Purchase(Integer orderId) {
		super();
		this.orderId = orderId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getQuaCheck() {
		return quaCheck;
	}
	public void setQuaCheck(String quaCheck) {
		this.quaCheck = quaCheck;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	@Override
	public String toString() {
		return "Purchase [orderId=" + orderId + ", orderCode=" + orderCode + ", shipmentMode=" + shipmentMode
				+ ", vendor=" + vendor + ", refNumber=" + refNumber + ", quaCheck=" + quaCheck + ", orderStatus="
				+ orderStatus + ", orderDesc=" + orderDesc + "]";
	}

	
}
