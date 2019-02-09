package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	public HibernateTemplate ht;
	

	
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		
		return (Integer) ht.save(orderMethod);
	}

	
	public void updateOrderMethod(OrderMethod orderMethod) {
		ht.update(orderMethod);

	}

	
	public void deleteOrderMethod(Integer id) {
		ht.delete(new OrderMethod(id));
	}

	
	public OrderMethod getOrderMethodById(Integer id) {
		
		return ht.get(OrderMethod.class, id);
	}

	
	public List<OrderMethod> getAllOrderMethods() {
		
		return ht.loadAll(OrderMethod.class);
	}


	@Override
	public List<Object[]> getOrderModeTypeCount() {
		
		return (List<Object[]>) ht.find(" select orderMode,count(orderMode) from com.app.model.OrderMethod group by orderMode ");
	}

}
