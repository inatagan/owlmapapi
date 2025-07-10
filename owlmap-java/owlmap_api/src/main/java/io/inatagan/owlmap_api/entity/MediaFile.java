package io.inatagan.owlmap_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MEDIAFILES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // private Long userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_userId")
    private User user;
    
    // private Long markerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_markerId")
    private Marker marker;
    
    private String mediaType;
    
    private String mediaUrl;
    
    private String createdAt;
    
    private String updatedAt;
}
