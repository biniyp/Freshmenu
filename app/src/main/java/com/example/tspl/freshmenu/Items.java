package com.example.tspl.freshmenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tspl on 06-07-2016.
 */
public class Items {
    private static Items ourInstance = new Items();
    private Integer[] itempositions={0,0,0};
    private Integer[] quanities={0,0,0};
    private String[] itemnames;



    public static Items getInstance() {
        return ourInstance;
    }

    private Items() {
    }


    public void setItempos(int value,int pos){
        this.itempositions[pos] = value;
    }
    public void setQuanities(int value,int pos){

        this.quanities[pos] = value;
    }
    public void setItemnames(String value,int pos){
        this.itemnames[pos] = value;
    }
    public Integer[] getItempos()
    {
        return this.itempositions;
    }
    public Integer[] getQuanities(){
        return this.quanities;
    }
    public String[] getItemnames(){ return this.itemnames; }
}
