package net.javaguides.ems.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.text.SimpleDateFormat;

@Component
public class Scheduler {

    // To trigger the scheduler every 30 seconds with
    // an initial delay of 5 seconds.
    @Scheduled(fixedDelay = 30000, initialDelay = 5000)
    public void scheduleTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(new Date());
        System.out.println(
                "Fixed Delay Scheduler: Task running at - "
                        + strDate);
    }
}