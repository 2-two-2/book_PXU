package com.pxu.service;

import com.pxu.bean.Book;
import com.pxu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
        BookService bookService  = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"大话数据结构","峰哥",new BigDecimal(8),11,1,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(3);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(6,"大话数据结构","峰哥",new BigDecimal(8),11,20,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(6));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(2,2));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1,2,1,2000));

    }
}