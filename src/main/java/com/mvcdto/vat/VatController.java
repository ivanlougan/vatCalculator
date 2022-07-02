package com.mvcdto.vat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VatController {

    private VatCalculatorService vatService;

    public VatController(VatCalculatorService vatService) {
        this.vatService = vatService;
    }

    @PostMapping("/calculate")
    String calculateVat(@RequestParam double nettoPrice,
                        @RequestParam String category,
                        Model model) {
        VatDto vat = vatService.calculateVat(nettoPrice, category);
        model.addAttribute("vat", vat);
    return "result";
    }
}
