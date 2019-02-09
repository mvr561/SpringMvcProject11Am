package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseDao;
import com.app.model.Purchase;

@Repository
public class PurchaseDaoImpl implements IPurchaseDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	public Integer savePurchase(Purchase purchase) {
		return (Integer) ht.save(purchase);
	}

	public void updatePurchase(Purchase purchase) {
		ht.update(purchase);
	}

	public void deletePurchase(Integer orderId) {
		ht.delete(new Purchase(orderId));
	}

	public Purchase getPurchaseById(Integer orderId) {
		return ht.get(Purchase.class, orderId);
	}

	public List<Purchase> getAllPurchases() {
		return ht.loadAll(Purchase.class);
	}

}
