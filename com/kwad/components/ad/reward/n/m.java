package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends d implements View.OnClickListener {
    private ViewGroup EG;
    private View EH;
    private TextView EI;
    private TextView EJ;
    private TextView EK;
    private View EL;
    private DialogFragment Ep;
    private View Es;
    private ImageView jY;
    private TextView mf;
    private h.a uB;

    public m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.Ep = dialogFragment;
        this.uB = aVar;
        if (com.kwad.sdk.core.response.b.a.df(com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
            this.EG = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            t(true);
        } else {
            this.EG = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
            t(false);
        }
    }

    private void t(boolean z) {
        this.EH = this.EG.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.mf = (TextView) this.EG.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.jY = (ImageView) this.EG.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.EJ = (TextView) this.EG.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.EI = (TextView) this.EG.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.Es = this.EG.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.EL = this.EG.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.EK = (TextView) this.EG.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z) {
            this.EH.setVisibility(8);
        }
        this.EH.setOnClickListener(this);
        this.Es.setOnClickListener(this);
        this.EL.setOnClickListener(this);
        this.EK.setOnClickListener(this);
    }

    public final void a(h.c cVar) throws Resources.NotFoundException {
        KSImageLoader.loadCircleIcon(this.jY, cVar.hs(), this.EG.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.mf != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = hT().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.mf.setText(spannableString);
        }
        this.EI.setText(cVar.ht());
        this.EJ.setText(cVar.hu());
        this.EK.setText(String.format("%s", cVar.uK));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup hT() {
        return this.EG;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.EH)) {
            this.Ep.dismiss();
            h.a aVar2 = this.uB;
            if (aVar2 != null) {
                aVar2.hn();
                return;
            }
            return;
        }
        if (view.equals(this.Es)) {
            this.Ep.dismiss();
            h.a aVar3 = this.uB;
            if (aVar3 != null) {
                aVar3.hn();
                return;
            }
            return;
        }
        if (view.equals(this.EL)) {
            this.Ep.dismiss();
            h.a aVar4 = this.uB;
            if (aVar4 != null) {
                aVar4.G(false);
                return;
            }
            return;
        }
        if (!view.equals(this.EK) || (aVar = this.uB) == null) {
            return;
        }
        aVar.i(131, 2);
    }
}
