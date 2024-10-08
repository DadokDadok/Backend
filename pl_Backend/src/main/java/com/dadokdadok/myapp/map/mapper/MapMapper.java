package com.dadokdadok.myapp.map.mapper;

import com.dadokdadok.myapp.map.vo.MapVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MapMapper {
    List<MapVO> selectNearbyMe(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("type") String type);
}
