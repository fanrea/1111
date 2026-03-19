package com.ss.texturerender.effect;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Bundle;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLLutFilter extends GLDefaultFilter {
    private static final String LOG_TAG = "TR_GLLutFilter";
    private final String fragmentShader;
    private int mCurrentIndex;
    private int mLutTextureHandle;
    private HashMap<Integer, LutTextureNode> mLutTextureMap;
    private int mStrengthHandle;

    private class LutTextureNode {
        public float strength;
        public int texID;
        public boolean using;

        public LutTextureNode(int i, float f, boolean z) {
            this.texID = i;
            this.using = z;
            this.strength = f;
        }

        public String toString() {
            return "[texID:" + this.texID + ",strength:" + this.strength + ",using:" + this.using + "]";
        }
    }

    public GLLutFilter(int i) {
        super(i, 2);
        this.fragmentShader = "precision mediump float;\nuniform sampler2D sTexture;\nuniform sampler2D lutTexture;\nvarying vec2 vTextureCoord;\nuniform float strength;\nvoid main() {\n    vec4 inputTexColor = texture2D(sTexture, vTextureCoord);\n    float blueColor = inputTexColor.b * 63.0;\n    vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 7.999);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    vec2 texturePos1;\n    texturePos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec2 texturePos2;\n    texturePos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec4 newColor1 = texture2D(lutTexture, texturePos1);\n    vec4 newColor2 = texture2D(lutTexture, texturePos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    gl_FragColor = mix(inputTexColor, vec4(newColor.rgb, inputTexColor.w), strength);\n}";
        this.mLutTextureMap = new HashMap<>();
        this.mOrder = 15;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new GLLutFilter,this:" + this);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        HashMap map;
        if (super.init(bundle) != 0) {
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(10, this.mEffectType, "super.init(bundle) != TR_OK");
            }
            return -1;
        }
        this.mStrengthHandle = GLES20.glGetUniformLocation(this.mProgram, TextureRenderKeys.KEY_IS_STRENGTH_FLOAT);
        this.mLutTextureHandle = GLES20.glGetUniformLocation(this.mProgram, "lutTexture");
        disableAllTextureNode();
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_LUT_BITMAP)) {
            if (((Bitmap) bundle.getParcelable(TextureRenderKeys.KEY_IS_LUT_BITMAP)) != null) {
                addTextureNode(0, (Bitmap) bundle.getParcelable(TextureRenderKeys.KEY_IS_LUT_BITMAP));
            }
        } else if (bundle.containsKey(TextureRenderKeys.KEY_IS_LUT_BITMAP_MULTI)) {
            HashMap map2 = (HashMap) bundle.getSerializable(TextureRenderKeys.KEY_IS_LUT_BITMAP_MULTI);
            if (map2 != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    addTextureNode(((Integer) entry.getKey()).intValue(), (Bitmap) entry.getValue());
                }
            }
        } else {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "init no bitmap,this:" + this);
            return -1;
        }
        removeExtraTextureNode();
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT)) {
            setAllLutStrength(bundle.getFloat(TextureRenderKeys.KEY_IS_STRENGTH_FLOAT));
        } else if (bundle.containsKey(TextureRenderKeys.KEY_IS_STRENGTH_MULTI_FLOAT) && (map = (HashMap) bundle.getSerializable(TextureRenderKeys.KEY_IS_STRENGTH_MULTI_FLOAT)) != null) {
            for (Map.Entry entry2 : map.entrySet()) {
                setLutStrength(((Integer) entry2.getKey()).intValue(), ((Float) entry2.getValue()).floatValue());
            }
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "init:" + bundle.toString() + ",this:" + this + " LutMap:" + this.mLutTextureMap);
        return 0;
    }

    private void disableAllTextureNode() {
        Iterator<LutTextureNode> it = this.mLutTextureMap.values().iterator();
        while (it.hasNext()) {
            it.next().using = false;
        }
    }

    private void addTextureNode(int i, Bitmap bitmap) {
        LutTextureNode lutTextureNode = this.mLutTextureMap.get(Integer.valueOf(i));
        if (lutTextureNode == null) {
            for (Map.Entry<Integer, LutTextureNode> entry : this.mLutTextureMap.entrySet()) {
                LutTextureNode value = entry.getValue();
                if (!value.using) {
                    this.mLutTextureMap.remove(entry.getKey());
                    this.mLutTextureMap.put(Integer.valueOf(i), value);
                    setBitmap(value.texID, bitmap);
                    return;
                }
            }
            LutTextureNode lutTextureNode2 = new LutTextureNode(TexGLUtils.genTexture(3553), 1.0f, true);
            setBitmap(lutTextureNode2.texID, bitmap);
            this.mLutTextureMap.put(Integer.valueOf(i), lutTextureNode2);
            return;
        }
        setBitmap(lutTextureNode.texID, bitmap);
        lutTextureNode.using = true;
    }

    private void removeExtraTextureNode() {
        Iterator<Map.Entry<Integer, LutTextureNode>> it = this.mLutTextureMap.entrySet().iterator();
        while (it.hasNext()) {
            LutTextureNode value = it.next().getValue();
            if (!value.using) {
                TexGLUtils.deleteTexture(value.texID);
                it.remove();
            }
        }
    }

    private void setLutStrength(int i, float f) {
        LutTextureNode lutTextureNode;
        if (f < 0.0f || f > 1.0f || (lutTextureNode = this.mLutTextureMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        lutTextureNode.strength = f;
    }

    private void setAllLutStrength(float f) {
        if (f < 0.0f || f > 1.0f) {
            return;
        }
        Iterator<LutTextureNode> it = this.mLutTextureMap.values().iterator();
        while (it.hasNext()) {
            it.next().strength = f;
        }
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        }
        int i = 0;
        while (true) {
            this.mCurrentIndex = i;
            if (this.mCurrentIndex >= this.mLutTextureMap.size()) {
                break;
            }
            LutTextureNode lutTextureNode = this.mLutTextureMap.get(Integer.valueOf(this.mCurrentIndex));
            if (lutTextureNode != null && lutTextureNode.strength > 0.0f) {
                effectTexture = super.process(effectTexture, frameBuffer);
            }
            i = this.mCurrentIndex + 1;
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        }
        return effectTexture;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        LutTextureNode lutTextureNode = this.mLutTextureMap.get(Integer.valueOf(this.mCurrentIndex));
        if (lutTextureNode == null) {
            return -1;
        }
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, lutTextureNode.texID);
        GLES20.glUniform1i(this.mLutTextureHandle, 1);
        GLES20.glUniform1f(this.mStrengthHandle, lutTextureNode.strength);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, float f) {
        if (i == 20) {
            setAllLutStrength(f);
            TextureRenderLog.i(this.mTexType, LOG_TAG, "set strength:" + f + ",this:" + this);
        } else {
            super.setOption(i, f);
        }
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle bundle) {
        if (bundle != null && this.mEffectType == bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE)) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "setOption:" + bundle.toString() + ",this:" + this);
            int i = bundle.getInt("action");
            if (i != 20) {
                if (i == 22 && !this.mLutTextureMap.isEmpty()) {
                    Bitmap bitmap = (Bitmap) bundle.getParcelable(TextureRenderKeys.KEY_IS_LUT_BITMAP);
                    if (bundle.containsKey("index")) {
                        LutTextureNode lutTextureNode = this.mLutTextureMap.get(Integer.valueOf(bundle.getInt("index")));
                        if (lutTextureNode != null) {
                            setBitmap(lutTextureNode.texID, bitmap);
                            return;
                        }
                        return;
                    }
                    LutTextureNode lutTextureNode2 = this.mLutTextureMap.get(0);
                    if (lutTextureNode2 != null) {
                        setBitmap(lutTextureNode2.texID, bitmap);
                        return;
                    }
                    return;
                }
                return;
            }
            if (bundle.containsKey("index")) {
                setLutStrength(bundle.getInt("index", 0), bundle.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, -1.0f));
                return;
            } else {
                setAllLutStrength(bundle.getFloat(TextureRenderKeys.KEY_IS_FLOAT_VALUE, -1.0f));
                return;
            }
        }
        super.setOption(bundle);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        return i != 11001 ? super.getStringOption(i) : "precision mediump float;\nuniform sampler2D sTexture;\nuniform sampler2D lutTexture;\nvarying vec2 vTextureCoord;\nuniform float strength;\nvoid main() {\n    vec4 inputTexColor = texture2D(sTexture, vTextureCoord);\n    float blueColor = inputTexColor.b * 63.0;\n    vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 7.999);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    vec2 texturePos1;\n    texturePos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec2 texturePos2;\n    texturePos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.r);\n    texturePos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputTexColor.g);\n    vec4 newColor1 = texture2D(lutTexture, texturePos1);\n    vec4 newColor2 = texture2D(lutTexture, texturePos2);\n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    gl_FragColor = mix(inputTexColor, vec4(newColor.rgb, inputTexColor.w), strength);\n}";
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        disableAllTextureNode();
        removeExtraTextureNode();
        TextureRenderLog.i(this.mTexType, LOG_TAG, "release,this:" + this);
        return super.release();
    }

    public void setBitmap(int i, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GLES20.glBindTexture(3553, i);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setBitmap:" + bitmap + ",this:" + this);
    }
}
