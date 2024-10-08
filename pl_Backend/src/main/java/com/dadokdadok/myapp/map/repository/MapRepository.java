package com.dadokdadok.myapp.map.repository;

import com.dadokdadok.myapp.map.vo.MapVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapRepository extends JpaRepository<MapVO, Long> {
    /**
     * 1. 도서관 or 서점 or 문화공간 하나 조회(모달용)
     * 2. 지역별 조회(타입 상관 없이)
     * 3. 지역별 도서관만 or 서점만 or 문화공간만 목록 조회
     * 4. 태그로 조회 - 보류(태그가 너무 많음)
     */

    Optional<MapVO> findById(Long id);

    List<MapVO> findByCityDoAndSiGunGuAndType(String cityDo, String siGunGu, String type);
    List<MapVO> findByCityDoAndSiGunGu(String cityDo, String siGunGu);
    List<MapVO> findByCityDoAndType(String cityDo, String type);
    List<MapVO> findByCityDo(String cityDo);


}
