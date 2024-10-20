package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyuequxiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyuequxiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyuequxiaoView;


/**
 * 预约取消
 *
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface YuyuequxiaoService extends IService<YuyuequxiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuequxiaoVO> selectListVO(Wrapper<YuyuequxiaoEntity> wrapper);
   	
   	YuyuequxiaoVO selectVO(@Param("ew") Wrapper<YuyuequxiaoEntity> wrapper);
   	
   	List<YuyuequxiaoView> selectListView(Wrapper<YuyuequxiaoEntity> wrapper);
   	
   	YuyuequxiaoView selectView(@Param("ew") Wrapper<YuyuequxiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuequxiaoEntity> wrapper);
   	

}

