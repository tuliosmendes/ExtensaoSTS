package br.edu.iftm.extensao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.extensao.domain.Atividade;
import br.edu.iftm.extensao.repositories.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository repositorio;

	public Atividade buscar(Integer id) {
		Atividade atividade = repositorio.findById(id).get();
		return atividade;
	}
}
