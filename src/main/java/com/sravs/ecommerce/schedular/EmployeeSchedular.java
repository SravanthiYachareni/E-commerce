package com.sravs.ecommerce.schedular;

import com.sravs.ecommerce.graphql.entity.EmployeeEntity;
import com.sravs.ecommerce.graphql.model.Employee;
import com.sravs.ecommerce.graphql.repositories.EmployeeRepository;
import com.sravs.ecommerce.graphql.service.EmployeeService;
import com.sravs.ecommerce.util.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class EmployeeSchedular {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmailUtil emailUtil;

    @Autowired
    private JavaMailSender javaMailSender;

    @Scheduled(cron = "*/2 * * * * *")
    @Async
//    @Scheduled(fixedRate = 2000)
//    @Scheduled(fixedDelay = 1000)
    public void processTask() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        log.info("fetched object from database" + new Date() + employeeEntities);
        emailUtil.sendMail("sravanthiyachareni@gmail.com","Hi");
    }
    @Scheduled(fixedDelay = 2000)
    public void processTaskByPid() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAllByPid("PID1");
        log.info("fetching the employee by pid" + employeeEntities);

    }

}
