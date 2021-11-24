package com.challenge.pharmainc.model.random;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomUser {
    private List<RandomUserResult> results;
    private RandomUserInfo info;
}
