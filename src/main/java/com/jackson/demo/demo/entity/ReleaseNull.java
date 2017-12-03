package com.jackson.demo.demo.entity;

public class ReleaseNull {

    private Integer id;



    public ReleaseNull() {
    }

    public ReleaseNull(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReleaseNull{" +
                "id=" + id +
                '}';
    }
}
