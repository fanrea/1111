package com.bykv.vk.openvk.component.video.d.hc.hc;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.container.components.command.j;
import com.bytedance.sdk.component.tc.tc;
import com.kwai.video.player.misc.IMediaFormat;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static volatile b hc;
    private final c b;
    private final Executor c;
    private final SparseArray<Map<String, d>> d;
    private volatile SQLiteStatement u;

    private b(Context context) {
        SparseArray<Map<String, d>> sparseArray = new SparseArray<>(2);
        this.d = sparseArray;
        this.c = new com.bytedance.sdk.component.tc.c.c(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new tc(5, "video_proxy_db"));
        this.b = new c(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static b d(Context context) {
        if (hc == null) {
            synchronized (b.class) {
                if (hc == null) {
                    hc = new b(context);
                }
            }
        }
        return hc;
    }

    public d query(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, d> map = this.d.get(i);
        d dVar = map == null ? null : map.get(str);
        if (dVar != null) {
            return dVar;
        }
        try {
            Cursor cursorQuery = this.b.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    dVar = new d(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex(IMediaFormat.KEY_MIME)), cursorQuery.getInt(cursorQuery.getColumnIndex(j.i)), i, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (dVar != null && map != null) {
                map.put(str, dVar);
            }
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void insert(final d dVar) {
        if (dVar != null) {
            Map<String, d> map = this.d.get(dVar.c);
            if (map != null) {
                map.put(dVar.d, dVar);
            }
            this.c.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.hc.hc.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.u != null) {
                            b.this.u.clearBindings();
                        } else {
                            b bVar = b.this;
                            bVar.u = bVar.b.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        b.this.u.bindString(1, dVar.d);
                        b.this.u.bindString(2, dVar.hc);
                        b.this.u.bindLong(3, dVar.b);
                        b.this.u.bindLong(4, dVar.c);
                        b.this.u.bindString(5, dVar.u);
                        b.this.u.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void delete(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, d> map = this.d.get(i);
        if (map != null) {
            map.remove(str);
        }
        this.c.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.hc.hc.b.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b.getWritableDatabase().delete("video_http_header_t", "key=? AND flag=?", new String[]{str, String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void d(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        int i2 = -1;
        Map<String, d> map = this.d.get(i);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            this.b.getWritableDatabase().delete("video_http_header_t", "key IN(" + hc(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    private String hc(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public void d(final int i) {
        Map<String, d> map = this.d.get(i);
        if (map != null) {
            map.clear();
        }
        this.c.execute(new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.hc.hc.b.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.this.b.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
