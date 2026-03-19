package com.kwad.sdk.api.tube.log;

import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@KsAdSdkApi
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public @interface KSTubeActonType {
    public static final int history_page_impression = 4;
    public static final int history_page_tube_item_click = 6;
    public static final int history_page_tube_item_impression = 5;
    public static final int recommend_page_impression = 1;
    public static final int recommend_page_tube_item_click = 3;
    public static final int recommend_page_tube_item_impression = 2;
}
