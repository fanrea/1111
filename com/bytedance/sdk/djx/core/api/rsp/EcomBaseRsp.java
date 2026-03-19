package com.bytedance.sdk.djx.core.api.rsp;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.bytedance.sdk.djx.utils.JSON;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EcomBaseRsp<T> {
    private int code;
    private T data;
    protected JSONObject dataSource;
    private String desc;

    public EcomBaseRsp(String str) {
        JSONObject jSONObjectBuild = JSON.build(str);
        this.code = JSON.getInt(jSONObjectBuild, "code");
        this.desc = JSON.getString(jSONObjectBuild, RemoteRewardActivity.JSON_BANNER_DESC_ID);
        this.dataSource = JSON.getJsonObject(jSONObjectBuild, "data");
    }

    public boolean isSuccessful() {
        return this.code == 0;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
