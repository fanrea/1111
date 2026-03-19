package com.bytedance.sdk.commonsdk.api.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonError {
    public int code;
    public String msg;
    public Map<Object, Object> others;
    public String requestId;
    public String subCode;

    public static CommonError build() {
        return new CommonError();
    }

    public static CommonError build(int i, String str) {
        return new CommonError().code(i).msg(str);
    }

    public CommonError code(int i) {
        this.code = i;
        return this;
    }

    public CommonError msg(String str) {
        this.msg = str;
        return this;
    }

    public CommonError subCode(String str) {
        this.subCode = str;
        return this;
    }

    public CommonError reqId(String str) {
        this.requestId = str;
        return this;
    }

    public Map<Object, Object> getOthers() {
        if (this.others == null) {
            this.others = new HashMap();
        }
        return this.others;
    }

    public CommonError addOther(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            if (this.others == null) {
                this.others = new HashMap();
            }
            this.others.put(obj, obj2);
        }
        return this;
    }

    public String toString() {
        return "CommonError{code=" + this.code + ", msg='" + this.msg + "', subCode=" + this.subCode + ", requestId='" + this.requestId + "', others=" + this.others + '}';
    }
}
