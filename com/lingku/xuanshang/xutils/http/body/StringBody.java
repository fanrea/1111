package com.lingku.xuanshang.xutils.http.body;

import android.text.TextUtils;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class StringBody implements RequestBody {
    public byte[] a;
    public String b;
    public String c;

    public StringBody(String str, String str2) {
        this.c = "UTF-8";
        if (!TextUtils.isEmpty(str2)) {
            this.c = str2;
        }
        this.a = str.getBytes(this.c);
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.a.length;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public String getContentType() {
        return TextUtils.isEmpty(this.b) ? "application/json;charset=" + this.c : this.b;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void setContentType(String str) {
        this.b = str;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.a);
        outputStream.flush();
    }
}
