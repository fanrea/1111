package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements b {
    private static boolean bDN = true;
    public static double bDO = 1.0d;
    private static volatile boolean bDS = false;
    private static String bDT = "";
    private long bDP = -1;
    private long bDQ = -1;
    private long bDR = -1;
    private j bDU = new j();

    private static boolean aZ(long j) {
        return j != -1;
    }

    private static boolean bc(long j) {
        return j >= 50;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b fk(int i) {
        return fo(1);
    }

    public d() {
        bDO = new Random().nextDouble();
    }

    private static void aS(String str) {
        if (bDN) {
            com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: fC, reason: merged with bridge method [inline-methods] */
    public d fx(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.bDU.url = str;
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            aS("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: fD, reason: merged with bridge method [inline-methods] */
    public d fy(String str) {
        try {
            this.bDU.host = Uri.parse(str).getHost();
            aS("host:" + this.bDU.host);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: fn, reason: merged with bridge method [inline-methods] */
    public d fj(int i) {
        this.bDU.httpCode = i;
        aS("http_code:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: fE, reason: merged with bridge method [inline-methods] */
    public d fz(String str) {
        this.bDU.errorMsg = str;
        aS(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: fF, reason: merged with bridge method [inline-methods] */
    public d fA(String str) {
        this.bDU.bCP = str;
        aS("reqType:" + str);
        fH(com.kwad.sdk.ip.direct.a.aki());
        aaT();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aaM, reason: merged with bridge method [inline-methods] */
    public d aaE() {
        this.bDU.bCZ = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aaN, reason: merged with bridge method [inline-methods] */
    public d aaF() {
        this.bDQ = SystemClock.elapsedRealtime();
        aS("this.responseReceiveTime:" + this.bDQ);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ba, reason: merged with bridge method [inline-methods] */
    public d aY(long j) {
        this.bDU.bDf = j;
        aS("responseSize:" + j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aaO, reason: merged with bridge method [inline-methods] */
    public d aaG() {
        if (aZ(this.bDP) && aZ(this.bDQ)) {
            this.bDU.bDg = this.bDQ - this.bDP;
            aS("info.waiting_response_cost:" + this.bDU.bDg);
        }
        return this;
    }

    private d bb(long j) {
        this.bDU.bDh = j;
        aS("totalCost:" + j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: fG, reason: merged with bridge method [inline-methods] */
    public d fB(String str) {
        this.bDU.bDj = str;
        aS("requestId:" + str);
        return this;
    }

    private d fo(int i) {
        this.bDU.bDk = i;
        aS("hasData:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: fp, reason: merged with bridge method [inline-methods] */
    public d fl(int i) {
        this.bDU.result = i;
        aS("result:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aaP, reason: merged with bridge method [inline-methods] */
    public d aaH() {
        if (aZ(this.bDU.bCZ)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.bDP = jElapsedRealtime;
            j jVar = this.bDU;
            jVar.bCT = jElapsedRealtime - jVar.bCZ;
            if (aZ(this.bDU.bCR)) {
                j jVar2 = this.bDU;
                jVar2.bCS = jVar2.bCT - this.bDU.bCR;
            }
            aS("info.request_create_cost:" + this.bDU.bCT);
            aS("info.requestAddParamsCost:" + this.bDU.bCS);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b aaI() {
        if (aZ(this.bDU.bCZ)) {
            this.bDU.bCR = SystemClock.elapsedRealtime() - this.bDU.bCZ;
            aS("info.request_prepare_cost:" + this.bDU.bCR);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aaQ, reason: merged with bridge method [inline-methods] */
    public d aaJ() {
        if (aZ(this.bDQ)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.bDR = jElapsedRealtime;
            this.bDU.bDe = jElapsedRealtime - this.bDQ;
            aS("info.response_parse_cost:" + this.bDU.bDe);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: aaR, reason: merged with bridge method [inline-methods] */
    public d aaK() {
        if (aZ(this.bDR)) {
            this.bDU.bDl = SystemClock.elapsedRealtime() - this.bDR;
            aaS();
            aS("info.response_done_cost:" + this.bDU.bDl);
        }
        return this;
    }

    private void aaS() {
        j jVar = this.bDU;
        if (jVar == null || jVar.bDk != 1 || bc(this.bDU.bDl)) {
            return;
        }
        this.bDU.bDl = -1L;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b fm(int i) {
        this.bDU.bDn = i;
        if (i != 0) {
            this.bDU.bCQ = 1;
        }
        return this;
    }

    private d fH(String str) {
        this.bDU.bDm = str;
        return this;
    }

    private d aaT() {
        this.bDU.bDo = (int) com.kwad.sdk.ip.direct.a.akj();
        this.bDU.bDp = (int) com.kwad.sdk.ip.direct.a.akk();
        this.bDU.bDq = (int) com.kwad.sdk.ip.direct.a.akl();
        return this;
    }

    private static boolean c(i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.bDU)) {
            return;
        }
        if (this.bDU.httpCode != 200) {
            aaU();
            return;
        }
        long jElapsedRealtime = aZ(this.bDU.bCZ) ? SystemClock.elapsedRealtime() - this.bDU.bCZ : -1L;
        bb(jElapsedRealtime);
        if (jElapsedRealtime > 30000 || jElapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.bDU);
        }
        aS("report normal" + this.bDU.toString());
    }

    private void aaU() {
        i iVarC = c(this.bDU);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(iVarC);
        }
        com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", "reportError" + iVarC.toJson().toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.bCP = jVar.bCP;
        iVar.url = jVar.url;
        iVar.bCQ = jVar.bCQ;
        return iVar;
    }
}
