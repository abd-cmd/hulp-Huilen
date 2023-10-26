package nl.hu.ict.inno;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class runner implements CommandLineRunner {

    private Producer producer;

    public runner(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        SharedMessage testMessage = new SharedMessage("Hoi", 9999);

        this.producer.sendMessage(testMessage);
    }
}
