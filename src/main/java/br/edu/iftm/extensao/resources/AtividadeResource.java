package br.edu.iftm.extensao.resources;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.extensao.domain.Atividade;
import br.edu.iftm.extensao.services.AtividadeService;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeResource {

	@Autowired
	private AtividadeService service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		try {
			Atividade atividade = service.buscar(id);
			return ResponseEntity.ok(atividade);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
