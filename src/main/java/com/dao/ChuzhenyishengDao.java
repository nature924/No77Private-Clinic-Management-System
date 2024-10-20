package com.dao;

import com.entity.ChuzhenyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuzhenyishengVO;
import com.entity.view.ChuzhenyishengView;


/**
 * 出诊医生
 * 
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface ChuzhenyishengDao extends BaseMapper<ChuzhenyishengEntity> {
	
	List<ChuzhenyishengVO> selectListVO(@Param("ew") Wrapper<ChuzhenyishengEntity> wrapper);
	
	ChuzhenyishengVO selectVO(@Param("ew") Wrapper<ChuzhenyishengEntity> wrapper);
	
	List<ChuzhenyishengView> selectListView(@Param("ew") Wrapper<ChuzhenyishengEntity> wrapper);

	List<ChuzhenyishengView> selectListView(Pagination page,@Param("ew") Wrapper<ChuzhenyishengEntity> wrapper);
	
	ChuzhenyishengView selectView(@Param("ew") Wrapper<ChuzhenyishengEntity> wrapper);
	

}
