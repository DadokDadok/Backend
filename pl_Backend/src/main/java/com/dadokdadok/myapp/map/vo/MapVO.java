package com.dadokdadok.myapp.map.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booksinfo")
public class MapVO {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    private String cityDo;
    private String siGunGu;
    private String address;
    private String tel;
    private Double latitude;
    private Double longitude;
    private String homepage;
    private String closed;
    private String open;
    private String description;
    private String img;
    private String tag;

}
