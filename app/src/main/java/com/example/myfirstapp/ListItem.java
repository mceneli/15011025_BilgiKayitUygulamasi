package com.example.myfirstapp;

public class ListItem {
    private String head,desc,detail;

    public ListItem(String head, String desc, String detail) {
        this.head = head;
        this.desc = desc;
        this.detail=detail;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
