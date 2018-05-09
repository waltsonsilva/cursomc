package mcagile.com;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mcagile.com.domain.Categoria;
import mcagile.com.domain.Cidade;
import mcagile.com.domain.Estado;
import mcagile.com.domain.Produto;
import mcagile.com.repositories.CategoriaRepository;
import mcagile.com.repositories.CidadeRepository;
import mcagile.com.repositories.EstadoRepository;
import mcagile.com.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 90.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null,"Pernambuco");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade ci1 = new Cidade(null, "Recife", est1);
		Cidade ci2 = new Cidade(null, "São Paulo", est2);
		Cidade ci3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(ci1));
		est2.getCidades().addAll(Arrays.asList(ci2,ci3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(ci1,ci2,ci3));
		
	}

}
