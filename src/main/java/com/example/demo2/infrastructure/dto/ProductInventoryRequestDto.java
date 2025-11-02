package com.example.demo2.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventoryRequestDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private String category;

    @JsonProperty("technicalDescription")
    private String technicalDescription;

    @JsonProperty("images")
    private List<String> images;

    @JsonProperty("stock")
    private Integer stock;
}
