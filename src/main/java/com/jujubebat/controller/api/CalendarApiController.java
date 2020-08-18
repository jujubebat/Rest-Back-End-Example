package com.jujubebat.controller.api;

import com.jujubebat.dto.CalendarRequestDto;
import com.jujubebat.dto.CalendarResponseDto;
import com.jujubebat.exception.ResourceNotFoundException;
import com.jujubebat.model.Calendar;
import com.jujubebat.model.Product;
import com.jujubebat.model.User;
import com.jujubebat.repository.CalendarRepository;
import com.jujubebat.repository.UserRepository;
import com.jujubebat.security.CurrentUser;
import com.jujubebat.security.UserPrincipal;
import com.jujubebat.service.CalendarService;
import com.jujubebat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/calendars")
public class CalendarApiController {

    private final UserRepository userRepository;
    private final CalendarService calendarService;
    private final ProductService productService;
    private EntityManager entityManager;

    @Autowired
    public CalendarApiController(UserRepository userRepository, CalendarService calendarService, ProductService productService){
        this.userRepository = userRepository;
        this.calendarService = calendarService;
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<CalendarResponseDto> getCalendars(@CurrentUser UserPrincipal userPrincipal) {

        User currentUser = userRepository.findById(userPrincipal.getId()).get();

       // List<Calendar> CalendarList = calendarService.getCalendarsByUserId(currentUser.getId());
       // System.out.println("CalendarList size : " + CalendarList.size());
       // List<CalendarResponseDto> CalendarResponseDtoList = new ArrayList<>();

       // for(Calendar calendar : CalendarList){

        calendarService.getCalendarsByUserId(currentUser.getId());

        Calendar calendar = calendarService.getCalendarsByUserId(currentUser.getId()).get(0);

        //calendar.getUser()

        List<CalendarResponseDto> CalendarResponseDtoList = new ArrayList<>();


        CalendarResponseDto calendarResponseDto = new CalendarResponseDto();

            calendarResponseDto.setUserId(calendar.getUser().getId());
            calendarResponseDto.setProduct(calendar.getProduct());

            CalendarResponseDtoList.add(calendarResponseDto);
       // }

        return CalendarResponseDtoList;
    }

// @RequestBody ReservationInfoParam reservationParam
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public boolean addCalendars(@CurrentUser UserPrincipal userPrincipal,
                             @RequestBody CalendarRequestDto calendarRequestDto) {



        User currentUser = userRepository.findById(userPrincipal.getId()).get();
        calendarService.addCalendars(currentUser.getId(), calendarRequestDto.getPublicAuctionNum());
        return true; // 데이터 입력 올바르게 되었으면 true 리턴하도록 수정.
    }

    @DeleteMapping(path = "/{publicAuctionNum}")
    @PreAuthorize("hasRole('USER')")
    public void removeCalendars(@CurrentUser UserPrincipal userPrincipal,
                                @PathVariable(name = "publicAuctionNum") Long publicAuctionNum) {

        User currentUser = userRepository.findById(userPrincipal.getId()).get();

        calendarService.removeCalendar(currentUser.getId(), publicAuctionNum);
    }

}
