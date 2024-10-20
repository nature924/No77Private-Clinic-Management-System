package com.entity.view;

import com.entity.ChufangkaijuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 处方开具
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
@TableName("chufangkaiju")
public class ChufangkaijuView  extends ChufangkaijuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChufangkaijuView(){
	}
 
 	public ChufangkaijuView(ChufangkaijuEntity chufangkaijuEntity){
 	try {
			BeanUtils.copyProperties(this, chufangkaijuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
