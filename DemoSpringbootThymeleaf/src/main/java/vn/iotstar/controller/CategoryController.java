package vn.iotstar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.iotstar.entity.Category;
import vn.iotstar.repository.CategoryRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    // Hiển thị danh sách
    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "category/index"; // => templates/category/index.html
    }

    // Mở form thêm mới Category
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "category/form"; // => templates/category/form.html
    }

    // Lưu Category mới hoặc cập nhật
    @PostMapping("/save")
    public String save(Category category) {
        categoryRepo.save(category);
        return "redirect:/categories";
    }

    // Mở form sửa theo ID
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Category cate = categoryRepo.findById(id).orElse(null);
        model.addAttribute("category", cate);
        return "category/form";
    }

    // Xóa theo ID
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryRepo.deleteById(id);
        return "redirect:/categories";
    }
}
