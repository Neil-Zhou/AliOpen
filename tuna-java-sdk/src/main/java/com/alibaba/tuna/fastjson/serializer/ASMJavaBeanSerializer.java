package com.alibaba.tuna.fastjson.serializer;

public abstract class ASMJavaBeanSerializer implements ObjectSerializer {

    protected JavaBeanSerializer nature;

    public ASMJavaBeanSerializer(Class<?> clazz){
        nature = new JavaBeanSerializer(clazz);
    }
    
    public JavaBeanSerializer getJavaBeanSerializer() {
        return nature;
    }
}