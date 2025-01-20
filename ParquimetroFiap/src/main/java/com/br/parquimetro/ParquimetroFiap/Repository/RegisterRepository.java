package com.br.parquimetro.ParquimetroFiap.Repository;


import com.br.parquimetro.ParquimetroFiap.Entity.Resgister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface RegisterRepository extends JpaRepository<Resgister,Long> {
    @Query(value = "SELECT * FROM resgister WHERE placa = ?1", nativeQuery = true)
    Resgister buscarVeiculoPlaca(@Param("placa") String placa);
    Resgister findByPlaca(String placa);


}
