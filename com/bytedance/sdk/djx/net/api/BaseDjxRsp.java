package com.bytedance.sdk.djx.net.api;

import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.utils.CommonConvertDjxUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BaseDjxRsp<T> extends BaseRsp<T> {
    @Override // com.bytedance.sdk.djx.net.api.BaseRsp
    public void setCode(int i) {
        super.setCode(i);
        TokenAccessError.valid(i);
        this.mCode = i;
    }

    @Override // com.bytedance.sdk.djx.net.api.BaseRsp
    public DJXError toDJXError() {
        return CommonConvertDjxUtils.commonErrorConvertDJXError(super.toDJXError());
    }
}
