package com.service.impl;

import com.entity.ShetuanxinxiEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JianlishetuanDao;
import com.entity.JianlishetuanEntity;
import com.service.JianlishetuanService;
import com.entity.vo.JianlishetuanVO;
import com.entity.view.JianlishetuanView;

@Service("jianlishetuanService")
public class JianlishetuanServiceImpl extends ServiceImpl<JianlishetuanDao, JianlishetuanEntity> implements JianlishetuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianlishetuanEntity> page = this.selectPage(
                new Query<JianlishetuanEntity>(params).getPage(),
                new EntityWrapper<JianlishetuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianlishetuanEntity> wrapper) {
		  Page<JianlishetuanView> page =new Query<JianlishetuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

	@Override
	public void insertInfo(Wrapper<ShetuanxinxiEntity> wrapper) {
		baseMapper.insertInfo(wrapper);
	}

	@Override
	public List<JianlishetuanVO> selectListVO(Wrapper<JianlishetuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianlishetuanVO selectVO(Wrapper<JianlishetuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianlishetuanView> selectListView(Wrapper<JianlishetuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianlishetuanView selectView(Wrapper<JianlishetuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
