package com.kwai.player.vr;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiPlayerStereoMesh {
    private static final String TAG = "KwaiPlayerStereoMesh";
    private KwaiBaseMesh mKwaiBaseMesh;

    public KwaiPlayerStereoMesh(int i) {
        genKwaiMesh(i);
    }

    public void genKwaiMesh(int i) {
        if (i == 1) {
            this.mKwaiBaseMesh = new KwaiSphereMesh();
        }
        KwaiBaseMesh kwaiBaseMesh = this.mKwaiBaseMesh;
        if (kwaiBaseMesh != null) {
            kwaiBaseMesh.genKwaiMesh();
        }
    }

    public KwaiMesh getKwaiMesh() {
        KwaiBaseMesh kwaiBaseMesh = this.mKwaiBaseMesh;
        if (kwaiBaseMesh != null) {
            return kwaiBaseMesh.getKwaiMesh();
        }
        return null;
    }
}
