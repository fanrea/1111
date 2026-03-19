package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.ss.android.d.d.hc.v;
import com.ss.android.downloadlib.h.k;
import com.ss.android.downloadlib.h.tc;
import com.ss.android.socialbase.downloader.c.vv;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb implements k.d {
    private boolean b = false;
    private u c;
    public com.ss.android.downloadlib.addownload.hc.u d;
    private long hc;
    private hc u;

    public interface hc {
        void d(com.ss.android.socialbase.downloader.h.b bVar);
    }

    @Override // com.ss.android.downloadlib.h.k.d
    public void d(Message message) {
    }

    public gb(u uVar) {
        this.c = uVar;
    }

    public void d(long j) {
        this.hc = j;
        com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(j);
        this.d = uVarU;
        if (uVarU.np()) {
            com.ss.android.downloadlib.u.b.d().d("setAdId ModelBox notValid");
        }
    }

    public void d(com.ss.android.socialbase.downloader.h.b bVar) {
        this.b = false;
        hc(bVar);
    }

    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
        hc hcVar = this.u;
        if (hcVar != null) {
            hcVar.d(bVar);
            this.u = null;
        }
    }

    boolean d(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.h.uo.d(this.d.hc)) {
            com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(this.d.d);
            if (hcVarC != null) {
                com.ss.android.socialbase.downloader.notification.hc.d().an(hcVarC.rf());
            }
            return com.ss.android.downloadlib.hc.d.d(this.d);
        }
        if (d(i) && !TextUtils.isEmpty(this.d.hc.he()) && mq.tt().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.hc.d.d(this.d, i)) {
                return true;
            }
            return this.c.tt() && this.c.c(true);
        }
        if (!z || this.d.c.hc() != 4 || this.c.u()) {
            return false;
        }
        this.c.b(true);
        return true;
    }

    public boolean d(int i) {
        if (this.d.c.hc() == 2 && i == 2) {
            return true;
        }
        return this.d.c.hc() == 2 && i == 1 && mq.tt().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean d(int i, com.ss.android.d.d.b.b bVar) {
        return com.ss.android.socialbase.appdownloader.an.u.b() && d(i) && !com.ss.android.downloadlib.h.uo.d(bVar);
    }

    boolean d(boolean z) {
        return !z && this.d.c.hc() == 1;
    }

    private boolean b() {
        return c() && u();
    }

    private boolean c() {
        return (this.d.hc == null || TextUtils.isEmpty(this.d.hc.he()) || TextUtils.isEmpty(this.d.hc.d())) ? false : true;
    }

    private boolean u() {
        return this.d.c.c();
    }

    void d(final v vVar) {
        if (!TextUtils.isEmpty(this.d.hc.e())) {
            String strE = this.d.hc.e();
            if (strE.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                vVar.d();
                return;
            }
            try {
                String parent = mq.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (strE.startsWith(parent)) {
                    vVar.d();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        hc(new v() { // from class: com.ss.android.downloadlib.addownload.gb.1
            @Override // com.ss.android.d.d.hc.v
            public void d() {
                vVar.d();
            }

            @Override // com.ss.android.d.d.hc.v
            public void d(String str) throws JSONException {
                mq.b().d(1, mq.getContext(), gb.this.d.hc, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.c.d.d().hc(gb.this.hc, 1);
                vVar.d(str);
            }
        });
    }

    private void hc(final v vVar) {
        if (com.ss.android.downloadlib.h.tc.hc("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (vVar != null) {
                vVar.d();
                return;
            }
            return;
        }
        String str = "android.permission.READ_MEDIA_IMAGES";
        if (!com.ss.android.downloadlib.h.uo.d()) {
            str = "android.permission.READ_EXTERNAL_STORAGE";
        } else if (com.ss.android.downloadlib.h.tc.hc("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.h.tc.hc(PermissionConfig.READ_MEDIA_AUDIO) || com.ss.android.downloadlib.h.tc.hc("android.permission.READ_MEDIA_VIDEO")) {
            if (vVar != null) {
                vVar.d();
                return;
            }
            return;
        }
        com.ss.android.downloadlib.h.tc.d(new String[]{str}, new tc.d() { // from class: com.ss.android.downloadlib.addownload.gb.2
            @Override // com.ss.android.downloadlib.h.tc.d
            public void d() {
                v vVar2 = vVar;
                if (vVar2 != null) {
                    vVar2.d();
                }
            }

            @Override // com.ss.android.downloadlib.h.tc.d
            public void d(String str2) {
                v vVar2 = vVar;
                if (vVar2 != null) {
                    vVar2.d(str2);
                }
            }
        });
    }

    void d(Message message, com.ss.android.d.d.u.u uVar, Map<Integer, Object> map) {
        hc hcVar;
        if (message == null || message.what != 3) {
            return;
        }
        com.ss.android.socialbase.downloader.h.b bVar = (com.ss.android.socialbase.downloader.h.b) message.obj;
        if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2) {
            if (bVar.xn()) {
                com.ss.android.downloadlib.gb.d().d(this.d.hc, this.d.c, this.d.b);
                bVar.tt(false);
            }
            com.ss.android.downloadlib.c.d.d().d(bVar);
        }
        uVar.d(bVar);
        tc.d(uVar);
        int iD = com.ss.android.socialbase.appdownloader.b.d(bVar.w());
        long jMb = bVar.mb();
        int iJs = jMb > 0 ? (int) ((bVar.js() * 100) / jMb) : 0;
        if ((jMb > 0 || com.ss.android.socialbase.downloader.uo.d.b().d("fix_click_start")) && (hcVar = this.u) != null) {
            hcVar.d(bVar);
            this.u = null;
        }
        for (com.ss.android.d.d.b.c cVar : d(map)) {
            if (iD != 1) {
                if (iD == 2) {
                    cVar.onDownloadPaused(uVar, tc.d(bVar.h(), iJs));
                } else if (iD == 3) {
                    if (bVar.w() == -4) {
                        cVar.d();
                    } else if (bVar.w() == -1) {
                        cVar.onDownloadFailed(uVar);
                    } else if (bVar.w() == -3) {
                        if (com.ss.android.downloadlib.h.uo.d(this.d.hc)) {
                            cVar.onInstalled(uVar);
                        } else {
                            cVar.onDownloadFinished(uVar);
                        }
                    }
                }
            } else if (bVar.w() != 11) {
                cVar.onDownloadActive(uVar, tc.d(bVar.h(), iJs));
            } else {
                Iterator<com.ss.android.d.d.b.u> it = hc(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    void b(com.ss.android.socialbase.downloader.h.b bVar) {
        if (!tt.d(this.d.hc) || this.b) {
            return;
        }
        com.ss.android.downloadlib.c.d.d().d("file_status", (bVar == null || !com.ss.android.downloadlib.h.uo.hc(bVar.k())) ? 2 : 1, this.d);
        this.b = true;
    }

    void d() {
        if (this.u == null) {
            this.u = new hc() { // from class: com.ss.android.downloadlib.addownload.gb.3
                @Override // com.ss.android.downloadlib.addownload.gb.hc
                public void d(com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
                    com.ss.android.downloadlib.c.d.d().d(gb.this.hc, 2, bVar);
                }
            };
        }
    }

    boolean c(com.ss.android.socialbase.downloader.h.b bVar) {
        return an() || u(bVar);
    }

    private boolean u(com.ss.android.socialbase.downloader.h.b bVar) {
        return !com.ss.android.downloadlib.h.uo.d(this.d.hc) && an(bVar);
    }

    private boolean an() {
        return com.ss.android.downloadlib.h.uo.d(this.d.hc) && tt.d(this.d.c.d());
    }

    private boolean an(com.ss.android.socialbase.downloader.h.b bVar) {
        return bVar != null && bVar.w() == -3 && com.ss.android.socialbase.downloader.e.an.c(bVar.mk(), bVar.gb());
    }

    int d(Context context, vv vvVar) {
        com.ss.android.socialbase.downloader.h.u uVarD;
        if (context == null) {
            return 0;
        }
        Map<String, String> mapTc = this.d.hc.tc();
        ArrayList arrayList = new ArrayList();
        if (mq.tt().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.d.hc.yi()) && (uVarD = d(this.d.hc.yi())) != null) {
            arrayList.add(uVarD);
        }
        if (mapTc != null) {
            for (Map.Entry<String, String> entry : mapTc.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.h.u(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strD = com.ss.android.downloadlib.h.c.d(String.valueOf(this.d.hc.c()), this.d.hc.b(), this.d.hc.mk(), String.valueOf(this.d.hc.us()));
        com.ss.android.socialbase.downloader.uo.d dVarHc = com.ss.android.downloadlib.h.u.hc(this.d.hc);
        JSONObject jSONObjectD = com.ss.android.downloadlib.h.u.d(this.d.hc);
        if (!this.d.c.e()) {
            jSONObjectD = com.ss.android.downloadlib.h.uo.d(jSONObjectD);
            com.ss.android.downloadlib.h.uo.d(jSONObjectD, "ah_plans", new JSONArray());
        }
        int iR = this.d.hc.r();
        if (this.d.hc.np() || tt.hc(this.d.hc)) {
            iR = 4;
        }
        String strD2 = d(dVarHc);
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(com.ss.android.socialbase.downloader.downloader.b.d(this.d.hc.d(), strD2));
        if (bVarGb != null && 3 == this.d.hc.us()) {
            bVarGb.tt(true);
        }
        com.ss.android.socialbase.appdownloader.an anVarE = new com.ss.android.socialbase.appdownloader.an(context, this.d.hc.d()).hc(this.d.hc.hc()).d(this.d.hc.gb()).u(strD).d(arrayList).d(this.d.hc.mq()).b(this.d.hc.uo()).hc(this.d.hc.cb()).b(strD2).mk(this.d.hc.vv()).gb(this.d.hc.u()).tc(this.d.hc.dc()).d(this.d.hc.an()).d(vvVar).mq(this.d.hc.sy() || dVarHc.d("need_independent_process", 0) == 1).d(this.d.hc.ba()).hc(this.d.hc.fs()).h(this.d.hc.he()).c(1000).u(100).d(jSONObjectD).tt(true).tc(true).hc(dVarHc.d("retry_count", 5)).b(dVarHc.d("backup_url_retry_count", 0)).tc(true).uo(dVarHc.d("need_head_connection", 0) == 1).c(dVarHc.d("need_https_to_http_retry", 0) == 1).gb(dVarHc.d("need_chunk_downgrade_retry", 1) == 1).h(dVarHc.d("need_retry_delay", 0) == 1).tt(dVarHc.b("retry_delay_time_array")).mk(dVarHc.d("need_reuse_runnable", 0) == 1).an(iR).cb(this.d.hc.tr()).e(this.d.hc.nv());
        if (!TextUtils.isEmpty(this.d.hc.tt())) {
            anVarE.an(this.d.hc.tt());
        } else {
            anVarE.an("application/vnd.android.package-archive");
        }
        if (dVarHc.d("notification_opt_2", 0) == 1) {
            anVarE.d(false);
            anVarE.hc(true);
        }
        com.ss.android.downloadlib.addownload.b.d dVar = null;
        if (dVarHc.d("clear_space_use_disk_handler", 0) == 1) {
            dVar = new com.ss.android.downloadlib.addownload.b.d();
            anVarE.d(dVar);
        }
        if ((this.d.hc instanceof com.ss.android.hc.d.d.b) && !TextUtils.isEmpty(((com.ss.android.hc.d.d.b) this.d.hc).wl())) {
            anVarE.c(((com.ss.android.hc.d.d.b) this.d.hc).wl());
        }
        int iD = tt.d(this.d, b(), anVarE);
        if (dVar != null) {
            dVar.d(iD);
        }
        return iD;
    }

    private String d(com.ss.android.socialbase.downloader.uo.d dVar) throws JSONException {
        boolean zHc;
        if (!TextUtils.isEmpty(this.d.hc.e())) {
            return this.d.hc.e();
        }
        com.ss.android.socialbase.downloader.h.b bVarD = com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext(), this.d.hc.d());
        if (!com.ss.android.downloadlib.h.uo.d()) {
            zHc = com.ss.android.downloadlib.h.tc.hc("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            zHc = com.ss.android.downloadlib.h.tc.hc("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.h.tc.hc(PermissionConfig.READ_MEDIA_AUDIO) || com.ss.android.downloadlib.h.tc.hc("android.permission.READ_MEDIA_VIDEO");
        }
        String strHc = hc();
        if (bVarD != null && !TextUtils.isEmpty(bVarD.mk())) {
            String strMk = bVarD.mk();
            if (zHc || strMk.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return strMk;
            }
            try {
                if (!TextUtils.isEmpty(strHc)) {
                    if (strMk.startsWith(strHc)) {
                        return strMk;
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc(bVarD.h());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zHc ? 1 : 2));
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.mq.d(e2);
        }
        com.ss.android.downloadlib.c.d.d().d("label_external_permission", jSONObject, this.d);
        String strHc2 = null;
        try {
            strHc2 = com.ss.android.socialbase.appdownloader.b.hc();
        } catch (Exception unused) {
        }
        int iD = com.ss.android.downloadlib.h.u.d(dVar);
        if (iD != 0) {
            if (iD == 4 || (!zHc && iD == 2)) {
                File filesDir = mq.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            } else if ((iD == 3 || (!zHc && iD == 1)) && !TextUtils.isEmpty(strHc)) {
                return strHc;
            }
        }
        return strHc2;
    }

    public String hc() {
        File externalFilesDir = mq.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    void d(com.ss.android.socialbase.downloader.h.b bVar, boolean z) {
        if (this.d.hc == null || bVar == null || bVar.h() == 0) {
            return;
        }
        int iW = bVar.w();
        if (iW == -1 || iW == -4 || tt.d(this.d.hc) || (z && com.ss.android.downloadlib.c.b.d().b() && (iW == -2 || iW == -3))) {
            com.ss.android.downloadlib.c.d.d().d(this.hc, 2);
        }
        switch (iW) {
            case -4:
            case -1:
                d();
                com.ss.android.downloadlib.addownload.hc.an.d().d(new com.ss.android.hc.d.hc.hc(this.d.hc, this.d.b, this.d.c, bVar.h()));
                break;
            case -3:
                if (com.ss.android.downloadlib.h.uo.d(this.d.hc)) {
                    com.ss.android.downloadlib.u.b.d().hc("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.c.d.d().d(this.hc, 5, bVar);
                    if (z && com.ss.android.downloadlib.c.b.d().hc() && !com.ss.android.downloadlib.c.b.d().hc(this.hc, this.d.hc.yi())) {
                        com.ss.android.downloadlib.c.d.d().d(this.hc, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.c.d.d().d(this.hc, 4, bVar);
                if (z && com.ss.android.downloadlib.c.b.d().hc() && !com.ss.android.downloadlib.c.b.d().hc(this.hc, this.d.hc.yi())) {
                    com.ss.android.downloadlib.c.d.d().d(this.hc, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.c.d.d().d(this.hc, 3, bVar);
                break;
        }
    }

    void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.d.d.u.u uVar, List<com.ss.android.d.d.b.c> list, boolean z) {
        if (list.isEmpty()) {
            return;
        }
        if (bVar == null || uVar == null) {
            Iterator<com.ss.android.d.d.b.c> it = list.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            return;
        }
        try {
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        int iJs = bVar.mb() > 0 ? (int) ((bVar.js() * 100) / bVar.mb()) : 0;
        int i = iJs >= 0 ? iJs : 0;
        uVar.d(bVar);
        tc.d(uVar);
        for (com.ss.android.d.d.b.c cVar : list) {
            switch (bVar.w()) {
                case -4:
                case 0:
                    if (com.ss.android.downloadlib.h.uo.d(this.d.hc)) {
                        uVar.hc = -3;
                        cVar.onInstalled(uVar);
                        break;
                    } else {
                        cVar.d();
                        break;
                    }
                case -3:
                    if (z) {
                        cVar.onInstalled(uVar);
                        break;
                    } else {
                        cVar.onDownloadFinished(uVar);
                        break;
                    }
                case -2:
                    cVar.onDownloadPaused(uVar, tc.d(bVar.h(), i));
                    break;
                case -1:
                    cVar.onDownloadFailed(uVar);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    cVar.onDownloadActive(uVar, tc.d(bVar.h(), i));
                    break;
                case 11:
                    if (cVar instanceof com.ss.android.d.d.b.u) {
                        break;
                    } else {
                        cVar.onDownloadActive(uVar, tc.d(bVar.h(), i));
                        break;
                    }
            }
        }
    }

    static class d extends com.ss.android.socialbase.downloader.c.d {
        private com.ss.android.downloadlib.h.k d;

        d(com.ss.android.downloadlib.h.k kVar) {
            this.d = kVar;
        }

        @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
        public void d(com.ss.android.socialbase.downloader.h.b bVar) {
            d(bVar, 1);
        }

        @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
        public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
            d(bVar, 2);
        }

        @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
        public void b(com.ss.android.socialbase.downloader.h.b bVar) {
            d(bVar, 4);
        }

        @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
        public void c(com.ss.android.socialbase.downloader.h.b bVar) {
            d(bVar, -2);
        }

        @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
        public void u(com.ss.android.socialbase.downloader.h.b bVar) {
            d(bVar, -3);
        }

        @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
        public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar) {
            d(bVar, -1);
        }

        @Override // com.ss.android.socialbase.downloader.c.b, com.ss.android.socialbase.downloader.c.vv
        public void an(com.ss.android.socialbase.downloader.h.b bVar) {
            d(bVar, -4);
        }

        @Override // com.ss.android.socialbase.downloader.c.d, com.ss.android.socialbase.downloader.c.jh
        public void h(com.ss.android.socialbase.downloader.h.b bVar) {
            d(bVar, 11);
        }

        private void d(com.ss.android.socialbase.downloader.h.b bVar, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = bVar;
            messageObtain.arg1 = i;
            this.d.sendMessage(messageObtain);
        }
    }

    public static List<com.ss.android.d.d.b.c> d(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.d.d.b.c) {
                    arrayList.add((com.ss.android.d.d.b.c) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.d.d.b.c) {
                            arrayList.add((com.ss.android.d.d.b.c) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.d.d.b.c) {
                            arrayList.add((com.ss.android.d.d.b.c) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<com.ss.android.d.d.b.u> hc(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.d.d.b.u) {
                    arrayList.add((com.ss.android.d.d.b.u) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.d.d.b.u) {
                            arrayList.add((com.ss.android.d.d.b.u) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.d.d.b.u) {
                            arrayList.add((com.ss.android.d.d.b.u) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.h.u d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.h.u("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            mq.jh().d(e, "parseLogExtra Error");
            return null;
        }
    }
}
