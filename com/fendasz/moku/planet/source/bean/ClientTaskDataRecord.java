package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientTaskDataRecord extends ClientSampleTaskDataRecord implements Serializable {
    private List<String> taskDataExamplePicList;
    private List<Data> taskDataSubmitFormList;
    private List<Data> taskDataSubmitPicList;

    public List<Data> getTaskDataSubmitPicList() {
        return this.taskDataSubmitPicList;
    }

    public void setTaskDataSubmitPicList(List<Data> list) {
        this.taskDataSubmitPicList = list;
    }

    public List<String> getTaskDataExamplePicList() {
        return this.taskDataExamplePicList;
    }

    public void setTaskDataExamplePicList(List<String> list) {
        this.taskDataExamplePicList = list;
    }

    public List<Data> getTaskDataSubmitFormList() {
        return this.taskDataSubmitFormList;
    }

    public void setTaskDataSubmitFormList(List<Data> list) {
        this.taskDataSubmitFormList = list;
    }
}
