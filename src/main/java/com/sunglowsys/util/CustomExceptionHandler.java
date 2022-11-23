package com.sunglowsys.util;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(FileStorageException.class)
    public ModelAndView handleException(FileStorageException exception, RedirectAttributes  redirectAttributes) {
        ModelAndView modelAttribute = new ModelAndView();
        modelAttribute.addObject("message", exception.getMessage());
        modelAttribute.setViewName("error");

        return modelAttribute;
    }
}
