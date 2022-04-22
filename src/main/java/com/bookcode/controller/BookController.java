package com.bookcode.controller;

import com.bookcode.dao.BookDao;
import com.bookcode.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookDao bookDao;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("booklist", bookDao.findAll());
        mav.setViewName("bookList");
        return mav;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Book book) {
        System.out.println(book.toString());
        bookDao.save(book);
        //System.out.println("sava book: " + book.toString());
        return "forward:/book/list";
    }

    @RequestMapping("/preUpdate/{id}")
    public ModelAndView preUpdate(@PathVariable("id")Integer id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", bookDao.getOne(id));
        mav.setViewName("bookUpdate");
        return mav;
    }

    @PostMapping(value = "/update")
    public String update(Book book) {
        bookDao.save(book);
        return "forward:/book/list";
    }

    @GetMapping("/delete")
    public String detele(Integer id) {
        bookDao.deleteById(id);
        return "forward:/book/list";
    }

    @ResponseBody
    @RequestMapping("/query")
    public List<Book> findByName(String name) {
        return bookDao.findByName("思想");
    }

    @ResponseBody
    @RequestMapping("/randomlist")
    public List<Book> randomList(String name) {
        return bookDao.randomList(2);
    }
}


