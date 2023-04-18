package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ShetuanxinxiEntity;
import com.utils.PageUtils;
import com.entity.JianlishetuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianlishetuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianlishetuanView;


/**
 * 建立社团
 *
 * @author 
 * @email
 */
public interface JianlishetuanService extends IService<JianlishetuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianlishetuanVO> selectListVO(Wrapper<JianlishetuanEntity> wrapper);
   	
   	JianlishetuanVO selectVO(@Param("ew") Wrapper<JianlishetuanEntity> wrapper);
   	
   	List<JianlishetuanView> selectListView(Wrapper<JianlishetuanEntity> wrapper);
   	
   	JianlishetuanView selectView(@Param("ew") Wrapper<JianlishetuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianlishetuanEntity> wrapper);

	void insertInfo(@Param("ew") Wrapper<ShetuanxinxiEntity> wrapper);
}

