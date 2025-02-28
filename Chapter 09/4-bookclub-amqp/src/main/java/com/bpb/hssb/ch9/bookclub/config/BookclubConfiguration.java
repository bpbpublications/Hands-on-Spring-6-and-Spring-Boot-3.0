package com.bpb.hssb.ch9.bookclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bpb.hssb.ch9.bookclub.receiver.ReservationRequestReceiver;
import com.bpb.hssb.ch9.bookclub.repository.BookCopyRepository;
import com.bpb.hssb.ch9.bookclub.repository.BookRepository;
import com.bpb.hssb.ch9.bookclub.repository.ReservationRequestRepository;
import com.bpb.hssb.ch9.bookclub.service.BookService;
import com.bpb.hssb.ch9.bookclub.service.BookServiceImpl;
import com.bpb.hssb.ch9.bookclub.service.ReservationService;
import com.bpb.hssb.ch9.bookclub.service.ReservationServiceImpl;

@Configuration
public class BookclubConfiguration {

    @Bean
    public BookService bookService(BookRepository bookRepository, BookCopyRepository bookCopyRepository) {
        return new BookServiceImpl(bookRepository, bookCopyRepository);
    }

    @Bean
    public ReservationService reservationService(ReservationRequestRepository reservationRequestRepository) {
        return new ReservationServiceImpl(reservationRequestRepository);
    }

    @Bean
    public ReservationRequestReceiver reservationRequestReceiver(ReservationService reservationService) {
        return new ReservationRequestReceiver(reservationService);
    }

}
