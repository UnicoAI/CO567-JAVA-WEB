package com.example.securingweb;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.securingweb.model.Ticket;;

@Controller
public class BookingController {
        
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private TicketService ticketService;

 

    @GetMapping("/booking")
    public String showBookingForm(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            // Log authentication details
            logger.info("User {} is authenticated.", authentication.getName());
    
    model.addAttribute("tickets", ticketService.getAllTickets());
      

        // Add list of events and seats to the model
        model.addAttribute("events", Arrays.asList(
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/eDnHgozW8vfOaLHzfpHluf1GZCW.jpg' width='100px'> Archive",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/gfJGlDaHuWimErCr5Ql0I8x9QSy.jpg' width='100px'>Wonder Woman",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/u6c5xkR0eIzlnxcQoMBlySH6ann.jpg' width='100px'>Deep Water Horizon",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/yf5IuMW6GHghu39kxA0oFx7Bxmj.jpg' width='100px'>Palm Springs",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/2kNnf7BwRCEm4bcFkdiE0T4U25s.jpg' width='100px'>Guns Akimbo",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/ggFHVNu6YYI5L9pCfOacjizRGt.jpg' width='100px'>Breaking Bad",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/prdFM08mGvVDA6uQxKJh8n8Vek1.jpg' width='100px'>How it ends",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/h4VB6m0RwcicVEZvzftYZyKXs6K.jpg' width='100px'>Birds of prey",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg' width='100px'>Sonic",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/pNM2VmqS2FBL92EJ0fUPLgoij8x.jpg' width='100px'>The occupant",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg' width='100px'>Joker",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/sm8iVzA7kRp0d4BSIsgXjsSBMKV.jpg' width='100px'>Emma",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg' width='100px'>Captain Marvel",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/pjeMs3yqRmFL3giJy4PMXWZTTPa.jpg' width='100px'>Frozen 2",
          "<img src='https://image.tmdb.org/t/p/w370_and_h556_bestv2/wUggWBMN8xUNVasYsroyUUPmaKa.jpg' width='100px'>Blue story"
  )); // Replace with actual events
  
        model.addAttribute("seats", Arrays.asList("A1", "A2", "B1", "B2","C1", "C2", "D1", "D2")); // Replace with actual seats
    
        return "booking";
    }

 else {
    // User is not authenticated, redirect to the login page or any other page as needed
    return "redirect:/login";
}
}
 
   @PostMapping("/bookTicket")
    public String bookTicket(
        
            @RequestParam("event") String event,
            @RequestParam("seat") String seat,
            @RequestParam("price") Double price,
            Model model) {

        if (event == null || seat == null || price == null) {
            // Set an error message
            model.addAttribute("error", "Please Select Your Seat!");
            // Return an error view
            return "error";
        }

        try {
            Ticket bookedTicket = ticketService.bookTicket(event, seat, price);
            model.addAttribute("message", "Ticket booked successfully!");
            model.addAttribute("bookedTicket", bookedTicket);
            return "bookticket";
        } catch (Exception e) {
            // Handle specific exceptions if needed
            model.addAttribute("error", "Error booking ticket: " + e.getMessage());
            return "error";
        }
    }
}
