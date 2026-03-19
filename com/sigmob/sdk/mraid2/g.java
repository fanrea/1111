package com.sigmob.sdk.mraid2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.q;
import com.sigmob.sdk.base.common.t;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.Template;
import com.sigmob.sdk.mraid.o;
import com.sigmob.sdk.mraid2.c;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g extends com.sigmob.sdk.mraid2.a {
    private static final String o = "Mraid2Bridge";
    private static final HashMap<String, g> r = new LinkedHashMap();
    private final g b;
    private com.sigmob.sdk.mraid2.c c;
    private g d;
    private String e;
    private c f;
    private b g;
    private a h;
    private boolean i;
    private FrameLayout j;
    private LinearLayout k;
    private boolean l;
    private JSONObject m;
    private BaseAdUnit n;
    private final h p;
    private com.sigmob.sdk.base.common.f q;
    private final HashMap<String, n> s;
    private final c.b t;

    /* renamed from: com.sigmob.sdk.mraid2.g$1, reason: invalid class name */
    class AnonymousClass1 extends h {
        AnonymousClass1() {
        }

        private void a() throws JSONException {
            if (g.this.c != null) {
                if (g.this.m != null) {
                    g.this.c.a(g.this.m);
                }
                g.this.c.d();
            }
            if (g.this.b != null && g.this.b.getMraidBridge() != null && !TextUtils.isEmpty(g.this.e)) {
                g.this.b.getMraidBridge().c(g.this.e);
            }
            if (g.this.i) {
                return;
            }
            g.this.i = true;
            if (g.this.h != null) {
                g.this.h.a(g.this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Object obj) throws JSONException {
            a();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) throws JSONException {
            super.onPageFinished(view, url);
            Log.d(g.o, g.this.m + "-----------onPageFinished---------" + url);
            if (g.this.c.b()) {
                a();
            } else {
                g.this.c.a("javascript:(function () {\n    var uniqueId = 1;\n    var mraid = window.mraid = {};\n    var bridge = window.mraidbridge = {\n        nativeCallQueue: [],\n        nativeCallInFlight: false,\n        queue: {},\n    };\n    var bidResponse = {};\n    var bindData = undefined;\n    var isViewable = false;\n    var exposure = 0;\n    var sdkVersion = undefined;\n    var listeners = {};\n    var screenSize = {\n        width: 0,\n        height: 0\n    };\n    var currentAppOrientation = {\n        orientation: 0,\n        locked: true\n    };\n    var isNullOrEmpty = function(param) {\n        return param === null || param === undefined;\n    };\n    var EVENTS = mraid.EVENTS = {\n        error: 'error',\n        info: 'info',\n        ready: 'ready',\n        viewableChange: 'viewableChange',\n        sizeChange: 'sizeChange',\n        exposureChange: 'exposureChange',\n        playStateChanged: 'playStateChanged',\n        loadStateChanged: 'loadStateChanged',\n        currentTime: 'currentTime',\n        playEnd: 'playEnd',\n        pageChanged: 'pageChanged',\n        downloadStateChanged: 'downloadStateChanged',\n        safeAreaInsetsChange: 'safeAreaInsetsChange',\n    };\n\n    bridge.setScreenSize = function (val) {\n       if (screenSize.width != val.width || screenSize.height != val.height) {\n            screenSize = val;\n            broadcastEvent(listeners, EVENTS.sizeChange, val.width, val.height);\n        }\n    };\n    bridge.setIsViewable = function (val) {\n        if ((val ^ isViewable) == 1) {\n            isViewable = val;\n            broadcastEvent(listeners, EVENTS.viewableChange, isViewable)\n        }\n    };\n    bridge.setExposureChange = function (val) {\n        if (val != exposure) {\n            exposure = val;\n            broadcastEvent(listeners, EVENTS.exposureChange, val)\n        }\n    };\n    bridge.setBindData = function (val) { bindData = val; };\n    bridge.sdkVersion = function (val) { sdkVersion = val; }\n    bridge.orientation = function (val) { currentAppOrientation = val; }\n    bridge.onStorageChanged = function (evt) {\n        const key = 'storage_' + evt.key;\n        broadcastEvent(listeners, key, evt);\n    };\n    bridge.setBidResponse = function (val) {\n        bidResponse = val;\n    };\n    bridge.onChangeEvent = function(evt) {\n        broadcastEvent(listeners, evt.event, evt.data);\n    };\n    bridge.setvdReadyToPlay = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.ready, val);\n    };\n    bridge.setvdPlayStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playStateChanged, val);\n    };\n    bridge.setvdLoadStateChanged = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.loadStateChanged, val);\n    };\n    bridge.setvdPlayCurrentTime = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.currentTime, val);\n    };\n    bridge.setvdPlayToEnd = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.playEnd, val);\n    };\n    bridge.setvdPlayError = function (val) {\n        let vpaid = bridge.queue[val.uniqueId]\n        broadcastEvent(vpaid.handlers, EVENTS.error, val);\n    };\n    bridge.onChangeFired = function (val) {\n        let obj = bridge.queue[val.uniqueId];\n        broadcastEvent(obj.handlers, val.event, val.args);\n    };\n    bridge.notify = function (val) {\n        console.log(val)\n        if (val.event.startsWith('fire_')) {\n            broadcastEvent(listeners, val.event)\n            return\n        }\n\n        if (val.event.startsWith('dispatch_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        if (val.event.startsWith('animation_')) {\n            broadcastEvent(listeners, val.event)\n            mraid.removeEventListener(val.event);\n            return\n        }\n\n        broadcastEvent(listeners, val.event, val.message)\n        mraid.removeEventListener(val.event);\n    };\n    bridge.notifyPageChangeEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.pageChanged, val)\n    };\n    bridge.notifyApkDownloadStateEvent = function (val) {\n        broadcastEvent(listeners, EVENTS.downloadStateChanged, val)\n    };\n    bridge.setWVFinished = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.ready);\n    };\n    bridge.setWVError = function (val) {\n        let web = bridge.queue[val.uniqueId]\n        broadcastEvent(web.handlers, EVENTS.error, val.error);\n    };\n    bridge.postMessage = function (msg) {\n        var msgStr = JSON.stringify(msg);\n        sigandroid.postMessage(msgStr);\n    }\n    bridge.syncMessage = function (msg) {\n        if (this.nativeCallInFlight) {\n            this.nativeCallQueue.push(msg)\n        } else {\n            this.nativeCallInFlight = true;\n            var msgStr = JSON.stringify(msg);\n            sigandroid.postMessage(msgStr);\n        }\n    }\n    bridge.nativeCallComplete = function (command) {\n        console.log('nativeCallCompletecommand = ' + command)\n        if (this.nativeCallQueue.length === 0) {\n            this.nativeCallInFlight = false;\n            return\n        }\n        var nextCall = this.nativeCallQueue.shift();\n        bridge.postMessage(nextCall);\n    };\n    bridge.onMotionChanged = function (evt) {\n        const key = 'motion_' + evt.type+evt.event;\n        delete evt.type;\n        delete evt.event;\n        broadcastEvent(listeners, key, evt);\n    };\n    var changeHandlers = {\n        onChangeEvent: bridge.onChangeEvent,\n        vdReadyToPlay: bridge.setvdReadyToPlay,\n        vdPlayStateChanged: bridge.setvdPlayStateChanged,\n        vdLoadStateChanged: bridge.setvdLoadStateChanged,\n        vdPlayCurrentTime: bridge.setvdPlayCurrentTime,\n        vdPlayToEnd: bridge.setvdPlayToEnd,\n        vdPlayError: bridge.setvdPlayError,\n        wvFinished: bridge.setWVFinished,\n        wvError: bridge.setWVError,\n        screenSize: bridge.setScreenSize,\n        viewable: bridge.setIsViewable,\n        exposure: bridge.setExposureChange,\n        bindData: bridge.setBindData,\n        sdkVersion: bridge.sdkVersion,\n        orientation: bridge.orientation,\n        storageChanged: bridge.onStorageChanged,\n        bidResponse: bridge.setBidResponse,\n        notify: bridge.notify,\n        motionChanged: bridge.onMotionChanged,\n        onChangeFired: bridge.onChangeFired,\n    };\n    bridge.fireChangeEvent = function (properties) {\n        for (let p in properties) {\n            if (properties.hasOwnProperty(p)) {\n                let handler = changeHandlers[p];\n                try {\n                    handler(properties[p])\n                } catch (error) {\n                    console.log('error: ' + error.message);\n                }\n            }\n        }\n    };\n\n    var Storage = function (type) {\n        this.setItem = function (key, value) {\n            sigandroid.storage(JSON.stringify({ event: 'setItem', args: { type, key, value } }))\n        };\n        this.getItem = function (key) {\n            var result = sigandroid.storage(JSON.stringify({ event: 'getItem', args: { type, key } }));\n            return result\n        };\n        this.removeItem = function (key) {\n            sigandroid.storage(JSON.stringify({ event: 'removeItem', args: { type, key } }))\n        };\n        this.clear = function () {\n            sigandroid.storage(JSON.stringify({ event: 'clear', args: { type } }))\n        };\n        this.length = function () {\n            var result = sigandroid.storage(JSON.stringify({ event: 'length', args: { type } }));\n            return parseInt(result)\n        };\n        this.addEventListener = function (key, callback) {\n            sigandroid.storage(JSON.stringify({ event: 'addEventListener', args: { type, key } }))\n            mraid.addEventListener('storage_' + key, callback);\n        };\n    };\n    var EventListeners = function (event) {\n        this.event = event;\n        this.count = 0;\n        var listeners = {};\n        this.add = function (func) {\n            var id = String(func);\n            if (!listeners[id]) {\n                listeners[id] = func;\n                this.count++\n            }\n        };\n        this.remove = function (func) {\n            var id = String(func);\n            if (listeners[id]) {\n                listeners[id] = null;\n                delete listeners[id];\n                this.count--;\n                return true\n            } else {\n                return false\n            }\n        };\n        this.removeAll = function () {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) this.remove(listeners[id])\n            }\n        };\n        this.broadcast = function (args) {\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) listeners[id].apply(mraid, args)\n            }\n        };\n        this.toString = function () {\n            var out = [event, ':'];\n            for (var id in listeners) {\n                if (listeners.hasOwnProperty(id)) out.push('|', id, '|')\n            }\n            return out.join('')\n        }\n    };\n    var contains = function (value, array) {\n        if (value.indexOf('motion_') == 0) {\n            return true;\n        }\n        if (value.indexOf('storage_') == 0) {\n            return true;\n        }\n        if (value.indexOf('fire_') == 0) {\n            return true;\n        }\n        if (value.indexOf('dispatch_') == 0) {\n            return true;\n        }\n        if (value.indexOf('animation_') == 0) {\n            return true;\n        }\n        if (value.indexOf('open_') == 0) {\n            return true;\n        }\n        if (value.indexOf('lance_') == 0) {\n            return true;\n        }\n\n        for (var i in array) {\n            if (array[i] === value) return true\n        }\n        return false\n    };\n    var broadcastEvent = function () {\n        var args = new Array(arguments.length);\n        var l = arguments.length;\n        for (var i = 0; i < l; i++) args[i] = arguments[i];\n        var handlers = args.shift();\n        var event = args.shift();\n        if (handlers[event]) {\n            handlers[event].broadcast(args)\n        }\n    };\n    var addEventListener = function (handlers, event, listener) {\n        if (!event || !listener) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and listener are required.', 'addEventListener')\n        } else {\n            if (!handlers[event]) {\n                handlers[event] = new EventListeners(event)\n            }\n            handlers[event].add(listener)\n        }\n    };\n    var removeEventListener = function (funs, event, listener) {\n        if (!event) {\n            broadcastEvent(listeners, EVENTS.error, 'Event is required.', 'removeEventListener');\n            return\n        }\n        if (listener) {\n            var success = false;\n            if (funs[event]) {\n                success = funs[event].remove(listener)\n            }\n            if (!success) {\n                broadcastEvent(listeners, EVENTS.error, 'Listener not currently registered for event.', 'removeEventListener');\n                return\n            }\n        } else if (funs && funs[event]) {\n            funs[event].removeAll()\n        }\n        if (funs[event] && funs[event].count === 0) {\n            funs[event] = null;\n            delete funs[event]\n        }\n    };\n    \n    var Motion = function(type) {\n        this.uniqId = 'motion_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motion';\n        var events = [];\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        this.init = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init',args: { uniqueId: this.uniqId, type, sensitivity} });\n        };\n        this.initSensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'init_sensitivity_raw', args: { uniqueId: this.uniqId, type, sensitivity_raw } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy',args: { uniqueId: this.uniqId, type } });\n        };\n        this.addEventListener = function (event,listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    bridge.fireReadyEvent = function () { broadcastEvent(listeners, EVENTS.ready) };\n    bridge.frame = function (event, uniqId, x, y, w, h) {\n        if (!w || !h) {\n            broadcastEvent(listeners, EVENTS.error, 'x,y,w,h is required!', 'frame');\n        } else {\n            bridge.syncMessage({ event: event, subEvent: 'frame', args: { uniqueId: uniqId, frame: { x, y, w, h } } });\n        }\n    }\n    var safeAreaInsets = {\n        top: 0,\n        left: 0,\n        bottom: 0,\n        right: 0\n    };\n    bridge.setSafeAreaInsets = function(top, left, bottom, right) {\n        if (safeAreaInsets.top == top && safeAreaInsets.left == left && safeAreaInsets.bottom == bottom && safeAreaInsets.right == right) {\n            return;\n        }\n        safeAreaInsets = {\n            top: top,\n            left: left,\n            bottom: bottom,\n            right: right\n          };\n         broadcastEvent(listeners,EVENTS.safeAreaInsetsChange, top, left, bottom, right);\n    };\n    mraid.getSafeAreaInsets = function() {\n        return {\n            top: safeAreaInsets.top,\n            left: safeAreaInsets.left,\n            bottom: safeAreaInsets.bottom,\n            right: safeAreaInsets.right\n        };\n    };\n   mraid.MotionView = function(type) {\n        this.uniqId = 'motion_view_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'motionView';\n        this.rect = {x: 0, y: 0, w: 0, h: 0};\n        this.handlers = {};\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, type } });\n        this.frame = function (x, y, w, h) {\n            this.rect = {x, y, w, h};\n            bridge.frame(this.event, this.uniqId, x, y, w, h);\n        };\n        this.hidden = function (hidden) {\n            bridge.syncMessage({ event: this.event, subEvent: 'hidden', args: { uniqueId: this.uniqId, hidden } });\n        };\n        this.sensitivity = function (sensitivity) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity', args: { uniqueId: this.uniqId, sensitivity } });\n        };\n        this.sensitivityRaw = function (sensitivity_raw) {\n            bridge.syncMessage({ event: this.event, subEvent: 'sensitivity_raw', args: { uniqueId: this.uniqId, sensitivity_raw } });\n        };\n        this.start = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'start', args: { uniqueId: this.uniqId } });\n        };\n        this.destroy = function () {\n            bridge.syncMessage({ event: this.event, subEvent: 'destroy', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.Vpaid = function (val) {\n        if (typeof (val) == 'object' && val.uniqId) {\n            this.uniqId = val.uniqId;\n            uniqueId++;\n            this.rect = val.rect;\n        } else {\n            this.uniqId = 'vd_' + (uniqueId++) + '_' + new Date().getTime();\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'init', args: { uniqueId: this.uniqId } });\n            this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        }\n        bridge.queue[this.uniqId] = this;\n        this.handlers = {};\n        this.assetURL = function (URL,useProxy = true) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'assetURL', args: { uniqueId: this.uniqId, URL: URL,proxy:useProxy} });\n        };\n        this.play = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'play', args: { uniqueId: this.uniqId } });\n        };\n        this.replay = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'replay', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.stop = function () {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'stop', args: { uniqueId: this.uniqId } });\n        };\n        this.muted = function (flag) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'muted', args: { uniqueId: this.uniqId, muted: flag } });\n        };\n        this.seek = function (val) {\n            bridge.syncMessage({ event: 'vpaid', subEvent: 'seek', args: { uniqueId: this.uniqId, seekTime: val } });\n        };\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame('vpaid', this.uniqId, x, y, w, h)\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n\n    function callNativeFunc(kwargs, func) {\n        if (kwargs === undefined) return undefined;\n        if (func === undefined) return undefined;\n        kwargs['func'] = func;\n        var returnStr = sigandroid.func(JSON.stringify(kwargs));\n        if (returnStr) {\n            try {\n                return JSON.parse(returnStr)\n            } catch (e) {\n                return JSON.stringify(returnStr)\n            }\n        } else {\n            console.log('-------callNativeFunc return null-----');\n        }\n    };\n\n    mraid.Color = function(red, green, blue, alpha) {\n        this.red = red;\n        this.green = green;\n        this.blue = blue;\n        this.alpha = alpha;\n    };\n   mraid.backgroundColor = function (color) {\n        bridge.postMessage({ event: 'backgroundColor', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n    };\n   mraid.uniqId = function () {\n        return sigandroid.getUniqueId()\n    };    mraid.Timer = function (interval, repeats = false, callback) {\n        if (!interval || interval <= 0) return;\n        this.uniqId = 'timer_' + (uniqueId++) + '_' + new Date().getTime();\n        bridge.syncMessage({\n            event: 'timer',\n            subEvent: 'init',\n            args: {\n                uniqueId: this.uniqId,\n                interval: interval,\n                repeats: repeats\n            }\n        });\n        this.fire = function () {\n            mraid.addEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'fire', args: { uniqueId: this.uniqId } });\n        };\n        this.invalidate = function () {\n            mraid.removeEventListener('fire_' + this.uniqId, callback);\n            bridge.syncMessage({ event: 'timer', subEvent: 'invalidate', args: { uniqueId: this.uniqId } });\n        };\n        this.pause = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'pause', args: { uniqueId: this.uniqId } });\n        };\n        this.resume = function () {\n            bridge.syncMessage({ event: 'timer', subEvent: 'resume', args: { uniqueId: this.uniqId } });\n        };\n    };\n    mraid.WebView = function () {\n        this.uniqId = 'wv_' + (uniqueId++) + '_' + new Date().getTime();\n        this.event = 'webView'\n        this.handlers = {}\n        this.rect = { x: 0, y: 0, w: 0, h: 0 };\n        var args = undefined;\n        if (arguments) {\n            args = JSON.stringify(arguments);\n        }\n        bridge.queue[this.uniqId] = this;\n        bridge.syncMessage({ event: this.event, subEvent: 'init', args: { uniqueId: this.uniqId, args } });\n        this.frame = function (x, y, w, h) {\n            this.rect = { x, y, w, h };\n            bridge.frame(this.event, this.uniqId, x, y, w, h)\n        };\n        this.loadURL = function (url) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURL', args: { uniqueId: this.uniqId, url } });\n        };\n        this.loadURLByPackage = function (URL) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadURLByPackage', args: { uniqueId: this.uniqId, URL } });\n        };\n        this.loadHTMLString = function (html) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadHTMLString', args: { uniqueId: this.uniqId, html } });\n        };\n        this.loadById = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'loadId', args: { uniqueId: this.uniqId, id } });\n        };\n        this.reload = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'reload', args: { uniqueId: this.uniqId } });\n        };\n        this.stopLoading = function (id) {\n            bridge.syncMessage({ event: this.event, subEvent: 'stopLoading', args: { uniqueId: this.uniqId } });\n        };\n        this.addEventListener = function (event, listener) {\n            addEventListener(this.handlers, event, listener);\n        };\n        this.removeEventListener = function (event, listener) {\n            removeEventListener(this.handlers, event, listener);\n        };\n    };\n    mraid.motion = {\n        shake: new Motion('shake'),\n        twist: new Motion('twist'),\n        slope: new Motion('slope'),\n        swing: new Motion('swing'),\n    };\n    mraid.blurEffect = {\n        init: function (color) {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'init', args: { red: color.red, green: color.green, blue: color.blue, alpha: color.alpha } });\n        },\n        destroy: function () {\n            bridge.syncMessage({ event: 'blurEffect', subEvent: 'destroy' });\n        },\n    };\n    mraid.localStorage = new Storage(1);\n    mraid.sessionStorage = new Storage(2);\n    mraid.getVersion = () => sdkVersion;\n    mraid.getOs = () => 2;\n    mraid.isViewable = () => isViewable;\n    mraid.getState = () => state;\n    mraid.version = () => '2.2'; \n     mraid.getScreenSize = () => screenSize;\n    mraid.getCurrentAppOrientation = () => currentAppOrientation;\n    mraid.bidResponse = () => bidResponse;\n    mraid.visible = function(visible) {\n        bridge.syncMessage({ event: 'visible', args: {visible} });\n    };\n    mraid.feedbackByVid = function(vid) {\n        bridge.postMessage({ event: 'feedbackByVid', args: { vid } });\n    };\n    mraid.openByVid = function(vid, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.syncMessage({ event: 'openByVid', args: {vid, event, data} });\n    };\n    mraid.open = function (url, data, cbObj = {}) {\n        var event = 'open_' + new Date().getTime();\n        if (cbObj.onSuccess) {\n            mraid.addEventListener(event + \"_success\", cbObj.onSuccess)\n        }\n        if (cbObj.onFailed) {\n            mraid.addEventListener(event + \"_failed\", cbObj.onFailed)\n        }\n        bridge.postMessage({ event: 'open', args: { url, event, data } })\n    };\n   mraid.subscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'subscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        addEventListener(listeners, key, listener);\n        if (listeners[key] && listeners[key].count == 1) {\n            bridge.syncMessage({ event: 'subscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.unsubscribe = function(uniqId, event, listener) {\n        if (isNullOrEmpty(uniqId) || isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'Both event and uniqId are required.', 'unsubscribe');\n            return;\n        }\n        let key = uniqId + '~' + event;\n        removeEventListener(listeners, key, listener);\n        if (isNullOrEmpty(listeners[key])) {\n            bridge.syncMessage({ event: 'unsubscribe', args: { uniqId, event } });\n        }\n    };\n    mraid.publish = function(event, data) {\n        if (isNullOrEmpty(event)) {\n            broadcastEvent(listeners, EVENTS.error, 'event are required.', 'publish');\n            return;\n        }\n        bridge.syncMessage({ event: 'publish', args: {event, data} });\n    };\n    mraid.ready = function () { bridge.postMessage({ event: 'ready' }); };\n    mraid.close = function () { bridge.postMessage({ event: 'close' }) };\n    mraid.unload = function () { bridge.postMessage({ event: 'unload' }) }\n    mraid.addSubview = function (val) { bridge.syncMessage({ event: 'addSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.belowSubview = function (val) { bridge.syncMessage({ event: 'belowSubview', args: { uniqueId: val.uniqId } }); };\n    mraid.useScrollView = function (flag) { bridge.syncMessage({ event: 'useScrollView', args: { flag } }); };\n    mraid.touchStart = function (x, y) { bridge.postMessage({ event: 'touchStart', args: { x, y } }); };\n    mraid.touchMove = function (x, y) { bridge.postMessage({ event: 'touchMove', args: { x, y } }); };\n    mraid.touchEnd = function (x, y) { bridge.postMessage({ event: 'touchEnd', args: { x, y } }); };\n    mraid.dispatchAfter = function (delay, callback) {\n        var event = 'dispatch_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'dispatch_after', args: { 'event': event, 'delay': delay } });\n    };\n    mraid.useCustomClose = function (flag) { bridge.postMessage({ event: 'useCustomClose', args: { flag } }) };\n    mraid.addEventListener = function (event, listener) { addEventListener(listeners, event, listener); };\n    mraid.removeEventListener = function (event, listener) { removeEventListener(listeners, event, listener); };\n    mraid.arguments = () => bindData;\n    mraid.reward = function () {\n        bridge.postMessage({ event: 'reward' })\n    };\n    mraid.addMacro = function (key, value, vid) {\n        callNativeFunc({ event: 'addMacro', args: { key, value, vid } }, 'handleMacro:')\n    };\n    mraid.addAllMacros = function (maps, vid) {\n        callNativeFunc({ event: 'addAllMacros', args: { maps, vid } }, 'handleMacro:')\n    };\n    mraid.removeMacro = function (key, vid) {\n        callNativeFunc({ event: 'removeMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.clearMacro = function (vid) {\n        callNativeFunc({ event: 'clearMacro', args: { vid } }, 'handleMacro:')\n    };\n    mraid.getMacro = function (key, vid) {\n        return callNativeFunc({ event: 'getMacro', args: { key, vid } }, 'handleMacro:')\n    };\n    mraid.addDclog = function (data, vid) {\n        return callNativeFunc({ data, vid }, 'addDclog:')\n    };\n    mraid.device = function () {\n        var device = sigandroid.getDeviceInfo()\n        if (device) {\n            return JSON.parse(device)\n        }\n    };\n    mraid.tracking = function (urls, event, data) {\n        if (urls.length > 0 || event) {\n            return callNativeFunc({ urls, event, data }, 'tracking:')\n        }\n    };\n    mraid.android = {\n        getApKDownloadProcess: function (vid) {\n            var process = sigandroidapk.getApKDownloadProcessId(vid);\n            return process\n        },\n        addEventListener: function (event, vid, listener) {\n            sigandroidapk.registerDownloadEvent(vid);\n            addEventListener(listeners, event, listener);\n        },\n        removeEventListener: function (event, listener) {\n            removeEventListener(listeners, event, listener);\n        }\n    };\n\n    mraid.loadAd = function (data, callback) {\n        var event = 'lance_' + new Date().getTime();\n        mraid.addEventListener(event, callback);\n        bridge.postMessage({ event: 'mraidLoadAd', args: { 'event': event, 'data': data } });\n    };\n\n    mraid.setCurPlayAd = function (vid) { bridge.postMessage({ event: 'curPlayAd', args: { vid } }); };\n\n    mraid.animation = function (duration, obj, from, to, completion) {\n        const fromRect = { x: from.x, y: from.y, w: from.w, h: from.h };\n        const toRect = { x: to.x, y: to.y, w: to.w, h: to.h };\n        var event = 'animation_' + new Date().getTime();\n        mraid.addEventListener(event, completion);\n        bridge.postMessage({ event: 'animation', args: { 'event': event, duration, uniqueId: obj.uniqId, from: fromRect, to: toRect } });\n    };\n\n    (function () {\n        bridge.postMessage({ event: 'mraidJsLoaded' })\n    })();\n\n    console.log('mraid ---- successed!!!')\n}());\n", new ValueCallback() { // from class: com.sigmob.sdk.mraid2.g$1$$ExternalSyntheticLambda0
                    @Override // android.webkit.ValueCallback
                    public final void onReceiveValue(Object obj) throws JSONException {
                        this.f$0.a(obj);
                    }
                });
            }
        }

        @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) throws JSONException {
            ac.a("h5_error", "mraid2", errorCode, failingUrl + " error:" + description, (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (ac.a) null);
            if (g.this.b == null || g.this.b.getMraidBridge() == null || TextUtils.isEmpty(g.this.e)) {
                return;
            }
            g.this.b.getMraidBridge().a(g.this.e, errorCode, description);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) throws JSONException {
            SigmobLog.i("onReceivedError:" + error.toString());
            if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT < 23) {
                return;
            }
            ac.a("h5_error", "mraid2", 0, request.getUrl() + " error:" + ((Object) error.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (ac.a) null);
            if (g.this.b == null || g.this.b.getMraidBridge() == null || TextUtils.isEmpty(g.this.e)) {
                return;
            }
            g.this.b.getMraidBridge().a(g.this.e, error.getErrorCode(), "" + ((Object) error.getDescription()));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            if (Build.VERSION.SDK_INT >= 21) {
                ac.a("h5_error", "mraid2", errorResponse.getStatusCode(), request.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, g.this.getAdUnitList().get(0), (ac.a) null);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(final WebView view, final RenderProcessGoneDetail detail) {
            Log.d(g.o, "-----------onRenderProcessGone---------" + detail);
            WindAdError windAdError = Build.VERSION.SDK_INT >= 26 ? (detail == null || !detail.didCrash()) ? WindAdError.RENDER_PROCESS_GONE_UNSPECIFIED : WindAdError.RENDER_PROCESS_GONE_WITH_CRASH : null;
            SigmobLog.e("handleRenderProcessGone " + windAdError);
            if (g.this.h != null) {
                g.this.h.a(windAdError);
            }
            g.this.a();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) throws IntentNotResolvableException {
            int i;
            int i2;
            if (url == null) {
                return false;
            }
            try {
                if (url.startsWith(com.alipay.sdk.m.l.a.r) || url.startsWith("https")) {
                    view.loadUrl(url);
                } else if (g.this.n != null) {
                    List<String> list = g.this.n.getAdSetting() != null ? g.this.n.getAdSetting().scheme_white_list : null;
                    if (list != null && !list.isEmpty()) {
                        while (i2 < list.size()) {
                            String str = list.get(i2);
                            i2 = (url.startsWith(str) || str.equals("*")) ? 0 : i2 + 1;
                            t.a(g.this.getContext(), Uri.parse(url));
                            return true;
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < g.this.getAdUnitList().size(); i3++) {
                        BaseAdUnit baseAdUnit = g.this.getAdUnitList().get(i3);
                        List<String> list2 = baseAdUnit.getAdSetting() != null ? baseAdUnit.getAdSetting().scheme_white_list : null;
                        if (list2 != null && !list2.isEmpty()) {
                            for (0; i < list2.size(); i + 1) {
                                String str2 = list2.get(i);
                                i = (url.startsWith(str2) || str2.equals("*")) ? 0 : i + 1;
                                t.a(g.this.getContext(), Uri.parse(url));
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public interface a {
        void a(g webView);

        void a(WindAdError errorCode);
    }

    public interface b {
        LinearLayout a(g mraid2WebView, int orientation);

        g a(g parentWebView, JSONObject args);

        void a();

        void a(g webView);

        void a(g webView, BaseAdUnit uri, JSONObject ext);

        void b(g webView);

        void b(g webView, JSONObject args);
    }

    public interface c {
        void a(g view, JSONObject args);

        void a(JSONObject args);

        void b(JSONObject args);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class d {
        private d() {
        }

        /* synthetic */ d(g gVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            Activity activityC = com.sigmob.sdk.base.utils.o.c(g.this);
            if (activityC == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.h((Context) activityC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Activity activityC = com.sigmob.sdk.base.utils.o.c(g.this);
            if (activityC == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.j(activityC);
        }

        @JavascriptInterface
        public boolean canInstallByVid(String vid, String apkName) {
            if (g.this.getAdUnitList() == null) {
                return false;
            }
            BaseAdUnit baseAdUnit = null;
            if (g.this.getAdUnitList() != null && !g.this.getAdUnitList().isEmpty()) {
                int i = 0;
                while (true) {
                    if (i >= g.this.getAdUnitList().size()) {
                        break;
                    }
                    BaseAdUnit baseAdUnit2 = g.this.getAdUnitList().get(i);
                    if (baseAdUnit2.getAd().vid.equals(vid)) {
                        baseAdUnit = baseAdUnit2;
                        break;
                    }
                    i++;
                }
            }
            if (baseAdUnit == null) {
                return false;
            }
            if (TextUtils.isEmpty(apkName)) {
                apkName = TextUtils.isEmpty(baseAdUnit.getApkName()) ? TextUtils.isEmpty(baseAdUnit.getApkMd5()) ? "" : baseAdUnit.getApkMd5() + ".apk" : baseAdUnit.getApkName();
            }
            return baseAdUnit.canInstall(apkName);
        }

        @JavascriptInterface
        public boolean canOpen(String packageName) {
            return com.sigmob.sdk.base.o.a().b(packageName).booleanValue();
        }

        @JavascriptInterface
        public boolean canOpenByVid(String vid, String packageName) {
            if (TextUtils.isEmpty(packageName)) {
                int i = 0;
                if (g.this.getAdUnitList() == null) {
                    return false;
                }
                BaseAdUnit baseAdUnit = null;
                if (g.this.getAdUnitList() != null && !g.this.getAdUnitList().isEmpty()) {
                    while (true) {
                        if (i >= g.this.getAdUnitList().size()) {
                            break;
                        }
                        BaseAdUnit baseAdUnit2 = g.this.getAdUnitList().get(i);
                        if (baseAdUnit2.getAd().vid.equals(vid)) {
                            baseAdUnit = baseAdUnit2;
                            break;
                        }
                        i++;
                    }
                }
                if (baseAdUnit != null) {
                    return baseAdUnit.canOpen();
                }
            }
            return com.sigmob.sdk.base.o.a().b(packageName).booleanValue();
        }

        @JavascriptInterface
        public void hideSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.mraid2.g$d$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        @JavascriptInterface
        public boolean isOpenListReport() {
            com.sigmob.sdk.base.o oVarA = com.sigmob.sdk.base.o.a();
            return (oVarA.V().isEmpty() || com.sigmob.sdk.base.services.b.a() || !oVarA.N().booleanValue()) ? false : true;
        }

        @JavascriptInterface
        public void onOpenListReport() {
            com.sigmob.sdk.base.services.b.c();
        }

        @JavascriptInterface
        public void showSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.mraid2.g$d$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            });
        }
    }

    private static class e {
        private View a;

        public e(View target) {
            this.a = target;
        }

        public int a() {
            return this.a.getLayoutParams().height;
        }

        public void a(int height) {
            this.a.getLayoutParams().height = height;
            this.a.requestLayout();
        }

        public int b() {
            return this.a.getLayoutParams().width;
        }

        public void b(int width) {
            this.a.getLayoutParams().width = width;
            this.a.requestLayout();
        }
    }

    public g(Context context, List<BaseAdUnit> adUnitList, FrameLayout parentLayout) {
        this(context, adUnitList, parentLayout, null, null);
        a(new d(this, null), "sigandroidh5");
    }

    public g(Context context, List<BaseAdUnit> adUnitList, FrameLayout parentLayout, g parentWebView, JSONObject args) {
        super(context);
        this.l = false;
        this.n = null;
        this.p = new AnonymousClass1();
        this.s = new LinkedHashMap();
        this.t = new c.b() { // from class: com.sigmob.sdk.mraid2.g.3
            @Override // com.sigmob.sdk.mraid2.c.b
            public void a() {
                if (g.this.g == null) {
                    return;
                }
                g.this.g.a(g.this.d);
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void a(BaseAdUnit adUnit, JSONObject args2) {
                if (g.this.g == null) {
                    return;
                }
                g.this.g.a(g.this.d, adUnit, args2);
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void a(String vid) {
                if (!TextUtils.isEmpty(vid)) {
                    for (int i = 0; i < g.this.getAdUnitList().size(); i++) {
                        g gVar = g.this;
                        gVar.n = gVar.getAdUnitList().get(i);
                        if (vid.equals(g.this.n.getVid())) {
                            break;
                        }
                    }
                }
                if (g.this.n == null) {
                    return;
                }
                com.sigmob.sdk.base.common.g.g().j(g.this.n.getCamp_id());
                com.sigmob.sdk.base.common.g.g().i(g.this.n.getCrid());
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void a(String subEvent, JSONObject args2) {
                com.sigmob.sdk.mraid.o oVar;
                SigmobLog.d(" onVpaidEvent :" + subEvent + ":" + args2);
                String strOptString = args2.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString)) {
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(strOptString);
                oVar = jVar instanceof com.sigmob.sdk.mraid.o ? (com.sigmob.sdk.mraid.o) jVar : null;
                subEvent.hashCode();
                switch (subEvent) {
                    case "replay":
                        if (oVar != null) {
                            oVar.c(args2);
                            break;
                        }
                        break;
                    case "assetURL":
                        if (oVar != null) {
                            oVar.a(args2);
                            break;
                        }
                        break;
                    case "init":
                        com.sigmob.sdk.mraid.o oVar2 = new com.sigmob.sdk.mraid.o(strOptString);
                        oVar2.a(new o.a() { // from class: com.sigmob.sdk.mraid2.g.3.1
                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String uniqueId, int state) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.a(uniqueId, state);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String uniqueId, int code, String message) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.a(uniqueId, "code:" + code + ", msg:" + message);
                                }
                                ac.a("video", code, message, g.this.n);
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String uniqueId, long position) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.c(uniqueId, (int) position);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String uniqueId, long duration, int width, int height) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.a(uniqueId, (int) duration, width, height);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void a(String uniqueId, long position, long duration) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.a(uniqueId, (int) position, (int) duration);
                                }
                            }

                            @Override // com.sigmob.sdk.mraid.o.a
                            public void b(String uniqueId, int state) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.b(uniqueId, state);
                                }
                            }
                        });
                        oVar2.a(g.this.getContext(), args2);
                        View viewB = oVar2.b();
                        if (viewB != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                            layoutParams.topMargin = 0;
                            layoutParams.rightMargin = 0;
                            viewB.setLayoutParams(layoutParams);
                        }
                        com.sigmob.sdk.mraid2.a.a.put(strOptString, oVar2);
                        break;
                    case "play":
                        if (oVar != null) {
                            oVar.b(args2);
                            break;
                        }
                        break;
                    case "seek":
                        if (oVar != null) {
                            oVar.g(args2);
                            break;
                        }
                        break;
                    case "stop":
                        if (oVar != null) {
                            oVar.e(args2);
                            oVar.c();
                            com.sigmob.sdk.mraid2.a.a.remove(oVar);
                            break;
                        }
                        break;
                    case "frame":
                        if (oVar != null) {
                            oVar.h(args2);
                            break;
                        }
                        break;
                    case "muted":
                        if (oVar != null) {
                            oVar.f(args2);
                            break;
                        }
                        break;
                    case "pause":
                        if (oVar != null) {
                            oVar.d(args2);
                            break;
                        }
                        break;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0171  */
            @Override // com.sigmob.sdk.mraid2.c.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a(org.json.JSONObject r29) {
                /*
                    Method dump skipped, instructions count: 487
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.g.AnonymousClass3.a(org.json.JSONObject):void");
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void b() {
                for (com.sigmob.sdk.mraid.j jVar : com.sigmob.sdk.mraid2.a.a.values()) {
                    if (!TextUtils.isEmpty(jVar.d()) && jVar.d().equals(g.this.e)) {
                        com.sigmob.sdk.base.utils.o.a(jVar.b());
                        jVar.c();
                    }
                }
                com.sigmob.sdk.base.utils.o.a(g.this.d);
                if (!g.this.s.isEmpty()) {
                    Iterator it = g.this.s.values().iterator();
                    while (it.hasNext()) {
                        ((n) it.next()).c();
                    }
                    g.this.s.clear();
                }
                if (g.this.d != null) {
                    g.this.d = null;
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void b(String subEvent, JSONObject args2) {
                n nVar;
                SigmobLog.d(" onTimerEvent :" + subEvent + ":" + args2);
                String strOptString = args2.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString)) {
                }
                nVar = (n) g.this.s.get(strOptString);
                subEvent.hashCode();
                switch (subEvent) {
                    case "invalidate":
                        if (nVar != null) {
                            nVar.c();
                        }
                        g.this.s.remove(strOptString);
                        break;
                    case "fire":
                        if (nVar != null) {
                            nVar.b();
                            break;
                        }
                        break;
                    case "init":
                        g.this.s.put(strOptString, new n(g.this.c, args2));
                        break;
                    case "pause":
                        if (nVar != null) {
                            nVar.a();
                            break;
                        }
                        break;
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void b(JSONObject args2) {
                String strOptString = args2.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(strOptString);
                if (jVar != null) {
                    jVar.a(g.this.e);
                    View viewB = jVar.b();
                    if (viewB != null) {
                        com.sigmob.sdk.base.utils.o.a(viewB);
                        if (!g.this.l || g.this.k == null) {
                            g.this.j.addView(viewB);
                        } else {
                            viewB.setX(0.0f);
                            viewB.setY(0.0f);
                            g.this.k.addView(viewB);
                        }
                    }
                }
                g gVar = (g) g.r.get(strOptString);
                if (gVar != null) {
                    com.sigmob.sdk.base.utils.o.a(gVar);
                    g.this.j.addView(gVar);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void c() {
                if (g.this.g == null) {
                    return;
                }
                g.this.g.b(g.this.d);
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
            @Override // com.sigmob.sdk.mraid2.c.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void c(java.lang.String r7, org.json.JSONObject r8) {
                /*
                    Method dump skipped, instructions count: 428
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.g.AnonymousClass3.c(java.lang.String, org.json.JSONObject):void");
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void c(JSONObject args2) {
                String strOptString = args2.optString("uniqueId");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(strOptString);
                if (jVar != null) {
                    jVar.a(g.this.e);
                    View viewB = jVar.b();
                    if (viewB != null) {
                        com.sigmob.sdk.base.utils.o.a(viewB);
                        if (!g.this.l || g.this.k == null) {
                            g.this.j.addView(viewB);
                            g.this.j.bringChildToFront(g.this.d);
                        } else {
                            viewB.setX(0.0f);
                            viewB.setY(0.0f);
                            g.this.k.addView(viewB);
                        }
                    }
                }
                g gVar = (g) g.r.get(strOptString);
                if (gVar != null) {
                    com.sigmob.sdk.base.utils.o.a(gVar);
                    g.this.j.addView(gVar);
                    g.this.j.bringChildToFront(g.this.d);
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void d() {
                if (g.this.g == null) {
                    return;
                }
                g.this.g.a();
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void d(JSONObject args2) {
                g.this.l = true;
                int iOptInt = args2.optInt("flag");
                if (g.this.g != null && g.this.k == null) {
                    g gVar = g.this;
                    gVar.k = gVar.g.a(g.this.d, iOptInt);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < g.this.j.getChildCount(); i++) {
                        View childAt = g.this.j.getChildAt(i);
                        if (childAt instanceof com.sigmob.sdk.mraid.m) {
                            arrayList.add((com.sigmob.sdk.mraid.m) childAt);
                        }
                    }
                    Log.d(g.o, "-------------onUseScrollView----------" + arrayList.size());
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.sigmob.sdk.mraid.m mVar = (com.sigmob.sdk.mraid.m) arrayList.get(i2);
                        mVar.setX(0.0f);
                        mVar.setY(0.0f);
                        com.sigmob.sdk.base.utils.o.a(mVar);
                        g.this.k.addView(mVar);
                    }
                }
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void e(JSONObject args2) {
                if (g.this.g == null) {
                    return;
                }
                g.this.g.b(g.this.d, args2);
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void f(JSONObject json) {
                f fVar;
                f fVar2;
                SigmobLog.d(" postMessage data:" + json);
                JSONObject jSONObjectOptJSONObject = json.optJSONObject("args");
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("uniqueId") : null;
                String strOptString2 = json.optString("subEvent");
                if (TextUtils.isEmpty(strOptString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + jSONObjectOptJSONObject);
                    return;
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(strOptString);
                fVar = jVar instanceof f ? (f) jVar : null;
                strOptString2.hashCode();
                switch (strOptString2) {
                    case "init_sensitivity_raw":
                        String strOptString3 = jSONObjectOptJSONObject.optString("type", "");
                        int iOptInt = jSONObjectOptJSONObject.optInt("sensitivity_raw", 0);
                        fVar2 = new f(strOptString, strOptString3);
                        fVar2.a(new i() { // from class: com.sigmob.sdk.mraid2.g.3.4
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String uniqueId, String type, String event, HashMap<String, Object> args2) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.a(uniqueId, type, event, args2);
                                }
                            }
                        });
                        fVar2.b(iOptInt);
                        break;
                    case "init":
                        String strOptString4 = jSONObjectOptJSONObject.optString("type", "");
                        int iOptInt2 = jSONObjectOptJSONObject.optInt("sensitivity", 0);
                        fVar2 = new f(strOptString, strOptString4);
                        fVar2.a(new i() { // from class: com.sigmob.sdk.mraid2.g.3.3
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String uniqueId, String type, String event, HashMap<String, Object> args2) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.a(uniqueId, type, event, args2);
                                }
                            }
                        });
                        fVar2.a(iOptInt2);
                        break;
                    case "destroy":
                        if (fVar != null) {
                            fVar.c();
                        }
                        com.sigmob.sdk.mraid2.a.a.remove(strOptString);
                        return;
                    default:
                        return;
                }
                fVar2.a();
                com.sigmob.sdk.mraid2.a.a.put(strOptString, fVar2);
            }

            @Override // com.sigmob.sdk.mraid2.c.b
            public void g(JSONObject json) {
                com.sigmob.sdk.mraid.h hVar;
                SigmobLog.d(" postMessage data:" + json);
                JSONObject jSONObjectOptJSONObject = json.optJSONObject("args");
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("uniqueId") : null;
                String strOptString2 = json.optString("subEvent");
                if (TextUtils.isEmpty(strOptString)) {
                    SigmobLog.e(" onMotionViewEvent uniqueId is null:" + jSONObjectOptJSONObject);
                }
                com.sigmob.sdk.mraid.j jVar = com.sigmob.sdk.mraid2.a.a.get(strOptString);
                hVar = jVar instanceof com.sigmob.sdk.mraid.h ? (com.sigmob.sdk.mraid.h) jVar : null;
                strOptString2.hashCode();
                switch (strOptString2) {
                    case "hidden":
                        if (hVar != null) {
                            hVar.a(jSONObjectOptJSONObject.optBoolean("hidden"));
                            break;
                        }
                        break;
                    case "init":
                        com.sigmob.sdk.mraid.h hVar2 = new com.sigmob.sdk.mraid.h(com.sigmob.sdk.b.e(), strOptString, jSONObjectOptJSONObject.optInt("type"));
                        hVar2.a(new i() { // from class: com.sigmob.sdk.mraid2.g.3.5
                            @Override // com.sigmob.sdk.mraid2.i
                            public void a(String uniqueId, String type, String event, HashMap<String, Object> args2) throws JSONException {
                                if (g.this.c != null) {
                                    g.this.c.a(uniqueId, type, event, args2);
                                }
                            }
                        });
                        com.sigmob.sdk.mraid2.a.a.put(strOptString, hVar2);
                        break;
                    case "frame":
                        if (hVar != null) {
                            hVar.a(jSONObjectOptJSONObject);
                            break;
                        }
                        break;
                    case "start":
                        if (hVar != null) {
                            hVar.a();
                            break;
                        }
                        break;
                    case "sensitivity":
                        if (hVar != null) {
                            hVar.a(jSONObjectOptJSONObject.optInt("sensitivity"));
                            break;
                        }
                        break;
                    case "destroy":
                        if (hVar != null) {
                            hVar.c();
                        }
                        com.sigmob.sdk.mraid2.a.a.remove(strOptString);
                        break;
                    case "sensitivity_raw":
                        if (hVar != null) {
                            hVar.b(jSONObjectOptJSONObject.optInt("sensitivity_raw"));
                            break;
                        }
                        break;
                }
            }
        };
        this.d = this;
        this.j = parentLayout;
        this.b = parentWebView;
        this.i = false;
        if (args != null) {
            try {
                this.m = new JSONObject(args.optString("args"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.e = args.optString("uniqueId");
        } else {
            String str = "wv_" + UUID.randomUUID().toString();
            this.e = str;
            r.put(str, this);
        }
        a(true);
        setBackgroundColor(0);
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.n.D, 2)));
            methodBuilder.addParam(Boolean.TYPE, true);
            methodBuilder.execute();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.n.F, 2)));
            methodBuilder2.addParam(Boolean.TYPE, true);
            methodBuilder2.execute();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.p.a(com.sigmob.sdk.base.o.a().ag());
        BaseAdUnit baseAdUnit = adUnitList.get(0);
        if (baseAdUnit != null) {
            this.p.b(baseAdUnit.isDisablexRequestWith());
        }
        setWebViewClient(this.p);
        com.sigmob.sdk.mraid2.c cVar = new com.sigmob.sdk.mraid2.c(adUnitList);
        this.c = cVar;
        cVar.a(this.t);
        this.c.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        a(new c.a(this.c), "sigandroid");
        String strMd5 = Md5Util.md5(url);
        File fileF = com.sigmob.sdk.base.utils.i.f(com.sigmob.sdk.base.utils.i.c);
        if (fileF == null) {
            return;
        }
        final File file = new File(fileF.getAbsolutePath() + File.separator + strMd5, "endcard.html");
        Log.d(o, file.exists() + "---------loadURLByPackage----------" + file.getAbsolutePath());
        if (file.exists()) {
            a(UriUtils.FILE_PREFIX + file.getAbsolutePath());
            return;
        }
        File file2 = new File(fileF, strMd5 + ".tgz");
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.url = url;
        downloadItem.filePath = file2.getAbsolutePath();
        downloadItem.type = DownloadItem.FileType.FILE;
        q.a().add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.mraid2.g.2
            public void downloadProgress(DownloadItem item, long totalSize, long readSize) {
            }

            public void onCancel(DownloadItem item) {
                Log.d(g.o, "-----------onCancel----------" + item.url);
            }

            public void onErrorResponse(DownloadItem item) {
                Log.d(g.o, "-----------onErrorResponse----------" + item.url);
            }

            public void onSuccess(DownloadItem item) {
                Log.d(g.o, item.url + "-----------onSuccess----------" + item.filePath);
                try {
                    com.sigmob.sdk.base.utils.f.a(new File(item.filePath), new File(item.filePath.replace(".tgz", "/")));
                    if (file.exists()) {
                        g.this.d.a(UriUtils.FILE_PREFIX + file.getAbsolutePath());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String templateId) {
        String strUtf8;
        MaterialMeta materialMeta;
        Template template;
        Log.d(o, "---------loadContentId----------" + templateId);
        for (int i = 0; i < getAdUnitList().size(); i++) {
            BaseAdUnit baseAdUnit = getAdUnitList().get(i);
            if (baseAdUnit != null) {
                if (baseAdUnit.scene == null || !templateId.equals(baseAdUnit.scene.templateId)) {
                    Ad ad = baseAdUnit.getAd();
                    if (ad != null && ad.materials != null && (materialMeta = ad.materials.get(0)) != null) {
                        if (materialMeta.main_template != null && templateId.equals(materialMeta.main_template.templateId)) {
                            template = materialMeta.main_template;
                        } else if (materialMeta.sub_template != null && templateId.equals(materialMeta.sub_template.templateId)) {
                            template = materialMeta.sub_template;
                        }
                    }
                } else {
                    template = baseAdUnit.scene;
                }
                strUtf8 = template.context.utf8();
                break;
            }
        }
        strUtf8 = null;
        if (TextUtils.isEmpty(strUtf8)) {
            return;
        }
        c(strUtf8);
    }

    public static HashMap<String, g> getMraidWebViews() {
        return r;
    }

    @Override // com.sigmob.sdk.mraid2.a
    public void a() {
        try {
            setLoadListener(null);
            setNextWebViewListener(null);
            setScrollTouchListener(null);
            if (this.d != null) {
                this.d = null;
            }
            com.sigmob.sdk.mraid2.c cVar = this.c;
            if (cVar != null) {
                cVar.g();
                this.c = null;
            }
            super.a();
        } catch (Throwable unused) {
        }
    }

    public void c(String htmlData) {
        a(new c.a(this.c), "sigandroid");
        File fileB = com.sigmob.sdk.base.utils.i.b(htmlData, Md5Util.md5(htmlData) + ".html");
        if (fileB == null || TextUtils.isEmpty(fileB.getAbsolutePath())) {
            a(Networking.getBaseUrlScheme() + "://localhost/", htmlData, "text/html", "UTF-8", null);
        } else {
            a(UriUtils.FILE_PREFIX + fileB.getAbsolutePath());
        }
    }

    public void d(String url) {
        Log.d(o, "---------loadContentUrl----------" + url);
        a(new c.a(this.c), "sigandroid");
        a(url);
    }

    public com.sigmob.sdk.base.common.f getAdSize() {
        return this.q;
    }

    @Override // com.sigmob.sdk.mraid2.a
    List<BaseAdUnit> getAdUnitList() {
        com.sigmob.sdk.mraid2.c cVar = this.c;
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }

    public com.sigmob.sdk.mraid2.c getMraidBridge() {
        return this.c;
    }

    public c getScrollTouchListener() {
        return this.f;
    }

    public String getUniqueId() {
        return this.e;
    }

    public void k() {
        BaseAdUnit baseAdUnit = getAdUnitList().get(0);
        Template template = baseAdUnit.scene != null ? baseAdUnit.scene : (baseAdUnit.getMaterial() == null || baseAdUnit.getMaterial().main_template == null) ? (baseAdUnit.getMaterial() == null || baseAdUnit.getMaterial().sub_template == null) ? null : baseAdUnit.getMaterial().sub_template : baseAdUnit.getMaterial().main_template;
        if (template == null) {
            return;
        }
        int iIntValue = template.type.intValue();
        if (iIntValue == 1) {
            d(template.context.utf8());
            return;
        }
        if (iIntValue == 2) {
            c(template.context.utf8());
        } else if (iIntValue != 3) {
            SigmobLog.e("template type error:" + template.type);
        } else {
            e(template.context.utf8());
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) throws JSONException {
        super.onVisibilityChanged(changedView, visibility);
        com.sigmob.sdk.mraid2.c cVar = this.c;
        if (cVar != null) {
            cVar.a(visibility == 0);
        }
    }

    public void setAdSize(com.sigmob.sdk.base.common.f adSize) {
        this.q = adSize;
    }

    public void setLoadListener(a loadWebViewListener) {
        this.h = loadWebViewListener;
    }

    public void setNextWebViewListener(b nextWebViewListener) {
        this.g = nextWebViewListener;
    }

    public void setScrollTouchListener(c scrollTouchListener) {
        this.f = scrollTouchListener;
    }
}
