package com.algamoney.api.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algamoney.api.event.RecursoCriadoEvent;
import com.algamoney.api.model.Categoria;
import com.algamoney.api.repository.CategoriaRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Categoria> categorias(){
		
		return categoriaRepository.findAll();
	}
	
	@ApiOperation(value="Cadastra Nova Entidade Categoria", 
			response=ResponseEntity.class, 
			notes="Essa operação salva informações para uma nova entidade Categoria.")
	@ApiResponses(value= {
			@ApiResponse(code=201, message="Restorna um ResponseEntity com o Status 201 CREATED")
	})
	@PostMapping
	public ResponseEntity<Categoria> nova(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
		
		Categoria categoriaNova = categoriaRepository.save(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaNova.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaNova);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> categoriaPorCodigo(@PathVariable Long codigo) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		
		if(categoria.isPresent()) {
			
			return ResponseEntity.ok(categoria.get());
		}
		
		return ResponseEntity.notFound().build();
	}
}
