package com.goshgarmirzayev.allora.controller;

import com.goshgarmirzayev.allora.dao.UserDataInter;
import com.goshgarmirzayev.allora.entity.*;
import com.goshgarmirzayev.allora.service.impl.ImageService;
import com.goshgarmirzayev.allora.service.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/adminPanel")

public class AdminController {
    @Autowired
    UserDataInter userDataInter;
    @Autowired
    UserServiceInter userServiceInter;
    @Autowired
    ImageService imageService;
    @Autowired
    CategoryServiceInter categoryServiceInter;
    @Autowired
    SubCategoryServiceInter subCategoryServiceInter;

    //Index Page
    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

    //Products Begin
    @RequestMapping(value = "/products")
    public ModelAndView product(ModelAndView modelAndView) {
        modelAndView.setViewName("/admin/products");
        return modelAndView;
    }

    //category mappping
    @RequestMapping(value = "/categories")
    public ModelAndView category(ModelAndView modelAndView) {
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("categories", categoryServiceInter.findAll());
        modelAndView.setViewName("/admin/category");
        return modelAndView;
    }

    @PostMapping(value = "/category/add")
    public ModelAndView addCategory(ModelAndView modelAndView, @ModelAttribute("category") Category category, @RequestParam("image") MultipartFile file[]) {
        if (!file[0].isEmpty()) {
            category.setBannerImageUrl(imageService.createImage(file));
        }
        categoryServiceInter.save(category);

        modelAndView.addObject("categories", categoryServiceInter.findAll());
        modelAndView.setViewName("redirect:/adminPanel/categories");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteCategory/{id}")
    public ModelAndView deleteCategory(ModelAndView modelAndView, @PathVariable("id") Integer id) {
        categoryServiceInter.deleteById(id);
        modelAndView.setViewName("redirect:/adminPanel/categories");
        return modelAndView;
    }

    //subcategory mappping
    @RequestMapping(value = "/subCategories")
    public ModelAndView subCategory(ModelAndView modelAndView) {
        modelAndView.addObject("subCategory", new SubCategory());
        modelAndView.addObject("categories", categoryServiceInter.findAll());
        modelAndView.addObject("subCategories", subCategoryServiceInter.findAll());
        modelAndView.setViewName("/admin/subCategory");
        return modelAndView;
    }

    @PostMapping(value = "/subCategory/add")
    public ModelAndView addSubCategory(ModelAndView modelAndView, @ModelAttribute("subCategory") SubCategory category, @RequestParam("image") MultipartFile file[], @RequestParam("category") Integer catId) {
        System.out.println(category);
        if (!file[0].isEmpty()) {
            System.out.println("File Is not empty");
            category.setBannerImageUrl(imageService.createImage(file));
        }

        category.setCategoryId(categoryServiceInter.findById(catId));
        subCategoryServiceInter.save(category);
        modelAndView.setViewName("redirect:/adminPanel/subCategories");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteSubCategory/{id}")
    public ModelAndView deleteSubCategory(ModelAndView modelAndView, @PathVariable("id") Integer id) {
        subCategoryServiceInter.deleteById(id);
        modelAndView.setViewName("redirect:/adminPanel/subCategories");
        return modelAndView;
    }
    //Users started here

    @RequestMapping(value = "/addNewUser")
    public ModelAndView addSubUser(ModelAndView modelAndView) {
        modelAndView.addObject("users", userServiceInter.findAll());
        modelAndView.setViewName("admin/addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(ModelAndView modelAndView, @Valid User user, BindingResult result) {
        int r = userServiceInter.save(user);
        if (r == -1) {
            result.rejectValue("email", "email", "exist");
        }
        modelAndView.setViewName("redirect:/adminPanel/addNewUser");
        return modelAndView;
    }

    @RequestMapping(value = "/updateUser")
    public ModelAndView updateUser(ModelAndView modelAndView, @RequestParam("id") Integer id, @RequestParam("email") String email, @RequestParam("password") String password) {
        User newUser = userServiceInter.findById(id);
        userServiceInter.save(newUser);
        return new ModelAndView("redirect:/adminPanel/addNewUser");

    }

    @RequestMapping(value = "/deleteUser")
    public ModelAndView deleteUser(@RequestParam("id") Integer id) {
        userDataInter.deleteById(id);
        return new ModelAndView("redirect:/adminPanel/addNewUser");
    }
    //Users ended here

    //Post ended here
}