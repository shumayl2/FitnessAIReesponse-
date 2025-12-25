package com.fitness.aiService.Service;

import com.fitness.aiService.Model.Recommendation;
import com.fitness.aiService.Repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RecommendationService {
    @Autowired
    private final RecommendationRepository recomrepo;

    public Recommendation getActivityRecommendation(String activityid){

        Recommendation activityIdNotFound = recomrepo.findByActivityId(activityid).orElseThrow(() -> new RuntimeException("Activity Id not found"));

        return activityIdNotFound;

    }

    public List<Recommendation> getUserRecommendation(String userid) {

        List<Recommendation> byUserId = recomrepo.findByUserId(userid);

        return byUserId;
    }
}
