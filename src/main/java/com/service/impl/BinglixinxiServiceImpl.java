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


import com.dao.BinglixinxiDao;
import com.entity.BinglixinxiEntity;
import com.service.BinglixinxiService;
import com.entity.vo.BinglixinxiVO;
import com.entity.view.BinglixinxiView;

@Service("binglixinxiService")
public class BinglixinxiServiceImpl extends ServiceImpl<BinglixinxiDao, BinglixinxiEntity> implements BinglixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BinglixinxiEntity> page = this.selectPage(
                new Query<BinglixinxiEntity>(params).getPage(),
                new EntityWrapper<BinglixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BinglixinxiEntity> wrapper) {
		  Page<BinglixinxiView> page =new Query<BinglixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BinglixinxiVO> selectListVO(Wrapper<BinglixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BinglixinxiVO selectVO(Wrapper<BinglixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BinglixinxiView> selectListView(Wrapper<BinglixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BinglixinxiView selectView(Wrapper<BinglixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
