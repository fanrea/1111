package ca.da.ca.ja;

import com.apm.applog.UriConfig;

/* compiled from: UriConstants.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class s {
    public static int a;
    public static final UriConfig b;

    static {
        new UriConfig.Builder().setRegisterUri("https://log.snssdk.com/apm/device_register").setActiveUri("https://ichannel.snssdk.com/service/2/app_alert_check/").setSendUris(new String[]{"https://log.snssdk.com/monitor/collect/c/session", "https://applog.snssdk.com/monitor/collect/c/session"}).setRealUris(new String[]{"https://rtlog.snssdk.com/monitor/collect/c/session", "https://rtapplog.snssdk.com/monitor/collect/c/session"}).setSettingUri("https://log.snssdk.com/service/2/log_settings/").setALinkAttributionUri("https://toblog-alink.ctobsnssdk.com/service/2/attribution_data").setALinkQueryUri("https://toblog-alink.ctobsnssdk.com/service/2/alink_data").build();
        b = new UriConfig.Builder().setRegisterUri("https://apmplus.volces.com/apm/device_register").setSendUris(new String[]{"https://apmplus.volces.com/monitor/collect/c/session"}).build();
    }
}
