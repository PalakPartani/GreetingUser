package com.greeting.controller;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "fName", defaultValue = "World") String firstName,
                             @RequestParam(value = "lName", defaultValue = "World") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @RequestMapping("/displayallgreeting")
    public List<Greeting> displayGreeting() {
        return greetingService.getAllGreetings();
    }

    @PostMapping("/getbyid/{id}")
    public Greeting displayGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    @PutMapping("/getbyiddelete/{id}")
    public void delete(@PathVariable Long id) {
        greetingService.deleteGreetingById(id);
    }

    @PutMapping("/putupdate/{id}")
    public void update(@PathVariable Long id,
                       @RequestParam(value = "fName") String firstName,
                       @RequestParam(value = "lName") String lastName){

        greetingService.updatgreetingById(id, firstName, lastName);

    }

}
