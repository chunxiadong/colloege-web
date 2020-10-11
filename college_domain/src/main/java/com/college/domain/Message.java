package com.college.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*
* 文件
* */
public class Message {
    private Integer messageId;//文章ID
    private String messageTitle;//文章标题
    private String messageType;//文章类型
    private String messageContent;//文章内容
    private Date createDate;//上次修改时间
    private String status;//审核状态
    private String messageAddress;//文章链接
    private String author;//作者
    private String formatDate;//格式化时间
//    private String messageImg;//图片地址
}
