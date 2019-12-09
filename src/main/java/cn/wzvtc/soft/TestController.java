package cn.wzvtc.soft;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(value = "http://127.0.0.1:5500",allowCredentials = "true")
@RestController("/")
public class TestController {

    @RequestMapping(value="/userinfo")
    public Map<String,String> userinfo(HttpServletRequest httpServletRequest){
        Map<String,String> resultMap=new HashMap<>();
        if(httpServletRequest.getSession().getAttribute("loginnumber")!=null) {
            resultMap.put("myname",(String)httpServletRequest.getSession().getAttribute("loginnumber"));
            resultMap.put("mynumber",(String)httpServletRequest.getSession().getAttribute("username"));
        }
        return resultMap;
    }

    @RequestMapping(value="/login")
    public Map<String,String> login(@RequestBody Map<String,String> map,HttpServletRequest httpServletRequest) {
        String password=map.get("password");
        String number=map.get("number");
        Map<String,String> resultMap=new HashMap<>();
        if ("18002090216".equals(number) && "18002090216".equals(password)) {
            httpServletRequest.getSession().setAttribute("loginnumber",number);
            httpServletRequest.getSession().setAttribute("username",number);
            resultMap.put("result", "success");
        }
        return resultMap;
    }
    @RequestMapping(value="/logout")
    public void login(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().removeAttribute("loginnumber");
    }

}