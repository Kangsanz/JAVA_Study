package com.varxyz.javacafe.product.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

@Controller("product.productController")
public class ProductController {

	@GetMapping("/product/addProduct_page")
	public ModelAndView addForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			mav.setViewName("product/addProduct_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@PostMapping("/product/addProduct_page")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String midCategory = request.getParameter("midCategory");
		String proName = request.getParameter("proName");
		String proPrice = request.getParameter("proPrice");
		Long proPriceL = Long.parseLong(proPrice);
		String proImage = request.getParameter("proImage");

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

			MidCategory midCategory2 = categoryService.getMidCategoryByMidName(cDao, midCategory);
			int mid = midCategory2.getMid();

			productService.addProduct(dao, mid, proName, proPriceL, proImage);

			mav.setViewName("product/addProduct_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/product/product_page")
	public ModelAndView loginForm(HttpServletRequest request, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			Long totalPrice = (long) 0;

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);
			mav.addObject("totalPrice", totalPrice);
			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/product/product_page1")
	public ModelAndView bigForm(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String bigCategory = request.getParameter("bigCategory");
		Object cartItemListO = session.getAttribute("cartItemList");
		String cartItemList = String.valueOf(cartItemListO);
		
		if("null".equals(cartItemList)) {
			cartItemList = null;
		}

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

			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			String[] splits1 = productService.splits(cartItemList);
			ArrayList<String> cartItemList2 = null;
			if (splits1 != null) {
				cartItemList2 = new ArrayList<>(Arrays.asList(splits1));
				mav.addObject("cartItemList", cartItemList2);
			}

			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("bigForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/product/product_page2")
	public ModelAndView midForm(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String midCategory = request.getParameter("midCategory");
		String totalPrice = request.getParameter("totalPrice");
		Object cartItemListO = session.getAttribute("cartItemList");
		String cartItemList = String.valueOf(cartItemListO);
		
		if("null".equals(cartItemList)) {
			cartItemList = null;
		}
		
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

			List<BigCategory> bigCategoryList = categoryService.getBigCategoryAll(cDao);
			List<MidCategory> midCategoryList = categoryService.getMidCategoryAll(cDao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			String[] splits1 = productService.splits(cartItemList);
			ArrayList<String> cartItemList2 = null;
			if (splits1 != null) {
				cartItemList2 = new ArrayList<>(Arrays.asList(splits1));
				mav.addObject("cartItemList", cartItemList2);
			}

			mav.addObject("totalPrice", totalPrice);

			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("midForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@PostMapping("/product/product_page")
	public ModelAndView login(HttpServletRequest request, HttpSession session) {
		String categoryProducts = request.getParameter("categoryProducts");
		String productsPrice = request.getParameter("productsPrice");
		String totalPrice = request.getParameter("totalPrice");
		Object cartItemListO = session.getAttribute("cartItemList");
		String cartItemList = String.valueOf(cartItemListO);
		
		if("null".equals(cartItemList)) {
			cartItemList = null;
		}
		
		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

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

			ArrayList<String> categoryProductsList = null;
			ArrayList<String> productsPriceList = null;
			if (splits1 != null) {
				categoryProductsList = new ArrayList<>(Arrays.asList(splits1));
				productsPriceList = new ArrayList<>(Arrays.asList(splits2));
			}

			mav.addObject("categoryProducts", categoryProductsList);
			mav.addObject("productsPrice", productsPriceList);
			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			String[] splits3 = productService.splits(cartItemList);
			ArrayList<String> cartItemList2 = null;
			if (splits1 != null) {
				cartItemList2 = new ArrayList<>(Arrays.asList(splits3));
				mav.addObject("cartItemList", cartItemList2);
			}

			mav.addObject("totalPrice", totalPrice);

			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@PostMapping("/product/product_page2")
	public ModelAndView login2(HttpServletRequest request, HttpSession session) {
		session.invalidate();

		String categoryProducts = request.getParameter("categoryProducts");
		String productsPrice = request.getParameter("productsPrice");
		String totalPrice = request.getParameter("totalPrice");

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

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

			ArrayList<String> categoryProductsList = null;
			ArrayList<String> productsPriceList = null;
			if (splits1 != null) {
				categoryProductsList = new ArrayList<>(Arrays.asList(splits1));
				productsPriceList = new ArrayList<>(Arrays.asList(splits2));
			}

			mav.addObject("categoryProducts", categoryProductsList);
			mav.addObject("productsPrice", productsPriceList);
			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			mav.addObject("totalPrice", totalPrice);

			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
