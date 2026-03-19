package com.bytedance.sdk.component.an.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk extends d {
    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "net_request";
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(final com.bytedance.sdk.component.an.b.b bVar) {
        final com.bytedance.sdk.component.an.b.an anVarJh = bVar.jh();
        com.bytedance.sdk.component.an.c cVarC = anVarJh.c();
        bVar.d(false);
        try {
            com.bytedance.sdk.component.an.an anVarCall = cVarC.call(new com.bytedance.sdk.component.an.hc.b(bVar.hc(), bVar.k(), bVar.e(), bVar.v()));
            int iHc = anVarCall.hc();
            bVar.d(anVarCall.d());
            if (anVarCall.hc() == 200) {
                final byte[] bArr = (byte[]) anVarCall.b();
                bVar.d(new hc(bArr, anVarCall));
                final String strAn = bVar.an();
                final com.bytedance.sdk.component.an.hc hcVarSy = bVar.sy();
                if (hcVarSy.h()) {
                    anVarJh.hc(bVar.sy()).d(strAn, bArr);
                }
                anVarJh.an().submit(new Runnable() { // from class: com.bytedance.sdk.component.an.c.mk.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hcVarSy.c()) {
                            anVarJh.b(bVar.sy()).d(strAn, bArr);
                        }
                    }
                });
                return;
            }
            anVarJh.gb();
            String.valueOf(anVarCall);
            Object objB = anVarCall.b();
            d(iHc, anVarCall.c(), objB instanceof Throwable ? (Throwable) objB : null, bVar);
        } catch (Throwable th) {
            d(1004, "net request failed!", th, bVar);
        }
    }

    private void d(int i, String str, Throwable th, com.bytedance.sdk.component.an.b.b bVar) {
        bVar.d(new gb(i, str, th));
    }
}
