package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ae {
    public static String dr(Context context) {
        String tips = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getTips(com.baidu.mobads.container.util.animation.j.g);
        return (!TextUtils.isEmpty(tips) || context == null) ? tips : context.getString(R.string.ksad_default_no_more_tip_or_toast_txt);
    }

    public static String ds(Context context) {
        String tips = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getTips("toast");
        return (!TextUtils.isEmpty(tips) || context == null) ? tips : context.getString(R.string.ksad_default_no_more_tip_or_toast_txt);
    }

    public static String dt(Context context) {
        return context.getString(R.string.ksad_page_load_no_more_tip);
    }

    public static String du(Context context) {
        return context.getString(R.string.ksad_network_error_toast);
    }

    public static String dv(Context context) {
        return context.getString(R.string.ksad_page_loading_network_error_title);
    }

    public static String dw(Context context) {
        return context.getString(R.string.ksad_page_loading_network_error_sub_title);
    }

    public static String dx(Context context) {
        return context.getString(R.string.ksad_data_error_toast);
    }

    public static String dy(Context context) {
        return context.getString(R.string.ksad_page_loading_data_error_title);
    }

    public static String dz(Context context) {
        return context.getString(R.string.ksad_page_loading_data_error_sub_title);
    }

    public static String dA(Context context) {
        return context.getString(R.string.ksad_page_loading_error_retry);
    }

    public static String dB(Context context) {
        return context.getString(R.string.ksad_half_page_loading_error_tip);
    }
}
