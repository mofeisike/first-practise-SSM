package com.mofei.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author mofeiske
 * @Description: 数据传输对象
 * @Date: Create in 2019/2/5 16:33
 */
public class RecordDTO {

    private String cardNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;

    /*默认当前页码*/
    private Integer pageNum;

    /*默认每页显示多少条数据*/
    private Integer pageSize;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "RecordDTO{" +
                "cardNo='" + cardNo + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
