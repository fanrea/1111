package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class cw implements Runnable {
    private Context a;

    public cw(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            String str = cu.a + cu.d;
            String strA = cv.a(this.a);
            if (!TextUtils.isEmpty(strA)) {
                str = str + "?" + strA;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObjectB = cv.b(this.a);
            if (jSONObjectB != null) {
                jSONObject.put("data", new bn(this.a).c(jSONObjectB.toString()));
            }
            l lVarA = l.a(this.a);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            lVarA.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cw.1
                @Override // com.kuaishou.weapon.p0.j
                public void b(String str2) {
                }

                @Override // com.kuaishou.weapon.p0.j
                public void a(String str2) {
                    try {
                        cw.this.a(str2);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public void a(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String strA = new bn(this.a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                y yVarB = b(strA);
                if (yVarB != null) {
                    df.a(this.a).a(str, yVarB);
                } else {
                    df.a(this.a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:7|(2:79|8)|(6:10|11|12|13|89|14)(2:16|17)|(3:83|18|(1:20))|(3:91|21|(1:23))|24|(3:95|25|(4:81|26|27|(2:77|28)))|(4:93|31|32|(8:85|33|34|87|35|36|105|37))|43|44|(2:75|45)|103|48|(3:50|(1:52)|53)|101|54|(1:56)|99|57|(1:59)|60) */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03df A[Catch: Exception -> 0x0444, TryCatch #14 {Exception -> 0x0444, blocks: (B:48:0x03d0, B:50:0x03df, B:52:0x040b, B:53:0x0441), top: B:103:0x03d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0455 A[Catch: Exception -> 0x0486, TRY_LEAVE, TryCatch #13 {Exception -> 0x0486, blocks: (B:54:0x0444, B:56:0x0455), top: B:101:0x0444 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0497 A[Catch: Exception -> 0x04da, TRY_LEAVE, TryCatch #12 {Exception -> 0x04da, blocks: (B:57:0x0486, B:59:0x0497), top: B:99:0x0486 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kuaishou.weapon.p0.y b(java.lang.String r21) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.cw.b(java.lang.String):com.kuaishou.weapon.p0.y");
    }
}
