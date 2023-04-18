package com.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

/**
 * 自定义填充处理器
 */
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //将"ctime" 的属性值设置为当前时间，以实现自动填充
        this.setFieldValByName("ctime", new Date(), metaObject);
    }

    @Override
    public boolean openUpdateFill() {
        //关闭更新填充，即不对实体类进行更新填充操作
        return false;
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 关闭更新填充、这里不执行
    }
}
