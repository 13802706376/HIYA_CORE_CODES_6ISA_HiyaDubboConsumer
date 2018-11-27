package com.hiya.dubbo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiya.dubbo.product.IProduct;
import com.hiya.dubbo.product.IProductRest1;
import com.hiya.dubbo.product.IProductRest2;
import com.hiya.dubbo.product.Product;

public class HomeController
{
    @Autowired
    private IProduct productService;
    
    @Autowired
    private IProductRest1 productRest1Service;
    
    @Autowired
    private IProductRest2  productRest2Service;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Locale locale, Model model)
    {
        Product pro = productService.getProduct(0L);
        System.out.println(pro.toString());
        int p = productService.saveProduct(pro);
        System.out.println(p);
        
        Product pro1 = productRest1Service.getProduct(1L);
        System.out.println(pro1.toString());
        int p1 = productRest1Service.saveProduct(pro1);
        System.out.println(p1);
        
        Product pro2 = productRest2Service.getProduct(2L);
        System.out.println(pro2.toString());
        int p2 = productRest2Service.saveProduct(pro2);
        System.out.println(p2);
        return "home";
    }
}
