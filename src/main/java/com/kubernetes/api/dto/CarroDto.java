package com.kubernetes.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode()
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarroDto {

    private Long id;
    private String marca;
    private String modelo;

}
