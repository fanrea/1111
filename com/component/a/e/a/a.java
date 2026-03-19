package com.component.a.e.a;

import com.baidu.mobads.annotation.remote.template.FeedNativeJson;
import com.component.a.g.g;
import com.component.a.i.n;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a implements g.a {
    private final FeedNativeJson a = new FeedNativeJson();

    @Override // com.component.a.g.g.a
    public String a(String str) {
        if ("feed_native_template".equals(str)) {
            return this.a.getTemplateJson();
        }
        if ("opt_style_41_1".equals(str)) {
            return this.a.getBookmarkJson();
        }
        return "";
    }

    @Override // com.component.a.g.g.a
    public JSONObject a() {
        return n.b(this.a.getTemplateJson());
    }
}
