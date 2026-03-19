package com.bytedance.sdk.djx.model;

import com.bytedance.sdk.commonsdk.api.model.CommonError;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXError extends CommonError {
    public static DJXError build() {
        return new DJXError();
    }

    public static DJXError build(int i, String str) {
        return new DJXError().code(i).msg(str);
    }

    @Override // com.bytedance.sdk.commonsdk.api.model.CommonError
    public DJXError code(int i) {
        return (DJXError) super.code(i);
    }

    @Override // com.bytedance.sdk.commonsdk.api.model.CommonError
    public DJXError msg(String str) {
        return (DJXError) super.msg(str);
    }

    @Override // com.bytedance.sdk.commonsdk.api.model.CommonError
    public DJXError subCode(String str) {
        return (DJXError) super.subCode(str);
    }

    @Override // com.bytedance.sdk.commonsdk.api.model.CommonError
    public DJXError reqId(String str) {
        return (DJXError) super.reqId(str);
    }

    @Override // com.bytedance.sdk.commonsdk.api.model.CommonError
    public Map<Object, Object> getOthers() {
        return super.getOthers();
    }

    @Override // com.bytedance.sdk.commonsdk.api.model.CommonError
    public DJXError addOther(Object obj, Object obj2) {
        return (DJXError) super.addOther(obj, obj2);
    }

    @Override // com.bytedance.sdk.commonsdk.api.model.CommonError
    public String toString() {
        return "DJXError{code=" + this.code + ", msg='" + this.msg + "', subCode=" + this.subCode + ", requestId='" + this.requestId + "', others=" + this.others + '}';
    }
}
