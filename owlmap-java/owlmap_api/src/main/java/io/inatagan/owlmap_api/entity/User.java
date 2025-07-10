package io.inatagan.owlmap_api.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a USER entity in the application.
 */

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String email;

	@NotBlank
	private String password;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private final Set<Marker> marker = new HashSet<>();

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private final Set<MediaFile> mediaFile = new HashSet<>();
}
/*
Example JSON for inserting a User (excluding id, marker, and mediaFile, which are managed by the system):

{
	"name": "John Doe",
	"email": "john.doe@example.com",
	"password": "securePassword123"
}
*/