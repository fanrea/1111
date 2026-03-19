package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.qq.e.comm.plugin.vg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class xy extends c30 {
    private final String a;

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "updateTimelineShareData";
    }

    xy(String str) {
        this.a = str;
    }

    /* compiled from: A */
    class a implements nm {
        final /* synthetic */ bm a;
        final /* synthetic */ ug b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        a(bm bmVar, ug ugVar, String str, String str2, String str3) {
            this.a = bmVar;
            this.b = ugVar;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) throws JSONException {
            Bitmap bitmapB = koVar.b();
            if (bitmapB == null) {
                bitmapB = BitmapFactory.decodeFile(koVar.d().getAbsolutePath());
            }
            xy.this.a(this.a, this.b, this.c, this.d, this.e, bitmapB);
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) throws JSONException {
            xy.this.a(this.a, this.b, this.c, this.d, this.e, null);
        }
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        a(jmVar.b(), ugVar);
    }

    private void a(bm bmVar, ug ugVar) throws JSONException {
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null) {
            return;
        }
        String strOptString = jSONObjectD.optString("title");
        mm.a().a(jSONObjectD.optString("imgUrl"), (ImageView) null, new a(bmVar, ugVar, jSONObjectD.optString("link"), strOptString, jSONObjectD.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bm bmVar, ug ugVar, String str, String str2, String str3, Bitmap bitmap) throws JSONException {
        int iA = i50.a(this.a, str, str2, str3, bitmap);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("code", Integer.valueOf(iA));
        } catch (JSONException e) {
            e.getMessage();
        }
        bmVar.a(new vg(ugVar, vg.a.OK, jSONObject));
        b10.b(1130015, null, Integer.valueOf(iA));
    }
}
