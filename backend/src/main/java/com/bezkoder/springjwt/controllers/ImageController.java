package com.bezkoder.springjwt.controllers;


import lombok.var;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin("img/*")
public class ImageController {

    @RequestMapping(value = "/img/{resource}/{id}/{img_name}", method = RequestMethod.GET,
            produces = MediaType.ALL_VALUE)

    public void getImage(
            @PathVariable String resource,
            @PathVariable String id,
            @PathVariable String img_name,
            HttpServletResponse response) throws IOException {

        var imgFile = new ClassPathResource("img/" + resource + "/" + id + "/" + img_name);

        response.setContentType(MediaType.ALL_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
}
