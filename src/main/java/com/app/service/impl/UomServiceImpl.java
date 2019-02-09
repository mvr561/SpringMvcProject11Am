package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private IUomDao dao;
    
	@Transactional
	public Integer saveUom(Uom uom) {

		return dao.saveUom(uom);
	}

	@Transactional
	public void updateUom(Uom uom) {
		dao.updateUom(uom);
	}

	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);

	}

	@Transactional(readOnly=true)
	public Uom getUomById(Integer id) {

		return dao.getUomById(id);
	}

	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {

		return dao.getAllUoms();
	}
	
	
	@Transactional(readOnly=true)
	public List<Object[]> getUomTypeCount() {
		// TODO Auto-generated method stub
		return dao.getUomTypeCount();
	}


}
