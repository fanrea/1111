package com.kuaishou.security.kste.export;

import com.kuaishou.security.kste.logic.event.KSTEException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface IKSTECallback {
    public static final IKSTECallback DEFAULT = new IKSTECallback() { // from class: com.kuaishou.security.kste.export.IKSTECallback.1
        @Override // com.kuaishou.security.kste.export.IKSTECallback
        public final void onError(KSTEException kSTEException) {
        }

        @Override // com.kuaishou.security.kste.export.IKSTECallback
        public final void onSuccess() {
        }

        @Override // com.kuaishou.security.kste.export.IKSTECallback
        public final void report(String str, String str2) {
        }
    };

    void onError(KSTEException kSTEException);

    void onSuccess();

    void report(String str, String str2);
}
