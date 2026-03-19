package com.bykv.vk.component.ttvideo.log;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f {
    public long a = -2147483648L;
    public long b = -2147483648L;
    public long c = -2147483648L;
    public long d = -2147483648L;
    public long e = -2147483648L;
    public long f = -2147483648L;
    public int g = Integer.MIN_VALUE;
    public int h = Integer.MIN_VALUE;
    public int i = Integer.MIN_VALUE;
    public int j = Integer.MIN_VALUE;
    public String k = "";
    public String l = "";
    public int m = Integer.MIN_VALUE;
    public String n = "";
    public String o = "";
    public String p = "";

    public static void a(Map map, String str, int i) {
        if (i != Integer.MIN_VALUE) {
            map.put(str, Integer.valueOf(i));
        }
    }

    public static void a(Map map, String str, long j) {
        if (j != -2147483648L) {
            map.put(str, Long.valueOf(j));
        }
    }

    public static void a(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    public JSONObject a(c cVar) {
        if (cVar == null) {
            return null;
        }
        HashMap map = new HashMap();
        a(map, "player_sessionid", this.n);
        a(map, "log_type", "video_playq");
        a(map, "sdk_version", cVar.e);
        a(map, "sv", cVar.d);
        a(map, "pc", cVar.c);
        a(map, Config.PLATFORM_TYPE, this.c);
        a(map, "vt", this.d);
        a(map, "et", this.e);
        a(map, "lt", this.f);
        a((Map) map, "bc", this.g);
        a((Map) map, "br", this.h);
        a((Map) map, "vd", cVar.h);
        a(map, "initial_url", this.k);
        a(map, "init_audio_url", this.l);
        a((Map) map, "watch_dur", this.m);
        a((Map) map, "errt", this.i);
        a((Map) map, "errc", this.j);
        a(map, "ps_t", this.a);
        a(map, "pt_new", this.b);
        a(map, "play_log_id", this.o);
        a(map, "last_sessionid", this.p);
        return new JSONObject(map);
    }
}
