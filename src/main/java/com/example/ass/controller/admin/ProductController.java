package com.example.ass.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ass.beans.ProductBean;
import com.example.ass.entities.Category;
import com.example.ass.entities.Product;
import com.example.ass.service.CategoryService;
import com.example.ass.service.ProductService;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@GetMapping({ "", "/list" })
	public String index(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "admin/product/index";
	}

	@GetMapping("/create")
	public String create(Model model, @ModelAttribute("product") Product product) {
		return "admin/product/create";
	}

	@ModelAttribute("categories")
	public List<Category> getCategory() {
		return categoryService.findAll();
	}

	@PostMapping("/store")
	public String store(Model model, @Validated @ModelAttribute("product") ProductBean productBean,
			BindingResult result) {
		if (!result.hasErrors()) {
			if (!productBean.getImage().isEmpty()) {
				try {
					byte[] bytes = productBean.getImage().getBytes();
					Path path = Paths.get(
							"src/main/resources/static/images/product/" + productBean.getImage().getOriginalFilename());
					Files.write(path, bytes);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Product product = new Product();
			product.setName(productBean.getName());
			product.setPrice(productBean.getPrice());
			product.setCategory(productBean.getCategory());
			product.setCreatedDate(new Date());
			product.setAvailable(productBean.getAvailable());
			product.setImage(productBean.getImage().getOriginalFilename());
			productService.save(product);
			return "admin/product/createsuccess";
		}
		return "admin/product/create";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Product product) {
		productService.delete(product);
		return "redirect:/admin/product";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @ModelAttribute("product") ProductBean productBean,
			@PathVariable("id") Product product) {
		model.addAttribute("product", product);
		return "admin/product/edit";
	}

	@PostMapping("edit/update/{id}")
	public String update(Model model, @Validated @ModelAttribute("product") ProductBean productBean,
			@PathVariable("id") Product product, BindingResult result) {
		if (!result.hasErrors()) {
			if (!productBean.getImage().isEmpty()) {
				try {
					byte[] bytes = productBean.getImage().getBytes();
					Path path = Paths.get(
							"src/main/resources/static/images/product/" + productBean.getImage().getOriginalFilename());
					Files.write(path, bytes);
					product.setImage(productBean.getImage().getOriginalFilename());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			product.setName(productBean.getName());
			product.setPrice(productBean.getPrice());
			product.setCategory(productBean.getCategory());
			product.setAvailable(productBean.getAvailable());
			productService.save(product);
			return "admin/product/editsuccess";
		}
		return "admin/product/edit";
	}
}
