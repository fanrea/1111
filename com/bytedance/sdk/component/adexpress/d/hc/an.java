package com.bytedance.sdk.component.adexpress.d.hc;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.utils.mq;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    public static int d = 2000;
    private static volatile an hc;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.d.b.b> u;
    private final Object c = new Object();
    private AtomicBoolean an = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.d.b.hc> h = new LruCache<String, com.bytedance.sdk.component.adexpress.d.b.hc>(d) { // from class: com.bytedance.sdk.component.adexpress.d.hc.an.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.d.b.hc hcVar) {
            return 1;
        }
    };
    private Set<String> b = Collections.synchronizedSet(new HashSet());

    public static an d() {
        if (hc == null) {
            synchronized (an.class) {
                if (hc == null) {
                    hc = new an();
                }
            }
        }
        return hc;
    }

    private an() {
    }

    com.bytedance.sdk.component.adexpress.d.b.hc d(String str) {
        com.bytedance.sdk.component.adexpress.d.b.hc hcVar;
        com.bytedance.sdk.component.adexpress.d.b.hc hcVarD;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.d.d.d.d().hc() == null) {
            return null;
        }
        synchronized (this.c) {
            hcVar = this.h.get(String.valueOf(str));
        }
        if (hcVar != null) {
            return hcVar;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.d.d.d.d().hc().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                        hcVarD = new com.bytedance.sdk.component.adexpress.d.b.hc().d(string).hc(string2).b(string3).c(string4).u(string5).an(cursorQuery.getString(cursorQuery.getColumnIndex(Config.INPUT_DEF_VERSION))).d(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                        synchronized (this.c) {
                            this.h.put(string2, hcVarD);
                        }
                        this.b.add(string2);
                    } while (cursorQuery.moveToNext());
                    return hcVarD;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return null;
    }

    Set<com.bytedance.sdk.component.adexpress.d.b.hc> hc(String str) {
        com.bytedance.sdk.component.adexpress.d.b.hc hcVar;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.d.d.d.d().hc() == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.d.d.d.d().hc().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.c) {
                                hcVar = this.h.get(string);
                            }
                            if (hcVar != null) {
                                hashSet.add(hcVar);
                            } else {
                                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                com.bytedance.sdk.component.adexpress.d.b.hc hcVarD = new com.bytedance.sdk.component.adexpress.d.b.hc().d(str).hc(string).b(string2).c(string3).u(string4).an(cursorQuery.getString(cursorQuery.getColumnIndex(Config.INPUT_DEF_VERSION))).d(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                                hashSet.add(hcVarD);
                                synchronized (this.c) {
                                    this.h.put(string, hcVarD);
                                }
                                this.b.add(string);
                            }
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    List<com.bytedance.sdk.component.adexpress.d.b.hc> hc() {
        if (com.bytedance.sdk.component.adexpress.d.d.d.d().hc() == null) {
            return null;
        }
        boolean z = this.an.get();
        this.an.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.d.d.d.d().hc().query("template_diff_new", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(TKDownloadReason.KSAD_TK_MD5));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex(Config.INPUT_DEF_VERSION));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.d.b.hc().d(string).hc(string2).b(string3).c(string4).u(string5).an(string6).d(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time")))));
                    synchronized (this.c) {
                        this.h.put(string2, arrayList.get(arrayList.size() - 1));
                    }
                    this.b.add(string2);
                    if (!z && com.bytedance.sdk.component.adexpress.d.d.d.d().an() != null) {
                        if (this.u == null) {
                            this.u = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.u.contains(string2)) {
                            this.u.put(string2, new com.bytedance.sdk.component.adexpress.d.b.b(string, string2, string3));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        mq.b("TmplDbHelper", "getTemplate error", th);
                        if (cursorQuery != null) {
                        }
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    void d(com.bytedance.sdk.component.adexpress.d.b.hc hcVar, boolean z) {
        if (hcVar == null || com.bytedance.sdk.component.adexpress.d.d.d.d().hc() == null || TextUtils.isEmpty(hcVar.hc())) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.component.adexpress.d.d.d.d().hc().query("template_diff_new", null, "id=?", new String[]{hcVar.hc()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("rit")) : null;
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", hcVar.d());
        contentValues.put("id", hcVar.hc());
        contentValues.put(TKDownloadReason.KSAD_TK_MD5, hcVar.b());
        contentValues.put("url", hcVar.c());
        contentValues.put("data", hcVar.u());
        contentValues.put(Config.INPUT_DEF_VERSION, hcVar.an());
        contentValues.put("update_time", hcVar.h());
        if (z2) {
            com.bytedance.sdk.component.adexpress.d.d.d.d().hc().update("template_diff_new", contentValues, "id=?", new String[]{hcVar.hc()});
        } else {
            com.bytedance.sdk.component.adexpress.d.d.d.d().hc().insert("template_diff_new", contentValues);
        }
        synchronized (this.c) {
            this.h.put(hcVar.hc(), hcVar);
        }
        this.b.add(hcVar.hc());
        if (z) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.d.d.d.d().an() == null) {
                return;
            }
            if (this.u == null) {
                this.u = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.d.b.b bVar = new com.bytedance.sdk.component.adexpress.d.b.b(hcVar.d(), hcVar.hc(), hcVar.b());
            this.u.put(hcVar.hc(), bVar);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.d.d.d.d().an().delete(string, bVar.hc());
            }
            com.bytedance.sdk.component.adexpress.d.d.d.d().an().update(hcVar.d(), bVar);
        } catch (Throwable unused2) {
        }
    }

    void d(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.d.d.d.d().hc() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                c(strArr[i]);
                com.bytedance.sdk.component.adexpress.d.d.d.d().hc().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                b(strArr[i]);
            }
        }
    }

    void b(String str) {
        com.bytedance.sdk.component.adexpress.d.b.b bVar;
        try {
            if (this.u == null || this.u.isEmpty() || (bVar = this.u.get(str)) == null) {
                return;
            }
            String strD = bVar.d();
            if (!TextUtils.isEmpty(strD) && com.bytedance.sdk.component.adexpress.d.d.d.d().an() != null) {
                com.bytedance.sdk.component.adexpress.d.d.d.d().an().delete(strD, str);
            }
            this.u.remove(str);
        } catch (Throwable unused) {
        }
    }

    private void c(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.d.b.hc> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.h) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.c) {
            this.h.remove(str);
        }
    }

    public static String b() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)").toString();
    }
}
