package com.br.parquimetro.ParquimetroFiap.Entity;

import com.br.parquimetro.ParquimetroFiap.Dto.ResgisterDTO;
import com.br.parquimetro.ParquimetroFiap.Enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Resgister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String modelo;
    private String placa;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Status status;

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }
    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getEntrada() {
        return this.entrada;
    }
    public LocalDateTime getSaida() {
        return this.saida;
    }
    public String getModelo() {
        return this.modelo;
    }
    public String getPlaca() {
        return this.placa;
    }

    public void ResgisterConverter(ResgisterDTO resgisterDTO){

        this.modelo = resgisterDTO.modelo();
        this.placa = resgisterDTO.placa();
        this.entrada =  resgisterDTO.entrada();
        this.saida  =  resgisterDTO.saida();
        this.status = resgisterDTO.status();

    }

}
