package com.college.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

//图片上传
public class ShowImg {
    public static void responseFile(HttpServletResponse response, File imageFile) throws IOException {
        System.out.println("加载图片");
        InputStream in=new FileInputStream(imageFile);
        OutputStream out=response.getOutputStream();
        byte [] buffer = new byte[1024];
        int len=0;
        while((len = in.read(buffer)) > 0){
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
    }
}
