package com.example.mapper;

import com.example.entity.Blog;
import com.example.entity.BlogExample;
import com.example.entity.BlogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int countByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int deleteByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int insert(BlogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int insertSelective(BlogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    List<BlogWithBLOBs> selectByExampleWithBLOBs(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    List<Blog> selectByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    BlogWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int updateByExampleSelective(@Param("record") BlogWithBLOBs record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") BlogWithBLOBs record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int updateByPrimaryKeySelective(BlogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(BlogWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_blog
     *
     * @mbggenerated Thu Sep 23 18:06:46 CST 2021
     */
    int updateByPrimaryKey(Blog record);
}