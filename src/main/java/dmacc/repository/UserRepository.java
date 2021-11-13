/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.User;

/**
 * @author Andrew Pierce - ajpierce1
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}
