package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Mensagem;
import br.com.serratec.repository.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository repository;
	
	public Mensagem mensagem(Mensagem mensagem) {

		Mensagem m = new Mensagem();
		m.setMensagem(mensagem.getMensagem());
		m.setNomeUsuario(mensagem.getNomeUsuario());
		
		repository.save(m);
		return new Mensagem(m);
	}
	
	public List<Mensagem> listarMensagem() {
        return repository.findAll();
    }
 
}
