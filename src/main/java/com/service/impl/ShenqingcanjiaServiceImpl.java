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


import com.dao.ShenqingcanjiaDao;
import com.entity.ShenqingcanjiaEntity;
import com.service.ShenqingcanjiaService;
import com.entity.vo.ShenqingcanjiaVO;
import com.entity.view.ShenqingcanjiaView;

@Service("shenqingcanjiaService")
public class ShenqingcanjiaServiceImpl extends ServiceImpl<ShenqingcanjiaDao, ShenqingcanjiaEntity> implements ShenqingcanjiaService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingcanjiaEntity> page = this.selectPage(
                new Query<ShenqingcanjiaEntity>(params).getPage(),
                new EntityWrapper<ShenqingcanjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingcanjiaEntity> wrapper) {
		  Page<ShenqingcanjiaView> page =new Query<ShenqingcanjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenqingcanjiaVO> selectListVO(Wrapper<ShenqingcanjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingcanjiaVO selectVO(Wrapper<ShenqingcanjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingcanjiaView> selectListView(Wrapper<ShenqingcanjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingcanjiaView selectView(Wrapper<ShenqingcanjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
