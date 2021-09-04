package com.tornado.categorizePhoneNumbers.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponcePhoneNumbers {
    
    private int totalPages;
    private List<PhoneNumberDto> phoneNumbers;


}
