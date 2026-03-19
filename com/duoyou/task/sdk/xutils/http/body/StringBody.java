package com.duoyou.task.sdk.xutils.http.body;

import android.text.TextUtils;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class StringBody implements RequestBody {
    private String charset;
    private byte[] content;
    private String contentType;

    public StringBody(String str, String str2) {
        this.charset = "UTF-8";
        if (!TextUtils.isEmpty(str2)) {
            this.charset = str2;
        }
        this.content = str.getBytes(this.charset);
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.content.length;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void setContentType(String str) {
        this.contentType = str;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public String getContentType() {
        return TextUtils.isEmpty(this.contentType) ? "application/json;charset=" + this.charset : this.contentType;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.content);
        outputStream.flush();
    }
}
