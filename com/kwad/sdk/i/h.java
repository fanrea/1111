package com.kwad.sdk.i;

import android.text.TextUtils;
import com.kwad.sdk.i.e;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h {
    private final AtomicBoolean cfF;
    private d cfH;
    private g cfI;
    private List<i> cfJ;
    private f cfK;
    private final AtomicBoolean mHasInit;
    private static final AtomicBoolean cfG = new AtomicBoolean(false);
    private static final float btI = new Random().nextFloat();

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.mHasInit = new AtomicBoolean(false);
        this.cfF = new AtomicBoolean(false);
    }

    static final class a {
        private static final h cfN = new h(0);
    }

    public static h alv() {
        return a.cfN;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            new StringBuilder("init sampling:").append(btI);
            j.alG();
            this.cfI = gVar;
            this.cfK = fVar;
            this.cfH = hF(str);
            this.mHasInit.set(true);
            alC();
        } catch (Throwable unused) {
            cfG.set(true);
            j.alF();
        }
    }

    public final void alw() {
        if (!this.mHasInit.get() || this.cfH == null) {
            return;
        }
        j.alG();
        m.alI();
    }

    public final synchronized void alx() {
        this.cfF.set(true);
    }

    public final synchronized void aly() {
        this.cfF.set(false);
    }

    public final g alz() {
        return this.cfI;
    }

    public final f alA() {
        return this.cfK;
    }

    public final long alB() {
        return this.cfH.alo();
    }

    private static d hF(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Throwable unused) {
            j.alF();
            return null;
        }
    }

    public final void f(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.cfF.get()) {
                    j.alG();
                    return;
                }
                i iVarHI = i.alE().hG(str).hH(str2).hI(str3);
                if (this.mHasInit.get()) {
                    b(iVarHI);
                } else {
                    if (cfG.get()) {
                        return;
                    }
                    j.alG();
                    a(iVarHI);
                }
            }
        } catch (Throwable unused) {
            j.alF();
        }
    }

    private void a(i iVar) {
        if (this.cfJ == null) {
            this.cfJ = new CopyOnWriteArrayList();
        }
        this.cfJ.add(iVar);
    }

    private void alC() {
        List<i> list = this.cfJ;
        if (list == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.cfJ.clear();
        this.cfJ = null;
    }

    private void b(final i iVar) {
        d dVar = this.cfH;
        if (dVar == null || j.aF(dVar.cft) || this.cfI == null || this.cfK == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.i.h.1
            @Override // com.kwad.sdk.i.n
            public final void doTask() {
                h hVar = h.this;
                e eVarA = hVar.a(hVar.cfH, iVar);
                if (eVarA == null) {
                    return;
                }
                iVar.t(eVarA.bun);
                m.a(iVar, eVarA.cfu == 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.cft;
        if (j.aF(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.cfv) && a(eVar.cfw, iVar) && eVar.bun > 0.0d && btI <= eVar.bun) {
                return eVar;
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.cfC != e.b.cfz) {
            return bVar.alp();
        }
        bVar.dh(b(bVar) && c(bVar) && d(bVar));
        return bVar.alp();
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.bMD;
        if (j.aF(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.cfI.getAppId(), it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.bME;
        if (j.aF(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.cfI.getSdkVersion(), it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(e.b bVar) {
        String androidId = this.cfI.getAndroidId();
        String deviceId = this.cfI.getDeviceId();
        String imei = this.cfI.getImei();
        String oaid = this.cfI.getOaid();
        List<String> list = bVar.cfB;
        if (j.aF(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(str, androidId) || TextUtils.equals(str, deviceId) || TextUtils.equals(str, imei) || TextUtils.equals(str, oaid)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.cfO) && b(aVar, iVar.cfP) && c(aVar, iVar.cfQ);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.cfx;
        if (j.aF(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.tagList;
        if (j.aF(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.cfy;
        if (j.aF(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
