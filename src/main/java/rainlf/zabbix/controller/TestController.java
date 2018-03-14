package rainlf.zabbix.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @ApiOperation("test api")
    @RequestMapping("hello")
    public String test() {
        return "Hello test";
    }
}
