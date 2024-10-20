package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KeshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KeshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KeshiView;


/**
 * 科室
 *
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface KeshiService extends IService<KeshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KeshiVO> selectListVO(Wrapper<KeshiEntity> wrapper);
   	
   	KeshiVO selectVO(@Param("ew") Wrapper<KeshiEntity> wrapper);
   	
   	List<KeshiView> selectListView(Wrapper<KeshiEntity> wrapper);
   	
   	KeshiView selectView(@Param("ew") Wrapper<KeshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KeshiEntity> wrapper);
   	

}

