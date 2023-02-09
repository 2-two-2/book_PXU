package com.pxu.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcUtilsTest {

    @Test
    public void getConnection() {
        System.out.println(JdbcUtils.getConnection());
    }
}