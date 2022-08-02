package com.varxyz.javacafe.product.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.javacafe.config.DataSourceConfig;
import com.varxyz.javacafe.product.domain.Product;
import com.varxyz.javacafe.product.repository.ProductDao;
import com.varxyz.javacafe.product.service.ProductServiceImpl;

@Controller("web.productController")
public class ProductController {

	@GetMapping("/web/purchase_page")
	public ModelAndView loginForm(HttpServletRequest request) {
		List<Product> drinkList = new ArrayList<>();
		List<Product> dessertList = new ArrayList<>();

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);

			drinkList = productService.getProductsByBigCategory(dao, "drink");
			dessertList = productService.getProductsByBigCategory(dao, "dessert");

			mav.addObject("drinkList", drinkList);
			mav.addObject("dessertList", dessertList);
			mav.setViewName("web/purchase_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

//	@PostMapping("/web/purchase_page")
	public ModelAndView login(HttpServletRequest request) {

		List<Product> drinkList = new ArrayList<>();
		List<Product> dessertList = new ArrayList<>();

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);

			drinkList = productService.getProductsByBigCategory(dao, "drink");
			dessertList = productService.getProductsByBigCategory(dao, "dessert");

			mav.addObject("drinkList", drinkList);
			mav.addObject("dessertList", dessertList);
			mav.setViewName("web/purchase_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
