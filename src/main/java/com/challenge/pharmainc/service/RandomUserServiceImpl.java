package com.challenge.pharmainc.service;

import com.challenge.pharmainc.model.StatusUser;
import com.challenge.pharmainc.model.User;
import com.challenge.pharmainc.model.random.RandomUser;
import com.challenge.pharmainc.model.random.RandomUserResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RandomUserServiceImpl implements RandomUserService {

    @Value("${spring.hosts.random-user}")
    private String host;

    @Value("${spring.hosts.random-perpage}")
    private Integer perPage;

    @Override
    public RandomUser importRandomUsers() {
        ResponseEntity<RandomUser> response = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForEntity(String.format("%s/?page=1&results=%d",host, perPage), RandomUser.class);
            if (response.getStatusCodeValue() != HttpStatus.OK.value())
                throw new Exception("error request random user");
        }catch (Exception e){
            e.printStackTrace();
        }

        return response.getBody();
    }

    @Override
    public List<User> convertRandomUser(RandomUser randomUser) {
        List<User> userList = new ArrayList<>();
        for (RandomUserResult result: randomUser.getResults()){

            userList.add(
                    User.builder()
                            .gender(result.getGender())
                            .nameTitle(result.getName().getTitle())
                            .nameFirst(result.getName().getFirst())
                            .nameLast(result.getName().getLast())
                            .locationStreetName(result.getLocation().getStreet().getName())
                            .locationStreetNumber(result.getLocation().getStreet().getNumber())
                            .locationCity(result.getLocation().getCity())
                            .locationState(result.getLocation().getState())
                            .locationCountry(result.getLocation().getCountry())
                            .locationPostcode(result.getLocation().getPostcode())
                            .locationCoordinatesLatitude(result.getLocation().getCoordinates().getLatitude())
                            .locationCoordinatesLongitude(result.getLocation().getCoordinates().getLongitude())
                            .locationTimezoneOffset(result.getLocation().getTimezone().getOffset())
                            .locationTimezoneDescription(result.getLocation().getTimezone().getDescription())
                            .email(result.getEmail())
                            .loginUuid(result.getLogin().getUuid())
                            .loginUsername(result.getLogin().getUsername())
                            .loginPassword(result.getLogin().getPassword())
                            .loginSalt(result.getLogin().getSalt())
                            .loginMd5(result.getLogin().getMd5())
                            .loginSha1(result.getLogin().getSha1())
                            .loginSha256(result.getLogin().getSha256())
                            .dobDate(result.getDob().getDate())
                            .dobAge(result.getDob().getAge())
                            .registeredDate(result.getRegistered().getDate())
                            .registeredAge(result.getRegistered().getAge())
                            .phone(result.getPhone())
                            .cell(result.getCell())
                            .idName(result.getId().getName())
                            .idValue(result.getId().getValue())
                            .pictureLarge(result.getPicture().getLarge())
                            .pictureMedium(result.getPicture().getMedium())
                            .pictureThumbnail(result.getPicture().getThumbnail())
                            .nat(result.getNat())
                            .imported_t(LocalDateTime.now())
                            .status(Integer.valueOf(StatusUser.STT_PUBLISHED.getId()))
                            .build()
            );
        }
        return userList;
    }
}
