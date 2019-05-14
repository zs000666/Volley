package com.bawei.volley.bean;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class Bean {
     private String address;
     private String logo;

    public Bean(String address, String logo) {
        this.address = address;
        this.logo = logo;
    }

    public Bean() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "address='" + address + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
