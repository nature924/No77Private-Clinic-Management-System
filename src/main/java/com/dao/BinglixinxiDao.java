package com.dao;

import com.entity.BinglixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BinglixinxiVO;
import com.entity.view.BinglixinxiView;


/**
 * 病历信息
 * 
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface BinglixinxiDao extends BaseMapper<BinglixinxiEntity> {
	
	List<BinglixinxiVO> selectListVO(@Param("ew") Wrapper<BinglixinxiEntity> wrapper);
	
	BinglixinxiVO selectVO(@Param("ew") Wrapper<BinglixinxiEntity> wrapper);
	
	List<BinglixinxiView> selectListView(@Param("ew") Wrapper<BinglixinxiEntity> wrapper);

	List<BinglixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<BinglixinxiEntity> wrapper);
	
	BinglixinxiView selectView(@Param("ew") Wrapper<BinglixinxiEntity> wrapper);
	

}
