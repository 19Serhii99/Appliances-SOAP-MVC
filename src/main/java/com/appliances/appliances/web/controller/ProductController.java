package com.appliances.appliances.web.controller;

import com.appliances.appliances.web.client.ProductClient;
import com.appliances.appliances.web.model.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductController {

    ProductClient client;

    @GetMapping("/products")
    public String findAll(Model model)  {
        List<Product> products = client.findAll().getProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        List<Product> products = client.findProductsByName(name).getProducts();

        model.addAttribute("searchField", name);
        model.addAttribute("products", products);

        return "products";
    }

    @PostMapping("/create")
    @ResponseBody
    public void create(@RequestBody Product product) {
        client.create(product);
    }

    @PostMapping("/update")
    @ResponseBody
    public void update(@RequestBody Product product) {
        client.update(product);
    }

    @GetMapping("/delete")
    @ResponseBody
    public void delete(@RequestParam("id") int id) {
        client.delete(id);
    }
}
