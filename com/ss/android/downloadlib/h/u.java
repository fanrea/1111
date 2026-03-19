package com.ss.android.downloadlib.h;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    public static JSONObject d() {
        return com.ss.android.downloadlib.addownload.mq.tt().optJSONObject("ad");
    }

    public static JSONObject d(com.ss.android.d.d.b.b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.np() ? uo.d(com.ss.android.downloadlib.addownload.mq.tt(), bVar.yo()) : bVar.yo();
    }

    public static com.ss.android.socialbase.downloader.uo.d hc(com.ss.android.d.d.b.b bVar) {
        return com.ss.android.socialbase.downloader.uo.d.d(d(bVar));
    }

    public static com.ss.android.socialbase.downloader.uo.d d(com.ss.android.hc.d.hc.d dVar) {
        if (dVar == null) {
            return com.ss.android.socialbase.downloader.uo.d.b();
        }
        if (dVar.rf() != 0) {
            return com.ss.android.socialbase.downloader.uo.d.d(dVar.rf());
        }
        if (dVar.b()) {
            return com.ss.android.socialbase.downloader.uo.d.d(d());
        }
        if (dVar.yo() != null) {
            return com.ss.android.socialbase.downloader.uo.d.d(dVar.yo());
        }
        return com.ss.android.socialbase.downloader.uo.d.b();
    }

    public static int d(com.ss.android.socialbase.downloader.uo.d dVar) {
        return dVar.d("external_storage_permission_path_type", 0);
    }

    public static int b(com.ss.android.d.d.b.b bVar) {
        return d(hc(bVar));
    }

    public static boolean hc(com.ss.android.hc.d.hc.d dVar) {
        return d(dVar).d("pause_reserve_on_wifi", 0) == 1 && dVar.w();
    }

    public static boolean b(com.ss.android.hc.d.hc.d dVar) {
        return d(dVar).d("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && dVar.w();
    }

    public static double d(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("clean_min_install_size", 0.0d);
    }

    public static long hc(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("storage_min_size", 0L);
    }

    public static long b(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean c(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean u(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean an(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("clean_space_switch", 0) == 1;
    }

    public static boolean h(int i) {
        return com.ss.android.socialbase.downloader.uo.d.d(i).d("clean_app_cache_dir", 0) == 1;
    }

    public static boolean hc(com.ss.android.socialbase.downloader.uo.d dVar) {
        return dVar != null && dVar.d("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean hc() {
        return com.ss.android.socialbase.downloader.uo.d.b().d("fix_notification_anr");
    }

    public static boolean b() {
        return com.ss.android.downloadlib.addownload.mq.tt().optInt("is_enable_start_install_again") == 1;
    }

    public static long c() {
        long jOptLong = com.ss.android.downloadlib.addownload.mq.tt().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static long u() {
        long jOptLong = com.ss.android.downloadlib.addownload.mq.tt().optLong("next_install_min_interval");
        return jOptLong == 0 ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : jOptLong;
    }

    public static int d(com.ss.android.hc.d.hc.hc hcVar) {
        return d((com.ss.android.hc.d.hc.d) hcVar).d("ttdownloader_app_install_detect_count", 15);
    }

    public static int hc(com.ss.android.hc.d.hc.hc hcVar) {
        return d((com.ss.android.hc.d.hc.d) hcVar).d("ttdownloader_app_install_detect_interval_ms", 20000);
    }

    public static boolean b(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.addownload.mq.tt().optInt("market_install_finish_opt_switch", 0) == 1 || d((com.ss.android.hc.d.hc.d) hcVar).d("market_install_finish_opt_switch", 0) == 1;
    }

    public static boolean c(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.addownload.mq.tt().optInt("market_install_finish_opt_broadcast", 0) == 1 || d((com.ss.android.hc.d.hc.d) hcVar).d("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean u(com.ss.android.hc.d.hc.hc hcVar) {
        return com.ss.android.downloadlib.addownload.mq.tt().optInt("market_install_finish_opt_polling_thread", 0) == 1 || d((com.ss.android.hc.d.hc.d) hcVar).d("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static int an(com.ss.android.hc.d.hc.hc hcVar) {
        return d((com.ss.android.hc.d.hc.d) hcVar).d("app_install_keep_receiver_time_s", 60);
    }

    public static long h(com.ss.android.hc.d.hc.hc hcVar) {
        return d((com.ss.android.hc.d.hc.d) hcVar).d("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }
}
