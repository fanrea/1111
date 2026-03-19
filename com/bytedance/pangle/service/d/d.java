package com.bytedance.pangle.service.d;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.gb;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.u;
import com.bytedance.sdk.openadsdk.api.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends u.d {
    private static volatile d hc;
    private final HashMap<ComponentName, IBinder> b = new HashMap<>();
    private final HashMap<ComponentName, hc> c = new HashMap<>();
    private final C0257d<Intent> u = new C0257d<>();
    private final HashMap<ComponentName, com.bytedance.pangle.service.d> an = new HashMap<>();
    private final HashSet<ComponentName> h = new HashSet<>();
    private final HashSet<ComponentName> gb = new HashSet<>();
    private final List<Runnable> tt = new ArrayList();
    private final Handler d = new Handler(Looper.getMainLooper());

    @Override // com.bytedance.pangle.u.d, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    class hc extends HashSet<gb> {
        hc() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof gb)) {
                return false;
            }
            Iterator<gb> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    an.d(e);
                }
                if (it.next().d() == ((gb) obj).d()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            gb gbVar = null;
            Iterator<gb> it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                gb next = it.next();
                try {
                } catch (RemoteException e) {
                    an.d(e);
                }
                if (next.d() == ((gb) obj).d()) {
                    gbVar = next;
                    break;
                }
            }
            return super.remove(gbVar);
        }
    }

    /* renamed from: com.bytedance.pangle.service.d.d$d, reason: collision with other inner class name */
    class C0257d<T> extends HashMap<gb, T> {
        C0257d() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof gb)) {
                return false;
            }
            Iterator<gb> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e) {
                    an.d(e);
                }
                if (it.next().d() == ((gb) obj).d()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public T remove(Object obj) {
            gb next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<gb> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                } catch (RemoteException e) {
                    an.d(e);
                }
                if (next.d() == ((gb) obj).d()) {
                    break;
                }
            }
            return (T) super.remove(next);
        }
    }

    public static d hc() {
        if (hc == null) {
            synchronized (d.class) {
                if (hc == null) {
                    hc = new d();
                }
            }
        }
        return hc;
    }

    private d() {
    }

    public void b() {
        for (Runnable runnable : this.tt) {
            if (runnable != null) {
                this.d.post(runnable);
            }
        }
        this.tt.clear();
    }

    @Override // com.bytedance.pangle.u
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return d(intent, str);
            }
            this.d.post(new Runnable() { // from class: com.bytedance.pangle.service.d.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.d(intent, str);
                }
            });
        } else {
            this.tt.add(new Runnable() { // from class: com.bytedance.pangle.service.d.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.d(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName d(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.an.containsKey(component)) {
            com.bytedance.pangle.service.d dVarHc = hc(intent, str);
            if (dVarHc == null) {
                return component;
            }
            this.an.put(component, dVarHc);
            this.h.add(component);
        }
        com.bytedance.pangle.service.d dVar = this.an.get(component);
        if (dVar != null) {
            dVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private com.bytedance.pangle.service.d hc(Intent intent, String str) {
        com.bytedance.pangle.service.d dVarB = b(intent, str);
        if (dVarB != null) {
            dVarB.onCreate();
        }
        return dVarB;
    }

    private com.bytedance.pangle.service.d b(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.d dVar = (com.bytedance.pangle.service.d) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                dVar.attach(plugin);
                return dVar;
            } catch (Exception e) {
                e = e;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            zLoadPlugin = false;
        }
    }

    @Override // com.bytedance.pangle.u
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hc().d(intent.getComponent());
            return true;
        }
        this.d.post(new Runnable() { // from class: com.bytedance.pangle.service.d.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.hc().d(intent.getComponent());
            }
        });
        return true;
    }

    public synchronized boolean d(ComponentName componentName) {
        if (!this.an.containsKey(componentName)) {
            return false;
        }
        this.gb.add(componentName);
        return hc(componentName);
    }

    private boolean hc(ComponentName componentName) {
        if (!this.h.contains(componentName)) {
            if (this.c.get(componentName) != null) {
                return false;
            }
            b(componentName);
            return true;
        }
        if (!this.gb.contains(componentName) || this.c.containsKey(componentName)) {
            return false;
        }
        b(componentName);
        return true;
    }

    private void b(ComponentName componentName) {
        com.bytedance.pangle.service.d dVarRemove = this.an.remove(componentName);
        this.gb.remove(componentName);
        this.b.remove(componentName);
        this.h.remove(componentName);
        if (dVarRemove != null) {
            dVarRemove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.u
    public boolean bindService(final Intent intent, final gb gbVar, final int i, final String str) throws RemoteException {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return d(intent, gbVar, i, str);
            }
            this.d.post(new Runnable() { // from class: com.bytedance.pangle.service.d.d.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.d(intent, gbVar, i, str);
                    } catch (RemoteException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                    }
                }
            });
            return true;
        }
        this.tt.add(new Runnable() { // from class: com.bytedance.pangle.service.d.d.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.this.d(intent, gbVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean d(Intent intent, gb gbVar, int i, String str) throws RemoteException {
        ComponentName component = intent.getComponent();
        if (!this.an.containsKey(component)) {
            com.bytedance.pangle.service.d dVarHc = hc(intent, str);
            if (dVarHc == null) {
                return false;
            }
            this.an.put(component, dVarHc);
        }
        com.bytedance.pangle.service.d dVar = this.an.get(component);
        if (!this.b.containsKey(component)) {
            this.b.put(component, dVar.onBind(intent));
        }
        IBinder iBinder = this.b.get(component);
        if (iBinder != null) {
            if (this.c.containsKey(component)) {
                if (!this.c.get(component).contains(gbVar)) {
                    this.c.get(component).add(gbVar);
                    this.u.put(gbVar, intent);
                    gbVar.d(component, iBinder);
                }
            } else {
                hc hcVar = new hc();
                hcVar.add(gbVar);
                this.c.put(component, hcVar);
                this.u.put(gbVar, intent);
                gbVar.d(component, iBinder);
            }
        }
        return true;
    }

    @Override // com.bytedance.pangle.u
    public void unbindService(final gb gbVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d(gbVar);
        } else {
            this.d.post(new Runnable() { // from class: com.bytedance.pangle.service.d.d.6
                @Override // java.lang.Runnable
                public void run() {
                    d.this.d(gbVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(gb gbVar) {
        for (ComponentName componentName : this.c.keySet()) {
            hc hcVar = this.c.get(componentName);
            if (hcVar.contains(gbVar)) {
                hcVar.remove(gbVar);
                Intent intentRemove = this.u.remove(gbVar);
                if (hcVar.size() == 0) {
                    this.c.remove(componentName);
                    com.bytedance.pangle.service.d dVar = this.an.get(componentName);
                    if (dVar != null) {
                        dVar.onUnbind(intentRemove);
                    }
                }
                hc(componentName);
                return;
            }
        }
    }
}
