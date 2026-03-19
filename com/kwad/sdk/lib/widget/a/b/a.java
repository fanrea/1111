package com.kwad.sdk.lib.widget.a.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.b.c;
import com.kwad.sdk.lib.widget.a.b.a.C0623a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a<MODEL, CallerContext extends C0623a<MODEL>> extends RecyclerView.ViewHolder {
    public final CallerContext cdK;
    public final Presenter mPresenter;

    /* renamed from: com.kwad.sdk.lib.widget.a.b.a$a, reason: collision with other inner class name */
    public static class C0623a<MODEL> {
        public RecyclerView Wj;
        public KsFragment alG;
        public c<?, MODEL> avY;
        public View cdL;
        public MODEL cdM;
        public int mCurrentPosition;
    }

    public a(View view, Presenter presenter, CallerContext callercontext) {
        super(view);
        this.cdK = callercontext;
        callercontext.cdL = view;
        this.mPresenter = presenter;
        presenter.ak(view);
    }
}
