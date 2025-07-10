package io.inatagan.owlmap_api.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MARKERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// private Long userId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_userId")
	private User user;

	private String name;

	private String longitude;

	private String latitude;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "marker", fetch = FetchType.LAZY)
	private final Set<MediaFile> mediaFiles = new HashSet<>();
}
/*
Example JSON for inserting a Marker entity:

{
	"user": {
		"id": 1
	},
	"name": "Sample Marker",
	"longitude": "34.0522",
	"latitude": "-118.2437"
}

Note: 
- The "mediaFiles" field is write-only and should not be included in the insert JSON.
- The "user" object should reference an existing user by id.
- "id" is auto-generated and should not be provided.
*/