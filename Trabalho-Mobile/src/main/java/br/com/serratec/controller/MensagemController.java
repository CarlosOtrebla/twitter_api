package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Mensagem;
import br.com.serratec.service.MensagemService;

@RestController
@RequestMapping("/post")
public class MensagemController {

	@Autowired
	private MensagemService service;
	
	@PostMapping
	public ResponseEntity<Mensagem> mensagem(@RequestBody Mensagem mensagem)throws Exception {
		Mensagem novoPost = service.mensagem(mensagem);
		return new ResponseEntity<>(novoPost, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Mensagem> listarMensagem() {
		return service.listarMensagem();
	}
	
}
