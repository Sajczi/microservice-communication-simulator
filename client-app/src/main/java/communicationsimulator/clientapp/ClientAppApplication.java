package communicationsimulator.clientapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "client-app-ribbon")
public class ClientAppApplication {

	@Autowired
	private MicroserviceAppClient microserviceAppClient;

	@RequestMapping(method = RequestMethod.GET, value = "/introduceRemoteApp")
	@ResponseBody
	public String introduceRemoteApp() {
		return microserviceAppClient.introduceSelf();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}

}
