//package com.mangesh.food.dao;
//
//import java.util.List;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.mangesh.fomobject.Product;
//
//@Repository
//public class ProductDao {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//	
////	private final String path = "/frontend-service/src/main/resources/static/images";
//
//	public void save(Product Product) {
//		Session session = sessionFactory.getCurrentSession();
//		String path = Product.getImageName();
//		session.save(Product);
//	}
//
//	public List<Product> findAllByCategoryId(Integer id) {
//		Session session = sessionFactory.getCurrentSession();
////		   Product product = session.get(Product.class, id);
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Product> createQuery = builder.createQuery(Product.class);
//		Root<Product> root = createQuery.from(Product.class);
//		createQuery.select(root);
//		Query<Product> query = session.createQuery(createQuery);
//		List<Product> producsList = query.getResultList();
//		return producsList;
//
//	}
//	
//	
//
//}
