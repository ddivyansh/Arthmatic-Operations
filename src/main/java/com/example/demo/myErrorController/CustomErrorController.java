//package com.example.demo.myErrorController;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//
///*
//Building a custom error controller to handle error pages
//*/
//@Controller
//public class CustomErrorController implements ErrorController {
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request) {
//        //do something like logging
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//
//        if (status != null) {
//            int statusCode = Integer.parseInt(status.toString());
//
//            if(statusCode == HttpStatus.NOT_FOUND.value()) {
//                return "404";
//            }
//            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//                return "error-500";
//            }
//        }
//        return "error";
//    }
//}
