package com.greeting.service.implementation;

import com.greeting.exception.GreetingException;
import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.repository.IGreetingRepository;
import com.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = user.toString().isEmpty() ? "Hello World" :
                "Hello " + user.getFirstName() + "  " + user.getLastName();
        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getGreetingById(Long id) {

        return greetingRepository.findById(id).orElseThrow(() -> new GreetingException("Sorry! no records for such id", GreetingException.ExceptionTypes.NO_SUCH_ID));
    }

    @Override
    public void deleteGreetingById(Long id) {
        greetingRepository.deleteById(id);
    }

    @Override
    public Greeting updatgreetingById(Long id, String fName, String lName) {
        Greeting byId = greetingRepository.findById(id)
                .orElseThrow(() -> new GreetingException("Sorry! no records for such id", GreetingException.ExceptionTypes.NO_SUCH_ID));
        byId.setMessage("Hello " + fName + " " + lName);
        return greetingRepository.save(byId);

    }

}
