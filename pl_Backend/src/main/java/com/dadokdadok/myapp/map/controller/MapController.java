package com.dadokdadok.myapp.map.controller;

import com.dadokdadok.myapp.map.service.MapService;
import com.dadokdadok.myapp.map.vo.MapVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MapController {
    /**
     * (완) 1. 도서관 or 서점 or 문화공간 하나 조회(모달용)
     * (완) 2. 지역별 조회(타입 상관 없이)
     * (완) 3. 지역별 도서관만 or 서점만 or 문화공간만 목록 조회
     * (완) 4. 내 위치 받아서 근처 10개
     * 5. 태그로 조회 - 보류(태그가 너무 많음)
     */

    @Autowired
    private MapService mapService;

    @GetMapping("get-book/{bookId}")
    public Optional<MapVO> getOneBook(@PathVariable Long bookId) {
        return mapService.findOneBook(bookId);
    }

    @GetMapping("get/books")
    public List<MapVO> getBooksByAddrAndType(
            @RequestParam String cityDo,
            @RequestParam(required = false) String siGunGu,
            @RequestParam(required = false) String type) {
        return mapService.getBooksByAddrAndType(cityDo, siGunGu, type);
    }

    @GetMapping("get/books-me")
    public List<MapVO> getBooksByAddrAndType(
            @RequestParam Double lat,
            @RequestParam Double lon){
        return mapService.getBooksByMe(lat, lon);
    }

}
