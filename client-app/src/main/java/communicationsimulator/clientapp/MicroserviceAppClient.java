package communicationsimulator.clientapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "microservice-app")
public interface MicroserviceAppClient {

    @RequestMapping(method = RequestMethod.GET, value = "/introduceSelf")
    @ResponseBody
    String introduceSelf();

}
