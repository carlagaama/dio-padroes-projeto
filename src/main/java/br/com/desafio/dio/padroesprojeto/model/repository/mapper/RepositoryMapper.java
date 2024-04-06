package br.com.desafio.dio.padroesprojeto.model.repository.mapper;

import br.com.desafio.dio.padroesprojeto.model.domain.Evento;
import br.com.desafio.dio.padroesprojeto.model.domain.enums.TipoEventoEnum;
import br.com.desafio.dio.padroesprojeto.model.entity.EventoEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepositoryMapper {
    RepositoryMapper INSTANCE = Mappers.getMapper(RepositoryMapper.class);

    @Mapping(target = "endereco", source = "presencial.endereco")
    @Mapping(target = "tipoEvento", ignore = true)
    EventoEntity mapFrom(Evento evento);

    @Mapping(target = "presencial.endereco", source = "endereco")
    Evento mapFrom(EventoEntity entity);


    @AfterMapping
    default void mapTipoEventoToEntity(@MappingTarget EventoEntity target, Evento source) {
        target.setTipoEvento(source.getTipoEvento().name());
    }

    @AfterMapping
    default void mapTipoEventoToDomain(@MappingTarget Evento target, EventoEntity source) {
        target.setTipoEvento(TipoEventoEnum.valueOf(source.getTipoEvento()));
    }
}
