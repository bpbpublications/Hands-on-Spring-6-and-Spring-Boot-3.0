package com.bpb.hssb.ch10.bookclub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpb.hssb.ch10.bookclub.domain.ServiceInfo;
import com.bpb.hssb.ch10.bookclub.service.BookServiceException;

@RestController
@RequestMapping("/api")
public class ServiceInfoController {

    private ServiceInfo serviceInfo;

    public ServiceInfoController(ServiceInfo serviceInfo) {

        this.serviceInfo = serviceInfo;
    }

    @GetMapping("/info")
    public ServiceInfo getInfo() throws BookServiceException {
        return serviceInfo;
    }

}
