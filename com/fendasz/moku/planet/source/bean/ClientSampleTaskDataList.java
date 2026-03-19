package com.fendasz.moku.planet.source.bean;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientSampleTaskDataList {
    private List<ClientSampleTaskData> list;
    private Integer page;
    private Integer pageSize;
    private Integer totalCount;
    private Integer totalPage;

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer num) {
        this.totalCount = num;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer num) {
        this.page = num;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(Integer num) {
        this.totalPage = num;
    }

    public List<ClientSampleTaskData> getList() {
        return this.list;
    }

    public void setList(List<ClientSampleTaskData> list) {
        this.list = list;
    }
}
