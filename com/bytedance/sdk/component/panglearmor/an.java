package com.bytedance.sdk.component.panglearmor;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.mq;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static String d;
    private static h tc;
    private static AtomicBoolean hc = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static String c = "";
    private static long u = 0;
    private static int an = 0;
    private static hc h = null;
    private static volatile DisplayManager.DisplayListener gb = null;
    private static volatile boolean tt = false;

    public static void d(h hVar) {
        tc = hVar;
    }

    public static void d() {
        try {
            Context contextC = c();
            if (!u() || b.getAndSet(true) || contextC == null) {
                return;
            }
            if (h != null) {
                hc.d((Application) contextC).hc((Application) contextC);
                h = null;
            }
            if (Build.VERSION.SDK_INT < 17 || gb == null) {
                return;
            }
            ((DisplayManager) contextC.getSystemService("display")).unregisterDisplayListener(gb);
            tt = false;
            gb = null;
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    public static String hc() {
        if (tt.hc() && tc != null) {
            final Handler handlerD = com.bytedance.sdk.component.utils.gb.d();
            final gb gbVarH = h();
            handlerD.post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.an.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!an.b.get()) {
                            hc unused = an.h = hc.d((Application) an.tc.d());
                            an.hc(handlerD);
                        }
                        u.d(an.tc.d());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        Object objD = an.d(1001, new Object[]{an.tc.d()});
                        if (objD instanceof String) {
                            String unused2 = an.c = (String) objD;
                        }
                    } catch (Throwable th) {
                        String unused3 = an.c = an.hc(th);
                    }
                    if (gbVarH == null || an.hc.getAndSet(true)) {
                        return;
                    }
                    JSONObject jSONObjectD = com.bytedance.sdk.component.panglearmor.d.d.d().d(an.tc.d(), an.tc.hc());
                    if (jSONObjectD != null && jSONObjectD.length() > 0) {
                        gbVarH.d("detailed_app_info", jSONObjectD);
                    }
                    an.hc.set(false);
                }
            });
        }
        if (TextUtils.isEmpty(c)) {
            String strGc = SoftDecTool.gc();
            if (!TextUtils.isEmpty(strGc)) {
                c = strGc;
            }
        }
        return TextUtils.isEmpty(c) ? "eyJzdHRzIjoxfQ==" : c;
    }

    @DungeonFlag
    public static Object d(int i, Object[] objArr) {
        return SoftDecTool.cn(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void hc(Handler handler) {
        if (!tt.hc() || tt || c() == null) {
            return;
        }
        tt = true;
        if (Build.VERSION.SDK_INT >= 17) {
            if (gb == null) {
                gb = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglearmor.an.2
                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayAdded(int i) {
                        if (i != 0) {
                            try {
                                an.d(1003, new Object[]{Integer.valueOf(i), an.c()});
                            } catch (Throwable th) {
                                mq.d(th);
                            }
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayRemoved(int i) {
                        if (i != 0) {
                            try {
                                an.d(1004, new Object[]{Integer.valueOf(i), an.c()});
                            } catch (Throwable th) {
                                mq.d(th);
                            }
                        }
                    }

                    @Override // android.hardware.display.DisplayManager.DisplayListener
                    public void onDisplayChanged(int i) {
                        if (i != 0) {
                            try {
                                an.d(1005, new Object[]{Integer.valueOf(i), an.c()});
                            } catch (Throwable th) {
                                mq.d(th);
                            }
                        }
                    }
                };
            }
            ((DisplayManager) c().getSystemService("display")).registerDisplayListener(gb, handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String hc(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            c = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            mq.d(th2);
            c = "eyJzdHRzIjozfQ==";
        }
        return c;
    }

    @DungeonFlag
    public static void d(final MotionEvent motionEvent) {
        if (motionEvent == null || !tt.hc() || c() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.bytedance.sdk.component.utils.gb.d().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.an.3
                @Override // java.lang.Runnable
                public void run() {
                    an.d(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), an.c()});
                }
            });
        }
    }

    @DungeonFlag
    public static void d(long j, int i) {
        u = j;
        an = i;
    }

    public static String d(String str, long j, int i, boolean z) {
        try {
            hc hcVar = h;
            if (hcVar != null) {
                return hcVar.d(str, j, i, z);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(String str, String str2) {
        Object objD = d(1010, new String[]{str, str2});
        return objD instanceof String ? (String) objD : str2;
    }

    public static String b() {
        if (d == null) {
            Object objD = d(1011, new Object[0]);
            if (objD instanceof String) {
                d = (String) objD;
            }
        }
        String str = d;
        return str != null ? str : "";
    }

    public static Context c() {
        h hVar = tc;
        if (hVar != null) {
            return hVar.d();
        }
        return null;
    }

    public static boolean u() {
        h hVar = tc;
        if (hVar != null) {
            return hVar.b();
        }
        return false;
    }

    public static String an() {
        h hVar = tc;
        if (hVar != null) {
            return hVar.hc();
        }
        return null;
    }

    public static gb h() {
        h hVar = tc;
        if (hVar != null) {
            return hVar.c();
        }
        return null;
    }

    public static long gb() {
        return u;
    }

    public static int tt() {
        return an;
    }
}
