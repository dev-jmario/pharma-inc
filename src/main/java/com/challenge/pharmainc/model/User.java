package com.challenge.pharmainc.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String gender;
    private String nameTitle;
    private String nameFirst;
    private String nameLast;
    private Integer locationStreetNumber;
    private String locationStreetName;
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private String locationPostcode;
    private BigDecimal locationCoordinatesLatitude;
    private BigDecimal locationCoordinatesLongitude;
    private String locationTimezoneOffset;
    private String locationTimezoneDescription;
    private String email;
    private UUID loginUuid;
    private String loginUsername;
    private String loginPassword;
    private String loginSalt;
    private String loginMd5;
    private String loginSha1;
    private String loginSha256;
    private LocalDateTime dobDate;
    private Integer dobAge;
    private LocalDateTime registeredDate;
    private Integer registeredAge;
    private String phone;
    private String cell;
    private String idName;
    private String idValue;
    private String pictureLarge;
    private String pictureMedium;
    private String pictureThumbnail;
    private String nat;

    private Integer status;
    private LocalDateTime imported_t;
}
