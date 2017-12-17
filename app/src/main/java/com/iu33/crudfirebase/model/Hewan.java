package com.iu33.crudfirebase.model;

/**
 * Created by Blackswan on 7/19/2017.
 */

public class Hewan {
    private  String id_hewan;
    private String name;

    public Hewan(String id, String name, String url, String info) {
        this.id_hewan =id;
        this.name =name;
        this.url=url;
        this.info=info;
    }
    public Hewan() {
        id_hewan="";
        name="";
        url="";
        info="";
    }

    public String getId_hewan() {
        return id_hewan;
    }

    public void setId_hewan(String id_hewan) {
        this.id_hewan = id_hewan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String url;

    private String info;
}
