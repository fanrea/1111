package com.bytedance.sdk.djx.net.api;

import com.bytedance.sdk.djx.net.token.Token;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class TokenRsp extends BaseRsp<Token> {
    private String mDid;

    public String getDid() {
        return this.mDid;
    }

    public void setDid(String str) {
        this.mDid = str;
    }
}
