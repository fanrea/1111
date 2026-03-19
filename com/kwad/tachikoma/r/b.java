package com.kwad.tachikoma.r;

import android.app.Activity;
import android.hardware.Sensor;
import android.os.Bundle;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILifeCycleListener;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends TKBaseNativeModule {
    private int Bs;
    private Map<Integer, Set<a>> EE;
    private final Map<String, a> EF;

    private static int cn(int i) {
        if (i == -3) {
            return 2;
        }
        if (i != -2) {
            return i != -1 ? 3 : 0;
        }
        return 1;
    }

    static /* synthetic */ int b(b bVar, int i) {
        return cn(i);
    }

    public b(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.EE = new HashMap();
        this.EF = new ConcurrentHashMap();
        this.Bs = OfflineHostProvider.getApi().lifeCycle().registerLifeCycleListener(new ILifeCycleListener() { // from class: com.kwad.tachikoma.r.b.1
            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityDestroyed(Activity activity) {
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityPaused(Activity activity) {
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onActivityResumed(Activity activity) {
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onBackToForeground() {
                try {
                    ISensorManagerProxy iSensorManagerProxySensorManager = OfflineHostProvider.getApi().sensorManager();
                    for (String str : b.this.EF.keySet()) {
                        a aVar = (a) b.this.EF.get(str);
                        if (aVar != null) {
                            int i = Integer.parseInt(str.split(Config.replace)[0]);
                            int i2 = Integer.parseInt(str.split(Config.replace)[1]);
                            iSensorManagerProxySensorManager.registerListener(b.this.getContext(), aVar, b.this.cm(i), b.b(b.this, i2));
                        }
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.kwad.components.offline.api.core.api.ILifeCycleListener
            public final void onBackToBackground() {
                ISensorManagerProxy iSensorManagerProxySensorManager = OfflineHostProvider.getApi().sensorManager();
                Iterator it = b.this.EF.keySet().iterator();
                while (it.hasNext()) {
                    try {
                        iSensorManagerProxySensorManager.unregisterListener((a) b.this.EF.get((String) it.next()));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public final boolean ci(int i) {
        return cm(i) != null;
    }

    public final void a(int i, int i2, V8Function v8Function) {
        if (OfflineHostProvider.getApi().deviceManager().useSensorManagerDisable()) {
            return;
        }
        Sensor sensorCm = cm(i);
        a aVar = new a(v8Function, pO());
        if (sensorCm == null) {
            aVar.ch(-1);
            aVar.onDestroy();
            return;
        }
        ISensorManagerProxy iSensorManagerProxySensorManager = OfflineHostProvider.getApi().sensorManager();
        if (iSensorManagerProxySensorManager != null) {
            iSensorManagerProxySensorManager.registerListener(getContext(), aVar, sensorCm, cn(i2));
            ck(i).add(aVar);
            a(i, i2, aVar);
        }
    }

    private void a(int i, int i2, a aVar) {
        this.EF.put(i + Config.replace + i2, aVar);
    }

    public final void cj(int i) {
        cl(i);
        try {
            for (String str : this.EF.keySet()) {
                if (Integer.parseInt(str.split(Config.replace)[0]) == i) {
                    this.EF.remove(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private Set<a> ck(int i) {
        Set<a> set = this.EE.get(Integer.valueOf(i));
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        this.EE.put(Integer.valueOf(i), hashSet);
        return hashSet;
    }

    private void cl(int i) {
        Set<a> setCk = ck(i);
        for (a aVar : ck(i)) {
            try {
                ISensorManagerProxy iSensorManagerProxySensorManager = OfflineHostProvider.getApi().sensorManager();
                if (iSensorManagerProxySensorManager != null) {
                    iSensorManagerProxySensorManager.unregisterListener(aVar);
                }
            } catch (Throwable unused) {
            }
            aVar.onDestroy();
        }
        setCk.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Sensor cm(int i) {
        ISensorManagerProxy iSensorManagerProxySensorManager;
        int i2 = 4;
        if (i == 1) {
            i2 = 10;
        } else if (i != 2) {
            i2 = i != 3 ? i != 4 ? i != 5 ? 0 : 2 : 9 : 1;
        }
        if (i2 == 0 || (iSensorManagerProxySensorManager = OfflineHostProvider.getApi().sensorManager()) == null) {
            return null;
        }
        return iSensorManagerProxySensorManager.getDefaultSensor(getContext(), i2);
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        Iterator<Integer> it = this.EE.keySet().iterator();
        while (it.hasNext()) {
            cl(it.next().intValue());
        }
        OfflineHostProvider.getApi().lifeCycle().unregisterLifeCycleListener(this.Bs);
    }
}
