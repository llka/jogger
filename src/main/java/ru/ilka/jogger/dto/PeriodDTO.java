package ru.ilka.jogger.dto;

import java.util.Date;
import java.util.Objects;

public class PeriodDTO {
    private Date startDate;
    private Date endDate;

    public PeriodDTO() {
    }

    public PeriodDTO(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PeriodDTO)) return false;
        PeriodDTO periodDTO = (PeriodDTO) o;
        return Objects.equals(startDate, periodDTO.startDate) &&
                Objects.equals(endDate, periodDTO.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}
