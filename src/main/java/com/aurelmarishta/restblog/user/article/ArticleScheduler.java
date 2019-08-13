package com.aurelmarishta.restblog.user.article;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ArticleScheduler {

    @Scheduled(fixedRate = 50000)
    public void checkForScheduledArticles(){
        System.out.println("Schedulde print");
    }

}
