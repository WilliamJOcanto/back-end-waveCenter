package com.mindHub.waveCenter.DTO;

import java.time.LocalDate;

public record AddCardDTO(String cardHolder, String number, Integer cvv, LocalDate thruDate, String cardType, String paymentNetwork) {
}
