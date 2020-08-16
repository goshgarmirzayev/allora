package com.goshgarmirzayev.lastrebound.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageDisplayerController {
    @RequestMapping(value="/images/{path}",method = RequestMethod.GET)
    public @ResponseBody void affichimage(@PathVariable("path") String
                                                  path, HttpServletResponse response, HttpServletRequest request) throws
            IOException,NullPointerException
    {
          // get the right annonce from
        //database
        File imageFile = new File("/projects/allora/images/"+path);
        response.setContentType("image/jpeg");
        InputStream in=new FileInputStream(imageFile);
        IOUtils.copy(in, response.getOutputStream());

    }
}
