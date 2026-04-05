package com.ems.dto.responsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleApiResponse {
    private boolean success;
    private String message;
}
