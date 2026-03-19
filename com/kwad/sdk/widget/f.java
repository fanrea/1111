package com.kwad.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f extends d {
    private b cpP;
    private String cpQ;
    private String cpR;
    private int cpS;
    private String cpT;
    private int cpU;

    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public f(a aVar) throws Resources.NotFoundException {
        super(aVar.mContext);
        a(aVar);
    }

    private void a(a aVar) throws Resources.NotFoundException {
        int color;
        int color2;
        if (aVar.mContext instanceof Activity) {
            setOwnerActivity((Activity) aVar.mContext);
        }
        this.cpP = aVar.cpP;
        this.cpQ = aVar.cpQ;
        this.cpR = !TextUtils.isEmpty(aVar.cpR) ? aVar.cpR : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        if (aVar.cpS == 0) {
            color = aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        } else {
            color = aVar.cpS;
        }
        this.cpS = color;
        this.cpT = !TextUtils.isEmpty(aVar.cpT) ? aVar.cpT : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        if (aVar.cpU == 0) {
            color2 = aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
        } else {
            color2 = aVar.cpU;
        }
        this.cpU = color2;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(sb());
            setCanceledOnTouchOutside(true);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private View sb() {
        View viewInflate = LayoutInflater.from(com.kwad.sdk.p.m.wrapContextIfNeed(getContext())).inflate(R.layout.ksad_no_title_common_dialog_content_layout, (ViewGroup) null, false);
        viewInflate.findViewById(R.id.ksad_no_title_common_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.f.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (f.this.cpP != null) {
                    f.this.cpP.c(f.this);
                }
            }
        });
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_no_title_common_positive_btn);
        if (!TextUtils.isEmpty(this.cpR)) {
            textView.setText(this.cpR);
        }
        textView.setTextColor(this.cpS);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.f.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (f.this.cpP != null) {
                    f.this.cpP.a(f.this);
                }
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.cpT)) {
            textView2.setText(this.cpT);
        }
        textView2.setTextColor(this.cpU);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.f.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (f.this.cpP != null) {
                    f.this.cpP.b(f.this);
                }
            }
        });
        ((TextView) viewInflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.cpQ);
        return viewInflate;
    }

    public static class a {
        private b cpP;
        private String cpQ;
        private String cpR;
        private int cpS;
        private String cpT;
        private int cpU;
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        public final a je(String str) {
            this.cpQ = str;
            return this;
        }

        public final a jf(String str) {
            this.cpR = str;
            return this;
        }

        public final a jg(String str) {
            this.cpT = str;
            return this;
        }

        public final a a(b bVar) {
            this.cpP = bVar;
            return this;
        }

        public final f aqR() {
            return new f(this);
        }
    }
}
