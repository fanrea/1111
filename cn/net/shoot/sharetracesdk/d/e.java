package cn.net.shoot.sharetracesdk.d;

import android.content.Context;
import android.opengl.GLSurfaceView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e extends GLSurfaceView {
    public f a;

    public e(Context context) {
        super(context);
        setEGLContextClientVersion(1);
        setEGLConfigChooser(8, 8, 8, 8, 0, 0);
        f fVar = new f();
        this.a = fVar;
        setRenderer(fVar);
    }
}
