package com.fpoly.controller;

import com.fpoly.model.Product;
import com.fpoly.service.ProductService;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // Tiêm ProductService qua constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Hiển thị danh sách sản phẩm sử dụng layout/base.html
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        System.out.println(products);
        model.addAttribute("products", products);
        model.addAttribute("title", "Product List");
        // Chỉ định fragment "content" trong file products/list.html
        model.addAttribute("content", "products/list");
        return "layout/base"; // Trỏ tới file base.html nằm trong thư mục layout
    }

    // Hiển thị form tạo sản phẩm mới sử dụng layout/base.html
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("title", "Create Product");
        model.addAttribute("product", new Product());
        model.addAttribute("content", "products/create");
        return "layout/base";
    }

    // Xử lý tạo mới sản phẩm
    @PostMapping
    public String createProduct(@ModelAttribute("product") @Validated Product product, BindingResult result,
            Model model, @RequestParam(value = "lang", required = false) String lang) {
        if (result.hasErrors()) {
            model.addAttribute("title", "Create Product");
            model.addAttribute("content", "products/create");
            return "layout/base"; // Trả về form nếu có lỗi
        }
        productService.createProduct(product);
        return "redirect:/products" + (lang != null ? "?lang=" + lang : "");
    }

    // Hiển thị form chỉnh sửa sản phẩm sử dụng layout/base.html
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("title", "Edit Product");
        model.addAttribute("content", "products/edit");
        return "layout/base";
    }

    // Xử lý cập nhật sản phẩm
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.updateProduct(product);
        return "redirect:/products";
    }

    // Xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
