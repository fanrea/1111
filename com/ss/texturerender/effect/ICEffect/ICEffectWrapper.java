package com.ss.texturerender.effect.ICEffect;

import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.m.p0.b;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectFactory;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.EffectTextureManager;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ICEffectWrapper extends AbsEffect {
    public static final int BEF_AB_DATA_TYPE_BOOL = 0;
    public static final int BEF_AB_DATA_TYPE_FLOAT = 2;
    public static final int BEF_AB_DATA_TYPE_INT = 1;
    public static final int BEF_AB_DATA_TYPE_STRING = 3;
    public static final String DEFAULT_SEI_KEY = "LiveSEI";
    private static final String LOG_TAG = "TR_ICEffectWrapper";
    private static boolean isLibLoaded = loadLibrary();
    private GLDefaultFilter mDefaultFilter;
    private long mHandle;
    private boolean mIsInit;
    public IEffectMsgListener mMsgListener;
    private boolean mProcessOccurError;
    private IEffectResourceFinder mResourceFinder;
    private String mSeiInfo;
    private String mSeiKey;

    public interface IEffectInitCallback extends Serializable {
        void onInitCallback(int i);
    }

    public interface IEffectLogListener extends Serializable {
        void onLogReport(int i, String str);
    }

    public interface IEffectMsgListener extends Serializable {
        void onMessageReceived(int i, long j, long j2, String str);
    }

    public interface IEffectResourceFinder extends Serializable {
        long createNativeResourceFinder(long j);

        void release(long j);
    }

    private native int _composerAppendNodesWithTags(long j, Object[] objArr, int i, Object[] objArr2);

    private native String _composerGetNodePaths(long j);

    private native int _composerRemoveNodes(long j, String[] strArr, int i);

    private native int _composerSetNodesWithTags(long j, Object[] objArr, int i, Object[] objArr2);

    private static native int _configABBooleanValue(long j, String str, boolean z);

    private static native int _configABFloatValue(long j, String str, float f);

    private static native int _configABIntValue(long j, String str, int i);

    private static native int _configABStringValue(long j, String str, String str2);

    private native int _configEffect(long j, int i, int i2, String str, String str2, String str3, String str4);

    private native long _createEffectWrapper();

    private native String _getEventData(long j, int i);

    private native int _initEffect(long j, int i, int i2, String str);

    private native int _processFrame(long j, int i, int i2, int i3, int i4, double d, String str, String str2);

    private native int _release(long j);

    private native int _sendEffectMsg(long j, int i, int i2, int i3, String str);

    private native int _setRenderCacheString(long j, String str, String str2);

    private native int _setTextureSize(long j, int i, int i2);

    public static boolean loadLibrary() {
        try {
            System.loadLibrary("texturerender_native");
            return true;
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    public ICEffectWrapper(int i) {
        super(i, 21);
        this.mSeiInfo = "";
        this.mSeiKey = DEFAULT_SEI_KEY;
        this.mIsInit = false;
        this.mProcessOccurError = false;
        this.mDefaultFilter = null;
        TextureRenderLog.i(this.mTexType, LOG_TAG, "new ICEffectWrapper, load so result: " + isLibLoaded);
        this.mOrder = 99;
        this.mIsSupportOes = 0;
        this.mInTextureTarget = 3553;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle bundle) {
        String str;
        if (bundle == null || !isLibLoaded || this.mIsInit) {
            return -1;
        }
        this.mHandle = _createEffectWrapper();
        TextureRenderLog.i(this.mTexType, LOG_TAG, "create effect wrapper, handle: " + this.mHandle);
        if (this.mHandle == 0) {
            return -1;
        }
        int i = bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_LOG_LEVEL);
        String string = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_LOG_KEY);
        String string2 = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_PLATFORM_CONFIG);
        int i2 = bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_USE_GL30);
        String string3 = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_CACHE_PATH);
        String string4 = bundle.getString("license");
        this.mMsgListener = (IEffectMsgListener) bundle.getSerializable(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_CALLBACK);
        IEffectInitCallback iEffectInitCallback = (IEffectInitCallback) bundle.getSerializable(ICEffectKeys.KEY_IS_IC_EFFECT_INIT_RESULT_CALLBACK);
        this.mResourceFinder = (IEffectResourceFinder) bundle.getSerializable(ICEffectKeys.KEY_IS_IC_EFFECT_RESOURCE_FINDER);
        long j = this.mHandle;
        String str2 = b.d;
        int i_configEffect = _configEffect(j, i2, i, string2, string3, string4, string);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "config effect, ret: " + i_configEffect);
        if (i_configEffect < 0) {
            if (iEffectInitCallback != null) {
                iEffectInitCallback.onInitCallback(i_configEffect);
            }
            this.mSurfaceTexture.notifyError(17, this.mEffectType, "iceffect config effect error code: " + i_configEffect);
            return i_configEffect;
        }
        String string5 = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_AB_CONFIG);
        if (!TextUtils.isEmpty(string5)) {
            try {
                JSONArray jSONArray = new JSONArray(string5);
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                    TextureRenderLog.i(this.mTexType, LOG_TAG, "set effect ab config: " + jSONObjectOptJSONObject);
                    if (jSONObjectOptJSONObject.has("key") && jSONObjectOptJSONObject.has("data_type")) {
                        str = str2;
                        if (jSONObjectOptJSONObject.has(str)) {
                            String strOptString = jSONObjectOptJSONObject.optString("key");
                            int iOptInt = jSONObjectOptJSONObject.optInt("data_type");
                            if (iOptInt == 0) {
                                i_configEffect = _configABBooleanValue(this.mHandle, strOptString, jSONObjectOptJSONObject.optBoolean(str));
                            } else if (iOptInt == 1) {
                                i_configEffect = _configABIntValue(this.mHandle, strOptString, jSONObjectOptJSONObject.optInt(str));
                            } else if (iOptInt == 2) {
                                i_configEffect = _configABFloatValue(this.mHandle, strOptString, (float) jSONObjectOptJSONObject.optDouble(strOptString));
                            } else if (iOptInt == 3) {
                                i_configEffect = _configABStringValue(this.mHandle, strOptString, jSONObjectOptJSONObject.optString(strOptString));
                            }
                        }
                    } else {
                        str = str2;
                    }
                    i3++;
                    str2 = str;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                i_configEffect = -1;
            }
        }
        if (i_configEffect < 0) {
            if (iEffectInitCallback != null) {
                iEffectInitCallback.onInitCallback(i_configEffect);
            }
            this.mSurfaceTexture.notifyError(17, this.mEffectType, "iceffect config ab params error code: " + i_configEffect);
            return i_configEffect;
        }
        int texWidth = this.mSurfaceTexture.getTexWidth();
        int texHeight = this.mSurfaceTexture.getTexHeight();
        if (texWidth == 0 || texHeight == 0) {
            TextureRenderLog.i(this.mTexType, LOG_TAG, "iceffect tex size is invalid");
            if (iEffectInitCallback != null) {
                iEffectInitCallback.onInitCallback(-1);
            }
            this.mSurfaceTexture.notifyError(17, this.mEffectType, "iceffect texture size is invalid");
            return -1;
        }
        int i_initEffect = _initEffect(this.mHandle, texWidth, texHeight, bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME));
        TextureRenderLog.i(this.mTexType, LOG_TAG, "init effect width: " + texWidth + ", height: " + texHeight + ", result: " + i_initEffect);
        if (i_initEffect == 0) {
            this.mIsInit = true;
        } else {
            this.mSurfaceTexture.notifyError(17, this.mEffectType, "iceffect init error code: " + i_initEffect);
        }
        if (iEffectInitCallback != null) {
            iEffectInitCallback.onInitCallback(i_initEffect);
        }
        return i_initEffect;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture effectTexture, FrameBuffer frameBuffer) {
        EffectTexture effectTextureReverseTexture;
        if (this.mHandle == 0 || effectTexture == null || !this.mIsInit || !isLibLoaded || this.mSurfaceTexture.getIntOption(163) != 1 || (effectTextureReverseTexture = reverseTexture(effectTexture, frameBuffer, this.mSurfaceTexture)) == null) {
            return effectTexture;
        }
        if (effectTextureReverseTexture.getWidth() == 0 || effectTextureReverseTexture.getHeight() == 0) {
            effectTextureReverseTexture.giveBack();
            return effectTexture;
        }
        EffectTexture effectTextureGenTexture = null;
        if (frameBuffer != null && this.mParentRender != null && this.mParentRender.getEffectTextureManager() != null && this.mSurfaceTexture != null) {
            effectTextureGenTexture = this.mParentRender.getEffectTextureManager().genTexture(effectTexture.getWidth(), effectTexture.getHeight(), this.mSurfaceTexture.getIntOption(130));
        }
        EffectTexture effectTexture2 = effectTextureGenTexture;
        if (effectTexture2 != null) {
            int i_processFrame = _processFrame(this.mHandle, effectTextureReverseTexture.getTexID(), effectTexture2.getTexID(), effectTextureReverseTexture.getWidth(), effectTextureReverseTexture.getHeight(), ((long) ((System.currentTimeMillis() / 1000.0d) * 1000.0d)) / 1000.0d, this.mSeiKey, this.mSeiInfo);
            effectTextureReverseTexture.giveBack();
            if (i_processFrame == 0) {
                this.mProcessOccurError = false;
                EffectTexture effectTextureReverseTexture2 = reverseTexture(effectTexture2, frameBuffer, this.mSurfaceTexture);
                if (effectTextureReverseTexture2 != null) {
                    effectTexture.giveBack();
                    effectTextureReverseTexture2.giveBack();
                    return new EffectTexture((EffectTextureManager) null, effectTextureReverseTexture2.getTexID(), effectTextureReverseTexture2.getWidth(), effectTextureReverseTexture2.getHeight(), 3553);
                }
                effectTexture2.giveBack();
                return effectTexture;
            }
            if (!this.mProcessOccurError) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "iceffect process error code: " + i_processFrame);
                this.mSurfaceTexture.notifyError(18, this.mEffectType, "iceffect process error code: " + i_processFrame);
                this.mProcessOccurError = true;
            }
            effectTexture2.giveBack();
            return effectTexture;
        }
        effectTextureReverseTexture.giveBack();
        return effectTexture;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle bundle) {
        if (this.mHandle == 0 || bundle == null || !isLibLoaded) {
            return;
        }
        switch (bundle.getInt("action")) {
            case 1:
                sendEffectMsg(bundle);
                break;
            case 2:
                composerSetNodesWithTags(bundle);
                break;
            case 4:
                composerAppendNodesWithTags(bundle);
                break;
            case 5:
                composerRemoveNodes(bundle);
                break;
            case 6:
                setSeiInfo(bundle);
                break;
            case 7:
                setRenderCacheString(bundle);
                break;
            case 8:
                setTextureSize(bundle);
                break;
            case 10:
                release();
                break;
        }
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        String[] strArrSplit;
        long j = this.mHandle;
        if (j == 0 || !isLibLoaded) {
            return super.release();
        }
        String str_composerGetNodePaths = _composerGetNodePaths(j);
        if (!TextUtils.isEmpty(str_composerGetNodePaths) && (strArrSplit = str_composerGetNodePaths.split(",")) != null && strArrSplit.length > 0) {
            _composerRemoveNodes(this.mHandle, strArrSplit, strArrSplit.length);
            TextureRenderLog.i(this.mTexType, LOG_TAG, "remove composer nodes");
        }
        _release(this.mHandle);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "release effect");
        this.mHandle = 0L;
        this.mIsInit = false;
        this.mProcessOccurError = false;
        this.mSeiInfo = "";
        this.mDefaultFilter = null;
        return super.release();
    }

    EffectTexture reverseTexture(EffectTexture effectTexture, FrameBuffer frameBuffer, VideoSurfaceTexture videoSurfaceTexture) {
        if (this.mDefaultFilter == null) {
            GLDefaultFilter gLDefaultFilter = (GLDefaultFilter) EffectFactory.createEffect(this.mTexType, 7);
            this.mDefaultFilter = gLDefaultFilter;
            if (gLDefaultFilter == null) {
                TextureRenderLog.i(this.mTexType, LOG_TAG, "create GLDefaultFilter failed");
                return null;
            }
            gLDefaultFilter.setSurfaceTexture(videoSurfaceTexture);
            this.mDefaultFilter.init(null);
            this.mDefaultFilter.setParentRender(this.mParentRender);
        }
        this.mDefaultFilter.setOption(31, 1);
        return this.mDefaultFilter.process(effectTexture, frameBuffer);
    }

    public void setSeiInfo(Bundle bundle) {
        if (!this.mIsInit || bundle == null || this.mHandle == 0) {
            return;
        }
        String string = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_SEI_KEY);
        String string2 = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_SEI_INFO);
        if (TextUtils.equals(string, DEFAULT_SEI_KEY)) {
            this.mSeiInfo = string2;
        }
    }

    public int setTextureSize(Bundle bundle) {
        if (!isLibLoaded || !this.mIsInit || bundle == null || this.mHandle == 0) {
            return -1;
        }
        return _setTextureSize(this.mHandle, bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_TEX_WIDTH), bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_TEX_HEIGHT));
    }

    public int setRenderCacheString(Bundle bundle) {
        if (!isLibLoaded || !this.mIsInit || bundle == null || this.mHandle == 0) {
            return -1;
        }
        String string = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_RENDER_CACHE_STRING_KEY);
        String string2 = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_RENDER_CACHE_STRING_VALUE);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return -1;
        }
        return _setRenderCacheString(this.mHandle, string, string2);
    }

    public int composerSetNodesWithTags(Bundle bundle) {
        if (!isLibLoaded || !this.mIsInit || bundle == null || this.mHandle == 0) {
            return -1;
        }
        String[] stringArray = bundle.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_NODE_PATH);
        String[] stringArray2 = bundle.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_STICKER_TAGS);
        if (stringArray == null) {
            return -1;
        }
        int i_composerSetNodesWithTags = _composerSetNodesWithTags(this.mHandle, stringArray, stringArray.length, stringArray2);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "_composerSetNodesWithTags ret: " + i_composerSetNodesWithTags);
        return i_composerSetNodesWithTags;
    }

    public int composerAppendNodesWithTags(Bundle bundle) {
        if (!isLibLoaded || !this.mIsInit || bundle == null || this.mHandle == 0) {
            return -1;
        }
        String[] stringArray = bundle.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_NODE_PATH);
        String[] stringArray2 = bundle.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_STICKER_TAGS);
        if (stringArray == null) {
            return -1;
        }
        int i_composerAppendNodesWithTags = _composerAppendNodesWithTags(this.mHandle, stringArray, stringArray.length, stringArray2);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "_composerAppendNodesWithTags ret: " + i_composerAppendNodesWithTags);
        return i_composerAppendNodesWithTags;
    }

    public int composerRemoveNodes(Bundle bundle) {
        String[] stringArray;
        if (!isLibLoaded || !this.mIsInit || bundle == null || this.mHandle == 0 || (stringArray = bundle.getStringArray(ICEffectKeys.KEY_IS_IC_EFFECT_NODE_PATH)) == null) {
            return -1;
        }
        int i_composerRemoveNodes = _composerRemoveNodes(this.mHandle, stringArray, stringArray.length);
        TextureRenderLog.i(this.mTexType, LOG_TAG, "_composerRemoveNodes ret: " + i_composerRemoveNodes);
        return i_composerRemoveNodes;
    }

    public void sendEffectMsg(Bundle bundle) {
        if (!isLibLoaded || !this.mIsInit || bundle == null || this.mHandle == 0) {
            return;
        }
        int i = bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_ID);
        int i2 = bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_PARAM1);
        int i3 = bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_PARAM2);
        String string = bundle.getString(ICEffectKeys.KEY_IS_IC_EFFECT_MSG_STRING_PARAM3);
        if (i != -1) {
            _sendEffectMsg(this.mHandle, i, i2, i3, string);
        }
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public Object getOption(Bundle bundle) {
        if (!isLibLoaded || !this.mIsInit || bundle == null || this.mHandle == 0) {
            return null;
        }
        int i = bundle.getInt("action");
        if (i == 3) {
            return _composerGetNodePaths(this.mHandle);
        }
        if (i != 9) {
            return null;
        }
        return _getEventData(this.mHandle, bundle.getInt(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE));
    }

    public void onReceiveEffectMessage(int i, long j, long j2, String str) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, "onReceiveEffectMessage, msgType: " + i + ", arg: " + str);
        IEffectMsgListener iEffectMsgListener = this.mMsgListener;
        if (iEffectMsgListener != null) {
            iEffectMsgListener.onMessageReceived(i, j, j2, str);
        }
    }

    public void onLogReport(int i, String str) {
        TextureRenderLog.i(this.mTexType, LOG_TAG, str);
    }

    public long getResourceFunc(long j) {
        IEffectResourceFinder iEffectResourceFinder = this.mResourceFinder;
        if (iEffectResourceFinder != null) {
            return iEffectResourceFinder.createNativeResourceFinder(j);
        }
        return 0L;
    }
}
