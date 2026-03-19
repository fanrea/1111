package com.kwad.components.offline.d.a;

import android.content.Intent;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements IOfflineHostActionHandler {
    private final r ahT;

    public c(r rVar) {
        this.ahT = rVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void showDialog(IOfflineTKDialog iOfflineTKDialog) {
        r rVar = this.ahT;
        if (rVar != null) {
            rVar.a(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void dismissDialog(IOfflineTKDialog iOfflineTKDialog) {
        r rVar = this.ahT;
        if (rVar != null) {
            rVar.b(a(iOfflineTKDialog));
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineHostActionHandler
    public final void startActivity(IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        r rVar = this.ahT;
        if (rVar != null) {
            rVar.a(a(iOfflineTKNativeIntent));
        }
    }

    private n a(final IOfflineTKNativeIntent iOfflineTKNativeIntent) {
        return new n() { // from class: com.kwad.components.offline.d.a.c.1
            @Override // com.kwad.sdk.components.n
            public final Intent getIntent() {
                return iOfflineTKNativeIntent.getIntent();
            }

            @Override // com.kwad.sdk.components.n
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKNativeIntent.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.n
            public final void callbackDismiss() {
                iOfflineTKNativeIntent.callbackDismiss();
            }

            @Override // com.kwad.sdk.components.n
            public final void a(q qVar) {
                iOfflineTKNativeIntent.registerJSCallHandler(new g(qVar));
            }

            @Override // com.kwad.sdk.components.n
            public final void callTKBridge(String str) {
                iOfflineTKNativeIntent.callTKBridge(str);
            }

            @Override // com.kwad.sdk.components.n
            public final String getTemplateString() {
                return iOfflineTKNativeIntent.getTemplateString();
            }

            @Override // com.kwad.sdk.components.n
            public final String getViewKey() {
                return iOfflineTKNativeIntent.getViewKey();
            }

            @Override // com.kwad.sdk.components.n
            public final String getClassName() {
                return iOfflineTKNativeIntent.getClassName();
            }

            @Override // com.kwad.sdk.components.n
            public final String getUrl() {
                return iOfflineTKNativeIntent.getUrl();
            }
        };
    }

    private l a(final IOfflineTKDialog iOfflineTKDialog) {
        return new l() { // from class: com.kwad.components.offline.d.a.c.2
            @Override // com.kwad.sdk.components.l
            public final int getDialogId() {
                return iOfflineTKDialog.getDialogId();
            }

            @Override // com.kwad.sdk.components.l
            public final String getViewKey() {
                return iOfflineTKDialog.getViewKey();
            }

            @Override // com.kwad.sdk.components.l
            public final String getStyleTemplate() {
                return iOfflineTKDialog.getStyleTemplate();
            }

            @Override // com.kwad.sdk.components.l
            public final boolean isHideNavigationBar() {
                return iOfflineTKDialog.isHideNavigationBar();
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackPageStatus(boolean z, String str) {
                iOfflineTKDialog.callbackPageStatus(z, str);
            }

            @Override // com.kwad.sdk.components.l
            public final void callbackDialogDismiss() {
                iOfflineTKDialog.callbackDialogDismiss();
            }

            @Override // com.kwad.sdk.components.l
            public final void a(q qVar) {
                iOfflineTKDialog.registerJSCallHandler(new g(qVar));
            }

            @Override // com.kwad.sdk.components.l
            public final void callTKBridge(String str) {
                iOfflineTKDialog.callTKBridge(str);
            }
        };
    }
}
