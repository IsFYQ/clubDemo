package com.entity.view;

import com.entity.ShenqingcanjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 申请参加
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
@TableName("shenqingcanjia")
public class ShenqingcanjiaView  extends ShenqingcanjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingcanjiaView(){
	}
 
 	public ShenqingcanjiaView(ShenqingcanjiaEntity shenqingcanjiaEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingcanjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
