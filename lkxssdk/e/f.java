package lkxssdk.e;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collection;
import lkxssdk.e.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class f extends Thread {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ h.a b;
    public final /* synthetic */ h c;

    public f(h hVar, ArrayList arrayList, h.a aVar) {
        this.c = hVar;
        this.a = arrayList;
        this.b = aVar;
    }

    public static void a(h.a aVar, ArrayList arrayList, ArrayList arrayList2) throws JSONException {
        q qVar = (q) aVar;
        qVar.getClass();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("picArr", new JSONArray((Collection) arrayList));
            String json = new Gson().toJson(arrayList2);
            lkxssdk.h0.c.b("date info", json);
            jSONObject.put("infoArr", new JSONArray(json));
            if (qVar.a.b != null) {
                lkxssdk.h0.c.a.getClass();
                TextUtils.isEmpty("LKLog");
                qVar.a.b.b(jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        i.b().getClass();
        i.a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3 A[Catch: Exception -> 0x00e9, TRY_LEAVE, TryCatch #1 {Exception -> 0x00e9, blocks: (B:11:0x003c, B:14:0x0051, B:15:0x0056, B:17:0x005c, B:18:0x0062, B:20:0x0073, B:23:0x007f, B:24:0x0086, B:28:0x009b, B:39:0x00e3, B:22:0x007b, B:25:0x008b, B:27:0x008f, B:29:0x00a8, B:37:0x00dd, B:30:0x00b3, B:32:0x00c6, B:34:0x00cb, B:33:0x00c9), top: B:57:0x003c, inners: #0 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.e.f.run():void");
    }

    public static void a(h.a aVar) {
        ((q) aVar).getClass();
    }
}
