package com.assignment.incredit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.incredit.dto.CreditAssessmentRequestDTO;
import com.assignment.incredit.dto.CreditAssessmentResponseDTO;
import com.assignment.incredit.service.AssessmentService;


@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {
	
	private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @PostMapping
    public ResponseEntity<CreditAssessmentResponseDTO> assessRisk(@RequestBody CreditAssessmentRequestDTO request) {
        CreditAssessmentResponseDTO response = assessmentService.assess(request);
        return ResponseEntity.ok(response);
    }

}
