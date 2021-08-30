package com.leonplatform.Controller.Admin;

import com.leonplatform.Objects.Tag;
import com.leonplatform.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable,
                       Model model) {
        model.addAttribute("page", tagService.listTag(pageable));
        model.addAttribute("tag", new Tag());
        return "admin/tags";
    }

    @PostMapping("/tags/post")
    public String post(Tag tag, RedirectAttributes redirectAttributes) {
        if ("".equals(tag.getName().strip())) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Title Can't Be Empty!");
            return "redirect:/admin/tags";
        } else if (tagService.getTagByName(tag.getName()) != null) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Already Exist!");
            return "redirect:/admin/tags";
        }
        Tag t = tagService.saveTag(tag);
        if (t == null) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Failed to Create Tag!");
        }
        redirectAttributes.addFlashAttribute("positiveMessage", "Create tag successfully!");
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}/edit")
    public String edit(@PathVariable Long id, Tag tag,
                       RedirectAttributes redirectAttributes) {
        Tag t = tagService.getTagByName(tag.getName());
        if (t != null) {
            redirectAttributes.addFlashAttribute("negativeMessage", "Already Exist!");
        } else {
            tagService.updateTag(id, tag);
            redirectAttributes.addFlashAttribute("positiveMessage", "Updated Successfully!");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }
}
