package com.yxcorp.kuaishou.addfp;

import com.kuaishou.security.kste.export.IKSTECallback;
import com.kuaishou.security.kste.logic.event.KSTEException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class a implements IKSTECallback {
    final /* synthetic */ KWEGIDDFP a;

    a(KWEGIDDFP kwegiddfp) {
        this.a = kwegiddfp;
    }

    @Override // com.kuaishou.security.kste.export.IKSTECallback
    public void onError(KSTEException kSTEException) {
        this.a.isLoadding = false;
        new StringBuilder("kste exception ").append(kSTEException.getMessage());
    }

    @Override // com.kuaishou.security.kste.export.IKSTECallback
    public void onSuccess() {
        this.a.isLoadding = false;
        this.a.kSecurityCV.open();
    }

    @Override // com.kuaishou.security.kste.export.IKSTECallback
    public void report(String str, String str2) {
        StringBuilder sb = new StringBuilder("kste report ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
    }
}
