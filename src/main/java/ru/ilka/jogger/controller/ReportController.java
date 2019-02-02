package ru.ilka.jogger.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilka.jogger.dto.UserAverageWorkoutReportDTO;
import ru.ilka.jogger.service.ReportService;
import ru.ilka.jogger.util.UrlSchema;

import java.util.List;

@RestController
@RequestMapping(value = UrlSchema.APP + "/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/average")
    @ApiOperation("This method allows to get average workout report for users by weeks.")
    public List<UserAverageWorkoutReportDTO> getAverageReportsByWeeks() {
        return reportService.getAverageReportsByWeeks();
    }
}
