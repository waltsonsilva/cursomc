package mcagile.com;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mcagile.com.domain.Categoria;
import mcagile.com.domain.Cidade;
import mcagile.com.domain.Cliente;
import mcagile.com.domain.Endereco;
import mcagile.com.domain.Estado;
import mcagile.com.domain.Pagamento;
import mcagile.com.domain.PagamentoComBoleto;
import mcagile.com.domain.PagamentoComCartao;
import mcagile.com.domain.Pedido;
import mcagile.com.domain.Produto;
import mcagile.com.domain.enums.EstadoPagamento;
import mcagile.com.domain.enums.TipoCliente;
import mcagile.com.repositories.CategoriaRepository;
import mcagile.com.repositories.CidadeRepository;
import mcagile.com.repositories.ClienteRepository;
import mcagile.com.repositories.EnderecoRepository;
import mcagile.com.repositories.EstadoRepository;
import mcagile.com.repositories.PagamentoRepository;
import mcagile.com.repositories.PedidoRepository;
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

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

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

		Estado est1 = new Estado(null, "Pernambuco");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade ci1 = new Cidade(null, "Recife", est1);
		Cidade ci2 = new Cidade(null, "São Paulo", est2);
		Cidade ci3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(ci1));
		est2.getCidades().addAll(Arrays.asList(ci2, ci3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(ci1, ci2, ci3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "marial@gmail.com", "888888888", TipoCliente.PESSOAJURIDICA);

		cli1.getTelefones().addAll(Arrays.asList("123123213213", "993432423"));
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardias", "3113123213", cli1, ci1);
		Endereco e2 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardias", "3113123213", cli1, ci2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

	}

}
