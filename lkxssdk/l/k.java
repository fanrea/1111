package lkxssdk.l;

import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class k {
    public int[] a;
    public lkxssdk.k.a<String> b;
    public boolean c;
    public boolean d;
    public BaseActivity e;

    public k(BaseActivity baseActivity) {
        this.e = baseActivity;
    }

    public final void a() {
        String str;
        ArrayList arrayList = new ArrayList();
        for (int i : this.a) {
            if (i == 1) {
                str = "android.permission.READ_PHONE_STATE";
            } else if (i == 2) {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                str = "android.permission.READ_EXTERNAL_STORAGE";
            }
            arrayList.add(str);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (this.a[0] != 3) {
            this.d = true;
            lkxssdk.j0.d.a(this.e, strArr, new a());
            return;
        }
        if (NotificationManagerCompat.from(this.e.getApplicationContext()).areNotificationsEnabled()) {
            this.b.b("{\"result\":1}");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", 3);
            jSONObject2.put("status", -2);
            jSONArray.put(jSONObject2);
            jSONObject.put("result", 0);
            jSONObject.put("data", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.b.b(jSONObject.toString());
    }

    public class a implements lkxssdk.j0.a {
        public a() {
        }

        @Override // lkxssdk.j0.a
        public void a(List<String> list, boolean z) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                int[] iArr = k.this.a;
                int length = iArr.length;
                for (int i = 0; i < length; i++) {
                    int i2 = iArr[i];
                    String str = i2 == 1 ? "android.permission.READ_PHONE_STATE" : i2 == 2 ? "android.permission.WRITE_EXTERNAL_STORAGE" : "";
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (next.equals(str)) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("type", i2);
                                if (Build.VERSION.SDK_INT >= 23) {
                                    if (k.this.e.shouldShowRequestPermissionRationale(next)) {
                                        jSONObject2.put("status", -1);
                                    } else {
                                        jSONObject2.put("status", -2);
                                    }
                                }
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                }
                jSONObject.put("result", 0);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            lkxssdk.h0.c.b(jSONObject.toString());
            k.this.b.b(jSONObject.toString());
        }

        @Override // lkxssdk.j0.a
        public void a() {
            k.this.b.b("{\"result\":1}");
        }
    }
}
