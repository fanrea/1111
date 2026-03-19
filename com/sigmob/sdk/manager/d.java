package com.sigmob.sdk.manager;

import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.utils.m;
import com.sigmob.sdk.base.utils.n;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    public static final String a = "WindAdExpirationManager";
    private static volatile d b;
    private volatile boolean c;
    private volatile long d;
    private Timer e;
    private final ConcurrentHashMap<SoftReference<b>, a> f = new ConcurrentHashMap<>();
    private volatile boolean g = false;

    static final class a {
        Boolean a;
        int b;
        int c;
        String d;
        String e;
        String f;
        String g;
        String h;
        Long i;
        Integer j;
        boolean k = false;
        boolean l;

        public a(BaseAdUnit baseAdUnit, boolean activeExpiration) {
            if (baseAdUnit == null) {
                return;
            }
            this.d = baseAdUnit.getVid();
            this.e = baseAdUnit.getOriginVid();
            this.f = baseAdUnit.getRequestId();
            this.h = baseAdUnit.getAdslot_id();
            this.g = baseAdUnit.getAdxEncPrice();
            this.j = baseAdUnit.getAdExpiredTime();
            this.i = Long.valueOf(baseAdUnit.getCreate_time());
            this.a = Boolean.valueOf(baseAdUnit.expiredAdCanReload());
            int iExpiredAdReloadNum = baseAdUnit.expiredAdReloadNum();
            this.b = iExpiredAdReloadNum;
            this.c = iExpiredAdReloadNum;
            this.l = activeExpiration;
        }

        public boolean a() {
            return (this.i.longValue() == 0 || this.j.intValue() == 0 || System.currentTimeMillis() - this.i.longValue() < ((long) this.j.intValue())) ? false : true;
        }

        public Map<String, String> b() {
            HashMap map = new HashMap();
            map.put(PointParamKey.EXPIRE_RELOAD_COUNT, String.valueOf(this.c));
            map.put(PointParamKey.ORIGIN_VID, m.b(this.e) ? this.e : this.d);
            if (m.b(this.g)) {
                map.put(PointParamKey.ORIGIN_PRICE, this.g);
            }
            map.put("request_id", this.f);
            return map;
        }
    }

    private d() {
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> mapB = aVar.b();
            if (com.sigmob.sdk.base.utils.e.b(mapB)) {
                pointEntitySigmob.getOptions().putAll(mapB);
            }
        }
    }

    private void d(b adManager) {
        Iterator<Map.Entry<SoftReference<b>, a>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            b bVar = it.next().getKey().get();
            if (bVar != null && bVar.equals(adManager)) {
                it.remove();
                SigmobLogger.i(a, "removeAdManager", new Object[0]);
                return;
            }
        }
    }

    private a e(b adManager) {
        if (adManager == null) {
            return null;
        }
        for (Map.Entry<SoftReference<b>, a> entry : this.f.entrySet()) {
            b bVar = entry.getKey().get();
            a value = entry.getValue();
            if (bVar != null && value != null && bVar.equals(adManager)) {
                return value;
            }
        }
        return null;
    }

    private synchronized void e() {
        SigmobLogger.d(a, "cancelTimer", new Object[0]);
        Timer timer = this.e;
        if (timer == null) {
            return;
        }
        timer.cancel();
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.g) {
            SigmobLogger.e(a, "checkAdExpiration: The screen is locked.", new Object[0]);
            return;
        }
        if (this.f.isEmpty()) {
            SigmobLogger.e(a, "checkAdExpiration: adManagerMap is unavailable.", new Object[0]);
            return;
        }
        if (!com.sigmob.sdk.manager.a.c()) {
            SigmobLogger.e(a, "checkAdExpiration: The app is on background.", new Object[0]);
            return;
        }
        Iterator<Map.Entry<SoftReference<b>, a>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<SoftReference<b>, a> next = it.next();
            SoftReference<b> key = next.getKey();
            final a value = next.getValue();
            if (key == null || value == null) {
                SigmobLogger.e(a, "checkAdExpiration: entry is unavailable, remove entry.", new Object[0]);
                it.remove();
            } else {
                b bVar = key.get();
                if (bVar == null) {
                    SigmobLogger.e(a, "checkAdExpiration: manager is unavailable, remove entry.", new Object[0]);
                } else if (!value.a.booleanValue() || value.c <= 0) {
                    SigmobLogger.e(a, "checkAdExpiration: retry not available.", new Object[0]);
                } else if (value.k) {
                    SigmobLogger.e(a, "checkAdExpiration: reloading.", new Object[0]);
                } else {
                    boolean zA = value.a();
                    j jVar = value.l ? j.ActiveFailureReload : j.ReloadAfterExpiration;
                    SigmobLogger.d(a, "checkAdExpiration: expiredAd = " + zA + ", requestId = " + value.f + ", placementId = " + value.h + ", reloadLeftNum = " + value.c + ", requestSceneType = " + jVar.a(), new Object[0]);
                    boolean z = zA && n.b(Boolean.valueOf(value.l));
                    if (z || n.a(Boolean.valueOf(value.l))) {
                        if (z) {
                            BaseAdUnit baseAdUnitE = bVar.e();
                            if (value.b == value.c) {
                                ac.a(PointCategory.OBJECT_EXPIRE, (String) null, baseAdUnitE, new ac.a() { // from class: com.sigmob.sdk.manager.d$$ExternalSyntheticLambda0
                                    @Override // com.sigmob.sdk.base.common.ac.a
                                    public final void onAddExtra(Object obj) {
                                        d.a(value, obj);
                                    }
                                });
                            }
                        }
                        value.k = true;
                        bVar.a(value.d, value.g, jVar);
                        value.c--;
                    }
                }
                it.remove();
            }
        }
    }

    public Map<String, String> a(b adManager, Integer sceneTypeValue) {
        a aVarE;
        HashMap map = new HashMap();
        return (b.a(sceneTypeValue) && (aVarE = e(adManager)) != null) ? aVarE.b() : map;
    }

    public synchronized void a(long interval) {
        if (interval <= 0) {
            SigmobLogger.e(a, "startExpirationCheck: interval is unavailable.", new Object[0]);
            return;
        }
        boolean z = interval == this.d;
        SigmobLogger.d(a, "startExpirationCheck: status = " + this.c + ", interval = " + interval + ", result = " + z, new Object[0]);
        if (this.c && z) {
            return;
        }
        e();
        long j = interval * 1000;
        Timer timer = new Timer();
        this.e = timer;
        timer.schedule(new TimerTask() { // from class: com.sigmob.sdk.manager.d.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                d.this.f();
            }
        }, j, j);
        this.c = true;
        this.d = interval;
        SigmobLogger.d(a, "startExpirationCheck: status = " + this.c, new Object[0]);
    }

    public void a(LoadAdRequest loadAdRequest) {
        if (loadAdRequest != null && b.a(Integer.valueOf(loadAdRequest.getRequest_scene_type()))) {
            String originVid = loadAdRequest.getOriginVid();
            loadAdRequest.getOriginPrice();
            Iterator<Map.Entry<SoftReference<b>, a>> it = this.f.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null && m.a((CharSequence) originVid, (CharSequence) value.d)) {
                    value.k = false;
                    SigmobLogger.d(a, "loadEnd: originVid = " + originVid, new Object[0]);
                    return;
                }
            }
        }
    }

    public void a(b adManager) {
        a(adManager, false);
    }

    public void a(b adManager, boolean activeExpiration) {
        if (adManager == null) {
            SigmobLogger.e(a, "addAdManager: adManager is unavailable.", new Object[0]);
            return;
        }
        BaseAdUnit baseAdUnitE = adManager.e();
        if (baseAdUnitE == null) {
            SigmobLogger.e(a, "addAdManager: baseAdUnit is unavailable.", new Object[0]);
            return;
        }
        if (m.b(baseAdUnitE.getBid_token())) {
            return;
        }
        if (n.b(e(adManager))) {
            b(adManager);
        }
        if (b.b(Integer.valueOf(baseAdUnitE.getRequestSceneType()))) {
            return;
        }
        a aVar = new a(baseAdUnitE, activeExpiration);
        this.f.put(new SoftReference<>(adManager), aVar);
        int size = this.f.size();
        if (size == 1) {
            a(this.d);
        }
        SigmobLogger.i(a, "addAdManager: vid = " + aVar.d + ", size = " + size + ", activeExpiration = " + aVar.l, new Object[0]);
    }

    public void a(boolean lockScreenStatus) {
        this.g = lockScreenStatus;
    }

    public void b() {
        if (this.f.isEmpty()) {
            return;
        }
        this.f.clear();
    }

    public void b(b adManager) {
        if (adManager == null) {
            SigmobLogger.e(a, "removeAdManager: adManager is unavailable.", new Object[0]);
            return;
        }
        d(adManager);
        if (com.sigmob.sdk.base.utils.e.a(this.f)) {
            c();
        }
    }

    public synchronized void c() {
        SigmobLogger.d(a, "stopExpirationCheck: running = " + this.c, new Object[0]);
        if (this.c) {
            e();
            this.c = false;
        }
    }

    public void c(b adManager) {
        if (adManager == null) {
            SigmobLogger.e(a, "resetAdManager: adManager is unavailable.", new Object[0]);
        } else {
            d(adManager);
            a(adManager, true);
        }
    }

    public void d() {
        c();
        b();
        b = null;
    }
}
