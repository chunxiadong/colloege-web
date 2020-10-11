package com.college.controller;

import com.college.domain.Message;
import com.college.service.MessageService;
import com.college.utils.ResponseMessage;
import com.college.utils.SetLogUtil;
import com.college.utils.ShowImg;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/college/message")
public class MessageController{
    static{
        SetLogUtil.setLog(MessageController.class).info("== 进入MessageController ==");
    }
    @Autowired
    private MessageService messageService;
    /*
    *采用动态sql
    * 给出通过给出的条件查询以此来得到文档的接口,以下5个参数作为条件可单选或者随意组合
    * 比如：只通过messageType查询、通过author和messageType查询等等
    * */
    @RequestMapping("/getMessage")
    public ResponseMessage<List<Message>> getMessage(String messageType, String formatDate, String author, String messageTitle,String messageId) throws JsonProcessingException {
        HashMap<Object, Object> map = new HashMap<>();
        if(messageType.isEmpty()==false){  map.put("messageType",messageType);}
        if(formatDate.isEmpty()==false){ map.put("formatDate",formatDate);}
        if(author.isEmpty()==false){ map.put("author",author);}
        if(messageTitle.isEmpty()==false){ map.put("messageTitle",messageTitle);}
        if (messageId.isEmpty()==false){
            int id=Integer.parseInt(messageId);
            map.put("messageId",id);
        }
        List<Message> message=messageService.getMessage(map);
        ResponseMessage<List<Message>> listResponseMessage = new ResponseMessage<>();
        listResponseMessage.setMsg("success");
        listResponseMessage.setData(message);
        listResponseMessage.setCode(1000);
        return listResponseMessage;
    }
/*
* 给出得到所有文档的接口
* */
    @RequestMapping("/getAllMessage")
    public  ResponseMessage<List<Message>>  getAllMessage() throws JsonProcessingException {
        List<Message> allMessage = messageService.getAllMessage();
        ResponseMessage<List<Message>> listResponseMessage = new ResponseMessage<>();
        listResponseMessage.setMsg("success");
        listResponseMessage.setCode(1000);
        listResponseMessage.setData(allMessage);
        return listResponseMessage;
    }


/*
* 给出根据ID更新相应文档的接口，更新的内容采用动态sql,用法同以上getMessage（）方法
* */
@RequestMapping("/updateMessageById")
    public ResponseMessage updateMessage(Message message){
        HashMap<Object, Object> map = new HashMap<>();
    map.put("messageId",message.getMessageId());
    if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}
    if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}
    if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}
    if (message.getMessageAddress().isEmpty()==false){ map.put("messageAddress",message.getMessageAddress());}
    if (message.getMessageContent().isEmpty()==false){ map.put("messageContent",message.getMessageContent());}
    int i = messageService.updateMessage(map);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    List<Message> message1 = messageService.getMessage(map);
    map.put("formatDate",sdf.format( message1.get(0).getCreateDate()));
    ResponseMessage responseMessage = new ResponseMessage<>();
    int j = messageService.updateMessage(map);
    if (j<1){
        return responseMessage.False();
    }
   return responseMessage.Success();
    }
/*
*采用动态sql
* 给出删除的接口，通过作者、文章标题、文章类型、格式化时间、编号作为条件进行删除
* 比如：只通过作者删除、通过作者和格式化时间为条件删除、以全部为条件删除等等
* */
@RequestMapping("/deleteMessage")
public ResponseMessage deleteMessage(Message message){
    HashMap<Object, Object> map = new HashMap<>();
    if(message.getMessageId()!=null){
        map.put("messageId",message.getMessageId());
    }
    if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}
    if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}
    if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}
    if(message.getFormatDate().isEmpty()==false){ map.put("formatDate",message.getFormatDate());}
    int i = messageService.deleteMessage(map);
    ResponseMessage<Object> responseMessage = new ResponseMessage<>();
    if (i<1){
        return responseMessage.False();
    }
    return responseMessage.Success();
}
/*
* 同时添加文档和图片到数据库和本项目中，不支持富文本编辑器
* 提供上传图片、文件到E:\idea\projects\college_project\file\img\的功能
* 把该图片的URL存到message表中messageAddress属性中
* */
    @RequestMapping("/insertMessageWithImg")
    public ResponseMessage<String> fileUpload(@RequestParam("file") CommonsMultipartFile file, Message message) throws IOException {
        //上传路径保存设置
        String path ="E:\\idea\\projects\\college_project\\file\\img\\"+file.getOriginalFilename();
        //格式化时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Object, Object> map = new HashMap<>();
        if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}
        if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}
        if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}
        if (message.getMessageContent().isEmpty()==false){ map.put("messageContent",message.getMessageContent());}
        if (path.equals("E:\\idea\\projects\\college_project\\file\\img\\")==false){
            map.put("messageAddress",path);
            //如果有图片就保存图片到本项目中
            file.transferTo(new File(path));
        }
        //添加message
        int i = messageService.insertMessage(map);
        if (i>0){
            List<Message> message1 = messageService.getMessage(map);
            map.put("formatDate",sdf.format( message1.get(0).getCreateDate()));
            map.put("messageId",message1.get(0).getMessageId());
            int j = messageService.updateMessage(map);
        }
        //返回图片URL
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        responseMessage.setCode(1000);
        responseMessage.setData("/showImg/"+file.getOriginalFilename());
        responseMessage.setMsg("success");
        return responseMessage;
    }

    /*
    * 上传图片的接口，不提供添加文档的功能，配合富文本编辑器使用
    * */
    @RequestMapping("/uploadImg")
    public ResponseMessage<String> uploadImg(@RequestParam("file") CommonsMultipartFile file)throws IOException{
        //上传路径保存设置
        String path ="E:\\idea\\projects\\college_project\\file\\img\\"+file.getOriginalFilename();
        //保存图片到本项目中
        file.transferTo(new File(path));
        //返回图片URL
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        responseMessage.setMsg("success");
        responseMessage.setCode(1000);
        responseMessage.setData("/showImg/"+file.getOriginalFilename());
        return responseMessage;
    }
    /*
    * 加载图片接口
    * */
    @RequestMapping("/onloadImg/{filename}.{suffix}")
    public void showPicture(@PathVariable("filename") String filename,
                            @PathVariable("suffix") String suffix,
                            HttpServletResponse response) throws IOException {
        System.out.println(filename+suffix);
        SetLogUtil.setLog(MessageController.class).info("== 加载图片开始了 ==");
        File imagefile=new File("E:\\idea\\projects\\college_project\\file\\img\\"+filename+"."+suffix);
        ShowImg.responseFile(response,imagefile);
//        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
//        return responseMessage.Success();
    }
    /*
    * 单纯提供添加文档message的接口，不提供上传图片功能，应该是配合富文本编辑器使用//
    * */
    @RequestMapping("insertMessageWithoutImg")
    public ResponseMessage insertMessage(Message message){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        HashMap<Object, Object> map = new HashMap<>();
        if (message.getMessageTitle().isEmpty()==false){ map.put("messageTitle",message.getMessageTitle());}
        if (message.getMessageType().isEmpty()==false){ map.put("messageType",message.getMessageType());}
        if (message.getAuthor().isEmpty()==false){map.put("author",message.getAuthor());}
        if (message.getMessageContent().isEmpty()==false){ map.put("messageContent",message.getMessageContent());}
        int i = messageService.insertMessage(map);
        List<Message> message1 = messageService.getMessage(map);
        map.put("formatDate",sdf.format( message1.get(0).getCreateDate()));
        map.put("messageId",message1.get(0).getMessageId());
        int j = messageService.updateMessage(map);
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        if (i<1){
            return responseMessage.False();
        }
       return responseMessage.Success();
    }
}