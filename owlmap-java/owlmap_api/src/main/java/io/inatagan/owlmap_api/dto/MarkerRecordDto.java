package io.inatagan.owlmap_api.dto;

public record MarkerRecordDto(Long userId, String name, String longitude, String latitude) {
    public MarkerRecordDto(Long userId, String name, String longitude, String latitude) {
        this.userId = userId;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
