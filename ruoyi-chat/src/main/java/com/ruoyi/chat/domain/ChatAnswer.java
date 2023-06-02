package com.ruoyi.chat.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 问答对象 chat_answer
 * 
 * @author wangxi
 * @date 2023-05-22
 */
public class ChatAnswer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 用户 */
    @Excel(name = "用户")
    private String userId;

    /** 会话号 */
    @Excel(name = "会话号")
    private String sessionId;
    public ChatAnswer(){

    }
    public ChatAnswer(String userId, String sessionId, String question, String questionFrom) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.question = question;
        this.questionFrom = questionFrom;
    }

    /** 问题序号 */
    @Excel(name = "问题序号")
    private String seq;

    /** 问题者 */
    @Excel(name = "问题者")
    private String question;

    /** 提问 */
    @Excel(name = "提问")
    private String questionFrom;

    /** 提问长度 */
    @Excel(name = "提问长度")
    private Integer questionLength;

    /** 提问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提问时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date questionTime;

    /** 回答者 */
    @Excel(name = "回答者")
    private String answerFrom;

    /** 回答 */
    @Excel(name = "回答")
    private String answer;

    /** 回答长度 */
    @Excel(name = "回答长度")
    private Integer answerLength;

    /** 回答时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回答时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date answerTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
    }
    public void setSeq(String seq) 
    {
        this.seq = seq;
    }

    public String getSeq() 
    {
        return seq;
    }
    public void setQuestion(String question) 
    {
        this.question = question;
    }

    public String getQuestion() 
    {
        return question;
    }
    public void setQuestionFrom(String questionFrom) 
    {
        this.questionFrom = questionFrom;
    }

    public String getQuestionFrom() 
    {
        return questionFrom;
    }
    public void setQuestionLength(Integer questionLength) 
    {
        this.questionLength = questionLength;
    }

    public Integer getQuestionLength() 
    {
        return questionLength;
    }
    public void setQuestionTime(Date questionTime) 
    {
        this.questionTime = questionTime;
    }

    public Date getQuestionTime() 
    {
        return questionTime;
    }
    public void setAnswerFrom(String answerFrom) 
    {
        this.answerFrom = answerFrom;
    }

    public String getAnswerFrom() 
    {
        return answerFrom;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setAnswerLength(Integer answerLength) 
    {
        this.answerLength = answerLength;
    }

    public Integer getAnswerLength() 
    {
        return answerLength;
    }
    public void setAnswerTime(Date answerTime) 
    {
        this.answerTime = answerTime;
    }

    public Date getAnswerTime() 
    {
        return answerTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("sessionId", getSessionId())
            .append("seq", getSeq())
            .append("question", getQuestion())
            .append("questionFrom", getQuestionFrom())
            .append("questionLength", getQuestionLength())
            .append("questionTime", getQuestionTime())
            .append("answerFrom", getAnswerFrom())
            .append("answer", getAnswer())
            .append("answerLength", getAnswerLength())
            .append("answerTime", getAnswerTime())
            .toString();
    }
}
