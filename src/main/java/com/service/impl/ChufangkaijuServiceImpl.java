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


import com.dao.ChufangkaijuDao;
import com.entity.ChufangkaijuEntity;
import com.service.ChufangkaijuService;
import com.entity.vo.ChufangkaijuVO;
import com.entity.view.ChufangkaijuView;

@Service("chufangkaijuService")
public class ChufangkaijuServiceImpl extends ServiceImpl<ChufangkaijuDao, ChufangkaijuEntity> implements ChufangkaijuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChufangkaijuEntity> page = this.selectPage(
                new Query<ChufangkaijuEntity>(params).getPage(),
                new EntityWrapper<ChufangkaijuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChufangkaijuEntity> wrapper) {
		  Page<ChufangkaijuView> page =new Query<ChufangkaijuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChufangkaijuVO> selectListVO(Wrapper<ChufangkaijuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChufangkaijuVO selectVO(Wrapper<ChufangkaijuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChufangkaijuView> selectListView(Wrapper<ChufangkaijuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChufangkaijuView selectView(Wrapper<ChufangkaijuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ChufangkaijuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ChufangkaijuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ChufangkaijuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
