package com.challenge.pharmainc.model.random;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserResultLocation {
    private RandomUserResultLocationStreet street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private RandomUserResultLocationCoordinates coordinates;
    private RandomUserResultLocationTimezone timezone;
}
