package shop.gongdal.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import shop.gongdal.model.Calendar;
import shop.gongdal.model.Product;
import shop.gongdal.model.User;
import shop.gongdal.payload.CalendarRequest;
import shop.gongdal.payload.CalendarResponse;
import shop.gongdal.repository.user.UserRepository;
import shop.gongdal.security.CurrentUser;
import shop.gongdal.security.UserPrincipal;
import shop.gongdal.service.CalendarService;
import shop.gongdal.service.ProductService;

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
    public CalendarApiController(UserRepository userRepository, CalendarService calendarService, ProductService productService){
        this.userRepository = userRepository;
        this.calendarService = calendarService;
        this.productService = productService;
    }

    @GetMapping(path = "/addTest/{productId}")
    public void addTest(@PathVariable("productId") Long productId){
        calendarService.addCalendars(Long.parseLong("1"), productId);
    }

    @GetMapping(path = "/getTest")
    public CalendarResponse getTest(){
        List<Calendar> calendarList = calendarService.getCalendarsByUserId(Long.parseLong("1"));

        List<Product> productList = new ArrayList<>();

        for(Calendar calendar : calendarList){
            productList.add(calendar.getProduct());
        }

        CalendarResponse calendarResponseDto = new CalendarResponse();
        calendarResponseDto.setUserId(Long.parseLong("1"));
        calendarResponseDto.setProductList(productList);
        return calendarResponseDto;
    }


    @GetMapping(path = "deteTest/{productId}")
    public boolean deleteTest(@PathVariable(name = "productId") Long productId){

        calendarService.removeCalendar(Long.parseLong("1"), productId);
        return true;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public CalendarResponse getCalendars(@CurrentUser UserPrincipal userPrincipal) {

        User currentUser = userRepository.findById(userPrincipal.getId()).get();

        List<Calendar> calendarList = calendarService.getCalendarsByUserId(currentUser.getId());

        List<Product> productList = new ArrayList<>();

        for(Calendar calendar : calendarList){
            productList.add(calendar.getProduct());
        }

        CalendarResponse calendarResponseDto = new CalendarResponse();
        calendarResponseDto.setUserId(currentUser.getId());
        calendarResponseDto.setProductList(productList);
        return calendarResponseDto;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public boolean addCalendars(@CurrentUser UserPrincipal userPrincipal,
                               @RequestBody CalendarRequest calendarRequest) {
        User currentUser = userRepository.findById(userPrincipal.getId()).get();
        calendarService.addCalendars(currentUser.getId(), calendarRequest.getProductId());
        return true;
    }

    @DeleteMapping(path = "/{productId}")
    @PreAuthorize("hasRole('USER')")
    public boolean removeCalendars(@CurrentUser UserPrincipal userPrincipal,
                                  @PathVariable(name = "productId") Long productId) {

        User currentUser = userRepository.findById(userPrincipal.getId()).get();
        calendarService.removeCalendar(currentUser.getId(), productId);
        //return new ResponseEntity<Void>(HttpStatus.OK);
        return true;
    }

}

