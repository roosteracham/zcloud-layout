package com.zonesion.layout.service;

import java.util.List;

import com.zonesion.layout.model.TemplateEntity;
import com.zonesion.layout.model.TemplateVO;
import com.zonesion.layout.page.QueryResult;

/**    
 * @author andieguo andieguo@foxmail.com
 * @Description: TODO 
 * @date 2016年4月21日 上午11:47:50  
 * @version V1.0    
 */
public interface TemplateService {

public List<TemplateEntity> findAll();
	
	public QueryResult<TemplateEntity> findAll(int firstindex, int maxresult);
	
	public TemplateEntity findByTemplateId(int tid);
	
	public List<TemplateEntity> findByAdminId(int aid,int visible);
	
	public List<Integer> findByAdminId(int aid);
	
	public QueryResult<TemplateEntity> findByAdminId(int aid,int firstindex, int maxresult);
	
	/**
	 * 根据管理员id和模板类型获取模板
	 */
	public List<TemplateEntity> findByAdminAndType(int aid,int type,int visible);
	
	public List<TemplateEntity> findByTempalteAndType(int tid,int type,int visible);
	
	public List<TemplateEntity> findByAdminIdAndTid(int aid,int tid,int visible);
	
	public List<TemplateEntity> findByType(int type);
	
	public QueryResult<TemplateEntity> findByAdminAndType(int aid,int type,int firstindex, int maxresult);
	
	public int save(TemplateEntity templateEntity);
	
	public int delete(int id);
	
	public int delete(int[] ids,int aid);
	
	public int delete(int[] ids);
	
	public int enable(int id,int visible);
	
	public int update(TemplateEntity templateEntity);
	
	public QueryResult<TemplateVO> findByAdminAndType(int aid, int type, int visible,int firstindex, int maxresult);
	
	public QueryResult<TemplateVO> findByAdminAndType(String nickname,String templatename, int type, int visible,int firstindex, int maxresult);

}
