package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {
	
	public Integer saveWhUserType(WhUserType whUserType);
	public void updateWhUserType(WhUserType whUserType);
	public void deleteWhUserType(Integer id);
	public WhUserType getWhUserTypeById(Integer id);
	public List<WhUserType> getAllWhUserTypes();
	public List<Object[]> getUserTypeCount();
   
}
