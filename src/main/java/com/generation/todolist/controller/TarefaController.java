package com.generation.todolist.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.todolist.model.Tarefa;
import com.generation.todolist.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TarefaController {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@PostMapping
	public ResponseEntity<Tarefa> post(@Valid @RequestBody Tarefa tarefa){
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefa));
	}
	
    @GetMapping("/{id}")
	public ResponseEntity<Optional<Tarefa>> getById(@PathVariable Long id) {
		Optional <Tarefa> buscaTarefa = tarefaRepository.findById(id);
		
		if(buscaTarefa.isPresent())
			return ResponseEntity.ok(buscaTarefa);
		else
			return ResponseEntity.notFound().build();
		
	}
    
}

