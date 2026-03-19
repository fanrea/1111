package com.ss.texturerender.effect.vr;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import com.ss.texturerender.effect.vr.director.IDirector;
import com.ss.texturerender.effect.vr.director.IDirectorEventListener;
import com.ss.texturerender.effect.vr.director.TouchDirector;
import com.ss.texturerender.effect.vr.director.picodirector.PicoDirector;
import com.ss.texturerender.effect.vr.director.sensordirector.SensorDirector;
import com.ss.texturerender.effect.vr.distortion.BrownDistortion;
import com.ss.texturerender.math.Quaternion;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GLPanoramaFilter extends GLDefaultFilter implements IDirectorEventListener {
    private static final float DEFAULT_BORDER_SIZE_METER = 0.003f;
    private static final String LOG_TAG = "TR_GLPanoramaFilter";
    private static final String cubemapShaderFragment = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvoid main() {\n    vec3 result = vec3((vTextureCoord - 0.5) / expandCoef + 0.5, 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}";
    private float DEFAULT_OUT_TEXTURE_SCALE;
    private float DEFAULT_PERSPEC_VIEW;
    private final String eac180FragShader;
    private final String eacFragShader;
    protected int mBackTextureSize;
    private float mCMPFaceInnerPadding;
    private float[] mCubeRotatesPerFace;
    private float[] mCubeTexOffsetPerFace;
    protected int mDesireViewSize;
    protected boolean mDidGetInitialModelMatrix;
    protected int mDirectMode;
    private Display mDisplay;
    private BrownDistortion mDistortion;
    private float[] mDistortionCoeffs;
    private short[][] mDistortionIndex;
    protected ShortBuffer[] mDistortionIndexBuffer;
    private float[][] mDistortionPos;
    private float[][] mDistortionTex;
    protected FloatBuffer[] mDistortionTextureBuffer;
    protected FloatBuffer[] mDistortionTriangleBuffer;
    protected int mEBO;
    private boolean mEnableTouchScaler;
    private float mExpandCoef;
    private int mExpandCoefHandle;
    private float[] mFov;
    private float[][] mFovTan;
    private int mFreezeDirector;
    protected float[] mFreezeModelMatrix;
    private float mHalfEyeDistance;
    private int mHeadposeCallbackCounter;
    private float[] mIdentityMat;
    protected float[] mInitialModelMatrixInvert;
    protected boolean mIsProcessed;
    private Quaternion mLastCallbackHeadpose;
    private float mLensToScreenDistance;
    private int mMVPMatrixHandle;
    protected float[] mModelMatrix;
    protected int mOffsetPitch;
    protected int mOffsetYaw;
    protected OrientationEventHandler mOrientationEventHandler;
    protected float mOutTextureScale;
    private int mPanoMode;
    protected float mPerspecView;
    public float mPerspecViewRatio;
    protected float[] mProjectionMatrix;
    protected float[] mRotateMatrix;
    private int mScreenH;
    private int mScreenW;
    protected IDirector mSensorDirector;
    protected boolean mSensorDirectorEnabled;
    protected int mSpaceOrientationPitch;
    protected int mTexVBO;
    private FloatBuffer mTextureVerticesRight;
    protected TouchDirector mTouchDirector;
    protected TouchScaler mTouchScaler;
    private float mTrayToLensDis;
    protected boolean mUseInitialHeadPoseAsFront;
    private int mVRModel;
    protected int mVerVBO;
    private int mVideoProjectModel;
    protected int mVideoStyle;
    protected float[] mViewMatrix;
    protected int mViewSize;
    private float mZOffset;
    private int mZOffsetHandle;
    private final String offsetCubicFragShader;
    private final String vertexDefaultShader;
    private static float[] SIDE_BY_SIDE_TEXSCALE_LEFT = {0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private static float[] SIDE_BY_SIDE_TEXSCALE_RIGHT = {0.5f, 0.0f, 0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private static float[] TOP_BOTTOM_TEXSCALE_LEFT = {1.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f};
    private static float[] TOP_BOTTOM_TEXSCALE_RIGHT = {1.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f, 0.0f, 0.0f};
    protected static float[] TEXSCALE_2D = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private static float mRadius = 1.0f;
    private static float METERS_PER_INCH = 0.0254f;
    private static int LEFT = 0;
    private static int RIGHT = 1;
    private static float ZNEAR = 0.1f;
    private static float ZFAR = 100.0f;
    private static int RESOLUTION = 40;

    protected class OrientationEventHandler extends OrientationEventListener {
        public OrientationEventHandler(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (GLPanoramaFilter.this.mTouchDirector != null) {
                GLPanoramaFilter.this.mTouchDirector.updateDeviceOrientation(i, GLPanoramaFilter.this.mDirectMode != 2 && GLPanoramaFilter.this.mSensorDirectorEnabled);
            }
        }
    }

    public GLPanoramaFilter(int i, int i2) {
        super(i, i2);
        this.vertexDefaultShader = "attribute vec4 aPosition;\nuniform mat4 u_MVPMatrix;\nuniform mat4 rotateMatrix;attribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;void main() {\n  gl_Position =  u_MVPMatrix * rotateMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n  verPosition = aPosition.xyz;}\n";
        this.eacFragShader = "#define PI 3.14159265359\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = 1.0 / 3.0 * clamp(floor(oriCoord.x * 3.0), 0.0, 2.0);\n    float yStep = 0.5 * step(0.5, oriCoord.y);\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 4.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 4.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture,  eacResult.xy);\n}";
        this.eac180FragShader = "#define PI 3.14159265359\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = -1.0 / 6.0 + step(1.0 / 6.0, oriCoord.x) / 3.0 + step(3.0 / 6.0, oriCoord.x) / 3.0 + step(2.0 / 3.0, oriCoord.x) / 6.0;\n    float yStep = 0.0;\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 2.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 2.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = step(0.0, -verPosition.z) * texture2D(sTexture, eacResult.xy);\n}";
        this.offsetCubicFragShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nvarying vec3 verPosition;\nuniform vec3 zOffset;\nuniform int cubemapMode;\nuniform vec2 texOffset[6];\nuniform mat2 rotates[6];\nuniform mat3 texScale;//one eye and two eye scale\nvec2 cubeToTexture(vec3 cubeCoord, float expand) {\n    vec2 result;\n    float absX = abs(cubeCoord.x);\n    float absY = abs(cubeCoord.y);\n    float absZ = abs(cubeCoord.z);\n    int index;//0:left 1:front 2:right 3:top 4:back 5:bottom\n    if (-cubeCoord.z >= absX && -cubeCoord.z >= absY) {\n        result = vec2(cubeCoord.x, cubeCoord.y);\n        index = 1;\n    } else if (cubeCoord.z >= absX && cubeCoord.z >= absY) {\n        result = vec2(-cubeCoord.x, cubeCoord.y);\n        index = 4;\n    } else if (cubeCoord.y >= absX && cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, cubeCoord.z);\n        index = 3;\n    } else if (-cubeCoord.y >= absX && -cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, -cubeCoord.z);\n        index = 5;\n    } else if (cubeCoord.x >= absY && cubeCoord.x >= absZ) {\n        result = vec2(cubeCoord.z, cubeCoord.y);\n        index = 2;\n    } else {\n        result = vec2(-cubeCoord.z, cubeCoord.y);\n        index = 0;\n    }\n    result = result * rotates[index] / expand;\n    result = vec2((result.x + 1.0) / 6.0, (result.y + 1.0) / 4.0) + texOffset[index];\n    return result;\n}\nvec2 offsetCubicTransFunc(vec3 inCubePosition) {\n    inCubePosition = inCubePosition - zOffset;\n    inCubePosition = inCubePosition / max(max(abs(inCubePosition.x),abs(inCubePosition.y)),abs(inCubePosition.z));\n    return cubeToTexture(inCubePosition, expandCoef);\n}\nvoid main() {\n    vec3 result = vec3(offsetCubicTransFunc(verPosition),1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}";
        this.mExpandCoef = 1.0f;
        this.mOffsetYaw = 0;
        this.mOffsetPitch = 0;
        this.mSpaceOrientationPitch = 0;
        this.mProjectionMatrix = new float[16];
        this.mModelMatrix = new float[16];
        this.mFreezeModelMatrix = new float[16];
        this.mInitialModelMatrixInvert = new float[16];
        this.mDidGetInitialModelMatrix = false;
        this.mUseInitialHeadPoseAsFront = false;
        this.mViewMatrix = new float[16];
        this.mRotateMatrix = new float[16];
        this.mSensorDirectorEnabled = true;
        this.mPanoMode = 2;
        this.mVideoStyle = 1;
        this.mVRModel = 1;
        this.mVideoProjectModel = 1;
        this.mViewSize = 360;
        this.mDesireViewSize = 360;
        this.mBackTextureSize = 180;
        this.mDirectMode = 1;
        this.DEFAULT_PERSPEC_VIEW = 100.0f;
        this.mPerspecView = 100.0f;
        this.mPerspecViewRatio = 1.0f;
        this.mFov = new float[]{100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f};
        this.mHalfEyeDistance = 0.03f;
        this.mIsProcessed = false;
        this.mLensToScreenDistance = 0.042f;
        this.mDistortionCoeffs = new float[]{0.441f, 0.156f};
        this.mTrayToLensDis = 0.035f;
        this.mScreenW = -1;
        this.mScreenH = -1;
        this.DEFAULT_OUT_TEXTURE_SCALE = 1.1f;
        this.mOutTextureScale = 1.1f;
        this.mTextureVerticesRight = null;
        this.mEBO = -1;
        this.mTexVBO = -1;
        this.mVerVBO = -1;
        this.mCMPFaceInnerPadding = 0.0f;
        this.mHeadposeCallbackCounter = 0;
        this.mLastCallbackHeadpose = null;
        this.mFreezeDirector = 0;
        this.mOrientationEventHandler = null;
        construct();
    }

    public GLPanoramaFilter(int i) {
        super(i, 8);
        this.vertexDefaultShader = "attribute vec4 aPosition;\nuniform mat4 u_MVPMatrix;\nuniform mat4 rotateMatrix;attribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;void main() {\n  gl_Position =  u_MVPMatrix * rotateMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n  verPosition = aPosition.xyz;}\n";
        this.eacFragShader = "#define PI 3.14159265359\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = 1.0 / 3.0 * clamp(floor(oriCoord.x * 3.0), 0.0, 2.0);\n    float yStep = 0.5 * step(0.5, oriCoord.y);\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 4.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 4.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture,  eacResult.xy);\n}";
        this.eac180FragShader = "#define PI 3.14159265359\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = -1.0 / 6.0 + step(1.0 / 6.0, oriCoord.x) / 3.0 + step(3.0 / 6.0, oriCoord.x) / 3.0 + step(2.0 / 3.0, oriCoord.x) / 6.0;\n    float yStep = 0.0;\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 2.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 2.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = step(0.0, -verPosition.z) * texture2D(sTexture, eacResult.xy);\n}";
        this.offsetCubicFragShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nvarying vec3 verPosition;\nuniform vec3 zOffset;\nuniform int cubemapMode;\nuniform vec2 texOffset[6];\nuniform mat2 rotates[6];\nuniform mat3 texScale;//one eye and two eye scale\nvec2 cubeToTexture(vec3 cubeCoord, float expand) {\n    vec2 result;\n    float absX = abs(cubeCoord.x);\n    float absY = abs(cubeCoord.y);\n    float absZ = abs(cubeCoord.z);\n    int index;//0:left 1:front 2:right 3:top 4:back 5:bottom\n    if (-cubeCoord.z >= absX && -cubeCoord.z >= absY) {\n        result = vec2(cubeCoord.x, cubeCoord.y);\n        index = 1;\n    } else if (cubeCoord.z >= absX && cubeCoord.z >= absY) {\n        result = vec2(-cubeCoord.x, cubeCoord.y);\n        index = 4;\n    } else if (cubeCoord.y >= absX && cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, cubeCoord.z);\n        index = 3;\n    } else if (-cubeCoord.y >= absX && -cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, -cubeCoord.z);\n        index = 5;\n    } else if (cubeCoord.x >= absY && cubeCoord.x >= absZ) {\n        result = vec2(cubeCoord.z, cubeCoord.y);\n        index = 2;\n    } else {\n        result = vec2(-cubeCoord.z, cubeCoord.y);\n        index = 0;\n    }\n    result = result * rotates[index] / expand;\n    result = vec2((result.x + 1.0) / 6.0, (result.y + 1.0) / 4.0) + texOffset[index];\n    return result;\n}\nvec2 offsetCubicTransFunc(vec3 inCubePosition) {\n    inCubePosition = inCubePosition - zOffset;\n    inCubePosition = inCubePosition / max(max(abs(inCubePosition.x),abs(inCubePosition.y)),abs(inCubePosition.z));\n    return cubeToTexture(inCubePosition, expandCoef);\n}\nvoid main() {\n    vec3 result = vec3(offsetCubicTransFunc(verPosition),1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}";
        this.mExpandCoef = 1.0f;
        this.mOffsetYaw = 0;
        this.mOffsetPitch = 0;
        this.mSpaceOrientationPitch = 0;
        this.mProjectionMatrix = new float[16];
        this.mModelMatrix = new float[16];
        this.mFreezeModelMatrix = new float[16];
        this.mInitialModelMatrixInvert = new float[16];
        this.mDidGetInitialModelMatrix = false;
        this.mUseInitialHeadPoseAsFront = false;
        this.mViewMatrix = new float[16];
        this.mRotateMatrix = new float[16];
        this.mSensorDirectorEnabled = true;
        this.mPanoMode = 2;
        this.mVideoStyle = 1;
        this.mVRModel = 1;
        this.mVideoProjectModel = 1;
        this.mViewSize = 360;
        this.mDesireViewSize = 360;
        this.mBackTextureSize = 180;
        this.mDirectMode = 1;
        this.DEFAULT_PERSPEC_VIEW = 100.0f;
        this.mPerspecView = 100.0f;
        this.mPerspecViewRatio = 1.0f;
        this.mFov = new float[]{100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f};
        this.mHalfEyeDistance = 0.03f;
        this.mIsProcessed = false;
        this.mLensToScreenDistance = 0.042f;
        this.mDistortionCoeffs = new float[]{0.441f, 0.156f};
        this.mTrayToLensDis = 0.035f;
        this.mScreenW = -1;
        this.mScreenH = -1;
        this.DEFAULT_OUT_TEXTURE_SCALE = 1.1f;
        this.mOutTextureScale = 1.1f;
        this.mTextureVerticesRight = null;
        this.mEBO = -1;
        this.mTexVBO = -1;
        this.mVerVBO = -1;
        this.mCMPFaceInnerPadding = 0.0f;
        this.mHeadposeCallbackCounter = 0;
        this.mLastCallbackHeadpose = null;
        this.mFreezeDirector = 0;
        this.mOrientationEventHandler = null;
        construct();
    }

    public void construct() {
        this.mOrder = 90;
        this.mEnableTouchScaler = true;
        this.mTouchScaler = new TouchScaler(this.mTexType);
        this.mDistortion = new BrownDistortion(this.mDistortionCoeffs, this.mTexType);
        int i = RESOLUTION;
        this.mDistortionTex = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, i * i * 2);
        int i2 = RESOLUTION;
        this.mDistortionPos = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, i2 * i2 * 2);
        int i3 = RESOLUTION;
        this.mDistortionIndex = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 2, ((i3 - 1) * 2 * i3) + (i3 - 2));
        this.mDistortionTriangleBuffer = new FloatBuffer[2];
        this.mDistortionTextureBuffer = new FloatBuffer[2];
        this.mDistortionIndexBuffer = new ShortBuffer[2];
        this.mFovTan = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 4);
        float[] fArr = new float[16];
        this.mIdentityMat = fArr;
        Matrix.setIdentityM(fArr, 0);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new GLPanoramaFilter,this:" + this);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        boolean z;
        TouchScaler touchScaler;
        Context context;
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_VR_MODEL)) {
            int i = bundle.getInt(TextureRenderKeys.KEY_IS_VR_MODEL);
            this.mVRModel = i;
            this.mVideoProjectModel = i;
        }
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_VIDEO_PROJECTION_MODEL)) {
            this.mVideoProjectModel = bundle.getInt(TextureRenderKeys.KEY_IS_VIDEO_PROJECTION_MODEL);
        }
        this.mViewSize = bundle.getInt(TextureRenderKeys.KEY_IS_VIEW_SIZE, 360);
        if (super.init(bundle) != 0) {
            if (this.mSurfaceTexture == null) {
                return -1;
            }
            this.mSurfaceTexture.notifyError(10, this.mEffectType, "super.init(bundle) != TR_OK");
            return -1;
        }
        this.mMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "u_MVPMatrix");
        this.mExpandCoefHandle = GLES20.glGetUniformLocation(this.mProgram, "expandCoef");
        this.mZOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "zOffset");
        Matrix.setIdentityM(this.mModelMatrix, 0);
        Matrix.setIdentityM(this.mViewMatrix, 0);
        Matrix.setIdentityM(this.mProjectionMatrix, 0);
        this.mIsProcessed = false;
        this.mFreezeDirector = 0;
        this.mPanoMode = bundle.getInt(TextureRenderKeys.KEY_IS_PANORAMA_MODE, 2);
        boolean z2 = true;
        this.mVideoStyle = bundle.getInt(TextureRenderKeys.KEY_IS_VIDEO_STYLE, 1);
        this.mDirectMode = bundle.getInt(TextureRenderKeys.KEY_IS_DIRECT_MODE, 1);
        this.mUseInitialHeadPoseAsFront = bundle.getInt(TextureRenderKeys.KEY_IS_USE_INITIAL_HEAD_POSE_AS_FRONT, 0) != 0;
        this.mPerspecView = bundle.getFloat(TextureRenderKeys.KEY_IS_PERSPECTIVE_VIEW, this.DEFAULT_PERSPEC_VIEW);
        this.mDesireViewSize = bundle.getInt(TextureRenderKeys.KEY_IS_DESIRE_VIEW_SIZE, this.mViewSize);
        this.mOutTextureScale = bundle.getFloat(TextureRenderKeys.KEY_IS_VR_OUT_TEXTURE_SCALE, this.DEFAULT_OUT_TEXTURE_SCALE);
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_BACKGROUND_TEXTURE_SIZE)) {
            this.mBackTextureSize = bundle.getInt(TextureRenderKeys.KEY_IS_BACKGROUND_TEXTURE_SIZE);
        }
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_EXPAND_COEF)) {
            this.mExpandCoef = bundle.getFloat(TextureRenderKeys.KEY_IS_EXPAND_COEF);
        }
        this.mZOffset = bundle.getFloat(TextureRenderKeys.KEY_IS_Z_OFFSET, 0.0f);
        this.mOffsetYaw = bundle.getInt(TextureRenderKeys.KEY_IS_YAW);
        this.mOffsetPitch = bundle.getInt(TextureRenderKeys.KEY_IS_PITCH);
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_SPACE_ORIENTATION_PITCH)) {
            this.mSpaceOrientationPitch = bundle.getInt(TextureRenderKeys.KEY_IS_SPACE_ORIENTATION_PITCH);
        }
        this.mCMPFaceInnerPadding = bundle.getFloat(TextureRenderKeys.KEY_IS_CMP_FACE_INNER_PADDING, 0.0f);
        if (this.mDisplay == null) {
            this.mDisplay = ((WindowManager) TextureRenderManager.getManager().getContext().getSystemService("window")).getDefaultDisplay();
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "display rotation:" + this.mDisplay.getRotation() + ",perspec:" + this.mPerspecView);
        updateRenderParam(null, null);
        initGLData();
        TouchDirector touchDirector = new TouchDirector(this.mDisplay);
        this.mTouchDirector = touchDirector;
        touchDirector.start();
        this.mTouchDirector.setRadius(800.0f);
        if (this.mSensorDirector == null) {
            if (DeviceManager.isVRDevice()) {
                this.mSensorDirector = new PicoDirector(this.mDisplay);
            } else {
                Context context2 = TextureRenderManager.getManager().getContext();
                if (context2 != null) {
                    this.mSensorDirector = new SensorDirector(context2, this.mDisplay, bundle.getInt(TextureRenderKeys.KEY_IS_SENSOR_START_POS, 1), bundle.getInt(TextureRenderKeys.KEY_IS_SENSOR_RESET_POS, 2), this.mTexType, bundle.getInt(TextureRenderKeys.KEY_IS_SENSOR_SMOOTHER_ENABLED, 0), bundle.getFloat(TextureRenderKeys.KEY_IS_SENSOR_SMOOTH_FACTOR, 1.0f), this);
                }
            }
        }
        IDirector iDirector = this.mSensorDirector;
        if (iDirector != null) {
            iDirector.setParam(bundle);
        }
        if (this.mOrientationEventHandler == null && bundle.getInt(TextureRenderKeys.KEY_IS_HANDLE_DEVICE_ORIENTATION_ENABLED, 0) != 0 && !DeviceManager.isVRDevice() && (context = TextureRenderManager.getManager().getContext()) != null) {
            this.mOrientationEventHandler = new OrientationEventHandler(context);
        }
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_FOV)) {
            this.mFov = bundle.getFloatArray(TextureRenderKeys.KEY_IS_FOV);
            z = true;
        } else {
            z = false;
        }
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_DISTORTION_COEFFS)) {
            this.mDistortionCoeffs = bundle.getFloatArray(TextureRenderKeys.KEY_IS_DISTORTION_COEFFS);
            z = true;
        }
        if (bundle.containsKey(TextureRenderKeys.KEY_IS_LENS_TO_SCREEN_DISTANCE)) {
            this.mLensToScreenDistance = bundle.getFloat(TextureRenderKeys.KEY_IS_LENS_TO_SCREEN_DISTANCE);
        } else {
            z2 = z;
        }
        updateDistortionParam(z2);
        if (this.mEnableTouchScaler && (touchScaler = this.mTouchScaler) != null) {
            touchScaler.setMaxScale(bundle.getFloat(TextureRenderKeys.KEY_IS_VR_MAX_SCALE, 4.0f));
            this.mTouchScaler.setMinScale(bundle.getFloat(TextureRenderKeys.KEY_IS_VR_MIN_SCALE, 0.2f));
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "init, this:" + this + ",manu:" + Build.MANUFACTURER);
        return 0;
    }

    private void initGLData() {
        if (this.mEBO <= 0) {
            int[] iArr = new int[1];
            GLES20.glGenBuffers(1, iArr, 0);
            int i = iArr[0];
            if (i == 0) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "glGenBuffers bufferID: 0");
                return;
            }
            this.mEBO = i;
        }
        GLES20.glBindBuffer(34963, this.mEBO);
        this.mIndexBuffers.position(0);
        GLES20.glBufferData(34963, this.mIndexBuffers.capacity() * 2, this.mIndexBuffers, 35044);
        GLES20.glBindBuffer(34963, 0);
        if (this.mVerVBO <= 0) {
            int[] iArr2 = new int[1];
            GLES20.glGenBuffers(1, iArr2, 0);
            int i2 = iArr2[0];
            if (i2 == 0) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "glGenBuffers bufferID: 0");
                return;
            }
            this.mVerVBO = i2;
        }
        GLES20.glBindBuffer(34962, this.mVerVBO);
        this.mTriangleVertices.position(0);
        GLES20.glBufferData(34962, this.mTriangleVertices.capacity() * 4, this.mTriangleVertices, 35044);
        GLES20.glBindBuffer(34962, 0);
        if (this.mTexVBO <= 0) {
            int[] iArr3 = new int[1];
            GLES20.glGenBuffers(1, iArr3, 0);
            int i3 = iArr3[0];
            if (i3 == 0) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "glGenBuffers bufferID: 0");
                return;
            }
            this.mTexVBO = i3;
        }
        GLES20.glBindBuffer(34962, this.mTexVBO);
        this.mTextureVertices.position(0);
        GLES20.glBufferData(34962, this.mTextureVertices.capacity() * 4, this.mTextureVertices, 35044);
        GLES20.glBindBuffer(34962, 0);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        EffectTexture effectTextureGenTexture;
        EffectTexture effectTextureGenTexture2;
        Quaternion quaternion;
        float[] fArr;
        if (!this.mIsProcessed) {
            this.mIsProcessed = true;
            OrientationEventHandler orientationEventHandler = this.mOrientationEventHandler;
            if (orientationEventHandler != null) {
                orientationEventHandler.enable();
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
        if (!this.mSensorDirectorEnabled && (fArr = this.mFreezeModelMatrix) != null) {
            this.mModelMatrix = fArr;
            if (!this.mDidGetInitialModelMatrix) {
                IDirector iDirector = this.mSensorDirector;
                if (iDirector != null && this.mDirectMode != 2) {
                    iDirector.getView(fArr, 0);
                }
                Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
                float[] fArr2 = this.mModelMatrix;
                Matrix.multiplyMM(fArr2, 0, fArr2, 0, this.mInitialModelMatrixInvert, 0);
                this.mFreezeModelMatrix = this.mModelMatrix;
                this.mDidGetInitialModelMatrix = true;
            }
        } else {
            IDirector iDirector2 = this.mSensorDirector;
            if (iDirector2 != null && this.mDirectMode != 2) {
                iDirector2.getView(this.mModelMatrix, 0);
            }
            if (!this.mDidGetInitialModelMatrix) {
                Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
                this.mDidGetInitialModelMatrix = true;
            }
            if (this.mDirectMode != 2 && this.mUseInitialHeadPoseAsFront) {
                float[] fArr3 = this.mModelMatrix;
                Matrix.multiplyMM(fArr3, 0, fArr3, 0, this.mInitialModelMatrixInvert, 0);
            }
        }
        Matrix.setIdentityM(this.mRotateMatrix, 0);
        if (!DeviceManager.isVRDevice() || this.mOffsetYaw != 0 || this.mOffsetPitch != 0) {
            Matrix.rotateM(this.mRotateMatrix, 0, this.mOffsetPitch + this.mTouchDirector.getDiffX(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.mRotateMatrix, 0, this.mTouchDirector.getDiffY() - this.mOffsetYaw, 0.0f, 1.0f, 0.0f);
        }
        Matrix.rotateM(this.mRotateMatrix, 0, this.mSpaceOrientationPitch, 1.0f, 0.0f, 0.0f);
        float[] fArr4 = new float[16];
        Matrix.multiplyMM(fArr4, 0, this.mModelMatrix, 0, this.mRotateMatrix, 0);
        Matrix.invertM(fArr4, 0, fArr4, 0);
        Quaternion quaternion2 = new Quaternion(fArr4);
        this.mSurfaceTexture.setHeadPose(quaternion2);
        this.mHeadposeCallbackCounter++;
        int intOption = this.mHeadposeCallbackCounter % (this.mSurfaceTexture != null ? this.mSurfaceTexture.getIntOption(135) : 1);
        this.mHeadposeCallbackCounter = intOption;
        if (intOption == 0 && ((quaternion = this.mLastCallbackHeadpose) == null || Math.abs(quaternion.getX0() - quaternion2.getX0()) + Math.abs(this.mLastCallbackHeadpose.getX1() - quaternion2.getX1()) + Math.abs(this.mLastCallbackHeadpose.getX2() - quaternion2.getX2()) + Math.abs(this.mLastCallbackHeadpose.getX3() - quaternion2.getX3()) > 0.001d)) {
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.onHeadposeChanged(quaternion2);
            }
            this.mLastCallbackHeadpose = quaternion2;
        }
        float scale = this.mTouchScaler.getScale();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.mProgram, "rotateMatrix"), 1, false, this.mRotateMatrix, 0);
        if (this.mVRModel == 3) {
            GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.mProgram, "texOffset"), 6, this.mCubeTexOffsetPerFace, 0);
            GLES20.glUniformMatrix2fv(GLES20.glGetUniformLocation(this.mProgram, "rotates"), 6, false, this.mCubeRotatesPerFace, 0);
            GLES20.glUniform3f(this.mZOffsetHandle, 0.0f, 0.0f, this.mZOffset);
        }
        GLES20.glUniform1f(this.mExpandCoefHandle, this.mExpandCoef);
        float viewportWidth = (this.mSurfaceTexture.getViewportWidth() * 1.0f) / this.mSurfaceTexture.getViewportHeight();
        this.mPerspecViewRatio = viewportWidth > 1.0f ? viewportWidth : 1.0f;
        if (frameBuffer != null) {
            updateOutTexSize(viewportWidth);
            effectTextureGenTexture = genTexture();
            if (effectTextureGenTexture == null) {
                return effectTexture;
            }
            frameBuffer.bindTexture2D(effectTextureGenTexture.getTexID());
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
        if (this.mPanoMode == 1) {
            GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, TEXSCALE_2D, 0);
            Matrix.perspectiveM(this.mProjectionMatrix, 0, this.mPerspecView / this.mPerspecViewRatio, viewportWidth, 0.1f, 100.0f);
            Matrix.scaleM(this.mProjectionMatrix, 0, scale, scale, 1.0f);
            GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
            Matrix.setLookAtM(this.mViewMatrix, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
            draw(this.mIndexBuffers);
            effectTexture.giveBack();
        } else {
            if (!DeviceManager.isVRDevice()) {
                updateDistortionParam(false);
                float[] fArr5 = this.mProjectionMatrix;
                float[] fArr6 = this.mFovTan[LEFT];
                float f = -fArr6[0];
                float f2 = ZNEAR;
                Matrix.frustumM(fArr5, 0, f * f2, fArr6[1] * f2, (-fArr6[2]) * f2, fArr6[3] * f2, f2, ZFAR);
            } else {
                Matrix.perspectiveM(this.mProjectionMatrix, 0, this.mPerspecView, viewportWidth / 2.0f, 0.1f, 100.0f);
            }
            if (this.mVideoStyle == 4) {
                GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, SIDE_BY_SIDE_TEXSCALE_LEFT, 0);
            } else {
                GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, TOP_BOTTOM_TEXSCALE_LEFT, 0);
            }
            GLES20.glViewport(0, 0, this.mViewPortWidth / 2, this.mViewPortHeight);
            Matrix.setLookAtM(this.mViewMatrix, 0, DeviceManager.isVRDevice() ? 0.0f : -this.mHalfEyeDistance, 0.0f, 0.0f, DeviceManager.isVRDevice() ? 0.0f : -this.mHalfEyeDistance, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
            draw(this.mIndexBuffers);
            FloatBuffer floatBuffer = this.mTextureVerticesRight;
            if (floatBuffer != null) {
                floatBuffer.position(0);
                GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, (Buffer) this.mTextureVerticesRight);
                GLES20.glEnableVertexAttribArray(this.maTextureHandle);
            }
            if (!DeviceManager.isVRDevice()) {
                float[] fArr7 = this.mProjectionMatrix;
                float[] fArr8 = this.mFovTan[RIGHT];
                float f3 = -fArr8[0];
                float f4 = ZNEAR;
                Matrix.frustumM(fArr7, 0, f3 * f4, fArr8[1] * f4, (-fArr8[2]) * f4, fArr8[3] * f4, f4, ZFAR);
            }
            if (this.mVideoStyle == 4) {
                GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, SIDE_BY_SIDE_TEXSCALE_RIGHT, 0);
            } else {
                GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, TOP_BOTTOM_TEXSCALE_RIGHT, 0);
            }
            GLES20.glViewport(this.mViewPortWidth / 2, 0, this.mViewPortWidth / 2, this.mViewPortHeight);
            Matrix.setLookAtM(this.mViewMatrix, 0, DeviceManager.isVRDevice() ? 0.0f : this.mHalfEyeDistance, 0.0f, 0.0f, DeviceManager.isVRDevice() ? 0.0f : this.mHalfEyeDistance, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
            draw(this.mIndexBuffers);
            effectTexture.giveBack();
            if (!DeviceManager.isVRDevice()) {
                if (frameBuffer != null) {
                    effectTextureGenTexture2 = genTexture();
                    if (effectTextureGenTexture2 != null) {
                        frameBuffer.bindTexture2D(effectTextureGenTexture2.getTexID());
                    }
                } else {
                    effectTextureGenTexture2 = null;
                }
                GLES20.glUseProgram(this.mProgram);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16384);
                GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(this.mInTextureTarget, effectTextureGenTexture.getTexID());
                GLES20.glUniform1i(this.mInputTextureHandle, 0);
                GLES20.glUniformMatrix4fv(this.mMVPMatrixHandle, 1, false, this.mIdentityMat, 0);
                GLES20.glEnable(3089);
                GLES20.glScissor(this.mViewPortX, this.mViewPortY, this.mViewPortWidth / 2, this.mViewPortHeight);
                renderDistortion(LEFT);
                GLES20.glScissor((this.mViewPortWidth / 2) + this.mViewPortX, this.mViewPortY, this.mViewPortWidth / 2, this.mViewPortHeight);
                renderDistortion(RIGHT);
                GLES20.glDisable(3089);
                effectTextureGenTexture.giveBack();
                effectTextureGenTexture = effectTextureGenTexture2;
            }
        }
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
        GLES20.glFinish();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.currentEffectProcessEnd(this.mEffectType);
        }
        int iCheckGLError = TexGLUtils.checkGLError(this.mTexType, "error pano draw");
        if (iCheckGLError != 0 && this.mSurfaceTexture != null) {
            this.mSurfaceTexture.notifyError(iCheckGLError, this.mEffectType, "error pano draw");
        }
        if (frameBuffer == null) {
            return null;
        }
        frameBuffer.unbindTexture2D();
        return effectTextureGenTexture;
    }

    protected void updateOutTexSize(float f) {
        if (this.mVideoProjectModel == 2 && this.mViewSize == 180) {
            this.mOutTexHeight = (int) Math.ceil(((this.mPerspecView / this.mPerspecViewRatio) / 90.0f) * this.mSurfaceTexture.getTexHeight() * this.mOutTextureScale);
        } else {
            this.mOutTexHeight = (int) Math.ceil(((this.mPerspecView / this.mPerspecViewRatio) / 180.0f) * this.mSurfaceTexture.getTexHeight() * this.mOutTextureScale);
        }
        this.mOutTexHeight = ((4 - (this.mOutTexHeight % 4)) % 4) + this.mOutTexHeight;
        this.mOutTexWidth = (int) Math.ceil(this.mOutTexHeight * 1.0f * f);
        TextureRenderLog.d(this.mTexType, LOG_TAG, "pano OutTex h:" + this.mOutTexHeight + " w:" + this.mOutTexWidth + ",viewPortRatio:" + f + ", this:" + this);
    }

    protected void draw(ShortBuffer shortBuffer) {
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, 0, this.mViewMatrix, 0, this.mModelMatrix, 0);
        Matrix.multiplyMM(fArr, 0, this.mProjectionMatrix, 0, fArr, 0);
        GLES20.glUniformMatrix4fv(this.mMVPMatrixHandle, 1, false, fArr, 0);
        shortBuffer.position(0);
        GLES20.glBindBuffer(34963, this.mEBO);
        GLES20.glDrawElements(4, shortBuffer.remaining(), 5123, 0);
        GLES20.glBindBuffer(34963, 0);
    }

    private void renderDistortion(int i) {
        this.mDistortionTriangleBuffer[i].position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 2, 5126, false, 8, (Buffer) this.mDistortionTriangleBuffer[i]);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mDistortionTextureBuffer[i].position(0);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 8, (Buffer) this.mDistortionTextureBuffer[i]);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        this.mDistortionIndexBuffer[i].position(0);
        GLES20.glDrawElements(5, this.mDistortionIndexBuffer[i].remaining(), 5123, this.mDistortionIndexBuffer[i]);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        IDirector iDirector = this.mSensorDirector;
        if (iDirector != null) {
            iDirector.stop();
            this.mSensorDirector = null;
        }
        OrientationEventHandler orientationEventHandler = this.mOrientationEventHandler;
        if (orientationEventHandler != null) {
            orientationEventHandler.disable();
            this.mOrientationEventHandler = null;
        }
        this.mIsProcessed = false;
        return super.release();
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, int i2) {
        TouchDirector touchDirector;
        if (i != 1) {
            if (i == 101) {
                this.mPanoMode = i2;
                return;
            }
            if (i == 102) {
                this.mVideoStyle = i2;
                updateRenderParam(null, null);
                return;
            }
            if (i == 105) {
                this.mDirectMode = i2;
                handleDirectModeChange();
                return;
            }
            if (i != 106) {
                if (i == 108) {
                    this.mOffsetYaw = i2;
                } else if (i == 109) {
                    this.mOffsetPitch = i2;
                } else {
                    if (i == 128) {
                        this.mDidGetInitialModelMatrix = false;
                        if (i2 == 0 || (touchDirector = this.mTouchDirector) == null) {
                            return;
                        }
                        touchDirector.reset();
                        return;
                    }
                    if (i == 129) {
                        boolean z = i2 != 0;
                        this.mSensorDirectorEnabled = z;
                        if (z) {
                            return;
                        }
                        this.mFreezeModelMatrix = this.mModelMatrix;
                        return;
                    }
                    switch (i) {
                        case 137:
                            this.mFreezeDirector = i2;
                            if (i2 == 0) {
                                handleDirectModeChange();
                                return;
                            }
                            if (i2 == 1 || i2 == 2) {
                                IDirector iDirector = this.mSensorDirector;
                                if (iDirector != null) {
                                    iDirector.stop();
                                }
                                if (i2 != 2 || this.mSurfaceTexture == null) {
                                    return;
                                }
                                this.mSurfaceTexture.unRegisterTouchListener(this.mTouchDirector);
                                return;
                            }
                            return;
                        case 138:
                            this.mSpaceOrientationPitch = i2;
                            break;
                        case 139:
                            TouchScaler touchScaler = this.mTouchScaler;
                            if (touchScaler == null || !this.mEnableTouchScaler) {
                                return;
                            }
                            touchScaler.stop();
                            this.mTouchScaler.start();
                            return;
                    }
                }
            } else if (this.mSensorDirector != null) {
                if (i2 == 1) {
                    OrientationEventHandler orientationEventHandler = this.mOrientationEventHandler;
                    if (orientationEventHandler != null) {
                        orientationEventHandler.disable();
                    }
                    this.mSensorDirector.stop();
                } else {
                    OrientationEventHandler orientationEventHandler2 = this.mOrientationEventHandler;
                    if (orientationEventHandler2 != null) {
                        orientationEventHandler2.enable();
                    }
                    startSensorDirector();
                }
            }
        } else if (this.mSensorDirector != null) {
            if (i2 == 3) {
                OrientationEventHandler orientationEventHandler3 = this.mOrientationEventHandler;
                if (orientationEventHandler3 != null) {
                    orientationEventHandler3.disable();
                }
                this.mSensorDirector.stop();
                this.mSensorDirector.reset();
                this.mTouchDirector.stop();
                this.mTouchDirector.reset();
                this.mTouchScaler.stop();
                this.mFreezeDirector = 0;
            } else if (i2 == 1) {
                OrientationEventHandler orientationEventHandler4 = this.mOrientationEventHandler;
                if (orientationEventHandler4 != null) {
                    orientationEventHandler4.enable();
                }
                startSensorDirector();
                this.mTouchDirector.start();
                this.mTouchScaler.start();
            }
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "setOption key:" + i + " value:" + i2 + ", this:" + this);
        super.setOption(i, i2);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int i, float f) {
        if (i == 103) {
            this.mPerspecView = f;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "perspective view:" + f);
            return;
        }
        if (i == 104) {
            this.mHalfEyeDistance = f / 2.0f;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "eye disfance:" + f);
        } else if (i == 111) {
            this.mZOffset = f;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "set zoffset:" + f);
        } else if (i == 164) {
            this.mOutTextureScale = f;
            TextureRenderLog.i(this.mTexType, LOG_TAG, "set textureScale:" + f);
        } else {
            super.setOption(i, f);
        }
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int i) {
        if (i == 11000) {
            return "attribute vec4 aPosition;\nuniform mat4 u_MVPMatrix;\nuniform mat4 rotateMatrix;attribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;void main() {\n  gl_Position =  u_MVPMatrix * rotateMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n  verPosition = aPosition.xyz;}\n";
        }
        if (i == 11001) {
            int i2 = this.mVRModel;
            return i2 == 2 ? this.mViewSize == 180 ? "#define PI 3.14159265359\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = -1.0 / 6.0 + step(1.0 / 6.0, oriCoord.x) / 3.0 + step(3.0 / 6.0, oriCoord.x) / 3.0 + step(2.0 / 3.0, oriCoord.x) / 6.0;\n    float yStep = 0.0;\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 2.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 2.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = step(0.0, -verPosition.z) * texture2D(sTexture, eacResult.xy);\n}" : "#define PI 3.14159265359\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = 1.0 / 3.0 * clamp(floor(oriCoord.x * 3.0), 0.0, 2.0);\n    float yStep = 0.5 * step(0.5, oriCoord.y);\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 4.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 4.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture,  eacResult.xy);\n}" : i2 == 3 ? "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nvarying vec3 verPosition;\nuniform vec3 zOffset;\nuniform int cubemapMode;\nuniform vec2 texOffset[6];\nuniform mat2 rotates[6];\nuniform mat3 texScale;//one eye and two eye scale\nvec2 cubeToTexture(vec3 cubeCoord, float expand) {\n    vec2 result;\n    float absX = abs(cubeCoord.x);\n    float absY = abs(cubeCoord.y);\n    float absZ = abs(cubeCoord.z);\n    int index;//0:left 1:front 2:right 3:top 4:back 5:bottom\n    if (-cubeCoord.z >= absX && -cubeCoord.z >= absY) {\n        result = vec2(cubeCoord.x, cubeCoord.y);\n        index = 1;\n    } else if (cubeCoord.z >= absX && cubeCoord.z >= absY) {\n        result = vec2(-cubeCoord.x, cubeCoord.y);\n        index = 4;\n    } else if (cubeCoord.y >= absX && cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, cubeCoord.z);\n        index = 3;\n    } else if (-cubeCoord.y >= absX && -cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, -cubeCoord.z);\n        index = 5;\n    } else if (cubeCoord.x >= absY && cubeCoord.x >= absZ) {\n        result = vec2(cubeCoord.z, cubeCoord.y);\n        index = 2;\n    } else {\n        result = vec2(-cubeCoord.z, cubeCoord.y);\n        index = 0;\n    }\n    result = result * rotates[index] / expand;\n    result = vec2((result.x + 1.0) / 6.0, (result.y + 1.0) / 4.0) + texOffset[index];\n    return result;\n}\nvec2 offsetCubicTransFunc(vec3 inCubePosition) {\n    inCubePosition = inCubePosition - zOffset;\n    inCubePosition = inCubePosition / max(max(abs(inCubePosition.x),abs(inCubePosition.y)),abs(inCubePosition.z));\n    return cubeToTexture(inCubePosition, expandCoef);\n}\nvoid main() {\n    vec3 result = vec3(offsetCubicTransFunc(verPosition),1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}" : (i2 == 4 || i2 == 5) ? cubemapShaderFragment : super.getStringOption(i);
        }
        return super.getStringOption(i);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle bundle) {
        if (bundle != null && this.mEffectType == bundle.getInt(TextureRenderKeys.KEY_IS_EFFECT_TYPE)) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, " setOption:" + bundle.toString() + ",this:" + this);
            if (bundle.getInt("action") != 134) {
                return;
            }
            IDirector iDirector = this.mSensorDirector;
            if (iDirector != null) {
                iDirector.stop();
                this.mSensorDirector.reset();
                startSensorDirector();
            }
            TouchDirector touchDirector = this.mTouchDirector;
            if (touchDirector != null) {
                touchDirector.stop();
                this.mTouchDirector.reset();
                this.mTouchDirector.start();
            }
            TouchScaler touchScaler = this.mTouchScaler;
            if (touchScaler == null || !this.mEnableTouchScaler) {
                return;
            }
            touchScaler.stop();
            this.mTouchScaler.start();
            return;
        }
        super.setOption(bundle);
    }

    protected void handleDirectModeChange() {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "handleDirectModeChange mDirectMode:" + this.mDirectMode + ", this:" + this);
        int i = this.mDirectMode;
        if (i == 1) {
            startSensorDirector();
            if (this.mSurfaceTexture != null) {
                this.mSurfaceTexture.unRegisterTouchListener(this.mTouchDirector);
                return;
            }
            return;
        }
        if (i == 2) {
            IDirector iDirector = this.mSensorDirector;
            if (iDirector != null) {
                iDirector.stop();
            }
            registTouchDirector();
            return;
        }
        startSensorDirector();
        registTouchDirector();
    }

    protected void startSensorDirector() {
        IDirector iDirector = this.mSensorDirector;
        if (iDirector != null) {
            if (this.mFreezeDirector == 0) {
                iDirector.start();
            } else {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "freezing,don't start,this:" + this);
            }
        }
    }

    protected void registTouchDirector() {
        if (this.mSurfaceTexture == null || this.mTouchDirector == null) {
            return;
        }
        if (this.mFreezeDirector == 2) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "freezing touch,don't regist,this:" + this);
        } else {
            this.mSurfaceTexture.registerTouchListener(this.mTouchDirector);
        }
    }

    protected void handleTouchScalerChange() {
        if (this.mSurfaceTexture == null) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "Error: handleTouchScalerChange mSurfaceTexture is null");
            return;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "handleTouchScalerChange mEnableTouchScaler:" + this.mEnableTouchScaler + ", this:" + this);
        if (this.mEnableTouchScaler) {
            this.mTouchScaler.start();
            this.mSurfaceTexture.registerTouchListener(this.mTouchScaler);
        } else {
            this.mSurfaceTexture.unRegisterTouchListener(this.mTouchScaler);
            this.mTouchScaler.stop();
        }
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        float[] fArr;
        float[][] fArr2;
        int i;
        short[] sArr;
        int i2;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "handleModlelChange mVideoStyle:" + this.mVideoStyle + ", this:" + this);
        float f = 2.0f;
        int i3 = 2;
        if (this.mVideoStyle != 1) {
            int i4 = this.mVRModel;
            if (i4 == 1 || i4 == 3 || i4 == 6) {
                int i5 = (int) ((this.mDesireViewSize * 150.0d) / 360.0d);
                float f2 = (float) ((r4 / 180) * 3.141592653589793d);
                float f3 = 1.0f / 75;
                float f4 = 1.0f / i5;
                int i6 = i5 + 1;
                int i7 = 76 * i6;
                fArr = new float[i7 * 3];
                short[] sArr2 = new short[i7 * 6];
                short s = 0;
                int i8 = 0;
                for (short s2 = 76; s < s2; s2 = 76) {
                    short[] sArr3 = sArr2;
                    double d = s * 3.1415927f * f3;
                    float fCos = (float) Math.cos(d);
                    float fSin = (float) Math.sin(d);
                    short s3 = 0;
                    while (s3 < i6) {
                        double d2 = (3.1415927f - (f2 / f)) + (s3 * f2 * f4);
                        int i9 = i5;
                        double d3 = fSin;
                        int i10 = i6;
                        float f5 = -((float) (Math.sin(d2) * d3));
                        float fCos2 = (float) (Math.cos(d2) * d3);
                        int i11 = i8 + 1;
                        float f6 = mRadius;
                        fArr[i8] = f5 * f6;
                        int i12 = i11 + 1;
                        fArr[i11] = fCos * f6;
                        i8 = i12 + 1;
                        fArr[i12] = fCos2 * f6;
                        s3 = (short) (s3 + 1);
                        i5 = i9;
                        i6 = i10;
                        f = 2.0f;
                    }
                    s = (short) (s + 1);
                    sArr2 = sArr3;
                    f = 2.0f;
                }
                short[] sArr4 = sArr2;
                int i13 = i5;
                int i14 = i6;
                int i15 = i7 * 2;
                fArr2 = new float[][]{new float[i15], null};
                short s4 = 0;
                int i16 = 0;
                int i17 = 0;
                short s5 = 76;
                while (s4 < s5) {
                    int i18 = i14;
                    short s6 = 0;
                    while (s6 < i18) {
                        int i19 = this.mVideoStyle;
                        if (i19 == i3) {
                            int i20 = i16 + 1;
                            fArr2[0][i16] = s6 * f4;
                            if (DeviceManager.isVRDevice()) {
                                fArr2[0][i20] = s4 * f3;
                                i16 = i20 + 1;
                            } else {
                                fArr2[0][i20] = 1.0f - (s4 * f3);
                                i16 = i20 + 1;
                                s6 = (short) (s6 + 1);
                                i3 = 2;
                            }
                        } else if (i19 == 3) {
                            int i21 = i16 + 1;
                            float f7 = s6 * f4;
                            fArr2[0][i16] = f7;
                            if (DeviceManager.isVRDevice()) {
                                i2 = i21 + 1;
                                fArr2[0][i21] = s4 * f3;
                            } else {
                                i2 = i21 + 1;
                                fArr2[0][i21] = 1.0f - ((s4 * f3) * 0.5f);
                            }
                            if (fArr2[1] == null) {
                                fArr2[1] = new float[i15];
                            }
                            int i22 = i17 + 1;
                            fArr2[1][i17] = f7;
                            if (DeviceManager.isVRDevice()) {
                                fArr2[1][i22] = s4 * f3;
                                i17 = i22 + 1;
                                i16 = i2;
                            } else {
                                fArr2[1][i22] = 0.5f - ((s4 * f3) * 0.5f);
                                i17 = i22 + 1;
                                i16 = i2;
                            }
                        } else if (i19 == 4) {
                            if (DeviceManager.isVRDevice()) {
                                float[] fArr3 = fArr2[0];
                                int i23 = i16 + 1;
                                fArr3[i16] = s6 * f4;
                                i16 = i23 + 1;
                                fArr3[i23] = s4 * f3;
                            } else {
                                float[] fArr4 = fArr2[0];
                                int i24 = i16 + 1;
                                fArr4[i16] = s6 * f4 * 0.5f;
                                i16 = i24 + 1;
                                fArr4[i24] = 1.0f - (s4 * f3);
                            }
                            if (fArr2[1] == null) {
                                fArr2[1] = new float[i15];
                            }
                            if (DeviceManager.isVRDevice()) {
                                float[] fArr5 = fArr2[1];
                                int i25 = i17 + 1;
                                fArr5[i17] = s6 * f4;
                                i17 = i25 + 1;
                                fArr5[i25] = s4 * f3;
                            } else {
                                float[] fArr6 = fArr2[1];
                                int i26 = i17 + 1;
                                fArr6[i17] = (s6 * f4 * 0.5f) + 0.5f;
                                i17 = i26 + 1;
                                fArr6[i26] = 1.0f - (s4 * f3);
                            }
                        }
                        s6 = (short) (s6 + 1);
                        i3 = 2;
                    }
                    s4 = (short) (s4 + 1);
                    i14 = i18;
                    s5 = 76;
                    i3 = 2;
                }
                int i27 = i14;
                short s7 = 0;
                int i28 = 0;
                while (s7 < 75) {
                    int i29 = i13;
                    short s8 = 0;
                    while (s8 < i29) {
                        int i30 = i28 + 1;
                        int i31 = s7 * i27;
                        sArr4[i28] = (short) (i31 + s8);
                        int i32 = i30 + 1;
                        int i33 = (s7 + 1) * i27;
                        short s9 = (short) (i33 + s8);
                        sArr4[i30] = s9;
                        int i34 = i32 + 1;
                        int i35 = s8 + 1;
                        short s10 = (short) (i31 + i35);
                        sArr4[i32] = s10;
                        int i36 = i34 + 1;
                        sArr4[i34] = s10;
                        int i37 = i36 + 1;
                        sArr4[i36] = s9;
                        i28 = i37 + 1;
                        sArr4[i37] = (short) (i33 + i35);
                        s8 = (short) i35;
                    }
                    s7 = (short) (s7 + 1);
                    i13 = i29;
                }
                if (this.mVRModel == 3) {
                    this.mCubeTexOffsetPerFace = new float[]{0.0f, 0.0f, 0.33333334f, 0.0f, 0.6666667f, 0.0f, 0.0f, 0.5f, 0.33333334f, 0.5f, 0.6666667f, 0.5f};
                    this.mCubeRotatesPerFace = new float[]{1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f};
                }
                sArr = sArr4;
                i = 0;
            } else {
                if (i4 == 2 || i4 == 4 || i4 == 5) {
                    fArr = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f};
                    sArr = new short[]{0, 1, 2, 1, 2, 3, 4, 5, 6, 5, 6, 7, 8, 9, 10, 9, 10, 11, 12, 13, 14, 13, 14, 15, 16, 17, 18, 17, 18, 19, 20, 21, 22, 21, 22, 23};
                    fArr2 = new float[2][];
                    if (i4 == 5) {
                        float f8 = this.mCMPFaceInnerPadding;
                        float f9 = 0.16666667f;
                        float f10 = 0.16666667f - (0.33333334f * f8);
                        float f11 = 0.25f - (f8 * 0.5f);
                        fArr2[0] = new float[48];
                        int i38 = 0;
                        for (int i39 = 6; i38 < i39; i39 = 6) {
                            int i40 = i38 * 8;
                            float f12 = (((i38 % 3) * 2) + 1) * f9;
                            float f13 = (((i38 / 3) * 2) + 1) * 0.25f;
                            float[] fArr7 = fArr2[0];
                            float f14 = f12 - f10;
                            fArr7[i40 + 0] = f14;
                            float f15 = f13 - f11;
                            fArr7[i40 + 1] = f15;
                            float f16 = f12 + f10;
                            fArr7[i40 + 2] = f16;
                            fArr7[i40 + 3] = f15;
                            fArr7[i40 + 4] = f14;
                            float f17 = f13 + f11;
                            fArr7[i40 + 5] = f17;
                            fArr7[i40 + 6] = f16;
                            fArr7[i40 + 7] = f17;
                            i38++;
                            f9 = 0.16666667f;
                        }
                    } else if (i4 == 4) {
                        fArr2[0] = new float[]{0.0f, 0.0f, 0.33333334f, 0.0f, 0.0f, 0.5f, 0.33333334f, 0.5f, 0.33333334f, 0.0f, 0.6666667f, 0.0f, 0.33333334f, 0.5f, 0.6666667f, 0.5f, 0.6666667f, 0.0f, 1.0f, 0.0f, 0.6666667f, 0.5f, 1.0f, 0.5f, 0.0f, 1.0f, 0.0f, 0.5f, 0.33333334f, 1.0f, 0.33333334f, 0.5f, 0.6666667f, 0.5f, 0.6666667f, 1.0f, 0.33333334f, 0.5f, 0.33333334f, 1.0f, 0.6666667f, 1.0f, 0.6666667f, 0.5f, 1.0f, 1.0f, 1.0f, 0.5f};
                    } else if (this.mViewSize == 360) {
                        fArr2[0] = new float[]{0.0f, 0.5f, 0.33333334f, 0.5f, 0.0f, 1.0f, 0.33333334f, 1.0f, 0.33333334f, 0.5f, 0.6666667f, 0.5f, 0.33333334f, 1.0f, 0.6666667f, 1.0f, 0.6666667f, 0.5f, 1.0f, 0.5f, 0.6666667f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.5f, 0.6666667f, 0.0f, 0.6666667f, 0.5f, 0.33333334f, 0.5f, 0.33333334f, 0.0f, 0.6666667f, 0.5f, 0.6666667f, 0.0f, 0.33333334f, 0.0f, 0.33333334f, 0.5f, 0.0f, 0.0f, 0.0f, 0.5f};
                    } else {
                        fArr2[0] = new float[]{-0.16666667f, 0.0f, 0.16666667f, 0.0f, -0.16666667f, 1.0f, 0.16666667f, 1.0f, 0.16666667f, 0.0f, 0.5f, 0.0f, 0.16666667f, 1.0f, 0.5f, 1.0f, 0.5f, 0.0f, 0.8333333f, 0.0f, 0.5f, 1.0f, 0.8333333f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.6666667f, 0.0f, 0.6666667f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.6666667f, 0.0f, 0.6666667f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.6666667f, 0.0f, 0.6666667f, 1.0f};
                    }
                } else {
                    fArr = null;
                    sArr = null;
                    fArr2 = null;
                }
                i = 0;
            }
        } else {
            if (effectTexture == null) {
                return -1;
            }
            float fTan = (float) (mRadius * Math.tan((((this.mPerspecView - 15.0f) / 2.0f) / 180.0f) * 3.141592653589793d));
            float width = (effectTexture.getWidth() * fTan) / effectTexture.getHeight();
            float f18 = -width;
            float f19 = -fTan;
            float f20 = mRadius;
            fArr = new float[]{f18, f19, -f20, width, f19, -f20, f18, fTan, -f20, width, fTan, -f20};
            TextureRenderLog.i(this.mTexType, LOG_TAG, "triangle ver:" + Arrays.toString(mTriangleVerticesData));
            fArr2 = new float[2][];
            i = 0;
            fArr2[0] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
            sArr = new short[]{0, 1, 2, 1, 2, 3};
        }
        if (fArr2 != null) {
            this.mTextureVertices = ByteBuffer.allocateDirect(fArr2[i].length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            if (this.mTextureVertices != null) {
                this.mTextureVertices.put(fArr2[i]).position(i);
            }
            float[] fArr8 = fArr2[1];
            if (fArr8 != null) {
                FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr8.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                this.mTextureVerticesRight = floatBufferAsFloatBuffer;
                if (floatBufferAsFloatBuffer != null) {
                    floatBufferAsFloatBuffer.put(fArr2[1]).position(0);
                }
            } else {
                this.mTextureVerticesRight = null;
            }
        }
        if (fArr != null) {
            this.mTriangleVertices = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            if (this.mTriangleVertices != null) {
                this.mTriangleVertices.put(fArr).position(0);
            }
        }
        if (sArr == null) {
            return 0;
        }
        this.mIndexBuffers = ByteBuffer.allocateDirect(sArr.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mIndexBuffers.put(sArr).position(0);
        return 0;
    }

    private void updateDistortionParam(boolean z) {
        if (this.mPanoMode != 2 || DeviceManager.isVRDevice()) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = TextureRenderManager.getManager().getContext();
        if (context != null) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        if (displayMetrics.widthPixels == this.mScreenW && displayMetrics.heightPixels == this.mScreenH && !z) {
            return;
        }
        this.mScreenW = displayMetrics.widthPixels;
        this.mScreenH = displayMetrics.heightPixels;
        float f = (displayMetrics.widthPixels / displayMetrics.xdpi) * METERS_PER_INCH;
        float f2 = (displayMetrics.heightPixels / displayMetrics.ydpi) * METERS_PER_INCH;
        float[] fArrCalculateFov = calculateFov(f, f2);
        this.mFovTan[LEFT][0] = (float) Math.tan(fArrCalculateFov[0]);
        this.mFovTan[LEFT][1] = (float) Math.tan(fArrCalculateFov[1]);
        this.mFovTan[LEFT][2] = (float) Math.tan(fArrCalculateFov[2]);
        this.mFovTan[LEFT][3] = (float) Math.tan(fArrCalculateFov[3]);
        this.mFovTan[RIGHT][0] = (float) Math.tan(fArrCalculateFov[1]);
        this.mFovTan[RIGHT][1] = (float) Math.tan(fArrCalculateFov[0]);
        this.mFovTan[RIGHT][2] = (float) Math.tan(fArrCalculateFov[2]);
        this.mFovTan[RIGHT][3] = (float) Math.tan(fArrCalculateFov[3]);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "realFov:" + Arrays.toString(fArrCalculateFov) + "screenWInMeter:" + f + " screenHInMeter:" + f2);
        float f3 = this.mLensToScreenDistance;
        float f4 = f / f3;
        float f5 = f2 / f3;
        float f6 = f / 2.0f;
        float f7 = this.mHalfEyeDistance;
        float f8 = (this.mTrayToLensDis - DEFAULT_BORDER_SIZE_METER) / f3;
        float fTan = (float) (Math.tan(fArrCalculateFov[0]) + Math.tan(fArrCalculateFov[1]));
        float fTan2 = (float) (Math.tan(fArrCalculateFov[2]) + Math.tan(fArrCalculateFov[3]));
        float fTan3 = (float) Math.tan(fArrCalculateFov[0]);
        float fTan4 = (float) Math.tan(fArrCalculateFov[1]);
        float fTan5 = (float) Math.tan(fArrCalculateFov[2]);
        updateMesh(LEFT, f4, f5, (f6 - f7) / f3, f8, fTan, fTan2, fTan3, fTan5);
        updateMesh(RIGHT, f4, f5, (f6 + f7) / f3, f8, fTan, fTan2, fTan4, fTan5);
    }

    private float[] calculateFov(float f, float f2) {
        float f3 = this.mHalfEyeDistance;
        float f4 = this.mTrayToLensDis - DEFAULT_BORDER_SIZE_METER;
        return new float[]{Math.min((float) Math.atan(this.mDistortion.distort(((f / 2.0f) - f3) / this.mLensToScreenDistance, 0.0f)[0]), (float) Math.toRadians(this.mFov[0])), Math.min((float) Math.atan(this.mDistortion.distort(f3 / this.mLensToScreenDistance, 0.0f)[0]), (float) Math.toRadians(this.mFov[1])), Math.min((float) Math.atan(this.mDistortion.distort(0.0f, f4 / this.mLensToScreenDistance)[1]), (float) Math.toRadians(this.mFov[2])), Math.min((float) Math.atan(this.mDistortion.distort(0.0f, (f2 - f4) / this.mLensToScreenDistance)[1]), (float) Math.toRadians(this.mFov[3]))};
    }

    private void updateMesh(int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        int i2;
        float f9 = i == LEFT ? 0.0f : 0.5f;
        int i3 = 0;
        while (true) {
            if (i3 >= RESOLUTION) {
                break;
            }
            float f10 = (i3 * 1.0f) / (r5 - 1);
            int i4 = 0;
            while (true) {
                if (i4 < RESOLUTION) {
                    float f11 = (i4 * 1.0f) / (r9 - 1);
                    float[] fArrDistortInverse = this.mDistortion.distortInverse((f11 * f5) - f7, (f10 * f6) - f8);
                    float f12 = (fArrDistortInverse[0] + f3) / f;
                    float f13 = (fArrDistortInverse[1] + f4) / f2;
                    int i5 = ((RESOLUTION * i3) + i4) * 2;
                    float[] fArr = this.mDistortionPos[i];
                    fArr[i5] = (f12 * 2.0f) - 1.0f;
                    int i6 = i5 + 1;
                    fArr[i6] = (f13 * 2.0f) - 1.0f;
                    float[] fArr2 = this.mDistortionTex[i];
                    fArr2[i5] = (f11 / 2.0f) + f9;
                    fArr2[i6] = f10;
                    i4++;
                }
            }
            i3++;
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < RESOLUTION - 1; i9++) {
            if (i9 > 0) {
                short[] sArr = this.mDistortionIndex[i];
                sArr[i7] = sArr[i7 - 1];
                i7++;
            }
            int i10 = 0;
            while (true) {
                i2 = RESOLUTION;
                if (i10 < i2) {
                    if (i10 > 0) {
                        i8 = i9 % 2 == 0 ? i8 + 1 : i8 - 1;
                    }
                    short[] sArr2 = this.mDistortionIndex[i];
                    int i11 = i7 + 1;
                    sArr2[i7] = (short) i8;
                    i7 = i11 + 1;
                    sArr2[i11] = (short) (i2 + i8);
                    i10++;
                }
            }
            i8 += i2;
        }
        this.mDistortionTriangleBuffer[i] = ByteBuffer.allocateDirect(this.mDistortionPos[i].length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mDistortionTriangleBuffer[i].put(this.mDistortionPos[i]).position(0);
        this.mDistortionTextureBuffer[i] = ByteBuffer.allocateDirect(this.mDistortionTex[i].length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mDistortionTextureBuffer[i].put(this.mDistortionTex[i]).position(0);
        this.mDistortionIndexBuffer[i] = ByteBuffer.allocateDirect(this.mDistortionIndex[i].length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mDistortionIndexBuffer[i].put(this.mDistortionIndex[i]).position(0);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int getIntOption(int i) {
        if (i == 10004 && DeviceManager.isVRDevice()) {
            if (Build.VERSION.SDK_INT >= 15) {
                return 36197;
            }
            return super.getIntOption(i);
        }
        if (i == 10012) {
            return this.mPanoMode;
        }
        return super.getIntOption(i);
    }

    int getShaderType() {
        int i = this.mViewSize;
        int i2 = 2;
        if (i == 90) {
            i2 = 1;
        } else if (i != 180 || this.mVRModel != 1 || this.mVideoProjectModel != 2) {
            i2 = 0;
        }
        TextureRenderLog.i(this.mTexType, LOG_TAG, "pano_eac:" + i2);
        return i2;
    }

    float getExpandCoef() {
        return this.mExpandCoef;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirectorEventListener
    public void onDisplayRotationChanged(int i, boolean z) {
        if (z) {
            this.mSurfaceTexture.setOption(128, 1);
        }
    }
}
