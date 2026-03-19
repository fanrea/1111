package com.kwai.kanas.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.kwai.kanas.Kanas;
import com.kwai.kanas.a.c;
import com.kwai.kanas.interfaces.KanasLogger;
import com.kwai.kanas.services.a;
import com.kwai.kanas.vader.Channel;
import com.kwai.kanas.vader.d;
import com.kwai.kanas.vader.f.i;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.Charsets;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import com.kwai.middleware.azeroth.utils.SystemUtils;
import com.kwai.middleware.azeroth.utils.TextUtils;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KanasService extends Service {
    private Handler a;
    private KanasLogger b;
    private volatile boolean c;
    private d d;
    private com.kwai.kanas.upload.d e;
    private com.kwai.kanas.upload.d f;
    private com.kwai.kanas.upload.d g;
    private i h;
    private a.AbstractBinderC0651a i = new a.AbstractBinderC0651a() { // from class: com.kwai.kanas.services.KanasService.1
        @Override // com.kwai.kanas.services.a
        public void a() {
        }

        @Override // com.kwai.kanas.services.a
        public void a(byte[] bArr, int i) {
            KanasService.this.a(bArr, i);
        }
    };

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.i;
    }

    private void a() {
        this.e = new com.kwai.kanas.upload.d(Channel.REAL_TIME);
        this.f = new com.kwai.kanas.upload.d(Channel.HIGH_FREQ);
        this.g = new com.kwai.kanas.upload.d(Channel.NORMAL);
        this.h = i.a(this.e, this.f, this.g, new com.kwai.kanas.vader.b() { // from class: com.kwai.kanas.services.KanasService.2
            @Override // com.kwai.kanas.vader.b
            public void a(String str, String str2) {
                if (str.contains("mismatch") || str.contains("evict_logs")) {
                    return;
                }
                if (Azeroth.get().isDebugMode()) {
                    Log.d("VaderLogger", "vader event: " + str + ", value: " + str2);
                }
                Kanas.get().getConfig().logger().logEvent(str, str2);
            }

            @Override // com.kwai.kanas.vader.b
            public void a(Exception exc) {
                if (Azeroth.get().isDebugMode()) {
                    Log.d("VaderLogger", "vader exception: ", exc);
                }
                Kanas.get().getConfig().logger().logErrors(new RuntimeException("Vader exception", exc));
            }
        });
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Kanas.get().getConfig() == null) {
            stopSelf();
            return;
        }
        a();
        HandlerThread handlerThread = new HandlerThread("kanas-log-sdk");
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper());
        this.a.postAtFrontOfQueue(new Runnable() { // from class: com.kwai.kanas.services.KanasService.3
            @Override // java.lang.Runnable
            public void run() {
                com.kwai.kanas.upload.a.a().a(new Runnable() { // from class: com.kwai.kanas.services.KanasService.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        KanasService.this.b().b();
                    }
                });
                KanasService.this.c = true;
            }
        });
        this.b = Kanas.get().getConfig().logger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, final int i) {
        final c.b bVarA = a(bArr);
        if (bVarA == null) {
            return;
        }
        String strA = Kanas.get().getActivityCallbacks().a();
        if (!TextUtils.equals(strA, bVarA.c)) {
            bVarA.c = strA;
        }
        if (i == 0) {
            this.a.post(new Runnable() { // from class: com.kwai.kanas.services.KanasService.6
                @Override // java.lang.Runnable
                public void run() {
                    KanasService.this.a(bVarA, i);
                }
            });
            return;
        }
        if (i == 1 || i == 4) {
            if (this.c) {
                this.a.postAtFrontOfQueue(new Runnable() { // from class: com.kwai.kanas.services.KanasService.4
                    @Override // java.lang.Runnable
                    public void run() {
                        KanasService.this.a(bVarA, i);
                    }
                });
            } else {
                this.a.post(new Runnable() { // from class: com.kwai.kanas.services.KanasService.5
                    @Override // java.lang.Runnable
                    public void run() {
                        KanasService.this.a(bVarA, i);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.b bVar, int i) {
        String strA = a(bVar);
        Channel channel = Channel.NORMAL;
        if (i == 4) {
            channel = Channel.REAL_TIME;
        } else if (i == 1) {
            channel = Channel.HIGH_FREQ;
        }
        b().a(bVar, channel, strA);
    }

    private String a(c.b bVar) {
        return bVar.f != null ? a(bVar.f) : "unknown";
    }

    private String a(JsonAdapter jsonAdapter) throws SecurityException {
        Field[] fields = jsonAdapter.getClass().getFields();
        if (fields == null) {
            return "";
        }
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(jsonAdapter) instanceof JsonAdapter) {
                return field.getName();
            }
            continue;
        }
        return "";
    }

    private c.b a(byte[] bArr) {
        return (c.b) JsonUtils.fromJson(new String(bArr, Charsets.UTF_8), c.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized d b() {
        Context context = Azeroth.get().getContext();
        if (!SystemUtils.isInMainProcess(context)) {
            this.b.logErrors(new IllegalStateException("Vader shoun't be created from non-main process"));
        }
        if (this.d == null) {
            this.d = new d(context, this.h, com.kwai.kanas.b.a.a().f());
        }
        return this.d;
    }
}
