package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.model.entity.Tarefa;

@Service
public interface TarefaService {

    Tarefa salvar(Tarefa tarefa);
    
    Tarefa atualizar(Tarefa tarefa);
    
    void deletar(Long id);
}