package dullbird.spring.demo.statemachine;

import dullbird.spring.demo.statemachine.enums.Events;
import dullbird.spring.demo.statemachine.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;

/**
 * @author : cys
 * date: 2021-05-03 11:42
 */
@SpringBootApplication
public class StateMachineDemo implements CommandLineRunner {
    @Autowired
    private StateMachine<States, Events> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(StateMachineDemo.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
    }
}