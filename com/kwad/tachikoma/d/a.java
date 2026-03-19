package com.kwad.tachikoma.d;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void e(String str, V8Function v8Function) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            g gVar = new g(v8Function, pO());
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
            }
            gVar.call(null, null);
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
        }
    }

    public final String getString() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                return null;
            }
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip.getItemCount() <= 0) {
                return null;
            }
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getText() != null) {
                return itemAt.getText().toString();
            }
            return null;
        } catch (Throwable th) {
            OfflineHostProvider.getApi().crash().gatherException(th);
            return null;
        }
    }
}
