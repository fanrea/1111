package com.kwad.tachikoma.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.TemplateConfig;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.tachikoma.e;
import com.kwad.tachikoma.t.h;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class a {
    private static volatile a Cl = null;
    private static volatile boolean Cm = false;
    private static long Cn;
    private Map<String, Boolean> Co = new ConcurrentHashMap();
    private Map<String, TemplateConfig> Cp = new ConcurrentHashMap();
    private Map<String, List<TKDownloadListener>> Cq = new ConcurrentHashMap();

    public final void ij() {
        this.Cq.clear();
        if (isLocalDebugEnable()) {
            this.Co.clear();
        }
    }

    public static synchronized a ik() {
        if (Cl == null) {
            synchronized (a.class) {
                if (Cl == null) {
                    Cl = new a();
                }
            }
        }
        return Cl;
    }

    public final synchronized void a(Context context, List<StyleTemplate> list) {
        if (context != null && list != null) {
            if (!list.isEmpty()) {
                if (!Cm) {
                    Cm = true;
                    b(context, list);
                }
            }
        }
    }

    private void b(final Context context, List<StyleTemplate> list) throws Throwable {
        for (StyleTemplate styleTemplate : list) {
            if (styleTemplate != null) {
                a(context, styleTemplate, 1, new TKDownloadListener() { // from class: com.kwad.tachikoma.g.a.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(StyleTemplate styleTemplate2) throws IOException {
                        if (OfflineHostProvider.getApi().getTKPreloadMemCacheTemplates().contains(styleTemplate2.templateId)) {
                            a.this.b(context, styleTemplate2);
                        }
                    }
                });
            }
        }
    }

    private void a(Context context, StyleTemplate styleTemplate, int i, TKDownloadListener tKDownloadListener) throws Throwable {
        File file = new File(e.hP().hQ().getTkJsFileDir(context, styleTemplate.templateId));
        if (!isLocalDebugEnable() && c(context, styleTemplate)) {
            a(file, styleTemplate);
            e.log().d("TkDownload", "本地缓存存在并且js md5正确" + styleTemplate.templateId);
            tKDownloadListener.onSuccess(styleTemplate);
            return;
        }
        a(styleTemplate, tKDownloadListener);
        if (this.Co.containsKey(styleTemplate.getTemplateKey())) {
            e.log().d("TkDownload", styleTemplate.templateId + "正在下载，再次下载请求被中断返回");
            return;
        }
        this.Co.put(styleTemplate.getTemplateKey(), Boolean.TRUE);
        String str = e(context, styleTemplate) ? TKDownloadReason.KSAD_TK_JS_MD5 : "";
        File fileA = h.a(context, styleTemplate.templateId, b(styleTemplate));
        h.b(fileA);
        a(str, styleTemplate, i);
        e.log().d("TkDownload", "开始下载" + styleTemplate.getTemplateKey());
        if (!OfflineHostProvider.getApi().downloader().downloadSync(fileA, styleTemplate.templateUrl)) {
            b("net", styleTemplate, i);
            h.b(file);
            e.log().d("TkDownload", "缓存下载失败");
            a(styleTemplate, "net");
            return;
        }
        if (isLocalDebugEnable()) {
            e.log().d("TkDownload", "开发环境关闭MD5校验");
        } else if (!TextUtils.equals(OfflineHostProvider.getApi().encrypt().getFileMD5(fileA), styleTemplate.templateMd5)) {
            e.log().d("TkDownload", "MD5校验不正确");
            h.b(file);
            b(TKDownloadReason.KSAD_TK_MD5, styleTemplate, i);
            a(styleTemplate, TKDownloadReason.KSAD_TK_MD5);
            return;
        }
        if (h.N(styleTemplate.templateUrl)) {
            boolean zA = h.a(fileA, e.hP().hQ().getTkJsFileDir(context, styleTemplate.templateId));
            h.b(fileA);
            if (!zA) {
                e.log().d("TkDownload", "unzip失败");
                a(styleTemplate, TKDownloadReason.KSAD_TK_UNZIP);
                b(TKDownloadReason.KSAD_TK_UNZIP, styleTemplate, i);
                return;
            }
        }
        if (!c(context, styleTemplate)) {
            e.log().d("TkDownload", "jsMD5校验失败,删除file =" + file.getName());
            h.b(file);
            b(styleTemplate.loadErrorMsg != null ? styleTemplate.loadErrorMsg : TKDownloadReason.KSAD_TK_JS_MD5, styleTemplate, i);
            a(styleTemplate, TKDownloadReason.KSAD_TK_JS_MD5);
            return;
        }
        a(styleTemplate, i);
        e.log().d("TkDownload", "下载并解压成功");
        a(styleTemplate);
    }

    private void a(StyleTemplate styleTemplate, TKDownloadListener tKDownloadListener) {
        if (tKDownloadListener == null) {
            return;
        }
        List<TKDownloadListener> list = this.Cq.get(styleTemplate.templateId);
        if (list == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(tKDownloadListener);
            this.Cq.put(styleTemplate.templateId, copyOnWriteArrayList);
            return;
        }
        list.add(tKDownloadListener);
    }

    private void a(StyleTemplate styleTemplate) {
        if (isLocalDebugEnable()) {
            this.Co.remove(styleTemplate.getTemplateKey());
        }
        List<TKDownloadListener> list = this.Cq.get(styleTemplate.templateId);
        if (list != null) {
            Iterator<TKDownloadListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onSuccess(styleTemplate);
            }
        }
        this.Cq.remove(styleTemplate.templateId);
    }

    private void a(StyleTemplate styleTemplate, String str) {
        this.Co.remove(styleTemplate.getTemplateKey());
        List<TKDownloadListener> list = this.Cq.get(styleTemplate.templateId);
        if (list != null) {
            Iterator<TKDownloadListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onFailed(str);
            }
        }
        this.Cq.remove(styleTemplate.templateId);
    }

    private void a(File file, StyleTemplate styleTemplate) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add("image");
        arrayList.add(styleTemplate.getTKJsFileName());
        arrayList.add(styleTemplate.getTKConfigFileName());
        arrayList.add("kcov.json");
        if (file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.kwad.tachikoma.g.a.2
                    @Override // java.io.FileFilter
                    public final boolean accept(File file2) {
                        return (file2 == null || arrayList.contains(file2.getName())) ? false : true;
                    }
                });
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        try {
                            if (file2.exists()) {
                                h.b(file2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static String b(StyleTemplate styleTemplate) {
        if (styleTemplate.templateUrl.endsWith(".zip")) {
            return styleTemplate.templateId;
        }
        return styleTemplate.getTKJsFileName();
    }

    public final StyleTemplate a(Context context, StyleTemplate styleTemplate) {
        if (!isLocalDebugEnable() && e(context, styleTemplate)) {
            styleTemplate.tkSouce = 2;
        } else {
            styleTemplate.tkSouce = 3;
        }
        return styleTemplate;
    }

    public final void a(final Context context, StyleTemplate styleTemplate, final TKDownloadListener tKDownloadListener) throws Throwable {
        if (!isLocalDebugEnable() && e(context, styleTemplate)) {
            styleTemplate.tkSouce = 2;
            String strB = b(context, styleTemplate);
            if (TextUtils.isEmpty(strB)) {
                OfflineHostProvider.getApi().log().d("TkDownload", "本地文件存在并且校验成功，直接返回:" + styleTemplate.templateId);
                tKDownloadListener.onSuccess(styleTemplate);
                return;
            }
            OfflineHostProvider.getApi().log().d("TkDownload", "本地文件存在但是校验失败：" + styleTemplate.templateId + ":" + strB);
        }
        OfflineHostProvider.getApi().log().d("TkDownload", "直接在线加载：" + styleTemplate.templateId);
        a(context, styleTemplate, 0, new TKDownloadListener() { // from class: com.kwad.tachikoma.g.a.3
            @Override // com.kwad.components.offline.api.tk.TKDownloadListener
            public final void onSuccess(StyleTemplate styleTemplate2) throws IOException {
                styleTemplate2.tkSouce = 3;
                String strB2 = a.this.b(context, styleTemplate2);
                if (TextUtils.isEmpty(strB2)) {
                    tKDownloadListener.onSuccess(styleTemplate2);
                } else {
                    tKDownloadListener.onFailed(strB2);
                }
            }

            @Override // com.kwad.components.offline.api.tk.TKDownloadListener
            public final void onFailed(String str) {
                tKDownloadListener.onFailed(str);
            }
        });
    }

    private static boolean isLocalDebugEnable() {
        return e.hP().hQ().isLocalDebugEnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context, StyleTemplate styleTemplate) throws IOException {
        File file = new File(e.hP().hQ().getTkJsFileDir(context, styleTemplate.templateId), styleTemplate.getTKJsFileName());
        if (!h.h(file)) {
            return TKPerformMsg.ERROR_REASON.KSAD_TK_NO_FILE;
        }
        try {
            if (!c(context, styleTemplate)) {
                e.log().d("TkDownload", "jsStr md5 校验失败" + styleTemplate.templateId);
                h.b(file);
                String str = styleTemplate.loadErrorMsg != null ? styleTemplate.loadErrorMsg : TKPerformMsg.ERROR_REASON.KSAD_TK_MD5_NOT_MATCH;
                TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(0).setRenderState(3).setErrorReason(str).setErrorDetail(styleTemplate.loadException != null ? styleTemplate.loadException.getMessage() : null).setTemplateId(styleTemplate.templateId).setVersionCode(String.valueOf(styleTemplate.templateVersionCode)).toJson());
                com.kwad.tachikoma.t.a.a(null);
                return str;
            }
            OfflineHostProvider.getApi().saveTKTemplateCache(styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.jsStr);
            e.log().d("TkDownload", "jsStr md5 校验成功" + styleTemplate.templateId);
            com.kwad.tachikoma.t.a.a(null);
            return null;
        } catch (Exception unused) {
            com.kwad.tachikoma.t.a.a(null);
            return TKPerformMsg.ERROR_REASON.KSAD_TK_JS_EMPTY;
        } catch (Throwable th) {
            com.kwad.tachikoma.t.a.a(null);
            throw th;
        }
    }

    private boolean c(Context context, StyleTemplate styleTemplate) throws Throwable {
        FileInputStream fileInputStream;
        Exception e;
        styleTemplate.loadErrorMsg = null;
        styleTemplate.loadException = null;
        File file = new File(e.hP().hQ().getTkJsFileDir(context, styleTemplate.templateId), styleTemplate.getTKJsFileName());
        if (!h.h(file)) {
            return false;
        }
        if (styleTemplate.jsStr == null) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e2) {
                fileInputStream = null;
                e = e2;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                com.kwad.tachikoma.t.a.a(fileInputStream);
                throw th;
            }
            try {
                try {
                    styleTemplate.jsStr = h.b(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.tachikoma.t.a.a(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                OfflineHostProvider.getApi().log().printStackTraceOnly(e);
                com.kwad.tachikoma.t.a.a(fileInputStream);
                return isLocalDebugEnable() ? true : true;
            }
            com.kwad.tachikoma.t.a.a(fileInputStream);
        }
        if (isLocalDebugEnable() && !styleTemplate.templateUrl.contains("coverage")) {
            String str = styleTemplate.templateMd5;
            if (h.N(styleTemplate.templateUrl)) {
                TemplateConfig templateConfigD = d(context, styleTemplate);
                if (templateConfigD == null) {
                    e.log().d("TkDownload", "zip包中JS文件配置不存在或者解析失败：" + styleTemplate.templateId);
                    return false;
                }
                e.log().d("TkDownload", "zip包中JS文件配置存在：" + styleTemplate.templateId);
                str = templateConfigD.md5;
            }
            String md5 = OfflineHostProvider.getApi().encrypt().getMD5(styleTemplate.jsStr);
            e.log().d("TkDownload", "校验md5:" + str + ":" + md5);
            boolean zEquals = TextUtils.equals(md5, str);
            if (!zEquals) {
                styleTemplate.loadErrorMsg = TKPerformMsg.ERROR_REASON.KSAD_TK_MD5_NOT_MATCH;
            }
            return zEquals;
        }
    }

    public final TemplateConfig d(Context context, StyleTemplate styleTemplate) throws Throwable {
        FileInputStream fileInputStream;
        String str = styleTemplate.templateId + ":" + styleTemplate.templateVersionCode;
        TemplateConfig templateConfig = this.Cp.get(str);
        if (templateConfig != null) {
            OfflineHostProvider.getApi().log().d("TkDownload", "缓存中存在配置文件：" + styleTemplate.templateId);
            return templateConfig;
        }
        File fileA = h.a(context, styleTemplate.templateId, styleTemplate.getTKConfigFileName());
        if (fileA == null || !fileA.exists()) {
            styleTemplate.loadErrorMsg = TKPerformMsg.ERROR_REASON.KSAD_TK_CONFIG_LOST;
            OfflineHostProvider.getApi().log().d("TkDownload", "配置文件不存在:" + styleTemplate.templateId);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(fileA);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            com.kwad.tachikoma.t.a.a(fileInputStream);
            throw th;
        }
        try {
            try {
                String strB = h.b(fileInputStream);
                if (!TextUtils.isEmpty(strB)) {
                    JSONObject jSONObject = new JSONObject(strB);
                    TemplateConfig templateConfig2 = new TemplateConfig();
                    templateConfig2.parseJson(jSONObject);
                    this.Cp.put(str, templateConfig2);
                    com.kwad.tachikoma.t.a.a(fileInputStream);
                    return templateConfig2;
                }
            } catch (Throwable th2) {
                th = th2;
                com.kwad.tachikoma.t.a.a(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            styleTemplate.loadErrorMsg = TKPerformMsg.ERROR_REASON.KSAD_TK_CONFIG_PARSE_FAIL;
            styleTemplate.loadException = e;
            OfflineHostProvider.getApi().log().printStackTraceOnly(e);
            OfflineHostProvider.getApi().log().d("TkDownload", "配置文件解析失败:" + styleTemplate.templateId + "：" + e.getMessage());
            com.kwad.tachikoma.t.a.a(fileInputStream);
            return null;
        }
        com.kwad.tachikoma.t.a.a(fileInputStream);
        return null;
    }

    private static boolean e(Context context, StyleTemplate styleTemplate) {
        return h.h(new File(e.hP().hQ().getTkJsFileDir(context, styleTemplate.templateId), styleTemplate.getTKJsFileName()));
    }

    private static void a(String str, StyleTemplate styleTemplate, int i) {
        Cn = SystemClock.elapsedRealtime();
        TkLoggerReporter.get().reportTKDownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setTemplateId(styleTemplate.templateId).setErrorReason(str).setPreload(i).setVersionCode(String.valueOf(styleTemplate.templateVersionCode)).toJson());
    }

    private static void a(StyleTemplate styleTemplate, int i) {
        TkLoggerReporter.get().reportTKDownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadTime(Cn > 0 ? SystemClock.elapsedRealtime() - Cn : 0L).setDownloadState(1).setTemplateId(styleTemplate.templateId).setPreload(i).setVersionCode(String.valueOf(styleTemplate.templateVersionCode)).toJson());
    }

    private static void b(String str, StyleTemplate styleTemplate, int i) {
        TkLoggerReporter.get().reportTKDownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setDownloadState(2).setErrorReason(str).setPreload(i).setTemplateId(styleTemplate.templateId).setVersionCode(String.valueOf(styleTemplate.templateVersionCode)).toJson());
    }
}
