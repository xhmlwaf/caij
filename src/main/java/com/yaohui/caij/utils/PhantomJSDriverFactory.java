package com.yaohui.caij.utils;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class PhantomJSDriverFactory extends BasePooledObjectFactory {

    @Override
    public Object create() throws Exception {
        return null;
    }

    @Override
    public PooledObject wrap(Object o) {
        return new DefaultPooledObject(o);
    }

}
