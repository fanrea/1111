package com.bytedance.sdk.component.tt.b;

import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.tt;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements tt {
    private int d;

    public void d(int i) {
        this.d = i;
    }

    @Override // com.bytedance.sdk.component.hc.d.tt
    public cb d(tt.d dVar) throws IOException {
        IOException iOException;
        k kVarD = dVar.d();
        if (h.d().d(this.d).hc() != null) {
            h.d().d(this.d).hc().u();
        }
        String string = kVarD.hc().toString();
        String strD = h.d().d(this.d).d(string);
        if (!string.equals(strD)) {
            kVarD = kVarD.h().d(strD).hc();
        }
        cb cbVarD = null;
        try {
            iOException = null;
            cbVarD = dVar.d(kVarD);
        } catch (Exception e) {
            iOException = new IOException(e.getMessage());
            h.d().d(this.d).d(kVarD, e);
        }
        h.d().d(this.d).d(kVarD, cbVarD);
        if (iOException == null) {
            return cbVarD == null ? dVar.d(kVarD) : cbVarD;
        }
        throw iOException;
    }
}
