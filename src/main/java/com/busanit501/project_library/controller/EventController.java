package com.busanit501.project_library.controller;

import com.busanit501.project_library.dto.EventDTO;
import com.busanit501.project_library.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/event")
@Log4j2
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    // 이달의 행사 리스트 (전체 보기)
    @GetMapping("/list")
    public void list(Model model) {
        log.info("이달의 행사 리스트 조회 중...");
        List<EventDTO> dtoList = eventService.getAll();
        model.addAttribute("dtoList", dtoList);
    }

    // 행사 및 강좌 상세 안내
    @GetMapping("/read")
    public void read(Long id, Model model) {
        log.info("행사 상세 정보 조회 : " + id);
        EventDTO eventDTO = eventService.readOne(id);
        model.addAttribute("dto", eventDTO);
    }

    @GetMapping("/lecture")
    public String lectureList(Model model) {
        log.info("강좌 및 세미나 리스트 조회 중...");
        List<EventDTO> lectureList = eventService.getLecturesByCategory("G");
        model.addAttribute("lectureList", lectureList);

        return "event/lecture";
    }
}