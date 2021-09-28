package com.example.web.admin;

import com.example.entity.Type;
import com.example.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author sunwu
 * @since 2021-09-24-22:37
 */
@Controller
@SuppressWarnings("all")
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum
            , @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
                        Model model) {
        PageInfo<Type> pageInfo = typeService.listType(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String types() {
        return "admin/types-input";
    }
    // 新增
    @PostMapping("/types")
    public String save(Type type, RedirectAttributes attributes) {
        boolean isHave = typeService.getTypeByName(type.getName());
        if (isHave) {
            attributes.addFlashAttribute("message", "新增失败！");
        } else {
            int saveType = typeService.saveType(type);
            attributes.addFlashAttribute("message", "新增成功！");
        }
        return "redirect:/admin/types";
    }
    // 更新
    @PostMapping("/types/{id}")
    public String updateType(Type type, @PathVariable("id") Long id, RedirectAttributes attributes) {
        boolean isHave = typeService.getTypeByName(type.getName());
        if (isHave) {
            attributes.addFlashAttribute("message", "更新失败！");
        } else {
            int saveType = typeService.updateType(type);
            attributes.addFlashAttribute("message", "更新成功！");
        }
        return "redirect:/admin/types";
    }
    // 修改
    @GetMapping("/types/{id}/input")
    public String edit(@PathVariable("id") Long id,Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("type",type);
        return "admin/types-edit";
    }

    // 删除
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable("id") Long id,Model model) {
        typeService.deleteType(id);
        model.addAttribute("message","删除成功！");
        return "redirect:/admin/types";
    }

}
