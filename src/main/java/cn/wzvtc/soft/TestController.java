package cn.wzvtc.soft;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController()
public class TestController {

    @RequestMapping(value="/data.json")
    public Map<String,String> bookById(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("myname","李家游");
        resultMap.put("mynumber","18002090216");
        return resultMap;
    }

    @RequestMapping(value="/login")
    public Map<String,String> login(@RequestBody Map<String,String> map) {
        String password=map.get("password");
        String number=map.get("number");
        Map<String,String> resultMap=new HashMap<>();
        if ("18002090216".equals(password) && "18002090216".equals(password)) {
            resultMap.put("result", "success");
        }
        return resultMap;
    }
}