package com.example.tspl.freshmenu;

import android.media.Image;

/**
 * Created by tspl on 21-06-2016.
 */
public class TodaysmenuData{
        private String title;
        private String price;
        private Integer backimage;
        private String details;

        public TodaysmenuData(String Title,String Price,Integer Backimage,String Details)
        {
            this.title  =   Title;
            this.price  =   Price;
            this.backimage  =   Backimage;
            this.details = Details;
        }

        public String getTitle(){
            return this.title;
        }

        public String getPrice(){
            return this.price;
        }

        public Integer getBackimage(){
            return this.backimage;
        }

        public String getDetails(){ return this.details; }
}