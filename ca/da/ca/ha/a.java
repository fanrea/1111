package ca.da.ca.ha;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NewUserModeManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static volatile a f;
    public volatile boolean a = false;
    public volatile boolean b = false;
    public ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();
    public WeakReference<Context> d;
    public volatile String e;

    public a(Context context) {
        String userData;
        this.d = new WeakReference<>(context);
        if (a()) {
            String strSubstring = "";
            String string = this.d.get().getSharedPreferences("debug_new_user_mode_sp", 0).getString("new_user_mode_json_str", "");
            if (TextUtils.isEmpty(string)) {
                Context context2 = this.d.get();
                try {
                    userData = AccountManager.get(context2).getUserData(b.a(context2), "new_user_mode_account");
                } catch (Throwable th) {
                    th.printStackTrace();
                    userData = "";
                }
                if (userData != null && userData.startsWith("newUserModeUtil:")) {
                    strSubstring = userData.substring(16);
                }
            } else {
                strSubstring = string;
            }
            try {
                a(strSubstring);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SharedPreferences.Editor editorEdit = this.d.get().getSharedPreferences("debug_new_user_mode_sp", 0).edit();
            editorEdit.putString("new_user_mode_json_str", strSubstring);
            editorEdit.apply();
        }
    }

    public static a a(Context context) {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a(context);
                }
            }
        }
        return f;
    }

    public final boolean a() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = "local_test";
        }
        return "local_test".equals(this.e);
    }

    public final void a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.a = jSONObject.optBoolean("is_new_user_mode", false);
        this.b = jSONObject.optBoolean("auto_mode", false);
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("debug_custom_param", ""));
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.c.put(next, jSONObject2.optString(next));
        }
    }
}
