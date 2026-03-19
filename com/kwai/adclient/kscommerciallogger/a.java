package com.kwai.adclient.kscommerciallogger;

import com.kwai.adclient.kscommerciallogger.model.c;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private com.kwai.adclient.kscommerciallogger.a.a cqQ;
    private com.kwai.adclient.kscommerciallogger.a.b cqR;
    private JSONObject cqS;
    private boolean cqT;
    private boolean isDebug;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.isDebug = false;
        this.cqT = false;
    }

    public static a arp() {
        return C0643a.arp();
    }

    public final void a(com.kwai.adclient.kscommerciallogger.a.a aVar, com.kwai.adclient.kscommerciallogger.a.b bVar, JSONObject jSONObject, boolean z, boolean z2) {
        this.cqQ = aVar;
        this.cqR = bVar;
        this.cqS = jSONObject;
        this.isDebug = z;
        this.cqT = z2;
    }

    public final JSONObject arq() {
        return this.cqS;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean arr() {
        return this.cqT;
    }

    public final void a(c cVar) {
        if (cVar == null) {
            return;
        }
        b(cVar);
        com.kwai.adclient.kscommerciallogger.a.b bVar = this.cqR;
        if (bVar != null) {
            bVar.T(cVar.ars(), cVar.toString());
        }
    }

    private void b(c cVar) {
        if (this.cqQ != null) {
            Object[] objArr = new Object[5];
            if (cVar.art() != null) {
                String str = cVar.art().value;
            }
            if (cVar.aru() != null) {
                cVar.aru().getValue();
            }
            cVar.arx();
            b.s(cVar.arv());
            b.s(cVar.arw());
        }
    }

    /* renamed from: com.kwai.adclient.kscommerciallogger.a$a, reason: collision with other inner class name */
    static final class C0643a {
        private static a cqU;

        public static a arp() {
            if (cqU == null) {
                cqU = new a((byte) 0);
            }
            return cqU;
        }
    }
}
