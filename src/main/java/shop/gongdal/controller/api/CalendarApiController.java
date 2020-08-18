package shop.gongdal.controller.api;

import shop.gongdal.dto.CalendarRequestDto;
import shop.gongdal.dto.CalendarResponseDto;
import shop.gongdal.model.Calendar;
import shop.gongdal.model.Product;
import shop.gongdal.model.User;
import shop.gongdal.repository.UserRepository;
import shop.gongdal.security.CurrentUser;
import shop.gongdal.security.UserPrincipal;
import shop.gongdal.service.CalendarService;
import shop.gongdal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final ProductService productService;

    @Autowired
    public CalendarApiController(UserRepository userRepository, CalendarService calendarService, ProductService productService) {
        this.userRepository = userRepository;
        this.calendarService = calendarService;
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public CalendarResponseDto getCalendars(@CurrentUser UserPrincipal userPrincipal) {

        User currentUser = userRepository.findById(userPrincipal.getId()).get();

        List<Calendar> calendarList = calendarService.getCalendarsByUserId(currentUser.getId());

        List<Product> productList = new ArrayList<>();

        for (Calendar calendar : calendarList) {
            productList.add(calendar.getProduct());
        }

        CalendarResponseDto calendarResponseDto = new CalendarResponseDto();
        calendarResponseDto.setUserId(currentUser.getId());
        calendarResponseDto.setProductList(productList);
        return calendarResponseDto;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Object addCalendars(@CurrentUser UserPrincipal userPrincipal,
                               @RequestBody CalendarRequestDto calendarRequestDto) {
        User currentUser = userRepository.findById(userPrincipal.getId()).get();
        calendarService.addCalendars(currentUser.getId(), calendarRequestDto.getPublicAuctionNum());
        return new ResponseEntity<Void>(HttpStatus.CREATED); // 데이터 입력 올바르게 되었으면 true 리턴하도록 수정.
    }

    @DeleteMapping(path = "/{publicAuctionNum}")
    @PreAuthorize("hasRole('USER')")
    public Object removeCalendars(@CurrentUser UserPrincipal userPrincipal,
                                  @PathVariable(name = "publicAuctionNum") Long publicAuctionNum) {
        User currentUser = userRepository.findById(userPrincipal.getId()).get();
        calendarService.removeCalendar(currentUser.getId(), publicAuctionNum);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
