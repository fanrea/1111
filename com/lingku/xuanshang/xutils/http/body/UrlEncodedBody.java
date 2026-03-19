package com.lingku.xuanshang.xutils.http.body;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.lingku.xuanshang.xutils.common.util.KeyValue;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class UrlEncodedBody implements RequestBody {
    public byte[] a;
    public String b;

    public UrlEncodedBody(List<KeyValue> list, String str) {
        this.b = "UTF-8";
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
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
                    sb.append(URLEncoder.encode(str2, this.b).replaceAll("\\+", "%20")).append("=").append(URLEncoder.encode(valueStrOrNull, this.b).replaceAll("\\+", "%20"));
                }
            }
        }
        this.a = sb.toString().getBytes(this.b);
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.a.length;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public String getContentType() {
        return "application/x-www-form-urlencoded;charset=" + this.b;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void setContentType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LogUtil.w("ignored Content-Type: " + str);
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.a);
        outputStream.flush();
    }
}
