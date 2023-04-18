package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.AboutusEntity;
import com.entity.view.AboutusView;

import com.service.AboutusService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 关于我们
 * 后端接口
 */
//所有方法的返回值都会被自动转换成JSON格式返回给前端
@RestController
@RequestMapping("/aboutus")
public class AboutusController {
    //自动注入`AboutusService`实例对象
    /*
     * 自动装配依赖的Bean，避免了手动创建对象的麻烦，提高了开发效率
     * 可以减少代码的耦合度，方便进行单元测试和模块化开发
     * */
    @Autowired
    private AboutusService aboutusService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AboutusEntity aboutus, 
		HttpServletRequest request){

        /*
         * MyBatis-Plus中提供的一个实体对象封装操作类，
         * 它继承自`AbstractWrapper`类，用于构建查询条件
         * 支持链式调用，使得代码更加简洁易读
         **/
        EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();

        /*
         * 查询结果经过排序、分页等处理后，将数据封装到`PageUtils`对象中,
         * `MPUtil`是对mybatis-plus的一些常用方法进行封装的工具类,用于生成Mybatis-Plus（简称MP）的查询条件
         * */
		PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AboutusEntity aboutus, HttpServletRequest request){
        EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();

		PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));
        /* 将查询结果封装成一个R对象，并返回给前端*/
		return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AboutusEntity aboutus){
       	EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();
      	ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus")); 
        return R.ok().put("data", aboutusService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AboutusEntity aboutus){
        EntityWrapper< AboutusEntity> ew = new EntityWrapper< AboutusEntity>();
 		ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus")); 
		AboutusView aboutusView =  aboutusService.selectView(ew);
		return R.ok("查询关于我们成功").put("data", aboutusView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AboutusEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AboutusEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
        // 随机生成aboutus的id
    	aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(aboutus);

        aboutusService.insert(aboutus);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
    	aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(aboutus);

        aboutusService.insert(aboutus);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
        //ValidatorUtils.validateEntity(aboutus);
        aboutusService.updateById(aboutus);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        // aboutusService 继承IService，deleteBatchIds是IService中的方法，批量删除数据
        aboutusService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<AboutusEntity> wrapper = new EntityWrapper<AboutusEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		int count = aboutusService.selectCount(wrapper);
		return R.ok().put("count", count);
	}

}
