package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements View.OnClickListener {
    private TextView Pc;
    private ImageView Pd;
    private ImageView Pe;
    private InterfaceC0458a Pf;
    private ViewGroup xM;

    /* renamed from: com.kwad.components.core.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0458a {
        void x(View view);

        void y(View view);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.xM = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.Pc = (TextView) this.xM.findViewById(R.id.ksad_kwad_titlebar_title);
        this.Pd = (ImageView) this.xM.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.xM.findViewById(R.id.ksad_kwad_web_navi_close);
        this.Pe = imageView;
        imageView.setOnClickListener(this);
        this.Pd.setOnClickListener(this);
    }

    public final void a(InterfaceC0458a interfaceC0458a) {
        this.Pf = interfaceC0458a;
    }

    public final void a(b bVar) {
        TextView textView;
        if (this.xM == null || (textView = this.Pc) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
    }

    public final void aj(boolean z) {
        ImageView imageView = this.Pe;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final ViewGroup hT() {
        return this.xM;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Pf == null) {
            return;
        }
        if (view.equals(this.Pe)) {
            this.Pf.y(view);
        } else if (view.equals(this.Pd)) {
            this.Pf.x(view);
        }
    }
}
