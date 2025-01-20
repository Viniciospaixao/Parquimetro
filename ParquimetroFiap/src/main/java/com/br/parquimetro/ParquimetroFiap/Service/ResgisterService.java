package com.br.parquimetro.ParquimetroFiap.Service;

import com.br.parquimetro.ParquimetroFiap.Dto.ResgisterDTO;
import com.br.parquimetro.ParquimetroFiap.Entity.Comprovante;
import com.br.parquimetro.ParquimetroFiap.Entity.Resgister;
import com.br.parquimetro.ParquimetroFiap.Enums.Status;
import com.br.parquimetro.ParquimetroFiap.Repository.ComprovanteRepository;
import com.br.parquimetro.ParquimetroFiap.Repository.RegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;


@Service
@Slf4j
public class ResgisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private ComprovanteRepository comprovanteRepository;
    

    private Resgister veiculo;

    public Resgister entrada(ResgisterDTO resgisterDTO){

        ZoneId zonaSaoPaulo = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime agoraSaoPaulo = ZonedDateTime.now(zonaSaoPaulo);

        LocalDateTime dataHoraLocal = agoraSaoPaulo.toLocalDateTime();

        Resgister resgister = new Resgister();

        resgister.ResgisterConverter(resgisterDTO);

        resgister.setEntrada(dataHoraLocal);

        return registerRepository.save(resgister);
    }

    public Resgister buscaVeiculo(String placa) {
        return registerRepository.buscarVeiculoPlaca(placa);
    }

    public Comprovante saida(long id){
       Optional<Resgister> veiculo =  registerRepository.findById(id);

            Resgister veiculosave = veiculo.get();
            ZoneId zonaSaoPaulo = ZoneId.of("America/Sao_Paulo");

            ZonedDateTime agoraSaoPaulo = ZonedDateTime.now(zonaSaoPaulo);

            LocalDateTime dataHoraLocal = agoraSaoPaulo.toLocalDateTime();

            veiculosave.setSaida(dataHoraLocal);
            veiculosave.setStatus(Status.FINALIZADO);

            registerRepository.save(veiculosave);


            Long tempo = calcularTempoEstacionamento(veiculosave.getEntrada(), veiculosave.getSaida());

            BigDecimal valor = BigDecimal.valueOf(calcularValor(tempo));
            Comprovante comprovante = new Comprovante(veiculosave, valor);

        return comprovanteRepository.save(comprovante);
    }


    public long calcularTempoEstacionamento(LocalDateTime entrada, LocalDateTime saida) {
        Duration duracao = Duration.between(entrada, saida);
        return duracao.toMinutes(); // Retorna a duração em minutos
    }

    public  Double calcularValor(long minutosEstacionado) {
        double horasEstacionado = (double) minutosEstacionado / 60;
        return Math.ceil(horasEstacionado) * 15;
    }
}
