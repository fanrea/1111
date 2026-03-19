package com.kuaishou.common.netty.function;

import java.lang.Throwable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface FunctionWithThrowable<T, R, X extends Throwable> {
    R apply(T t);
}
