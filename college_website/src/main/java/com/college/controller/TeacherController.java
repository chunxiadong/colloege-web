package com.college.controller;

import com.college.domain.Teacher;
import com.college.service.TeacherService;
import com.college.utils.ResponseMessage;
import com.college.utils.SetLogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college/teacher")
public class TeacherController {
    static{
        SetLogUtil.setLog(School_LeaderController.class).info("== 进入TeacherController ==");
    }
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getTeacher")
    public ResponseMessage<List<Teacher>> getTeacher(Teacher teacher) throws JsonProcessingException{
        Map<Object,Object> map = new HashMap();
        if(teacher.getTeacherId()==null){map.put("teaceherId",teacher.getTeacherId());}
        if(teacher.getTeacherName().isEmpty()==false){map.put("teacherName",teacher.getTeacherName());}
        if(teacher.getTeacherTitle().isEmpty()==false){map.put("teacherTitle",teacher.getTeacherTitle());}
        List<Teacher> newteacher = teacherService.getTeacher(map);
        ResponseMessage<List<Teacher>> listResponseMessage = new ResponseMessage();
        listResponseMessage.setMsg("success");
        listResponseMessage.setCode(1000);
        listResponseMessage.setData(newteacher);
        return listResponseMessage;
    }

    @RequestMapping("/getAllTeacher")
    public ResponseMessage<List<Teacher>> getAllTeacher() throws JsonProcessingException{
        List<Teacher> allteacher = teacherService.getAllTeacher();
        ResponseMessage<List<Teacher>> listResponseMessage = new ResponseMessage();
        listResponseMessage.setMsg("success");
        listResponseMessage.setCode(1000);
        listResponseMessage.setData(allteacher);
        return listResponseMessage;
    }

    @RequestMapping("/insertTeacher")
    public ResponseMessage insertTeacher(Teacher teacher){
        System.out.println(teacher.toString());
        Map<Object,Object> map = new HashMap();
        if(teacher.getTeacherName().isEmpty()==false){map.put("teacherName",teacher.getTeacherName());}
        if(teacher.getTeacherTitle().isEmpty()==false){map.put("teacherTitle",teacher.getTeacherTitle());}
        if(teacher.getTeacherHonor().isEmpty()==false){map.put("teacherHonor",teacher.getTeacherHonor());}
        if(teacher.getTeacherTeam().isEmpty()==false){map.put("teacherTeam",teacher.getTeacherTeam());}
        if(teacher.getTeacherTeamTitle().isEmpty()==false){map.put("teacherTeamTitle",teacher.getTeacherTeamTitle());}
        int i = teacherService.insertTeacher(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage();
        if(i<1){
            return responseMessage.False();
        }else{
            return responseMessage.Success();
        }
    }

    @RequestMapping("/deleteTeacher")
    public ResponseMessage deleteTeacher(Teacher teacher){
        Map<Object,Object> map = new HashMap();
        if(teacher.getTeacherId() != null){map.put("teacherId",teacher.getTeacherId());}
        if(teacher.getTeacherName().isEmpty()==false){map.put("teacherName",teacher.getTeacherName());}
        if(teacher.getTeacherTitle().isEmpty()==false){map.put("teacherTitle",teacher.getTeacherTitle());}
        int i = teacherService.deleteTeacher(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage();
        if(i<1){
            return responseMessage.False();
        }else{
            return responseMessage.Success();
        }
    }

    @RequestMapping("/updateTeacher")
    public ResponseMessage updateTeacher(Teacher teacher){
        Map<Object,Object> map = new HashMap();
        map.put("teacherId",teacher.getTeacherId());
        if(teacher.getTeacherName().isEmpty()==false){map.put("teacherName",teacher.getTeacherName());}
        if(teacher.getTeacherTitle().isEmpty()==false){map.put("teacherTitle",teacher.getTeacherTitle());}
        if(teacher.getTeacherHonor().isEmpty()==false){map.put("teacherHonor",teacher.getTeacherHonor());}
        if(teacher.getTeacherTeam().isEmpty()==false){map.put("teacherTeam",teacher.getTeacherTeam());}
        if(teacher.getTeacherTeamTitle().isEmpty()==false){map.put("teacherTeamTitle",teacher.getTeacherTeamTitle());}
        int i = teacherService.updateTeacher(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage();
        if(i<1){
            return responseMessage.False();
        }else{
            return responseMessage.Success();
        }
    }
}