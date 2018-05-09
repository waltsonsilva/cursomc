package mcagile.com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mcagile.com.domain.Cliente;
import mcagile.com.repositories.ClienteRepository;
import mcagile.com.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objetod não encontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));

	}

}
