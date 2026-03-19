package com.sigmob.sdk.base.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.ResponseHeader;
import com.czhj.sdk.logger.SigmobLog;
import com.just.agentweb.AgentWebPermissions;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an extends AsyncTask<String, Void, String> {
    private static final int a = 10;
    private final a b;

    public interface a {
        void a(final String resolvedUrl);

        void a(final String message, final Throwable throwable);
    }

    private an(a listener) {
        this.b = listener;
    }

    private static String a(final String baseUrl, final HttpURLConnection httpUrlConnection) throws Throwable {
        URI uri = new URI(baseUrl);
        int responseCode = httpUrlConnection.getResponseCode();
        String headerField = httpUrlConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
        if (responseCode < 300 || responseCode >= 400) {
            return null;
        }
        try {
            return uri.resolve(headerField).toString();
        } catch (IllegalArgumentException unused) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + baseUrl + "\n redirectUrl=" + headerField);
            throw new URISyntaxException(headerField, "Unable to parse invalid URL");
        } catch (Throwable th) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + baseUrl + "\n redirectUrl=" + headerField);
            throw th;
        }
    }

    public static void a(final String urlString, final a listener) {
        try {
            new an(listener).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), urlString);
        } catch (Throwable th) {
            listener.a("Failed to resolve url", th);
        }
    }

    private String b(final String urlString) throws Throwable {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(urlString).openConnection();
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.addRequestProperty(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
            String strA = a(urlString, httpURLConnection);
            if (httpURLConnection != null) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                        SigmobLog.d("IOException when closing httpUrlConnection. Ignoring.");
                    }
                }
                httpURLConnection.disconnect();
            }
            return strA;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                InputStream inputStream2 = httpURLConnection2.getInputStream();
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable unused2) {
                        SigmobLog.d("IOException when closing httpUrlConnection. Ignoring.");
                    }
                }
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... urls) {
        String str = null;
        if (urls == null || urls.length == 0) {
            return null;
        }
        try {
            String strB = urls[0];
            while (true) {
                String str2 = str;
                str = strB;
                if (str == null) {
                    return str2;
                }
                try {
                    if (!al.OPEN_WITH_BROWSER.a(Uri.parse(str), 0)) {
                        return str;
                    }
                    strB = b(str);
                } catch (Throwable th) {
                    str = str2;
                    th = th;
                    SigmobLog.w(th.getMessage());
                    return str;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(final String resolvedUrl) {
        super.onPostExecute(resolvedUrl);
        if (isCancelled() || resolvedUrl == null) {
            onCancelled();
        } else {
            this.b.a(resolvedUrl);
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.b.a("Task for resolving url was cancelled", null);
    }
}
