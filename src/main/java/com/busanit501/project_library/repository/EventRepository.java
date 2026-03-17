package com.busanit501.project_library.repository;

import com.busanit501.project_library.domain.Event;
import org.springframework.data.domain.Page; // 추가
import org.springframework.data.domain.Pageable; // 추가
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    // Pageable을 파라미터로 받고 리턴은 Page로!
    Page<Event> findByCategory(String category, Pageable pageable);
}