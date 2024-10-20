package com.dao;

import com.entity.ChufangkaijuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChufangkaijuVO;
import com.entity.view.ChufangkaijuView;


/**
 * 处方开具
 * 
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface ChufangkaijuDao extends BaseMapper<ChufangkaijuEntity> {
	
	List<ChufangkaijuVO> selectListVO(@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);
	
	ChufangkaijuVO selectVO(@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);
	
	List<ChufangkaijuView> selectListView(@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);

	List<ChufangkaijuView> selectListView(Pagination page,@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);
	
	ChufangkaijuView selectView(@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);



}
