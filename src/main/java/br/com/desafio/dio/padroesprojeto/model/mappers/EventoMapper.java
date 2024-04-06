package br.com.desafio.dio.padroesprojeto.model.mappers;

import br.com.desafio.dio.padroesprojeto.model.domain.Endereco;
import br.com.desafio.dio.padroesprojeto.model.domain.Evento;
import br.com.desafio.dio.padroesprojeto.model.domain.EventoPresencial;
import br.com.desafio.dio.padroesprojeto.model.domain.EventoRemoto;
import br.com.desafio.dio.padroesprojeto.model.domain.enums.TipoEventoEnum;
import br.com.desafio.dio.padroesprojeto.model.dto.request.EventoRequest;
import br.com.desafio.dio.padroesprojeto.service.client.EnderecoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface EventoMapper {
    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);


    default Endereco mapFrom(EnderecoResponse response, @MappingTarget Endereco target) {
        target.setLogradouro(response.getLogradouro());
        target.setBairro(response.getBairro());
        target.setUf(response.getUf());
        target.setLocalidade(response.getLocalidade());
        return target;

    }

    default Evento mapFrom(EventoRequest request) {
        EventoRemoto eventoRemoto = null;
        EventoPresencial eventoPresencial = null;
        Evento evento = Evento.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .horario(request.getHorario())
                .build();

        if (request.isIndicadorEventoRemoto()) {
            eventoRemoto = buildEventoRemoto(request);
            evento.setTipoEvento(TipoEventoEnum.REMOTO);
        } else {
            eventoPresencial = buildEventoPresencial(request);
            evento.setTipoEvento(TipoEventoEnum.PRESENCIAL);
        }


        evento.setPresencial(eventoPresencial);
        evento.setRemoto(eventoRemoto);

        return evento;
    }

    @Mapping(target = "clima", ignore = true)
    EventoPresencial buildEventoPresencial(EventoRequest evento);


    EventoRemoto buildEventoRemoto(EventoRequest request);

}
