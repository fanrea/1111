package com.component.a.e.c;

import com.component.a.e.e.c;
import com.component.a.f.e;
import com.component.a.i.n;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends c {
    private String a = "{\"background\":{\"alpha\":0.06}}";
    private String b = "{\"id\":\"33_1_close_view#1\",\"type\":\"image\",\"w\":20,\"h\":15,\"click\":\"dislike\",\"src\":\"@res/opt_black_dislike\",\"gravity\":\"8\",\"margins\":[0,1,1,1],\"background\":{}}";
    private String c = "{\"id\":\"33_2_close_view#2\",\"type\":\"image\",\"w\":20,\"h\":15,\"click\":\"dislike\",\"src\":\"@res/opt_black_dislike\",\"gravity\":8,\"background\":{},\"margins\":[0,0,0,0]}";
    private String d = "{\"id\":\"33_2_btn#3\",\"margins\":[0,0,23,0],\"type\":\"button\",\"w\":75,\"h\":30,\"src\":\"查看详情\",\"gravity\":40,\"click\":\"creative_click\",\"background\":{\"shape\":\"round_rect\",\"color\":\"#4E6EF2\",\"radius\":[15,15,15,15,15,15,15,15]},\"text\":{\"size\":13,\"color\":\"#FFFFFF\",\"style\":0},\"button\":{\"custom\":\"cta\",\"progress_color\":\"#D7E6FF\",\"style\":1},\"anim\":\"\"}";
    private String e;
    private int f;

    public b(String str, int i) {
        this.e = str;
        this.f = i;
    }

    @Override // com.component.a.e.e.c, com.component.a.g.g.a
    public JSONObject a() {
        JSONObject jSONObjectB = n.b(a(this.e, this.f));
        if (com.baidu.mobads.container.n.a.a.equals(this.e) || (com.baidu.mobads.container.n.a.b.equals(this.e) && this.f == 33)) {
            return a(jSONObjectB);
        }
        return jSONObjectB;
    }

    public String a(String str, int i) {
        a aVar = new a();
        if (com.baidu.mobads.container.n.a.b.equals(str)) {
            switch (i) {
                case 33:
                    return a(33, 1);
                case 41:
                    return a(41, 1);
                default:
                    return a(28, 2);
            }
        }
        if (com.baidu.mobads.container.n.a.a.equals(str)) {
            return a(33, 2);
        }
        if (com.baidu.mobads.container.n.a.c.equals(str)) {
            return aVar.a();
        }
        if (!com.baidu.mobads.container.n.a.d.equals(str)) {
            return "";
        }
        return aVar.b();
    }

    public JSONObject a(JSONObject jSONObject) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        try {
            Map<String, e> mapC = n.c(jSONObject);
            for (String str : mapC.keySet()) {
                if ("opt_style_33_2".equals(str) && (eVar4 = mapC.get(str)) != null) {
                    n.a(eVar4.f(), new JSONObject(this.a));
                }
                if ("33_2_close_view#2".equals(str) && (eVar3 = mapC.get(str)) != null) {
                    n.a(eVar3.f(), new JSONObject(this.c));
                }
                if ("33_2_btn#3".equals(str) && (eVar2 = mapC.get(str)) != null) {
                    n.a(eVar2.f(), new JSONObject(this.d));
                }
                if ("33_1_close_view#1".equals(str) && (eVar = mapC.get(str)) != null) {
                    n.a(eVar.f(), new JSONObject(this.b));
                }
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
