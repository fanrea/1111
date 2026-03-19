package com.baidu.mobstat.forbes;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.ah;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPOutputStream;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class LogSender {
    private static LogSender a = new LogSender();
    private boolean b = false;
    private int c = 0;
    private int d = 1;
    private SendStrategyEnum e = SendStrategyEnum.APP_START;
    private Timer f;
    private Handler g;

    public static LogSender instance() {
        return a;
    }

    private LogSender() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.g = new Handler(handlerThread.getLooper());
    }

    public void setLogSenderDelayed(int i) {
        if (i >= 0 && i <= 30) {
            this.c = i;
        }
    }

    public void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            if (i > 0 && i <= 24) {
                this.d = i;
                this.e = SendStrategyEnum.SET_TIME_INTERVAL;
                al.a().a(context, this.e.ordinal());
                al.a().b(context, this.d);
            }
        } else {
            this.e = sendStrategyEnum;
            al.a().a(context, this.e.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                al.a().b(context, 24);
            }
        }
        this.b = z;
        al.a().a(context, this.b);
    }

    public void onSend(final Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context == null) {
            return;
        }
        this.g.post(new Runnable() { // from class: com.baidu.mobstat.forbes.LogSender.1
            @Override // java.lang.Runnable
            public void run() {
                if (LogSender.this.f != null) {
                    LogSender.this.f.cancel();
                    LogSender.this.f = null;
                }
                LogSender.this.e = SendStrategyEnum.values()[al.a().b(context)];
                LogSender.this.d = al.a().c(context);
                LogSender.this.b = al.a().d(context);
                if (LogSender.this.e.equals(SendStrategyEnum.SET_TIME_INTERVAL) || LogSender.this.e.equals(SendStrategyEnum.ONCE_A_DAY)) {
                    LogSender.this.setSendingLogTimer(context);
                }
                LogSender.this.g.postDelayed(new Runnable() { // from class: com.baidu.mobstat.forbes.LogSender.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogSender.this.a(context);
                    }
                }, LogSender.this.c * 1000);
            }
        });
    }

    public void setSendingLogTimer(Context context) {
        final Context applicationContext = context.getApplicationContext();
        long j = this.d * 3600000;
        try {
            this.f = new Timer();
            this.f.schedule(new TimerTask() { // from class: com.baidu.mobstat.forbes.LogSender.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    LogSender.this.a(applicationContext);
                }
            }, j, j);
        } catch (Exception e) {
        }
    }

    public void saveLogData(Context context, String str, boolean z) {
        aj.a(context, (z ? Config.PREFIX_SEND_DATA_FULL : Config.PREFIX_SEND_DATA) + System.currentTimeMillis(), str, false);
        if (z) {
            a(context, Config.FULL_TRACE_LOG_LIMIT, Config.PREFIX_SEND_DATA_FULL);
        }
    }

    private void a(Context context, long j, String str) throws IOException {
        ArrayList<String> arrayListA = a(context, str);
        int size = arrayListA.size() - 1;
        long jAvailable = 0;
        FileInputStream fileInputStreamOpenFileInput = null;
        while (size >= 0) {
            try {
                fileInputStreamOpenFileInput = context.openFileInput(arrayListA.get(size));
                jAvailable += fileInputStreamOpenFileInput.available();
            } catch (Exception e) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
            if (fileInputStreamOpenFileInput != null) {
                try {
                    fileInputStreamOpenFileInput.close();
                } catch (Exception e4) {
                }
                fileInputStreamOpenFileInput = null;
            }
            if (jAvailable > j) {
                break;
            } else {
                size--;
            }
        }
        for (int i = 0; i <= size; i++) {
            aj.b(context, arrayListA.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> a(Context context, final String str) {
        File filesDir;
        String[] list;
        ArrayList<String> arrayList = new ArrayList<>();
        if (context == null || (filesDir = context.getFilesDir()) == null || !filesDir.exists()) {
            return arrayList;
        }
        try {
            list = filesDir.list(new FilenameFilter() { // from class: com.baidu.mobstat.forbes.LogSender.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    if (str2.startsWith(str)) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            list = null;
        }
        if (list == null || list.length == 0) {
            return arrayList;
        }
        try {
            Arrays.sort(list, new Comparator<String>() { // from class: com.baidu.mobstat.forbes.LogSender.4
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(String str2, String str3) {
                    return str2.compareTo(str3);
                }
            });
        } catch (Exception e2) {
        }
        for (String str2 : list) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    class a implements Callable<Object> {
        private Context b;
        private String c;
        private String d;
        private boolean e;

        a(Context context, String str, String str2, boolean z) {
            this.b = context;
            this.d = str;
            this.c = str2;
            this.e = z;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws JSONException {
            boolean z;
            if (!LogSender.this.a(this.b, this.c, this.e)) {
                LogSender.b(this.b, this.d, this.c);
                z = false;
            } else {
                aj.b(this.b, this.d);
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    public void sendLogDataWithSyn(Context context) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(context, Config.PREFIX_SEND_DATA));
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        if (size > 20) {
            size = 20;
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(size);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList2.add(executorServiceNewFixedThreadPool.submit(new a(context, (String) arrayList.get(i), aj.a(context, (String) arrayList.get(i)), ((String) arrayList.get(i)).contains(Config.PREFIX_SEND_DATA_FULL))));
        }
        executorServiceNewFixedThreadPool.shutdown();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            try {
                ((Future) it.next()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context) {
        if (this.b && !ar.h(context)) {
            return;
        }
        this.g.post(new Runnable() { // from class: com.baidu.mobstat.forbes.LogSender.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA));
                    arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA_FULL));
                    Iterator it = arrayList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        String strA = aj.a(context, str);
                        if (TextUtils.isEmpty(strA)) {
                            aj.b(context, str);
                        } else {
                            if (!str.contains(Config.PREFIX_SEND_DATA_FULL)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (!LogSender.this.a(context, strA, z)) {
                                LogSender.b(context, str, strA);
                                i++;
                                if (i >= 5) {
                                    break;
                                }
                            } else {
                                aj.b(context, str);
                                i = 0;
                            }
                        }
                    }
                    ap.a().b(context);
                } catch (Exception e) {
                }
            }
        });
    }

    public void sendLogData(Context context, final String str, boolean z) throws JSONException {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        if (z) {
            b(applicationContext, str);
        } else {
            this.g.post(new Runnable() { // from class: com.baidu.mobstat.forbes.LogSender.6
                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    LogSender.this.b(applicationContext, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str) throws JSONException {
        String str2 = Config.PREFIX_SEND_DATA + System.currentTimeMillis();
        aj.a(context, str2, str, false);
        if (c(context, str)) {
            aj.b(context, str2);
        } else {
            b(context, str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2) throws JSONException {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(Config.TRACE_PART);
            jSONObject2.put(Config.TRACE_FAILED_CNT, jSONObject2.getLong(Config.TRACE_FAILED_CNT) + 1);
        } catch (Exception e2) {
        }
        aj.a(context, str, jSONObject.toString(), false);
    }

    public void sendEmptyLogData(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        this.g.post(new Runnable() { // from class: com.baidu.mobstat.forbes.LogSender.7
            @Override // java.lang.Runnable
            public void run() {
                String strConstructLogWithEmptyBody = DataCore.instance().constructLogWithEmptyBody(applicationContext, str);
                if (!TextUtils.isEmpty(strConstructLogWithEmptyBody)) {
                    LogSender.this.c(applicationContext, strConstructLogWithEmptyBody);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context, String str) {
        return a(context, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, boolean z) {
        if (!z) {
            v.c().a("Start send log \n" + str);
        }
        boolean z2 = false;
        if (this.b && !ar.h(context)) {
            v.c().a("[WARNING] wifi not available, log will be cached, next time will try to resend");
            return false;
        }
        String str2 = Config.LOG_SEND_URL;
        if (z) {
            str2 = Config.LOG_FULL_SEND_URL;
        }
        try {
            c(context, str2, str);
            z2 = true;
        } catch (Exception e) {
            v.c().a(e);
        }
        if (!z) {
            v.c().a("Send log " + (z2 ? "success" : com.alipay.sdk.m.u.h.i));
        }
        return z2;
    }

    private String c(Context context, String str, String str2) {
        if (!str.startsWith("https://")) {
            return e(context, str, str2);
        }
        return d(context, str, str2);
    }

    private String d(Context context, String str, String str2) throws JSONException {
        HttpURLConnection httpURLConnectionD = aj.d(context, str);
        httpURLConnectionD.setDoOutput(true);
        httpURLConnectionD.setInstanceFollowRedirects(false);
        httpURLConnectionD.setUseCaches(false);
        httpURLConnectionD.setRequestProperty("Content-Type", "gzip");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ae.b("mtj_LogSender", "url=" + str + ";json=" + jSONObject.toString());
            ae.b("mtj_LogSender", "url=" + str + ";json=" + jSONObject.optJSONArray(Config.ACTIVITY_LIFE_CYCLE_PART));
            JSONObject jSONObject2 = jSONObject.getJSONObject(Config.HEADER_PART);
            httpURLConnectionD.setRequestProperty("mtj_appkey", jSONObject2.getString("k"));
            httpURLConnectionD.setRequestProperty("mtj_appversion", jSONObject2.getString("n"));
            httpURLConnectionD.setRequestProperty("mtj_os", jSONObject2.getString(Config.OS));
            httpURLConnectionD.setRequestProperty("mtj_pn", jSONObject2.getString(Config.PACKAGE_NAME));
            httpURLConnectionD.setRequestProperty("mtj_tg", jSONObject2.getString(Config.SDK_TAG));
            httpURLConnectionD.setRequestProperty("mtj_ii", jSONObject2.getString(Config.CUID_SEC));
            httpURLConnectionD.setRequestProperty("from", jSONObject2.getString("from"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        httpURLConnectionD.connect();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(httpURLConnectionD.getOutputStream())));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionD.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            int contentLength = httpURLConnectionD.getContentLength();
            if (httpURLConnectionD.getResponseCode() != 200 || contentLength != 0) {
                throw new IOException("http code = " + httpURLConnectionD.getResponseCode() + "; contentResponse = " + ((Object) sb));
            }
            return sb.toString();
        } finally {
            httpURLConnectionD.disconnect();
        }
    }

    private String e(Context context, String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        HttpURLConnection httpURLConnectionD = aj.d(context, str);
        httpURLConnectionD.setDoOutput(true);
        httpURLConnectionD.setInstanceFollowRedirects(false);
        httpURLConnectionD.setUseCaches(false);
        httpURLConnectionD.setRequestProperty("Content-Type", "gzip");
        byte[] bArrA = ah.a.a();
        byte[] bArrB = ah.a.b();
        httpURLConnectionD.setRequestProperty("key", aq.a(bArrA));
        httpURLConnectionD.setRequestProperty("iv", aq.a(bArrB));
        byte[] bArrA2 = ah.a.a(bArrA, bArrB, str2.getBytes("utf-8"));
        httpURLConnectionD.connect();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(httpURLConnectionD.getOutputStream());
            gZIPOutputStream.write(bArrA2);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnectionD.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            int contentLength = httpURLConnectionD.getContentLength();
            if (httpURLConnectionD.getResponseCode() != 200 || contentLength != 0) {
                throw new IOException("http code = " + httpURLConnectionD.getResponseCode() + "; contentResponse = " + ((Object) sb));
            }
            return sb.toString();
        } finally {
            httpURLConnectionD.disconnect();
        }
    }
}
