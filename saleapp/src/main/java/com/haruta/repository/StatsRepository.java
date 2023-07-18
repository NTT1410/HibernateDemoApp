/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.repository;

import com.haruta.pojo.Category;
import com.haruta.pojo.Product;
import com.haruta.saleapp.HibernateUtils;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class StatsRepository {
    public List<Object[]> countProductsByCate(){
        try (Session s = HibernateUtils.getFatory().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            
            Root rProduct = q.from(Product.class);
            Root rCate = q.from(Category.class);
            
            q.where(b.equal(rProduct.get("categoryId"), rCate.get("id")));
            
            q.multiselect(rCate.get("id"), rCate.get("name"), b.count(rProduct.get("id")));
            
            q.groupBy(rCate.get("id"));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
}
