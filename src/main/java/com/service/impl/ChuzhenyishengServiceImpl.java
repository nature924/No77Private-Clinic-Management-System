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


import com.dao.ChuzhenyishengDao;
import com.entity.ChuzhenyishengEntity;
import com.service.ChuzhenyishengService;
import com.entity.vo.ChuzhenyishengVO;
import com.entity.view.ChuzhenyishengView;

@Service("chuzhenyishengService")
public class ChuzhenyishengServiceImpl extends ServiceImpl<ChuzhenyishengDao, ChuzhenyishengEntity> implements ChuzhenyishengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuzhenyishengEntity> page = this.selectPage(
                new Query<ChuzhenyishengEntity>(params).getPage(),
                new EntityWrapper<ChuzhenyishengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuzhenyishengEntity> wrapper) {
		  Page<ChuzhenyishengView> page =new Query<ChuzhenyishengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChuzhenyishengVO> selectListVO(Wrapper<ChuzhenyishengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuzhenyishengVO selectVO(Wrapper<ChuzhenyishengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuzhenyishengView> selectListView(Wrapper<ChuzhenyishengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuzhenyishengView selectView(Wrapper<ChuzhenyishengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
