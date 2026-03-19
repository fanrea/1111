package com.ss.android.ugc.aweme.framework.services.plugin;

import android.util.Log;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginInstaller.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/plugin/PluginInstaller;", "", "()V", "GEN_CLASS_NAME", "", "TAG", "logD", "", "msg", "onPluginInstall", "", "pluginPackageName", "spi_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class PluginInstaller {
    private static final String GEN_CLASS_NAME = "SpiPluginBinder";
    public static final PluginInstaller INSTANCE = new PluginInstaller();
    private static final String TAG = "SPIPluginInstaller";

    private PluginInstaller() {
    }

    public final boolean onPluginInstall(String pluginPackageName) {
        Intrinsics.checkParameterIsNotNull(pluginPackageName, "pluginPackageName");
        try {
            Class<?> cls = Class.forName(pluginPackageName + ".SpiPluginBinder");
            if (cls != null) {
                Object objNewInstance = cls.newInstance();
                if (objNewInstance == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.framework.services.plugin.IPluginBinder");
                }
                ((IPluginBinder) objNewInstance).bindPluginSpi();
            }
            logD("Install service for " + pluginPackageName + " success");
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            logD("Install service for " + pluginPackageName + " failed with " + th + " \n classLoader -> " + getClass().getClassLoader());
            return false;
        }
    }

    private final void logD(String msg) {
        ALog.d(TAG, msg);
        Log.d(TAG, msg);
    }
}
