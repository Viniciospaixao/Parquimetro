package com.br.parquimetro.ParquimetroFiap.Dto;

import com.br.parquimetro.ParquimetroFiap.Enums.Status;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

public record ResgisterDTO (String modelo, String placa, LocalDateTime entrada, LocalDateTime saida, Status status){
}
