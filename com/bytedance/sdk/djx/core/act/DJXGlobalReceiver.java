package com.bytedance.sdk.djx.core.act;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.djx.DJXSdk;
import com.bytedance.sdk.djx.core.init.helper.PLTHelper;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.setting.SettingsHelper;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXGlobalReceiver extends BroadcastReceiver {
    private static final List<GRListener> sListeners = new CopyOnWriteArrayList();
    private static final DJXGlobalReceiver sReceiver = new DJXGlobalReceiver();
    private static int sNetworkType = 0;
    private static final AtomicBoolean sIsFirst = new AtomicBoolean(true);

    public static void register() {
        sNetworkType = NetworkUtils.getNetworkType(InnerManager.getContext());
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            InnerManager.getContext().registerReceiver(sReceiver, intentFilter);
        } catch (Throwable unused) {
        }
    }

    public static int getNetworkType() {
        return sNetworkType;
    }

    public static void addListener(GRListener gRListener) {
        if (gRListener != null) {
            List<GRListener> list = sListeners;
            if (list.contains(gRListener)) {
                return;
            }
            list.add(gRListener);
        }
    }

    public static void removeListener(GRListener gRListener) {
        if (gRListener != null) {
            sListeners.remove(gRListener);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (DJXSdk.isStartSuccess()) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                int i = sNetworkType;
                int networkType = NetworkUtils.getNetworkType(InnerManager.getContext());
                if (networkType > 0 && !sIsFirst.get()) {
                    if (TextUtils.isEmpty(TokenHelper.getInstance().getToken())) {
                        TokenHelper.getInstance().update();
                    } else {
                        SettingsHelper.loadSettings();
                        PLTHelper.getInstance().refreshPreload2();
                    }
                }
                if (networkType != i) {
                    sNetworkType = networkType;
                    List<GRListener> list = sListeners;
                    if (list != null) {
                        for (GRListener gRListener : list) {
                            try {
                                if (gRListener != null) {
                                    gRListener.onNetChanged(i, networkType);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            sIsFirst.set(false);
        }
    }
}
