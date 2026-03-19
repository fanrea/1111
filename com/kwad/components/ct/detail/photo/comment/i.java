package com.kwad.components.ct.detail.photo.comment;

import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class i implements com.kwad.components.ct.f.a {
    public static void register() {
        com.kwad.components.ct.f.d.Kb().a(i.class, new i());
    }

    public final h zV() {
        if (com.kwad.components.ct.f.d.Kb().wR() == 1) {
            com.kwad.components.ct.f.d.Kb();
            return (h) com.kwad.components.ct.f.d.b("commentPanelNightStyle", zX());
        }
        com.kwad.components.ct.f.d.Kb();
        return (h) com.kwad.components.ct.f.d.b("commentPanelStyle", zW());
    }

    private static h zW() {
        h hVar = new h();
        hVar.aqv = R.drawable.ksad_photo_bottom_panel_bg;
        hVar.aqy = "#FF151924";
        hVar.asm = "#FF888B91";
        hVar.asn = "#FF131924";
        hVar.aso = "#FF131924";
        hVar.asp = "#FF9C9C9C";
        hVar.asq = R.drawable.ksad_comment_bottom_ad_bg;
        hVar.asr = "#FFFFFFFF";
        hVar.ass = R.drawable.ksad_photo_comment_ad_item_link_img;
        hVar.ast = "#FF18407D";
        hVar.asu = R.drawable.ksad_photo_comment_list_panel_close_btn_normal;
        hVar.asv = "#FFC6C6C6";
        hVar.asw = R.drawable.ksad_comment_bottom_ad_panel_close_img;
        return hVar;
    }

    private static h zX() {
        h hVar = new h();
        hVar.aqv = R.drawable.ksad_photo_bottom_panel_night_bg;
        hVar.aqy = "#FFE6E6E6";
        hVar.asm = "#FF888B91";
        hVar.asn = "#FFE6E6E6";
        hVar.aso = "#FFE6E6E6";
        hVar.asp = "#FF9C9C9C";
        hVar.asq = R.drawable.ksad_comment_bottom_ad_night_bg;
        hVar.asr = "#FF000000";
        hVar.ass = R.drawable.ksad_photo_comment_ad_item_link_img_night;
        hVar.ast = "#FF6EAFCC";
        hVar.asu = R.drawable.ksad_photo_comment_list_panel_close_btn_night;
        hVar.asv = "#FF4C4C4C";
        hVar.asw = R.drawable.ksad_comment_bottom_ad_panel_close_img_night;
        return hVar;
    }
}
