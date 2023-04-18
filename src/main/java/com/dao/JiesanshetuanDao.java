package com.dao;

import com.entity.JiesanshetuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiesanshetuanVO;
import com.entity.view.JiesanshetuanView;


/**
 * 解散社团
 * 
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
public interface JiesanshetuanDao extends BaseMapper<JiesanshetuanEntity> {
	
	List<JiesanshetuanVO> selectListVO(@Param("ew") Wrapper<JiesanshetuanEntity> wrapper);
	
	JiesanshetuanVO selectVO(@Param("ew") Wrapper<JiesanshetuanEntity> wrapper);
	
	List<JiesanshetuanView> selectListView(@Param("ew") Wrapper<JiesanshetuanEntity> wrapper);

	List<JiesanshetuanView> selectListView(Pagination page,@Param("ew") Wrapper<JiesanshetuanEntity> wrapper);
	
	JiesanshetuanView selectView(@Param("ew") Wrapper<JiesanshetuanEntity> wrapper);
	

}
