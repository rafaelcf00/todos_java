package com.example.todo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.model.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
