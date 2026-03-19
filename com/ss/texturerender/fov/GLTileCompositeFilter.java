package com.ss.texturerender.fov;

import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import com.sigmob.sdk.archives.tar.d;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLTileCompositeFilter extends GLDefaultFilter {
    private static final String LOG_TAG = "GLTileCompositeFilter";
    private final String fragmentShader;
    private int mAntiColorHandle;
    private TileInfo mBackgroundTileInfos;
    private TileInfo[] mCurrTileInfos;
    private int mDecodedBackgroundTexHeight;
    private int mDecodedBackgroundTexWidth;
    private int mDepthZHandle;
    private int mGlobalClampHandle;
    private int mScaleOffsetHandle;
    private int mVertexScaleOffsetHandle;
    private final String vertexShader;

    public GLTileCompositeFilter(int i) {
        super(i, 18);
        this.vertexShader = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform float DepthZ;\nuniform vec2 globalClamp;\nuniform vec4 vertexScaleOffset;\nvoid main() {\n  vec2 positionXY = (vec2(aPosition.x, aPosition.y) / 2.0 + 0.5) * vertexScaleOffset.xy + vertexScaleOffset.zw;\n  positionXY = (positionXY - 0.5) * 2.0;\n  gl_Position = vec4(positionXY.x, positionXY.y, DepthZ, 1.0);\n  vTextureCoord = clamp(aTextureCoord.xy, vec2(globalClamp.x), vec2(globalClamp.y));\n}\n";
        this.fragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec4 scaleOffset;\nuniform int antiColor;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord * scaleOffset.xy + scaleOffset.zw);\n  if (antiColor == 1) {\n      gl_FragColor.rgba = gl_FragColor.bgra;\n  }\n}\n";
        this.mBackgroundTileInfos = null;
        this.mCurrTileInfos = null;
        this.mDecodedBackgroundTexWidth = 0;
        this.mDecodedBackgroundTexHeight = 0;
        this.mOrder = 99;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        super.init(bundle);
        if (Build.VERSION.SDK_INT < 15) {
            return -1;
        }
        this.mInTextureTarget = 36197;
        this.mVertexScaleOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "vertexScaleOffset");
        this.mDepthZHandle = GLES20.glGetUniformLocation(this.mProgram, "DepthZ");
        this.mScaleOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "scaleOffset");
        this.mGlobalClampHandle = GLES20.glGetUniformLocation(this.mProgram, "globalClamp");
        this.mAntiColorHandle = GLES20.glGetUniformLocation(this.mProgram, "antiColor");
        this.mLayoutMode = 0;
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        int length = effectTexture.getExtraEffectTexture().length;
        TileInfo[] tileInfoArr = this.mCurrTileInfos;
        if (tileInfoArr == null || tileInfoArr.length != length) {
            this.mCurrTileInfos = new TileInfo[length];
        }
        this.mBackgroundTileInfos = null;
        Arrays.fill(this.mCurrTileInfos, (Object) null);
        updateMappingInfo(length + 1);
        TileInfo tileInfo = this.mBackgroundTileInfos;
        if (tileInfo != null && (this.mDecodedBackgroundTexWidth != tileInfo.getBackgroundTexWidth() || this.mDecodedBackgroundTexHeight != this.mBackgroundTileInfos.getBackgroundTexHeight())) {
            this.mDecodedBackgroundTexWidth = this.mBackgroundTileInfos.getBackgroundTexWidth();
            this.mDecodedBackgroundTexHeight = this.mBackgroundTileInfos.getBackgroundTexHeight();
        }
        this.mOutTexWidth = this.mSurfaceTexture.getTexWidth();
        this.mOutTexHeight = this.mSurfaceTexture.getTexHeight();
        if (effectTexture.getTexTarget() != this.mInTextureTarget) {
            TextureRenderLog.d(this.mTexType, getClass().getSimpleName(), "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + effectTexture.getTexTarget());
            return effectTexture;
        }
        this.mSurfaceTexture.currentEffectProcessBegin(this.mEffectType);
        if (updateRenderParam(effectTexture, null) == -1) {
            updateDefaultRenderParam(effectTexture, null);
        }
        GLES20.glUseProgram(this.mProgram);
        if (this.mNeedClear) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16384);
        }
        this.mTriangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, (Buffer) this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, (Buffer) this.mTextureVertices);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        onDrawFrameBefore();
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        if (this.mBackgroundTileInfos != null) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.mInTextureTarget, effectTexture.getTexID());
            GLES20.glUniform1i(this.mInputTextureHandle, 0);
            GLES20.glTexParameteri(this.mInTextureTarget, 10241, 9729);
            GLES20.glTexParameteri(this.mInTextureTarget, d.b, 9729);
            drawBackground(this.mBackgroundTileInfos);
        }
        int i = 0;
        while (true) {
            TileInfo[] tileInfoArr2 = this.mCurrTileInfos;
            if (i < tileInfoArr2.length) {
                if (tileInfoArr2[i] != null) {
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(this.mInTextureTarget, effectTexture.getExtraEffectTexture()[i].getTexID());
                    GLES20.glUniform1i(this.mInputTextureHandle, 0);
                    GLES20.glTexParameteri(this.mInTextureTarget, 10241, 9728);
                    GLES20.glTexParameteri(this.mInTextureTarget, d.b, 9728);
                    drawOverlay(this.mCurrTileInfos[i]);
                }
                i++;
            } else {
                onDrawFrameAfter();
                GLES20.glBindTexture(this.mInTextureTarget, 0);
                GLES20.glDisableVertexAttribArray(this.maPositionHandle);
                GLES20.glDisableVertexAttribArray(this.maTextureHandle);
                this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
                effectTexture.giveBack();
                GLES20.glFinish();
                this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
                return null;
            }
        }
    }

    private void drawOverlay(TileInfo tileInfo) {
        int i;
        int i2;
        int[] iArr;
        int i3;
        TileInfo tileInfo2 = tileInfo;
        GLES20.glUniform1f(this.mDepthZHandle, 0.1f);
        GLES20.glUniform2f(this.mGlobalClampHandle, 0.0f, 1.0f);
        GLES20.glUniform1i(this.mAntiColorHandle, 1);
        int length = tileInfo2.visibleArray.length();
        int[] iArr2 = new int[length];
        int i4 = 0;
        while (true) {
            i = -1;
            if (i4 >= tileInfo2.visibleArray.length()) {
                break;
            }
            try {
                iArr2[i4] = tileInfo2.visibleArray.getInt(i4);
            } catch (JSONException e) {
                iArr2[i4] = -1;
                e.printStackTrace();
            }
            i4++;
        }
        int i5 = 0;
        while (i5 < length) {
            int i6 = iArr2[i5];
            if (i6 == i) {
                i2 = i;
                iArr = iArr2;
                i3 = length;
            } else {
                int i7 = i5 / tileInfo2.srcTileWidthCount;
                int i8 = i5 % tileInfo2.srcTileWidthCount;
                int i9 = i6 / tileInfo2.dstTileWidthCount;
                int i10 = i6 % tileInfo2.dstTileWidthCount;
                i2 = -1;
                iArr = iArr2;
                i3 = length;
                drawTile(tileInfo2.srcTileWidthCount, tileInfo2.srcTileHeightCount, tileInfo2.dstTileWidthCount, tileInfo2.dstTileHeightCount, i8, i8, i7, i7, i10, i10, i9, i9, tileInfo2.tileWidth, tileInfo2.tileHeight, tileInfo.getDecodedFrameWidth(), tileInfo.getDecodedFrameHeight(), tileInfo2.paddingY, tileInfo.is3DInput());
            }
            i5++;
            tileInfo2 = tileInfo;
            i = i2;
            iArr2 = iArr;
            length = i3;
        }
    }

    private void drawBackground(TileInfo tileInfo) {
        int i;
        int i2;
        int i3;
        TileInfo tileInfo2 = tileInfo;
        GLES20.glUniform1f(this.mDepthZHandle, 0.9f);
        GLES20.glUniform2f(this.mGlobalClampHandle, 3.0f / this.mDecodedBackgroundTexWidth, 1.0f - (3.0f / this.mDecodedBackgroundTexHeight));
        int i4 = 0;
        GLES20.glUniform1i(this.mAntiColorHandle, 0);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i8 < tileInfo2.backgroundTileHeightCount) {
            int i9 = i5;
            int i10 = i6;
            int i11 = i7;
            int i12 = i4;
            int i13 = i12;
            while (i12 < tileInfo2.backgroundTileWidthCount) {
                if (i11 == tileInfo2.backgroundTileWidthCount - 1) {
                    int i14 = i11;
                    int i15 = i12;
                    i = i8;
                    i2 = i4;
                    drawTile(tileInfo2.backgroundTileWidthCount, tileInfo2.backgroundTileHeightCount, tileInfo2.backgroundTileWidthCount, tileInfo2.backgroundTileHeightCount, i10, i14, i9, i9, i13, i15, i, i, tileInfo2.tileWidth, tileInfo2.tileHeight, tileInfo.getDecodedFrameWidth(), tileInfo.getDecodedFrameHeight(), tileInfo2.paddingY, tileInfo.is3DInput());
                    i9++;
                    i13 = i15 + 1;
                    i3 = i15;
                    i10 = i2;
                } else {
                    int i16 = i12;
                    i = i8;
                    i2 = i4;
                    if (i16 == tileInfo2.backgroundTileWidthCount - 1) {
                        i3 = i16;
                        drawTile(tileInfo2.backgroundTileWidthCount, tileInfo2.backgroundTileHeightCount, tileInfo2.backgroundTileWidthCount, tileInfo2.backgroundTileHeightCount, i10, i11, i9, i9, i13, i16, i, i, tileInfo2.tileWidth, tileInfo2.tileHeight, tileInfo.getDecodedFrameWidth(), tileInfo.getDecodedFrameHeight(), tileInfo2.paddingY, tileInfo.is3DInput());
                        i10 = i11 + 1;
                    } else {
                        i3 = i16;
                        i11++;
                        i12 = i3 + 1;
                        tileInfo2 = tileInfo;
                        i8 = i;
                        i4 = i2;
                    }
                }
                i11 = i10;
                i12 = i3 + 1;
                tileInfo2 = tileInfo;
                i8 = i;
                i4 = i2;
            }
            i8++;
            tileInfo2 = tileInfo;
            i6 = i10;
            i5 = i9;
            i7 = i11;
        }
    }

    private void drawTile(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z) {
        float f = i;
        float f2 = ((i6 - i5) + 1) / f;
        float f3 = i2;
        float f4 = ((i8 - i7) + 1) / f3;
        float f5 = i5 / f;
        float f6 = i7 / f3;
        float f7 = i3;
        float f8 = ((i10 - i9) + 1) / f7;
        float f9 = i4;
        float f10 = ((i12 - i11) + 1) / f9;
        float f11 = i9 / f7;
        float f12 = ((i4 - i11) - 1) / f9;
        if (z) {
            float f13 = i17;
            float f14 = (f4 * (1.0f - (f13 / i14))) / 2.0f;
            float f15 = f13 / 4.0f;
            float f16 = i16;
            GLES20.glUniform4f(this.mScaleOffsetHandle, f2, f14, f5, (f15 / f16) + f6);
            float f17 = (-f10) / 2.0f;
            float f18 = f12 / 2.0f;
            float f19 = f10 / 2.0f;
            GLES20.glUniform4f(this.mVertexScaleOffsetHandle, f8, f17, f11, f18 + 0.5f + f19);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glUniform4f(this.mScaleOffsetHandle, f2, f14, f5, f6 + f14 + ((f15 * 3.0f) / f16));
            GLES20.glUniform4f(this.mVertexScaleOffsetHandle, f8, f19, f11, f18);
            GLES20.glDrawArrays(5, 0, 4);
            return;
        }
        float f20 = i17;
        GLES20.glUniform4f(this.mScaleOffsetHandle, f2, f4 * (1.0f - (f20 / i14)), f5, f6 + ((f20 / 2.0f) / i16));
        GLES20.glUniform4f(this.mVertexScaleOffsetHandle, f8, -f10, f11, f12 + f10);
        GLES20.glDrawArrays(5, 0, 4);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        return i != 11000 ? i != 11001 ? super.getStringOption(i) : "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec4 scaleOffset;\nuniform int antiColor;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord * scaleOffset.xy + scaleOffset.zw);\n  if (antiColor == 1) {\n      gl_FragColor.rgba = gl_FragColor.bgra;\n  }\n}\n" : "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform float DepthZ;\nuniform vec2 globalClamp;\nuniform vec4 vertexScaleOffset;\nvoid main() {\n  vec2 positionXY = (vec2(aPosition.x, aPosition.y) / 2.0 + 0.5) * vertexScaleOffset.xy + vertexScaleOffset.zw;\n  positionXY = (positionXY - 0.5) * 2.0;\n  gl_Position = vec4(positionXY.x, positionXY.y, DepthZ, 1.0);\n  vTextureCoord = clamp(aTextureCoord.xy, vec2(globalClamp.x), vec2(globalClamp.y));\n}\n";
    }

    private void updateMappingInfo(long j) {
        LinkedList<VideoSurfaceTexture.FrameMetaData> frameMetaData = this.mSurfaceTexture.getFrameMetaData(this.mSurfaceTexture.getTimestamp(), j);
        if (frameMetaData != null) {
            for (int i = 0; i < frameMetaData.size(); i++) {
                String stringifiedTileInfo = frameMetaData.get(i).getStringifiedTileInfo();
                TileInfo tileInfoUpdateTileInfo = updateTileInfo(stringifiedTileInfo);
                if (tileInfoUpdateTileInfo.streamIndex == 0) {
                    this.mBackgroundTileInfos = tileInfoUpdateTileInfo;
                } else {
                    this.mCurrTileInfos[tileInfoUpdateTileInfo.streamIndex - 1] = tileInfoUpdateTileInfo;
                }
                TextureRenderLog.d(this.mTexType, LOG_TAG, "debug -> tile info " + stringifiedTileInfo);
            }
            return;
        }
        updateTileInfo(null);
        TextureRenderLog.d(this.mTexType, LOG_TAG, "debug -> frameMetaData not found, ts " + this.mSurfaceTexture.getTimestamp());
    }

    private TileInfo updateTileInfo(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return TileInfo.create(str);
    }
}
