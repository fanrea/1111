package ca.da.ca.da;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import ca.da.ca.da.g;
import ca.da.ca.fa.h;
import ca.da.ca.ia.j;
import ca.da.ca.ja.i;
import ca.da.ca.ja.k;
import ca.da.ca.ja.l;
import ca.da.ca.ja.m;
import ca.da.ca.ja.n;
import ca.da.ca.ja.r;
import ca.da.ca.ja.s;
import ca.da.ca.ja.t;
import com.apm.applog.AppLog;
import com.apm.applog.UriConfig;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.apm.common.utility.concurrent.ThreadPlus;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Engine.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements Handler.Callback, Comparator<ca.da.ca.ia.b> {
    public static HandlerThread w;
    public boolean a;
    public Application b;
    public ca.da.ca.fa.g c;
    public volatile ca.da.ca.ia.d e;
    public h f;
    public volatile Handler g;
    public e h;
    public f i;
    public UriConfig k;
    public Handler l;
    public long m;
    public volatile boolean n;
    public ca.da.ca.da.a o;
    public volatile d p;
    public volatile boolean r;
    public volatile long s;
    public volatile ca.da.ca.ea.a u;
    public final ArrayList<ca.da.ca.ia.b> d = new ArrayList<>(32);
    public CopyOnWriteArrayList<ca.da.ca.da.a> q = new CopyOnWriteArrayList<>();
    public final List<AbstractC0028b> t = new ArrayList();
    public boolean v = true;
    public g j = new g(this);

    /* compiled from: Engine.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d();
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: ca.da.ca.da.b$b, reason: collision with other inner class name */
    public abstract class AbstractC0028b<T> {
        public T a;

        public AbstractC0028b(b bVar, T t) {
            this.a = t;
        }
    }

    /* compiled from: Engine.java */
    public class c extends AbstractC0028b<String> {
        public c(String str) {
            super(b.this, str);
        }
    }

    public b(Application application, ca.da.ca.fa.g gVar, h hVar) {
        this.b = application;
        this.c = gVar;
        this.f = hVar;
        if (w == null) {
            synchronized (b.class) {
                if (w == null) {
                    HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
                    handlerThread.start();
                    w = handlerThread;
                }
            }
        }
        Handler handler = new Handler(w.getLooper(), this);
        this.l = handler;
        h hVar2 = this.f;
        ((ca.da.ca.ja.f) hVar2.g).b.a(handler);
        if (AppLog.isOAIdEnabled()) {
            ca.da.da.f.b.b(hVar2.b).a();
        }
        if (this.c.b.isClearDidAndIid()) {
            h hVar3 = this.f;
            String clearKey = this.c.b.getClearKey();
            k kVar = hVar3.g;
            if (kVar instanceof ca.da.ca.ja.f) {
                ((ca.da.ca.ja.f) kVar).a(hVar3.b, clearKey);
            }
            hVar3.c.e.edit().remove("device_token").commit();
        }
        if (this.c.b.getIpcDataChecker() != null && !this.c.k()) {
            this.c.b.getIpcDataChecker();
        }
        this.l.sendEmptyMessage(10);
        if (this.c.b.autoStart()) {
            this.n = true;
            this.l.sendEmptyMessage(1);
        }
        if (this.c.b.isFixPageView()) {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    public static boolean f() {
        return false;
    }

    public void a(boolean z, Context context) {
        l lVar = i.a;
        if (lVar != null) {
            lVar.a(z, context);
        } else {
            r.a("can't find ET, should compile with ET", (Throwable) null);
        }
    }

    public UriConfig c() {
        if (this.k == null) {
            UriConfig uriConfig = this.c.b.getUriConfig();
            this.k = uriConfig;
            if (uriConfig == null) {
                int i = s.a;
                this.k = s.b;
            }
        }
        return this.k;
    }

    @Override // java.util.Comparator
    public int compare(ca.da.ca.ia.b bVar, ca.da.ca.ia.b bVar2) {
        long j = bVar.b - bVar2.b;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public final void d() {
        j jVar = new j();
        jVar.n = PointCategory.INIT;
        jVar.a(System.currentTimeMillis());
        jVar.l = -1L;
        jVar.m = "";
        a(jVar);
    }

    public void e() {
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.length();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.os.Handler$Callback, ca.da.ca.da.b] */
    /* JADX WARN: Type inference failed for: r6v0, types: [ca.da.ca.da.g$a] */
    /* JADX WARN: Type inference failed for: r6v1, types: [ca.da.ca.ea.a] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Map<String, ?> all;
        Set set;
        Set set2;
        boolean z = false;
        ?? cVar = 0;
        String[] strArr = null;
        cVar = 0;
        cVar = 0;
        switch (message.what) {
            case 1:
                ca.da.ca.fa.g gVar = this.c;
                gVar.a(gVar.e.getBoolean("bav_log_collect", false));
                if (!this.f.j()) {
                    this.l.removeMessages(1);
                    this.l.sendEmptyMessageDelayed(1, 1000L);
                } else if (this.c.k()) {
                    HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                    handlerThread.start();
                    this.g = new Handler(handlerThread.getLooper(), this);
                    this.g.sendEmptyMessage(2);
                    if (this.d.size() > 0) {
                        this.l.removeMessages(4);
                        this.l.sendEmptyMessageDelayed(4, 1000L);
                    }
                    Application application = this.b;
                    m.a = true;
                    ThreadPlus.submitRunnable(new n(application));
                    r.a("net|worker start", (Throwable) null);
                }
                return true;
            case 2:
                e eVar = new e(this);
                this.h = eVar;
                this.q.add(eVar);
                f fVar = new f(this);
                this.i = fVar;
                this.q.add(fVar);
                c();
                if (this.f.f.getInt("version_code", 0) != this.f.h() || !TextUtils.equals(this.c.e.getString("channel", ""), this.c.d())) {
                    e eVar2 = this.h;
                    if (eVar2 != null) {
                        eVar2.i();
                    }
                    if (this.c.b.isEventFilterEnable()) {
                        try {
                            this.b.getSharedPreferences("sp_filter_name", 0).edit().clear().commit();
                        } catch (Throwable unused) {
                        }
                        a(null);
                    }
                } else if (this.c.b.isEventFilterEnable()) {
                    try {
                        SharedPreferences sharedPreferences = this.b.getSharedPreferences("sp_filter_name", 0);
                        HashSet hashSet = new HashSet();
                        HashMap map = new HashMap();
                        try {
                            all = sharedPreferences.getAll();
                        } catch (Throwable unused2) {
                            all = null;
                        }
                        if (all != null && all.size() > 0) {
                            int i = 0;
                            for (Map.Entry<String, ?> entry : all.entrySet()) {
                                if (entry != null) {
                                    String key = entry.getKey();
                                    if ("is_block".equals(key)) {
                                        i = sharedPreferences.getInt("is_block", 0);
                                    } else if ("events".equals(key)) {
                                        try {
                                            set2 = (Set) entry.getValue();
                                        } catch (Throwable unused3) {
                                            set2 = null;
                                        }
                                        if (set2 != null && set2.size() > 0) {
                                            hashSet.addAll(set2);
                                        }
                                    } else if (!TextUtils.isEmpty(key)) {
                                        HashSet hashSet2 = new HashSet();
                                        try {
                                            set = (Set) entry.getValue();
                                        } catch (Throwable unused4) {
                                            set = null;
                                        }
                                        if (set != null && set.size() > 0) {
                                            hashSet2.addAll(set);
                                        }
                                        if (hashSet2.size() > 0) {
                                            map.put(key, hashSet2);
                                        }
                                    }
                                }
                            }
                            cVar = i > 0 ? new ca.da.ca.ea.c(hashSet, map) : new ca.da.ca.ea.b(hashSet, map);
                        }
                    } catch (Throwable unused5) {
                    }
                    a(cVar);
                }
                this.g.removeMessages(6);
                this.g.sendEmptyMessage(6);
                return true;
            case 3:
            case 5:
            default:
                r.a((Throwable) null);
                return true;
            case 4:
                a((String[]) message.obj, false);
                return true;
            case 6:
                this.g.removeMessages(6);
                long j = 15000;
                if (!this.c.b.isSilenceInBackground() || this.j.b()) {
                    long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
                    Iterator<ca.da.ca.da.a> it = this.q.iterator();
                    while (it.hasNext()) {
                        ca.da.ca.da.a next = it.next();
                        if (!next.e) {
                            long jA = next.a();
                            if (jA < j2) {
                                j2 = jA;
                            }
                        }
                    }
                    long jCurrentTimeMillis = j2 - System.currentTimeMillis();
                    if (!this.v || jCurrentTimeMillis <= 15000) {
                        j = jCurrentTimeMillis;
                    }
                }
                this.g.sendEmptyMessageDelayed(6, j);
                if (this.t.size() > 0) {
                    synchronized (this.t) {
                        for (AbstractC0028b abstractC0028b : this.t) {
                            if (abstractC0028b != null) {
                                c cVar2 = (c) abstractC0028b;
                                b.this.a((String) cVar2.a);
                            }
                        }
                        this.t.clear();
                    }
                }
                return true;
            case 7:
                synchronized (this.d) {
                    ArrayList<ca.da.ca.ia.b> arrayList = this.d;
                    if (g.p == null) {
                        g.p = new g.b(cVar);
                    }
                    g.p.a(0L);
                    arrayList.add(g.p);
                }
                a(null, false);
                return true;
            case 8:
                ArrayList<ca.da.ca.ia.b> arrayList2 = (ArrayList) message.obj;
                if (!a(arrayList2)) {
                    b().a(arrayList2);
                }
                return true;
            case 9:
                ca.da.ca.da.a aVar = this.o;
                if (!aVar.e) {
                    long jA2 = aVar.a();
                    if (!aVar.e) {
                        this.g.sendEmptyMessageDelayed(9, jA2 - System.currentTimeMillis());
                    }
                }
                return true;
            case 10:
                synchronized (this.d) {
                    ca.da.ca.fa.b.a(this.d);
                }
                int size = ca.da.ca.fa.b.b.size();
                if (size > 0) {
                    strArr = new String[size];
                    ca.da.ca.fa.b.b.toArray(strArr);
                    ca.da.ca.fa.b.b.clear();
                }
                a(strArr, false);
                return true;
            case 11:
            case 13:
                return true;
            case 12:
                Object[] objArr = (Object[]) message.obj;
                String str = (String) objArr[0];
                j jVarA = (j) objArr[1];
                a(this.i);
                if (jVarA == null && (jVarA = ca.da.ca.ca.a.a()) != null) {
                    jVarA = (j) jVarA.m290clone();
                }
                ArrayList<ca.da.ca.ia.b> arrayList3 = new ArrayList<>();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jVarA != null) {
                    long j3 = jCurrentTimeMillis2 - jVarA.b;
                    jVarA.a(jCurrentTimeMillis2);
                    jVarA.l = j3 >= 0 ? j3 : 0L;
                    jVarA.p = this.j.m;
                    this.j.a(jVarA);
                    arrayList3.add(jVarA);
                }
                h hVar = this.f;
                if (hVar.a("user_unique_id", str)) {
                    ca.ca.ca.ca.a.a(hVar.c.c, "user_unique_id", str);
                    z = true;
                }
                if (z) {
                    if (str != null) {
                        this.c.l();
                    }
                    this.r = true;
                    a(this.h);
                    a(true);
                }
                if (jVarA != null) {
                    j jVar = (j) jVarA.m290clone();
                    jVar.a(jCurrentTimeMillis2 + 1);
                    jVar.l = -1L;
                    this.j.a(jVar, arrayList3, true).o = this.j.m;
                    this.j.a(jVar);
                    arrayList3.add(jVar);
                }
                if (!arrayList3.isEmpty()) {
                    b().a(arrayList3);
                }
                a(this.i);
                return true;
            case 14:
                a(null, true);
                return true;
            case 15:
                Object[] objArr2 = (Object[]) message.obj;
                boolean zBooleanValue = ((Boolean) objArr2[0]).booleanValue();
                String str2 = (String) objArr2[1];
                if (zBooleanValue) {
                    if (this.p == null) {
                        this.p = new d(this, str2);
                        this.q.add(this.p);
                        this.g.removeMessages(6);
                        this.g.sendEmptyMessage(6);
                    }
                } else if (this.p != null) {
                    this.p.e = true;
                    this.q.remove(this.p);
                    this.p = null;
                }
                return true;
            case 16:
                b((ca.da.ca.ia.b) message.obj);
                return true;
        }
    }

    public ca.da.ca.ia.d b() {
        if (this.e == null) {
            synchronized (this) {
                ca.da.ca.ia.d dVar = this.e;
                if (dVar == null) {
                    dVar = new ca.da.ca.ia.d(this, this.c.b.getDbName());
                }
                this.e = dVar;
            }
        }
        return this.e;
    }

    public final boolean a(ArrayList<ca.da.ca.ia.b> arrayList) throws JSONException {
        boolean z = true;
        String[] strArrA = ca.da.ca.ba.b.a(this, this.f.d(), true);
        JSONObject jSONObjectA = t.a(this.f.d());
        if (strArrA.length <= 0) {
            z = false;
        } else {
            int iA = ca.da.ca.ba.a.a(strArrA, ca.da.ca.ia.i.a(arrayList, jSONObjectA), this.c);
            if (iA != 200) {
                if (ca.da.ca.ba.a.a(iA)) {
                    this.m = System.currentTimeMillis();
                }
                z = false;
            } else {
                this.m = 0L;
            }
        }
        r.a("sendRealTime, " + z);
        return z;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.length();
        }
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.length();
        }
    }

    public void b(ca.da.ca.ia.b bVar) {
        d dVar = this.p;
        if (((bVar instanceof ca.da.ca.ia.g) || (bVar instanceof ca.da.ca.ia.k)) && dVar != null) {
            ca.da.ca.ba.a.a(this, bVar.f(), dVar.f);
        }
    }

    public boolean a(boolean z) {
        if ((!this.a || z) && this.g != null) {
            this.a = true;
            this.g.removeMessages(11);
            this.g.sendEmptyMessage(11);
        }
        return this.a;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.length();
        }
    }

    public void a(String[] strArr, boolean z) {
        ArrayList<ca.da.ca.ia.b> arrayList;
        ArrayList<ca.da.ca.ia.b> arrayListB;
        String str;
        synchronized (this.d) {
            arrayList = (ArrayList) this.d.clone();
            this.d.clear();
        }
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str2 : strArr) {
                arrayList.add(ca.da.ca.ia.b.a(str2));
            }
        }
        if (!arrayList.isEmpty()) {
            boolean zIsEventFilterEnable = this.c.b.isEventFilterEnable();
            ca.da.ca.ea.a aVar = this.u;
            ca.da.ca.ea.a aVar2 = AppLog.sEventFilterFromClient;
            if ((zIsEventFilterEnable && aVar != null) || aVar2 != null) {
                Iterator<ca.da.ca.ia.b> it = arrayList.iterator();
                while (it.hasNext()) {
                    ca.da.ca.ia.b next = it.next();
                    if (next instanceof ca.da.ca.ia.g) {
                        ca.da.ca.ia.g gVar = (ca.da.ca.ia.g) next;
                        String str3 = gVar.n;
                        String strC = gVar.c();
                        if ((aVar2 != null && !aVar2.a(str3, strC)) || (aVar != null && !aVar.a(str3, strC))) {
                            it.remove();
                        }
                    } else if (next instanceof ca.da.ca.ia.e) {
                        ca.da.ca.ia.e eVar = (ca.da.ca.ia.e) next;
                        if (aVar2 != null && !aVar2.a(eVar.m, eVar.o)) {
                            it.remove();
                        }
                    }
                }
            }
        }
        boolean zA = this.c.a(arrayList);
        if (arrayList.size() > 0 && this.c.k()) {
            if (!zA && arrayList.size() <= 100) {
                Iterator<ca.da.ca.ia.b> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    a(it2.next());
                }
            } else {
                if (i.a()) {
                    Iterator<ca.da.ca.ia.b> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        ca.da.ca.ia.b next2 = it3.next();
                        if (next2 instanceof ca.da.ca.ia.e) {
                            str = NotificationCompat.CATEGORY_EVENT;
                        } else if (next2 instanceof ca.da.ca.ia.g) {
                            str = "event_v3";
                        } else if (next2 instanceof ca.da.ca.ia.f) {
                            str = "log_data";
                        } else if (next2 instanceof ca.da.ca.ia.h) {
                            str = Config.LAUNCH;
                        } else {
                            str = next2 instanceof ca.da.ca.ia.m ? "terminate" : null;
                        }
                        if (str != null) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(next2.f());
                            i.a(str, jSONArray);
                        }
                    }
                }
                Collections.sort(arrayList, this);
                ArrayList<ca.da.ca.ia.b> arrayList2 = new ArrayList<>(arrayList.size());
                Iterator<ca.da.ca.ia.b> it4 = arrayList.iterator();
                boolean zA2 = false;
                boolean z2 = false;
                boolean zB = false;
                while (it4.hasNext()) {
                    ca.da.ca.ia.b next3 = it4.next();
                    zA2 |= this.j.a(next3, arrayList2);
                    if (next3 instanceof j) {
                        zB = g.b(next3);
                        z2 = true;
                    }
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        this.g.obtainMessage(16, next3).sendToTarget();
                    } else {
                        b(next3);
                    }
                }
                String[] realUris = c().getRealUris();
                if (this.g != null && realUris != null && realUris.length > 0 && System.currentTimeMillis() - this.m > 900000 && (arrayListB = this.c.b(arrayList2)) != null && arrayListB.size() > 0) {
                    this.g.obtainMessage(8, arrayListB).sendToTarget();
                }
                b().a(arrayList2);
                if (z2) {
                    if (zB) {
                        this.l.removeMessages(7);
                    } else {
                        this.l.sendEmptyMessageDelayed(7, this.c.h());
                    }
                }
                if (zA2) {
                    a(this.i);
                }
                if (!this.a && this.j.i && this.g != null && this.c.b.isAutoActive()) {
                    a(false);
                }
            }
        }
        if (z && this.c.k()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - this.s) > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                this.s = jCurrentTimeMillis;
                a(this.i);
            }
        }
    }

    public final void a(ca.da.ca.da.a aVar) {
        if (this.g == null || aVar == null) {
            return;
        }
        aVar.i();
        if (Looper.myLooper() == this.g.getLooper()) {
            aVar.a();
        } else {
            this.g.removeMessages(6);
            this.g.sendEmptyMessage(6);
        }
    }

    public void a(ca.da.ca.ia.b bVar) {
        int size;
        if (bVar == null) {
            return;
        }
        if (bVar.b == 0) {
            r.a((Throwable) null);
        }
        synchronized (this.d) {
            size = this.d.size();
            this.d.add(bVar);
        }
        boolean z = bVar instanceof j;
        if (size % 10 == 0 || z) {
            this.l.removeMessages(4);
            if (!z && size == 0) {
                this.l.sendEmptyMessageDelayed(4, 300L);
            } else {
                this.l.sendEmptyMessage(4);
            }
        }
    }

    public void a(String str) {
        String strG = this.f.g();
        if ((!TextUtils.isEmpty(str) || TextUtils.isEmpty(strG)) && (TextUtils.isEmpty(str) || TextUtils.equals(str, strG))) {
            return;
        }
        if (this.g != null) {
            j jVarA = ca.da.ca.ca.a.a();
            if (jVarA != null) {
                jVarA = (j) jVarA.m290clone();
            }
            Message messageObtainMessage = this.g.obtainMessage(12, new Object[]{str, jVarA});
            this.g.removeMessages(12);
            if (jVarA != null && !TextUtils.isEmpty(this.j.m)) {
                messageObtainMessage.sendToTarget();
                return;
            } else {
                this.g.sendMessageDelayed(messageObtainMessage, 300L);
                return;
            }
        }
        synchronized (this.t) {
            this.t.add(new c(str));
        }
    }

    public void a(ca.da.ca.ea.a aVar) {
        this.u = aVar;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.length();
        }
    }

    public final ca.da.ca.ia.h a() {
        try {
            AppLog appLog = AppLog.getInstance(this.f.a());
            if (appLog == null) {
                return null;
            }
            this.j.c();
            ca.da.ca.ia.h hVar = new ca.da.ca.ia.h();
            hVar.d = this.j.e;
            hVar.c = 10001L;
            hVar.a(System.currentTimeMillis());
            hVar.m = this.f.i();
            hVar.l = this.f.h();
            hVar.e = g.n;
            hVar.f = appLog.getUserUniqueID();
            hVar.g = appLog.getSsid();
            hVar.h = appLog.getAbSdkVersion();
            this.c.g();
            hVar.p = 0;
            r.a("Engine create Launch sid = " + hVar.d);
            return hVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
