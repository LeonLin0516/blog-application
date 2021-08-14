package com.leonplatform.Controller;

import com.leonplatform.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id, @PathVariable String name) {
//        String blogPost = null;
//        if (blogPost == null) {
//            throw new NotFoundException("This Blog No Longer Exist!");
//        }
        return "index";
    }
}
