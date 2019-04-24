package com.xiaowei.service.template;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.xiaowei.common.common.JSONResult;
import com.xiaowei.common.req.template.AddProductMixReq;
import com.xiaowei.common.req.template.TemplateListReq;
import com.xiaowei.common.res.template.TemplateListRes;
import com.xiaowei.common.util.LevelUtil;
import com.xiaowei.mapper.dataobject.SelfTemplateMainDO;
import com.xiaowei.mapper.mapper.SelfTemplateMainMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * created by 韩金群 2019/4/9
 */
@Service
public class TemplateMainService {
    @Autowired
    private SelfTemplateMainMapper selfTemplateMainMapper;
    /**
     * 根据模板类型查询主模板列表
     * */
    public JSONResult templateList(TemplateListReq req)
    {
        List<TemplateListRes>result=new ArrayList<>();
        List<SelfTemplateMainDO>selfTemplateMainDOS=selfTemplateMainMapper.templateList(req.getTemplateType());
        selfTemplateMainDOS.forEach(selfTemplateMainDO -> {
            TemplateListRes res=new TemplateListRes();
            BeanUtils.copyProperties(selfTemplateMainDO,res);
            result.add(res);
        });
        return JSONResult.ok(treeList(result));
    }
    private List<TemplateListRes>treeList(List<TemplateListRes> resList)
    {
        //集合为空直接返回
        if(CollectionUtils.isEmpty(resList))
        {
            return Lists.newArrayList();
        }
        Multimap<String,TemplateListRes>multimap= ArrayListMultimap.create();
        //首先保存第一层级字典树，也是最后一层级
        List<TemplateListRes>rootList=Lists.newArrayList();
        for (TemplateListRes res:resList)
        {
            multimap.put(res.getCodeLevel(),res);
            if(LevelUtil.ROOT.equals(res.getCodeLevel()))
            {
                rootList.add(res);
            }
        }
        transformTree(rootList,LevelUtil.ROOT,multimap);
        //递归生成树
        return rootList;
    }
    //递归生成树
    public void transformTree(List<TemplateListRes>templateList,String level,Multimap<String,TemplateListRes>multimap)
    {
        int size=templateList.size();
        for (int i=0;i<size;i++)
        {
            TemplateListRes templateListRes=templateList.get(i);
            //处理当前层级下的数据
            String nextLevel=LevelUtil.calculateLevel(level,templateListRes.getId());
            List<TemplateListRes>nextList=(List<TemplateListRes>)multimap.get(nextLevel);
            if(!CollectionUtils.isEmpty(nextList))
            {
                templateListRes.setChildren(nextList);
                transformTree(nextList,nextLevel,multimap);
            }
        }
    }
    //新增时获取等级
    private String getLevel(Long parentId)
    {
        if(parentId==null)
        {
            return null;
        }
        SelfTemplateMainDO bean=selfTemplateMainMapper.dataById(parentId);
        if(bean==null)
        {
            return null;
        }
        else
        {
            return bean.getCodeLevel();
        }
    }
}
