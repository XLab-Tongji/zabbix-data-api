package rainlf.zabbix.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rainlf.zabbix.service.TestService;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation("test api")
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String test() {
        return testService.test();
    }
}
