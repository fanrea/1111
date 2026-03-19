package com.bytedance.sdk.djx.ad;

import android.content.res.Resources;
import android.os.Bundle;
import com.bykv.vk.openvk.TTPluginListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OppoPluginListener implements TTPluginListener {
    public static OppoPluginListener INSTANCE = new OppoPluginListener();
    private IPluginListener pluginListener;

    public void setPluginListener(IPluginListener iPluginListener) {
        this.pluginListener = iPluginListener;
    }

    public void onPluginListener(int i, ClassLoader classLoader, Resources resources, Bundle bundle) {
        this.pluginListener.onPluginListener(i, classLoader, resources, bundle);
    }

    public String packageName() {
        return this.pluginListener.packageName();
    }

    public Bundle config() {
        return this.pluginListener.config();
    }
}
