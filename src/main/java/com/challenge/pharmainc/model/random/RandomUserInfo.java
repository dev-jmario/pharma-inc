package com.challenge.pharmainc.model.random;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserInfo {
    private String seed;
    private Integer results;
    private Integer page;
    private String version;
}
