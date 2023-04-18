package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiesanshetuanDao;
import com.entity.JiesanshetuanEntity;
import com.service.JiesanshetuanService;
import com.entity.vo.JiesanshetuanVO;
import com.entity.view.JiesanshetuanView;

@Service("jiesanshetuanService")
public class JiesanshetuanServiceImpl extends ServiceImpl<JiesanshetuanDao, JiesanshetuanEntity> implements JiesanshetuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiesanshetuanEntity> page = this.selectPage(
                new Query<JiesanshetuanEntity>(params).getPage(),
                new EntityWrapper<JiesanshetuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiesanshetuanEntity> wrapper) {
		  Page<JiesanshetuanView> page =new Query<JiesanshetuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiesanshetuanVO> selectListVO(Wrapper<JiesanshetuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiesanshetuanVO selectVO(Wrapper<JiesanshetuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiesanshetuanView> selectListView(Wrapper<JiesanshetuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiesanshetuanView selectView(Wrapper<JiesanshetuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
