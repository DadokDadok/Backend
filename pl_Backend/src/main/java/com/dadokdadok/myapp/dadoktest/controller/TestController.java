package com.dadokdadok.myapp.dadoktest.controller;


import com.dadokdadok.myapp.dadoktest.dao.InputDAO;
import com.dadokdadok.myapp.dadoktest.vo.InputVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    private final InputDAO inputDAO;

    @GetMapping("/test/{testId}")
    public String testGet() {
        return "Get 성공: pipe-line-test";
    }

    @PostMapping("/test/submit")
    public String testPost(@RequestBody InputVO inputVO) {
        log.info("입력값: ", inputVO.getInput());
        return "Post 성공: pipe-line-test / 인풋값: " + inputVO.getInput();
    }

    @GetMapping("get/{output}")
    public String getInput(@PathVariable String output) {
        return inputDAO.findInput(output);
    }

    @PostMapping("post/{output}")
    public void createInput(@PathVariable String output) {
        inputDAO.addInput(output);
    }

    @PutMapping("put/{output}")
    public void updateInput(@PathVariable String output) {
        inputDAO.updateInput(output);
    }

    @DeleteMapping("delete/{output}")
    public void deleteInput(@PathVariable String output) {
        inputDAO.deleteInput(output);
    }
}
