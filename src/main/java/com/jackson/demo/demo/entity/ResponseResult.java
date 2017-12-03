package com.jackson.demo.demo.entity;

public class ResponseResult {

    private NullTest nullTest;

    public ResponseResult(NullTest nullTest) {
        this.nullTest = nullTest;
    }

    public NullTest getNullTest() {
        return nullTest;
    }

    public void setNullTest(NullTest nullTest) {
        this.nullTest = nullTest;
    }
}
