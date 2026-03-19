package com.duoyou.task.sdk.xutils.http.annotation;

import com.duoyou.task.sdk.xutils.http.app.DefaultParamsBuilder;
import com.duoyou.task.sdk.xutils.http.app.ParamsBuilder;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public @interface HttpRequest {
    Class<? extends ParamsBuilder> builder() default DefaultParamsBuilder.class;

    String[] cacheKeys() default {""};

    String host() default "";

    String path();

    String[] signs() default {""};
}
