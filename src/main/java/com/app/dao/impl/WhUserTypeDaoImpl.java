package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
	@Autowired
	private HibernateTemplate ht;

	
	public Integer saveWhUserType(WhUserType whUserType) {
		
		return (Integer) ht.save(whUserType);
	}

	
	public void updateWhUserType(WhUserType whUserType) {
		ht.update(whUserType);
	}

	
	public void deleteWhUserType(Integer id) {
		ht.delete(new WhUserType(id));
	}


	public WhUserType getWhUserTypeById(Integer id) {
		
		return ht.get(WhUserType.class, id);
	}

	
	public List<WhUserType> getAllWhUserTypes() {
		
		return ht.loadAll(WhUserType.class);
	}


	
	public List<Object[]> getUserTypeCount() {
		// TODO Auto-generated method stub
		return (List<Object[]>) ht.find(" select userType,count(userType) from com.app.model.WhUserType group by userType ");
	}

}
