package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.provider.FontsContractCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.d.d;
import com.ss.android.socialbase.downloader.k.gb;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc {
    private static d b = null;
    private static final String d = "hc";
    private static b hc;

    public interface b {
        void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.appdownloader.d dVar);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.hc$hc, reason: collision with other inner class name */
    interface InterfaceC0766hc {
        boolean d(Context context);
    }

    public static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar, Intent intent, boolean z) {
        JSONArray jSONArrayU = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).u("ah_plans");
        if (jSONArrayU == null) {
            return false;
        }
        int length = jSONArrayU.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayU.optJSONObject(i);
            if (com.ss.android.socialbase.appdownloader.an.d.d(jSONObjectOptJSONObject) && d(context, bVar, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0174 A[PHI: r15
  0x0174: PHI (r15v13 com.ss.android.socialbase.appdownloader.d) = 
  (r15v2 com.ss.android.socialbase.appdownloader.d)
  (r15v8 com.ss.android.socialbase.appdownloader.d)
  (r15v14 com.ss.android.socialbase.appdownloader.d)
 binds: [B:98:0x0172, B:88:0x014a, B:60:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean d(android.content.Context r11, com.ss.android.socialbase.downloader.h.b r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) throws java.lang.IllegalAccessException, org.json.JSONException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.hc.d(android.content.Context, com.ss.android.socialbase.downloader.h.b, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    private static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.d dVar, com.ss.android.socialbase.downloader.uo.d dVar2) {
        boolean zHc;
        String strOptString = jSONObject.optString("type");
        dVar.d = strOptString;
        Intent intentHc = com.ss.android.socialbase.appdownloader.d.c.d(context, "vbi", jSONObject, bVar).hc();
        StringBuilder sb = new StringBuilder();
        try {
            zHc = hc(context, intentHc);
        } catch (Throwable th) {
            sb.append(strOptString).append(" startActivity failed : ").append(d(th));
            d(dVar, 1);
            zHc = false;
        }
        if (!zHc) {
            dVar.b = sb.toString();
        } else {
            dVar.hc = 0;
        }
        return true;
    }

    private static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.d dVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            dVar.u = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String strMk = bVar.mk();
                if (TextUtils.isEmpty(strMk)) {
                    return false;
                }
                File file = new File(strMk);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    String str2 = strArrSplit[i];
                    com.ss.android.socialbase.appdownloader.d.d dVarD = com.ss.android.socialbase.appdownloader.d.c.d(context, str2, jSONObject, bVar);
                    if (dVarD != null) {
                        Intent intentHc = dVarD.hc();
                        if (intentHc != null) {
                            if (d(file, bVar, jSONObject)) {
                                try {
                                    d(context, intentHc, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2).append(" startActivity failed : ").append(d(th));
                                    d(dVar, 1);
                                }
                            } else {
                                d(dVar, 6);
                                sb.append(str2).append(" createDescFile failed! ");
                            }
                        } else {
                            d(dVar, 3);
                            sb.append(str2).append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    dVar.b = sb.toString();
                } else {
                    dVar.c = str;
                    dVar.hc = 0;
                }
                return z;
            }
        }
        return false;
    }

    private static boolean hc(Context context, com.ss.android.socialbase.downloader.h.b bVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.d dVar) {
        if (context != null && jSONObject != null) {
            String strMk = bVar.mk();
            if (TextUtils.isEmpty(strMk)) {
                return false;
            }
            dVar.c = SchedulerSupport.CUSTOM;
            com.ss.android.socialbase.appdownloader.d.d dVarD = com.ss.android.socialbase.appdownloader.d.c.d(context, SchedulerSupport.CUSTOM, jSONObject, bVar);
            if (dVarD == null || !dVarD.d()) {
                dVar.hc = 3;
            } else {
                Intent intentHc = dVarD.hc();
                if (intentHc == null) {
                    return false;
                }
                if (d(new File(strMk), bVar, jSONObject)) {
                    if (hc(context, intentHc)) {
                        dVar.hc = 0;
                        return true;
                    }
                    dVar.hc = 1;
                } else {
                    dVar.hc = 6;
                }
                return false;
            }
        }
        return false;
    }

    public static int d(com.ss.android.socialbase.downloader.uo.d dVar) {
        int i;
        if (!(dVar.c("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.uo.d.b().d("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayU = dVar.u("ah_plans");
        int i2 = -1;
        if (jSONArrayU != null) {
            int length = jSONArrayU.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayU.optJSONObject(i3);
                if (com.ss.android.socialbase.appdownloader.an.d.d(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if ("plan_a".equals(strOptString) || "plan_b".equals(strOptString) || "plan_e".equals(strOptString) || "plan_f".equals(strOptString)) {
                        com.ss.android.socialbase.appdownloader.d dVarD = d(jSONObjectOptJSONObject, dVar);
                        i = dVarD.hc;
                        if (dVarD.hc == 0) {
                            return 0;
                        }
                    } else {
                        if (!"plan_d".equalsIgnoreCase(strOptString) && !"plan_h".equalsIgnoreCase(strOptString)) {
                            if ("plan_g".equalsIgnoreCase(strOptString)) {
                                com.ss.android.socialbase.appdownloader.d dVarHc = hc(jSONObjectOptJSONObject, dVar);
                                i = dVarHc.hc;
                                if (dVarHc.hc == 0) {
                                }
                            } else {
                                continue;
                            }
                        }
                        return 0;
                    }
                    i2 = i;
                }
            }
        }
        return i2;
    }

    public static com.ss.android.socialbase.appdownloader.d d(JSONObject jSONObject, com.ss.android.socialbase.downloader.uo.d dVar) {
        com.ss.android.socialbase.appdownloader.d dVar2 = new com.ss.android.socialbase.appdownloader.d();
        if (jSONObject == null) {
            return dVar2;
        }
        String strOptString = jSONObject.optString("type");
        dVar2.d = strOptString;
        if ("plan_b".equals(strOptString)) {
            dVar2.u = SchedulerSupport.CUSTOM;
            if (com.ss.android.socialbase.appdownloader.d.c.d(com.ss.android.socialbase.downloader.downloader.b.tr(), SchedulerSupport.CUSTOM, jSONObject, dVar)) {
                dVar2.hc = 0;
                return dVar2;
            }
            d(dVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            dVar2.u = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.d.c.d(com.ss.android.socialbase.downloader.downloader.b.tr(), str, jSONObject, dVar)) {
                        dVar2.hc = 0;
                        return dVar2;
                    }
                    d(dVar2, 3);
                }
            }
        }
        return dVar2;
    }

    public static com.ss.android.socialbase.appdownloader.d hc(JSONObject jSONObject, com.ss.android.socialbase.downloader.uo.d dVar) {
        com.ss.android.socialbase.appdownloader.d dVar2 = new com.ss.android.socialbase.appdownloader.d();
        if (jSONObject == null) {
            return dVar2;
        }
        dVar2.d = jSONObject.optString("type");
        dVar2.u = "vbi";
        if (com.ss.android.socialbase.appdownloader.d.c.d(com.ss.android.socialbase.downloader.downloader.b.tr(), "vbi", jSONObject, dVar)) {
            dVar2.hc = 0;
        } else {
            d(dVar2, 3);
        }
        return dVar2;
    }

    public static com.ss.android.socialbase.appdownloader.d d(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.uo.d dVar) {
        com.ss.android.socialbase.appdownloader.d dVar2 = new com.ss.android.socialbase.appdownloader.d();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.an.u.b()) {
            dVar2.d = jSONObject.optString("type");
            if (dVar.d("bi", 0) == 1) {
                dVar2.hc = 0;
                return dVar2;
            }
            if (d(context)) {
                dVar2.hc = 2;
            } else if (com.ss.android.socialbase.appdownloader.an.d.d(str) != null) {
                dVar2.hc = 0;
            } else {
                dVar2.hc = 9;
            }
        }
        return dVar2;
    }

    private static void d(com.ss.android.socialbase.appdownloader.d dVar, int i) {
        if (dVar.hc != -1) {
            dVar.hc = (dVar.hc * 10) + i;
        } else {
            dVar.hc = i;
        }
    }

    private static boolean d(File file, com.ss.android.socialbase.downloader.h.b bVar, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectC = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).c("download_dir");
        File file2 = null;
        String strOptString = jSONObjectC != null ? jSONObjectC.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(path + File.separator + strOptString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean d(Context context, Intent intent, JSONObject jSONObject, int i, com.ss.android.socialbase.appdownloader.d dVar) throws JSONException {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferencesHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferencesHc.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !d(context)) {
                sharedPreferencesHc.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (d(context, intent2, false)) {
                            c(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (dVar != null) {
                            dVar.hc = 1;
                            dVar.b = "tryShowUnknownSourceDialog" + d(th);
                        }
                        return false;
                    }
                }
                if (d(context, intent, i, jSONObject)) {
                    b(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean d(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.an.u.b() && Build.VERSION.SDK_INT < 26 && !c(context)) {
                com.ss.android.socialbase.appdownloader.d.an anVar = new com.ss.android.socialbase.appdownloader.d.an(context);
                if (anVar.d()) {
                    d(context, intent, i, jSONObject, new InterfaceC0766hc() { // from class: com.ss.android.socialbase.appdownloader.hc.1
                        @Override // com.ss.android.socialbase.appdownloader.hc.InterfaceC0766hc
                        public boolean d(Context context2) {
                            return hc.c(context2);
                        }
                    });
                    return hc(context, anVar.hc());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !u(context)) {
                com.ss.android.socialbase.appdownloader.d.hc hcVar = new com.ss.android.socialbase.appdownloader.d.hc(context);
                if (hcVar.d()) {
                    d(context, intent, i, jSONObject, new InterfaceC0766hc() { // from class: com.ss.android.socialbase.appdownloader.hc.2
                        @Override // com.ss.android.socialbase.appdownloader.hc.InterfaceC0766hc
                        public boolean d(Context context2) {
                            return hc.u(context2);
                        }
                    });
                    return hc(context, hcVar.hc());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.an.u.b() && Build.VERSION.SDK_INT < 26) {
            return c(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return u(context);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean u(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean d() {
        return u.d == 1;
    }

    private static void c(int i, JSONObject jSONObject) throws JSONException {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.socialbase.downloader.downloader.b.y().hc(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void d(int i, JSONObject jSONObject) throws JSONException {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.socialbase.downloader.downloader.b.y().hc(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void hc(int i, JSONObject jSONObject) throws JSONException {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.socialbase.downloader.downloader.b.y().hc(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void b(int i, JSONObject jSONObject) throws JSONException {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.socialbase.downloader.downloader.b.y().hc(i, "guide_auth_open_setting", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(int i, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.socialbase.downloader.downloader.b.y().hc(i, "guide_auth_result", jSONObject);
    }

    private static void d(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0766hc interfaceC0766hc) {
        if (b != null) {
            com.ss.android.socialbase.downloader.d.d.d().hc(b);
            b = null;
        }
        b = new d(context, intent, i, jSONObject, interfaceC0766hc);
        com.ss.android.socialbase.downloader.d.d.d().d(b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hc(Context context, Intent intent) {
        return d(context, intent, true);
    }

    public static boolean d(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String d(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    private static class c implements Callable<Boolean> {
        private final Handler b;
        private final long c;
        private final Context d;
        private final InterfaceC0766hc hc;

        public c(Handler handler, Context context, InterfaceC0766hc interfaceC0766hc, long j) {
            this.d = context;
            this.hc = interfaceC0766hc;
            this.b = handler;
            this.c = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0766hc interfaceC0766hc;
            try {
                interfaceC0766hc = this.hc;
            } catch (Throwable unused) {
            }
            if (interfaceC0766hc != null) {
                long j = this.c;
                if (j > 0 && j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    Context context = this.d;
                    boolean zD = context != null ? interfaceC0766hc.d(context) : false;
                    Message messageObtain = Message.obtain();
                    if (zD) {
                        messageObtain.what = 2;
                        this.b.sendMessage(messageObtain);
                    } else {
                        messageObtain.what = 1;
                        this.b.sendMessageDelayed(messageObtain, this.c);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    public static void d(b bVar) {
        hc = bVar;
    }

    private static class d implements d.InterfaceC0785d {
        private JSONObject b;
        private final u d;
        private final int hc;

        public d(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0766hc interfaceC0766hc) {
            this.b = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.hc = iOptInt;
            this.d = new u(context, intent, i, interfaceC0766hc, iOptInt);
        }

        @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
        public void hc() {
            if (!this.d.tt) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.d.an.sendMessage(messageObtain);
            }
            com.ss.android.socialbase.downloader.d.d.d().hc(this);
            d unused = hc.b = null;
        }

        @Override // com.ss.android.socialbase.downloader.d.d.InterfaceC0785d
        public void b() {
            int iOptInt = this.b.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.d.an.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.d.an.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }
    }

    private static class u implements gb.d {
        public static int d;
        private static int hc;
        private final Handler an;
        private final Context b;
        private final Intent c;
        private Future<Boolean> gb;
        private final long h;
        private boolean tt = false;
        private final InterfaceC0766hc u;

        public u(Context context, Intent intent, int i, InterfaceC0766hc interfaceC0766hc, long j) {
            this.b = context;
            this.c = intent;
            hc = i;
            this.u = interfaceC0766hc;
            this.an = new com.ss.android.socialbase.downloader.k.gb(Looper.getMainLooper(), this);
            this.h = j;
        }

        @Override // com.ss.android.socialbase.downloader.k.gb.d
        public void d(Message message) throws JSONException {
            if (message != null) {
                if (message.what == 1) {
                    long j = this.h;
                    if (j <= 0 || j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                    d = 1;
                    this.gb = com.ss.android.socialbase.downloader.downloader.b.mk().submit(new c(this.an, this.b, this.u, this.h));
                    return;
                }
                if (message.what == 2) {
                    d = 2;
                    this.an.removeMessages(2);
                    this.an.removeMessages(1);
                    Future<Boolean> future = this.gb;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.tt && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.d.d.d().hc())) {
                        Intent intent = this.c;
                        if (intent != null) {
                            hc.hc(this.b, intent);
                        } else {
                            com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(this.b).gb(hc);
                            if (bVarGb != null && bVarGb.bd()) {
                                com.ss.android.socialbase.appdownloader.b.hc(this.b, hc, false);
                            }
                        }
                        this.tt = true;
                    }
                    hc.hc(hc, this.c == null, hc.d(this.b));
                }
            }
        }
    }
}
