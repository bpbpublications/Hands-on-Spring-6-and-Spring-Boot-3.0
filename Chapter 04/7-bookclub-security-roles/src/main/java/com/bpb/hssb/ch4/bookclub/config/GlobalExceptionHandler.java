package com.bpb.hssb.ch4.bookclub.config;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
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

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAccessDeniedException(AccessDeniedException ex) {
        System.out.println("======================");
        return "redirect:/books";
    } 
}
