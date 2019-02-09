package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;


@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	public Integer saveUom(Uom uom) {

		return (Integer)ht.save(uom);
	}


	public void updateUom(Uom uom) {
		ht.update(uom);
	}


	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}


	public Uom getUomById(Integer id) {

		return ht.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAllUoms() {

		return ht.loadAll(Uom.class);
	}


	@Override
	public List<Object[]> getUomTypeCount() {
		// TODO Auto-generated method stub
		return (List<Object[]>) ht.find(" select uomType,count(uomType) from com.app.model.Uom group by uomType ");
	}

}
