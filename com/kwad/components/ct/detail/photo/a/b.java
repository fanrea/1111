package com.kwad.components.ct.detail.photo.a;

import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements com.kwad.components.ct.f.a {
    public static void register() {
        com.kwad.components.ct.f.d.Kb().a(b.class, new b());
    }

    public final a zj() {
        if (com.kwad.components.ct.f.d.Kb().wR() == 1) {
            return zk();
        }
        com.kwad.components.ct.f.d.Kb();
        return (a) com.kwad.components.ct.f.d.b("bottomPanelStyle", zl());
    }

    public final a zk() {
        com.kwad.components.ct.f.d.Kb();
        return (a) com.kwad.components.ct.f.d.b("bottomPanelNightStyle", zm());
    }

    private static a zl() {
        a aVar = new a();
        aVar.aqv = R.drawable.ksad_photo_bottom_panel_bg;
        aVar.aqw = "#FF696D75";
        aVar.aqx = "#FFFEFFFF";
        aVar.aqy = "#FF222222";
        aVar.aqz = R.drawable.ksad_func_button_photo_share_2;
        aVar.aqA = R.drawable.ksad_func_button_media_share;
        aVar.aqB = R.drawable.ksad_func_button_photo_report_dislike;
        aVar.aqF = R.drawable.ksad_func_button_photo_author_shield;
        aVar.aqC = R.color.ksad_content_more_report_dislike_content_item_color;
        aVar.aqD = R.drawable.ksad_content_more_report_dislike_content_item_bg;
        aVar.aqE = R.drawable.ksad_func_button_photo_report_dislike_panel_close;
        return aVar;
    }

    private static a zm() {
        a aVar = new a();
        aVar.aqv = R.drawable.ksad_photo_bottom_panel_night_bg;
        aVar.aqw = "#FFFFFFFF";
        aVar.aqx = "#DD26282A";
        aVar.aqy = "#FFE6E6E6";
        aVar.aqz = R.drawable.ksad_func_button_photo_share_night;
        aVar.aqA = R.drawable.ksad_func_button_media_share_night;
        aVar.aqB = R.drawable.ksad_func_button_photo_report_dislike_night;
        aVar.aqF = R.drawable.ksad_func_button_photo_author_shield_night;
        aVar.aqC = R.color.ksad_content_more_report_dislike_content_item_color_night;
        aVar.aqD = R.drawable.ksad_content_more_report_dislike_content_item_bg_night;
        aVar.aqE = R.drawable.ksad_func_button_photo_report_dislike_panel_close_night;
        return aVar;
    }
}
