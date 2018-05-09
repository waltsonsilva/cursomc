package mcagile.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mcagile.com.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
