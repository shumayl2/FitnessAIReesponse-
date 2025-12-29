package com.fitness.aiService.Controller;


import com.fitness.aiService.Model.Recommendation;
import com.fitness.aiService.Service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class AIController {

    private RecommendationService recommendatioService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId){
        List<Recommendation> userRecommendation = recommendatioService.getUserRecommendation(userId);

        return new ResponseEntity<>(userRecommendation, HttpStatus.OK);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<Recommendation> getActivityRecommendation(@PathVariable String activityId){

        Recommendation activityRecommendation = recommendatioService.getActivityRecommendation(activityId);
        return new ResponseEntity<>(activityRecommendation,HttpStatus.OK);

    }


}
