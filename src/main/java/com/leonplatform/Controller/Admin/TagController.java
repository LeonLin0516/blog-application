package com.leonplatform.Controller.Admin;

import com.leonplatform.Objects.Tag;
import com.leonplatform.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable,
                       Model model) {
        System.out.println(tagService.listTag(pageable));
        model.addAttribute("page", tagService.listTag(pageable));
        model.addAttribute("tag", new Tag());
        return "admin/tags";
    }

    @PostMapping("/tags/post")
    public String post(Tag tag, RedirectAttributes redirectAttributes) {
        if ("".equals(tag.getName())) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Tag title can't be empty!");
            return "redirect:/admin/tags";
        } else if (tagService.getTagByName(tag.getName()) != null) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Tag has already exist!");
            return "redirect:/admin/tags";
        }
        Tag t = tagService.saveTag(tag);
        if (t == null) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Failed to create tag!");
        }
        redirectAttributes.addFlashAttribute("positiveMessage", "Create tag successfully!");
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }
}
