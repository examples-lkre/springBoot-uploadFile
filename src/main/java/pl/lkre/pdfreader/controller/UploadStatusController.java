package pl.lkre.pdfreader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;

import java.util.ArrayList;

@Controller
public class UploadStatusController {

    @GetMapping("/uploadStatus")
    public String uploadStatus(Model model) {
        Document document = (Document) model.asMap().get("document");
        if (document != null) {
            String textContent = document.getDocumentElement().getTextContent();
            model.addAttribute("content", textContent);
        }

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        model.addAttribute("integers", integers);
        return "uploadStatus";
    }
}
