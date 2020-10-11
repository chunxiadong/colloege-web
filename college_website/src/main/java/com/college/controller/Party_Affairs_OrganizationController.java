package com.college.controller;

import com.college.domain.Party_Affairs_Organization;
import com.college.service.Party_Affairs_OrganizationService;
import com.college.utils.ResponseMessage;
import com.college.utils.SetLogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/college/Party_Affairs_Organization")
public class Party_Affairs_OrganizationController {
    static{
        SetLogUtil.setLog(Party_Affairs_OrganizationController.class).info("== 进入Party_Affairs_OrganizationController ==");
    }
    @Autowired
    private Party_Affairs_OrganizationService P_A_OService;
    /*
    * 给出得到所有党支部的接口//
    * */
    @RequestMapping("/getAllP_A_O")
    public ResponseMessage<List<Party_Affairs_Organization>> getAllP_A_O() throws JsonProcessingException {
        List<Party_Affairs_Organization> allP_a_o = P_A_OService.getAllP_A_O();
        ResponseMessage<List<Party_Affairs_Organization>> responseMessage = new ResponseMessage<>();
        responseMessage.setData(allP_a_o);
        responseMessage.setCode(1000);
        responseMessage.setMsg("success");
        return responseMessage;
    }
    /*
    * 给出通过条件查询得到相应党支部的接口
    * */
    @RequestMapping("/getP_A_O")
    public  ResponseMessage<List<Party_Affairs_Organization>> getP_A_O(String party_name,String party_honor,String party_ID) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        if (party_ID.isEmpty()==false){
            int id=Integer.parseInt(party_ID);
            map.put("party_ID",id);
        }
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        List<Party_Affairs_Organization> p_a_o = P_A_OService.getP_A_O(map);
        ResponseMessage<List<Party_Affairs_Organization>> responseMessage = new ResponseMessage<>();
        responseMessage.setData(p_a_o);
        responseMessage.setCode(1000);
        responseMessage.setMsg("success");
        return responseMessage;
    }
    /*
    * 给出添加学工部的接口
    * */
    @RequestMapping("/insertP_A_O")
    public ResponseMessage insertP_A_O(String party_name,String party_honor){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        int i = P_A_OService.insertP_A_O(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
           return responseMessage.False();
        }
        return responseMessage.Success();
    }
    /*
    * 给出根据ID修改相应党支部资料的接口
    * */
    @RequestMapping("/updateP_A_OById")
    public ResponseMessage updateP_A_OById(String party_name,String party_honor,int party_ID){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("party_ID",party_ID);
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        int i = P_A_OService.updateP_A_O(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }
    /*
    * 给出通过条件查询后删除相应党支部的接口
    * */
    @RequestMapping("/deleteP_A_O")
    public ResponseMessage deleteP_A_O(String party_name,String party_honor,String party_ID){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_ID.isEmpty()==false){
            int id=Integer.parseInt(party_ID);
            map.put("party_ID",id);
        }
        if (party_name.isEmpty()==false){
            map.put("party_name",party_name);
        }
        if (party_honor.isEmpty()==false){
            map.put("party_honor",party_honor);
        }
        int i = P_A_OService.deleteP_A_O(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }
}
