package com.busanit501.project_library.service;

import com.busanit501.project_library.dto.EventDTO;
import java.util.List;

public interface EventService {
    Long register(EventDTO eventDTO); // 등록
    EventDTO readOne(Long id);       // 상세 조회
    List<EventDTO> getAll();         // 전체 목록
    List<EventDTO> getLecturesByCategory(String category); // 카테고리별 목록
}