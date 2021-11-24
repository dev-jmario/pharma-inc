package com.challenge.pharmainc.model.random;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserResultDob {
    private LocalDateTime date;
    private Integer age;
}
