package com.bytedance.sdk.djx.core.business.base;

import com.bytedance.sdk.djx.core.business.base.BaseContract;
import com.bytedance.sdk.djx.core.business.base.BaseContract.BasePresenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class FragMvpProxy<P extends BaseContract.BasePresenter> extends FragProxy implements BaseContract.BaseView {
    protected P mPresenter;

    protected abstract P bindPresenter();

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy
    protected void processLogic() {
        P p = (P) bindPresenter();
        this.mPresenter = p;
        p.attach(this);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.FragProxy, com.bytedance.sdk.djx.core.base.FLifeProxy
    public void onDetach() {
        super.onDetach();
        P p = this.mPresenter;
        if (p != null) {
            p.detach();
        }
    }
}
