/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 28, 2021
 */
package dmacc.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Andrew Pierce - ajpierce1
 */
@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {

	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	private String roles;

	public MyUserDetails(String username) {
		this.username = username;
	}

	public MyUserDetails() {

	}

	/**
	 * @param user
	 */
	public MyUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		this.roles = user.getRoles();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

	/**
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}
}