package com.example.web;

import com.example.entity.Blog;
import com.example.entity.Tag;
import com.example.entity.Type;
import com.example.entity.User;
import com.example.exception.NotFoundException;
import com.example.service.BlogService;
import com.example.service.TagService;
import com.example.service.TypeService;
import com.example.service.UserService;
import com.example.utils.MarkdownUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private UserService userService;

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

    /**
     *  具体的某篇博客
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/blog/{id}")
    public String blog(@PathVariable("id") Long id, Model model) {
        blogService.updateBlog(id);  // 更新浏览量
        Blog blog = blogService.getBlogWithComment(id);
        model.addAttribute("blog", blog);
        return "blog";
    }

    /**
     *  搜索框的查询
     * @param pageNum 当前页数
     * @param model
     * @param query  查询条件
     * @return
     */
    @PostMapping("/search")
    public String search(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, Model model,
                         @RequestParam("query") String query){
        PageInfo<Blog> Searchresult =  blogService.listBlogs(pageNum,query);
        model.addAttribute("page",Searchresult);
        model.addAttribute("query",query);
        return "search";

    }
}
