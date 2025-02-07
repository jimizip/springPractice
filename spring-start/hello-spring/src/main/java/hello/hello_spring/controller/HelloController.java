package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    // MVC
    @GetMapping("hello-mvc")
    public String helloMvc (@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // API-JSON
    @GetMapping("hello-api")
    @ResponseBody // HTTP body에 문자 내용 직접 반환
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // 객체 -> JSON 형태로 반환
    }
    static class Hello {
        private String name;
        // getter, setter -> 프로퍼티 방식
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        } }

}
