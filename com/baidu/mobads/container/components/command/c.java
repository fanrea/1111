package com.baidu.mobads.container.components.command;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.container.components.c.a;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.i;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.au;
import com.baidu.mobads.container.util.ay;
import com.baidu.mobads.container.util.bj;
import com.baidu.mobads.container.util.bp;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.t;
import com.baidu.mobads.container.util.x;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobstat.forbes.Config;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c implements a.InterfaceC0121a, Observer {
    public static final String a = "OAdRemoteApkDownloaderObserver";
    private static NotificationManager c;
    private static int d = 10091;
    private static HashMap<String, c> m = new HashMap<>();
    private j e;
    private Context f;
    private com.baidu.mobads.container.components.e.b k;
    private com.baidu.mobads.container.components.c.g g = null;
    private List<WeakReference<IOAdEventListener>> h = new ArrayList();
    private String i = "";
    private com.baidu.mobads.container.components.command.a j = new com.baidu.mobads.container.components.command.a();
    public boolean b = false;
    private final a l = new a();
    private Handler n = new Handler(Looper.getMainLooper());

    public j a() {
        return this.e;
    }

    public static synchronized c a(String str) {
        return m.get(str);
    }

    public static synchronized c b(String str) {
        return m.remove(str);
    }

    public static synchronized void a(String str, c cVar) {
        m.put(str, cVar);
    }

    public static synchronized int c(String str) {
        c cVar = m.get(str);
        if (cVar != null && cVar.a() != null) {
            return cVar.a().W;
        }
        int i = d;
        d = i + 1;
        return i;
    }

    public c(Context context, j jVar) {
        this.e = null;
        bq.a().a(a, "observer created");
        if (c == null) {
            c = (NotificationManager) context.getSystemService("notification");
        }
        if (x.a(context).a() >= 26) {
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("down", "下载信息", 2));
        }
        this.f = context.getApplicationContext();
        this.e = jVar;
        a(this.e.Z, this);
    }

    public void a(IOAdEventListener iOAdEventListener) {
        if (iOAdEventListener != null) {
            for (WeakReference<IOAdEventListener> weakReference : this.h) {
                if (weakReference != null && weakReference.get() == iOAdEventListener) {
                    return;
                }
            }
            this.h.add(new WeakReference<>(iOAdEventListener));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) throws IOException {
        String str;
        String lastPathSegment;
        int iH;
        com.baidu.mobads.container.components.e.b bVar = (com.baidu.mobads.container.components.e.b) observable;
        this.k = bVar;
        this.e.X = bVar.i();
        if (this.e.X == b.a.DOWNLOADING) {
            if (this.e.U < 0) {
                bq.a().a(a, "download update---mExtraInfo.contentLength < 0");
                this.e.U = bVar.g();
                this.e.ab = bVar.t();
                this.e.b(this.f);
                this.i = String.format(Locale.CHINA, "%.1fM", Float.valueOf(this.e.U / 1048576.0f));
            }
            if (bVar.h() > 0.0f && (iH = (int) bVar.h()) > this.e.V) {
                this.e.V = iH;
                if (this.e.ad) {
                    a(bVar);
                }
            }
        } else {
            bp bpVarA = bp.a();
            if (this.e.X == b.a.COMPLETED) {
                this.e.T = bVar.m();
                this.e.S = bVar.n();
                String str2 = this.e.T + this.e.S;
                t.a aVarE = t.e(this.f, str2);
                if (aVarE != null) {
                    if (!TextUtils.isEmpty(aVarE.c) && !aVarE.c.equals(this.e.Z)) {
                        this.e.b(this.f);
                        this.e.Z = aVarE.c;
                    }
                } else {
                    a(bVar, "Parse APK file error.");
                }
                a(302, false);
                a(this.e, com.baidu.mobads.container.components.h.a.EVENT_DL_COMPLETE);
                bq.a().a(a, "download success-->>" + bVar.l());
                boolean z = this.e.ac;
                com.baidu.mobads.container.components.c.g.a().a(this.f, this.e);
                com.baidu.mobads.container.components.c.g.a().a(this.e.Z, this);
                if (!z) {
                    str = "complete";
                } else {
                    bq.a().a(a, "launch installing .............");
                    if (com.baidu.mobads.container.util.j.b(this.f, this.e.Z)) {
                        a(this.e, com.baidu.mobads.container.components.h.a.EVENT_DL_OPEN);
                        bj.b(this.f, this.e.Z);
                        a(301, true);
                        str = bp.a;
                    } else {
                        a(this.e, com.baidu.mobads.container.components.h.a.EVENT_DL_INSTALL);
                        com.baidu.mobads.container.util.j.a(this.f, new File(str2), this.e);
                        str = bp.b;
                    }
                }
                a(this.e, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
                bpVarA.a(this.f, bu.h, str, this.e);
                this.j.d(this.f, this.e);
                com.baidu.mobads.container.components.d.b.a().a(this.f, this.e);
                if (aVarE != null && !TextUtils.isEmpty(aVarE.c) && i.a.a.equals(aVarE.c)) {
                    au.b(str2, this.e.T + ap.a(i.a.a) + ".apk");
                    if (TextUtils.isEmpty(this.e.aa)) {
                        lastPathSegment = "";
                    } else {
                        lastPathSegment = Uri.parse(this.e.aa).getLastPathSegment();
                    }
                    by.a.a(this.f).a(1026).a(this.e.l()).a("qk", this.e.ae).a("adid", this.e.ag).a("act", "0").a(j.f, this.e.af).a("lastPath", lastPathSegment).a("evt", com.alipay.sdk.m.k.b.m).f();
                }
            } else if (this.e.X == b.a.ERROR) {
                a(bVar, bVar.o());
            } else if (bVar.i() == b.a.INITING) {
                this.e.an++;
            } else if (bVar.i() == b.a.PAUSED) {
                this.j.c(this.f, this.e);
                this.e.c("pause_reason", String.valueOf(bVar.p()));
                bpVarA.a(this.f, 406, "download_paused", this.e);
                a(303, true);
                a(this.e, com.baidu.mobads.container.components.h.a.EVENT_DL_PAUSE);
                a(this.e, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
            } else if (bVar.i() == b.a.CANCELLED) {
                bpVarA.a(this.f, bu.l, "download_cancel", this.e);
            }
            if (this.e.ad) {
                a(bVar);
            }
            this.e.b(this.f);
        }
        d();
    }

    public void a(com.baidu.mobads.container.components.e.b bVar) {
        this.l.a(this.f, this.e.al);
        this.n.post(new d(this, bVar));
    }

    public void b() {
        if (c != null) {
            c.cancel(this.e.W);
        }
    }

    private void a(com.baidu.mobads.container.components.e.b bVar, String str) {
        this.e.ab = bVar.t();
        bq.a().c(a, "download failed-->>" + bVar.l());
        com.baidu.mobads.container.components.d.b.a().a(this.e);
        bp.a().a(this.f, 406, "download_error", this.e, str);
        this.j.a(this.f, this.e, str);
        a(304, true);
        a(this.e, com.baidu.mobads.container.components.h.a.EVENT_DL_ERROR);
        a(this.e, com.baidu.mobads.container.components.h.a.EVENT_AD_STATE_END);
    }

    private void a(int i, boolean z) {
        try {
            String strI = this.e.i();
            String strH = this.e.h();
            HashMap<String, String> map = this.e.am;
            if (map != null) {
                String str = map.get("cur_qk");
                String str2 = map.get("cur_adid");
                if (!TextUtils.isEmpty(str)) {
                    strI = str;
                }
                if (!TextUtils.isEmpty(str2)) {
                    strH = str2;
                }
            }
            com.baidu.mobads.container.components.h.a.a.a().b(strI, strH, i, z);
        } catch (Throwable th) {
            bq.a().a(a, th);
        }
    }

    private void d() {
        IOAdEventListener iOAdEventListener;
        if (this.h.size() > 0) {
            try {
                for (WeakReference<IOAdEventListener> weakReference : this.h) {
                    if (weakReference != null && (iOAdEventListener = weakReference.get()) != null) {
                        this.n.post(new f(this, iOAdEventListener));
                    }
                }
            } catch (Exception e) {
                bq.a().b(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Toast.makeText(this.f, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Notification b(com.baidu.mobads.container.components.e.b bVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strC;
        String str = this.e.R;
        if (!TextUtils.isEmpty(this.e.ak)) {
            str = this.e.ak;
        }
        String str2 = "正在下载 " + str;
        b.a aVar = this.e.X;
        b.a aVar2 = b.a.COMPLETED;
        int i = R.drawable.stat_sys_download_done;
        if (aVar == aVar2) {
            str = this.e.X.c() + ": " + str;
            if (!this.b) {
                strC = " 点击这里安装应用";
            } else {
                strC = " 打开应用";
            }
        } else if (this.e.X == b.a.PAUSED) {
            str = this.e.X.c() + ": " + str;
            if (!bVar.u()) {
                strC = "目前不在wifi网络下， 点击这里继续下载";
            } else {
                strC = "点击这里继续下载";
            }
            str2 = "已为您暂停下载， 点击通知栏继续下载";
        } else if (this.e.X == b.a.ERROR) {
            str = this.e.X.c() + ": " + str;
            strC = " 稍后点击这里重新下载";
        } else {
            b.a aVar3 = this.e.X;
            b.a aVar4 = b.a.DOWNLOADING;
            i = R.drawable.stat_sys_download;
            if (aVar3 == aVar4) {
                str = this.e.X.c() + ": " + str;
                strC = "下载进度: " + this.e.V + "%  应用大小: " + this.i;
            } else if (this.e.X != b.a.INITING) {
                strC = "";
            } else {
                str = this.e.X.c() + ": " + str;
                strC = this.e.X.c();
            }
        }
        PendingIntent pendingIntentA = a("download", str, bVar.l(), bVar.u());
        if (x.a(null).a() >= 16) {
            boolean z = (this.e.X == b.a.DOWNLOADING || this.e.X == b.a.PAUSED) ? false : true;
            Notification notificationA = a(this.f, pendingIntentA, this.e);
            if (notificationA == null) {
                if (x.a(null).a() >= 26) {
                    this.e.Y = new Notification.Builder(this.f, "down");
                    return ((Notification.Builder) this.e.Y).setContentTitle(str).setContentText(strC).setTicker(str2).setSmallIcon(i).setContentIntent(pendingIntentA).setAutoCancel(z).setProgress(100, this.e.V, false).build();
                }
                this.e.Y = new Notification.Builder(this.f);
                return ((Notification.Builder) this.e.Y).setContentTitle(str).setContentText(strC).setTicker(str2).setSmallIcon(i).setContentIntent(pendingIntentA).setAutoCancel(z).setProgress(100, this.e.V, false).build();
            }
            return notificationA;
        }
        if (this.e.Y == null) {
            this.e.Y = new Notification();
        }
        Notification notification = (Notification) this.e.Y;
        notification.icon = i;
        notification.flags |= 16;
        notification.tickerText = str2;
        notification.contentIntent = pendingIntentA;
        try {
            notification.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, this.f, str, strC, pendingIntentA);
            return notification;
        } catch (IllegalAccessException e) {
            return notification;
        } catch (IllegalArgumentException e2) {
            return notification;
        } catch (NoSuchMethodException e3) {
            return notification;
        } catch (InvocationTargetException e4) {
            return notification;
        }
    }

    private PendingIntent a(String str, String str2, String str3, boolean z) {
        Intent intent = new Intent(this.f, t.e());
        intent.putExtra("activityImplName", ay.e);
        intent.putExtra("downloadAction", str);
        intent.putExtra("dealWithDownload", true);
        intent.putExtra("pausedManually", z);
        intent.putExtra("status", this.e.X.b());
        intent.putExtra("pk", this.e.Z);
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("localApkPath", str3);
        } else {
            intent.putExtra("localApkPath", this.e.T + this.e.S);
        }
        intent.putExtra("title", str2);
        intent.addFlags(268435456);
        intent.setAction(Long.toString(System.currentTimeMillis()));
        return PendingIntent.getActivity(this.f, this.e.W, intent, 201326592);
    }

    private void a(j jVar, com.baidu.mobads.container.components.h.a aVar) {
    }

    @Override // com.baidu.mobads.container.components.c.a.InterfaceC0121a
    public boolean a(Context context, Intent intent) {
        if (this.e.ad) {
            this.b = true;
            a(this.k);
        }
        d();
        return false;
    }

    private Notification a(Context context, PendingIntent pendingIntent, j jVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        int i;
        boolean z2;
        String str6 = jVar.R;
        if (jVar.ak != null && !jVar.ak.isEmpty()) {
            str = jVar.ak;
        } else {
            str = str6;
        }
        String str7 = "正在下载 " + str;
        b.a aVar = jVar.X;
        if (aVar == b.a.INITING) {
            str2 = "下载准备中";
            str3 = str7;
            str4 = "暂停";
            str5 = "取消下载";
            z = false;
            i = 0;
            z2 = true;
        } else if (aVar == b.a.DOWNLOADING) {
            int i2 = jVar.V;
            str2 = "下载进度: " + i2 + "%  应用大小: " + a(jVar.U);
            str4 = "暂停";
            str5 = "取消下载";
            z = false;
            z2 = false;
            i = i2;
            str3 = str7;
        } else if (aVar == b.a.PAUSED) {
            i = jVar.V;
            str2 = "已为您暂停下载, 请点击继续下载";
            str4 = "继续";
            str5 = "取消下载";
            z = false;
            z2 = false;
            str3 = str2;
        } else if (aVar == b.a.ERROR) {
            str2 = "稍后点击这里重新下载";
            str4 = "下载";
            str5 = "取消下载";
            z = false;
            i = -1;
            z2 = false;
            str3 = "已为您暂停下载, 请点击重新下载";
        } else if (aVar != b.a.COMPLETED) {
            str2 = null;
            str3 = str7;
            str4 = "暂停";
            str5 = "取消下载";
            z = false;
            i = -1;
            z2 = false;
        } else if (this.b) {
            str2 = "安装完成, 请点击打开";
            str4 = "打开";
            str5 = "";
            z = true;
            i = -1;
            z2 = false;
            str3 = str7;
        } else {
            str2 = "下载完成, 请点击安装";
            str4 = "安装";
            str5 = "";
            z = true;
            i = -1;
            z2 = false;
            str3 = str7;
        }
        return a(context, str3, z, this.l.a(), str, str2, i, z2, str4, pendingIntent, str5, a("cancel", str, "", false));
    }

    private String a(long j) {
        long j2 = (j / 1024) / 1024;
        return j2 > 1000 ? String.format(Locale.CHINA, "%.1fG", Float.valueOf(j2 / 1024.0f)) : String.format(Locale.CHINA, "%.1fM", Float.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        private final AtomicBoolean a = new AtomicBoolean(false);
        private volatile Bitmap b;

        public Bitmap a() {
            return this.b;
        }

        public void b() {
            this.a.set(false);
            if (this.b != null) {
                this.b = null;
            }
        }

        public void a(Context context, String str) {
            if (context == null || this.a.getAndSet(true)) {
                return;
            }
            com.baidu.mobads.container.util.d.d.a(context).a(str, (com.baidu.mobads.container.util.d.a) new g(this));
        }
    }

    private Notification a(Context context, String str, boolean z, Bitmap bitmap, String str2, String str3, int i, boolean z2, String str4, PendingIntent pendingIntent, String str5, PendingIntent pendingIntent2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("context", context);
            jSONObject.put(Config.INPUT_DEF_VERSION, 1);
            jSONObject.put("ticker", str);
            jSONObject.put("icon", bitmap);
            jSONObject.put("title", str2);
            jSONObject.put("content", str3);
            jSONObject.put("autoCancel", z);
            jSONObject.put("progress", i);
            jSONObject.put("indeterminate", z2);
            jSONObject.put("action", str4);
            jSONObject.put("pendingIntent", pendingIntent);
            jSONObject.put("action2", str5);
            jSONObject.put("pendingIntent2", pendingIntent2);
            ICommonModuleObj iCommonModuleObjK = com.baidu.mobads.container.config.b.a().k();
            if (iCommonModuleObjK == null) {
                return null;
            }
            return (Notification) iCommonModuleObjK.createModuleObj(ICommonModuleObj.KEY_NOTIFICATION, jSONObject);
        } catch (Throwable th) {
            bq.a().d(th);
            return null;
        }
    }
}
