package com.pxu.bean;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book book = new Book();
    @Test
    public void getId() {
        System.out.println(book.getId());
    }

    @Test
    public void getName() {
        System.out.println(book.getName());
    }

    @Test
    public void getAuthor() {
    }

    @Test
    public void getPrice() {
    }
}