package communicationsimulator.microserviceapp;

import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
@SpringBootApplication
@Slf4j
public class MicroserviceAppApplication {

	private static final int UUID = new Random().nextInt(1000);
	private static Logger logger = LoggerFactory.getLogger(MicroserviceAppApplication.class.toString());

	@Autowired
	EurekaClient eurekaClient;

	@RequestMapping(method = RequestMethod.GET, value = "/introduceSelf")
	@ResponseBody
	public String introduceSelf() {
		return "My name is APP NO. " + UUID;
	}

	public static void main(String[] args) {
		logger.info("" + UUID);
		SpringApplication.run(MicroserviceAppApplication.class, args);
	}

}
