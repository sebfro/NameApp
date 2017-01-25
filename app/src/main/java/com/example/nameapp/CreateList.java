package com.example.nameapp;

import java.io.File;

/**
 * Created by sebas on 19.01.2017.
 */

public class CreateList {

    private String image_title;
    private Integer image_id;
    private File image_Location;

    public String getImage_title(){
        return image_title;
    }

    public void setImage_title(String android_version_name){
        this.image_title = android_version_name;
    }

    public Integer getImage_ID(){
        return image_id;
    }

    public void setImage_ID(Integer android_image_url){
        this.image_id = android_image_url;
    }

    public void setImage_Location(File android_image_location){
        this.image_Location = android_image_location;
    }

    public File getImage_Location(){
        return image_Location;
    }
}

