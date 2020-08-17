package com.jujubebat.service;

import com.jujubebat.dto.ProductResponseDto;
import com.jujubebat.model.Calendar;
import com.jujubebat.model.Product;
import com.jujubebat.model.User;
import com.jujubebat.repository.CalendarRepository;
import com.jujubebat.repository.ProductRepository;
import com.jujubebat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository,
                           UserRepository userRepository,
                           ProductRepository productRepository){
        this.calendarRepository = calendarRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<Calendar> getCalendarsByUserId(Long userId){
        return calendarRepository.findByUserId(userId);
    }

    public void addCalendars(Long userId, Long publicAuctionNum){
        Calendar calendar = new Calendar();

        Optional<User> user = userRepository.findById(userId);
        calendar.setUser(user.get());

        Optional<Product> product = productRepository.findById(publicAuctionNum);
        calendar.setProduct(product.get());

        calendarRepository.save(calendar);

    }

    //addCalendars(currentUser.getId(), calendarRequestDto)

}
