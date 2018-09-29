package br.edu.iftm.extensao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.iftm.extensao.domain.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

	//@Query("Select a from Atividade a where a.nome like %:nome%")
	public List<Atividade> findByNomeContaining(@Param("nome") String nome);
}
