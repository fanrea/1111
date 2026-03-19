package com.duoyou.task.sdk.xutils.http.body;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class UrlEncodedBody implements RequestBody {
    private String charset;
    private byte[] content;

    public UrlEncodedBody(List<KeyValue> list, String str) {
        this.charset = "UTF-8";
        if (!TextUtils.isEmpty(str)) {
            this.charset = str;
        }
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (KeyValue keyValue : list) {
                String str2 = keyValue.key;
                String valueStrOrNull = keyValue.getValueStrOrNull();
                if (!TextUtils.isEmpty(str2) && valueStrOrNull != null) {
                    if (sb.length() > 0) {
                        sb.append(a.n);
                    }
                    sb.append(URLEncoder.encode(str2, this.charset).replaceAll("\\+", "%20")).append("=").append(URLEncoder.encode(valueStrOrNull, this.charset).replaceAll("\\+", "%20"));
                }
            }
        }
        this.content = sb.toString().getBytes(this.charset);
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.content.length;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void setContentType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LogUtil.w("ignored Content-Type: " + str);
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public String getContentType() {
        return "application/x-www-form-urlencoded;charset=" + this.charset;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.content);
        outputStream.flush();
    }
}
