package com.lingku.xuanshang.xutils.view.annotation;

import android.view.View;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public @interface Event {
    String method() default "";

    int[] parentId() default {0};

    String setter() default "";

    Class<?> type() default View.OnClickListener.class;

    int[] value();
}
