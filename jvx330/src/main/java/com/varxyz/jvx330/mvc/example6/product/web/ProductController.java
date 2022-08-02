package com.varxyz.jvx330.mvc.example6.product.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.jvx330.mvc.example6.category.domain.BigCategory;
import com.varxyz.jvx330.mvc.example6.category.domain.MidCategory;
import com.varxyz.jvx330.mvc.example6.config.DataSourceConfig;
import com.varxyz.jvx330.mvc.example6.product.domain.Product;
import com.varxyz.jvx330.mvc.example6.product.repository.ProductDao;
import com.varxyz.jvx330.mvc.example6.product.service.ProductServiceImpl;

@Controller("example6.productController")
public class ProductController {

	@GetMapping("/example6/purchase_page")
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
			mav.setViewName("example6/purchase_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

//	@PostMapping("/example6/purchase_page")
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
			mav.setViewName("example6/purchase_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/example6/categoryAdd_page")
	public ModelAndView categoryForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);

			List<BigCategory> bigCategoryList = new ArrayList<>();
			List<MidCategory> midCategoryList = new ArrayList<>();
			
			bigCategoryList = 

//			mav.addObject("bigCategoryNameList", bigCategoryNameList);
//			mav.addObject("midCategoryNameList", midCategoryNameList);
			mav.setViewName("example6/categoryAdd_page");

		} catch (BeansException e) {
			System.out.println("categoryForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
