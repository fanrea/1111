package cn.net.shoot.sharetracesdk.d;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f implements GLSurfaceView.Renderer {
    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        cn.net.shoot.sharetracesdk.a.a.a("glr", gl10.glGetString(7937));
        cn.net.shoot.sharetracesdk.a.a.a("glv", gl10.glGetString(7936));
        String str = "get gl config complete . renderer=" + gl10.glGetString(7937);
        d dVarB = d.b();
        dVarB.getClass();
        try {
            if (dVarB.a.getCount() > 0) {
                dVarB.a.countDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
