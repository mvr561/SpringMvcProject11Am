package com.app.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;


	public Integer saveShipmentType(ShipmentType shipmentType) {
		
		return  (Integer)ht.save(shipmentType);
	}


	public void updateShipmentType(ShipmentType shipmentType) {
		ht.update(shipmentType);
	}


	public void deleteShipmentType(Integer id) {
		ht.delete(new ShipmentType(id));

	}


	public ShipmentType getShipmentTypeById(Integer id) {

		return ht.get(ShipmentType.class,id);
	}


	public List<ShipmentType> getAllShipments() {

		return ht.loadAll(ShipmentType.class);
	}


	@Override
	public List<Object[]> getShipmentModeCount() {
		
		return (List<Object[]>) ht.find(" select shipmentMode,count(shipmentMode) from com.app.model.ShipmentType group by shipmentMode ");
	}

}
