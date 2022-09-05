package com.generation.todolist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Tarefa> getById(@PathVariable Long id) {
		return tarefaRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
    
    /**
     * Exercícios Plataforma
     */

    @GetMapping
	public ResponseEntity<List<Tarefa>> getAll() {
		return ResponseEntity.ok(tarefaRepository.findAll());

	}

    @GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tarefa>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(tarefaRepository.findAllByNomeContainingIgnoreCase(nome));
	}

    @PutMapping
	public ResponseEntity<Tarefa> putTema(@Valid @RequestBody Tarefa tarefa) {
					
		return tarefaRepository.findById(tarefa.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(tarefaRepository.save(tarefa));
				})
				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable Long id) {
		
		return tarefaRepository.findById(id)
				.map(resposta -> {
					tarefaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}

