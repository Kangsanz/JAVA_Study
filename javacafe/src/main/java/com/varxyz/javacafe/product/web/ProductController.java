package com.varxyz.javacafe.product.web;

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
import com.varxyz.javacafe.purchase.domain.CartItem;
import com.varxyz.javacafe.purchase.domain.Item;
import com.varxyz.javacafe.purchase.repository.PurchaseDao;
import com.varxyz.javacafe.purchase.service.PurchaseServiceImpl;

@Controller("product.productController")
public class ProductController {

	@GetMapping("/product/product_page")
	public ModelAndView loginForm(HttpServletRequest request) {
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
			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/product/product_page1")
	public ModelAndView bigForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String bigCategory = request.getParameter("bigCategory");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

			List<Product> categoryProductsName = productService.getProductsByBigCategory(dao, bigCategory);

			List<String> categoryProducts = categoryProductsName.stream().map(Product::getProName)
					.collect(Collectors.toList());
			List<Long> productsPrice = categoryProductsName.stream().map(Product::getProPrice)
					.collect(Collectors.toList());

			mav.addObject("categoryProducts", categoryProducts);
			mav.addObject("productsPrice", productsPrice);
			mav.setViewName("product/product_page");

			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

		} catch (BeansException e) {
			System.out.println("bigForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/product/product_page2")
	public ModelAndView midForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String midCategory = request.getParameter("midCategory");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

			List<Product> categoryProductsName = productService.getProductsByMidCategory(dao, midCategory);
			List<String> categoryProducts = categoryProductsName.stream().map(Product::getProName)
					.collect(Collectors.toList());
			List<Long> productsPrice = categoryProductsName.stream().map(Product::getProPrice)
					.collect(Collectors.toList());

			mav.addObject("categoryProducts", categoryProducts);
			mav.addObject("productsPrice", productsPrice);
			mav.setViewName("product/product_page");

			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

		} catch (BeansException e) {
			System.out.println("midForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@PostMapping("/product/product_page")
	public ModelAndView login(HttpServletRequest request) {
		String categoryProducts = request.getParameter("categoryProducts");
		String productsPrice = request.getParameter("productsPrice");
		String product = request.getParameter("product");
		String cartListString = request.getParameter("cartList");

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			PurchaseDao pDao = context.getBean("purchaseDao", PurchaseDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);
			PurchaseServiceImpl purchaseService = context.getBean("purchaseServiceImpl", PurchaseServiceImpl.class);

			// 카테고리 보이기
			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			// 상품 정보 보이기

			String[] splits1 = productService.splits(categoryProducts);
			String[] splits2 = productService.splits(productsPrice);
			String[] splits3 = productService.splits(cartListString);

			ArrayList<String> categoryProductsList = new ArrayList<>(Arrays.asList(splits1));
			ArrayList<String> productsPriceList = new ArrayList<>(Arrays.asList(splits2));
			ArrayList<String> cartList = new ArrayList<>(Arrays.asList(splits3));

			mav.addObject("categoryProducts", categoryProductsList);
			mav.addObject("productsPrice", productsPriceList);
			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			// 장바구니
			List<String> cart;
			int allCount;
			int amount;

			if (cart == null) {
				cart = new ArrayList<>();
			}

			List<CartItem> cartItems;

			if (cartItems == null) {
				cartItems = new ArrayList<>();
			}

			Item item = new Item(product);

			cart.add(purchaseService.addCart(cart, cartItems, item, product, amount));

			List<CartItem> cartItemList = purchaseService.

			mav.addObject("cartList", cart);
			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
