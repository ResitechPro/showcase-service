package com.resitechpro.web.rest;

import com.resitechpro.domain.dto.response.stats.StatsResponseDto;
import com.resitechpro.service.StatsService;
import com.resitechpro.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/showcase/stats")
public class StatsRest {

    private final StatsService statsService;

    public StatsRest(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public ResponseEntity<Response<StatsResponseDto>> getStats() {
        Response<StatsResponseDto> response = new Response<>();
        response.setResult(
                statsService.getLatestStats()
        );
        response.setMessage("Stats retrieved successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/submit-view/{propertyId}")
    public ResponseEntity<Response<Boolean>> submitView(@PathVariable String propertyId) {
        Response<Boolean> response = new Response<>();
        response.setResult(
                statsService.submitView(propertyId)
        );
        response.setMessage("Stats submited successfully");
        return ResponseEntity.ok(response);
    }
}
