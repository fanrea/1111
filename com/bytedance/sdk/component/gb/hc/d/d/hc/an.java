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
public class an extends hc {
    protected List<String> b;
    private final Context c;
    protected com.bytedance.sdk.component.gb.d.u hc;
    private com.bytedance.sdk.component.gb.hc.c.hc.d u;

    public byte b() {
        return (byte) 0;
    }

    public byte hc() {
        return (byte) 2;
    }

    public an(Context context, com.bytedance.sdk.component.gb.hc.c.hc.d dVar, com.bytedance.sdk.component.gb.d.u uVar) {
        super(context, uVar, dVar == null ? com.bytedance.sdk.component.gb.hc.c.hc.d.b() : dVar);
        this.b = new ArrayList();
        this.c = context;
        this.u = dVar;
        this.hc = uVar;
        if (dVar == null) {
            this.u = com.bytedance.sdk.component.gb.hc.c.hc.d.b();
        }
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d
    public boolean d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        return com.bytedance.sdk.component.gb.hc.b.d.b(hcVar);
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.hc
    com.bytedance.sdk.component.gb.d.u c() {
        return this.hc;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.hc
    public String d() {
        com.bytedance.sdk.component.gb.d.an anVarHc = this.hc.hc();
        if (anVarHc != null) {
            return anVarHc.hc();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.b
    public List<com.bytedance.sdk.component.gb.d.hc> d(int i, String str, int i2, boolean z) {
        String str2;
        com.bytedance.sdk.component.gb.d.c cVar;
        String string;
        String string2;
        int i3;
        long jD = com.bytedance.sdk.component.gb.hc.hc.d.d(i, getContext(), this.hc);
        com.bytedance.sdk.component.gb.hc.b.b.hc(d() + " query db max :" + jD + " limit:" + i, this.hc);
        if (jD <= 0) {
            jD = 1;
        } else if (jD > 100) {
            jD = 100;
        }
        List<com.bytedance.sdk.component.gb.d.hc> arrayList = new ArrayList<>();
        this.b.clear();
        String str3 = "ad_extra_data";
        Cursor cursorQuery = com.bytedance.sdk.component.gb.hc.d.d.hc.query(getContext(), d(), new String[]{"id", com.alipay.sdk.m.p0.b.d, "encrypt", "retry"}, null, null, null, null, str + " DESC limit " + jD, this.hc);
        if (cursorQuery != null) {
            try {
                com.bytedance.sdk.component.gb.d.c cVarC = this.hc.c();
                while (cursorQuery.moveToNext()) {
                    try {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        string2 = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                        i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                        if (i4 == 1) {
                            string2 = cVarC.d(string2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        str2 = str3;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.b.add(string);
                    } else {
                        if (arrayList.size() > 100) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(string2);
                        str2 = str3;
                        try {
                            String strOptString = jSONObject.optString(str2);
                            if (TextUtils.isEmpty(strOptString)) {
                                cVar = cVarC;
                            } else {
                                JSONObject jSONObject2 = new JSONObject(strOptString);
                                jSONObject2.put("retry_count", i3);
                                cVar = cVarC;
                                try {
                                    jSONObject2.put("db_rd", System.currentTimeMillis());
                                    jSONObject.put(str2, jSONObject2.toString());
                                } catch (Throwable th2) {
                                    th = th2;
                                    com.bytedance.sdk.component.gb.hc.b.b.b(th.getMessage(), this.hc);
                                    cVarC = cVar;
                                    str3 = str2;
                                }
                            }
                            com.bytedance.sdk.component.gb.hc.c.d.d dVar = new com.bytedance.sdk.component.gb.hc.c.d.d(string, jSONObject);
                            dVar.d(b());
                            dVar.hc(hc());
                            com.bytedance.sdk.component.gb.hc.b.d.d(jSONObject, dVar, this.hc, i3);
                            arrayList.add(dVar);
                        } catch (Throwable th3) {
                            th = th3;
                            cVar = cVarC;
                            com.bytedance.sdk.component.gb.hc.b.b.b(th.getMessage(), this.hc);
                            cVarC = cVar;
                            str3 = str2;
                        }
                        cVarC = cVar;
                        str3 = str2;
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
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th4) {
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
                throw th4;
            }
        }
        com.bytedance.sdk.component.gb.hc.b.b.hc(d() + " query db actually size :" + arrayList.size(), this.hc);
        return arrayList;
    }

    @Override // com.bytedance.sdk.component.gb.hc.d.d.hc.b
    public List<com.bytedance.sdk.component.gb.d.hc> d(String str, int i, boolean z) {
        com.bytedance.sdk.component.gb.hc.c.hc.d dVar = this.u;
        if (dVar == null) {
            return new ArrayList();
        }
        return d(dVar.hc(), str, i, z);
    }

    protected String b(List<String> list) {
        d();
        list.size();
        String strD = com.bytedance.sdk.component.gb.hc.d.d.hc.d(getContext(), "DELETE FROM " + d() + " WHERE " + d("id", (List<?>) list, 1000, true), this.hc);
        com.bytedance.sdk.component.gb.hc.b.hc.d(com.bytedance.sdk.component.gb.hc.hc.hc.d.e(), list.size(), this.hc);
        d(list);
        return strD;
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
