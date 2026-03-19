package com.bytedance.sdk.component.an.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements tt {
    private byte[] d;
    private com.bytedance.sdk.component.an.an hc;

    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "image_type";
    }

    public hc(byte[] bArr, com.bytedance.sdk.component.an.an anVar) {
        this.d = bArr;
        this.hc = anVar;
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        tt gbVar;
        int iUo = bVar.uo();
        bVar.d(this.d.length);
        if (iUo != 2) {
            if (iUo == 3) {
                byte[] bArr = this.d;
                gbVar = new uo(bArr, bArr, this.hc, com.bytedance.sdk.component.an.b.b.d.hc(bArr));
            } else {
                boolean zHc = com.bytedance.sdk.component.an.b.b.d.hc(this.d);
                if (zHc) {
                    byte[] bArr2 = this.d;
                    gbVar = new uo(bArr2, bArr2, this.hc, zHc);
                } else if (com.bytedance.sdk.component.an.b.b.d.d(this.d)) {
                    gbVar = new u(this.d, this.hc);
                } else {
                    byte[] bArr3 = this.d;
                    gbVar = new uo(bArr3, bArr3, this.hc, zHc);
                }
            }
        } else if (com.bytedance.sdk.component.an.b.b.d.d(this.d)) {
            gbVar = new u(this.d, this.hc);
        } else if (this.hc == null) {
            gbVar = new mk();
        } else {
            gbVar = new gb(1001, "not image format", null);
        }
        bVar.d(gbVar);
    }
}
