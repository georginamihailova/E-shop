package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private final OrderService orderService;
    private final TypeService typeService;
    private final UserService userService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService, OrderService orderService, TypeService typeService,UserService userService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
        this.typeService = typeService;
        this.userService = userService;
    }

    @GetMapping
    public String getBalloonListPage(@RequestParam(required = false)String error, Model model){
        List<Balloon> balloons = this.balloonService.listAll();
        model.addAttribute("balloons",balloons);
//        List<BalloonType> balloonTypes = this.typeService.findAll();
//        model.addAttribute("types", balloonTypes);
        return "listBalloons2";
    }
    @PostMapping
    public String sendBalloon(HttpServletRequest request,Model model){
        String option = request.getParameter("color");
        request.getSession().setAttribute("option",option);
        return "redirect:/selectBalloon";
    }
    @GetMapping("/add-balloon")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        List<BalloonType> balloonTypes = this.typeService.findAll();
        model.addAttribute("manufacturers",manufacturers);
        model.addAttribute("types", balloonTypes);
        return "add-balloon";
    }
    @PostMapping("/add")
    public String saveBalloon(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Long manufacturer) {
        this.balloonService.save(name, description, manufacturer);

        return "redirect:/balloons";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }
    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editBalloon(@PathVariable Long id, Model model) {
        if (this.balloonService.findById(id).isPresent())
        {
            Balloon balloons = this.balloonService.findById(id).get();
            this.balloonService.deleteById(id);
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
//            List<BalloonType> balloonTypes = this.typeService.findAll();
            model.addAttribute("manufacturers", manufacturers);
//            model.addAttribute("types", balloonTypes);
            model.addAttribute("balloons", balloons);
            return "add-balloon";
        }
        return "redirect:/balloons?error=ProductNotFound";
    }
    @GetMapping("/userOrders")
    public String getAllOrdersPage(Model model, HttpServletRequest request) {
        String username = (String) request.getRemoteUser();
        String color = (String) request.getSession().getAttribute("option");
        String size = (String) request.getSession().getAttribute("size");
        this.orderService.placeOrder(color,size,username);
        System.out.println(orderService.findAll());
        model.addAttribute("orders", this.orderService.findAll());
        return "userOrders";
    }





}
