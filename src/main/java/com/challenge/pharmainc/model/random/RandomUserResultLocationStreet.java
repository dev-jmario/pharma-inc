package com.challenge.pharmainc.model.random;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserResultLocationStreet {
    private Integer number;
    private String name;
}
