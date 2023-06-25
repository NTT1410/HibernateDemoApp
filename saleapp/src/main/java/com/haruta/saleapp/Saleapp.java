/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.haruta.saleapp;

import com.haruta.pojo.Category;
import com.haruta.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author nguye
 */
public class Saleapp {

    public static void main(String[] args) {
        try(Session s = HibernateUtils.getFatory().openSession()){
            Query q = s.createNamedQuery("Category.findAll", Category.class);
            List<Category> cates = q.getResultList();
            cates.forEach(c -> System.out.println(c.getName()));
        }
//        Map<String, String> params = new HashMap<>();
//        params.put("fromPrice", "30000000");
//        params.put("toPrice", "50000000");
//        params.put("cateId", "1");
//        
//        ProductRepository pre = new ProductRepository();
//        pre.getProducts(params).forEach(p -> System.out.printf("%d - %s - %.1f\n", p.getId(), p.getName(), p.getPrice()));
    }
}
