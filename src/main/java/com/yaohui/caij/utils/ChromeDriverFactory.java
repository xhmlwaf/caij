package com.yaohui.caij.utils;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ChromeDriverFactory extends BasePooledObjectFactory {

    @Override
    public Object create() throws Exception {
        return SpringApplicationUtil.getBean(ChromeDriverUtils.class).getDriver();
    }

    @Override
    public PooledObject wrap(Object o) {
        return new DefaultPooledObject(o);
    }

}
