package com.dao;

import com.entity.YuyueguahaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyueguahaoVO;
import com.entity.view.YuyueguahaoView;


/**
 * 预约挂号
 * 
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface YuyueguahaoDao extends BaseMapper<YuyueguahaoEntity> {
	
	List<YuyueguahaoVO> selectListVO(@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);
	
	YuyueguahaoVO selectVO(@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);
	
	List<YuyueguahaoView> selectListView(@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);

	List<YuyueguahaoView> selectListView(Pagination page,@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);
	
	YuyueguahaoView selectView(@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuyueguahaoEntity> wrapper);



}
