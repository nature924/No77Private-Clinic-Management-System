package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChufangkaijuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChufangkaijuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChufangkaijuView;


/**
 * 处方开具
 *
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface ChufangkaijuService extends IService<ChufangkaijuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChufangkaijuVO> selectListVO(Wrapper<ChufangkaijuEntity> wrapper);
   	
   	ChufangkaijuVO selectVO(@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);
   	
   	List<ChufangkaijuView> selectListView(Wrapper<ChufangkaijuEntity> wrapper);
   	
   	ChufangkaijuView selectView(@Param("ew") Wrapper<ChufangkaijuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChufangkaijuEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChufangkaijuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChufangkaijuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChufangkaijuEntity> wrapper);



}

