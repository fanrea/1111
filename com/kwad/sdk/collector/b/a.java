package com.kwad.sdk.collector.b;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.webkit.WebView;
import com.kwad.sdk.api.proxy.app.ServiceProxyRemote;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.service.c;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.kwad.sdk.m.a {
    private static AtomicBoolean btB = new AtomicBoolean(false);
    public static volatile Message btC;
    private HandlerC0572a btz = new HandlerC0572a(0);
    private Messenger btA = new Messenger(this.btz);

    public static void register() {
        try {
            c.g(Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote"), a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        super.onCreate(service);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(ay.getProcessName(service.getApplicationContext()));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.d("RemoteService", "WebView has already been initialized " + e.getMessage());
            }
        }
        com.kwad.sdk.core.d.c.d("RemoteService", "onCreate processName:" + ay.getProcessName(service));
        if (!SystemUtil.isInMainProcess(service)) {
            d.a(service, new d.a() { // from class: com.kwad.sdk.collector.b.a.1
                @Override // com.kwad.sdk.collector.d.a
                public final void onLoaded() {
                    com.kwad.sdk.core.d.c.d("RemoteService", "onLoaded");
                    a.btB.set(true);
                    if (a.btC != null) {
                        a.this.btz.handleMessage(a.btC);
                        a.btC = null;
                    }
                }

                @Override // com.kwad.sdk.collector.d.a
                public final void dS(String str) {
                    com.kwad.sdk.core.d.c.e("RemoteService", "onLoadError: " + str);
                    a.btB.set(false);
                }
            });
        } else {
            btB.set(true);
        }
        this.btz.a(service);
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        super.onDestroy(service);
        com.kwad.sdk.core.d.c.d("RemoteService", "onDestroy");
        this.btz.a(null);
        if (bB(service)) {
            com.kwad.sdk.core.d.c.d("RemoteService", "goto kill myself");
            Process.killProcess(Process.myPid());
        }
    }

    public static AtomicBoolean Ww() {
        return btB;
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        com.kwad.sdk.core.d.c.d("RemoteService", "bindASService");
        context.bindService(new Intent(context, (Class<?>) ServiceProxyRemote.class), serviceConnection, 1);
    }

    public static void b(Context context, ServiceConnection serviceConnection) {
        com.kwad.sdk.core.d.c.d("RemoteService", "unbindASService");
        try {
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.m.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        return this.btA.getBinder();
    }

    /* renamed from: com.kwad.sdk.collector.b.a$a, reason: collision with other inner class name */
    static class HandlerC0572a extends Handler {
        private WeakReference<Service> btE;

        private HandlerC0572a() {
        }

        /* synthetic */ HandlerC0572a(byte b) {
            this();
        }

        public final void a(Service service) {
            if (service != null) {
                this.btE = new WeakReference<>(service);
            } else {
                this.btE = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            com.kwad.sdk.core.d.c.d("RemoteService", "handleMessage");
            WeakReference<Service> weakReference = this.btE;
            Service service = weakReference != null ? weakReference.get() : null;
            if (service == null) {
                return;
            }
            if (!a.Ww().get()) {
                com.kwad.sdk.core.d.c.d("RemoteService", "save buffered message");
                a.btC = Message.obtain(message);
                return;
            }
            final Messenger messenger = message.replyTo;
            int i = message.what;
            com.kwad.sdk.core.d.c.d("RemoteService", "handleMessage what: " + i);
            if (i != 100) {
                return;
            }
            final Bundle bundle = new Bundle();
            g.a(service, new g.b() { // from class: com.kwad.sdk.collector.b.a.a.1
                @Override // com.kwad.sdk.utils.g.b
                public final void ag(List<b> list) throws RemoteException {
                    com.kwad.sdk.core.d.c.d("RemoteService", "RemoteService: onAppStatusResult list: " + list);
                    if (list != null && !list.isEmpty()) {
                        com.kwad.sdk.core.d.c.d("RemoteService", "RemoteService: onAppStatusResult: " + list.size());
                        JSONArray jSONArrayAI = g.a.aI(list);
                        String string = jSONArrayAI != null ? jSONArrayAI.toString() : null;
                        com.kwad.sdk.core.d.c.d("RemoteService", "resultJson :" + string);
                        if (string != null) {
                            AppStatusRules appStatusRulesAnw = g.anw();
                            ArrayList<AppStatusRules.Strategy> allStrategy = appStatusRulesAnw != null ? appStatusRulesAnw.getAllStrategy() : null;
                            String string2 = allStrategy != null ? aa.aL(allStrategy).toString() : null;
                            bundle.putString("resultJson", string);
                            bundle.putString("allStrategyJson", string2);
                        }
                    }
                    try {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 101;
                        messageObtain.setData(bundle);
                        messenger.send(messageObtain);
                    } catch (RemoteException unused) {
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    Iterator<b> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().destroy();
                    }
                }
            });
        }
    }

    private static boolean bB(Context context) {
        String processName = ay.getProcessName(context);
        return (processName == null || context.getPackageName().equals(processName)) ? false : true;
    }
}
