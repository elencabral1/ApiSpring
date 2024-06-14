package br.com.consoletech.application.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "users")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	@Column( unique = true, length = 100 )
	private String username;
	@Column( unique = true, length = 120 )
	private String email;
	@Column(columnDefinition = "boolean default false")
	private Boolean active;
	private String password;
	private Instant created;
	private Instant updated;
	
	@ManyToMany
	private List<Group> groups;
	
	public User() {
		
	}

	public User(Long id, String username, String email, Boolean active, String password, Instant created,
			Instant updated) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.active = active;
		this.password = password;
		this.created = created;
		this.updated = updated;
	}
	
	


	public User(Long id, String username, String email, Boolean active, String password, Instant created,
			Instant updated, List<Group> groups) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.active = active;
		this.password = password;
		this.created = created;
		this.updated = updated;
		this.groups = groups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getUpdated() {
		return updated;
	}

	public void setUpdated(Instant updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", active=" + active + ", created="
				+ created + ", updated=" + updated + "]";
	}
	
	
}
