package br.com.desafio.dio.padroesprojeto.model.entity;

import br.com.desafio.dio.padroesprojeto.model.domain.enums.TipoEventoEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity(name = "eventos")
public class EventoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String descricao;
    private LocalDateTime horario;
    private String tipoEvento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "remoto_id", referencedColumnName = "id")
    private EventoRemotoEntity remoto;

    private LocalDateTime dataHoraInclusao = LocalDateTime.now();
}
