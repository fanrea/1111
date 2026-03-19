package com.kwad.tachikoma.m;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.RemoteViews;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.tachikoma.o.e;
import com.kwad.tachikoma.t.j;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends TKBaseNativeModule {
    private RemoteViews Es;

    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(com.kuaishou.tk.export.NativeModuleInitParams r4) {
        /*
            r3 = this;
            r3.<init>(r4)
            java.lang.Object[] r0 = r4.args
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1d
            java.lang.Object[] r0 = r4.args
            int r0 = r0.length
            if (r0 <= 0) goto L1d
            java.lang.Object[] r4 = r4.args
            r4 = r4[r2]
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 == 0) goto L1d
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            goto L1e
        L1d:
            r4 = 1
        L1e:
            if (r4 == r1) goto L45
            r0 = 2
            if (r4 == r0) goto L36
            r0 = 3
            if (r4 == r0) goto L27
            goto L35
        L27:
            android.content.Context r4 = r3.getContext()
            com.kwad.sdk.api.core.ICompletedRemoteView r4 = com.kwad.sdk.api.core.RemoteViewBuilder.createCompletedView(r4)
            android.widget.RemoteViews r4 = r4.build()
            r3.Es = r4
        L35:
            return
        L36:
            android.content.Context r4 = r3.getContext()
            com.kwad.sdk.api.core.IProgressRemoteView r4 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r4, r2, r2)
            android.widget.RemoteViews r4 = r4.build()
            r3.Es = r4
            return
        L45:
            android.content.Context r4 = r3.getContext()
            com.kwad.sdk.api.core.IProgressRemoteView r4 = com.kwad.sdk.api.core.RemoteViewBuilder.createProgressView(r4, r2, r1)
            android.widget.RemoteViews r4 = r4.build()
            r3.Es = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.m.c.<init>(com.kuaishou.tk.export.NativeModuleInitParams):void");
    }

    public final void a(String str, int i, int i2, int i3, int i4) {
        int id;
        if (this.Es == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.setViewPadding(id, j.b(getContext(), i), j.b(getContext(), i2), j.b(getContext(), i3), j.b(getContext(), i4));
    }

    public final void B(String str) {
        int id;
        if (this.Es == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.removeAllViews(id);
    }

    public final void d(String str, int i) {
        int id;
        if (this.Es == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.setViewVisibility(id, i);
    }

    public final void g(String str, String str2) {
        int id;
        if (this.Es == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.setTextViewText(id, str2);
    }

    public final void e(String str, int i) {
        int id;
        if (this.Es == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.setTextViewTextSize(id, 1, i);
    }

    public final void g(int i, int i2, boolean z) {
        int id;
        if (this.Es == null || (id = OfflineHostProvider.getApi().getId(getContext(), "ksad_download_progress")) == 0) {
            return;
        }
        this.Es.setProgressBar(id, i, i2, z);
    }

    public final void c(String str, V8Object v8Object) {
        e eVar;
        PendingIntent pendingIntent;
        int id;
        if (this.Es == null || (eVar = (e) getNativeModule(v8Object)) == null || (pendingIntent = eVar.getPendingIntent()) == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.setOnClickPendingIntent(id, pendingIntent);
    }

    public final void h(String str, String str2) {
        if (this.Es == null) {
            return;
        }
        int id = OfflineHostProvider.getApi().getId(getContext(), str);
        int drawableId = OfflineHostProvider.getApi().getDrawableId(getContext(), str2);
        if (id == 0 || drawableId == 0) {
            return;
        }
        this.Es.setImageViewResource(id, drawableId);
    }

    public final void d(String str, V8Object v8Object) {
        com.kwad.tachikoma.b.a aVar;
        Bitmap bitmap;
        int id;
        if (this.Es == null || (aVar = (com.kwad.tachikoma.b.a) getNativeModule(v8Object)) == null || (bitmap = aVar.getBitmap()) == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.setImageViewBitmap(id, bitmap);
    }

    public final void j(String str, String str2) {
        int id;
        if (this.Es == null || (id = OfflineHostProvider.getApi().getId(getContext(), str)) == 0) {
            return;
        }
        this.Es.setTextColor(id, Color.parseColor(str2));
    }

    public final RemoteViews iS() {
        return this.Es;
    }
}
