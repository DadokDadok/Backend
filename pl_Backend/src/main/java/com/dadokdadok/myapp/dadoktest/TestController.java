package com.dadokdadok.myapp.dadoktest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test/{testId}")
    public String testGet() {
        return "Get 성공: pipe-line-test";
    }

    @PostMapping("/test/submit")
    public String testPost(@RequestBody InputDTO inputDTO) {
        log.info("입력값: ", inputDTO.getInput());
        return "Post 성공: pipe-line-test / 인풋값: " + inputDTO.getInput();
    }
}
