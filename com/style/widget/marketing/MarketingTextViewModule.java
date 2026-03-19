package com.style.widget.marketing;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.adrequest.j;
import com.baidu.mobads.container.util.animation.a;
import com.component.a.f.d;
import com.component.a.f.e;
import com.component.a.g.c.e;
import com.component.a.i.f;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class MarketingTextViewModule extends e {
    private com.component.a.f.e mIconInfo;
    private com.component.a.f.e mLabelInfo;

    public MarketingTextViewModule(Context context, j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        if (eVar == null || this.mAdInfo == null) {
            return null;
        }
        if ("bdmarketingtitle".equals(eVar.m("")) && checkMarketingTextInfo(eVar)) {
            return createMarketingTextView(eVar);
        }
        return super.onPrepareView(view, eVar);
    }

    private boolean checkMarketingTextInfo(com.component.a.f.e eVar) {
        List<com.component.a.f.e> listO;
        if (eVar != null && eVar.e(1) == 1 && (listO = eVar.o()) != null && !listO.isEmpty()) {
            for (com.component.a.f.e eVar2 : listO) {
                if (eVar2 != null) {
                    if ("marketing_label".equals(eVar2.m(""))) {
                        this.mLabelInfo = eVar2;
                    } else if ("marketing_icon".equals(eVar2.m(""))) {
                        this.mIconInfo = eVar2;
                    }
                }
            }
            return this.mLabelInfo != null && this.mLabelInfo.e(-1) == 1;
        }
        return false;
    }

    private RemoteMarketingTextView createMarketingTextView(com.component.a.f.e eVar) {
        RemoteMarketingTextView remoteMarketingTextView = new RemoteMarketingTextView(this.mAppContext);
        remoteMarketingTextView.setLifeCycle(new f(eVar));
        String strO = eVar.o("");
        if (TextUtils.isEmpty(strO)) {
            strO = this.mAdInfo.getTitle();
        }
        remoteMarketingTextView.setTitleContent(strO);
        remoteMarketingTextView.setMarketingLabelDesc(this.mLabelInfo.o(""));
        remoteMarketingTextView.setMarketingLabelIcon(this.mIconInfo.o(""));
        remoteMarketingTextView.applyViewTextInfo(eVar.g());
        remoteMarketingTextView.applyViewBgInfo(eVar.h());
        remoteMarketingTextView.applyLabelTextInfo(this.mLabelInfo);
        return remoteMarketingTextView;
    }

    private TextUtils.TruncateAt getEllipsize(int i) {
        if (1 == i) {
            return TextUtils.TruncateAt.START;
        }
        if (2 == i) {
            return TextUtils.TruncateAt.END;
        }
        if (3 == i) {
            return TextUtils.TruncateAt.MIDDLE;
        }
        if (4 == i) {
            return TextUtils.TruncateAt.MARQUEE;
        }
        return TextUtils.TruncateAt.END;
    }

    @Override // com.component.a.g.c.e
    public Animator initViewAnimation(View view, com.component.a.f.e eVar) {
        return super.initViewAnimation(view, eVar);
    }

    @Override // com.component.a.g.c.e
    public void buildJsonAnimator(View view, a.c cVar, com.component.a.f.e eVar, e.C0316e c0316e) {
        super.buildJsonAnimator(view, cVar, eVar, c0316e);
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(d dVar) {
        super.onCreateView(dVar);
    }

    @Override // com.component.a.g.c.e
    public void onClickView(d dVar) {
        super.onClickView(dVar);
    }

    @Override // com.component.a.g.c.e
    public void onCustomEvent(d dVar) {
        super.onCustomEvent(dVar);
    }

    @Override // com.component.a.g.c.e
    public void destroy() {
        super.destroy();
    }
}
