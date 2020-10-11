package com.college.controller;

import com.college.domain.Student_Affairs_Office;
import com.college.service.Student_Affairs_OfficeService;
import com.college.utils.ResponseMessage;
import com.college.utils.SetLogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/college/Student_Affairs_Office")
public class Student_Affairs_OfficeController {
    static {
        SetLogUtil.setLog(Student_Affairs_OfficeController.class).info("== 进入Student_Affairs_OfficeController ==");
    }

    @Autowired
    private Student_Affairs_OfficeService student_affairs_officeService;

    /*
     * 给出得到所有学工部成员的接口//
     * */
    @RequestMapping("/getAll")
    public ResponseMessage<List<Student_Affairs_Office>> getAll() throws JsonProcessingException {
        List<Student_Affairs_Office> allS_a_o = student_affairs_officeService.getAllS_A_O();
        ResponseMessage<List<Student_Affairs_Office>> responseMessage = new ResponseMessage<>();
        responseMessage.setData(allS_a_o);
        responseMessage.setCode(1000);
        responseMessage.setMsg("success");
        return responseMessage;
    }

    /*
     * 给出了根据条件查询得到相应学工部成员的接口
     * */
    @RequestMapping("/get")
    public  ResponseMessage<List<Student_Affairs_Office>> get(Student_Affairs_Office student_affairs_office ) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getID()!=null){
            map.put("ID",student_affairs_office.getID());
        }
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getMotto().isEmpty() == false) {
            map.put("motto", student_affairs_office.getMotto());
        }
        if (student_affairs_office.getEmail().isEmpty() == false) {
            map.put("email", student_affairs_office.getEmail());
        }
        if (student_affairs_office.getLocation().isEmpty() == false) {
            map.put("location", student_affairs_office.getLocation());
        }
        if (student_affairs_office.getPhone().isEmpty() == false) {
            map.put("phone", student_affairs_office.getPhone());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        List<Student_Affairs_Office> s_a_o = student_affairs_officeService.getS_A_O(map);
        ResponseMessage<List<Student_Affairs_Office>> responseMessage = new ResponseMessage<>();
        responseMessage.setData(s_a_o);
        responseMessage.setCode(1000);
        responseMessage.setMsg("success");
        return responseMessage;
    }
    /*
    * 给出了添加学工部成员的接口
    * */
    @RequestMapping("/insert")
    public ResponseMessage insert(Student_Affairs_Office student_affairs_office){
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getMotto().isEmpty() == false) {
            map.put("motto", student_affairs_office.getMotto());
        }
        if (student_affairs_office.getEmail().isEmpty() == false) {
            map.put("email", student_affairs_office.getEmail());
        }
        if (student_affairs_office.getLocation().isEmpty() == false) {
            map.put("location", student_affairs_office.getLocation());
        }
        if (student_affairs_office.getPhone().isEmpty() == false) {
            map.put("phone", student_affairs_office.getPhone());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        int i = student_affairs_officeService.insertS_A_O(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }
    /*
    * 给出了根据id修改相应学工部成员的接口
    * */
    @RequestMapping("/updateById")
    public ResponseMessage updateById(Student_Affairs_Office student_affairs_office){
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getMotto().isEmpty() == false) {
            map.put("motto", student_affairs_office.getMotto());
        }
        if (student_affairs_office.getEmail().isEmpty() == false) {
            map.put("email", student_affairs_office.getEmail());
        }
        if (student_affairs_office.getLocation().isEmpty() == false) {
            map.put("location", student_affairs_office.getLocation());
        }
        if (student_affairs_office.getPhone().isEmpty() == false) {
            map.put("phone", student_affairs_office.getPhone());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        map.put("ID",student_affairs_office.getID());
        int i = student_affairs_officeService.updateS_A_O(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }
    /*
    * 给出了根据条件查询得到相应的学工部员工后删除的接口
    * */
    @RequestMapping("/delete")
    public ResponseMessage delete(Student_Affairs_Office student_affairs_office){
        HashMap<Object, Object> map = new HashMap<>();
        if (student_affairs_office.getID()!=null){
            map.put("ID",student_affairs_office.getID());
        }
        if (student_affairs_office.getName().isEmpty() == false) {
            map.put("name", student_affairs_office.getName());
        }
        if (student_affairs_office.getTitle().isEmpty() == false) {
            map.put("title", student_affairs_office.getTitle());
        }
        int i = student_affairs_officeService.deleteS_A_O(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }

}
