package org.aspectj.lang.reflect;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public interface Pointcut {
    AjType getDeclaringType();

    int getModifiers();

    String getName();

    String[] getParameterNames();

    AjType<?>[] getParameterTypes();

    PointcutExpression getPointcutExpression();
}
