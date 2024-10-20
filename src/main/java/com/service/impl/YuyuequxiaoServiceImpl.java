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


import com.dao.YuyuequxiaoDao;
import com.entity.YuyuequxiaoEntity;
import com.service.YuyuequxiaoService;
import com.entity.vo.YuyuequxiaoVO;
import com.entity.view.YuyuequxiaoView;

@Service("yuyuequxiaoService")
public class YuyuequxiaoServiceImpl extends ServiceImpl<YuyuequxiaoDao, YuyuequxiaoEntity> implements YuyuequxiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuequxiaoEntity> page = this.selectPage(
                new Query<YuyuequxiaoEntity>(params).getPage(),
                new EntityWrapper<YuyuequxiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuequxiaoEntity> wrapper) {
		  Page<YuyuequxiaoView> page =new Query<YuyuequxiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuyuequxiaoVO> selectListVO(Wrapper<YuyuequxiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyuequxiaoVO selectVO(Wrapper<YuyuequxiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyuequxiaoView> selectListView(Wrapper<YuyuequxiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuequxiaoView selectView(Wrapper<YuyuequxiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
