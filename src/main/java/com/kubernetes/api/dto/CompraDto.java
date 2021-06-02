package com.kubernetes.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode()
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraDto {

    private Long id;
    private Long idCarro;
    private BigDecimal valorTotal;

}
