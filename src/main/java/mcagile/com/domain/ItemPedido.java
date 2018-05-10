package mcagile.com.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private double desconto;
	
	private Integer quantidade;
	
	private double preco;
	@EmbeddedId
	private ItemPedidoPk id = new ItemPedidoPk();
	
	
	public ItemPedido() {
		
	}


	public ItemPedido(double desconto, Integer quantidade, double preco,  Pedido pedido,Produto produto) {
		super();
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
		id.setPedido(pedido);
		id.setProduto(produto);
	}

	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public double getDesconto() {
		return desconto;
	}


	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public ItemPedidoPk getId() {
		return id;
	}


	public void setId(ItemPedidoPk id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
