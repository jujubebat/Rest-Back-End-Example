package shop.gongdal.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import shop.gongdal.model.Calendar;
import shop.gongdal.model.Product;
import shop.gongdal.model.User;
import shop.gongdal.repository.CalendarRepository;
import shop.gongdal.repository.ProductRepository;
import shop.gongdal.repository.UserRepository;
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
                           ProductRepository productRepository) {
        this.calendarRepository = calendarRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public List<Calendar> getCalendarsByUserId(Long userId) {
        return calendarRepository.findByUserId(userId);
    }

    public void addCalendars(Long userId, Long productId) {
        Calendar calendar = new Calendar();

        Optional<User> user = userRepository.findById(userId);
        calendar.setUser(user.get());

        Optional<Product> product = productRepository.findById(productId);
        calendar.setProduct(product.get());

        calendarRepository.save(calendar);
    }

    public ResponseEntity removeCalendar(Long userId, Long productId) {
        calendarRepository.deleteByUserIdAndProductId(userId, productId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
