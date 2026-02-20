package edu.uoc.ds.adt;

import edu.uoc.ds.adt.model.WeatherStationData;
import edu.uoc.ds.adt.model.WeatherStationDataSummaryItem;
import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;

import edu.uoc.ds.traversal.Iterator;

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
        return this.queue;
    }

    public void add(WeatherStationData data) {
        if (data == null) return;

        queue.add(data);

        // Global acumulado
        totalPrecipitation += data.getPrecipitation();
        totalAvgTemp += data.getAvgAirTemperature();
        totalCount++;

        // Por año
        int year = data.getLastUpdated().getYear();
        int idx = indexOfYear(year);

        if (idx != -1) {
            sumPrecipitationByYear[idx] += data.getPrecipitation();
            sumAvgTempByYear[idx] += data.getAvgAirTemperature();
            countByYear[idx]++;
        }
    }

    public double getMeanPrecipitation() {
        if (totalCount == 0) return 0.0;
        return totalPrecipitation / (double) totalCount;
    }

    public double getMeanAvgAirTemperature() {
        if (totalCount == 0) return 0.0;
        return totalAvgTemp / (double) totalCount;
    }

    public WeatherStationDataSummaryItem getWeatherStationDataSummaryByYear(int year) {
        int idx = indexOfYear(year);
        if (idx == -1 || countByYear[idx] == 0) return null;

        double accumulatedPrecipitation = sumPrecipitationByYear[idx];
        double meanAvgAirTemperature = sumAvgTempByYear[idx] / (double) countByYear[idx];
        int rows = countByYear[idx];

        // Cambiado
        return new WeatherStationDataSummaryItem(accumulatedPrecipitation, meanAvgAirTemperature, rows);
    }

    /**
     * Si el test te obliga a calcular recorriendo la cola con iterador (como sugiere el enunciado),
     * aquí tienes un ejemplo auxiliar opcional.
     */
    public double computeMeanPrecipitationByIteratingQueue() {
        if (queue == null || queue.size() == 0) return 0.0;

        double sum = 0.0;
        int count = 0;

        Iterator<WeatherStationData> it = queue.values();
        while (it.hasNext()) {
            WeatherStationData d = it.next();
            sum += d.getPrecipitation();
            count++;
        }
        return count == 0 ? 0.0 : sum / (double) count;
    }

    // Método para el test
    public WeatherStationDataSummaryItem getWeatherStationDataSumaryItem(int year) {
        int idx = indexOfYear(year);
        if (idx == -1 || countByYear[idx] == 0) return null;

        double accumulatedPrecipitation = sumPrecipitationByYear[idx];
        double meanAvgAirTemperature = sumAvgTempByYear[idx] / (double) countByYear[idx];
        int rows = countByYear[idx];

        return new WeatherStationDataSummaryItem(accumulatedPrecipitation, meanAvgAirTemperature, rows);
    }

    private int indexOfYear(int year) {
        for (int i = 0; i < years.length; i++) {
            if (years[i] == year) return i;
        }
        return -1;
    }
}