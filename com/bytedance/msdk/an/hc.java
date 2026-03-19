package com.bytedance.msdk.an;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.u.an;
import com.bytedance.sdk.component.utils.mq;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static final Map<String, Boolean> d = new ConcurrentHashMap();

    static final synchronized void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.put(str, Boolean.TRUE);
    }

    public static final synchronized boolean hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean bool = d.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static synchronized void d(Context context) {
        List<com.bytedance.msdk.core.tc.d> listHc = com.bytedance.msdk.h.d.hc.d().hc();
        if (listHc != null) {
            for (com.bytedance.msdk.core.tc.d dVar : listHc) {
                final com.bytedance.msdk.api.c.d.hc.b.hc hcVarB = dVar.b();
                try {
                    if (!hc(dVar.u())) {
                        d(context, hcVarB, new com.bytedance.msdk.d.d.b() { // from class: com.bytedance.msdk.an.hc.1
                            @Override // com.bytedance.msdk.d.d.b
                            public void d() {
                                com.bytedance.msdk.an.hc.d.d(hcVarB.hc(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
                            }

                            @Override // com.bytedance.msdk.d.d.b
                            public void d(com.bytedance.msdk.api.d dVar2) {
                                if (dVar2 != null) {
                                    com.bytedance.msdk.an.hc.d.d(hcVarB.hc(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + dVar2.d + " errorMessage = " + dVar2.hc));
                                }
                            }
                        });
                        d(dVar.u());
                    }
                } catch (Exception e) {
                    mq.d(e);
                    com.bytedance.msdk.an.hc.d.d(hcVarB.hc(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, e.toString()));
                    an.d(hcVarB.hc(), (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, e.toString()));
                }
            }
            return;
        }
        an.d("", (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, "获取的自定义Adapter总配置为null"));
    }

    private static com.bytedance.msdk.api.c.d.hc.an.d d(com.bytedance.msdk.api.c.d.hc.b.hc hcVar, com.bytedance.msdk.d.d.b bVar) throws IllegalAccessException, InstantiationException {
        com.bytedance.msdk.api.c.d.hc.an.d dVarD = com.bytedance.msdk.an.hc.d.c().d(hcVar.hc());
        if (dVarD == null) {
            if (com.bytedance.msdk.core.mk.d.d().b()) {
                dVarD = new com.bytedance.msdk.d.c.d.d();
            } else if (d((Class<?>) null)) {
                try {
                    Object objNewInstance = Class.forName(hcVar.b()).newInstance();
                    if (objNewInstance instanceof com.bytedance.msdk.api.c.d.hc.an.d) {
                        dVarD = (com.bytedance.msdk.api.c.d.hc.an.d) objNewInstance;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
            com.bytedance.msdk.an.hc.d.c().d(hcVar.hc(), dVarD);
        }
        return dVarD;
    }

    private static void d(Context context, com.bytedance.msdk.api.c.d.hc.b.hc hcVar, com.bytedance.msdk.d.d.b bVar) throws Exception {
        if (hcVar == null || TextUtils.isEmpty(hcVar.b())) {
            if (hcVar == null) {
                throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置为null");
            }
            throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置初始化类名为空");
        }
        com.bytedance.msdk.api.c.d.hc.an.d dVarD = d(hcVar, bVar);
        if (dVarD != null) {
            if (!dVarD.c()) {
                d(context, hcVar, dVarD);
            }
            bVar.d();
            return;
        }
        throw new Exception("GMCustomAdapterConfiguration is null");
    }

    private static void d(Context context, com.bytedance.msdk.api.c.d.hc.b.hc hcVar, com.bytedance.msdk.api.c.d.hc.an.d dVar) {
        if (context == null) {
            an.d(hcVar.hc(), (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, "context为null"));
            return;
        }
        try {
            dVar.hc(context.getApplicationContext(), hcVar, com.bytedance.msdk.core.d.mk().us());
        } catch (Exception e) {
            an.d(hcVar.hc(), (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, "调用自定义Adapter初始化方法出现异常 " + e.getClass().getName()));
            mq.d(e);
        }
    }

    private static boolean d(Class<?> cls) throws NoSuchMethodException, SecurityException {
        String strD;
        if (!hc(cls, com.bytedance.msdk.api.c.d.hc.an.d.class)) {
            strD = "自定义ADN初始化失败  ---------  初始化类 " + cls.getSimpleName() + " 需要继承自自定义ADN的初始化Adapter类 d";
        } else {
            strD = d(cls, (Class<?>) com.bytedance.msdk.api.c.d.hc.an.d.class);
        }
        if (TextUtils.isEmpty(strD)) {
            return true;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK_SDK_Init", strD);
        an.d("", (com.bytedance.msdk.hc.b) null, (com.bytedance.msdk.api.d.hc) null, (tc) null, new com.bytedance.msdk.api.d(49013, strD));
        return false;
    }

    public static String d(Class<?> cls, Class<?> cls2) throws NoSuchMethodException, SecurityException {
        for (Method method : cls2.getMethods()) {
            HashSet hashSet = new HashSet();
            for (Method method2 : Object.class.getMethods()) {
                hashSet.add(method2.getName());
            }
            if (!hashSet.contains(method.getName())) {
                try {
                    cls.getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e) {
                    mq.d(e);
                    return "自定义ADN校验API失败接入API不符合版本需求，不符合的API的方法名为 " + method.getName();
                }
            }
        }
        return "";
    }

    public static boolean hc(Class<?> cls, Class<?> cls2) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass == cls2) {
                return true;
            }
        }
        return false;
    }

    public static synchronized void d(Context context, String str) {
        if (!hc(str)) {
            d(context);
        }
    }
}
