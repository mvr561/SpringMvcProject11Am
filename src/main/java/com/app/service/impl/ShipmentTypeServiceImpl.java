package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
	@Autowired
	private IShipmentTypeDao dao;

    @Transactional
	public Integer saveShipmentType(ShipmentType shipmentType) {

		return dao.saveShipmentType(shipmentType);
	}

    @Transactional
	public void updateShipmentType(ShipmentType shipmentType) {

		dao.updateShipmentType(shipmentType);

	}

    @Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}
    @Transactional(readOnly=true)
	public ShipmentType getShipmentTypeById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getShipmentTypeById(id);
	}

    @Transactional(readOnly=true)
	public List<ShipmentType> getAllShipments() {
		// TODO Auto-generated method stub
		return dao.getAllShipments();
	}

    @Transactional(readOnly=true)
	public List<Object[]> getShipmentModeCount() {
		// TODO Auto-generated method stub
		return dao.getShipmentModeCount();
	}

}
