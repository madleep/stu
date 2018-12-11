package cn.tedu.helloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/hello/{name}")
	@ResponseBody
	public String helloSpingboot(@PathVariable String name){
		return "hello Springboot"+name;
	}
}
