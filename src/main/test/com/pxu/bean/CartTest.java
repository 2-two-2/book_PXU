package com.pxu.bean;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();
    @Test
    public void getTotalCount() {
    }

    @Test
    public void getTotalPrice() {
    }

    @Test
    public void setItems() {
    }

    @Test
    public void addItem() {
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(2,"刘林伟传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(2,"刘林伟传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.deleteItem(1);
        System.out.println(cart);

    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(2,"刘林伟传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
       cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(2,"刘林伟传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.clear();
        cart.addItem(new CartItem(1,"郭敬红传奇",1,new BigDecimal(1000),new BigDecimal(2000)));
        cart.updateCount(1,10);
        System.out.println(cart);
    }
}