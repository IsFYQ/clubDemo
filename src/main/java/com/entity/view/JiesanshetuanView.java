package com.entity.view;

import com.entity.JiesanshetuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 解散社团
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
@TableName("jiesanshetuan")
public class JiesanshetuanView  extends JiesanshetuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiesanshetuanView(){
	}
 
 	public JiesanshetuanView(JiesanshetuanEntity jiesanshetuanEntity){
 	try {
			BeanUtils.copyProperties(this, jiesanshetuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
