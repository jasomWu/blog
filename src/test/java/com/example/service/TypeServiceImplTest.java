package com.example.service;

import com.example.entity.Type;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sunwu
 * @since 2021-09-24-22:04
 */
@SpringBootTest
@Slf4j
class TypeServiceImplTest {

    @Autowired
    private TypeServiceImpl typeService;

    @Test
    void saveType() {
        Type type =new Type();
        type.setName("springboot");
        typeService.saveType(type);
    }

    @Test
    void deleteType() {

    }

    @Test
    void updateType() {
        Type type =new Type();
        type.setId(7L);
        type.setName("SpringBoot");
        typeService.updateType(type);
    }

    @Test
    void getType() {
        Type type = typeService.getType(7l);
        log.info(type.toString());
    }

    @Test
    void listType() {
//        PageInfo<Type> pageInfo = typeService.listType(1, 3);
//        List<Type> list = pageInfo.getList();
//        for (Type type : list) {
//            log.info(type.toString());
//        }
//        List<Type> types = typeService.listType();
//        for (Type type : types) {
//            log.info(type.toString());
//        }
        List<Type> types = typeService.listTypeTop(6L);
        for (Type type : types) {
            log.info(String.valueOf(type.getBlogs().size()));
        }

    }

}