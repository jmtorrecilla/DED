package edu.uoc.ds.adt.model;

public record WeatherStationDataSummaryItem(double accumulatedPrecipitation,
                                            double meanAvgAirTemperature,
                                            int numRows) {

    public double getAccumulatedPrecipitation() {
        return accumulatedPrecipitation;
    }

    public double getMeanAvgAirTemperature() {
        return meanAvgAirTemperature;
    }
}