package com.example.securingweb;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DemoController {

   

    @GetMapping("/index")
    public String showBookingForm( Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // User is authenticated, proceed with displaying the booking form
           
        return "/index";
    } else {
        // User is not authenticated, redirect to the login page or any other page as needed
        return "redirect:/login";
    }
    }

    @PostMapping("/booking")
public String bookMovie(
        
        Model model) {

    return "booking";
}

}
