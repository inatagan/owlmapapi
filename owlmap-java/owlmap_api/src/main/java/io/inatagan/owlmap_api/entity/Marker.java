package io.inatagan.owlmap_api.entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Marker implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	private String name;
	
	private String longitude;
	
	private String latitude;

	@ManyToMany
	@JoinTable(
		name = "MARKER_TAGS",
		joinColumns = @JoinColumn(name = "marker_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<User> users = new HashSet<>();

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "marker", fetch = FetchType.LAZY)
	private final Set<MediaFile> mediaFiles = new HashSet<>();
}
/*
 Example JSON for inserting a Marker entity:
 
{
  "userId": [1],
  "name": "Sample Marker",
  "longitude": "34.0522",
  "latitude": "-118.2437"
}
 Note:
 - The "mediaFiles" field is write-only and should not be included in the
 insert JSON.
 - The "user" object should reference an existing user by id.
 - "id" is auto-generated and should not be provided.
 */