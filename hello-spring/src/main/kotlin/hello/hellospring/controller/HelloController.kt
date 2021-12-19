package hello.hellospring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    // url 뒤에 hello
    // localhost:8070/hello
    @GetMapping("hello")
    // mvc model의 hello
    fun hello(model: Model): String {
        // 데이터를 담는 함수
        model.addAttribute("data", "hello")
        return "hello"

    }

    @GetMapping("hello-mvc")
    fun helloMvc(@RequestParam("name") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "hello-template"
    }

    @GetMapping("hello-string")
    @ResponseBody
    fun helloString(@RequestParam("name") name: String): String {
        return "hello $name"
    }
}