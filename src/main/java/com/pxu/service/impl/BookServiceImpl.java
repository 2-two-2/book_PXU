package com.pxu.service.impl;

import com.pxu.bean.Book;
import com.pxu.bean.Page;
import com.pxu.dao.BookDao;
import com.pxu.dao.impl.BookDaoImpl;
import com.pxu.service.BookService;

import java.util.List;

/**
 * @author
 * @Date:2022/12/1-16:00
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        //给所有属性赋值
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //设置总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize >0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        //设置当前页数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        //给所有属性赋值
        page.setPageSize(pageSize);
        //设置总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        //设置总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize >0){
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        //设置当前页数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);

        return page;
    }
}
