package com.dao;

import com.entity.JianlishetuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.entity.ShetuanxinxiEntity;
import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianlishetuanVO;
import com.entity.view.JianlishetuanView;


/**
 * 建立社团
 * 
 * @author 
 * @email 
 * @date 2023-04-13 19:12:14
 */
public interface JianlishetuanDao extends BaseMapper<JianlishetuanEntity> {
	
	List<JianlishetuanVO> selectListVO(@Param("ew") Wrapper<JianlishetuanEntity> wrapper);
	
	JianlishetuanVO selectVO(@Param("ew") Wrapper<JianlishetuanEntity> wrapper);
	
	List<JianlishetuanView> selectListView(@Param("ew") Wrapper<JianlishetuanEntity> wrapper);

	List<JianlishetuanView> selectListView(Pagination page,@Param("ew") Wrapper<JianlishetuanEntity> wrapper);
	
	JianlishetuanView selectView(@Param("ew") Wrapper<JianlishetuanEntity> wrapper);

	void insertInfo(@Param("ew") Wrapper<ShetuanxinxiEntity> wrapper);
}
