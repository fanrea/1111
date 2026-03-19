package com.bytedance.sdk.djx.core.business.widgetprovider;

import com.bytedance.sdk.djx.IDJXWidget;
import com.bytedance.sdk.djx.core.business.budrama.history.DJXDramaHistoryFragment;
import com.bytedance.sdk.djx.core.business.widgetprovider.interfaces.WidgetProvider;
import com.bytedance.sdk.djx.params.DJXWidgetDramaHistoryParam;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class UserProfilePageProvider implements WidgetProvider<DJXWidgetDramaHistoryParam> {
    @Override // com.bytedance.sdk.djx.core.business.widgetprovider.interfaces.WidgetProvider
    public IDJXWidget get(DJXWidgetDramaHistoryParam dJXWidgetDramaHistoryParam) {
        if (Objects.requireNonNull(dJXWidgetDramaHistoryParam.mPageType) == DJXWidgetDramaHistoryParam.PageType.USER_DRAMA_HISTORY_PAGE) {
            DJXDramaHistoryFragment dJXDramaHistoryFragment = new DJXDramaHistoryFragment();
            dJXDramaHistoryFragment.setParam(dJXWidgetDramaHistoryParam, null);
            return dJXDramaHistoryFragment;
        }
        throw new IllegalArgumentException("not valid page type");
    }
}
