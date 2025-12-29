package com.fitness.aiService.Service;


import com.fitness.aiService.Model.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.LoggingProducerListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityEventListner {



    @KafkaListener(topics = "${kafka.topic.name}")
    public void processActivity(Activity activity){
        log.info("Recived Activty for processing : {}", activity.getUserId());

    }
}
