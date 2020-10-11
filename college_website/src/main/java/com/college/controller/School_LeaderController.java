package com.college.controller;

import com.college.domain.School_Leader;
import com.college.service.School_LeaderService;
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
@RequestMapping("/college/leader")
public class School_LeaderController {
    static{
        SetLogUtil.setLog(School_LeaderController.class).info("== 进入School_LeaderController ==");
    }
    @Autowired
    private School_LeaderService school_leaderService;
/*
* 给出得到全部领导的接口//
* */
    @RequestMapping("/getAllLeader")
    public ResponseMessage<List<School_Leader>> getAllLeader() throws JsonProcessingException {
        List<School_Leader> allLeader = school_leaderService.getAllLeader();
        ResponseMessage<List<School_Leader>> listResponseMessage = new ResponseMessage<>();
        listResponseMessage.setMsg("success");
        listResponseMessage.setCode(1000);
        listResponseMessage.setData(allLeader);
        return listResponseMessage;
    }
/*
*采用动态sql
* 给出通过条件查询得到相应领导的接口，以下leader_name、leader_title、leader_ID作为条件可单选或者随机组合
* 比如：只以leader_name查询、通过leader_name和leader_title查询等等
* */
@RequestMapping("/getLeader")
public  ResponseMessage<List<School_Leader>> getLeader(School_Leader school_leader) throws JsonProcessingException {
    HashMap<Object, Object> map = new HashMap<>();
    if (school_leader.getLeader_ID()!=null){
        map.put("leader_ID",school_leader.getLeader_ID());
    }
    if (school_leader.getLeader_name().isEmpty()==false){  map.put("leader_name",school_leader.getLeader_name());}
    if (school_leader.getLeader_title().isEmpty()==false){ map.put("leader_title",school_leader.getLeader_title());}
    List<School_Leader> leader = school_leaderService.getLeader(map);
    ResponseMessage<List<School_Leader>> listResponseMessage = new ResponseMessage<>();
    listResponseMessage.setMsg("success");
    listResponseMessage.setCode(1000);
    listResponseMessage.setData(leader);
    return listResponseMessage;
}

/*
* 给出根据ID修改领导的接口，修改的内容采用动态sql，用法同以上getLeader（）方法
* */
@RequestMapping("/updateLeaderById")
public ResponseMessage updateLeader(School_Leader leader){
    HashMap<Object, Object> map = new HashMap<>();
    if(leader.getLeader_title().isEmpty()==false){
        map.put("leader_title",leader.getLeader_title());
    }
    if(leader.getLeader_name().isEmpty()==false){
        map.put("leader_name",leader.getLeader_name());
    }
    if(leader.getLeader_contact_unit().isEmpty()==false){
        map.put("leader_contact_unit",leader.getLeader_contact_unit());
    }
    if(leader.getLeader_email().isEmpty()==false){
        map.put("leader_email",leader.getLeader_email());
    }
    if(leader.getLeader_office_location().isEmpty()==false){
        map.put("leader_office_location",leader.getLeader_office_location());
    }
    if(leader.getLeader_phone().isEmpty()==false){
        map.put("leader_phone",leader.getLeader_phone());
    }
    if(leader.getLeader_work().isEmpty()==false){
        map.put("leader_work",leader.getLeader_work());
    }
    map.put("leader_ID",leader.getLeader_ID());
    int i = school_leaderService.updateSchool_Leader(map);
    ResponseMessage<Object> responseMessage = new ResponseMessage<>();
    if (i<1){
       return responseMessage.False();
    }
   return responseMessage.Success();
}
/*
* 给出添加领导的接口，动态sql，同以上getLeader（）方法
* */
@RequestMapping("/insertLeader")
public ResponseMessage insertLeader(School_Leader leader){
    HashMap<Object, Object> map = new HashMap<>();
    if(leader.getLeader_title().isEmpty()==false){
        map.put("leader_title",leader.getLeader_title());
    }
    if(leader.getLeader_name().isEmpty()==false){
        map.put("leader_name",leader.getLeader_name());
    }
    if(leader.getLeader_contact_unit().isEmpty()==false){
        map.put("leader_contact_unit",leader.getLeader_contact_unit());
    }
    if(leader.getLeader_email().isEmpty()==false){
        map.put("leader_email",leader.getLeader_email());
    }
    if(leader.getLeader_office_location().isEmpty()==false){
        map.put("leader_office_location",leader.getLeader_office_location());
    }
    if(leader.getLeader_phone().isEmpty()==false){
        map.put("leader_phone",leader.getLeader_phone());
    }
    if(leader.getLeader_work().isEmpty()==false){
        map.put("leader_work",leader.getLeader_work());
    }
    int i = school_leaderService.insertSchool_Leader(map);
    ResponseMessage<Object> responseMessage = new ResponseMessage<>();
    if (i<1){
        return responseMessage.False();
    }
    return responseMessage.Success();
}

/*
 *给出的条件删除相应领导的接口，删除内容采用动态sql，用法同以上getLeader()方法
* */
public ResponseMessage deleteLeader(School_Leader leader){
    HashMap<Object, Object> map = new HashMap<>();
    if (leader.getLeader_ID()!=null){
        map.put("leader_ID",leader.getLeader_ID());
    }
    if(leader.getLeader_title().isEmpty()==false){
        map.put("leader_title",leader.getLeader_title());
    }
    if(leader.getLeader_name().isEmpty()==false){
        map.put("leader_name",leader.getLeader_name());
    }
    int i = school_leaderService.deleteSchool_Leader(map);
    ResponseMessage<Object> responseMessage = new ResponseMessage<>();
    if (i<1){
        return responseMessage.False();
    }
    return responseMessage.Success();
}
}
