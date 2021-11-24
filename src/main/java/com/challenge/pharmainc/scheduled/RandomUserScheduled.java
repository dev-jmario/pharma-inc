package com.challenge.pharmainc.scheduled;

import com.challenge.pharmainc.model.User;
import com.challenge.pharmainc.model.random.RandomUser;
import com.challenge.pharmainc.service.CrudService;
import com.challenge.pharmainc.service.RandomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class RandomUserScheduled {

    @Autowired
    private RandomUserService randomUserService;
    @Autowired
    private CrudService crudService;

    @Value("${spring.hosts.random-limit}")
    private int limit;

    @Scheduled(cron = "0 ${spring.exec.minute} ${spring.exec.hour} * * *")
    //@Scheduled(cron = "0 0/1 * * * *")
    public void executar(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        List<User> userList = new ArrayList<>();
        while(userList.size()<limit){
            System.out.printf("Now... %s\n", LocalDateTime.now().format(formatter));
            RandomUser randomUser = randomUserService.importRandomUsers();
            if(randomUser != null){
                userList.addAll( randomUserService.convertRandomUser(randomUser));
                System.out.printf("Importing... %d\n", userList.size());
            }
            else{
                System.out.printf("import error\n");
                break;
            }
        }
        System.out.printf("Imported Amount... %d\n", userList.size());
        System.out.printf("Limit... %d\n", limit);

        if(userList.size()>0){
            crudService.saveAll(userList);
        }
    }

}
