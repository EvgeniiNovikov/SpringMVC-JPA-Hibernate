//package controllers;
//
//import models.Address;
//import models.Role;
//import models.User;
//import services.UserServiceHibernate;
//import services.UserServiceHibernateImpl;
//import validator.UserChecker;
//import validator.UserCheckerImpl;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@WebServlet("/servlet1")
//public class TestServlet extends HttpServlet {
//
//    UserServiceHibernate service = new UserServiceHibernateImpl();
//    UserChecker validator = new UserCheckerImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher = null;
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//        User user;
//        try {
//            user = service.checkUser(login, password);
//            if (user.getRole().getTitle().equals("user")) {
//                req.setAttribute("user", user);
//                dispatcher = req.getRequestDispatcher("/jsp/HUserInfo.jsp");
//            } else if (user.getRole().getTitle().equals("admin")) {
//                req.setAttribute("users", service.getAllUsers());
//                dispatcher = req.getRequestDispatcher("/jsp/AdminAllUserInfo.jsp");
//            }
//        } catch (Exception e) {
//            req.setAttribute("message", " login or password is incorrect");
//            dispatcher = req.getRequestDispatcher("/jsp/HLogin.jsp");
//            dispatcher.forward(req, resp);
//        }
//
//        if (dispatcher != null) {
//            dispatcher.forward(req, resp);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher;
//        if (validator.checkLogin(req.getParameter("login"))) {
//            req.setAttribute("message", "This login out");
//            dispatcher = req.getRequestDispatcher("/jsp/HAddUser.jsp");
//            dispatcher.forward(req, resp);
//        } else {
//            User user = new User();
//            Address address = new Address();
//            Role role = new Role();
//            user.setLogin(req.getParameter("login"));
//            user.setPassword(req.getParameter("password"));
//            user.setfName(req.getParameter("first_name"));
//            user.setlName(req.getParameter("last_name"));
//            address.setCountry(req.getParameter("country"));
//            address.setUserAddress(req.getParameter("userAddress"));
//            user.setAddress(address);
//            role.setTitle(req.getParameter("role"));
//            role.addUser(user);
//            user.setRole(role);
//            service.addUser(user);
//            resp.sendRedirect("jsp/HLogin.jsp");
//        }
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = service.findById(Integer.parseInt(req.getParameter("id")));
//        user.setId(Integer.parseInt(req.getParameter("id")));
//        user.setLogin(req.getParameter("login"));
//        user.setPassword(req.getParameter("password"));
//        user.setfName(req.getParameter("firstName"));
//        user.setlName(req.getParameter("lastName"));
//        user.getAddress().setCountry(req.getParameter("country"));
//        user.getAddress().setUserAddress(req.getParameter("address"));
//        user.getRole().setTitle(req.getParameter("role"));
//        service.update(user);
//        resp.sendRedirect("/jsp/HLogin.jsp");
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        service.delete(id);
//        resp.sendRedirect("/jsp/HLogin.jsp");
//    }
//}
