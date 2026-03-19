package com.bytedance.sdk.djx.core.business.widgetprovider.interfaces;

import com.bytedance.sdk.djx.IDJXWidget;
import com.bytedance.sdk.djx.params.DJXWidgetParam;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface WidgetProvider<Param extends DJXWidgetParam> {
    IDJXWidget get(Param param);
}
