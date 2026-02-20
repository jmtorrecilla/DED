package edu.uoc.ds.adt.model;

import java.time.LocalDateTime;

public class WeatherStationData {
    private final LocalDateTime lastUpdated;
    private final String stationName;
    private final String province;
    private final double longitude;
    private final double latitude;
    private final double avgAirTemperature;
    private final double precipitation;
    private final double minAirTemperature;
    private final double maxAirTemperature;

    public WeatherStationData(LocalDateTime lastUpdated,
                              String stationName,
                              String province,
                              double longitude,
                              double latitude,
                              double avgAirTemperature,
                              double precipitation,
                              double minAirTemperature,
                              double maxAirTemperature) {
        this.lastUpdated = lastUpdated;
        this.stationName = stationName;
        this.province = province;
        this.longitude = longitude;
        this.latitude = latitude;
        this.avgAirTemperature = avgAirTemperature;
        this.precipitation = precipitation;
        this.minAirTemperature = minAirTemperature;
        this.maxAirTemperature = maxAirTemperature;
    }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public String getStationName() { return stationName; }
    public String getProvince() { return province; }
    public double getLongitude() { return longitude; }
    public double getLatitude() { return latitude; }
    public double getAvgAirTemperature() { return avgAirTemperature; }
    public double getPrecipitation() { return precipitation; }
    public double getMinAirTemperature() { return minAirTemperature; }
    public double getMaxAirTemperature() { return maxAirTemperature; }
}