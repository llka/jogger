package ru.ilka.jogger.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;
import org.joda.time.Period;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "workout")
public class Workout implements DatabaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Positive
    private Long distanceInKm;

    @NotNull
    private Date startDateTime;

    @NotNull
    private Date finishDateTime;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Workout() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Positive Long getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(@Positive Long distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(Date finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public double getAverageSpeedKmH() {
        double lengthInHours = getLengthInHours();
        if (lengthInHours > 0) {
            return distanceInKm * 1.0 / lengthInHours;
        } else {
            return 0.0;
        }
    }

    public int getLengthInHours() {
        Period period = new Period(new DateTime(startDateTime), new DateTime(finishDateTime));
        return period.getHours();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workout)) return false;
        Workout workout = (Workout) o;
        return distanceInKm == workout.distanceInKm &&
                Objects.equals(id, workout.id) &&
                Objects.equals(startDateTime, workout.startDateTime) &&
                Objects.equals(finishDateTime, workout.finishDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distanceInKm, startDateTime, finishDateTime);
    }
}
