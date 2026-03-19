package com.bytedance.rpc.annotation;

import com.bytedance.rpc.serialize.SerializeType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: RpcOption.java */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public @interface g {
    SerializeType a() default SerializeType.JSON;

    boolean b() default true;

    String[] c() default {};
}
