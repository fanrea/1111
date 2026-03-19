package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.mk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc {
    private static volatile tc d;
    private boolean hc;
    private final List<ZeusPluginStateListener> b = new CopyOnWriteArrayList();
    private final List<ZeusPluginEventCallback> c = new ArrayList();
    private final Handler u = new Handler(Looper.getMainLooper());
    private ZeusPluginDecodeCallback an = null;
    private Map<String, JSONObject> h = new ConcurrentHashMap();

    public static tc d() {
        if (d == null) {
            synchronized (tc.class) {
                if (d == null) {
                    d = new tc();
                }
            }
        }
        return d;
    }

    synchronized void d(Application application) {
        if (this.hc) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        d(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application == null) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "context is null");
            throw new IllegalArgumentException("context must be not null !!!");
        }
        ZeusLogger.setDebug(globalParam.isDebug());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
        com.bytedance.pangle.u.u.hc(new Runnable() { // from class: com.bytedance.pangle.tc.1
            @Override // java.lang.Runnable
            public void run() {
                mk.hc();
            }
        });
        if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
            com.bytedance.pangle.an.an.d();
        }
        com.bytedance.pangle.c.hc.d().d(new com.bytedance.pangle.c.d() { // from class: com.bytedance.pangle.tc.2
            @Override // com.bytedance.pangle.c.d
            public void d(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                com.bytedance.pangle.log.hc.d(str, jSONObject, jSONObject2, jSONObject3);
            }
        });
        if (!globalParam.isCloseFlipped()) {
            hc.d();
        }
        if (com.bytedance.pangle.util.tt.w()) {
            com.bytedance.pangle.u.u.d(new Runnable() { // from class: com.bytedance.pangle.tc.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                        MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                    } catch (Throwable th) {
                        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th)));
                    }
                }
            });
        }
        if (com.bytedance.pangle.util.tt.e()) {
            h();
        }
        an();
        ContentProviderManager.getInstance().initSystemContentProviderInfo();
        if (!globalParam.closeHookHuaweiOnInit()) {
            Zeus.hookHuaWeiVerifier(application);
        }
        this.hc = true;
        d(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
    }

    private void an() throws PackageManager.NameNotFoundException {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "start");
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (!TextUtils.isEmpty(providerInfo.authority) && providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                        String str = (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) ? LiveConfigKey.MAIN : providerInfo.processName.split(":")[1];
                        if (Zeus.getServerManagerHashMap().get(str) == null || !TextUtils.equals(str, LiveConfigKey.MAIN) || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    public boolean hc() {
        return this.hc;
    }

    public List<ZeusPluginStateListener> b() {
        return this.b;
    }

    public void d(ZeusPluginStateListener zeusPluginStateListener) {
        this.b.add(zeusPluginStateListener);
    }

    public void hc(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void d(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.c) {
            this.c.add(zeusPluginEventCallback);
        }
    }

    public void hc(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.c) {
            this.c.remove(zeusPluginEventCallback);
        }
    }

    public void d(final int i, final int i2, final String str, final int i3, final Throwable th) {
        for (final Object obj : gb()) {
            this.u.post(new Runnable() { // from class: com.bytedance.pangle.tc.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void h() {
        try {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
            FieldUtils.writeField(com.bytedance.pangle.u.d.d(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    private Object[] gb() {
        Object[] array;
        synchronized (this.c) {
            array = !this.c.isEmpty() ? this.c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public void d(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        this.an = zeusPluginDecodeCallback;
    }

    public ZeusPluginDecodeCallback c() {
        return this.an;
    }

    public Map<String, JSONObject> u() {
        return this.h;
    }
}
