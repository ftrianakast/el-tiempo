package co.eltiempo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import co.eltiempo.domain.User;

@Transactional
public interface ClientRepository extends CrudRepository<User, Long> {

	public User findUserByEmailAndPassword(String email, String password);

}
