package com.bytedance.sdk.component.tt.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.hc.d.an;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends c {
    public d(mq mqVar) {
        super(mqVar);
    }

    public void d(final com.bytedance.sdk.component.tt.d.d dVar) {
        try {
            k.d dVar2 = new k.d();
            dVar2.d((Object) hc());
            hc("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.an)) {
                dVar.d(this, new IOException("Url is Empty"));
                return;
            }
            dVar2.d(this.an);
            d(dVar2);
            this.b.d(dVar2.d().hc()).d(new com.bytedance.sdk.component.hc.d.b() { // from class: com.bytedance.sdk.component.tt.hc.d.1
                @Override // com.bytedance.sdk.component.hc.d.b
                public void onFailure(com.bytedance.sdk.component.hc.d.hc hcVar, IOException iOException) {
                    com.bytedance.sdk.component.tt.d.d dVar3 = dVar;
                    if (dVar3 != null) {
                        dVar3.d(d.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.hc.d.b
                public void onResponse(com.bytedance.sdk.component.hc.d.hc hcVar, cb cbVar) throws IOException {
                    int iIntValue;
                    byte[] bArr;
                    InputStream inputStreamB;
                    if (dVar != null) {
                        HashMap map = new HashMap();
                        if (cbVar != null) {
                            com.bytedance.sdk.component.tt.hc hcVar2 = new com.bytedance.sdk.component.tt.hc(cbVar.c(), cbVar.b(), cbVar.u(), map, null, cbVar.hc(), cbVar.d());
                            if (cbVar.c()) {
                                InputStream inputStream = null;
                                try {
                                    an anVarH = cbVar.h();
                                    if (anVarH != null) {
                                        for (int i = 0; i < anVarH.d(); i++) {
                                            map.put(anVarH.d(i), anVarH.hc(i));
                                        }
                                    }
                                    iIntValue = Long.valueOf(cbVar.an().d()).intValue();
                                    bArr = new byte[iIntValue];
                                    inputStreamB = cbVar.an().b();
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    if (inputStreamB.read(bArr) == iIntValue) {
                                        hcVar2.d(bArr);
                                    } else {
                                        hcVar2 = new com.bytedance.sdk.component.tt.hc(false, cbVar.b(), "Byte opt fail", map, null, cbVar.hc(), cbVar.d());
                                    }
                                    dVar.d(d.this, hcVar2);
                                    if (inputStreamB != null) {
                                        try {
                                            inputStreamB.close();
                                            return;
                                        } catch (Throwable unused) {
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = inputStreamB;
                                    try {
                                        com.bytedance.sdk.component.utils.mq.d(th);
                                        dVar.d(d.this, new IOException(th.getMessage()));
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                                return;
                                            } catch (Throwable unused2) {
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable unused3) {
                                            }
                                        }
                                        throw th3;
                                    }
                                }
                            }
                            dVar.d(d.this, hcVar2);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    @Override // com.bytedance.sdk.component.tt.hc.c
    public com.bytedance.sdk.component.tt.hc d() {
        InputStream inputStreamB;
        try {
            k.d dVar = new k.d();
            dVar.d((Object) hc());
            hc("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.an)) {
                com.bytedance.sdk.component.utils.mq.c("ByteDownloadExecutor", "execute: Url is Empty");
                return null;
            }
            dVar.d(this.an);
            d(dVar);
            cb cbVarD = this.b.d(dVar.d().hc()).d();
            if (cbVarD == null || !cbVarD.c()) {
                return null;
            }
            HashMap map = new HashMap();
            an anVarH = cbVarD.h();
            if (anVarH != null) {
                for (int i = 0; i < anVarH.d(); i++) {
                    map.put(anVarH.d(i), anVarH.hc(i));
                }
            }
            long jD = cbVarD.an().d();
            byte[] bArr = new byte[Long.valueOf(jD).intValue()];
            inputStreamB = cbVarD.an().b();
            try {
                if (inputStreamB.read(bArr) == jD) {
                    com.bytedance.sdk.component.tt.hc hcVar = new com.bytedance.sdk.component.tt.hc(cbVarD.c(), cbVarD.b(), cbVarD.u(), map, null, cbVarD.hc(), cbVarD.d());
                    hcVar.d(bArr);
                    if (inputStreamB != null) {
                        try {
                            inputStreamB.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return hcVar;
                }
                com.bytedance.sdk.component.tt.hc hcVar2 = new com.bytedance.sdk.component.tt.hc(false, cbVarD.b(), "Byte opt fail", map, null, cbVarD.hc(), cbVarD.d());
                if (inputStreamB != null) {
                    try {
                        inputStreamB.close();
                    } catch (Throwable unused2) {
                    }
                }
                return hcVar2;
            } catch (Throwable th) {
                th = th;
                try {
                    com.bytedance.sdk.component.utils.mq.d(th);
                    if (inputStreamB != null) {
                        try {
                            inputStreamB.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (inputStreamB != null) {
                        try {
                            inputStreamB.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamB = null;
        }
    }
}
