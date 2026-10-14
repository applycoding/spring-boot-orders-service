package com.applycoding.orders;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record Order(Long id, @NotBlank String item, @Min(1) int quantity) {}
