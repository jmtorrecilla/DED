package edu.uoc.ds.adt;

import edu.uoc.ds.adt.model.WeatherStationData;
import edu.uoc.ds.adt.model.WeatherStationDataSummaryItem;
import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

public class PR1WeatherStationDataQueue {

    private final int capacity;
    private final int[] years;

    private final double[] sumPrecipitationByYear;
    private final double[] sumAvgTempByYear;
    private final int[] countByYear;

    private Queue<WeatherStationData> queue;

    private double totalPrecipitation;
    private double totalAvgTemp;
    private int totalCount;

    public PR1WeatherStationDataQueue(int capacity, int[] years) {
        this.capacity = capacity;
        this.years = years;

        this.sumPrecipitationByYear = new double[years.length];
        this.sumAvgTempByYear = new double[years.length];
        this.countByYear = new int[years.length];

        newQueue();
    }

    public void newQueue() {
        this.queue = new QueueArrayImpl<>(capacity);

        this.totalPrecipitation = 0.0;
        this.totalAvgTemp = 0.0;
        this.totalCount = 0;

        for (int i = 0; i < years.length; i++) {
            sumPrecipitationByYear[i] = 0.0;
            sumAvgTempByYear[i] = 0.0;
            countByYear[i] = 0;
        }
    }

    public Queue<WeatherStationData> getQueue() {
        return queue;
    }

    public void add(WeatherStationData data) {
        queue.add(data);

        // global
        totalPrecipitation += data.getPrecipitation();
        totalAvgTemp += data.getAvgAirTemperature();
        totalCount++;

        // por año
        int year = data.getLastUpdated().getYear();
        int idx = indexOfYear(year);
        if (idx >= 0) {
            sumPrecipitationByYear[idx] += data.getPrecipitation();
            sumAvgTempByYear[idx] += data.getAvgAirTemperature();
            countByYear[idx]++;
        }
    }

    public double getMeanPrecipitation() {
        return totalCount == 0 ? 0.0 : totalPrecipitation / totalCount;
    }

    public double getMeanAvgAirTemperature() {
        return totalCount == 0 ? 0.0 : totalAvgTemp / totalCount;
    }

    public WeatherStationDataSummaryItem getWeatherStationDataSumaryItem(int year) {
        int idx = indexOfYear(year);
        if (idx < 0 || countByYear[idx] == 0) {
            return new WeatherStationDataSummaryItem(0.0, 0.0, 0);
        }

        double accumulated = sumPrecipitationByYear[idx];
        double meanTemp = sumAvgTempByYear[idx] / countByYear[idx];
        int rows = countByYear[idx];

        return new WeatherStationDataSummaryItem(accumulated, meanTemp, rows);
    }

    private int indexOfYear(int year) {
        for (int i = 0; i < years.length; i++) {
            if (years[i] == year) return i;
        }
        return -1;
    }
}