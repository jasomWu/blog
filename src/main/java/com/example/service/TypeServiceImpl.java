package com.example.service;

import com.example.entity.Type;
import com.example.entity.TypeExample;
import com.example.mapper.TypeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunwu
 * @since 2021-09-24-21:57
 */
@SuppressWarnings("all")
@Service
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int saveType(Type type) {
        return typeMapper.insert(type);
    }

    @Override
    public void deleteType(Long id) {
        typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKey(type);
    }

    @Override
    public Type getType(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }
    //使用分页插件查询分页数据
    @Override
    public PageInfo<Type> listType(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TypeExample example=new TypeExample();
        TypeExample.Criteria criteria = example.createCriteria();
        criteria.getCriteria();
        List<Type> list = typeMapper.selectByExample(example);
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     *  根据名字查询是否存在
     * @param name
     * @return true表示存在 ，false表示不存在
     */
    @Override
    public boolean getTypeByName(String name) {
        TypeExample example=new TypeExample();
        TypeExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Type> types = typeMapper.selectByExample(example);
        if (types.size() >0){
            return true;
        }
        return false;
    }
}
