package com.kwad.components.ct.tube.slide.detail.reward;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.proxy.g;
import com.kwad.components.ct.response.a.c;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.tube.d.b;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends g {
    private final InterfaceC0543a aYG;
    private final CtAdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ct.tube.slide.detail.reward.a$a, reason: collision with other inner class name */
    public interface InterfaceC0543a {
        void KR();

        void em();
    }

    @Override // com.kwad.components.core.proxy.g
    public final boolean si() {
        return false;
    }

    public static a a(Activity activity, CtAdTemplate ctAdTemplate, InterfaceC0543a interfaceC0543a) {
        if (activity != null && !activity.isFinishing() && ctAdTemplate != null) {
            try {
                a aVar = new a(activity, ctAdTemplate, interfaceC0543a);
                aVar.show();
                return aVar;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private a(Activity activity, CtAdTemplate ctAdTemplate, InterfaceC0543a interfaceC0543a) {
        super(activity);
        this.mAdTemplate = ctAdTemplate;
        this.aYG = interfaceC0543a;
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return R.layout.ksad_tube_reward_tip_dialog_layout;
    }

    @Override // com.kwad.components.core.proxy.g
    public final void h(View view) {
        TextView textView = (TextView) findViewById(R.id.ksad_dialog_title);
        TextView textView2 = (TextView) findViewById(R.id.ksad_dialog_title_num);
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate);
        textView.setText(c.w(ctPhotoInfoAy));
        textView2.setText(" · " + b.b(c.p(ctPhotoInfoAy)));
        ImageView imageView = (ImageView) findViewById(R.id.ksad_dialog_close_btn);
        TextView textView3 = (TextView) findViewById(R.id.ksad_dialog_confirm_btn);
        textView3.setText(b.c(c.p(ctPhotoInfoAy)));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.slide.detail.reward.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.dismiss();
                a.this.aYG.em();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.tube.slide.detail.reward.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (com.kwad.sdk.c.a.a.Wl()) {
                    return;
                }
                a.this.aYG.KR();
            }
        });
    }
}
