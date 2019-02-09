package com.app.service;

import java.util.List;

import com.app.model.Uom;

public interface IUomService {
	
	
	public Integer saveUom(Uom uom);
	public void updateUom(Uom uom);
	public void deleteUom(Integer id);
	public Uom getUomById(Integer id);
	public List<Uom> getAllUoms();
	public List<Object[]> getUomTypeCount();


}
