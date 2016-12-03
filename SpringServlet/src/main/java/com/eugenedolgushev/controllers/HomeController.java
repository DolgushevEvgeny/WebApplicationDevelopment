package com.eugenedolgushev.controllers;

import com.eugenedolgushev.models.Book;
import com.eugenedolgushev.models.BookDAO;
import com.eugenedolgushev.util.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookDAO bookDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final ModelAndView listBook(ModelAndView model) throws IOException {
        List<Book> listBook = bookDAO.list();
        String status = bookDAO.getStatus();
        model.addObject("listBook", listBook);
        model.addObject("status", status);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value = "/newBook", method = RequestMethod.GET)
    public final ModelAndView newBook(ModelAndView model) {
        Book newBook = new Book();
        model.addObject("book", newBook);
        model.setViewName("newBook");

        return model;
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    @ResponseBody
    public final ModelAndView saveBook(@ModelAttribute("book") Book book) {
        bookDAO.save(book);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public final ModelAndView showExample(ModelAndView model) {
        String content = Service.readPage();
        model.addObject("remoteContent", content);
        model.setViewName("remote");
        return model;
    }

    @InitBinder
    public final void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, numberFormat, true));
    }
}
