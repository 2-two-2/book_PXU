package com.pxu.service;

import com.pxu.bean.Book;
import com.pxu.bean.Page;

import java.util.List;

/**
 * @author
 * @Date:2022/10/16-15:31
 */
public interface BookService {
    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book);

    /**
     * 删除图书
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 更新图书信息
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 根据ID查找图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 列表显示所有图书
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 分页
     * @param pageNo 当前页码
     * @param pageSize 每页显示的数量
     * @return 分页对象
     */
    public Page<Book> page(int pageNo, int pageSize);

    /**
     * 处理价格区间的分页
     * @param pageNo 页数
     * @param pageSize 每页显示的数量
     * @param min
     * @param max
     * @return
     */
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
