package com.college.controller;

import com.college.domain.Admin;
import com.college.service.AdminService;
import com.college.utils.ResponseMessage;
import com.college.utils.SetLogUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//
@RestController
@RequestMapping("/college/admin")
public class AdminController {
    private static Logger logger = Logger.getLogger(AdminController.class);
    static{
        SetLogUtil.setLog(AdminController.class).info("== 进入AdminController ==");
    }
    @Autowired
    private AdminService adminService;

    /* 获取校验码 */
    @RequestMapping("/getVerifyCode")
    public void generate(HttpServletResponse response, HttpSession session){
        logger.info("获取校验码");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String verifyCodeValue = drawImg(output);
        // 将校验码保存到session中
        session.setAttribute("verifyCodeValue", verifyCodeValue);

        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
           logger.info("<--验证码前端写出.出现异常-->");
            e.printStackTrace();

        }
    }
    /* 绘制验证码 */
    private String drawImg(ByteArrayOutputStream output) {
        logger.info("绘制验证码");
        String code = "";
        // 随机产生4个字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        // 调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /* 获取随机参数 */
    private char randomChar() {
        logger.info("获取随机参数");
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
    /* 获取校验码结束 */

    /*
    * 给出管理员登录时对密码和用户名进行存在性、正确性验证的接口
    * */
    @RequestMapping("/checkAdmin")
    public ResponseMessage<String> checkAdmin(@RequestParam("admin_name") String admin_name, @RequestParam("admin_pwd") String admin_pwd){
        String msg="";
        List<Admin> allAdmin = adminService.getAllAdmin();
        if (admin_name.isEmpty()==false){
            for (Admin a:allAdmin
                 ) {
                if (a.getAdmin_name().equals(admin_name)){
                    msg="用户名正确";
                }
            }
            if (msg.equals("用户名正确")==false){
                msg="用户名错误";
            }
        }
        if (admin_pwd.isEmpty()==false){
            for (Admin a:allAdmin
            ) {
                if (a.getAdmin_pwd().equals(admin_pwd) && a.getAdmin_name().equals(admin_name)){
                    msg="用户密码正确";
                }
            }
            if (msg.equals("用户名正确")==false){
                msg="用户密码错误";
            }
        }
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        responseMessage.setData(msg);
        responseMessage.setCode(1000);
        responseMessage.setMsg("success");
        return responseMessage;
    }
/*
* 给出注册管理员账号的接口
* */
@RequestMapping("/insertAdmin")
public ResponseMessage insertAdmin(Admin admin){
    HashMap<Object, Object> map = new HashMap<>();
    if (admin.getAdmin_name().isEmpty()==false){
        map.put("admin_name",admin.getAdmin_name());
    }
    if (admin.getAdmin_pwd().isEmpty()==false){
        map.put("admin_pwd",admin.getAdmin_pwd());
    }
    int i = adminService.insertAdmin(map);
    ResponseMessage<Object> responseMessage = new ResponseMessage<>();
    if (i<1){
      return responseMessage.False();
    }
    return responseMessage.Success();
}
/*
* 给出根据条件删除相应管理员的接口
* */
@RequestMapping("/deleteAdmin")
public ResponseMessage deleteAdmin(Admin admin){
    HashMap<Object, Object> map = new HashMap<>();
    if (admin.getAdmin_id()!=null){
        map.put("admin_id",admin.getAdmin_id());
    }
    if (admin.getAdmin_name().isEmpty()==false){
        map.put("admin_name",admin.getAdmin_name());
    }
    if (admin.getAdmin_pwd().isEmpty()==false){
        map.put("admin_pwd",admin.getAdmin_pwd());
    }
    int i = adminService.deleteAdmin(map);
    ResponseMessage<Object> responseMessage = new ResponseMessage<>();
    if (i<1){
        return responseMessage.False();
    }
    return responseMessage.Success();
}
/*
* 给出根据ID修改相应管理员的接口
* */
@RequestMapping("/updateAdmin")
    public ResponseMessage updateAdmin(Admin admin){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("admin_id",admin.getAdmin_id());
        if (admin.getAdmin_name().isEmpty()==false){
            map.put("admin_name",admin.getAdmin_name());
        }
        if (admin.getAdmin_pwd().isEmpty()==false){
            map.put("admin_pwd",admin.getAdmin_pwd());
        }
        int i = adminService.updateAdmin(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }
}
