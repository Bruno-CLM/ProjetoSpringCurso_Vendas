package io.github.brunoclm.model;

import java.util.Objects;
import java.util.UUID;

public class Client {
	
	private String uuid = UUID.randomUUID().toString();
	
	private String nome;
	
	private String email;
	
	public String getUuid() {
		return uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(uuid, other.uuid);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
