package com.example.web;

import com.example.entity.Blog;
import com.example.entity.Tag;
import com.example.entity.Type;
import com.example.service.BlogService;
import com.example.service.TagService;
import com.example.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author sunwu
 * @since 2021-09-23-11:38
 */
@Controller
@SuppressWarnings("all")
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @RequestMapping(value = {"/","index","index.html"})
    public String index(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, Model model){
        PageInfo<Blog> pageInfo = blogService.listBlog(pageNum);
        List<Blog> newRecomBlogs = blogService.listNewRecommended(8L);
        List<Type> types = typeService.listTypeTop(6L);
        List<Tag> tags = tagService.listTagTop(10L);
        List<Blog> newFooterBlogs = blogService.listNewRecommended(3L);
        model.addAttribute("page",pageInfo);
        model.addAttribute("types",types);
        model.addAttribute("tags",tags);
        model.addAttribute("recommendBlog",newRecomBlogs);
        model.addAttribute("newFooterBlogs",newFooterBlogs);
        return "index";
    }
    @RequestMapping("/blog/{id}")
    public String blog(){
        return  null;
    }
}
