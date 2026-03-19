package com.lingku.xuanshang.xutils.http.request;

import com.lingku.xuanshang.xutils.http.RequestParams;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AssetsRequest extends ResRequest {
    public AssetsRequest(RequestParams requestParams, Type type) {
        super(requestParams, type);
    }

    @Override // com.lingku.xuanshang.xutils.http.request.ResRequest, com.lingku.xuanshang.xutils.http.request.UriRequest
    public InputStream getInputStream() throws IOException {
        if (this.inputStream == null) {
            this.inputStream = this.params.getContext().getResources().getAssets().open(this.queryUrl.replace("assets://", ""));
            this.contentLength = r0.available();
        }
        return this.inputStream;
    }
}
