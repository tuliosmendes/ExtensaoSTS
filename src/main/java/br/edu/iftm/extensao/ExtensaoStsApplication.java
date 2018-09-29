package br.edu.iftm.extensao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.extensao.domain.Atividade;
import br.edu.iftm.extensao.repositories.AtividadeRepository;

@SpringBootApplication
public class ExtensaoStsApplication implements CommandLineRunner {

	@Autowired
	private AtividadeRepository repositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(ExtensaoStsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Atividade a1 = new Atividade();
		a1.setNome("Simpos");
		repositorio.save(a1);
	}
}
