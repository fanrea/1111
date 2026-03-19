package com.lingku.xuanshang.xutils.http.annotation;

import com.lingku.xuanshang.xutils.http.app.ResponseParser;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public @interface HttpResponse {
    Class<? extends ResponseParser> parser();
}
