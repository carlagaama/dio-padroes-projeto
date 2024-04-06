package br.com.desafio.dio.padroesprojeto.model.repository;

import br.com.desafio.dio.padroesprojeto.model.entity.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<EventoEntity, UUID> {
}
