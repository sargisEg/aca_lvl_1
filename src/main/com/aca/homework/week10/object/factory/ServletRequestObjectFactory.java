package com.aca.homework.week10.object.factory;

public class ServletRequestObjectFactory implements ObjectFactory {

    @Override
    public ServletRequest getObject() {
        return new ServletRequestImpl();
    }
}
