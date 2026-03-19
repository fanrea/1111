package com.ss.texturerender.effect.vr;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Bundle;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.math.Quaternion;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLPanorama180To360Filter extends GLPanoramaFilter {
    private static final String LOG_TAG = "GLPanorama180To360Filter";
    private final String fragment180to360Shader;
    private int mBackgroundTexHandle;
    private int mBackgroundTexScaleHandle;
    private int mContentTypeOffsetHandle;
    private int mEacExpandCoefHandle;
    private int mGlBackgroundTexture;
    private int mInputBackTexSizeHandle;
    private int mInputTexOffsetHandle;
    private int mInputTexScaleHandle;
    private int mInputTexSizeHandle;
    private int mShaderTypeHandle;

    public GLPanorama180To360Filter(int i) {
        super(i, 12);
        this.fragment180to360Shader = "precision highp float;\n\n#define PI 3.14159265359\nuniform sampler2D sTexture;\nuniform sampler2D sBackground;\nuniform float sTextureSize;\nuniform float sBackTextureSize;\nuniform float scaleU;\nuniform float scaleV;\nuniform float offsetU;\nuniform float offsetT;\nuniform float expandCoef;\nuniform int shaderType;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\n\nvec4 vrTextureFragmentForVirtualLive() {\n    vec4 outputColor = texture2D(sBackground, vec2(vTextureCoord.x, 1.0 - vTextureCoord.y));\n    if (verPosition.z < 0.0 && abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n        vec2 st = vec2(verPosition.x / (verPosition.z * 2.0) + 0.5, verPosition.y / (verPosition.z * 2.0) + 0.5);\n        st = vec2(1.0, 1.0) - st;\n        outputColor = texture2D(sTexture, st);\n    }\n    return outputColor;\n}\n\nvec4 vrTextureFragmentFor180eac() {\n    vec4 colMain;\n    if (verPosition.z < 0.0) {\n       vec2 st;\n       float padding = 1.0/expandCoef;\n       if (abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n           st = vec2((2.0*(0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.z)) + 0.5) + 3.0)/6.0, 0.5*(4.0/PI*atan(padding * verPosition.y / verPosition.z)) + 0.5);\n           st = vec2(1.0, 1.0) - st;\n       } else if ( verPosition.x < 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.x > 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0 + 4.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.y < 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       } else if (verPosition.y > 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       }\n       colMain = texture2D(sTexture, st);\n    }\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvec4 vrTextureFragmentForGeneralUse() {\n    vec2 uvMain = vTextureCoord;\n    if (offsetT == 0.0  && offsetU ==  0.25) {\n       uvMain.x = (uvMain.x - offsetU) * 2.0;\n    } else {\n       uvMain.x = (uvMain.x - offsetU) * scaleU;\n    }\n    vec4 colMain = texture2D(sTexture, uvMain);\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvoid main()\n{\n    if (shaderType == 1) {\n        gl_FragColor = vrTextureFragmentForVirtualLive();\n    } else if (shaderType == 2) {\n        gl_FragColor = vrTextureFragmentFor180eac();\n    } else {\n        gl_FragColor = vrTextureFragmentForGeneralUse();\n    }\n}\n";
        this.mGlBackgroundTexture = 0;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new GLPanoramaFilter,this:" + this);
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        if (super.init(bundle) != 0) {
            if (this.mSurfaceTexture == null) {
                return -1;
            }
            this.mSurfaceTexture.notifyError(10, this.mEffectType, "super.init(bundle) != TR_OK");
            return -1;
        }
        this.mBackgroundTexHandle = GLES20.glGetUniformLocation(this.mProgram, "sBackground");
        this.mInputTexSizeHandle = GLES20.glGetUniformLocation(this.mProgram, "sTextureSize");
        this.mInputBackTexSizeHandle = GLES20.glGetUniformLocation(this.mProgram, "sBackTextureSize");
        this.mInputTexScaleHandle = GLES20.glGetUniformLocation(this.mProgram, "scaleU");
        this.mBackgroundTexScaleHandle = GLES20.glGetUniformLocation(this.mProgram, "scaleV");
        this.mInputTexOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "offsetU");
        this.mContentTypeOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "offsetT");
        this.mEacExpandCoefHandle = GLES20.glGetUniformLocation(this.mProgram, "expandCoef");
        this.mShaderTypeHandle = GLES20.glGetUniformLocation(this.mProgram, "shaderType");
        return 0;
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        EffectTexture effectTextureGenTexture;
        if (!this.mIsProcessed) {
            this.mIsProcessed = true;
            if (this.mOrientationEventHandler != null) {
                this.mOrientationEventHandler.enable();
            }
            handleDirectModeChange();
            handleTouchScalerChange();
        }
        if (effectTexture.getTexTarget() != this.mInTextureTarget) {
            TextureRenderLog.e(this.mTexType, getClass().getSimpleName(), "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + effectTexture.getTexTarget());
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + effectTexture.getTexTarget());
            }
            return effectTexture;
        }
        if (this.mProgram == 0) {
            TextureRenderLog.e(this.mTexType, LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
            }
            return effectTexture;
        }
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        }
        GLES20.glUseProgram(this.mProgram);
        this.mViewPortWidth = this.mSurfaceTexture.getViewportWidth();
        this.mViewPortHeight = this.mSurfaceTexture.getViewportHeight();
        if (this.mVideoStyle == 1) {
            updateRenderParam(effectTexture, frameBuffer);
        }
        GLES20.glBindBuffer(34962, this.mVerVBO);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, 0);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34962, this.mTexVBO);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, 0);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GLES20.glBindBuffer(34962, 0);
        if (!this.mSensorDirectorEnabled && this.mFreezeModelMatrix != null) {
            this.mModelMatrix = this.mFreezeModelMatrix;
            if (!this.mDidGetInitialModelMatrix) {
                if (this.mSensorDirector != null && this.mDirectMode != 2) {
                    this.mSensorDirector.getView(this.mModelMatrix, 0);
                }
                Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
                Matrix.multiplyMM(this.mModelMatrix, 0, this.mModelMatrix, 0, this.mInitialModelMatrixInvert, 0);
                this.mFreezeModelMatrix = this.mModelMatrix;
                this.mDidGetInitialModelMatrix = true;
            }
        } else {
            if (this.mSensorDirector != null && this.mDirectMode != 2) {
                this.mSensorDirector.getView(this.mModelMatrix, 0);
            }
            if (!this.mDidGetInitialModelMatrix) {
                Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
                this.mDidGetInitialModelMatrix = true;
            }
            if (this.mDirectMode != 2 && this.mUseInitialHeadPoseAsFront) {
                Matrix.multiplyMM(this.mModelMatrix, 0, this.mModelMatrix, 0, this.mInitialModelMatrixInvert, 0);
            }
        }
        Matrix.setIdentityM(this.mRotateMatrix, 0);
        if (!DeviceManager.isVRDevice() || this.mOffsetYaw != 0 || this.mOffsetPitch != 0) {
            Matrix.rotateM(this.mRotateMatrix, 0, this.mOffsetPitch + this.mTouchDirector.getDiffX(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.mRotateMatrix, 0, this.mTouchDirector.getDiffY() - this.mOffsetYaw, 0.0f, 1.0f, 0.0f);
        }
        Matrix.rotateM(this.mRotateMatrix, 0, this.mSpaceOrientationPitch, 1.0f, 0.0f, 0.0f);
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, 0, this.mModelMatrix, 0, this.mRotateMatrix, 0);
        Matrix.invertM(fArr, 0, fArr, 0);
        this.mSurfaceTexture.setHeadPose(new Quaternion(fArr));
        float scale = this.mTouchScaler.getScale();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.mProgram, "rotateMatrix"), 1, false, this.mRotateMatrix, 0);
        float viewportWidth = (this.mSurfaceTexture.getViewportWidth() * 1.0f) / this.mSurfaceTexture.getViewportHeight();
        this.mPerspecViewRatio = viewportWidth > 1.0f ? viewportWidth : 1.0f;
        if (frameBuffer != null) {
            updateOutTexSize(viewportWidth);
            effectTextureGenTexture = genTexture();
            if (effectTextureGenTexture != null) {
                frameBuffer.bindTexture2D(effectTextureGenTexture.getTexID());
            }
            this.mViewPortWidth = this.mOutTexWidth;
            this.mViewPortHeight = this.mOutTexHeight;
        } else {
            effectTextureGenTexture = null;
        }
        if (this.mNeedClear) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, effectTexture.getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.mGlBackgroundTexture);
        GLES20.glUniform1i(this.mShaderTypeHandle, getShaderType());
        GLES20.glUniform1f(this.mEacExpandCoefHandle, getExpandCoef());
        GLES20.glUniform1i(this.mBackgroundTexHandle, 1);
        if (this.mVideoStyle == 2 && this.mViewSize == 360) {
            GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
            GLES20.glUniform1f(this.mInputTexScaleHandle, 1.0f);
            GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.0f);
            GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.0f);
            GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 1.0f);
        } else if (this.mVideoStyle == 2 && this.mViewSize == 180) {
            GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
            GLES20.glUniform1f(this.mInputTexScaleHandle, 1.0f);
            GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.25f);
            GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.0f);
            GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 1.0f);
        } else if (this.mVideoStyle == 4) {
            GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
            GLES20.glUniform1f(this.mInputTexScaleHandle, 2.0f);
            GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.125f);
            GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.5f);
            GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 1.0f);
        } else if (this.mVideoStyle == 3) {
            GLES20.glUniform1f(this.mInputTexSizeHandle, 0.5f);
            GLES20.glUniform1f(this.mInputTexScaleHandle, 1.0f);
            GLES20.glUniform1f(this.mInputTexOffsetHandle, 0.0f);
            GLES20.glUniform1f(this.mContentTypeOffsetHandle, 0.0f);
            GLES20.glUniform1f(this.mBackgroundTexScaleHandle, 2.0f);
        }
        GLES20.glUniform1f(this.mInputBackTexSizeHandle, (float) ((this.mBackTextureSize * 1.0d) / 360.0d));
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, TEXSCALE_2D, 0);
        Matrix.perspectiveM(this.mProjectionMatrix, 0, this.mPerspecView / this.mPerspecViewRatio, viewportWidth, 0.1f, 100.0f);
        Matrix.scaleM(this.mProjectionMatrix, 0, scale, scale, 1.0f);
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        Matrix.setLookAtM(this.mViewMatrix, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
        draw(this.mIndexBuffers);
        effectTexture.giveBack();
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
        int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "error pano draw");
        if (iCheckGLError != 0 && this.mSurfaceTexture != null) {
            this.mSurfaceTexture.notifyError(iCheckGLError, this.mEffectType, "error pano draw");
        }
        GLES20.glFinish();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        }
        if (frameBuffer == null) {
            return null;
        }
        frameBuffer.unbindTexture2D();
        return effectTextureGenTexture;
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        int i = this.mGlBackgroundTexture;
        if (i != 0) {
            TexGLUtils.deleteTexture(i);
        }
        return super.release();
    }

    @Override // com.ss.texturerender.effect.vr.GLPanoramaFilter, com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        return i != 11001 ? super.getStringOption(i) : "precision highp float;\n\n#define PI 3.14159265359\nuniform sampler2D sTexture;\nuniform sampler2D sBackground;\nuniform float sTextureSize;\nuniform float sBackTextureSize;\nuniform float scaleU;\nuniform float scaleV;\nuniform float offsetU;\nuniform float offsetT;\nuniform float expandCoef;\nuniform int shaderType;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\n\nvec4 vrTextureFragmentForVirtualLive() {\n    vec4 outputColor = texture2D(sBackground, vec2(vTextureCoord.x, 1.0 - vTextureCoord.y));\n    if (verPosition.z < 0.0 && abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n        vec2 st = vec2(verPosition.x / (verPosition.z * 2.0) + 0.5, verPosition.y / (verPosition.z * 2.0) + 0.5);\n        st = vec2(1.0, 1.0) - st;\n        outputColor = texture2D(sTexture, st);\n    }\n    return outputColor;\n}\n\nvec4 vrTextureFragmentFor180eac() {\n    vec4 colMain;\n    if (verPosition.z < 0.0) {\n       vec2 st;\n       float padding = 1.0/expandCoef;\n       if (abs(verPosition.z) > abs(verPosition.x) && abs(verPosition.z) > abs(verPosition.y)) {\n           st = vec2((2.0*(0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.z)) + 0.5) + 3.0)/6.0, 0.5*(4.0/PI*atan(padding * verPosition.y / verPosition.z)) + 0.5);\n           st = vec2(1.0, 1.0) - st;\n       } else if ( verPosition.x < 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.x > 0.0 && abs(verPosition.x) > abs(verPosition.z) && abs(verPosition.x) > abs(verPosition.y)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.x))/6.0 + 4.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.y / verPosition.x)) + 0.5);\n       } else if (verPosition.y < 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, -0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       } else if (verPosition.y > 0.0 && abs(verPosition.y) > abs(verPosition.z) && abs(verPosition.y) > abs(verPosition.x)) {\n           st = vec2((4.0/PI*atan(padding * verPosition.z / verPosition.y))/(-6.0) + 5.0/6.0, 0.5 * (4.0/PI*atan(padding * verPosition.x / verPosition.y)) + 0.5);\n       }\n       colMain = texture2D(sTexture, st);\n    }\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvec4 vrTextureFragmentForGeneralUse() {\n    vec2 uvMain = vTextureCoord;\n    if (offsetT == 0.0  && offsetU ==  0.25) {\n       uvMain.x = (uvMain.x - offsetU) * 2.0;\n    } else {\n       uvMain.x = (uvMain.x - offsetU) * scaleU;\n    }\n    vec4 colMain = texture2D(sTexture, uvMain);\n    float StepLeft = 1.0 - step((0.25 - sTextureSize / 2.0 + 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n    float StepRight = step((0.75 + sTextureSize / 2.0 - 0.5 * sBackTextureSize) / scaleU, vTextureCoord.x);\n\n    vec2 leftUV = vTextureCoord;\n    leftUV.x = (scaleU * leftUV.x  / sBackTextureSize) + 0.5;\n    \n    vec2 rightUV = vTextureCoord;\n    rightUV.x = (scaleU * (rightUV.x - 1.0 + offsetT) / sBackTextureSize) + 0.5;\n    \n    leftUV.y = scaleV * (1.0 - leftUV.y);\n    rightUV.y = scaleV * (1.0 - rightUV.y);\n\n    vec4 col = colMain * (1.0 - StepLeft) * (1.0 - StepRight) + texture2D(sBackground, leftUV) * StepLeft + texture2D(sBackground, rightUV) * StepRight;\n\n    return col;\n}\n\nvoid main()\n{\n    if (shaderType == 1) {\n        gl_FragColor = vrTextureFragmentForVirtualLive();\n    } else if (shaderType == 2) {\n        gl_FragColor = vrTextureFragmentFor180eac();\n    } else {\n        gl_FragColor = vrTextureFragmentForGeneralUse();\n    }\n}\n";
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, Object obj) {
        if (i == 118) {
            try {
                ArrayList arrayList = (ArrayList) obj;
                Object obj2 = arrayList.get(0);
                Object obj3 = arrayList.get(1);
                if (obj3 instanceof Bitmap) {
                    updateBackgroundTexture((Bitmap) obj3);
                }
                synchronized (obj2) {
                    obj2.notify();
                    TextureRenderLog.i(this.mTexType, LOG_TAG, "update background texture done");
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        super.setOption(i, obj);
    }

    void genBackgroundTexture() {
        int iGenTexture = TexGLUtils.genTexture(3553);
        this.mGlBackgroundTexture = iGenTexture;
        GLES20.glBindTexture(3553, iGenTexture);
        GLES20.glTexImage2D(3553, 0, 6408, 1, 1, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
    }

    void updateBackgroundTexture(Bitmap bitmap) {
        if (this.mGlBackgroundTexture == 0) {
            genBackgroundTexture();
        }
        if (bitmap != null) {
            try {
                GLES20.glBindTexture(3553, this.mGlBackgroundTexture);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
                GLES20.glBindTexture(3553, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
