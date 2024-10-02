package com.example.todo.model.repository;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.example.todo.model.entity.Tarefa;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TarefaRepositoryTest {

    @Autowired
    TarefaRepository repository;

    @Autowired
    TestEntityManager entityManager;
    
    @Test
    public void devePersistirUmaTarefaNaBaseDeDados() {
        Tarefa tarefa = criarTarefa();
        
        Tarefa tarefaSalva = repository.save(tarefa);
        
        Assertions.assertThat(tarefaSalva.getId()).isNotNull();
    }
    
    @Test
    public void deveAtualizarUmaTarefaNaBaseDeDados() {
        
        Tarefa tarefa = criarTarefa();
        Tarefa tarefaSalva = repository.save(tarefa);
        
    
        tarefaSalva.setNome("Tarefa Atualizada");
        tarefaSalva.setDescricao("Descrição Atualizada");
        
      
        Tarefa tarefaAtualizada = repository.save(tarefaSalva);
        
       
        Assertions.assertThat(tarefaAtualizada.getNome()).isEqualTo("Tarefa Atualizada");
        Assertions.assertThat(tarefaAtualizada.getDescricao()).isEqualTo("Descrição Atualizada");
    }

    @Test
    public void deveDeletarUmaTarefaNaBaseDeDados() {
       
        Tarefa tarefa = criarTarefa();
        Tarefa tarefaSalva = repository.save(tarefa);
        
      
        repository.delete(tarefaSalva);
        
    
        Optional<Tarefa> tarefaDeletada = repository.findById(tarefaSalva.getId());
        Assertions.assertThat(tarefaDeletada).isEmpty();
    }
    
    public static Tarefa criarTarefa() {
        return new Tarefa("Tarefa", "descricao tarefa", "observacao tarefa", "CONCLUIDO", LocalDate.now(), LocalDate.now());
    }
}
