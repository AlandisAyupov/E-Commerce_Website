package com.ayupov.Bank.Pictures;

import org.springframework.data.annotation.Id;

public class Picture {
    @Id
    public String pictureID;

    public String data;
    
    public String encoding;

    public String getPictureID() {
        return this.pictureID;
    }

    public String getData() {
        return this.data;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
