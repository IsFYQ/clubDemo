package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenqingcanjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenqingcanjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingcanjiaView;


/**
 * 申请参加
 *
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
public interface ShenqingcanjiaService extends IService<ShenqingcanjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingcanjiaVO> selectListVO(Wrapper<ShenqingcanjiaEntity> wrapper);
   	
   	ShenqingcanjiaVO selectVO(@Param("ew") Wrapper<ShenqingcanjiaEntity> wrapper);
   	
   	List<ShenqingcanjiaView> selectListView(Wrapper<ShenqingcanjiaEntity> wrapper);
   	
   	ShenqingcanjiaView selectView(@Param("ew") Wrapper<ShenqingcanjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingcanjiaEntity> wrapper);
   	

}

