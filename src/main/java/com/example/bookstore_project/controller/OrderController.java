package com.example.bookstore_project.controller;


import com.example.bookstore_project.model.Order;
import com.example.bookstore_project.model.User;
import com.example.bookstore_project.service.OrderService;
import com.example.bookstore_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/submit")
    public String submitOrder(RedirectAttributes redirectAttributes) {
        try {
            Order order = orderService.submitOrder();
            return "redirect:/order/" + order.getId();
        }
        catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("errorMessage",e.getMessage());
            return "redirect:/cart";
        }


    }

    @GetMapping("/{orderId}")
    public String getOrder(@PathVariable Long orderId, Model model) {

        Order order = orderService.getOrder(orderId);
        model.addAttribute("order", order);


        return "order";
    }
    @GetMapping("/history")
    public String getOrderHistory(Model model) {
        User currentUser = userService.getCurrentUser();
        List<Order> orderHistory = orderService.getOrderHistoryForUser(currentUser);
        model.addAttribute("orderHistory", orderHistory);
        return "orderhistory";
    }
}