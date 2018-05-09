package mcagile.com.domain;

import java.util.Date;

import mcagile.com.domain.enums.EstadoPagamento;

public class PagamentoComBoleto extends Pagamento {
	
	private Date dataVencimento;
	
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	
	
}
