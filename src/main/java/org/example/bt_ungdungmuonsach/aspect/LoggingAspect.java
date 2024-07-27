package org.example.bt_ungdungmuonsach.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @After("execution(* org.example.bt_ungdungmuonsach.service.loan.LoanService.loan())")
    public void logBorrow() {
        logger.info("Một cuốn sách đã được mượn");
    }

    @After("execution(* org.example.bt_ungdungmuonsach.service.loan.LoanService.returnBorrow())")
    public void logReturn() {
        logger.info("Một cuốn sách đã được trả");
    }
}
