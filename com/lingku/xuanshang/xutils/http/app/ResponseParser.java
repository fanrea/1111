package com.lingku.xuanshang.xutils.http.app;

import java.lang.reflect.Type;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface ResponseParser<ResponseDataType> extends RequestInterceptListener {
    Object parse(Type type, Class<?> cls, ResponseDataType responsedatatype);
}
