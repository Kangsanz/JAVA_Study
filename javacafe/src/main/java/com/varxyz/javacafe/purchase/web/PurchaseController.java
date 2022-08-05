package com.varxyz.javacafe.purchase.web;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.javacafe.config.DataSourceConfig;
import com.varxyz.javacafe.product.service.ProductServiceImpl;

@Controller("purchase.purchaseController")
public class PurchaseController {

	@PostMapping("/purchase/purchase_page")
	public ModelAndView purchase(HttpServletRequest request, HttpSession session) {
		String proName = request.getParameter("proName");
		String proPrice = request.getParameter("proPrice");
		Object totalPriceO = session.getAttribute("totalPrice");
		String totalPrice = String.valueOf(totalPriceO);
		Object cartItemListO = session.getAttribute("cartItemList");
		String cartItemList = String.valueOf(cartItemListO);

		if ("null".equals(totalPrice)) {
			totalPrice = null;
		}

		if ("null".equals(cartItemList)) {
			cartItemList = null;
		}

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);

			mav.addObject("proName", proName);
			mav.addObject("proPrice", proPrice);

			String[] splits1 = productService.splits(cartItemList);
			ArrayList<String> cartItemList2 = null;
			if (splits1 != null) {
				cartItemList2 = new ArrayList<>(Arrays.asList(splits1));
			}

			mav.addObject("cartItemList", cartItemList2);

			mav.addObject("totalPrice", totalPrice);

			mav.setViewName("purchase/purchase_page");

		} catch (BeansException e) {
			System.out.println("midForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}

	@PostMapping("/purchase/purchase_page_result")
	public ModelAndView purchaseResult(HttpServletRequest request, HttpSession session) {
		String proName = request.getParameter("proName");
		String proPrice = request.getParameter("proPrice");
		String proAmount = request.getParameter("proAmount");
		Object totalPriceO = session.getAttribute("totalPrice");
		String totalPrice = String.valueOf(totalPriceO);
		Object cartItemListO = session.getAttribute("cartItemList");
		String cartItemList = String.valueOf(cartItemListO);

		if ("null".equals(totalPrice)) {
			totalPrice = null;
		}

		if ("null".equals(cartItemList)) {
			cartItemList = null;
		}

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			ProductServiceImpl productService = context.getBean("productServiceImpl", ProductServiceImpl.class);

			String[] splits1 = productService.splits(cartItemList);
			ArrayList<String> cartItemList2 = null;
			if (splits1 != null) {
				cartItemList2 = new ArrayList<>(Arrays.asList(splits1));

				String proTotal = proName + "/" + proAmount + "/" + proPrice;
				cartItemList2.add(proTotal);
				System.out.println(cartItemList);

				String intStr = proPrice.replaceAll("[^0-9]", "");
				Long proPriceL = Long.parseLong(intStr);
				int proAmountI = Integer.parseInt(proAmount);
				Long totalPrice2 = proPriceL * proAmountI;

				session.setAttribute("cartItemList", cartItemList2);
				session.setAttribute("totalPrice", totalPrice2);

			} else {
				cartItemList2 = new ArrayList<>();

				String proTotal = proName + "/" + proAmount + "/" + proPrice;
				cartItemList2.add(proTotal);
				System.out.println(cartItemList);

				String intStr = proPrice.replaceAll("[^0-9]", "");
				Long proPriceL = Long.parseLong(intStr);
				int proAmountI = Integer.parseInt(proAmount);
				Long totalPriceAll = null;

				if (totalPrice != null) {
					Long totalPrice1 = Long.parseLong(totalPrice);
					Long totalPrice2 = proPriceL * proAmountI;
					totalPriceAll = totalPrice1 + totalPrice2;
				}

				session.setAttribute("cartItemList", cartItemList2);
				session.setAttribute("totalPrice", totalPriceAll);
			}

			mav.setViewName("purchase/purchase_page_result");

		} catch (BeansException e) {
			System.out.println("midForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
