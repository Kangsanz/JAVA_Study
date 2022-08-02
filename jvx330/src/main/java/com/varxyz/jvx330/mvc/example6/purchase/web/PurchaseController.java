//package com.varxyz.jvx330.mvc.example6.purchase.web;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.varxyz.jvx330.mvc.example6.config.DataSourceConfig;
//import com.varxyz.jvx330.mvc.example6.product.domain.Product;
//import com.varxyz.jvx330.mvc.example6.product.web.Account;
//import com.varxyz.jvx330.mvc.example6.product.web.AccountServiceImpl;
//import com.varxyz.jvx330.mvc.example6.product.web.CustomerDao;
//import com.varxyz.jvx330.mvc.example6.product.web.CustomerServiceImpl;
//import com.varxyz.jvx330.mvc.example6.product.web.PurchaseDao;
//
////@Controller("example6.purchaseController")
////@RequestMapping("/example6/purchase_page")
//public class PurchaseController {
//
////	@GetMapping
//	public String purchaseForm(Model model) {
//		model.addAttribute("product", new Product());
//		return "example6/purchase_page";
//	}
//
////	@PostMapping
//	public String addCustomer(@ModelAttribute("product") Product product, Model model) {
//
//		// db처리
//		// ... (가정)
//		// customer = customerService.addCustomer(customer);
//
//		model.addAttribute("product", product);
//		return "example6/purchase_page";
//	}
//
////	@PostMapping("/example1/login")
//	public ModelAndView login(HttpServletRequest request) {
//		ModelAndView mav = new ModelAndView();
//
//		String userId = request.getParameter("userId");
//		String passwd = request.getParameter("passwd");
//
//		List<Account> accountList = new ArrayList<>();
//
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao adao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			accountList = accountService.getAccounts(adao, userId);
//
//			mav.addObject("userId", userId);
//			mav.addObject("accountList", accountList);
//
//			CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
//			CustomerServiceImpl customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
//
//			if (customerService.findCustomer(dao, userId, passwd)) {
//				// 로그인 성공
//				mav.addObject("userId", userId);
//				mav.setViewName("example1/banking_page");
//			} else {
//				mav.addObject("msg", "로그인 실패");
//				mav.setViewName("example1/login");
//			}
//			customerService.findCustomer(dao, userId, passwd);
//
//		} catch (BeansException e) {
//			System.out.println("login 오류났음!!");
//			e.printStackTrace();
//		}
//		return mav;
//	}
//
//	// 계좌 목록 확인
////	@GetMapping("/example1/banking_page")
//	public String bankingForm() {
//		return "example1/banking_page";
//	}
//
////	@PostMapping("/example1/banking_page")
//	public ModelAndView banking(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		List<Account> accountList = new ArrayList<>();
//
//		ModelAndView mav = new ModelAndView();
//
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			accountList = accountService.getAccounts(dao, userId);
//			System.out.println(accountList);
//
//			mav.addObject("userId", userId);
//			mav.addObject("accountList", accountList);
//			mav.setViewName("example1/banking_page");
//
//		} catch (BeansException e) {
//			System.out.println("getAccounts 오류났음!!");
//			e.printStackTrace();
//		}
//		System.out.println("-getAccounts Inserted-");
//
//		return mav;
//	}
//
//	// 인터넷 뱅킹 가입
////	@GetMapping("/example1/add_customer")
//	public String addCustomerForm() {
//		return "example1/add_customer";
//	}
//
////	@PostMapping("/example1/add_customer")
//	public ModelAndView addCustomer(HttpServletRequest request) {
//
//		String userId = request.getParameter("userId");
//		String passwd = request.getParameter("passwd");
//		String name = request.getParameter("name");
//		String ssn = request.getParameter("ssn");
//		String phone = request.getParameter("phone");
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userId", userId);
//		mav.addObject("passwd", passwd);
//		mav.addObject("name", name);
//		mav.addObject("ssn", ssn);
//		mav.addObject("phone", phone);
//		mav.setViewName("example1/add_customer");
//
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
//			CustomerServiceImpl customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
//
//			customerService.addCustomer(dao, userId, passwd, name, ssn, phone);
//		} catch (BeansException e) {
//			System.out.println("add_customer 오류남!");
//			e.printStackTrace();
//		}
//
//		System.out.println("-Customer Inserted-");
//
//		return mav;
//	}
//
//	// 계좌 개설
////	@GetMapping("/example1/add_account")
//	public ModelAndView addAccountForm(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userId", userId);
//		mav.setViewName("example1/add_account");
//
//		return mav;
//	}
//
////	@PostMapping("/example1/add_account")
//	public ModelAndView addAccount(HttpServletRequest request) {
//		Long customerId = null;
//		String userId = request.getParameter("userId");
//
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
//		CustomerDao cdao = context.getBean("customerDao", CustomerDao.class);
//		AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//		CustomerServiceImpl customerService = context.getBean("customerServiceImpl", CustomerServiceImpl.class);
//		customerId = customerService.getCustomerByUserId(cdao, userId).getCid();
//
//		System.out.println("오류 어서 뜸?");
//		String accountNum = accountService.checkAccountNum();
//		String accountPasswd = request.getParameter("accountPasswd");
//		System.out.println(accountPasswd);
//		String accType = request.getParameter("accType");
//		String balance = request.getParameter("balance");
//		Double balanceD = Double.parseDouble(balance);
//		String interestRate = request.getParameter("interestRate");
//		Double interestRateD = Double.parseDouble(interestRate);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userId", userId);
//		mav.addObject("accountNum", accountNum);
//		mav.addObject("accountPasswd", accountPasswd);
//		mav.addObject("accType", accType);
//		mav.addObject("balance", balance);
//		mav.addObject("interestRate", interestRate);
//		mav.setViewName("example1/add_account");
//
//		PurchaseDao adao = context.getBean("accountDao", PurchaseDao.class);
//
//		accountService.addAccount(adao, customerId, accountNum, accountPasswd, accType, balanceD, interestRateD);
//		System.out.println("-Account Inserted-");
//
//		return mav;
//	}
//
//	// 계좌 잔고 조회
////	@GetMapping("/example1/getBalance")
//	public ModelAndView getBalanceForm(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		ModelAndView mav = new ModelAndView();
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			List<Account> accountList = accountService.getAccounts(dao, userId);
//
//			List<String> accountNum = accountList.stream().map(Account::getAccountNum).collect(Collectors.toList());
//			System.out.println("accountNum List: " + accountNum.toString());
//
//			mav.addObject("userId", userId);
//			mav.addObject("accountNum", accountNum);
//			mav.setViewName("example1/getBalance");
//
//		} catch (BeansException e) {
//			System.out.println("getBalance 오류났음!!");
//			e.printStackTrace();
//		}
//		System.out.println("-getBalance 불러옴-");
//
//		return mav;
//	}
//
////	@PostMapping("/example1/getBalance")
//	public ModelAndView FindBalanceForm(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		String accountNum2 = request.getParameter("accountNum");
//
//		ModelAndView mav = new ModelAndView();
//
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			Double balance = accountService.getBalance(dao, accountNum2).getBalance();
//
//			List<Account> accountList = accountService.getAccounts(dao, userId);
//			List<String> accountNum = accountList.stream().map(Account::getAccountNum).collect(Collectors.toList());
//			System.out.println("accountNum List: " + accountNum.toString());
//
//			mav.addObject("userId", userId);
//			mav.addObject("accountNum", accountNum);
//			mav.addObject("balance", balance);
//			mav.setViewName("example1/getBalance");
//
//		} catch (BeansException e) {
//			System.out.println("getBalance 오류났음!!");
//			e.printStackTrace();
//		}
//		System.out.println("-getBalance Inserted-");
//
//		return mav;
//	}
//
//	// 계좌 이자 지급
////	@GetMapping("/example1/saveInterest")
//	public ModelAndView saveInterestForm(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		ModelAndView mav = new ModelAndView();
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			List<Account> accountList = accountService.getAccounts(dao, userId);
//
//			List<String> accountNum = accountList.stream().map(Account::getAccountNum).collect(Collectors.toList());
//			List<Double> balance = accountList.stream().map(Account::getBalance).collect(Collectors.toList());
//			List<Double> interest = accountList.stream().map(Account::getInterestRate).collect(Collectors.toList());
//			System.out.println("accountNum List: " + accountNum.toString());
//
//			mav.addObject("userId", userId);
//			mav.addObject("accountNum", accountNum);
//			mav.addObject("balance", balance);
//			mav.addObject("interest", interest);
//			mav.setViewName("example1/saveInterest");
//
//		} catch (BeansException e) {
//			System.out.println("saveInterest 오류났음!!");
//			e.printStackTrace();
//		}
//		System.out.println("-saveInterest 불러옴-");
//
//		return mav;
//	}
//
////	@PostMapping("/example1/saveInterest")
//	public ModelAndView saveInterest(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		String check = request.getParameter("check");
//		ModelAndView mav = new ModelAndView();
//
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			Double interestD = accountService.getBalance(dao, check).getInterestRate();
//			Double balanceD = accountService.getBalance(dao, check).getBalance();
//
//			Double balanceI = balanceD * interestD / 100;
//			balanceD += balanceI;
//			System.out.println(check + " / " + balanceD);
//
//			accountService.saveInterest(dao, check, balanceD);
//
//			List<Account> accountList = accountService.getAccounts(dao, userId);
//
//			List<String> accountNum = accountList.stream().map(Account::getAccountNum).collect(Collectors.toList());
//			List<Double> balance = accountList.stream().map(Account::getBalance).collect(Collectors.toList());
//			List<Double> interest = accountList.stream().map(Account::getInterestRate).collect(Collectors.toList());
//
//			mav.addObject("userId", userId);
//			mav.addObject("accountNum", accountNum);
//			mav.addObject("balance", balance);
//			mav.addObject("interest", interest);
//			mav.setViewName("example1/saveInterest");
//
//		} catch (BeansException e) {
//			System.out.println("saveInterest 오류났음!!");
//			e.printStackTrace();
//		}
//		System.out.println("-saveInterest Inserted-");
//
//		return mav;
//	}
//
//	// 계좌 이체
////	@GetMapping("/example1/transfer")
//	public ModelAndView transferForm(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//
//		ModelAndView mav = new ModelAndView();
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			List<Account> accountList = accountService.getAccounts(dao, userId);
//			List<Account> allAccountList = accountService.getAccountsAll(dao);
//
//			List<String> allAccountsNum = allAccountList.stream().map(Account::getAccountNum)
//					.collect(Collectors.toList());
//			List<String> accountNum = accountList.stream().map(Account::getAccountNum).collect(Collectors.toList());
//			List<Double> balance = accountList.stream().map(Account::getBalance).collect(Collectors.toList());
//			System.out.println("accountNum List: " + accountNum.toString());
//
//			mav.addObject("userId", userId);
//			mav.addObject("allAccountsNum", allAccountsNum);
//			mav.addObject("accountNum", accountNum);
//			mav.addObject("balance", balance);
//			mav.setViewName("example1/transfer");
//
//		} catch (BeansException e) {
//			System.out.println("transfer 오류났음!!");
//			e.printStackTrace();
//		}
//		System.out.println("-transfer 불러옴-");
//
//		return mav;
//	}
//
////	@PostMapping("/example1/transfer")
//	public ModelAndView transfer(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		String accountNumT = request.getParameter("accountNumT");
//		String allAccountNum = request.getParameter("allAccountNum");
//		String balanceT = request.getParameter("balanceT");
//		Double balanceD = Double.parseDouble(balanceT);
//
//		ModelAndView mav = new ModelAndView();
//		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//				DataSourceConfig.class)) {
//			PurchaseDao dao = context.getBean("accountDao", PurchaseDao.class);
//			AccountServiceImpl accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
//
//			Double balanceA = accountService.getBalance(dao, accountNumT).getBalance();
//			balanceA -= balanceD;
//			Double balanceAA = accountService.getBalance(dao, allAccountNum).getBalance();
//			balanceAA += balanceD;
//
//			accountService.transfer(dao, balanceA, accountNumT);
//			accountService.transfer(dao, balanceAA, allAccountNum);
//
//			List<Account> accountList = accountService.getAccounts(dao, userId);
//			List<Account> allAccountList = accountService.getAccountsAll(dao);
//
//			List<String> allAccountsNum = allAccountList.stream().map(Account::getAccountNum)
//					.collect(Collectors.toList());
//			List<String> accountNum = accountList.stream().map(Account::getAccountNum).collect(Collectors.toList());
//			List<Double> balance = accountList.stream().map(Account::getBalance).collect(Collectors.toList());
//			System.out.println("accountNum List: " + accountNum.toString());
//
//			mav.addObject("userId", userId);
//			mav.addObject("allAccountsNum", allAccountsNum);
//			mav.addObject("accountNum", accountNum);
//			mav.addObject("accountNum2", accountNum);
//			mav.addObject("balance", balance);
//			mav.addObject("balance2", balance);
//			mav.setViewName("example1/transfer");
//
//		} catch (BeansException e) {
//			System.out.println("transfer 오류났음!!");
//			e.printStackTrace();
//		}
//		System.out.println("-transfer 불러옴-");
//
//		return mav;
//	}
//}
