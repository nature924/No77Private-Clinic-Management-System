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


import com.dao.KeshiDao;
import com.entity.KeshiEntity;
import com.service.KeshiService;
import com.entity.vo.KeshiVO;
import com.entity.view.KeshiView;

@Service("keshiService")
public class KeshiServiceImpl extends ServiceImpl<KeshiDao, KeshiEntity> implements KeshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KeshiEntity> page = this.selectPage(
                new Query<KeshiEntity>(params).getPage(),
                new EntityWrapper<KeshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KeshiEntity> wrapper) {
		  Page<KeshiView> page =new Query<KeshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KeshiVO> selectListVO(Wrapper<KeshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KeshiVO selectVO(Wrapper<KeshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KeshiView> selectListView(Wrapper<KeshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KeshiView selectView(Wrapper<KeshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
