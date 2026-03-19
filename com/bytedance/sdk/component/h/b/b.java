package com.bytedance.sdk.component.h.b;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.c.d.hc;
import com.bytedance.sdk.component.tc.tc;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b implements com.bytedance.sdk.component.c.d.hc {
    private static ThreadPoolExecutor d = null;
    private static int hc = 3;
    private final File b;
    private final File c;
    private volatile boolean gb;
    private final boolean k;
    private long mk;
    private final com.bytedance.sdk.component.h.hc mq;
    private long tt;
    private final Object u = new Object();
    private final Map<String, Object> an = new ConcurrentHashMap();
    private Map<String, Object> h = new HashMap();
    private final List<Runnable> tc = new ArrayList();
    private AtomicBoolean uo = new AtomicBoolean(false);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    static /* synthetic */ long b(b bVar) {
        long j = bVar.tt;
        bVar.tt = 1 + j;
        return j;
    }

    public b(File file, com.bytedance.sdk.component.h.d dVar, com.bytedance.sdk.component.h.hc hcVar, boolean z) {
        this.gb = false;
        this.k = z;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            dVar = new com.bytedance.sdk.component.h.b.d(null);
            file = file2;
        }
        this.b = file;
        this.c = new File(file.getPath() + ".bak");
        this.gb = false;
        dVar = dVar == null ? new com.bytedance.sdk.component.h.b.d(null) : dVar;
        if (hcVar == null) {
            this.mq = new com.bytedance.sdk.component.h.b.d(null);
        } else {
            this.mq = hcVar;
        }
        d(dVar);
    }

    private void d(final com.bytedance.sdk.component.h.d dVar) {
        synchronized (this.u) {
            this.gb = false;
        }
        u().execute(new Runnable() { // from class: com.bytedance.sdk.component.h.b.b.1
            @Override // java.lang.Runnable
            public void run() throws JSONException {
                b.this.hc(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(com.bytedance.sdk.component.h.d dVar) throws JSONException {
        synchronized (this.u) {
            if (this.gb) {
                return;
            }
            if (this.c.exists()) {
                this.b.delete();
                this.c.renameTo(this.b);
            }
            Map<String, Object> mapD = null;
            try {
                mapD = dVar.d(this.b);
            } catch (Throwable th) {
                d("loadFromDisk error", th);
            }
            synchronized (this.u) {
                this.gb = true;
                if (mapD != null) {
                    try {
                        for (Map.Entry<String, Object> entry : mapD.entrySet()) {
                            Object value = entry.getValue();
                            if (value != null) {
                                String key = entry.getKey();
                                if (key == null) {
                                    key = "";
                                }
                                this.an.put(key, value);
                            }
                        }
                    } finally {
                        this.u.notifyAll();
                    }
                }
            }
            synchronized (this.tc) {
                Iterator<Runnable> it = this.tc.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.tc.clear();
            }
        }
    }

    private void c() throws InterruptedException {
        while (!this.gb) {
            try {
                this.u.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private static ThreadPoolExecutor u() {
        ThreadPoolExecutor threadPoolExecutor = d;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (b.class) {
            ThreadPoolExecutor threadPoolExecutor2 = d;
            if (threadPoolExecutor2 != null) {
                return threadPoolExecutor2;
            }
            int i = hc;
            com.bytedance.sdk.component.tc.c.c cVar = new com.bytedance.sdk.component.tc.c.c(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new tc("SharedPreferencesImpl"));
            d = cVar;
            return cVar;
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> mapAn;
        if (this.k) {
            synchronized (this.u) {
                c();
                mapAn = an();
            }
            return mapAn;
        }
        return an();
    }

    private Map<String, ?> an() {
        HashMap map = new HashMap(this.an);
        map.putAll(this.h);
        return map;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strB;
        if (str == null) {
            str = "";
        }
        if (this.k) {
            synchronized (this.u) {
                c();
                strB = b(str, str2);
            }
            return strB;
        }
        return b(str, str2);
    }

    private String b(String str, String str2) throws JSONException {
        try {
            Object obj = this.h.get(str);
            if (obj == null) {
                obj = this.an.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            d("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setB;
        if (str == null) {
            str = "";
        }
        if (this.k) {
            synchronized (this.u) {
                c();
                setB = b(str, set);
            }
            return setB;
        }
        return b(str, set);
    }

    private Set<String> b(String str, Set<String> set) throws JSONException {
        try {
            Set<String> set2 = (Set) this.h.get(str);
            if (set2 == null) {
                set2 = (Set) this.an.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            d("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        int iB;
        if (str == null) {
            str = "";
        }
        if (this.k) {
            synchronized (this.u) {
                c();
                iB = b(str, i);
            }
            return iB;
        }
        return b(str, i);
    }

    private int b(String str, int i) throws JSONException {
        try {
            Object obj = this.h.get(str);
            if (obj == null) {
                obj = this.an.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            d("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        long jB;
        if (str == null) {
            str = "";
        }
        if (this.k) {
            synchronized (this.u) {
                c();
                jB = b(str, j);
            }
            return jB;
        }
        return b(str, j);
    }

    private long b(String str, long j) throws JSONException {
        try {
            Long l = (Long) this.h.get(str);
            if (l == null) {
                l = (Long) this.an.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            d("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float fB;
        if (str == null) {
            str = "";
        }
        if (this.k) {
            synchronized (this.u) {
                c();
                fB = b(str, f);
            }
            return fB;
        }
        return b(str, f);
    }

    private float b(String str, float f) throws JSONException {
        try {
            Object obj = this.h.get(str);
            if (obj == null) {
                obj = this.an.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            d("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        boolean zB;
        if (str == null) {
            str = "";
        }
        if (this.k) {
            synchronized (this.u) {
                c();
                zB = b(str, z);
            }
            return zB;
        }
        return b(str, z);
    }

    private boolean b(String str, boolean z) throws JSONException {
        try {
            Boolean bool = (Boolean) this.h.get(str);
            if (bool == null) {
                bool = (Boolean) this.an.get(str);
            }
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            d("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.u) {
            c();
            zContainsKey = this.an.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // android.content.SharedPreferences
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d edit() {
        synchronized (this.u) {
            c();
        }
        return new d();
    }

    private void d(Runnable runnable) {
        synchronized (this.tc) {
            if (this.gb) {
                runnable.run();
            } else {
                this.tc.add(runnable);
            }
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(final hc.d<Map<String, ?>> dVar) {
        if (this.gb) {
            dVar.d(this.an);
        } else {
            d(new Runnable() { // from class: com.bytedance.sdk.component.h.b.b.4
                @Override // java.lang.Runnable
                public void run() {
                    dVar.d(b.this.an);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public int hc(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public long hc(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public float hc(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public boolean hc(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public String hc(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public Set<String> hc(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void d(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.h.put(str, t);
            this.tt++;
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, int i) {
        d(str, (String) Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, long j) {
        d(str, (String) Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, float f) {
        d(str, (String) Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, boolean z) {
        d(str, (String) Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, String str2) {
        d(str, str2);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, Set<String> set) {
        d(str, (String) set);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.h.put(str, null);
            this.tt++;
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d() {
        if (this.gb) {
            this.an.clear();
            synchronized ("SharedPreferencesImpl") {
                this.h.clear();
                this.tt++;
            }
            return;
        }
        d(new Runnable() { // from class: com.bytedance.sdk.component.h.b.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.an.clear();
                synchronized ("SharedPreferencesImpl") {
                    b.this.h.clear();
                    b.b(b.this);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void hc() {
        if (!this.gb) {
            if (this.uo.compareAndSet(false, true)) {
                d(new Runnable() { // from class: com.bytedance.sdk.component.h.b.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.uo.set(false);
                        b.this.hc();
                    }
                });
            }
        } else if (this.mk != this.tt && this.uo.compareAndSet(false, true)) {
            u().execute(new Runnable() { // from class: com.bytedance.sdk.component.h.b.b.3
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    try {
                        Map<String, Object> mapH = b.this.h();
                        if (mapH != null) {
                            b.this.mq.d(mapH, b.this.b);
                        }
                        b.this.uo.set(false);
                    } catch (Exception e) {
                        b.this.d("apply write error", (Throwable) e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> h() {
        HashMap map;
        synchronized ("SharedPreferencesImpl") {
            map = new HashMap(this.h);
            this.h = new HashMap();
        }
        HashMap map2 = new HashMap(this.an);
        if (map.isEmpty() && map2.isEmpty()) {
            return map2;
        }
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            Object obj = map2.get(str);
            if (value == null) {
                if (obj != null) {
                    map2.remove(str);
                    i++;
                }
            } else if (!value.equals(obj)) {
                map2.put(str, value);
                i++;
            }
        }
        if (i > 0) {
            return map2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, Throwable th) throws JSONException {
        com.bytedance.sdk.component.c.b bVar = (com.bytedance.sdk.component.c.b) AutoService.d(com.bytedance.sdk.component.c.b.class);
        if (bVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(n.z, this.b.getAbsolutePath());
                jSONObject.put("msg", str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            bVar.d("kv", jSONObject, th);
        }
    }

    public final class d implements SharedPreferences.Editor {
        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        public d() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            b.this.d(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            b.this.d(str, (String) set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            b.this.d(str, (String) Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            b.this.d(str, (String) Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            b.this.d(str, (String) Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            b.this.d(str, (String) Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            b.this.d(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                b.b(b.this);
                b.this.h.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            b.this.hc();
        }
    }
}
