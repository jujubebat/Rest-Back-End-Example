package com.jujubebat.controller.api;

import com.jujubebat.dto.CalendarRequestDto;
import com.jujubebat.dto.CalendarResponseDto;
import com.jujubebat.exception.ResourceNotFoundException;
import com.jujubebat.model.Calendar;
import com.jujubebat.model.User;
import com.jujubebat.repository.CalendarRepository;
import com.jujubebat.repository.UserRepository;
import com.jujubebat.security.CurrentUser;
import com.jujubebat.security.UserPrincipal;
import com.jujubebat.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/calendars")
public class CalendarApiController {

    private final UserRepository userRepository;
    private final CalendarService calendarService;

    @Autowired
    public CalendarApiController(UserRepository userRepository, CalendarService calendarService){
        this.userRepository = userRepository;
        this.calendarService = calendarService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<CalendarResponseDto> getCalendars(@CurrentUser UserPrincipal userPrincipal) {

        User currentUser = userRepository.findById(userPrincipal.getId()).get();

        List<Calendar> CalendarList = calendarService.getCalendarsByUserId(currentUser.getId());

        List<CalendarResponseDto> CalendarResponseDtoList = new ArrayList<>();

        for(Calendar calendar : CalendarList){
            CalendarResponseDto calendarResponseDto = new CalendarResponseDto();

            calendarResponseDto.setPublicAuctionNum(calendar.getProduct().getPublicAuctionNum());
            calendarResponseDto.setUserId(calendar.getUser().getId());

            CalendarResponseDtoList.add(calendarResponseDto);
        }

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
    }

}
