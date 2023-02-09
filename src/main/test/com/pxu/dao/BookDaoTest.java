package com.pxu.dao;

import com.pxu.bean.Book;
import com.pxu.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
 private  BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        System.out.println(
                bookDao.addBook(new Book(null,"JavaWeb","王珊、萨师煊 编著",new BigDecimal(999),11,0,null))
        );
    }

    @Test
    public void deleteBookById() {
        System.out.println( bookDao.deleteBookById(2));
    }

    @Test
    public void updateBook() {
        System.out.println(
                bookDao.updateBook(new Book(2,"JavaWeb","王珊、萨师煊 编著",new BigDecimal(999),11,0,null))
        );
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(2));
    }

    @Test
    public void queryBooks() {
        /**
         *遍历查找所有图书并输出
         */
        for (Book queryBook : bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        /**
         * 查询总记录数
         */
        System.out.println( bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(bookDao.queryForPageItems(1,2));
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,9000));
    }

    @Test
    public void queryForPageItemsByPrice() {
        System.out.println(bookDao.queryForPageItemsByPrice(1,1,1,2));
    }
}