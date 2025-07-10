package io.inatagan.owlmap_api.dto;

import java.util.Set;

public record MarkerRecordDto(Set<Long> userId, String name, String longitude, String latitude) {

    public MarkerRecordDto(Set<Long> userId, String name, String longitude, String latitude) {
        this.userId = userId;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
