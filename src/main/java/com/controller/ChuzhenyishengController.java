package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ChuzhenyishengEntity;
import com.entity.view.ChuzhenyishengView;

import com.service.ChuzhenyishengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 出诊医生
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-13 12:28:46
 */
@RestController
@RequestMapping("/chuzhenyisheng")
public class ChuzhenyishengController {
    @Autowired
    private ChuzhenyishengService chuzhenyishengService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuzhenyishengEntity chuzhenyisheng,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqiend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			chuzhenyisheng.setYishengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
                if(chuzhenriqistart!=null) ew.ge("chuzhenriqi", chuzhenriqistart);
                if(chuzhenriqiend!=null) ew.le("chuzhenriqi", chuzhenriqiend);

		PageUtils page = chuzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuzhenyisheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChuzhenyishengEntity chuzhenyisheng, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date chuzhenriqiend,
		HttpServletRequest request){
        EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
                if(chuzhenriqistart!=null) ew.ge("chuzhenriqi", chuzhenriqistart);
                if(chuzhenriqiend!=null) ew.le("chuzhenriqi", chuzhenriqiend);

		PageUtils page = chuzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuzhenyisheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuzhenyishengEntity chuzhenyisheng){
       	EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuzhenyisheng, "chuzhenyisheng")); 
        return R.ok().put("data", chuzhenyishengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuzhenyishengEntity chuzhenyisheng){
        EntityWrapper< ChuzhenyishengEntity> ew = new EntityWrapper< ChuzhenyishengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuzhenyisheng, "chuzhenyisheng")); 
		ChuzhenyishengView chuzhenyishengView =  chuzhenyishengService.selectView(ew);
		return R.ok("查询出诊医生成功").put("data", chuzhenyishengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuzhenyishengEntity chuzhenyisheng = chuzhenyishengService.selectById(id);
		chuzhenyisheng.setClicktime(new Date());
		chuzhenyishengService.updateById(chuzhenyisheng);
        return R.ok().put("data", chuzhenyisheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuzhenyishengEntity chuzhenyisheng = chuzhenyishengService.selectById(id);
		chuzhenyisheng.setClicktime(new Date());
		chuzhenyishengService.updateById(chuzhenyisheng);
        return R.ok().put("data", chuzhenyisheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request){
    	chuzhenyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuzhenyisheng);
        chuzhenyishengService.insert(chuzhenyisheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request){
    	chuzhenyisheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chuzhenyisheng);
        chuzhenyishengService.insert(chuzhenyisheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuzhenyisheng);
        chuzhenyishengService.updateById(chuzhenyisheng);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuzhenyishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ChuzhenyishengEntity> wrapper = new EntityWrapper<ChuzhenyishengEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			wrapper.eq("yishengzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = chuzhenyishengService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request,String pre){
        EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = chuzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuzhenyisheng), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ChuzhenyishengEntity chuzhenyisheng, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "keshi";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "chuzhenyisheng").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ChuzhenyishengEntity> chuzhenyishengList = new ArrayList<ChuzhenyishengEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                chuzhenyishengList.addAll(chuzhenyishengService.selectList(new EntityWrapper<ChuzhenyishengEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ChuzhenyishengEntity> ew = new EntityWrapper<ChuzhenyishengEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = chuzhenyishengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuzhenyisheng), params), params));
        List<ChuzhenyishengEntity> pageList = (List<ChuzhenyishengEntity>)page.getList();
        if(chuzhenyishengList.size()<limit) {
            int toAddNum = (limit-chuzhenyishengList.size())<=pageList.size()?(limit-chuzhenyishengList.size()):pageList.size();
            for(ChuzhenyishengEntity o1 : pageList) {
                boolean addFlag = true;
                for(ChuzhenyishengEntity o2 : chuzhenyishengList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    chuzhenyishengList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(chuzhenyishengList.size()>limit) {
            chuzhenyishengList = chuzhenyishengList.subList(0, limit);
        }
        page.setList(chuzhenyishengList);
        return R.ok().put("data", page);
    }







}
