package com.bpb.hssb.ch5.bookclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bpb.hssb.ch5.bookclub.service.BookServiceException;

@Controller
public class ExceptionController {

    @RequestMapping("/geterror")
    public String someEndpoint() throws BookServiceException {
        throw new BookServiceException("Intentionally created error");
    }


}
