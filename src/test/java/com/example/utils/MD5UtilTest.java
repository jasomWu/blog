package com.example.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sunwu
 * @since 2021-09-23-22:22
 */
class MD5UtilTest {

    @Test
    void md5() {
     String msg = MD5Util.md5("admin");
        System.out.println(msg.equals("21232F297A57A5A743894A0E4A801FC3"));
    }
}