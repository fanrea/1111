package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.c;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g {
    private static Handler agB;
    private static WeakReference<Context> agJ;
    private static Messenger ckY;
    private static volatile ExecutorService ckZ;
    private static volatile AppStatusRules cla;
    private static com.kwad.sdk.collector.h clb;
    private static ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.utils.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                if (g.anx()) {
                    messageObtain.replyTo = g.ckY;
                    try {
                        messenger.send(messageObtain);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                com.kwad.sdk.core.d.c.w("AppStatusHelper", "clientMessenger init error");
            } catch (SecurityException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.service.d.gatherException(e);
            }
        }
    };

    public interface b {
        void ag(List<com.kwad.sdk.collector.model.b> list);
    }

    public static AppStatusRules anw() {
        return cla;
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (bd.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.aH(8192L) || context == null || com.kwad.sdk.utils.d.cP(context)) {
            return;
        }
        clb = hVar;
        boolean zIsInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isMainProcess: " + zIsInMainProcess);
        if (zIsInMainProcess) {
            agJ = new WeakReference<>(context);
            if (agB == null) {
                agB = new Handler(Looper.getMainLooper());
            }
            agB.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    /* renamed from: com.kwad.sdk.utils.g$2, reason: invalid class name */
    final class AnonymousClass2 extends bh {
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context) {
            this.val$context = context;
        }

        @Override // com.kwad.sdk.utils.bh
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.val$context, new c.a() { // from class: com.kwad.sdk.utils.g.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) throws ClassNotFoundException {
                    appStatusRules.initStatus(AnonymousClass2.this.val$context);
                    AppStatusRules unused = g.cla = appStatusRules;
                    g.b(AnonymousClass2.this.val$context, g.cla);
                    g.cR(AnonymousClass2.this.val$context);
                    boolean zEV = bs.eV(AnonymousClass2.this.val$context);
                    boolean zIsAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(g.cla);
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + zIsAppStatusTargetNotEmpty + ", permissionGranted: " + zEV);
                    if (zEV && zIsAppStatusTargetNotEmpty) {
                        long jObtainDefaultScanInterval = g.cla.obtainDefaultScanInterval();
                        if (jObtainDefaultScanInterval <= 0) {
                            g.cT(AnonymousClass2.this.val$context);
                        } else {
                            g.d(AnonymousClass2.this.val$context, jObtainDefaultScanInterval);
                        }
                    }
                    boolean zIsUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(g.cla);
                    boolean z = g.cla.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + zIsUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (zIsUploadTargetNotEmpty && z && zEV) {
                        g.any();
                        g.ckZ.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.val$context, g.cla);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.d.gatherException(th);
                                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void H(int i, String str) {
                    com.kwad.sdk.core.d.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    public static void cR(Context context) {
        if (cla == null) {
            cla = cS(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean anx() {
        if (ckY == null) {
            try {
                ckY = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return ckY != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String string = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.m(file.getAbsolutePath(), com.kwad.sdk.core.a.c.encodeKsSdk(string), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void any() {
        if (ckZ == null) {
            synchronized (g.class) {
                if (ckZ == null) {
                    ExecutorService executorServiceAcl = GlobalThreadPools.acl();
                    ckZ = executorServiceAcl;
                    com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) executorServiceAcl, "appStatusHelper");
                }
            }
        }
    }

    private static AppStatusRules cS(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String strJ = com.kwad.sdk.crash.utils.h.J(file);
            if (TextUtils.isEmpty(strJ)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.isEncodeKsSdk(strJ)) {
                strJ = com.kwad.sdk.core.a.c.decodeKsSdk(strJ);
            }
            JSONObject jSONObject = new JSONObject(strJ);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(final Context context, final long j) {
        if (agB == null) {
            agB = new Handler(Looper.getMainLooper());
        }
        agB.post(new bh() { // from class: com.kwad.sdk.utils.g.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() throws ClassNotFoundException {
                g.cT(context);
                g.agB.postDelayed(this, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cT(Context context) throws ClassNotFoundException {
        if (context == null) {
            return;
        }
        boolean zAnz = anz();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isServiceAvailable: " + zAnz);
        if (zAnz) {
            com.kwad.sdk.collector.b.a.a(context, serviceConnection);
        } else {
            a(context, new d(null));
        }
    }

    private static boolean anz() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            if (cls != null) {
                Context context = ServiceProvider.getContext();
                return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
            }
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        return false;
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || bd.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.aH(8192L) || com.kwad.sdk.utils.d.cP(context)) {
            return;
        }
        any();
        ckZ.submit(new Runnable() { // from class: com.kwad.sdk.utils.g.4
            @Override // java.lang.Runnable
            public final void run() {
                List listCU;
                try {
                    HashSet hashSet = new HashSet();
                    if (!bs.eV(context) || (listCU = g.cU(context)) == null) {
                        return;
                    }
                    Iterator it = listCU.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(listCU);
                    if (bVar != null) {
                        bVar.ag(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.d.gatherException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.kwad.sdk.collector.model.b> cU(Context context) {
        if (!bs.eV(context)) {
            return new ArrayList();
        }
        if (cla == null) {
            cla = cS(context);
        }
        return cV(context);
    }

    private static List<com.kwad.sdk.collector.model.b> cV(Context context) {
        ArrayList arrayList = new ArrayList();
        if (bd.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.aH(8192L) || com.kwad.sdk.utils.d.cP(context)) {
            return arrayList;
        }
        AppStatusRules appStatusRulesAnw = anw();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(appStatusRulesAnw)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy strategyD = com.kwad.sdk.collector.i.d(appStatusRulesAnw);
        arrayList.addAll(a(strategyD));
        strategyD.setNeedSaveLaunchTime(System.currentTimeMillis());
        return aH(arrayList);
    }

    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean zIsNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + zIsNeedLaunch);
        if (!zIsNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.Wm().a(strategy);
    }

    private static List<com.kwad.sdk.collector.model.b> aH(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static class a implements com.kwad.sdk.core.b {
        private String appName;
        private List<Long> clh = new ArrayList();
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        public a() {
        }

        public static JSONArray aI(List<com.kwad.sdk.collector.model.b> list) {
            List<a> listAJ;
            try {
                listAJ = aJ(list);
            } catch (Exception e) {
                com.kwad.sdk.service.d.gatherException(e);
                listAJ = null;
            }
            if (listAJ == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = listAJ.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        private static List<a> aJ(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap map = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String strB = com.kwad.sdk.collector.model.c.b(bVar);
                        if (map.containsKey(strB)) {
                            aVar = (a) map.get(strB);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            map.put(strB, aVar2);
                            aVar = aVar2;
                        }
                        long jC = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.by(jC);
                        }
                    }
                    return new ArrayList(map.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
            return null;
        }

        private void by(long j) {
            this.clh.add(Long.valueOf(j));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString("packageName");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("runningTimes");
            if (jSONArrayOptJSONArray != null) {
                this.clh.clear();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.clh.add(Long.valueOf(jSONArrayOptJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "appName", this.appName);
            aa.putValue(jSONObject, "packageName", this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.clh.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            aa.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }
    }

    static class d implements b {
        private b clj = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.g.b
        public final void ag(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray jSONArrayAI = a.aI(list);
            if (jSONArrayAI != null) {
                g.clb.c(jSONArrayAI);
            }
            b bVar = this.clj;
            if (bVar != null) {
                bVar.ag(list);
            }
        }
    }

    static class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                c(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }

        private void c(Message message) {
            ArrayList arrayList;
            List listA;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> listA2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        listA = aa.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.g.c.1
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b Le() {
                                return anI();
                            }

                            private static a anI() {
                                return new a();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        listA = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    listA = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    c((ArrayList<com.kwad.sdk.collector.model.b>) arrayList);
                }
                if (listA != null) {
                    aK(listA);
                }
            }
            if (g.agJ != null && g.agJ.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        listA2 = aa.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.g.c.2
                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b Le() {
                                return anJ();
                            }

                            private static AppStatusRules.Strategy anJ() {
                                return new AppStatusRules.Strategy();
                            }
                        });
                    }
                } else {
                    listA2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (listA2 != null) {
                    for (AppStatusRules.Strategy strategy : listA2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) g.agJ.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (g.agJ == null || g.serviceConnection == null) {
                return;
            }
            com.kwad.sdk.core.d.c.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) g.agJ.get(), g.serviceConnection);
        }

        private static void c(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray jSONArrayAI;
            if (arrayList == null || (jSONArrayAI = a.aI(arrayList)) == null) {
                return;
            }
            g.clb.c(jSONArrayAI);
        }

        private static void aK(List<a> list) {
            if (list == null) {
                return;
            }
            g.clb.c(aa.aL(list));
        }
    }
}
