package com.challenge.pharmainc.model.random;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserResult {
    private String gender;
    private RandomUserResultName name;
    private RandomUserResultLocation location;
    private String email;
    private RandomUserResultLogin login;
    private RandomUserResultDob dob;
    private RandomUserResultRegistered registered;
    private String phone;
    private String cell;
    private RandomUserResultId id;
    private RandomUserResultPicture picture;
    private String nat;
}
