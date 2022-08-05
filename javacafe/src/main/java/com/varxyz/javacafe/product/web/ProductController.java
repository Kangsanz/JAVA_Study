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

@Controller("product.productController")
public class ProductController {

	@GetMapping("/product/addProduct_page")
	public ModelAndView addForm(HttpServletRequest request) {
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

		String bigCategory = request.getParameter("bigCategory");
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
	public ModelAndView bigForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String bigCategory = request.getParameter("bigCategory");
		String cartItem = request.getParameter("cart");
		String totalPrice = request.getParameter("totalPrice");

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

			// 장바구니 상품 불러오기
			String[] splits3 = productService.splits(cartItem);

			List<String> cartList = null;
			if (splits3 != null) {
				cartList = new ArrayList<>(Arrays.asList(splits3));
			}

			List<String> cart = new ArrayList<>();

			// 장바구니 상품 리스트 장바구니에 추가
			if (cartList != null) {
				for (String item : cartList) {
					cart.add(item);
				}
				// 장바구니 이름과 가격 구별
				mav.addObject("cart", cart);
			}

			mav.addObject("totalPrice", totalPrice);

			mav.setViewName("product/product_page");

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
		String cartItem = request.getParameter("cart");
		String totalPrice = request.getParameter("totalPrice");

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

			// 장바구니 상품 불러오기
			String[] splits3 = productService.splits(cartItem);

			List<String> cartList = null;
			if (splits3 != null) {
				cartList = new ArrayList<>(Arrays.asList(splits3));
			}

			List<String> cart = new ArrayList<>();

			// 장바구니 상품 리스트 장바구니에 추가
			if (cartList != null) {
				for (String item : cartList) {
					cart.add(item);

				}
				// 장바구니 이름과 가격 구별
				mav.addObject("cart", cart);
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
	public ModelAndView login(HttpServletRequest request) {
		String categoryProducts = request.getParameter("categoryProducts");
		String productsPrice = request.getParameter("productsPrice");
		String proName = request.getParameter("proName");
		String proPrice = request.getParameter("proPrice");
		String cartItem = request.getParameter("cart");
		String totalPrice = request.getParameter("totalPrice");

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductDao dao = context.getBean("productDao", ProductDao.class);
			CategoryDao cDao = context.getBean("categoryDao", CategoryDao.class);
//			PurchaseDao pDao = context.getBean("purchaseDao", PurchaseDao.class);
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);
//			PurchaseServiceImpl purchaseService = context.getBean("purchaseServiceImpl", PurchaseServiceImpl.class);

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

			ArrayList<String> categoryProductsList = new ArrayList<>(Arrays.asList(splits1));
			ArrayList<String> productsPriceList = new ArrayList<>(Arrays.asList(splits2));

			mav.addObject("categoryProducts", categoryProductsList);
			mav.addObject("productsPrice", productsPriceList);
			mav.addObject("bigCategoryListName", bigCategoryListName);
			mav.addObject("midCategoryListName", midCategoryListName);

			// 장바구니 상품 불러오기
			String[] splits3 = productService.splits(cartItem);

			System.out.println("splits3 = " + splits3);

			List<String> cartList = null;
			if (splits3 != null) {
				cartList = new ArrayList<>(Arrays.asList(splits3));
			}
			System.out.println("cartList = " + cartList);

			// 장바구니 null 체크
			if (cartList == null) {
				System.out.println("cartList 비었음!");
				List<String> cart = new ArrayList<>();

				// 장바구니 상품 리스트
				int allCount;
				int amount;

				String cartName = proName;
				String cartPrice = proPrice;
				String cartAmount = "1";
				String cartNamePrice = proName + "/" + proPrice + "/" + cartAmount;
				mav.addObject("cartName", cartName);
				mav.addObject("cartPrice", cartPrice);
				mav.addObject("cartAmount", cartAmount);

				// 장바구니 상품 리스트 장바구니에 추가
				cart.add(cartNamePrice);

				// 장바구니 이름과 가격 구별
				mav.addObject("cart", cart);

			} else {
				System.out.println("cartList 안 비었음!");
				List<String> cart = new ArrayList<>();

				// 장바구니 상품 리스트
				int allCount;
				int amount;

				// 기존 상품 장바구니 추가
				for (String item : cartList) {
					cart.add(item);
				}

				// 상품이 기존에 있으면 갯수 상승 및 새로운 상품 리스트 장바구니에 추가
				String cartName = proName;
				String cartPrice = proPrice;
				int cartAmount = 1;

				String cartNamePrice = cartName + "/" + cartPrice + "/" + cartAmount;

				if (productService.contain(cart, cartName, cartPrice, cartAmount, cartNamePrice)) {
					System.out.println("상품이 존재함");
					cart.remove(cartNamePrice);

					cart.add(cartNamePrice);
				} else {
					System.out.println("상품이 없음");
					cart.add(cartNamePrice);
				}

				// 장바구니 이름과 가격 구별
				mav.addObject("cart", cart);
			}

			// 총 금액
			Long totalPriceL = Long.parseLong(totalPrice);

			String intStr = proPrice.replaceAll("[^\\d]", "");
			totalPriceL += Long.parseLong(intStr);

			mav.addObject("totalPrice", totalPriceL);

			mav.setViewName("product/product_page");

		} catch (BeansException e) {
			System.out.println("loginForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
