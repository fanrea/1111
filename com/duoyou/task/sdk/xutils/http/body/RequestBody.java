package com.duoyou.task.sdk.xutils.http.body;

import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface RequestBody {
    long getContentLength();

    String getContentType();

    void setContentType(String str);

    void writeTo(OutputStream outputStream);
}
