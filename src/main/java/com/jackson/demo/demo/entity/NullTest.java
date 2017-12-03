package com.jackson.demo.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class NullTest {

    private String key;

    private List<String> list;

    private Map<String,Object> maps;

    private int[] array;

    private String[] array2;

    private ReleaseNull releaseNull;

    private java.util.Date now;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public String[] getArray2() {
        return array2;
    }

    public void setArray2(String[] array2) {
        this.array2 = array2;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public ReleaseNull getReleaseNull() {
        return releaseNull;
    }

    public void setReleaseNull(ReleaseNull releaseNull) {
        this.releaseNull = releaseNull;
    }
}
