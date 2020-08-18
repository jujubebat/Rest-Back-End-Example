package com.jujubebat.repository;

import com.jujubebat.model.Calendar;
import com.jujubebat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    List<Calendar> findByUserId(Long userId);

    //https://happyer16.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9A%94%EC%B2%ADrequest%EC%8B%9C-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98-%EC%8B%9C%EC%9E%91%EC%9D%80-%EC%96%B4%EB%94%94%EC%84%9C-%ED%95%A0%EA%B9%8C
    @Transactional // 안쓰면 삭제오류남
    boolean deleteByUserIdAndProductId(Long userId, Long productId);
}
