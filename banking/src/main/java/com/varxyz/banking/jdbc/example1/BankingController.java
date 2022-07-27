package com.varxyz.banking.jdbc.example1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.banking.jdbc.Account;
import com.varxyz.banking.jdbc.Customer;
import com.varxyz.banking.jdbc.DataSourceConfig;

@Controller("example1.bankingController")
public class BankingController {

	@GetMapping("/example1/login")
	public String loginForm() {
		return "example1/login";
	}

	@PostMapping("/example1/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CustomerDao dao = context.getBean("customerDao", CustomerDao.class);

			if (CustomerService.findCustomer(dao, userId, passwd)) {
				// 로그인 성공
				mav.addObject("userId", userId);
				mav.setViewName("example1/banking_page");
			} else {
				mav.addObject("msg", "로그인 실패");
				mav.setViewName("example1/login");
			}

			CustomerService.findCustomer(dao, userId, passwd);
		} catch (BeansException e) {
			System.out.println("add_customer 오류남!");
		}
		return mav;
	}

	@GetMapping("/example1/banking_page")
	public String bankingForm() {
		return "example1/banking_page";
	}

	// 인터넷 뱅킹 가입
	@GetMapping("/example1/add_customer")
	public String addCustomerForm() {
		return "example1/add_customer";
	}

	@PostMapping("/example1/add_customer")
	public ModelAndView addCustomer(HttpServletRequest request) {

		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String phone = request.getParameter("phone");

		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		mav.addObject("name", name);
		mav.addObject("ssn", ssn);
		mav.addObject("phone", phone);
		mav.setViewName("example1/success_add_customer");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CustomerDao dao = context.getBean("customerDao", CustomerDao.class);

			CustomerService.addCustomer(dao, userId, passwd, name, ssn, phone);
		} catch (BeansException e) {
			System.out.println("add_customer 오류남!");
		}

		System.out.println("-Customer Inserted-");

		return mav;
	}

	// 계좌 개설
	@GetMapping("/example1/add_account")
	public ModelAndView addAccountForm(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.setViewName("example1/add_account");

		return mav;
	}

	@PostMapping("/example1/add_account")
	public ModelAndView addAccount(HttpServletRequest request) {

		Long customerId = null;

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
			String userId = request.getParameter("userId");
			customerId = CustomerService.getCustomerByAccountNum(dao, userId).getCid();

		} catch (BeansException e) {
			System.out.println("getCustomerByAccountNum 오류났음!!");
		}

		String accountNum = AccountService.checkAccountNum();
		String accType = request.getParameter("accType");
		String balance = request.getParameter("balance");
		Double balanceD = Double.parseDouble(balance);
		String interestRate = request.getParameter("interestRate");
		Double interestRateD = Double.parseDouble(interestRate);

		ModelAndView mav = new ModelAndView();
		mav.addObject("customerId", customerId);
		mav.addObject("accountNum", accountNum);
		mav.addObject("accType", accType);
		mav.addObject("balance", balance);
		mav.addObject("interestRate", interestRate);
		mav.setViewName("example1/success_add_account");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			AccountDao dao = context.getBean("accountDao", AccountDao.class);

			AccountService.addAccount(dao, customerId, accountNum, accType, balanceD, interestRateD);
		} catch (BeansException e) {
			System.out.println("add_account 오류났음!!");
		}
		System.out.println("-Account Inserted-");

		return mav;
	}

	// 계좌 목록 확인
	@PostMapping("/example1/getAccounts_result")
	public ModelAndView FindAccountForm(HttpServletRequest request) {

		String userId = request.getParameter("userId");
		List<Account> accountList = new ArrayList<>();

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			AccountDao dao = context.getBean("accountDao", AccountDao.class);

			accountList = AccountService.getAccounts(dao, userId);
			System.out.println(accountList);

			mav.addObject("accountList", accountList);
			mav.setViewName("example1/getAccounts_result");

		} catch (BeansException e) {
			System.out.println("getAccounts 오류났음!!");
		}
		System.out.println("-getAccounts Inserted-");

		return mav;
	}

	// 계좌 잔고 조회
	@GetMapping("/example1/getBalance")
	public ModelAndView getBalanceForm(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		ModelAndView mav = new ModelAndView();
		List<Account> accountNum = new ArrayList<>();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			AccountDao dao = context.getBean("accountDao", AccountDao.class);

			List<Account> accountList = AccountService.getAccounts(dao, userId);
			Iterator<Account> it = accountList.iterator();

			while (it.hasNext()) {
				Account str = it.next();
				System.out.println(str);
			}

			mav.addObject("it", it);
			mav.setViewName("example1/getBalance");

		} catch (BeansException e) {
			System.out.println("getBalance 오류났음!!");
		}
		System.out.println("-getBalance 불러옴-");

		return mav;
	}

	@PostMapping("/example1/getBalance")
	public ModelAndView FindBalanceForm(HttpServletRequest request) {
		String accountNum = request.getParameter("accountNum");

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			AccountDao dao = context.getBean("accountDao", AccountDao.class);

			Double balance = AccountService.getBalance(dao, accountNum).getBalance();
			System.out.println(balance);

			mav.addObject("balance", balance);
			mav.setViewName("example1/getBalance_result");

		} catch (BeansException e) {
			System.out.println("getBalance 오류났음!!");
		}
		System.out.println("-getBalance Inserted-");

		return mav;
	}

	// 계좌 이자 지급
	@GetMapping("/example1/saveInterest")
	public String saveInterestForm() {
		return "example1/saveInterest";
	}

	@PostMapping("/example1/saveInterest")
	public ModelAndView saveInterest(HttpServletRequest request) {
		String accountNum = request.getParameter("accountNum");

		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			AccountDao dao = context.getBean("accountDao", AccountDao.class);

			Double balance = AccountService.getBalance(dao, accountNum).getBalance();
			System.out.println(balance);

			mav.addObject("balance", balance);
			mav.setViewName("example1/saveInterest_result");

		} catch (BeansException e) {
			System.out.println("saveInterest 오류났음!!");
		}
		System.out.println("-saveInterest Inserted-");

		return mav;
	}
}
