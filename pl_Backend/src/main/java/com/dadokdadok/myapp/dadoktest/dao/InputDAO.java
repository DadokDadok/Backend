package com.dadokdadok.myapp.dadoktest.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InputDAO {

//    select, insert, update, delete

    String findInput(@Param("output") String output);
    void addInput(@Param("output") String output);
    void updateInput(@Param("output") String output);
    void deleteInput(@Param("output") String output);


}