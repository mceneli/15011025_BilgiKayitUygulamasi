package com.example.myfirstapp;

public class ListItem {
    private String head,desc,detail,ogrsayi,ortalama;

    public ListItem(String head, String desc, String detail,String ogrsayi,String ortalama) {
        this.head = head;
        this.desc = desc;
        this.detail=detail;
        this.ogrsayi=ogrsayi;
        this.ortalama=ortalama;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getDetail() { return detail; }

    public String getOgrsayi() { return ogrsayi; }

    public String getOrtalama() { return ortalama; }
}
