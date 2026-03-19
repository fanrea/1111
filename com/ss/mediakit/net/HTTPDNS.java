package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLNetClient;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HTTPDNS extends BaseDNS {
    private static final String TAG = "HTTPDNS";
    private static String mGoogleDNSServer = "/resolve?name=";
    private static String mTTDNSServer = "/q?host=";
    private int mHttpDNSType;
    private Object mSource;
    private long mSourceId;

    public HTTPDNS(String str, AVMDLNetClient aVMDLNetClient, int i, Handler handler) {
        super(str, aVMDLNetClient, handler);
        this.mHttpDNSType = i;
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void start() throws SecurityException {
        String str_getURL = _getURL();
        AVMDLLog.d(TAG, "http dns url:" + str_getURL);
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
            this.mNetClient.startTask(str_getURL, null, null, 0, new AVMDLNetClient.CompletionListener() { // from class: com.ss.mediakit.net.HTTPDNS.1
                @Override // com.ss.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        } else {
            this.mNetClient.startTask(str_getURL, null, new AVMDLNetClient.CompletionListener() { // from class: com.ss.mediakit.net.HTTPDNS.2
                @Override // com.ss.mediakit.net.AVMDLNetClient.CompletionListener
                public void onCompletion(JSONObject jSONObject, Error error) {
                    HTTPDNS.this._handleResponse(jSONObject, error);
                }
            });
        }
    }

    @Override // com.ss.mediakit.net.BaseDNS
    public void cancel() {
        if (this.mCancelled) {
            return;
        }
        this.mCancelled = true;
        this.mNetClient.cancel();
    }

    private String _getURL() {
        StringBuilder sb = new StringBuilder();
        boolean zIsIPv4Reachable = AVMDLMultiNetwork.isIPv4Reachable();
        boolean zIsIPv4Reachable2 = AVMDLMultiNetwork.isIPv4Reachable();
        int i = this.mHttpDNSType;
        if (i == 2 || i == 1) {
            sb.append("https://" + AVMDLDNSParser.mGlobalOwnDNSParseHost + mTTDNSServer);
        } else if (i == 3) {
            sb.append("https://" + AVMDLDNSParser.mGlobalGoogleDNSParseHost + mGoogleDNSServer);
        }
        sb.append(this.mHostname);
        int i2 = this.mHttpDNSType;
        if (i2 == 2 || i2 == 1) {
            sb.append("&source=vod");
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            if (config != null && config.mEnableNetworkChangeNotify == 1) {
                if (zIsIPv4Reachable && zIsIPv4Reachable2) {
                    sb.append("&f=0");
                } else if (zIsIPv4Reachable) {
                    sb.append("&f=1");
                } else if (zIsIPv4Reachable2) {
                    sb.append("&f=2");
                }
            }
        }
        return sb.toString();
    }

    private AVMDLDNSInfo parserResult(JSONObject jSONObject) throws JSONException {
        long jCurrentTimeMillis;
        String string;
        String str;
        String str2;
        int i = this.mHttpDNSType;
        String str3 = "";
        if (i == 2 || i == 1) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            iOptInt = jSONObject.has("ttl") ? jSONObject.optInt("ttl") : 60;
            AVMDLLog.d(TAG, String.format(Locale.US, "receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(iOptInt), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
            if (AVMDLDNSParser.mGlobalForceExpiredTime > 0) {
                iOptInt = AVMDLDNSParser.mGlobalForceExpiredTime;
            }
            jCurrentTimeMillis = System.currentTimeMillis() + (iOptInt * 1000);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ips");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return null;
            }
            string = null;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                try {
                    string = jSONArrayOptJSONArray.getString(i2);
                } catch (Exception e) {
                    e.printStackTrace();
                    string = null;
                }
                if (!TextUtils.isEmpty(string)) {
                    if (TextUtils.isEmpty(str3)) {
                        str = str3 + string;
                    } else {
                        str = str3 + "," + string;
                    }
                    str3 = str;
                }
            }
        } else {
            jCurrentTimeMillis = 0;
            string = null;
        }
        if (this.mHttpDNSType == 3) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("Answer");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.has("type") && jSONObject2.getInt("type") == 1) {
                        if (jSONObject2.has("TTL")) {
                            iOptInt = jSONObject2.optInt("TTL");
                        }
                        if (jSONObject2.has("data")) {
                            string = jSONObject2.optString("data");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            if (TextUtils.isEmpty(str3)) {
                                str2 = str3 + string;
                            } else {
                                str2 = str3 + "," + string;
                            }
                            str3 = str2;
                        }
                    }
                }
                AVMDLLog.d(TAG, String.format(Locale.US, "receive expiredtime:%d force expiredtime:%d ", Integer.valueOf(iOptInt), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)));
                if (AVMDLDNSParser.mGlobalForceExpiredTime > 0) {
                    iOptInt = AVMDLDNSParser.mGlobalForceExpiredTime;
                }
                jCurrentTimeMillis = System.currentTimeMillis() + (iOptInt * 1000);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, str3, jCurrentTimeMillis, this.mId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleResponse(JSONObject jSONObject, Error error) {
        AVMDLDNSInfo aVMDLDNSInfo;
        AVMDLLog.d(TAG, String.format(Locale.US, "****http dns id:%s type:%d host:%s", this.mId, Integer.valueOf(this.mHttpDNSType), this.mHostname));
        AVMDLDNSInfo aVMDLDNSInfo2 = new AVMDLDNSInfo(this.mHttpDNSType, this.mHostname, (String) null, 0L, this.mId);
        if (error != null) {
            aVMDLDNSInfo2.mErrorStr = error.errStr;
            AVMDLLog.d(TAG, String.format(Locale.US, "handle response receive err:%s", error.errStr));
        } else if (jSONObject == null || jSONObject.length() == 0) {
            new Error(this.mHttpDNSType, this.mHostname, this.mId, String.format(Locale.US, "HTTP dns empty, type:%d", Integer.valueOf(this.mHttpDNSType)));
            AVMDLLog.d(TAG, String.format(Locale.US, "json null err", new Object[0]));
        } else {
            try {
                aVMDLDNSInfo = parserResult(jSONObject);
            } catch (Throwable th) {
                AVMDLLog.d(TAG, String.format(Locale.US, "handle response exception:%s", th.toString()));
                aVMDLDNSInfo = null;
            }
            if (aVMDLDNSInfo == null) {
                AVMDLLog.d(TAG, String.format(Locale.US, "info null err", new Object[0]));
            } else {
                AVMDLLog.d(TAG, String.format(Locale.US, "****parse suc for host:%s iplist:%s", this.mHostname, aVMDLDNSInfo.mIpList));
                IPCache.getInstance().put(this.mHostname, aVMDLDNSInfo);
                notifySuccess(aVMDLDNSInfo);
                return;
            }
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "****parse failed for host:%s", this.mHostname));
        notifyError(aVMDLDNSInfo2);
    }
}
