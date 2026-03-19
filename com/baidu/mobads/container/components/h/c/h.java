package com.baidu.mobads.container.components.h.c;

import android.content.Context;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h {
    private Context a;
    private int b = 0;
    private int c = -1;
    private e d;

    public h(Context context) {
        this.a = context.getApplicationContext();
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(int i) {
        this.c = i;
        if (this.c >= 0) {
            this.d = e.a(this.a);
        }
    }

    public boolean a(com.baidu.mobads.container.components.h.b.d dVar) {
        if (dVar == null) {
            return false;
        }
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.c> copyOnWriteArrayListF = dVar.f();
        if (copyOnWriteArrayListF.size() == 0) {
            return false;
        }
        CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.d> copyOnWriteArrayListD = dVar.d();
        if ((copyOnWriteArrayListD != null && copyOnWriteArrayListD.size() > 0) || a(copyOnWriteArrayListF, dVar)) {
            return false;
        }
        d(dVar);
        return true;
    }

    public boolean a(com.baidu.mobads.container.components.h.b.c cVar) {
        if (cVar != null) {
            int iA = cVar.a();
            if (com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_FAILED.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_TIMEOUT.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_FILTER.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_FAILED.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_CALLBACK_FAILED.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_DATA_LACK.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_FAILED.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_CLICK_RESPOND.b() == iA) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean b(com.baidu.mobads.container.components.h.b.c cVar) {
        if (cVar != null) {
            if (com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_NO_AD.b() == cVar.a()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void b(com.baidu.mobads.container.components.h.b.d dVar) {
        if (this.c >= 0 && dVar != null) {
            String strC = c(dVar);
            if (this.d != null) {
                this.d.b(dVar, strC);
            }
        }
    }

    private String c(com.baidu.mobads.container.components.h.b.d dVar) {
        ArrayList<com.baidu.mobads.container.components.h.b.c> arrayList = new ArrayList<>(dVar.f());
        HashMap<String, String> map = new HashMap<>(dVar.h());
        com.baidu.mobads.container.components.h.b.d dVarC = dVar;
        while (dVarC.c() != null) {
            dVarC = dVar.c();
            map.putAll(dVarC.h());
            arrayList.addAll(dVarC.f());
        }
        a(arrayList);
        return by.a.a(this.a).a(1048).a(map).a("codes", b(arrayList)).b().toString();
    }

    private boolean a(CopyOnWriteArrayList<com.baidu.mobads.container.components.h.b.c> copyOnWriteArrayList, com.baidu.mobads.container.components.h.b.d dVar) {
        com.baidu.mobads.container.components.h.b.c cVar;
        String strB;
        try {
            cVar = copyOnWriteArrayList.get(copyOnWriteArrayList.size() - 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (cVar == null) {
            return true;
        }
        int iA = cVar.a();
        switch (this.b) {
            case -1:
                return true;
            case 0:
                if (com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_FAILED.b() == iA) {
                    com.baidu.mobads.container.components.h.b.d dVarC = dVar.c();
                    if (dVarC == null) {
                        strB = dVar.b("prod");
                    } else {
                        strB = dVarC.b("prod");
                    }
                    if ("rsplash".equals(strB)) {
                        return false;
                    }
                }
                return true;
            case 1:
                return com.baidu.mobads.container.components.h.a.AD_EVENT_REQUEST_SUCCESS.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_RESPONSE_SUCCESS.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_CACHE_SUCCESS.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_SUCCESS.b() == iA || com.baidu.mobads.container.components.h.a.AD_EVENT_IMPRESSION_SUCCESS.b() == iA;
            default:
        }
    }

    private void d(com.baidu.mobads.container.components.h.b.d dVar) {
        ArrayList<com.baidu.mobads.container.components.h.b.c> arrayList = new ArrayList<>(dVar.f());
        HashMap<String, String> map = new HashMap<>(dVar.h());
        com.baidu.mobads.container.components.h.b.d dVarC = dVar;
        while (dVarC.c() != null) {
            dVarC = dVar.c();
            map.putAll(dVarC.h());
            arrayList.addAll(dVarC.f());
        }
        a(arrayList);
        com.baidu.mobads.container.l.g.d(map + ";codes :" + b(arrayList));
        String strB = b(arrayList);
        by.a aVarA = by.a.a(this.a).a(1048).a(map).a("codes", strB);
        StringBuffer stringBufferB = aVarA.b();
        aVarA.f();
        if (this.d != null && this.c >= 0) {
            this.d.a(dVar, stringBufferB.toString());
        }
        try {
            cc.a(this.a, strB + ((Object) stringBufferB), cc.a.STATE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(ArrayList<com.baidu.mobads.container.components.h.b.c> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size - 1; i++) {
            int i2 = 0;
            while (i2 < (size - i) - 1) {
                com.baidu.mobads.container.components.h.b.c cVar = arrayList.get(i2);
                int i3 = i2 + 1;
                com.baidu.mobads.container.components.h.b.c cVar2 = arrayList.get(i3);
                if (cVar.c() > cVar2.c()) {
                    arrayList.set(i2, cVar2);
                    arrayList.set(i3, cVar);
                }
                i2 = i3;
            }
        }
    }

    private String b(ArrayList<com.baidu.mobads.container.components.h.b.c> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                com.baidu.mobads.container.components.h.b.c cVar = arrayList.get(i);
                if (cVar != null) {
                    sb.append(cVar.a()).append(":").append(cVar.c()).append(i.b);
                }
            }
        }
        return sb.toString();
    }
}
