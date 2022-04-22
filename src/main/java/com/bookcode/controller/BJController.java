package com.bookcode.controller;

import com.bookcode.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BJController {
    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person("张三", 11, "徐州");

        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("李四", 11, "江苏");
        Person p2 = new Person("王五", 22, "湖北");
        Person p3 = new Person("钱进", 33, "北京");
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
}
