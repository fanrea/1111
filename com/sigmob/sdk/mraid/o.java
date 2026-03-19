package com.sigmob.sdk.mraid;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.mraid.j;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class o extends j implements j.a, com.sigmob.sdk.videocache.d {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 4;
    public static final int l = 8;
    private m m;
    private String n;
    private a o;

    /* renamed from: com.sigmob.sdk.mraid.o$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.sigmob.sdk.videoplayer.d.values().length];
            a = iArr;
            try {
                iArr[com.sigmob.sdk.videoplayer.d.STATE_PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_AUTO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_PREPARING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_BUFFERING_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.sigmob.sdk.videoplayer.d.STATE_STOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public interface a {
        void a(String uniqueId, int state);

        void a(String uniqueId, int code, String message);

        void a(String uniqueId, long position);

        void a(String uniqueId, long duration, int width, int height);

        void a(String uniqueId, long position, long duration);

        void b(String uniqueId, int state);
    }

    public o(String uniqueId) {
        super(uniqueId);
    }

    private void a(String uniqueId, String url) {
        Uri uri = Uri.parse(url);
        if (uri != null && "127.0.0.1".equalsIgnoreCase(uri.getHost())) {
            Pattern patternCompile = Pattern.compile("/(.*)");
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return;
            }
            Matcher matcher = patternCompile.matcher(path);
            if (matcher.find()) {
                this.n = matcher.group(1);
                com.sigmob.sdk.base.common.g.d().a(this, this.n);
            }
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void a(Context context, JSONObject args) {
        m mVar = new m(context);
        this.m = mVar;
        mVar.setVideoPlayerStatusListener(new com.sigmob.sdk.videoplayer.k() { // from class: com.sigmob.sdk.mraid.o.1
            @Override // com.sigmob.sdk.videoplayer.k
            public void a(long position, long duration) {
                if (o.this.o == null) {
                    return;
                }
                o.this.o.a(o.this.a, position, duration);
            }

            @Override // com.sigmob.sdk.videoplayer.k
            public void a(com.sigmob.sdk.videoplayer.d state) {
                a aVar;
                String str;
                SigmobLog.d("VIDEO_PLAYER_STATE change: " + state);
                int i2 = 1;
                switch (AnonymousClass2.a[state.ordinal()]) {
                    case 1:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, o.this.m.getDuration(), o.this.m.getVideoWidth(), o.this.m.getVideoHeight());
                        }
                        if (o.this.o != null) {
                            o.this.o.b(o.this.a, 2);
                        }
                        if (o.this.o != null) {
                            o.this.o.b(o.this.a, 4);
                            return;
                        }
                        return;
                    case 2:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, o.this.m.getErrorCode(), o.this.m.getErrorMessage());
                            return;
                        }
                        return;
                    case 3:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, 2);
                            return;
                        }
                        return;
                    case 4:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, 1);
                            return;
                        }
                        return;
                    case 5:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, o.this.m.getDuration(), o.this.m.getDuration());
                            o.this.o.a(o.this.a, o.this.m.getDuration());
                            return;
                        }
                        return;
                    case 6:
                        if (o.this.o != null) {
                            aVar = o.this.o;
                            str = o.this.a;
                            break;
                        } else {
                            return;
                        }
                    case 7:
                        if (o.this.o != null) {
                            o.this.m.j();
                            aVar = o.this.o;
                            str = o.this.a;
                            i2 = 8;
                            break;
                        } else {
                            return;
                        }
                    case 8:
                        if (o.this.o != null) {
                            o.this.m.d();
                            o.this.o.b(o.this.a, 2);
                            return;
                        }
                        return;
                    case 9:
                        if (o.this.o != null) {
                            o.this.o.a(o.this.a, 4);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                aVar.b(str, i2);
            }
        });
    }

    public void a(a mraidVpaidListener) {
        this.o = mraidVpaidListener;
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(File cacheFile, String url, int percentsAvailable) {
    }

    @Override // com.sigmob.sdk.videocache.d
    public void a(String url, Throwable throwable) {
        SigmobLog.e("url", throwable);
        a aVar = this.o;
        if (aVar == null) {
            return;
        }
        aVar.a(this.a, 0, throwable.getMessage());
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void a(JSONObject args) {
        if (this.m == null) {
            return;
        }
        String strOptString = args.optString("URL");
        if (args.optBoolean(com.baidu.mobads.container.w.g.c.t, false) && !TextUtils.isEmpty(strOptString) && strOptString.startsWith(com.alipay.sdk.m.l.a.r)) {
            Uri uri = Uri.parse(strOptString);
            if (uri != null && !"127.0.0.1".equalsIgnoreCase(uri.getHost())) {
                strOptString = com.sigmob.sdk.base.common.g.d().a(strOptString);
            }
            a(this.a, strOptString);
        }
        this.m.setUp(strOptString);
        this.m.n();
    }

    @Override // com.sigmob.sdk.mraid.j
    public View b() {
        return this.m;
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void b(JSONObject args) {
        m mVar = this.m;
        if (mVar == null) {
            return;
        }
        mVar.d();
    }

    @Override // com.sigmob.sdk.mraid.j
    public void c() {
        m mVar = this.m;
        if (mVar != null) {
            com.sigmob.sdk.base.utils.o.a(mVar);
            this.m.removeAllViews();
            this.m.r();
            this.m = null;
        }
        if (this.n != null) {
            com.sigmob.sdk.base.common.g.d().b(this, this.n);
        }
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void c(JSONObject args) {
        m mVar = this.m;
        if (mVar == null) {
            return;
        }
        mVar.a(0);
        this.m.d();
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void d(JSONObject args) {
        m mVar = this.m;
        if (mVar == null) {
            return;
        }
        mVar.j();
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void e(JSONObject args) {
        m mVar = this.m;
        if (mVar == null) {
            return;
        }
        mVar.i();
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void f(JSONObject args) {
        if (this.m == null) {
            return;
        }
        this.m.setMute(args.optBoolean("muted", false));
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void g(JSONObject args) {
        if (this.m == null) {
            return;
        }
        this.m.a(((int) args.optDouble("seekTime", 0.0d)) * 1000);
    }

    @Override // com.sigmob.sdk.mraid.j.a
    public void h(JSONObject args) {
        JSONObject jSONObjectOptJSONObject;
        if (this.m == null || args == null || (jSONObjectOptJSONObject = args.optJSONObject(TypedValues.AttributesType.S_FRAME)) == null) {
            return;
        }
        Context contextE = com.sigmob.sdk.b.e();
        int iOptDouble = (int) jSONObjectOptJSONObject.optDouble("x", 0.0d);
        int iOptDouble2 = (int) jSONObjectOptJSONObject.optDouble("y", 0.0d);
        int iOptDouble3 = (int) jSONObjectOptJSONObject.optDouble("w", -1.0d);
        int iOptDouble4 = (int) jSONObjectOptJSONObject.optDouble("h", -1.0d);
        if (iOptDouble3 > 0) {
            iOptDouble3 = Dips.dipsToIntPixels(iOptDouble3, contextE);
        }
        if (iOptDouble4 > 0) {
            iOptDouble4 = Dips.dipsToIntPixels(iOptDouble4, contextE);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iOptDouble3, iOptDouble4);
        this.m.setX(Dips.dipsToIntPixels(iOptDouble, contextE));
        this.m.setY(Dips.dipsToIntPixels(iOptDouble2, contextE));
        this.m.setLayoutParams(layoutParams);
        this.m.requestLayout();
    }
}
