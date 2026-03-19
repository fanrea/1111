package com.kwad.tachikoma.live.message;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import com.kwad.framework.tachikoma.a;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f extends com.tk.core.component.e<FrameLayout> {
    private TextView Dc;
    private LiveMessageRecyclerView Dx;
    private d Dy;
    private int Dz;

    public f(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public FrameLayout n(Context context) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(com.kwad.tachikoma.e.hP().hQ().wrapper().wrapContextIfNeed(context), a.c.ksad_live_message_layout, null);
        this.Dx = (LiveMessageRecyclerView) frameLayout.findViewById(a.b.ksad_message_list);
        this.Dc = (TextView) frameLayout.findViewById(a.b.ksad_message_tip);
        this.Dz = this.Dx.getContext().getResources().getDimensionPixelSize(a.C0561a.ksad_live_message_default_height);
        iv();
        return frameLayout;
    }

    public final void j(V8Object v8Object) {
        String string = v8Object.getString("userName");
        String string2 = v8Object.getString("content");
        LiveMessage liveMessage = new LiveMessage();
        liveMessage.userName = string;
        liveMessage.content = string2;
        if (this.Dy != null) {
            Log.d("live message tag", "live message received SCFeedPush");
            this.Dy.a(liveMessage);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.support.v7.widget.al$i, com.kwad.tachikoma.live.message.LiveMessageLinearLayoutManager] */
    private void iv() {
        c cVar = new c();
        ?? liveMessageLinearLayoutManager = new LiveMessageLinearLayoutManager(getContext());
        liveMessageLinearLayoutManager.t(true);
        this.Dx.setMathHeight(this.Dz);
        this.Dx.setLayoutManager(liveMessageLinearLayoutManager);
        this.Dx.setItemAnimator(null);
        this.Dx.setAdapter(cVar);
        if (this.Dx.getItemDecorationCount() == 0) {
            this.Dx.a(new e(com.kwad.tachikoma.t.e.a(getContext(), 4.0f)));
        }
        this.Dy = new d(this.Dx, cVar, this.Dc);
        this.Dy.io();
    }
}
