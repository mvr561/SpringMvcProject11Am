package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="item_tab")
public class Item {

	@Id
	@GeneratedValue(generator="pkgen")
	@GenericGenerator(name="pkgen",strategy="increment")
	@Column(name="itemId")
	private Integer  itemId;
	@Column(name="icode")
	private String itemCode;
	@Column(name="ilength")
	private Double itemLength;
	@Column(name="iwidth")
	private Double itemWidth;
	@Column(name="iheight")
	private Double itemHeight;
	@Column(name="icost")
	private Double baseCost;
	@Column(name="basecurrency")
	private String baseCurrency;
	@Column(name="dsc")
	private String itemDsc;
	public Item() {
		super();
	}
	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Double getItemLength() {
		return itemLength;
	}
	public void setItemLength(Double itemLength) {
		this.itemLength = itemLength;
	}
	public Double getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(Double itemWidth) {
		this.itemWidth = itemWidth;
	}
	public Double getItemHeight() {
		return itemHeight;
	}
	public void setItemHeight(Double itemHeight) {
		this.itemHeight = itemHeight;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getItemDsc() {
		return itemDsc;
	}
	public void setItemDsc(String itemDsc) {
		this.itemDsc = itemDsc;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemLength=" + itemLength + ", itemWidth="
				+ itemWidth + ", itemHeight=" + itemHeight + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency
				+ ", itemDsc=" + itemDsc + "]";
	}
	
	
	
	
}
