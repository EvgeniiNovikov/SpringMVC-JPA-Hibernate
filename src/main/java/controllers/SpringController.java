package controllers;

import models.Address;
import models.Role;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.UserServiceHibernate;
import validator.UserChecker;


@Controller
public class SpringController {

    private UserServiceHibernate service;
    private UserChecker checker;

    @Autowired
    public void setUserServiceHibernate(UserServiceHibernate userServiceHibernate) {
        this.service = userServiceHibernate;
    }

    @Autowired
    public void setUserChecker(UserChecker userChecker) {
        this.checker = userChecker;
    }

    @RequestMapping(value = "/")
    public String start() {
        return "start";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam("login") String login, @RequestParam("password") String password) {
        String value = "";
        User user;
        try {
            user = service.checkUser(login, password);
            if (user.getRole().getTitle().equals("user")) {
                model.addAttribute("user", user);
                value = "HUserInfo";
            } else if (user.getRole().getTitle().equals("admin")) {
                model.addAttribute("users", service.getAllUsers());
                value = "AdminAllUserInfo";
            }
        } catch (Exception e) {
            model.addAttribute("message", " login or password is incorrect");
            value = "HLogin";
        }
        return value;
    }

    @PostMapping("/addUser")
    public String addUser(Model model, @RequestParam("login") String login, @RequestParam("password") String password,
                          @RequestParam("first_name") String fName, @RequestParam("last_name") String lName,
                          @RequestParam("country") String country, @RequestParam("userAddress") String userAddress,
                          @RequestParam("role") String title) {
        String value;
        if (checker.checkLogin(login)) {
            model.addAttribute("message", "This login out");
           value = "HAddUser";
        } else {
            User user = new User();
            Address address = new Address();
            Role role = new Role();
            user.setLogin(login);
            user.setPassword(password);
            user.setfName(fName);
            user.setlName(lName);
            address.setCountry(country);
            address.setUserAddress(userAddress);
            user.setAddress(address);
            role.setTitle(title);
            role.addUser(user);
            user.setRole(role);
            service.addUser(user);
            value = "HLogin";
        }
        return value;
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") int id, @RequestParam("login") String login, @RequestParam("password") String password,
                             @RequestParam("firstName") String fName, @RequestParam("lastName") String lName,
                             @RequestParam("country") String country, @RequestParam("address") String userAddress,
                             @RequestParam("role") String role) {
        User user = service.findById(id);
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setfName(fName);
        user.setlName(lName);
        user.getAddress().setCountry(country);
        user.getAddress().setUserAddress(userAddress);
        user.getRole().setTitle(role);
        service.update(user);
        return "HLogin";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        service.delete(id);
        return "HLogin";
    }

    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    public String goToEnterPage() {
        return "HLogin";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String goToUserInfoPage() {
        return "HUserInfo";
    }

    @RequestMapping(value = "/delete1", method = RequestMethod.POST)
    public String goToDeletePage() {
        return "HDeleteUser";
    }

    @RequestMapping(value = "/update1", method = RequestMethod.POST)
    public String goToUpdatePage() {
        return "HUpdateUser";
    }

    @RequestMapping(value = "/adminUpdate", method = RequestMethod.POST)
    public String goToAdminUpdatePage() {
        return "AdminUpdateUsers";
    }

    @RequestMapping(value = "/addUser1", method = RequestMethod.GET)
    public String goToAddUser() {
        return "HAddUser";
    }
}
