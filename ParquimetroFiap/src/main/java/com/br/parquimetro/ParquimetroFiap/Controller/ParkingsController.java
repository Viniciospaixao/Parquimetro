package com.br.parquimetro.ParquimetroFiap.Controller;

import com.br.parquimetro.ParquimetroFiap.Dto.ResgisterDTO;
import com.br.parquimetro.ParquimetroFiap.Entity.Comprovante;
import com.br.parquimetro.ParquimetroFiap.Entity.Resgister;
import com.br.parquimetro.ParquimetroFiap.Service.ResgisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/parkings")
public class ParkingsController {
    @Autowired
    private ResgisterService resgisterService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/entrada")
    public Resgister register(@RequestBody ResgisterDTO resgisterDTO){

       return resgisterService.entrada(resgisterDTO);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public Resgister BuscarVeiculo(@RequestBody String placa ){

        return resgisterService.buscaVeiculo(placa);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/saida")
    public Comprovante saida(@RequestBody Long placa ){

        return resgisterService.saida(placa);

    }
}
