package com.example.todo.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.api.dto.TarefaDTO;
import com.example.todo.model.entity.Tarefa;
import com.example.todo.service.TarefaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaResource {

    private final TarefaService service;

    @Autowired
    public TarefaResource(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa) {
        Tarefa tarefaSalva = service.salvar(tarefa);
        return ResponseEntity.ok(tarefaSalva);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id); 
        Tarefa tarefaAtualizada = service.atualizar(tarefa);
        return ResponseEntity.ok(tarefaAtualizada);
    }
    
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
