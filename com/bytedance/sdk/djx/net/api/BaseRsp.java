package com.bytedance.sdk.djx.net.api;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.commonsdk.api.utils.JSON;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BaseRsp<T> {
    protected int mCode = -1;
    private T mData;
    private Extra mExtra;
    private String mMsg;
    private String mRequestId;
    private String mSubRet;

    public static CommonError toDJXError(BaseRsp baseRsp) {
        return baseRsp == null ? CommonError.build() : baseRsp.toDJXError();
    }

    public CommonError toDJXError() {
        return CommonError.build(this.mCode, this.mMsg).subCode(this.mSubRet).reqId(this.mRequestId);
    }

    public void parseComm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        setCode(JSON.getInt(jSONObject, "ret"));
        setMsg(JSON.getString(jSONObject, "msg"));
        setSubRet(JSON.getString(jSONObject, "sub_ret"));
        String string = JSON.getString(jSONObject, g.o);
        if (TextUtils.isEmpty(string)) {
            string = JSON.getString(jSONObject, "request_id");
        }
        setRequestId(string);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "extra");
        if (jsonObject != null) {
            Extra extra = new Extra();
            extra.setAdMode(JSON.getInt(jsonObject, "ad_mode", -1));
            extra.setAdModeNews(JSON.getInt(jsonObject, "news_ad_mode", -1));
            extra.setABConfig(JSON.getString(jsonObject, ICEffectKeys.KEY_IS_IC_EFFECT_AB_CONFIG, null));
            extra.setAdLogParams(JSON.getJsonArray(jsonObject, "adlog_params"));
            JSONArray jsonArray = JSON.getJsonArray(jsonObject, "version_names");
            if (jsonArray != null && jsonArray.length() > 0) {
                int length = jsonArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        int iOptInt = jsonArray.optInt(i);
                        if (iOptInt > 0) {
                            extra.addVid(iOptInt);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            extra.setContentUnionRequestType(JSON.getInt(jsonObject, "content_union_request_type", 0));
            extra.setAdShakeCoverShow((Boolean) JSON.getObject(jsonObject, "ad_shake_cover_show", null));
            setExtra(extra);
        }
    }

    public boolean isOk() {
        return getCode() == 0;
    }

    public int getCode() {
        return this.mCode;
    }

    public void setCode(int i) {
        this.mCode = i;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }

    public String getSubRet() {
        return this.mSubRet;
    }

    public void setSubRet(String str) {
        this.mSubRet = str;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public T getData() {
        return this.mData;
    }

    public void setData(T t) {
        this.mData = t;
    }

    public Extra getExtra() {
        Extra extra = this.mExtra;
        return extra == null ? new Extra() : extra;
    }

    public void setExtra(Extra extra) {
        this.mExtra = extra;
    }

    public static class Extra {
        private String mABConfig;
        private JSONArray mAdLogParams;
        private Boolean mAdShakeCoverShow;
        private int mContentUnionRequestType;
        private int mAdMode = -1;
        private int mAdModeNews = -1;
        private List<Integer> mVidList = new ArrayList();

        public List<Integer> getVidList() {
            return this.mVidList;
        }

        public void addVid(int i) {
            if (i > 0) {
                this.mVidList.add(Integer.valueOf(i));
            }
        }

        public JSONArray getAdLogParams() {
            return this.mAdLogParams;
        }

        public void setAdLogParams(JSONArray jSONArray) {
            this.mAdLogParams = jSONArray;
        }

        public String getABConfig() {
            return this.mABConfig;
        }

        public void setABConfig(String str) {
            this.mABConfig = str;
        }

        public int getAdMode() {
            return this.mAdMode;
        }

        public void setAdMode(int i) {
            this.mAdMode = i;
        }

        public int getAdModeNews() {
            return this.mAdModeNews;
        }

        public void setAdModeNews(int i) {
            this.mAdModeNews = i;
        }

        public int getContentUnionRequestType() {
            return this.mContentUnionRequestType;
        }

        public void setContentUnionRequestType(int i) {
            this.mContentUnionRequestType = i;
        }

        public Boolean getAdShakeCoverShow() {
            return this.mAdShakeCoverShow;
        }

        public void setAdShakeCoverShow(Boolean bool) {
            this.mAdShakeCoverShow = bool;
        }
    }
}
