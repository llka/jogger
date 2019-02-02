package ru.ilka.jogger.dto;

public class WorkoutAverageReportDTO {

    private PeriodDTO period;

    private double averageSpeedKmH;
    private double averageWorkoutTimeLengthInMin;
    private double averageDistanceInKm;
    private double totalDistanceInKm;

    public PeriodDTO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodDTO period) {
        this.period = period;
    }

    public double getAverageSpeedKmH() {
        return averageSpeedKmH;
    }

    public void setAverageSpeedKmH(double averageSpeedKmH) {
        this.averageSpeedKmH = averageSpeedKmH;
    }

    public double getAverageWorkoutTimeLengthInMin() {
        return averageWorkoutTimeLengthInMin;
    }

    public void setAverageWorkoutTimeLengthInMin(double averageWorkoutTimeLengthInMin) {
        this.averageWorkoutTimeLengthInMin = averageWorkoutTimeLengthInMin;
    }

    public double getAverageDistanceInKm() {
        return averageDistanceInKm;
    }

    public void setAverageDistanceInKm(double averageDistanceInKm) {
        this.averageDistanceInKm = averageDistanceInKm;
    }

    public double getTotalDistanceInKm() {
        return totalDistanceInKm;
    }

    public void setTotalDistanceInKm(double totalDistanceInKm) {
        this.totalDistanceInKm = totalDistanceInKm;
    }
}
