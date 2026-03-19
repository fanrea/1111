package com.fendasz.moku.planet.common.network;

import android.content.Context;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.Network;
import com.fendasz.moku.planet.common.network.interceptor.CompanyInterceptor;
import com.fendasz.moku.planet.common.network.interceptor.LogInterceptor;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import java.util.ArrayList;
import retrofit2.Retrofit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CompanyNetworkManager extends Network {
    private static final String BASE_DOMAIN_NAME;
    private static Boolean DEBUG;

    static {
        Boolean bool = false;
        DEBUG = bool;
        BASE_DOMAIN_NAME = bool.booleanValue() ? "192.168.1.204:8082" : "sdk.moguxingqiu.com";
    }

    public static Retrofit getApiInstance(Context context) {
        ArrayList arrayList = new ArrayList();
        LogUtils.logD("CompanyNetworkManager", "IS DEBUG=>" + DEBUG);
        if (arrayList.size() == 0) {
            arrayList.add(CompanyInterceptor.create(context));
            if (DEBUG.booleanValue()) {
                arrayList.add(new LogInterceptor());
            }
        }
        String string = BASE_DOMAIN_NAME;
        if (DEBUG.booleanValue()) {
            string = SharedPreferencesUtils.getInstance(context).getString(context.getString(R.string.moku_sp_domain_name), string);
        }
        return getRetrofitInstance("http://" + string + "/moku-planet/", arrayList);
    }

    public static String getBaseDomain(Context context) {
        String str = BASE_DOMAIN_NAME;
        return DEBUG.booleanValue() ? SharedPreferencesUtils.getInstance(context).getString(context.getString(R.string.moku_sp_domain_name), str) : str;
    }
}
