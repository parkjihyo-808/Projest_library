package com.busanit501.project_library.repository;

import com.busanit501.project_library.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    // 카테고리별로 리스트 가져오는 기능 추가
    List<Event> findByCategory(String category);
}