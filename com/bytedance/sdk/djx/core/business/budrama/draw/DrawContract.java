package com.bytedance.sdk.djx.core.business.budrama.draw;

import com.bytedance.sdk.djx.core.business.base.BaseContract;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
interface DrawContract {

    public interface Presenter extends BaseContract.BasePresenter<View> {
        void loadMore(boolean z);

        void loadRefresh(boolean z);
    }

    public interface View extends BaseContract.BaseView {
        int getAdapterCount();

        int getAdapterCount2();

        Object getAdapterItem(int i);

        void onLoadRefresh(int i, boolean z, boolean z2, List list);

        void setLoadMoreEnable(boolean z);

        void setLoading(boolean z);

        void setRefreshing(boolean z);

        void setRefreshingEnable(boolean z);
    }
}
