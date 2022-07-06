package br.com.gvp.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gvp.forum.controller.dto.TopicoDTO;
import br.com.gvp.forum.modelo.Topico;
import br.com.gvp.forum.repository.TopicoRepository;

@RestController
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDTO> lista() {
		
		List<Topico> topicos = topicoRepository.findAll();
		
		return TopicoDTO.conversor(topicos);
	}
}
