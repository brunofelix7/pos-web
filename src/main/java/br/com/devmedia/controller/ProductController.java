package br.com.devmedia.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.devmedia.domain.Product;
import br.com.devmedia.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("products", service.list());
        return new ModelAndView("/product/list", model);
    }

    @GetMapping("/form")
    public String preSalvar(@ModelAttribute("product") Product product) {
        return "/product/add";
    }

    @PostMapping("/save")
    public String salvar(@Valid @ModelAttribute("product") Product product, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/product/add";
        }
        service.save(product);
        attr.addFlashAttribute("mensagem", "Produto criado com sucesso.");
        return "redirect:/products";
    }

    @GetMapping("/form/{id}")
    public ModelAndView preAtualizar(@PathVariable("id") Long id, ModelMap model) {
        Product product = service.findById(id);
        model.addAttribute("product", product);
        return new ModelAndView("/product/add", model);
    }

    @PutMapping("/save")
    public String atualizar(@Valid @ModelAttribute("playlist") Product product, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/product/add";
        }
        service.update(product);
        attr.addFlashAttribute("mensagem", "Produto atualizado com sucesso.");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String remover(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.delete(id);
        attr.addFlashAttribute("mensagem", "Produto excluído com sucesso.");
        return "redirect:/products";
    }

}
