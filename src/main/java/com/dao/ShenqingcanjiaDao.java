package com.dao;

import com.entity.ShenqingcanjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenqingcanjiaVO;
import com.entity.view.ShenqingcanjiaView;


/**
 * 申请参加
 * 
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
public interface ShenqingcanjiaDao extends BaseMapper<ShenqingcanjiaEntity> {
	
	List<ShenqingcanjiaVO> selectListVO(@Param("ew") Wrapper<ShenqingcanjiaEntity> wrapper);
	
	ShenqingcanjiaVO selectVO(@Param("ew") Wrapper<ShenqingcanjiaEntity> wrapper);
	
	List<ShenqingcanjiaView> selectListView(@Param("ew") Wrapper<ShenqingcanjiaEntity> wrapper);

	List<ShenqingcanjiaView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingcanjiaEntity> wrapper);
	
	ShenqingcanjiaView selectView(@Param("ew") Wrapper<ShenqingcanjiaEntity> wrapper);
	

}
