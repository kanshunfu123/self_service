package com.xiaowei.mapper.mapper.req;

/**
 * Created by MOMO on 2019/1/8.
 */
public class UserPageReq {

    //当前页
    private int pageNum=1;
    //每页的数量
    private int pageSize=20;
    //用户姓名
    private String uNickname;
    //登录账户
    private String uLoginName;
    //企业id
    private Long compId;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public String getuLoginName() {
        return uLoginName;
    }

    public void setuLoginName(String uLoginName) {
        this.uLoginName = uLoginName;
    }
}
