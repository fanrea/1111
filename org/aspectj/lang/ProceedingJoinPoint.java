package org.aspectj.lang;

import org.aspectj.runtime.internal.AroundClosure;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public interface ProceedingJoinPoint extends JoinPoint {
    Object proceed();

    Object proceed(Object[] objArr);

    void set$AroundClosure(AroundClosure aroundClosure);
}
