package br.edu.iftm.extensao.resources;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder
public class AtividadeResourceTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void testa01IdSucesso() throws Exception {
		this.mvc.perform(get("/atividades/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("nome", is("Visita Tecnica GDG 2018")));
	}
	
	@Test
	public void testa02IdFalha() throws Exception {
		this.mvc.perform(get("/atividades/10"))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void testa03DeleteSucesso() throws Exception {
		this.mvc.perform(delete("/atividades/1"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("1")));
	}
	
	@Test
	public void testa04DeleteFalha() throws Exception {
		this.mvc.perform(delete("/atividades/10"))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void testa05SalvarSucesso() throws Exception {
		this.mvc.perform(post("/atividades")
				.content("{\"nome\": \"Evento\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(header().string("Location", is("http://localhost/atividades/3")))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testa06SalvarFalha() throws Exception {
		this.mvc.perform(post("/atividades")
				.content("{\"nomne\": \"Evento\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest())
				.andDo(MockMvcResultHandlers.print());
	}
}
