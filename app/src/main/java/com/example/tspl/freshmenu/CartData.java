package com.example.tspl.freshmenu;

/**
 * Created by tspl on 05-07-2016.
 */
public class CartData {
    private String titlepdt;
    private String price;
    private String qty;
    private Integer img;
    private Integer pid;

    public CartData(String Title, String Price, String Qty, Integer Img, Integer pid){
        this.titlepdt = Title;
        this.price = Price;
        this.qty = Qty;
        this.img = Img;
        this.pid = pid;
    }

    public String getTitlepdt() {
        return titlepdt;
    }
    public String getPrice(){ return this.price; }
    public String getQty(){ return this.qty; }
    public Integer getImg(){ return this.img; }
    public Integer getPid(){ return this.pid; }
}
