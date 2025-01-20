package com.br.parquimetro.ParquimetroFiap.Repository;

import com.br.parquimetro.ParquimetroFiap.Entity.Comprovante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComprovanteRepository extends JpaRepository<Comprovante, UUID> {
}
