/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.haruta.saleapp;

import com.haruta.pojo.Category;
import com.haruta.pojo.OrderDetail;
import com.haruta.pojo.ProdTag;
import com.haruta.pojo.Product;
import com.haruta.pojo.SaleOrder;
import com.haruta.pojo.Tag;
import com.haruta.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author nguye
 */
public class HibernateUtils {
    private static final SessionFactory fatory;
    
    static{
        Configuration conf = new Configuration();
        
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "14102002aT");
        props.put(Environment.SHOW_SQL, "true");
        
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(OrderDetail.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        fatory = conf.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getFatory() {
        return fatory;
    }
    
    
}
