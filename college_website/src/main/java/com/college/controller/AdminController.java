package com.college.controller;

import com.college.domain.Admin;
import com.college.service.AdminService;
import com.college.utils.ResponseMessage;
import com.college.utils.SetLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
//
@RestController
@RequestMapping("/college/admin")
public class AdminController {

    static{
        SetLogUtil.setLog(AdminController.class).info("== 进入AdminController ==");
    }
    @Autowired
    private AdminService adminService;
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
