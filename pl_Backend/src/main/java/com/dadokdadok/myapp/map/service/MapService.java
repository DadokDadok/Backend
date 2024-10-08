package com.dadokdadok.myapp.map.service;

import com.dadokdadok.myapp.map.mapper.MapMapper;
import com.dadokdadok.myapp.map.vo.MapVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MapService {
    /**
     * 1. 도서관 or 서점 or 문화공간 하나 조회(모달용) - 파라미터: 아이디
     * 2. 지역별 조회(타입 상관 없이) - 파라미터: 시도, 시군구(시군구는 옵션)
     * 3. 지역별 도서관만 or 서점만 or 문화공간만 목록 조회  - 파라미터: 시도, 시군구(시군구는 옵션), 타입
     * 4. 내 위치 기준
     * 5. 태그로 조회 - 보류(태그가 너무 많음)
     */

    private final com.dadokdadok.myapp.map.repository.MapRepository MapRepository;

    private final MapMapper mapper;

    // 1. 도서관 or 서점 or 문화공간 하나 조회(모달용)
    public Optional<MapVO> findOneBook(Long id) {
        return MapRepository.findById(id);
    }

    // 2. 지역별 조회(타입 상관 없이) - 파라미터: 시도, 시군구(시군구는 옵션)
    public List<MapVO> getBooksByAddrAndType(String cityDo, String siGunGu, String type) {
        if ((siGunGu == null || siGunGu.isEmpty()) && (type == null || type.isEmpty())) {
            // siGunGu와 type이 모두 X
            return MapRepository.findByCityDo(cityDo);
        } else if (siGunGu != null && !siGunGu.isEmpty() && (type == null || type.isEmpty())) {
            // siGunGu O, type X
            return MapRepository.findByCityDoAndSiGunGu(cityDo, siGunGu);
        } else if (type != null && !type.isEmpty() && (siGunGu == null || siGunGu.isEmpty())) {
            // type O, siGunGu X
            return MapRepository.findByCityDoAndType(cityDo, type);
        } else {
            // 두 조건 모두 제공된 경우
            return MapRepository.findByCityDoAndSiGunGuAndType(cityDo, siGunGu, type);
        }
    }

    // 4. 내 위치 기준
    public List<MapVO> getBooksByMe(Double latitude, Double longitude, String type) {
        return mapper.selectNearbyMe(latitude, longitude, type);
    }
}
