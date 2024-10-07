package com.mindHub.waveCenter.DTO;

import java.util.List;

public record RentStandApliDTO(long enventId, List<Integer> positions, String name, String description) {
}
