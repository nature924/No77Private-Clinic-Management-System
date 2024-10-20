package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuzhenyishengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuzhenyishengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuzhenyishengView;


/**
 * 出诊医生
 *
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
public interface ChuzhenyishengService extends IService<ChuzhenyishengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuzhenyishengVO> selectListVO(Wrapper<ChuzhenyishengEntity> wrapper);
   	
   	ChuzhenyishengVO selectVO(@Param("ew") Wrapper<ChuzhenyishengEntity> wrapper);
   	
   	List<ChuzhenyishengView> selectListView(Wrapper<ChuzhenyishengEntity> wrapper);
   	
   	ChuzhenyishengView selectView(@Param("ew") Wrapper<ChuzhenyishengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuzhenyishengEntity> wrapper);
   	

}

