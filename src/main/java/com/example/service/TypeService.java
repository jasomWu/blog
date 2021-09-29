package com.example.service;

import com.example.entity.Tag;
import com.example.entity.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**对标签的增删改查
 * @author sunwu
 * @since 2021-09-24-21:31
 */
public interface TypeService {

    int saveType(Type type);

    void deleteType(Long id);

    int updateType(Type type);

    Type getType(Long id);

    List<Type> listType();

    PageInfo<Type> listType(int pageNum, int pageSize);
    /**
     *  根据名字查询是否存在
     * @param name
     * @return true表示存在 ，false表示不存在
     */
    boolean getTypeByName(String name);

    List<Type> listTypeTop(Long count);

}
