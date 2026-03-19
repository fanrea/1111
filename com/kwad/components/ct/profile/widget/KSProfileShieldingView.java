package com.kwad.components.ct.profile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KSProfileShieldingView extends FrameLayout {
    private a aRo;

    public interface a {
        void Jj();
    }

    public KSProfileShieldingView(Context context) {
        this(context, null);
    }

    public KSProfileShieldingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSProfileShieldingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.ksad_profile_shielding, this);
        ((TextView) findViewById(R.id.ksad_shield_relief_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.profile.widget.KSProfileShieldingView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (KSProfileShieldingView.this.aRo != null) {
                    KSProfileShieldingView.this.aRo.Jj();
                }
            }
        });
    }

    public void setShieldReliefClickListener(a aVar) {
        this.aRo = aVar;
    }
}
