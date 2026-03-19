package com.bytedance.sdk.djx.impl;

import com.bytedance.sdk.djx.IEMBaseService;
import java.lang.reflect.Method;
import kotlin.Metadata;

/* compiled from: EMBaseHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/djx/impl/EMBaseHelper;", "", "()V", "BASE_IMPL_CLASS_NAME", "", "impl", "Lcom/bytedance/sdk/djx/IEMBaseService;", "sdk_api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class EMBaseHelper {
    private static final String BASE_IMPL_CLASS_NAME = "com.bytedance.sdk.djx.core.EMBaseInternal";
    public static final EMBaseHelper INSTANCE = new EMBaseHelper();

    private EMBaseHelper() {
    }

    public final IEMBaseService impl() {
        Class<?> clsLoadClass;
        Method declaredMethod;
        ClassLoader dJXSdkClassLoader = DJXSdkStartHelper.getInstance().getDJXSdkClassLoader();
        if (dJXSdkClassLoader == null) {
            clsLoadClass = null;
        } else {
            try {
                clsLoadClass = dJXSdkClassLoader.loadClass(BASE_IMPL_CLASS_NAME);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        Object objInvoke = (clsLoadClass == null || (declaredMethod = clsLoadClass.getDeclaredMethod("service", new Class[0])) == null) ? null : declaredMethod.invoke(null, new Object[0]);
        if (objInvoke instanceof IEMBaseService) {
            return (IEMBaseService) objInvoke;
        }
        return null;
    }
}
