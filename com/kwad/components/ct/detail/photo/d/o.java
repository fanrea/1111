package com.kwad.components.ct.detail.photo.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.widget.FlowLayout;
import com.kwad.components.ct.response.model.home.ReportInfo;
import com.kwad.sdk.R;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o extends FlowLayout.a<a> {
    private List<ReportInfo> atF;
    private int atG = -1;
    private Context mContext;

    public o(Context context, List<ReportInfo> list) {
        this.mContext = context;
        this.atF = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.widget.FlowLayout.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public a m(ViewGroup viewGroup) {
        TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_content_more_report_dislike_item_layout, viewGroup, false);
        com.kwad.components.ct.detail.photo.a.a aVarZj = ((com.kwad.components.ct.detail.photo.a.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.detail.photo.a.b.class)).zj();
        com.kwad.components.ct.f.g.r(textView, aVarZj.aqD);
        com.kwad.components.ct.f.g.a(textView, aVarZj.aqC);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(textView.getLayoutParams());
        marginLayoutParams.setMargins(com.kwad.sdk.c.a.a.a(this.mContext, 16.0f), com.kwad.sdk.c.a.a.a(this.mContext, 4.0f), com.kwad.sdk.c.a.a.a(this.mContext, 4.0f), com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
        textView.setLayoutParams(marginLayoutParams);
        return new a(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ct.detail.photo.widget.FlowLayout.a
    public void a(a aVar, final int i) {
        aVar.atI.setText(this.atF.get(i).content);
        aVar.atI.setSelected(this.atG == i);
        aVar.atI.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.d.o.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = o.this.atG;
                int i3 = i;
                if (i2 == i3) {
                    o.this.atG = -1;
                } else {
                    o.this.atG = i3;
                }
                o.this.BS();
            }
        });
    }

    @Override // com.kwad.components.ct.detail.photo.widget.FlowLayout.a
    public final int getItemCount() {
        return this.atF.size();
    }

    public final ReportInfo An() {
        List<ReportInfo> list;
        if (this.atG < 0 || (list = this.atF) == null || list.isEmpty()) {
            return null;
        }
        int size = this.atF.size();
        int i = this.atG;
        if (size > i) {
            return this.atF.get(i);
        }
        return null;
    }

    public class a extends FlowLayout.b {
        TextView atI;

        public a(View view) {
            super(view);
            this.atI = (TextView) view.findViewById(R.id.ksad_content_more_report_dislike_content_item);
        }
    }
}
