package com.example.todo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.model.entity.Tarefa;
import com.example.todo.model.repository.TarefaRepository;
import com.example.todo.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {
    
    private TarefaRepository repository;
    
    @Autowired
    public TarefaServiceImpl(TarefaRepository repository) {
        super();
        this.repository = repository;
    }
    
    @Override
    @Transactional
    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @Override
    @Transactional
    public Tarefa atualizar(Tarefa tarefa) {

        if (!repository.existsById(tarefa.getId())) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        return repository.save(tarefa); 
    }

    @Override
    @Transactional
    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }
}
