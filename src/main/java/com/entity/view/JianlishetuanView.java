package com.entity.view;

import com.entity.JianlishetuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 建立社团
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
@TableName("jianlishetuan")
public class JianlishetuanView  extends JianlishetuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianlishetuanView(){
	}
 
 	public JianlishetuanView(JianlishetuanEntity jianlishetuanEntity){
 	try {
			BeanUtils.copyProperties(this, jianlishetuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
