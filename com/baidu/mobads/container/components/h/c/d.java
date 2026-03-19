package com.baidu.mobads.container.components.h.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.cc;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    public static final String a = "request";
    public static final String b = "ad";
    public static final int c = 30;
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d>> d = new ConcurrentHashMap<>();
    private final h e;
    private Context f;

    public d(Context context) {
        this.e = new h(context);
        this.f = context;
        this.d.put("request", new CopyOnWriteArrayList<>());
        this.d.put("ad", new CopyOnWriteArrayList<>());
    }

    public void a(int i) {
        this.e.a(i);
    }

    public void b(int i) {
        this.e.b(i);
    }

    public void a(com.baidu.mobads.container.components.h.b.d dVar) {
        if (this.e != null) {
            this.e.b(dVar);
        }
    }

    public com.baidu.mobads.container.components.h.b.d a(String str) {
        if ("request".equals(str)) {
            return new com.baidu.mobads.container.components.h.b.e(str);
        }
        if ("ad".equals(str)) {
            return new com.baidu.mobads.container.components.h.b.a(str);
        }
        return new com.baidu.mobads.container.components.h.b.b(str);
    }

    public boolean b(com.baidu.mobads.container.components.h.b.d dVar) {
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList;
        if (dVar != null && (copyOnWriteArrayList = this.d.get(dVar.b())) != null) {
            b(copyOnWriteArrayList);
            if (!a(copyOnWriteArrayList, dVar)) {
                return copyOnWriteArrayList.add(dVar);
            }
            return false;
        }
        return false;
    }

    public void a() {
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            b(this.d.get(it.next()));
        }
    }

    public boolean a(CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList, com.baidu.mobads.container.components.h.b.d dVar) {
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && dVar != null) {
            for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
                com.baidu.mobads.container.components.h.b.d dVar2 = copyOnWriteArrayList.get(i);
                if (dVar2 != null && TextUtils.equals(dVar2.a(), dVar.a())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(String str, com.baidu.mobads.container.components.h.b.c cVar) {
        com.baidu.mobads.container.components.h.b.d dVarB;
        com.baidu.mobads.container.components.h.b.d dVarB2;
        if (!TextUtils.isEmpty(str) && cVar != null) {
            try {
                if (cc.a() && this.e != null && ((this.e.b(cVar) || this.e.a(cVar) || cVar.a() == com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_SUCCESS.b()) && (dVarB2 = b(str)) != null)) {
                    String strB = dVarB2.b(com.baidu.mobads.container.components.h.b.e.h);
                    String strB2 = dVarB2.b(com.baidu.mobads.container.components.h.b.e.l);
                    dVarB2.c(com.baidu.mobads.container.components.h.b.e.h);
                    dVarB2.c(com.baidu.mobads.container.components.h.b.e.l);
                    if (TextUtils.isEmpty(strB2)) {
                        strB2 = "code=" + cVar.a() + " , " + cVar.b();
                    }
                    if (!TextUtils.isEmpty(strB)) {
                        com.baidu.mobads.container.util.d.d.a(this.f).l(strB + '\n' + strB2 + "\n\n");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (this.e != null && this.e.b(cVar)) {
                d(str);
                return;
            }
            if (cVar.a() != com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_SUCCESS.b() && (dVarB = b(str)) != null) {
                dVarB.a(cVar);
                if (cVar.a() > com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_NO_AD.b()) {
                    a(dVarB);
                }
                if (this.e != null && this.e.a(cVar)) {
                    c(str);
                }
            }
        }
    }

    public com.baidu.mobads.container.components.h.b.d b(String str) {
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            com.baidu.mobads.container.components.h.b.d dVarA = a(it.next(), str);
            if (dVarA != null) {
                return dVarA;
            }
        }
        return null;
    }

    public com.baidu.mobads.container.components.h.b.d a(String str, String str2) {
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.d.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
                com.baidu.mobads.container.components.h.b.d dVar = copyOnWriteArrayList.get(i);
                if (dVar != null && str2.equals(dVar.a())) {
                    return dVar;
                }
            }
            return null;
        }
        return null;
    }

    public void a(String str, String str2, String str3) {
        com.baidu.mobads.container.components.h.b.d dVarB = b(str);
        if (dVarB != null) {
            dVarB.a(str2, str3);
        }
    }

    public void b(String str, String str2) {
        com.baidu.mobads.container.components.h.b.d dVarB = b(str);
        if (dVarB != null) {
            dVarB.c(str2);
        }
    }

    public void c(String str) {
        this.e.a(d(str));
    }

    public void c(com.baidu.mobads.container.components.h.b.d dVar) {
        if (d(dVar)) {
            this.e.a(dVar);
        }
    }

    public boolean d(com.baidu.mobads.container.components.h.b.d dVar) {
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList;
        if (dVar != null && (copyOnWriteArrayList = this.d.get(dVar.b())) != null) {
            return b(copyOnWriteArrayList, dVar);
        }
        return false;
    }

    public com.baidu.mobads.container.components.h.b.d d(String str) {
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            com.baidu.mobads.container.components.h.b.d dVarC = c(it.next(), str);
            if (dVarC != null) {
                return dVarC;
            }
        }
        return null;
    }

    public com.baidu.mobads.container.components.h.b.d c(String str, String str2) {
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList;
        com.baidu.mobads.container.components.h.b.d dVar;
        if (!TextUtils.isEmpty(str2) && (copyOnWriteArrayList = this.d.get(str)) != null && copyOnWriteArrayList.size() > 0) {
            int i = 0;
            while (true) {
                if (i >= copyOnWriteArrayList.size()) {
                    dVar = null;
                    break;
                }
                dVar = copyOnWriteArrayList.get(i);
                if (dVar != null && str2.equals(dVar.a())) {
                    break;
                }
                i++;
            }
            if (b(copyOnWriteArrayList, dVar)) {
                return dVar;
            }
        }
        return null;
    }

    public void b() {
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList = this.d.get(it.next());
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
        }
    }

    private void a(CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList) {
        int size = copyOnWriteArrayList.size();
        if (size > 1) {
            int i = 0;
            while (true) {
                int i2 = size - 1;
                if (i < i2) {
                    int i3 = i;
                    while (i3 < i2) {
                        com.baidu.mobads.container.components.h.b.d dVar = copyOnWriteArrayList.get(i3);
                        int i4 = i3 + 1;
                        com.baidu.mobads.container.components.h.b.d dVar2 = copyOnWriteArrayList.get(i4);
                        if (dVar.e() > dVar2.e()) {
                            copyOnWriteArrayList.set(i3, dVar2);
                            copyOnWriteArrayList.set(i4, dVar);
                        }
                        i3 = i4;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private void b(CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList) {
        com.baidu.mobads.container.components.h.b.d dVarC;
        if (copyOnWriteArrayList != null) {
            int i = 0;
            while (i < copyOnWriteArrayList.size()) {
                com.baidu.mobads.container.components.h.b.d dVar = copyOnWriteArrayList.get(i);
                if (dVar.i() && b(copyOnWriteArrayList, dVar)) {
                    this.e.a(dVar);
                } else {
                    i++;
                }
            }
            if (copyOnWriteArrayList.size() >= 30 && (dVarC = c(copyOnWriteArrayList)) != null) {
                b(copyOnWriteArrayList, dVarC);
                this.e.a(dVarC);
            }
        }
    }

    private com.baidu.mobads.container.components.h.b.d c(CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList) {
        try {
            if (copyOnWriteArrayList.size() > 1) {
                int i = 0;
                long jE = copyOnWriteArrayList.get(0).e();
                for (int i2 = 1; i2 < copyOnWriteArrayList.size(); i2++) {
                    com.baidu.mobads.container.components.h.b.d dVar = copyOnWriteArrayList.get(i2);
                    if (dVar.e() < jE) {
                        jE = dVar.e();
                        i = i2;
                    }
                }
                return copyOnWriteArrayList.get(i);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean b(CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList, com.baidu.mobads.container.components.h.b.d dVar) {
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayList2;
        try {
            if (copyOnWriteArrayList.remove(dVar)) {
                com.baidu.mobads.container.components.h.b.d dVarC = dVar.c();
                if (dVarC != null) {
                    dVarC.c(dVar);
                    if (dVarC.i() && (copyOnWriteArrayList2 = this.d.get(dVarC.b())) != null) {
                        return b(copyOnWriteArrayList2, dVarC);
                    }
                    return true;
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
