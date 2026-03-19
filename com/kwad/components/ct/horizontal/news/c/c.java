package com.kwad.components.ct.horizontal.news.c;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.horizontal.news.b.a {
    private ImageView EZ;
    private TextView Fa;
    private View aNM;
    private Drawable aNR;
    private View aOa;
    private View aOb;
    private TextView aOc;
    private TextView aOd;
    private TextView aOe;
    private final RecyclerView.OnScrollListener asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.horizontal.news.c.c.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 == 0) {
                return;
            }
            if (((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() > 0) {
                c.this.y(1.0f);
                return;
            }
            int top = c.this.aOb.getTop();
            if (top < 0) {
                float height = c.this.aOb.getHeight();
                float height2 = c.this.aNM.getHeight();
                float f = height - height2;
                if (f <= 0.0f) {
                    return;
                }
                float f2 = -top;
                if (f2 > height2 && f2 <= f) {
                    c.this.y(f2 / f);
                    return;
                } else if (f2 > f) {
                    c.this.y(1.0f);
                    return;
                }
            }
            c.this.y(0.0f);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aNM = findViewById(R.id.ksad_actionbar_container);
        this.aOa = findViewById(R.id.ksad_actionbar_author_container);
        y(0.0f);
        View viewA = com.kwad.sdk.c.a.a.a((ViewGroup) getRootView(), R.layout.ksad_news_header_auhor_info_layout, false);
        this.aOb = viewA;
        this.aOc = (TextView) viewA.findViewById(R.id.news_title);
        this.EZ = (ImageView) this.aOb.findViewById(R.id.author_icon);
        this.Fa = (TextView) this.aOb.findViewById(R.id.author_name);
        this.aOd = (TextView) this.aOb.findViewById(R.id.news_source);
        this.aOe = (TextView) this.aOb.findViewById(R.id.publish_time);
        this.aNR = getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon);
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() throws Resources.NotFoundException {
        super.ay();
        Id();
        CtAdTemplate ctAdTemplate = this.aNz.mEntryAdTemplate;
        this.aOc.setText(com.kwad.components.ct.response.a.a.aN(ctAdTemplate));
        com.kwad.sdk.glide.c.h(this.aNz.aGE).hh(com.kwad.components.ct.response.a.a.bf(ctAdTemplate)).d(this.aNR).f(this.aNR).a(new com.kwad.components.ct.widget.b.a()).b(this.EZ);
        this.Fa.setText(com.kwad.components.ct.response.a.a.aL(ctAdTemplate));
        this.aOd.setText(com.kwad.components.ct.response.a.a.aM(ctAdTemplate));
        this.aOe.setText(bq.bL(com.kwad.components.ct.response.a.a.aP(ctAdTemplate)));
        this.aNz.aFW.addHeaderView(this.aOb);
        this.aNz.Wj.addOnScrollListener(this.asg);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        this.aNz.Wj.removeOnScrollListener(this.asg);
    }

    private void Id() throws Resources.NotFoundException {
        if (com.kwad.components.core.u.e.e(this.aNz.aGE.getActivity())) {
            int statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.ksad_content_actionbar_height);
            View view = this.aOb;
            view.setPadding(view.getPaddingLeft(), statusBarHeight + dimensionPixelOffset, this.aOb.getPaddingRight(), this.aOb.getPaddingBottom());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f) {
        this.aNM.getBackground().mutate().setAlpha((int) (255.0f * f));
        this.aOa.setAlpha(f);
    }
}
