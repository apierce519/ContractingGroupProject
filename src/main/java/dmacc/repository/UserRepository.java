/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.model.User;

/**
 * @author Andrew Pierce - ajpierce1
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<dmacc.model.User> findByUsername(String username);

}
