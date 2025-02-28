package com.bpb.hssb.ch4.bookclub.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.bpb.hssb.ch4.bookclub.service.BookServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookServiceException.class)
    public String handleBookServiceException(BookServiceException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error/error";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String handleNoResourceFoundException(NoResourceFoundException ex, Model model) {
        return "error/default";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex, Model model) {
        return "error/default";
    }
}
