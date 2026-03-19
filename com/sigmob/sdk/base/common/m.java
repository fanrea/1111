package com.sigmob.sdk.base.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.m;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.l;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class m {
    private static final HashMap<String, com.sigmob.sdk.downloader.f> a = new HashMap<>();

    /* renamed from: com.sigmob.sdk.base.common.m$2, reason: invalid class name */
    class AnonymousClass2 extends com.sigmob.sdk.downloader.h {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ List c;
        private l.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, final Context val$context, final String val$url, final List val$trackers) {
            super(context);
            this.a = val$context;
            this.b = val$url;
            this.c = val$trackers;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Exception exc, String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                pointEntitySigmob.getOptions().put("error", exc.getMessage());
                pointEntitySigmob.getOptions().put("url", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, com.sigmob.sdk.videoAd.d dVar, Object obj) {
            PointEntitySigmob pointEntitySigmob;
            Map options;
            int i;
            if (obj instanceof PointEntitySigmob) {
                pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("url", str);
                String event = dVar.getEvent();
                event.hashCode();
                switch (event) {
                    case "download_quarter":
                        options = pointEntitySigmob.getOptions();
                        i = 25;
                        break;
                    case "download_three_quarter":
                        options = pointEntitySigmob.getOptions();
                        i = 75;
                        break;
                    case "download_two_quarter":
                        options = pointEntitySigmob.getOptions();
                        i = 50;
                        break;
                    default:
                        return;
                }
                options.put("status", String.valueOf(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("status", String.valueOf(1));
                pointEntitySigmob.getOptions().put("url", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("status", String.valueOf(1));
                pointEntitySigmob.getOptions().put("url", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("status", String.valueOf(1));
                pointEntitySigmob.getOptions().put("url", str);
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void a(final com.sigmob.sdk.downloader.f task) {
            this.e = l.a.COMPLETED;
            super.a(task);
            WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.m.2.1
                @Override // java.lang.Runnable
                public void run() {
                    o.a(AnonymousClass2.this.a, task.n().getAbsolutePath(), (BaseAdUnit) null);
                }
            });
            final String str = this.b;
            ac.a(PointCategory.APKDOWNLOAD, PointCategory.END, (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.base.common.m$2$$ExternalSyntheticLambda3
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass2.c(str, obj);
                }
            });
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0736a
        public void a(com.sigmob.sdk.downloader.f task, int blockCount, long currentOffset, long totalLength) {
            super.a(task, blockCount, currentOffset, totalLength);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0736a
        public void a(com.sigmob.sdk.downloader.f task, long currentOffset, long totalLength) {
            this.e = l.a.RUNNING;
            super.a(task, currentOffset, totalLength);
            List<com.sigmob.sdk.videoAd.d> listA = com.sigmob.sdk.videoAd.d.a(this.c, com.sigmob.sdk.base.common.a.p, currentOffset, totalLength);
            if (com.sigmob.sdk.base.utils.e.a(listA)) {
                return;
            }
            for (final com.sigmob.sdk.videoAd.d dVar : listA) {
                dVar.setTracked();
                final String str = this.b;
                ac.a(PointCategory.APKDOWNLOAD, "progress", (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.base.common.m$2$$ExternalSyntheticLambda0
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        m.AnonymousClass2.a(str, dVar, obj);
                    }
                });
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void a(com.sigmob.sdk.downloader.f task, final Exception e) {
            this.e = l.a.UNKNOWN;
            super.a(task, e);
            if (task.C()) {
                return;
            }
            ai.a(this.a, "下载失败，" + e.getMessage(), 1).show();
            final String str = this.b;
            ac.a(PointCategory.APKDOWNLOAD, PointCategory.END, (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.base.common.m$2$$ExternalSyntheticLambda4
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass2.a(e, str, obj);
                }
            });
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void b(com.sigmob.sdk.downloader.f task) {
            this.e = l.a.RUNNING;
            super.b(task);
            final String str = this.b;
            ac.a(PointCategory.APKDOWNLOAD, "start", (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.base.common.m$2$$ExternalSyntheticLambda2
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass2.b(str, obj);
                }
            });
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void c(com.sigmob.sdk.downloader.f task) {
            if (this.e == l.a.CANCELED) {
                return;
            }
            this.e = l.a.CANCELED;
            super.c(task);
            final String str = this.b;
            ac.a(PointCategory.APKDOWNLOAD, "pause", (BaseAdUnit) null, new ac.a() { // from class: com.sigmob.sdk.base.common.m$2$$ExternalSyntheticLambda1
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass2.a(str, obj);
                }
            });
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.m$3, reason: invalid class name */
    class AnonymousClass3 extends com.sigmob.sdk.downloader.h {
        final /* synthetic */ BaseAdUnit a;
        final /* synthetic */ Context b;
        private l.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, final BaseAdUnit val$adUnit, final Context val$context) {
            super(context);
            this.a = val$adUnit;
            this.b = val$context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Context context, com.sigmob.sdk.downloader.f fVar, BaseAdUnit baseAdUnit) {
            o.a(context, fVar.n().getAbsolutePath(), baseAdUnit);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(com.sigmob.sdk.videoAd.d dVar, Object obj) {
            PointEntitySigmob pointEntitySigmob;
            Map options;
            int i;
            if (obj instanceof PointEntitySigmob) {
                pointEntitySigmob = (PointEntitySigmob) obj;
                String event = dVar.getEvent();
                event.hashCode();
                switch (event) {
                    case "download_quarter":
                        options = pointEntitySigmob.getOptions();
                        i = 25;
                        break;
                    case "download_three_quarter":
                        options = pointEntitySigmob.getOptions();
                        i = 75;
                        break;
                    case "download_two_quarter":
                        options = pointEntitySigmob.getOptions();
                        i = 50;
                        break;
                    default:
                        return;
                }
                options.put("status", String.valueOf(i));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Exception exc, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                pointEntitySigmob.getOptions().put("error", exc.getMessage());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void a(final com.sigmob.sdk.downloader.f task) {
            this.c = l.a.COMPLETED;
            super.a(task);
            this.a.enableUseDownloadApk(true);
            if (this.a.isRecord()) {
                ac.b(PointCategory.DOWNLOAD_END, "1", this.a);
                com.sigmob.sdk.base.network.g.a(this.a, com.sigmob.sdk.base.common.a.H);
            }
            Handler handler = WindAds.sharedAds().getHandler();
            final Context context = this.b;
            final BaseAdUnit baseAdUnit = this.a;
            handler.post(new Runnable() { // from class: com.sigmob.sdk.base.common.m$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    m.AnonymousClass3.a(context, task, baseAdUnit);
                }
            });
            ac.a(PointCategory.APKDOWNLOAD, PointCategory.END, this.a, new ac.a() { // from class: com.sigmob.sdk.base.common.m$3$$ExternalSyntheticLambda3
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass3.c(obj);
                }
            });
            HashMap map = new HashMap();
            map.put("result", "1");
            map.put("downloadId", this.a.getDownloadId());
            BaseBroadcastReceiver.a(this.b, this.a.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0736a
        public void a(com.sigmob.sdk.downloader.f task, int blockCount, long currentOffset, long totalLength) {
            super.a(task, blockCount, currentOffset, totalLength);
            HashMap map = new HashMap();
            map.put("result", "1");
            map.put("downloadId", this.a.getDownloadId());
            BaseBroadcastReceiver.a(this.b, this.a.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0736a
        public void a(com.sigmob.sdk.downloader.f task, long currentOffset, long totalLength) {
            this.c = l.a.RUNNING;
            super.a(task, currentOffset, totalLength);
            List<com.sigmob.sdk.videoAd.d> listA = com.sigmob.sdk.videoAd.d.a(this.a.getDownloadQuarterTrack(), com.sigmob.sdk.base.common.a.p, currentOffset, totalLength);
            if (com.sigmob.sdk.base.utils.e.a(listA)) {
                return;
            }
            for (final com.sigmob.sdk.videoAd.d dVar : listA) {
                dVar.setTracked();
                ac.a(PointCategory.APKDOWNLOAD, "progress", this.a, new ac.a() { // from class: com.sigmob.sdk.base.common.m$3$$ExternalSyntheticLambda5
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj) {
                        m.AnonymousClass3.a(dVar, obj);
                    }
                });
            }
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void a(com.sigmob.sdk.downloader.f task, final Exception e) {
            this.c = l.a.UNKNOWN;
            super.a(task, e);
            if (task.C()) {
                return;
            }
            ai.a(this.b, "下载失败，" + e.getMessage(), 1).show();
            if (this.a.isRecord()) {
                ac.b(PointCategory.DOWNLOAD_END, "0", this.a);
            }
            ac.a(PointCategory.APKDOWNLOAD, PointCategory.END, this.a, new ac.a() { // from class: com.sigmob.sdk.base.common.m$3$$ExternalSyntheticLambda4
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass3.a(e, obj);
                }
            });
            HashMap map = new HashMap();
            map.put("result", "0");
            map.put("downloadId", this.a.getDownloadId());
            BaseBroadcastReceiver.a(this.b, this.a.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void b(com.sigmob.sdk.downloader.f task) {
            this.c = l.a.RUNNING;
            super.b(task);
            ac.a(PointCategory.APKDOWNLOAD, "start", this.a, new ac.a() { // from class: com.sigmob.sdk.base.common.m$3$$ExternalSyntheticLambda0
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass3.b(obj);
                }
            });
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        protected void c(com.sigmob.sdk.downloader.f task) {
            if (this.c == l.a.CANCELED) {
                return;
            }
            this.c = l.a.CANCELED;
            super.c(task);
            ac.a(PointCategory.APKDOWNLOAD, "pause", this.a, new ac.a() { // from class: com.sigmob.sdk.base.common.m$3$$ExternalSyntheticLambda1
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj) {
                    m.AnonymousClass3.a(obj);
                }
            });
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.m$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.a.values().length];
            a = iArr;
            try {
                iArr[l.a.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.a.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.a.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.a.CANCELED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static class a extends BroadcastReceiver {
        static final String a = "downloadButtonAction";
        static final String b = "downloadAction";
        private final com.sigmob.sdk.downloader.f c;
        private final BaseAdUnit d;
        private final String e;

        public a(com.sigmob.sdk.downloader.f task, String action_id, BaseAdUnit adUnit) {
            this.c = task;
            this.e = action_id;
            this.d = adUnit;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.c == null || TextUtils.isEmpty(this.e)) {
                return;
            }
            String action = intent.getAction();
            if (action == null || !action.equals(this.e)) {
                if (com.sigmob.sdk.downloader.l.c(this.c)) {
                    WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.m.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            o.a(com.sigmob.sdk.b.e(), a.this.c.n().getAbsolutePath(), a.this.d);
                        }
                    });
                }
            } else {
                if (!com.sigmob.sdk.downloader.l.a(this.c)) {
                    this.c.B();
                    return;
                }
                if (this.d != null) {
                    HashMap map = new HashMap();
                    map.put("result", "1");
                    map.put("downloadId", this.d.getDownloadId());
                    BaseBroadcastReceiver.a(context, this.d.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
                }
                Handler handler = WindAds.sharedAds().getHandler();
                com.sigmob.sdk.downloader.f fVar = this.c;
                Objects.requireNonNull(fVar);
                handler.postDelayed(new m$$ExternalSyntheticLambda0(fVar), 200L);
            }
        }
    }

    public static int a(Context context, BaseAdUnit adUnit) {
        com.sigmob.sdk.downloader.f downloadTask = adUnit.getDownloadTask();
        if (downloadTask == null || !com.sigmob.sdk.downloader.l.a(downloadTask)) {
            return -1;
        }
        HashMap map = new HashMap();
        map.put("result", "1");
        map.put("downloadId", adUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, adUnit.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
        Handler handler = WindAds.sharedAds().getHandler();
        Objects.requireNonNull(downloadTask);
        handler.postDelayed(new m$$ExternalSyntheticLambda0(downloadTask), 200L);
        return 0;
    }

    private static String a(BaseAdUnit adUnit, String url) {
        String apkMd5 = adUnit.getApkMd5();
        if (TextUtils.isEmpty(apkMd5)) {
            apkMd5 = Md5Util.md5(url);
        }
        return apkMd5 + ".apk";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, com.sigmob.sdk.downloader.f fVar, BaseAdUnit baseAdUnit) {
        o.a(context, fVar.n().getAbsolutePath(), baseAdUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.getOptions().put("status", String.valueOf(0));
            pointEntitySigmob.getOptions().put("error", "cancel download");
        }
    }

    protected static void a(final String url, final BaseAdUnit adUnit, boolean isMThread) {
        String str;
        Object obj;
        final String absolutePath;
        final com.sigmob.sdk.downloader.f downloadTask;
        PendingIntent broadcast;
        com.sigmob.sdk.downloader.core.breakpoint.g gVarC;
        final Context contextE = com.sigmob.sdk.b.e();
        try {
            downloadTask = adUnit.getDownloadTask();
            if (downloadTask != null) {
                absolutePath = downloadTask.n().getAbsolutePath();
                try {
                    if (com.sigmob.sdk.downloader.l.c(downloadTask)) {
                        if (adUnit.isRecord()) {
                            com.sigmob.sdk.base.network.g.a(adUnit, com.sigmob.sdk.base.common.a.H);
                        }
                        WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                m.a(contextE, downloadTask, adUnit);
                            }
                        });
                        return;
                    } else {
                        if (com.sigmob.sdk.downloader.l.a(downloadTask)) {
                            ai.a(contextE, "正在下载", 1).show();
                            HashMap map = new HashMap();
                            map.put("result", "1");
                            map.put("downloadId", adUnit.getDownloadId());
                            BaseBroadcastReceiver.a(contextE, adUnit.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
                            return;
                        }
                        str = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                        obj = "downloadId";
                    }
                } catch (Throwable th) {
                    th = th;
                    str = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                    obj = "downloadId";
                    HashMap map2 = new HashMap();
                    map2.put("result", "0");
                    map2.put(obj, adUnit.getDownloadId());
                    BaseBroadcastReceiver.a(contextE, adUnit.getUuid(), map2, str);
                    ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda3
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj2) {
                            m.a(url, absolutePath, obj2);
                        }
                    });
                    ac.a(PointCategory.APKDOWNLOAD, "start", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda4
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj2) {
                            m.a(th, contextE, obj2);
                        }
                    });
                }
            } else {
                f.a aVarC = new f.a(url, com.sigmob.sdk.base.utils.i.a(contextE)).a(adUnit.getApkName()).c(false);
                aVarC.a("User-Agent", Networking.getUserAgent());
                if (!isMThread) {
                    aVarC = aVarC.a(1);
                }
                downloadTask = aVarC.a();
                if (com.sigmob.sdk.downloader.l.a(downloadTask)) {
                    com.sigmob.sdk.downloader.g.j().a().a((com.sigmob.sdk.downloader.core.a) downloadTask);
                }
                File fileN = downloadTask.n();
                if (fileN != null && fileN.exists()) {
                    fileN.delete();
                }
                if (fileN.getParentFile().exists()) {
                    fileN.getParentFile().mkdirs();
                }
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(contextE, adUnit, contextE);
                String str2 = "downloadButtonAction_" + adUnit.getUuid() + Config.replace + downloadTask.c();
                Intent intent = new Intent(str2);
                intent.setPackage(contextE.getPackageName());
                a aVar = new a(downloadTask, str2, adUnit);
                str = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                try {
                    obj = "downloadId";
                } catch (Throwable th2) {
                    th = th2;
                    obj = "downloadId";
                    absolutePath = null;
                    HashMap map22 = new HashMap();
                    map22.put("result", "0");
                    map22.put(obj, adUnit.getDownloadId());
                    BaseBroadcastReceiver.a(contextE, adUnit.getUuid(), map22, str);
                    ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda3
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj2) {
                            m.a(url, absolutePath, obj2);
                        }
                    });
                    ac.a(PointCategory.APKDOWNLOAD, "start", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda4
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj2) {
                            m.a(th, contextE, obj2);
                        }
                    });
                }
                try {
                    IntentFilter intentFilter = new IntentFilter("downloadAction_" + adUnit.getUuid() + Config.replace + downloadTask.c());
                    intentFilter.addAction(str2);
                    t.a(contextE, aVar, intentFilter);
                    Intent intent2 = new Intent("downloadAction_" + adUnit.getUuid() + Config.replace + downloadTask.c());
                    intent2.setPackage(contextE.getPackageName());
                    List<com.sigmob.sdk.videoAd.d> arrayList = new ArrayList<>();
                    arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.p, 0.25f));
                    arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.aa, 0.5f));
                    arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.ab, 0.75f));
                    adUnit.setDownloadQuarterTrack(arrayList);
                    anonymousClass3.a(adUnit.getIconUrl(), adUnit.getAppName(), adUnit.getDesc());
                    if (Build.VERSION.SDK_INT >= 31) {
                        anonymousClass3.a(PendingIntent.getBroadcast(contextE, 0, intent, 201326592));
                        broadcast = PendingIntent.getBroadcast(contextE, 0, intent2, 201326592);
                    } else {
                        anonymousClass3.a(PendingIntent.getBroadcast(contextE, 0, intent, 134217728));
                        broadcast = PendingIntent.getBroadcast(contextE, 0, intent2, 134217728);
                    }
                    anonymousClass3.b(broadcast);
                    downloadTask.a((com.sigmob.sdk.downloader.c) anonymousClass3);
                    adUnit.setDownloadTask(downloadTask);
                    if (!adUnit.isResumableDownload() && (gVarC = com.sigmob.sdk.downloader.g.j().c()) != null) {
                        gVarC.b(downloadTask.c());
                    }
                    absolutePath = null;
                } catch (Throwable th3) {
                    th = th3;
                    absolutePath = null;
                    HashMap map222 = new HashMap();
                    map222.put("result", "0");
                    map222.put(obj, adUnit.getDownloadId());
                    BaseBroadcastReceiver.a(contextE, adUnit.getUuid(), map222, str);
                    ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda3
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj2) {
                            m.a(url, absolutePath, obj2);
                        }
                    });
                    ac.a(PointCategory.APKDOWNLOAD, "start", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda4
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj2) {
                            m.a(th, contextE, obj2);
                        }
                    });
                }
            }
        } catch (Throwable th4) {
            th = th4;
            str = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
        }
        try {
            adUnit.setDownloadId(Long.valueOf(downloadTask.c()));
            downloadTask.B();
            ai.a(contextE, "已开始下载", 1).show();
            if (adUnit.isRecord()) {
                com.sigmob.sdk.base.network.g.a(adUnit, "download_start");
                ac.a("download_start", "1", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda2
                    @Override // com.sigmob.sdk.base.common.ac.a
                    public final void onAddExtra(Object obj2) {
                        m.b(url, absolutePath, obj2);
                    }
                });
            }
        } catch (Throwable th5) {
            th = th5;
            HashMap map2222 = new HashMap();
            map2222.put("result", "0");
            map2222.put(obj, adUnit.getDownloadId());
            BaseBroadcastReceiver.a(contextE, adUnit.getUuid(), map2222, str);
            ac.a("download_start", "0", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda3
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj2) {
                    m.a(url, absolutePath, obj2);
                }
            });
            ac.a(PointCategory.APKDOWNLOAD, "start", adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda4
                @Override // com.sigmob.sdk.base.common.ac.a
                public final void onAddExtra(Object obj2) {
                    m.a(th, contextE, obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map options = pointEntitySigmob.getOptions();
            options.put("apkfile", str2);
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    protected static void a(String apkName, String url, String iconUrl, String title, boolean isMThread) {
        final Context contextE = com.sigmob.sdk.b.e();
        HashMap<String, com.sigmob.sdk.downloader.f> map = a;
        final com.sigmob.sdk.downloader.f fVar = map.get(apkName);
        if (fVar != null) {
            if (com.sigmob.sdk.downloader.l.c(fVar)) {
                WindAds.sharedAds().getHandler().post(new Runnable() { // from class: com.sigmob.sdk.base.common.m.1
                    @Override // java.lang.Runnable
                    public void run() {
                        o.a(contextE, fVar.n().getAbsolutePath(), (BaseAdUnit) null);
                    }
                });
                return;
            } else if (com.sigmob.sdk.downloader.l.a(fVar)) {
                ai.a(contextE, "正在下载", 1).show();
                return;
            } else {
                ai.a(contextE, "继续下载", 1).show();
                fVar.B();
                return;
            }
        }
        f.a aVarC = new f.a(url, com.sigmob.sdk.base.utils.i.a(contextE)).a(apkName).c(false);
        aVarC.a("User-Agent", Networking.getUserAgent());
        if (!isMThread) {
            aVarC = aVarC.a(1);
        }
        com.sigmob.sdk.downloader.f fVarA = aVarC.a();
        if (com.sigmob.sdk.downloader.l.a(fVarA)) {
            com.sigmob.sdk.downloader.g.j().a().a((com.sigmob.sdk.downloader.core.a) fVarA);
        }
        File fileN = fVarA.n();
        if (fileN != null && fileN.exists()) {
            fileN.delete();
        }
        if (fileN.getParentFile().exists()) {
            fileN.getParentFile().mkdirs();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.p, 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.aa, 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.ab, 0.75f));
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(contextE, contextE, url, arrayList);
        String str = "downloadButtonAction_" + apkName + Config.replace + fVarA.c();
        Intent intent = new Intent(str);
        intent.setPackage(contextE.getPackageName());
        a aVar = new a(fVarA, str, null);
        IntentFilter intentFilter = new IntentFilter("downloadAction_" + apkName + Config.replace + fVarA.c());
        intentFilter.addAction(str);
        t.a(contextE, aVar, intentFilter);
        Intent intent2 = new Intent("downloadAction_" + apkName + Config.replace + fVarA.c());
        intent2.setPackage(contextE.getPackageName());
        anonymousClass2.a(iconUrl, title, apkName);
        int i = Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
        anonymousClass2.a(PendingIntent.getBroadcast(contextE, 0, intent, i));
        anonymousClass2.b(PendingIntent.getBroadcast(contextE, 0, intent2, i));
        fVarA.a((com.sigmob.sdk.downloader.c) anonymousClass2);
        fVarA.B();
        ai.a(contextE, "已开始下载", 1).show();
        map.put(apkName, fVarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th, Context context, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.getOptions().put("status", String.valueOf(0));
            pointEntitySigmob.getOptions().put("error", th.getMessage());
            ai.a(context, "下载失败，" + th.getMessage(), 1).show();
        }
    }

    public static int b(Context context, BaseAdUnit adUnit) {
        com.sigmob.sdk.downloader.f downloadTask = adUnit.getDownloadTask();
        boolean zA = com.sigmob.sdk.downloader.l.a(downloadTask);
        if (downloadTask == null || zA) {
            return -1;
        }
        downloadTask.B();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, String str2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            pointEntitySigmob.setFinal_url(str);
            Map options = pointEntitySigmob.getOptions();
            options.put("apkfile", str2);
            options.put("apkurl", str);
            pointEntitySigmob.setOptions(options);
        }
    }

    public static int c(Context context, BaseAdUnit adUnit) {
        com.sigmob.sdk.downloader.f downloadTask = adUnit.getDownloadTask();
        if (downloadTask == null) {
            return -1;
        }
        downloadTask.a((com.sigmob.sdk.downloader.c) null);
        downloadTask.E();
        com.sigmob.sdk.downloader.g.j().c().b(downloadTask.c());
        File fileM = downloadTask.m();
        if (fileM != null && fileM.exists()) {
            fileM.delete();
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(downloadTask.c());
        }
        File fileN = downloadTask.n();
        if (fileN != null && fileN.exists()) {
            fileN.delete();
        }
        HashMap map = new HashMap();
        map.put("result", "0");
        map.put("downloadId", adUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, adUnit.getUuid(), map, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        adUnit.setDownloadId(null);
        adUnit.setDownloadTask(null);
        if (adUnit.isRecord()) {
            ac.b(PointCategory.DOWNLOAD_END, "0", adUnit);
        }
        ac.a(PointCategory.APKDOWNLOAD, PointCategory.END, adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.m$$ExternalSyntheticLambda5
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                m.a(obj);
            }
        });
        return 0;
    }

    public static long[] d(Context context, BaseAdUnit adUnit) {
        l.a aVarB;
        long[] jArr = {-1, -1, 0};
        com.sigmob.sdk.downloader.f downloadTask = adUnit.getDownloadTask();
        if (downloadTask == null) {
            return jArr;
        }
        com.sigmob.sdk.downloader.core.breakpoint.c cVarY = downloadTask.y();
        if (cVarY == null) {
            aVarB = com.sigmob.sdk.downloader.l.a(adUnit.getDownloadUrl(), com.sigmob.sdk.base.utils.i.a(context).getAbsolutePath(), adUnit.getApkName());
        } else {
            jArr[0] = cVarY.i();
            jArr[1] = cVarY.j();
            aVarB = com.sigmob.sdk.downloader.l.b(downloadTask);
        }
        int i = AnonymousClass4.a[aVarB.ordinal()];
        if (i == 1) {
            jArr[2] = 2;
        } else if (i == 2) {
            jArr[2] = 8;
        } else if (i == 3) {
            jArr[2] = 1;
        } else if (i != 4) {
            jArr[2] = 16;
        } else {
            jArr[2] = 4;
        }
        return jArr;
    }
}
