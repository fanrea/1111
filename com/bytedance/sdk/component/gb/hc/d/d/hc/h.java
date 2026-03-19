package com.bytedance.sdk.component.gb.hc.d.d.hc;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends hc {
    protected List<String> b;
    private com.bytedance.sdk.component.gb.hc.c.hc.d c;
    protected com.bytedance.sdk.component.gb.d.u hc;

    public byte b() {
        return (byte) 2;
    }

    public byte hc() {
        return (byte) 1;
    }

    public h(Context context, com.bytedance.sdk.component.gb.hc.c.hc.d dVar, com.bytedance.sdk.component.gb.d.u uVar) {
        super(context, uVar, dVar == null ? com.bytedance.sdk.component.gb.hc.c.hc.d.b() : dVar);
        this.b = new ArrayList();
        this.c = dVar;
        this.hc = uVar;
        if (dVar == null) {
            this.c = com.bytedance.sdk.component.gb.hc.c.hc.d.b();
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public boolean d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return com.bytedance.sdk.component.gb.hc.b.d.c(hcVar);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.hc
    com.bytedance.sdk.component.gb.d.u c() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.hc
    public String d() {
        return this.hc.hc().c();
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.b
    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, String str, int i2, boolean z) {
        long jD = com.bytedance.sdk.component.gb.hc.hc.d.d(i, getContext(), this.hc);
        if (jD <= 0) {
            jD = 1;
        } else if (jD > 100) {
            jD = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.b.clear();
        Cursor cursorQuery = com.bytedance.sdk.component.gb.hc.d.d.hc.query(getContext(), d(), new String[]{"id", com.alipay.sdk.m.p0.b.d, "encrypt"}, null, null, null, null, str + " DESC limit " + jD, this.hc);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d));
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt")) == 1) {
                            string2 = this.hc.c().d(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.b.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            com.bytedance.sdk.component.gb.hc.c.d.d dVar = new com.bytedance.sdk.component.gb.hc.c.d.d(string, new JSONObject(string2));
                            dVar.hc(b());
                            dVar.d(hc());
                            arrayList.add(dVar);
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                            if (!this.b.isEmpty()) {
                                b(this.b);
                                this.b.clear();
                            }
                            if (com.bytedance.sdk.component.gb.hc.b.d.d(i2) && !z) {
                                d(arrayList, 5, 604800000L);
                            }
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                    if (!this.b.isEmpty()) {
                        b(this.b);
                        this.b.clear();
                    }
                    if (com.bytedance.sdk.component.gb.hc.b.d.d(i2) && !z) {
                        d(arrayList, 5, 604800000L);
                    }
                } catch (Exception unused3) {
                }
            }
        }
        return arrayList;
    }

    protected void b(List<String> list) {
        d();
        list.size();
        com.bytedance.sdk.component.gb.hc.d.d.hc.d(getContext(), "DELETE FROM " + d() + " WHERE " + d("id", (List<?>) list, 1000, true), this.hc);
        com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.e(), list.size(), this.hc);
        d(list);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.b
    public List<com.bytedance.sdk.component.gb.d.hc> d(String str, int i, boolean z) {
        com.bytedance.sdk.component.gb.hc.c.hc.d dVar = this.c;
        if (dVar == null) {
            return new ArrayList();
        }
        return d(dVar.hc(), str, i, z);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.b
    public String delete(List<com.bytedance.sdk.component.gb.d.hc> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.gb.d.hc> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().b());
        }
        com.bytedance.sdk.component.gb.hc.b.d.d(list, this.hc, d());
        String strD = com.bytedance.sdk.component.gb.hc.d.d.hc.d(getContext(), "DELETE FROM " + d() + " WHERE " + d("id", (List<?>) linkedList, 1000, true), this.hc);
        d(linkedList);
        return strD;
    }

    private void d(int i, long j) {
        com.bytedance.sdk.component.gb.hc.d.d.hc.delete(getContext(), d(), "gen_time <? OR retry >?", new String[]{new StringBuilder().append(System.currentTimeMillis() - j).toString(), new StringBuilder().append(i).toString()}, this.hc);
    }

    public void d(List<com.bytedance.sdk.component.gb.d.hc> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            c(list);
            d(i, j);
        } catch (Exception unused) {
        }
    }

    private void c(List<com.bytedance.sdk.component.gb.d.hc> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.bytedance.sdk.component.gb.d.hc> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().b());
        }
        com.bytedance.sdk.component.gb.hc.d.d.hc.d(getContext(), "UPDATE " + d() + " SET retry = retry+1 WHERE " + d("id", (List<?>) linkedList, 1000, true), this.hc);
    }

    public static String c(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String u(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    private static String d(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strD = d(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str).append(str2).append("('").append(strD).append("')");
        }
        return d(sb.toString(), str + str2 + "('')");
    }

    private static String d(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
