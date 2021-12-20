package com.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @program: SSM_zuoye
 * @description:
 * @author: wen
 * @create: 2021-12-20 08:53
 * @version:1.0
 **/
@Controller
public class UploadController {

    @RequestMapping("/upload")
    public ModelAndView uploadFilter(MultipartFile multipartFile, HttpSession session){
        //获取上传文件名
        String filename = multipartFile.getOriginalFilename();
        //获取WebRoot下的images文件夹的绝对路径作为前半部分路径
        String leftPath = session.getServletContext().getRealPath("/static/");
        //将文件的前半部分路径与文件名拼接
        File file = new File(leftPath, filename);
        try {
            multipartFile.transferTo(file);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("loadSucess");
        return mv;
    }


    @RequestMapping("/down")
    public void DownFilter(String fileName, HttpServletRequest req, HttpServletResponse resp){
        //解决文件名中含有中文时出现乱码
        byte[] nameBytes=("lhs"+fileName).getBytes(StandardCharsets.UTF_8);

        String downloadName=new String(nameBytes,StandardCharsets.ISO_8859_1);

        resp.setHeader("content-disposition","attachment="+downloadName);

        try {
            InputStream inputStream=
                    new FileInputStream(req.getServletContext().getRealPath("/static/")+fileName);
            ServletOutputStream os=resp.getOutputStream();
            int len=-1;
            byte[] btyes=new byte[1024];

            while ((len=inputStream.read(btyes))!=-1){
                os.write(btyes,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}