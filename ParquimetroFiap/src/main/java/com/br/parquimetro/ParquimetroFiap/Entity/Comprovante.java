package com.br.parquimetro.ParquimetroFiap.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comprovante {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticket;
    private String modelo;
    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private BigDecimal valor;


    public Comprovante(Resgister resgister, BigDecimal valor){

        this.modelo = resgister.getModelo();
        this.placa = resgister.getPlaca();
        this.entrada = resgister.getEntrada();
        this.saida = resgister.getSaida();
        this.valor = valor;
    }


}
