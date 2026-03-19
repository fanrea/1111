package com.fendasz.moku.planet.source.bean;

import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ClientTaskData extends ClientSampleTaskData implements Serializable {
    private List<ClientGroupTaskData> clientGroupTaskDataList;
    private ListeningTimeConfig listeningTimeConfig;
    private Task task;

    @SerializedName(alternate = {"cplTaskData"}, value = "taskData")
    private TaskData taskData;
    private Integer taskDataTag;

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskData getTaskData() {
        return this.taskData;
    }

    public void setTaskData(TaskData taskData) {
        this.taskData = taskData;
    }

    public ListeningTimeConfig getListeningTimeConfig() {
        return this.listeningTimeConfig;
    }

    public void setListeningTimeConfig(ListeningTimeConfig listeningTimeConfig) {
        this.listeningTimeConfig = listeningTimeConfig;
    }

    public List<ClientGroupTaskData> getClientGroupTaskDataList() {
        return this.clientGroupTaskDataList;
    }

    public void setClientGroupTaskDataList(List<ClientGroupTaskData> list) {
        this.clientGroupTaskDataList = list;
    }

    public Integer getTaskDataTag() {
        return this.taskDataTag;
    }

    public void setTaskDataTag(Integer num) {
        this.taskDataTag = num;
    }
}
