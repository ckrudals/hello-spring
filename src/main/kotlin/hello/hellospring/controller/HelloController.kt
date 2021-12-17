package hello.hellospring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {

    // url 뒤에 hello
    // localhost:8070/hello
    @GetMapping("hello")
    // mvc model의 hello
    fun hello(model: Model): String {
        // 데이터를 담는 함수
        model.addAttribute("data","hello")
        return "hello"

    }
}