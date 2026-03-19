package com.kwai.kanas;

import android.arch.lifecycle.ProcessLifecycleOwner;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.kwai.kanas.a.c;
import com.kwai.kanas.a.d;
import com.kwai.kanas.interfaces.CommonParams;
import com.kwai.kanas.interfaces.CustomProtoEvent;
import com.kwai.kanas.interfaces.CustomStatEvent;
import com.kwai.kanas.interfaces.IKanas;
import com.kwai.kanas.interfaces.KanasConfig;
import com.kwai.kanas.services.KanasService;
import com.kwai.kanas.services.a;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.utils.Charsets;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import com.kwai.middleware.azeroth.utils.SampleUtils;
import com.kwai.middleware.azeroth.utils.TextUtils;
import com.kwai.middleware.azeroth.utils.Utils;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Kanas implements IKanas {
    public static final long a = 1000000;
    public static final String b = "kanas";
    public static final String c = "Kanas";
    private final ReentrantReadWriteLock d;
    private Handler e;
    private KanasConfig f;
    private volatile com.kwai.kanas.services.a g;
    private LifecycleCallbacks h;
    private KanasEventHelper i;
    private Queue<Pair<c.b, Integer>> j;
    private long k;

    private Kanas() {
        this.d = new ReentrantReadWriteLock();
        this.j = new LinkedBlockingQueue();
    }

    public static Kanas get() {
        return a.a;
    }

    @Override // com.kwai.kanas.interfaces.IKanas
    public final void startWithConfig(KanasConfig kanasConfig) {
        HandlerThread handlerThread = new HandlerThread("kanas-log");
        handlerThread.start();
        this.e = new Handler(handlerThread.getLooper());
        this.f = kanasConfig;
        Utils.checkAllNotNullOrEmpty(kanasConfig);
        this.h = new LifecycleCallbacks();
        this.i = new KanasEventHelper(Azeroth.get().getContext(), this.f, this.h);
        Utils.runOnUiThread(new Runnable() { // from class: com.kwai.kanas.Kanas.1
            @Override // java.lang.Runnable
            public void run() {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(Kanas.this.h);
            }
        });
        Context context = Azeroth.get().getContext();
        context.bindService(new Intent(context, (Class<?>) KanasService.class), new ServiceConnection() { // from class: com.kwai.kanas.Kanas.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Kanas.this.d.writeLock().lock();
                try {
                    Kanas.this.g = a.AbstractBinderC0651a.a(iBinder);
                    Kanas.this.d.writeLock().unlock();
                    Kanas.this.e.postAtFrontOfQueue(new Runnable() { // from class: com.kwai.kanas.Kanas.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Kanas.this.c();
                        }
                    });
                    Kanas.this.e.post(new Runnable() { // from class: com.kwai.kanas.Kanas.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Kanas.this.b();
                        }
                    });
                } catch (Throwable th) {
                    Kanas.this.d.writeLock().unlock();
                    throw th;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Kanas.this.d.writeLock().lock();
                try {
                    Kanas.this.g = null;
                } finally {
                    Kanas.this.d.writeLock().unlock();
                }
            }
        }, 1);
        this.k = SystemClock.elapsedRealtime();
        Azeroth.get().setLogger(new b());
    }

    final long a() {
        long j = this.k;
        this.k = 0L;
        return j;
    }

    @Override // com.kwai.kanas.interfaces.IKanas
    public final void addCustomStatEvent(final CustomStatEvent customStatEvent) {
        Utils.checkNotNullOrEmpty(customStatEvent);
        this.e.post(new Runnable() { // from class: com.kwai.kanas.Kanas.3
            @Override // java.lang.Runnable
            public void run() {
                if (!SampleUtils.sample(customStatEvent.commonParams().sampleRatio())) {
                    Log.d(Kanas.c, "Drop a CustomStatEvent log, key: " + customStatEvent.key() + ", sampleRatio: " + customStatEvent.commonParams().sampleRatio());
                    return;
                }
                d.c cVar = new d.c();
                d.b bVar = new d.b();
                bVar.a = customStatEvent.key();
                bVar.b = TextUtils.emptyIfNull(customStatEvent.value());
                cVar.a = bVar;
                c.b bVarBuildCommonReportEvent = Kanas.this.i.buildCommonReportEvent(customStatEvent.commonParams());
                bVarBuildCommonReportEvent.g = TextUtils.emptyIfNull(customStatEvent.eventId());
                bVarBuildCommonReportEvent.f = cVar;
                Kanas.this.a(bVarBuildCommonReportEvent, customStatEvent.commonParams().realtime() ? 1 : 0);
            }
        });
    }

    @Override // com.kwai.kanas.interfaces.IKanas
    public final void addCustomProtoEvent(final CustomProtoEvent customProtoEvent) {
        Utils.checkAllNotNullOrEmpty(customProtoEvent);
        this.e.post(new Runnable() { // from class: com.kwai.kanas.Kanas.4
            @Override // java.lang.Runnable
            public void run() {
                if (!SampleUtils.sample(customProtoEvent.commonParams().sampleRatio())) {
                    Log.d(Kanas.c, "Drop a CustomProtoEvent log, type: " + customProtoEvent.type() + ", sampleRatio: " + customProtoEvent.commonParams().sampleRatio());
                    return;
                }
                d.c cVar = new d.c();
                cVar.b = new d.a();
                cVar.b.a = customProtoEvent.type();
                cVar.b.b = Base64.encodeToString(customProtoEvent.payload().toString().getBytes(Charsets.UTF_8), 3);
                Kanas.this.a(cVar, customProtoEvent.eventId(), customProtoEvent.commonParams(), customProtoEvent.commonParams().realtime() ? 1 : 0);
            }
        });
    }

    @Override // com.kwai.kanas.interfaces.IKanas
    public final KanasConfig getConfig() {
        return this.f;
    }

    @Override // com.kwai.kanas.interfaces.IKanas
    public final void setSessionIdAutoUpdate(boolean z) {
        this.h.a(z);
    }

    public final void addStatEvent(d.c cVar) {
        addStatEvent(cVar, null);
    }

    public final void addStatEvent(d.c cVar, CommonParams commonParams) {
        a(cVar, null, commonParams, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final d.c cVar, final String str, final CommonParams commonParams, final int i) {
        Utils.checkNotNull(cVar);
        this.e.post(new Runnable() { // from class: com.kwai.kanas.Kanas.5
            @Override // java.lang.Runnable
            public void run() {
                c.b bVarBuildCommonReportEvent = Kanas.this.i.buildCommonReportEvent(commonParams);
                bVarBuildCommonReportEvent.g = TextUtils.emptyIfNull(str);
                bVarBuildCommonReportEvent.f = cVar;
                Kanas.this.a(bVarBuildCommonReportEvent, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.b bVar, int i) {
        bVar.c = this.h.a();
        this.d.readLock().lock();
        try {
            if (this.g == null) {
                this.j.add(new Pair<>(bVar, Integer.valueOf(i)));
                return;
            }
            this.d.readLock().unlock();
            b();
            b(bVar, i);
        } finally {
            this.d.readLock().unlock();
        }
    }

    private void b(c.b bVar, int i) {
        if (Azeroth.get().isDebugMode()) {
            Log.d(c, bVar.toString());
        }
        this.d.readLock().lock();
        try {
            try {
                if (this.g != null) {
                    try {
                        byte[] bytes = JsonUtils.toJson(bVar).toString().getBytes(Charsets.UTF_8);
                        if (bytes.length >= 1000000) {
                            String str = "The total size of adding log event is over 1000000 bytes, then SQLite cannot save it, so abort it!!\nthe event is :\n" + bVar.toString();
                            if (Azeroth.get().isDebugMode()) {
                                throw new IllegalStateException(str);
                            }
                            getConfig().logger().logErrors(new IllegalStateException(str));
                        } else {
                            this.g.a(bytes, i);
                        }
                    } catch (Exception e) {
                        String str2 = "reportEvent cannot toByteArray. reportEvent:\n " + bVar;
                        if (Azeroth.get().isDebugMode()) {
                            throw new IllegalArgumentException(str2, e);
                        }
                        getConfig().logger().logErrors(new IllegalArgumentException(str2, e));
                    }
                } else {
                    Log.e(c, "Kanas service is disconnected, stash logs.");
                    this.j.add(new Pair<>(bVar, Integer.valueOf(i)));
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            this.d.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!this.j.isEmpty()) {
            Pair<c.b, Integer> pairPoll = this.j.poll();
            b((c.b) pairPoll.first, ((Integer) pairPoll.second).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.d.readLock().lock();
        try {
            try {
                if (this.g != null) {
                    this.g.a();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } finally {
            this.d.readLock().unlock();
        }
    }

    static class a {
        private static final Kanas a = new Kanas();

        private a() {
        }
    }

    public final LifecycleCallbacks getActivityCallbacks() {
        return this.h;
    }
}
