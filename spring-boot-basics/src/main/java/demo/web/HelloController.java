package demo.web;

import demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/hello")
    public String sayHi(){
        return "Hey right back at ya!!!";
    }

}
