package com.varxyz.javacafe.category.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.javacafe.category.domain.BigCategory;
import com.varxyz.javacafe.category.domain.MidCategory;
import com.varxyz.javacafe.category.repository.CategoryDao;
import com.varxyz.javacafe.category.service.CategoryServiceImpl;
import com.varxyz.javacafe.config.DataSourceConfig;

@Controller("category.categoryController")
public class CategoryController {

	@GetMapping("/category/categoryAdd_page")
	public ModelAndView categoryForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DataSourceConfig.class)) {
			CategoryDao dao = context.getBean("categoryDao", CategoryDao.class);
			CategoryServiceImpl categoryService = context.getBean("categoryServiceImpl", CategoryServiceImpl.class);

			List<BigCategory> bigCategoryList = new ArrayList<>();
			List<MidCategory> midCategoryList = new ArrayList<>();

			bigCategoryList = categoryService.getBigCategoryAll(dao);
			midCategoryList = categoryService.getMidCategoryAll(dao);

			List<String> bigCategoryListName = bigCategoryList.stream().map(BigCategory::getBigName)
					.collect(Collectors.toList());
			List<String> midCategoryListName = midCategoryList.stream().map(MidCategory::getMidName)
					.collect(Collectors.toList());

			mav.addObject("bigCategoryList", bigCategoryListName);
			mav.addObject("midCategoryList", midCategoryListName);
			mav.setViewName("category/categoryAdd_page");

		} catch (BeansException e) {
			System.out.println("categoryForm 오류났음!!");
			e.printStackTrace();
		}
		return mav;
	}
}
