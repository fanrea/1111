package lkxssdk.e;

import java.util.ArrayList;
import lkxssdk.e.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class g extends Thread {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ h.c b;
    public final /* synthetic */ h c;

    public g(h hVar, ArrayList arrayList, h.c cVar) {
        this.c = hVar;
        this.a = arrayList;
        this.b = cVar;
    }

    public static void a(h.c cVar, ArrayList arrayList, ArrayList arrayList2) throws JSONException {
        r rVar = (r) cVar;
        rVar.getClass();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("thumb", arrayList.get(i));
                jSONObject2.put("videoPath", arrayList2.get(i));
                jSONArray.put(jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("videoArr", jSONArray);
        lkxssdk.k.a<String> aVar = rVar.a.b;
        if (aVar != null) {
            aVar.b(jSONObject.toString());
        }
        i.b().getClass();
        i.a = null;
        rVar.a.a.g();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:5|(4:73|6|(1:10)|11)|(3:13|79|14)(3:77|22|26)|27|(3:29|(1:31)(1:32)|33)(2:35|(3:37|(1:39)(1:40)|41)(14:42|43|(1:45)|46|(1:48)|49|(1:51)|81|52|56|(1:58)(1:59)|60|(3:85|62|88)(3:84|63|87)|86))|34|43|(0)|46|(0)|49|(0)|81|52|56|(0)(0)|60|(0)(0)|86|3) */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0152, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0153, code lost:
    
        r4.printStackTrace();
        r4 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0179 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.e.g.run():void");
    }
}
