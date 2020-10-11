package com.college.controller;

import com.college.domain.Party_Affairs_Organization_Member;
import com.college.service.Party_Affairs_Organization_MemberService;
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
@RequestMapping("/college/Party_Affairs_Organization_Member")
public class Party_Affairs_Organization_MemberController {
    static{
        SetLogUtil.setLog(Party_Affairs_Organization_MemberController.class).info("== 进入Party_Affairs_Organization_MemberController ==");
    }
    @Autowired
    private Party_Affairs_Organization_MemberService party_affairs_organization_memberService;
    /*
    * 给出了得到所有党支部成员的接口//
    * */
    @RequestMapping("/getAll")
    public ResponseMessage<List<Party_Affairs_Organization_Member>> getAll() throws JsonProcessingException {
        List<Party_Affairs_Organization_Member> all = party_affairs_organization_memberService.getAll();
        ResponseMessage<List<Party_Affairs_Organization_Member>> listResponseMessage = new ResponseMessage<>();
        listResponseMessage.setMsg("success");
        listResponseMessage.setCode(1000);
        listResponseMessage.setData(all);
        return listResponseMessage;
    }
    /*
    *给出通过条件查询后得到相应党支部成员的接口
    * */
    @RequestMapping("/get")
    public ResponseMessage<List<Party_Affairs_Organization_Member>> get(Party_Affairs_Organization_Member party_affairs_organization_member){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_affairs_organization_member.getParty_member_ID()!=null){

            map.put("party_member_ID",party_affairs_organization_member.getParty_member_ID());
        }
        if (party_affairs_organization_member.getParty_member_name().isEmpty()==false){
            map.put("party_member_name",party_affairs_organization_member.getParty_member_name());
        }
        if (party_affairs_organization_member.getParty_member_title().isEmpty()==false){
            map.put("party_member_title",party_affairs_organization_member.getParty_member_title());
        }
        if (party_affairs_organization_member.getBelong_to_party().isEmpty()==false){
            map.put("belong_to_party",party_affairs_organization_member.getBelong_to_party());
        }
        List<Party_Affairs_Organization_Member> some = party_affairs_organization_memberService.getSome(map);
        ResponseMessage<List<Party_Affairs_Organization_Member>> listResponseMessage = new ResponseMessage<>();
        listResponseMessage.setMsg("success");
        listResponseMessage.setCode(1000);
        listResponseMessage.setData(some);
        return listResponseMessage;
    }
    /*
    * 给出通过条件查询否删除相应的党支部成员的接口
    * */
    public ResponseMessage delete(Party_Affairs_Organization_Member party_affairs_organization_member){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_affairs_organization_member.getParty_member_ID()!=null){
            map.put("party_member_ID",party_affairs_organization_member.getParty_member_ID());
        }
        if (party_affairs_organization_member.getParty_member_name().isEmpty()==false){
            map.put("party_member_name",party_affairs_organization_member.getParty_member_name());
        }
        if (party_affairs_organization_member.getParty_member_title().isEmpty()==false){
            map.put("party_member_title",party_affairs_organization_member.getParty_member_title());
        }
        if (party_affairs_organization_member.getBelong_to_party().isEmpty()==false){
            map.put("belong_to_party",party_affairs_organization_member.getBelong_to_party());
        }
        int delete = party_affairs_organization_memberService.delete(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (delete<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }
    /*
    * 给出通过ID修改党支部成员资料的接口
    * */
    public ResponseMessage updateById(Party_Affairs_Organization_Member party_affairs_organization_member){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_affairs_organization_member.getParty_member_name().isEmpty()==false){
            map.put("party_member_name",party_affairs_organization_member.getParty_member_name());
        }
        if (party_affairs_organization_member.getParty_member_title().isEmpty()==false){
            map.put("party_member_title",party_affairs_organization_member.getParty_member_title());
        }
        if (party_affairs_organization_member.getBelong_to_party().isEmpty()==false){
            map.put("belong_to_party",party_affairs_organization_member.getBelong_to_party());
        }
        int update = party_affairs_organization_memberService.update(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (update<1){
           return responseMessage.False();
        }
        return responseMessage.Success();
    }
    /*
    * 给出添加党支部成员的接口
    * */
    public ResponseMessage insert(Party_Affairs_Organization_Member party_affairs_organization_member){
        HashMap<Object, Object> map = new HashMap<>();
        if (party_affairs_organization_member.getParty_member_name().isEmpty()==false){
            map.put("party_member_name",party_affairs_organization_member.getParty_member_name());
        }
        if (party_affairs_organization_member.getParty_member_title().isEmpty()==false){
            map.put("party_member_title",party_affairs_organization_member.getParty_member_title());
        }
        if (party_affairs_organization_member.getBelong_to_party().isEmpty()==false){
            map.put("belong_to_party",party_affairs_organization_member.getBelong_to_party());
        }
        int insert = party_affairs_organization_memberService.insert(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (insert<1){
            return responseMessage.False();
        }
        return responseMessage.Success();
    }
}
