package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiesanshetuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiesanshetuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiesanshetuanView;


/**
 * 解散社团
 *
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
public interface JiesanshetuanService extends IService<JiesanshetuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiesanshetuanVO> selectListVO(Wrapper<JiesanshetuanEntity> wrapper);
   	
   	JiesanshetuanVO selectVO(@Param("ew") Wrapper<JiesanshetuanEntity> wrapper);
   	
   	List<JiesanshetuanView> selectListView(Wrapper<JiesanshetuanEntity> wrapper);
   	
   	JiesanshetuanView selectView(@Param("ew") Wrapper<JiesanshetuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiesanshetuanEntity> wrapper);
   	

}

