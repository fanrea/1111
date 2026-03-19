package com.kwad.components.ct.wallpaper.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ct.wallpaper.widget.a;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends RelativeLayout {
    private TextView Pc;
    private b bac;
    private a.InterfaceC0544a bae;
    private TextView baj;
    private TextView bak;
    private TextView bal;
    private ImageView bam;
    private Dialog ban;

    public c(Context context, b bVar, a.InterfaceC0544a interfaceC0544a, Dialog dialog) {
        super(context);
        this.bac = bVar;
        this.bae = interfaceC0544a;
        this.ban = dialog;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_dialog_panel_layout, (ViewGroup) this, true);
        this.Pc = (TextView) findViewById(R.id.ksad_dialog_panel_title);
        this.baj = (TextView) findViewById(R.id.ksad_dialog_panel_content);
        this.bak = (TextView) findViewById(R.id.ksad_dialog_panel_positive_button);
        this.bal = (TextView) findViewById(R.id.ksad_dialog_panel_negative_button);
        this.bam = (ImageView) findViewById(R.id.ksad_dialog_panel_top_image);
        this.Pc.setText(this.bac.ZS);
        if (!TextUtils.isEmpty(this.bac.bah)) {
            this.baj.setText(this.bac.bah);
            this.baj.setVisibility(0);
        } else {
            this.baj.setVisibility(8);
        }
        this.bak.setText(this.bac.baf);
        this.bal.setText(this.bac.bag);
        if (this.bac.bai != -1) {
            this.bam.setImageResource(this.bac.bai);
            this.bam.setVisibility(0);
        } else {
            this.bam.setVisibility(8);
        }
        if (this.bae != null) {
            this.bak.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.wallpaper.widget.c.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.bae.b(c.this.ban);
                }
            });
            this.bal.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.wallpaper.widget.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.bae.c(c.this.ban);
                }
            });
        }
    }

    public final void reset() {
        this.bae = null;
        this.bac = null;
    }
}
