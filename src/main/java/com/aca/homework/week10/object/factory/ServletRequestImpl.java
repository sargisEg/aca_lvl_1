package com.aca.homework.week10.object.factory;

public class ServletRequestImpl implements ServletRequest {

    private int contentLength;
    private String body;

    public ServletRequestImpl() {
    }

    @Override
    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
