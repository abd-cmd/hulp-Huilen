package nl.hu.inno.humc.student.presentation;

import nl.hu.inno.humc.student.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private final Producer producer;

    public HelloWorldController(Producer producer) {
        this.producer = producer;
    }
    @PostMapping
    public void helloWorld() {
        producer.sendHelloWorld();
    }
}
