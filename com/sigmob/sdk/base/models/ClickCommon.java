package com.sigmob.sdk.base.models;

import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.a;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ClickCommon implements Serializable {
    public static final String AIM = "aim";
    public static final String CLICK_AREA_APPINFO = "appinfo";
    public static final String CLICK_AREA_BTN = "btn";
    public static final String CLICK_AREA_COMPANION = "companion";
    public static final String CLICK_AREA_COMPONENT = "component";
    public static final String CLICK_AREA_MATERIAL = "material";
    public static final String CLICK_CB_STATE = "click_cb_state";
    public static final String CLICK_LOSE_RATE = "click_lose_rate";
    public static final String CLICK_SCENE_AD = "ad";
    public static final String CLICK_SCENE_APPINFO = "appinfo";
    public static final String CLICK_SCENE_ENDCARD = "endcard";
    public static final String CLICK_SCENE_PREVIEW = "preview";
    public static final String CLICK_SCENE_TEMPLATE = "template";
    public static final String CPT_RENDER_TYPE = "cpt_render_type";
    public String adarea_h;
    public String adarea_w;
    public String adarea_x;
    public String adarea_y;
    public Integer aim;
    public String clickCoordinate;
    public a clickUIType;
    public String clickUrl;
    public String click_area;
    public String click_scene;
    public Integer cpt_render_type;
    public TouchLocation down;
    public String isDeeplink;
    public boolean is_final_click;
    public String template_id;
    public String turn_time;
    public String turn_x;
    public String turn_y;
    public String turn_z;
    public TouchLocation up;
    public int widget_id;
    public String x_max_acc;
    public String y_max_acc;
    public String z_max_acc;
    public String sld = "0";
    public Integer click_lose_rate = 0;
    public Integer click_cb_state = 0;

    public String getClickCoordinate() {
        TouchLocation touchLocation = this.down;
        if (touchLocation != null && this.up != null) {
            this.clickCoordinate = String.format("%s,%s,%s,%s", Integer.valueOf(touchLocation.getX()), Integer.valueOf(this.down.getY()), Integer.valueOf(this.up.getX()), Integer.valueOf(this.up.getY()));
        }
        return this.clickCoordinate;
    }
}
