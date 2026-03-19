package com.ss.texturerender.effect;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import com.kuaishou.socket.nano.SocketMessages;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLWatermarkFilter extends GLDefaultFilter {
    private static final String LOG_TAG = "TR_GLWatermarkFilter";
    private final String fragmentDefaultShader;
    private Bitmap mBitmap;
    private EffectTexture mTexture;
    private int mVideoStyle;
    private int mVideoStyleLoc;

    public GLWatermarkFilter(int i) {
        super(i, 17);
        this.fragmentDefaultShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform int videoStyle;\nvoid main() {\n  vec2 uv = vTextureCoord;\n  if(videoStyle == 3) {\n    if (uv.y <= 0.5) {\n      uv.y = uv.y * 2.0;\n    } else {\n      uv.y = (uv.y - 0.5) * 2.0;\n    }\n  } else if(videoStyle == 4) {\n    if (uv.x <= 0.5) {\n      uv.x = uv.x * 2.0;\n    } else {\n      uv.x = (uv.x - 0.5) * 2.0;\n    }\n  }\n  gl_FragColor = texture2D(sTexture, uv);\n}\n";
        this.mVideoStyle = 2;
        this.mVideoStyleLoc = -1;
        this.mOrder = 8;
        TextureRenderLog.d(this.mTexType, LOG_TAG, "new GLWatermarkFilter,this:" + this);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        Bitmap bitmap;
        if (super.init(bundle) != 0) {
            return -1;
        }
        this.mVideoStyleLoc = GLES20.glGetUniformLocation(this.mProgram, "videoStyle");
        this.mVideoStyle = bundle.getInt(TextureRenderKeys.KEY_IS_VIDEO_STYLE, 2);
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_WATERMARK_BITMAP) && (bitmap = (Bitmap) bundle.getParcelable(TextureRenderKeys.KEY_IS_WATERMARK_BITMAP)) != null) {
            getFlipBitmap(bitmap);
        }
        this.mNeedClear = false;
        TextureRenderLog.d(this.mTexType, LOG_TAG, "GLWatermarkFilter init,this:" + this);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        if (frameBuffer != null && effectTexture != null) {
            frameBuffer.bindTexture2D(effectTexture.getTexID());
        }
        this.mViewPortWidth = effectTexture.getWidth();
        this.mViewPortHeight = effectTexture.getHeight();
        if (this.mTexture == null) {
            this.mTexture = new EffectTexture((EffectTextureManager) null, TexGLUtils.genTexture(3553), 0, 0, 3553);
        }
        super.process(this.mTexture, null);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmap = null;
        }
        if (frameBuffer != null) {
            frameBuffer.unbindTexture2D();
        }
        return effectTexture;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, SocketMessages.PayloadType.SC_LIVE_GIFT_OUTSIDE_MESSAGE);
        GLES20.glUniform1i(this.mVideoStyleLoc, this.mVideoStyle);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        GLES20.glDisable(3042);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        return i != 11001 ? super.getStringOption(i) : "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform int videoStyle;\nvoid main() {\n  vec2 uv = vTextureCoord;\n  if(videoStyle == 3) {\n    if (uv.y <= 0.5) {\n      uv.y = uv.y * 2.0;\n    } else {\n      uv.y = (uv.y - 0.5) * 2.0;\n    }\n  } else if(videoStyle == 4) {\n    if (uv.x <= 0.5) {\n      uv.x = uv.x * 2.0;\n    } else {\n      uv.x = (uv.x - 0.5) * 2.0;\n    }\n  }\n  gl_FragColor = texture2D(sTexture, uv);\n}\n";
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle bundle) {
        if (bundle != null && this.mEffectType == bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE)) {
            TextureRenderLog.d(this.mTexType, LOG_TAG, "setOption:" + bundle.toString() + ",this:" + this);
            if (bundle.getInt("action") != 22) {
                return;
            }
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            getFlipBitmap((Bitmap) bundle.getParcelable(TextureRenderKeys.KEY_IS_WATERMARK_BITMAP));
            return;
        }
        super.setOption(bundle);
    }

    private void getFlipBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f);
        this.mBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        EffectTexture effectTexture = this.mTexture;
        if (effectTexture != null) {
            TexGLUtils.deleteTexture(effectTexture.getTexID());
        }
        return super.release();
    }
}
