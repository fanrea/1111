package com.alliance.ssp.ad.e0;

import android.content.pm.PackageManager;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.manager.applist.InitConfigManager;
import com.alliance.ssp.ad.manager.applist.bean.InitConfigBean;
import com.alliance.ssp.ad.o0.l;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InitConfigRequester.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b implements Callback {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ e b;
    public final /* synthetic */ d c;

    public b(d dVar, int[] iArr, int i, e eVar) {
        this.c = dVar;
        this.a = iArr;
        this.b = eVar;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) throws JSONException, PackageManager.NameNotFoundException, IOException {
        int[] iArr = this.a;
        int i = iArr[0];
        if (i < 1) {
            iArr[0] = i + 1;
            call.clone().enqueue(this);
            return;
        }
        ((a) this.b).getClass();
        if ((iOException instanceof SocketTimeoutException) || (iOException instanceof ConnectTimeoutException)) {
            new f().a(1, 3, (Integer) null, (String) null, 0);
        } else {
            new f().a(1, 2, (Integer) null, (String) null, 200);
        }
        iOException.getMessage();
        int i2 = l.a;
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) throws JSONException, PackageManager.NameNotFoundException, IOException {
        if (!response.isSuccessful()) {
            int[] iArr = this.a;
            int i = iArr[0];
            if (i >= 1) {
                ((a) this.b).a(response.code(), response.message());
                return;
            } else {
                iArr[0] = i + 1;
                call.clone().enqueue(this);
                return;
            }
        }
        e eVar = this.b;
        d dVar = this.c;
        dVar.getClass();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
        StringBuilder sb = new StringBuilder();
        InitConfigBean initConfigBean = null;
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    sb.append(line);
                }
            } catch (Exception unused) {
                int i2 = l.a;
            }
        }
        JSONObject jSONObject = new JSONObject(sb.toString());
        if (jSONObject.has("cipher") && jSONObject.has("encryptParams")) {
            initConfigBean = (InitConfigBean) new Gson().fromJson(com.alliance.ssp.ad.o.e.a(jSONObject.getString("cipher"), jSONObject.getString("encryptParams")), new c(dVar).getType());
        }
        ((a) eVar).getClass();
        if (initConfigBean == null) {
            new f().a(1, 1, (Integer) null, (String) null, 0);
            return;
        }
        InitConfigManager.g.d = initConfigBean;
        new f().a(1, 0, initConfigBean.getB(), initConfigBean.getA() != null ? initConfigBean.getA().toString() : "", 0);
    }
}
