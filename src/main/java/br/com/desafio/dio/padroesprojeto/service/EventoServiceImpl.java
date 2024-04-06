package br.com.desafio.dio.padroesprojeto.service;

import br.com.desafio.dio.padroesprojeto.model.domain.Endereco;
import br.com.desafio.dio.padroesprojeto.model.domain.enums.TipoEventoEnum;
import br.com.desafio.dio.padroesprojeto.model.entity.EventoEntity;
import br.com.desafio.dio.padroesprojeto.model.mappers.EventoMapper;
import br.com.desafio.dio.padroesprojeto.model.repository.EventoRepository;
import br.com.desafio.dio.padroesprojeto.model.domain.Evento;
import br.com.desafio.dio.padroesprojeto.model.repository.mapper.RepositoryMapper;
import br.com.desafio.dio.padroesprojeto.service.client.EnderecoResponse;
import br.com.desafio.dio.padroesprojeto.service.client.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoRepository repository;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Evento cadastrarEvento(Evento evento) {

        if(evento.getTipoEvento().equals(TipoEventoEnum.REMOTO)) {
            EventoEntity toSave = RepositoryMapper.INSTANCE.mapFrom(evento);
            repository.save(toSave);
            return RepositoryMapper.INSTANCE.mapFrom(toSave);
        } else {
            enriquecerEndereco(evento);
            //TODO integrar com API de clima
            EventoEntity toSave = RepositoryMapper.INSTANCE.mapFrom(evento);
            repository.save(toSave);
            return RepositoryMapper.INSTANCE.mapFrom(toSave);
        }
    }

    private void enriquecerEndereco(Evento evento) {
        Endereco endereco = evento.getPresencial().getEndereco();
        EnderecoResponse enderecoComplementar = enderecoService.consultarCep(evento.getPresencial().getEndereco().getCep());
        evento.getPresencial().setEndereco(EventoMapper.INSTANCE.mapFrom(enderecoComplementar, endereco));
    }
}
