package com.bytedance.sdk.component.gb.hc.d.d.hc;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc extends com.bytedance.sdk.component.gb.hc.d.d implements b {
    private com.bytedance.sdk.component.gb.d.u b;
    private com.bytedance.sdk.component.gb.hc.c.hc.d c;
    private final Context hc;
    protected final List<com.bytedance.sdk.component.gb.d.hc> d = new ArrayList();
    private boolean u = false;
    private final Runnable an = new Runnable() { // from class: com.bytedance.sdk.component.gb.hc.d.d.hc.hc.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (hc.this) {
                if (hc.this.d.isEmpty()) {
                    hc.this.u = false;
                    return;
                }
                ArrayList arrayList = new ArrayList(hc.this.d);
                hc.this.d.clear();
                hc.this.u = false;
                hc.this.hc(arrayList);
            }
        }
    };

    abstract com.bytedance.sdk.component.gb.d.u c();

    public abstract String d();

    public hc(Context context, com.bytedance.sdk.component.gb.d.u uVar, com.bytedance.sdk.component.gb.hc.c.hc.d dVar) {
        this.hc = context;
        this.b = uVar;
        this.c = dVar;
    }

    private void hc() {
        if (this.u) {
            return;
        }
        com.bytedance.sdk.component.gb.hc.h.d.d(c()).d().postDelayed(this.an, r0.hc());
        this.u = true;
    }

    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, int i2, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z) {
        int iHc;
        if (this.c == null || hcVar == null || !com.bytedance.sdk.component.gb.hc.b.d.d(i) || !d(hcVar) || (iHc = this.c.hc()) <= i2) {
            return null;
        }
        return d(iHc - i2, "_id", i, z);
    }

    public com.bytedance.sdk.component.gb.hc.d.hc d(int i, List<com.bytedance.sdk.component.gb.d.hc> list) {
        com.bytedance.sdk.component.gb.hc.d.hc hcVar = new com.bytedance.sdk.component.gb.hc.d.hc();
        if (list != null && list.size() != 0 && list.get(0) != null && d(list.get(0))) {
            if (i == 200 || i == -1 || i == -3) {
                hcVar.d(delete(list));
            } else {
                hcVar.d("code:".concat(String.valueOf(i)));
            }
            hcVar.d(true);
            return hcVar;
        }
        hcVar.d(false);
        return hcVar;
    }

    public int u() {
        int i = 0;
        Cursor cursorQuery = null;
        try {
            cursorQuery = com.bytedance.sdk.component.gb.hc.d.d.hc.query(getContext(), d(), new String[]{"count(1)"}, null, null, null, null, null, this.b);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                i = cursorQuery.getInt(0);
            }
        } catch (Exception unused) {
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception unused3) {
            }
        }
        return i;
    }

    protected void d(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<com.bytedance.sdk.component.gb.d.hc> it = this.d.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.gb.d.hc next = it.next();
                if (next != null) {
                    String strB = next.b();
                    if (!TextUtils.isEmpty(strB) && list.contains(strB)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.d("DBInsertMemRepo", d() + "deleteMemList: " + th.getMessage(), this.b.u());
        }
    }

    public synchronized void hc(com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (d(hcVar) && hcVar.h() != null && !TextUtils.isEmpty(hcVar.b())) {
            this.d.add(hcVar);
            hc();
        }
    }

    public Context getContext() {
        return this.hc;
    }

    public void hc(List<com.bytedance.sdk.component.gb.d.hc> list) {
        com.bytedance.sdk.component.gb.hc.d.d.hc.insert(getContext(), d(), list, this.b);
        Iterator<com.bytedance.sdk.component.gb.d.hc> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.sdk.component.gb.hc.b.d.d(it.next(), this.b, "_db");
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public List<com.bytedance.sdk.component.gb.d.hc> hc(int i, com.bytedance.sdk.component.gb.d.hc hcVar, boolean z, List<String> list, String str) {
        List<com.bytedance.sdk.component.gb.d.hc> listD = d("_id", i, z);
        if (!d(listD, list)) {
            return null;
        }
        d();
        listD.size();
        return listD;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public boolean d(String str) {
        if (this.c == null) {
            return false;
        }
        int iU = u();
        com.bytedance.sdk.component.gb.hc.b.b.d("check flush db " + d() + " count:" + iU, this.b);
        return iU > 0;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public boolean hc(int i, String str, com.bytedance.sdk.component.gb.d.hc hcVar) {
        if (this.c == null) {
            return false;
        }
        int iU = u();
        int iD = this.c.d();
        com.bytedance.sdk.component.gb.hc.b.b.d("check db " + d() + " count:" + iU + " MaxCacheCount:" + iD + " message:" + com.bytedance.sdk.component.gb.hc.b.d.hc(i), this.b);
        return iU >= iD;
    }

    private boolean d(List<com.bytedance.sdk.component.gb.d.hc> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.gb.d.hc> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.gb.d.hc next = it.next();
                    if (next != null) {
                        String strB = next.b();
                        if (!TextUtils.isEmpty(strB) && list2.contains(strB)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.gb.hc.b.b.d("DBInsertMemRepo", "deleteMemList: " + th.getMessage(), this.b);
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }
}
