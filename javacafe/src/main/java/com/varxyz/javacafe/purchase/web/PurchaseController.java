package com.varxyz.javacafe.purchase.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.javacafe.category.domain.BigCategory;
import com.varxyz.javacafe.category.domain.MidCategory;
import com.varxyz.javacafe.category.repository.CategoryDao;
import com.varxyz.javacafe.category.service.CategoryServiceImpl;
import com.varxyz.javacafe.config.DataSourceConfig;
import com.varxyz.javacafe.product.domain.Product;
import com.varxyz.javacafe.product.repository.ProductDao;
import com.varxyz.javacafe.product.service.ProductServiceImpl;

@Controller("purchase.purchaseController")
public class PurchaseController {


	@PostMapping("/product/product_page1")
	public ModelAndView login(HttpServletRequest request) {
		String categoryProducts = request.getParameter("categoryProducts");
		String productsPrice = request.getParameter("productsPrice");
		String product = request.getParameter("product");
		String cartListString = request.getParameter("cartList");
		String cartPrice = request.getParameter('"' + product + '"');

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			String[] splits1 = productService.splits(categoryProducts);
			String[] splits2 = productService.splits(productsPrice);
			String[] splits3 = productService.splits(cartListString);

			ArrayList<String> categoryProductsList = new ArrayList<>(Arrays.asList(splits1));
			ArrayList<String> productsPriceList = new ArrayList<>(Arrays.asList(splits2));
			ArrayList<String> cartList = new ArrayList<>(Arrays.asList(splits3));

			if (cartList.contains("")) {
				cartList.clear();
			}

			int cartPriceInt = 0;
			if (cartPrice != null) {
				cartPriceInt = Integer.parseInt(cartPrice);
				if (cartList.contains(product)) {
					cartPriceInt += 1;
				} else {
					cartList.add(product);
				}
			} else {
				cartList.add(product);
			}

			mav.addObject("categoryProducts", categoryProductsList);
			mav.addObject("productsPrice", productsPriceList);
			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);
			mav.addObject("cartList", cartList);
			mav.addObject(product, cartPriceInt);
			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
