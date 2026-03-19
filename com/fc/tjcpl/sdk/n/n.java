package com.fc.tjcpl.sdk.n;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.fc.tjcpl.sdk.TJActivity;
import com.fc.tjcpl.sdk.h.c;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class n implements Runnable {
    public final /* synthetic */ CustomViewContent a;

    public class a implements com.fc.tjcpl.sdk.h.j {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.fc.tjcpl.sdk.h.j
        public void a(int i, String str) {
            n.this.a.i = 0;
        }

        @Override // com.fc.tjcpl.sdk.h.j
        public void a(Object obj) {
            CustomViewContent customViewContent = n.this.a;
            customViewContent.i = 2;
            if (customViewContent.a.a() != null) {
                com.fc.tjcpl.sdk.l.d dVarA = com.fc.tjcpl.sdk.l.d.a();
                Context applicationContext = n.this.a.a.a().getApplicationContext();
                String str = "appListMd5" + n.this.a.h;
                String str2 = this.a;
                dVarA.getClass();
                SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences("TJSetting", 0).edit();
                editorEdit.putString(str, str2);
                editorEdit.commit();
            }
        }
    }

    public n(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    @Override // java.lang.Runnable
    public void run() throws UnsupportedEncodingException {
        String str;
        StringBuilder sbAppend;
        CustomViewContent customViewContent;
        HashMap<String, String> mapA = com.fc.tjcpl.sdk.b.a.a(this.a.a.a().getApplicationContext());
        String strA = com.fc.tjcpl.sdk.g.b.a(mapA.toString());
        String str2 = "";
        String strA2 = com.fc.tjcpl.sdk.l.d.a().a(this.a.a.a().getApplicationContext(), "appListMd5" + this.a.h, "");
        if (!TextUtils.isEmpty(strA2) && strA.equals(strA2)) {
            this.a.i = 2;
            com.fc.tjcpl.sdk.i.c.a("tag", "client apps has report");
            return;
        }
        StringBuilder sb = new StringBuilder();
        String string = new JSONObject(mapA).toString();
        if (TextUtils.isEmpty(this.a.a.b())) {
            StringBuilder sbAppend2 = sb.append(string).append("#");
            com.fc.tjcpl.sdk.n.a aVar = this.a.a;
            TJActivity tJActivity = aVar.a;
            if (tJActivity != null) {
                str = tJActivity.h;
            } else {
                com.fc.tjcpl.sdk.a.f fVar = aVar.b;
                str = fVar != null ? fVar.f : "";
            }
            sbAppend = sbAppend2.append(str).append("#");
            customViewContent = this.a;
        } else {
            sbAppend = sb.append(string).append("#").append(this.a.a.b()).append("#");
            customViewContent = this.a;
        }
        sbAppend.append(customViewContent.g).append("#").append("91tj_h2majstzue");
        String strA3 = com.fc.tjcpl.sdk.g.b.a(Base64.encodeToString(sb.toString().getBytes(), 2).trim());
        c.a aVar2 = new c.a();
        aVar2.c = string;
        com.fc.tjcpl.sdk.n.a aVar3 = this.a.a;
        TJActivity tJActivity2 = aVar3.a;
        if (tJActivity2 != null) {
            str2 = tJActivity2.h;
        } else {
            com.fc.tjcpl.sdk.a.f fVar2 = aVar3.b;
            if (fVar2 != null) {
                str2 = fVar2.f;
            }
        }
        aVar2.a = str2;
        aVar2.b = aVar3.b();
        aVar2.d = strA3;
        aVar2.e = this.a.g;
        com.fc.tjcpl.sdk.h.h.a().a(new com.fc.tjcpl.sdk.h.c(aVar2), new com.fc.tjcpl.sdk.h.d(), new a(strA));
    }
}
