package com.sunglowsys.resource;

import com.sunglowsys.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class FileResource {

    private List<String> extensions = Arrays.asList("png","jpg","gif");


    public final FileService fileService;
    public FileResource(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             RedirectAttributes redirectAttributes) {

        if (!extensions.contains(getExtension(file.getOriginalFilename()))) {
            throw new RuntimeException("invalid format ");
        }

        fileService.uploadImage(file);
        redirectAttributes.addFlashAttribute("message",
                "you have  successfully uploaded "+file.getOriginalFilename()+" !!");
        return "redirect:/";
    }

    private String getExtension(String fileName) {
      return fileName.substring(fileName.lastIndexOf(".")+1);
    }
}
