package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLNetClient;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HTTPDNSHosts {
    private static final String TAG = "BatchParseHTTPDNSHosts";
    private static String mTTDNSServer = "/q?host=";
    protected boolean mCancelled = false;
    protected Handler mHandler;
    public String[] mHostnames;
    private int mHttpDNSType;
    public String mId;
    protected AVMDLNetClient mNetClient;

    public HTTPDNSHosts(String[] strArr, AVMDLNetClient aVMDLNetClient, int i, Handler handler) throws Exception {
        this.mHttpDNSType = 2;
        this.mNetClient = null;
        if (i != 2) {
            AVMDLLog.d(TAG, "create fail type is not own");
            throw new Exception("type is not own");
        }
        if (strArr == null || strArr.length == 0) {
            AVMDLLog.d(TAG, "host array is valid");
            throw new Exception("host array is valid");
        }
        this.mHttpDNSType = i;
        this.mHostnames = strArr;
        this.mNetClient = aVMDLNetClient;
        if (aVMDLNetClient == null) {
            this.mNetClient = new AVMDLHTTPNetwork();
        }
        this.mHttpDNSType = i;
        this.mHandler = handler;
    }

    public void start() throws SecurityException {
        String str_getURL = _getURL();
        AVMDLLog.d(TAG, "batch http dns  url:" + str_getURL);
        Method[] declaredMethods = this.mNetClient.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Method method = declaredMethods[i];
            if (method.getName().equals("startTask") && method.getParameterTypes().length == 5) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            this.mNetClient.startTask(str_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.ss.mediakit.net.HTTPDNSHosts.1
                @Override // com.ss.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(str_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.ss.mediakit.net.HTTPDNSHosts.2
                @Override // com.ss.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNSHosts.this._handleResponse(jSONObject, error);
                }
            });
        }
    }

    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.mHostnames;
            if (i < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    if (i2 == 0) {
                        sb.append(this.mHostnames[i]);
                    } else {
                        sb.append("," + this.mHostnames[i]);
                    }
                    i2++;
                }
                i++;
            } else {
                return sb.toString();
            }
        }
    }

    private void parseResult(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dns");
            for (int i = 0; i < jSONArray.length(); i++) {
                AVMDLDNSInfo aVMDLDNSInfo = parserResultForSingleHost(jSONArray.getJSONObject(i));
                if (aVMDLDNSInfo != null) {
                    IPCache.getInstance().put(aVMDLDNSInfo.mHost, aVMDLDNSInfo);
                }
            }
        } catch (Exception e) {
            AVMDLLog.d(TAG, "parse json exception" + e);
        }
    }

    private AVMDLDNSInfo parserResultForSingleHost(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        long j;
        String string;
        int i = this.mHttpDNSType;
        String str3 = "";
        if (i == 2 || i == 1) {
            if (jSONObject != null && jSONObject.length() != 0) {
                int iOptInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
                String strOptString = jSONObject.has("host") ? jSONObject.optString("host") : null;
                long jCurrentTimeMillis = System.currentTimeMillis() + (iOptInt * 1000);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        try {
                            string = jSONArrayOptJSONArray.getString(i2);
                        } catch (Exception e) {
                            e.printStackTrace();
                            string = null;
                        }
                        if (!TextUtils.isEmpty(string)) {
                            if (TextUtils.isEmpty(str3)) {
                                str3 = str3 + string;
                            } else {
                                str3 = str3 + "," + string;
                            }
                        }
                    }
                    str = str3;
                    str2 = strOptString;
                    j = jCurrentTimeMillis;
                }
            }
            return null;
        }
        str2 = null;
        str = "";
        j = 0;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            AVMDLLog.d(TAG, "parse result is null");
            return null;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "parse result host:%s ips:%s expiredT:%d", str2, str, Long.valueOf(j)));
        return new AVMDLDNSInfo(this.mHttpDNSType, str2, str, j, this.mId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLLog.d(TAG, String.format(Locale.US, "****http dns id:%s type:%d", this.mId, Integer.valueOf(this.mHttpDNSType)));
        if (error != null) {
            AVMDLLog.d(TAG, String.format(Locale.US, "handle response receive err:%s", error.errStr));
            return;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            AVMDLLog.d(TAG, String.format(Locale.US, "json null err", new Object[0]));
            return;
        }
        try {
            parseResult(jSONObject);
        } catch (Throwable th) {
            AVMDLLog.d(TAG, String.format(Locale.US, "handle response exception:%s", th.toString()));
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "****parse end", new Object[0]));
    }
}
