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

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userid){
        List<Recommendation> userRecommendation = recommendatioService.getUserRecommendation(userid);

        return new ResponseEntity<>(userRecommendation, HttpStatus.OK);
    }

    @GetMapping("/activity/{activityid}")
    public ResponseEntity<Recommendation> getActivityRecommendation(@PathVariable String activityid){

        Recommendation activityRecommendation = recommendatioService.getActivityRecommendation(activityid);
        return new ResponseEntity<>(activityRecommendation,HttpStatus.OK);

    }


}
