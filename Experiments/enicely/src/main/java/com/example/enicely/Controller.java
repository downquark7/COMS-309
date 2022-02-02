package com.example.enicely;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @GetMapping("/xyzzz")
    public String test()
    {
        return "said xyzzz";
    }
}
