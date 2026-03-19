package com.duoyou.task.sdk.xutils.http;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.duoyou.task.sdk.xutils.common.util.KeyValue;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.body.FileBody;
import com.duoyou.task.sdk.xutils.http.body.InputStreamBody;
import com.duoyou.task.sdk.xutils.http.body.MultipartBody;
import com.duoyou.task.sdk.xutils.http.body.RequestBody;
import com.duoyou.task.sdk.xutils.http.body.StringBody;
import com.duoyou.task.sdk.xutils.http.body.UrlEncodedBody;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class BaseParams {
    private String bodyContent;
    private String bodyContentType;
    private HttpMethod method;
    private RequestBody requestBody;
    private String charset = "UTF-8";
    private boolean multipart = false;
    private boolean asJsonContent = false;
    private boolean asJsonArrayContent = false;
    private final List<Header> headers = new ArrayList();
    private final List<KeyValue> queryStringParams = new ArrayList();
    private final List<KeyValue> bodyParams = new ArrayList();

    public void setCharset(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.charset = str;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public boolean isMultipart() {
        return this.multipart;
    }

    public void setMultipart(boolean z) {
        this.multipart = z;
    }

    public boolean isAsJsonContent() {
        return this.asJsonContent;
    }

    public void setAsJsonContent(boolean z) {
        this.asJsonContent = z;
    }

    public boolean isAsJsonArrayContent() {
        return this.asJsonArrayContent;
    }

    public void setAsJsonArrayContent(boolean z) {
        this.asJsonArrayContent = z;
    }

    public void setHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Header header = new Header(str, str2, true);
        Iterator<Header> it = this.headers.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().key)) {
                it.remove();
            }
        }
        this.headers.add(header);
    }

    public void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.headers.add(new Header(str, str2, false));
    }

    public void addParameter(String str, Object obj) {
        if (HttpMethod.permitsRequestBody(this.method)) {
            addBodyParameter(str, obj, null, null);
        } else {
            addQueryStringParameter(str, obj);
        }
    }

    public void addQueryStringParameter(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.queryStringParams.add(new ArrayItem(str, it.next()));
            }
            return;
        }
        int i = 0;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            while (i < length) {
                this.queryStringParams.add(new ArrayItem(str, jSONArray.opt(i)));
                i++;
            }
            return;
        }
        if (obj != null && obj.getClass().isArray()) {
            int length2 = Array.getLength(obj);
            while (i < length2) {
                this.queryStringParams.add(new ArrayItem(str, Array.get(obj, i)));
                i++;
            }
            return;
        }
        this.queryStringParams.add(new KeyValue(str, obj));
    }

    public void addBodyParameter(String str, Object obj) {
        addBodyParameter(str, obj, null, null);
    }

    public void addBodyParameter(String str, Object obj, String str2) {
        addBodyParameter(str, obj, str2, null);
    }

    public void addBodyParameter(String str, Object obj, String str2, String str3) {
        if (TextUtils.isEmpty(str) && obj == null) {
            return;
        }
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            if (obj instanceof Iterable) {
                Iterator it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    this.bodyParams.add(new ArrayItem(str, it.next()));
                }
                return;
            }
            int i = 0;
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                while (i < length) {
                    this.bodyParams.add(new ArrayItem(str, jSONArray.opt(i)));
                    i++;
                }
                return;
            }
            if (obj instanceof byte[]) {
                this.bodyParams.add(new KeyValue(str, obj));
                return;
            }
            if (obj != null && obj.getClass().isArray()) {
                int length2 = Array.getLength(obj);
                while (i < length2) {
                    this.bodyParams.add(new ArrayItem(str, Array.get(obj, i)));
                    i++;
                }
                return;
            }
            this.bodyParams.add(new KeyValue(str, obj));
            return;
        }
        this.bodyParams.add(new BodyItemWrapper(str, obj, str2, str3));
    }

    public void setBodyContent(String str) {
        this.bodyContent = str;
    }

    public String getBodyContent() {
        checkBodyParams();
        return this.bodyContent;
    }

    public void setBodyContentType(String str) {
        this.bodyContentType = str;
    }

    public List<Header> getHeaders() {
        return new ArrayList(this.headers);
    }

    public List<KeyValue> getQueryStringParams() {
        checkBodyParams();
        return new ArrayList(this.queryStringParams);
    }

    public List<KeyValue> getBodyParams() {
        checkBodyParams();
        return new ArrayList(this.bodyParams);
    }

    public List<KeyValue> getParams(String str) {
        ArrayList arrayList = new ArrayList();
        for (KeyValue keyValue : this.queryStringParams) {
            if (str != null && str.equals(keyValue.key)) {
                arrayList.add(keyValue);
            }
        }
        for (KeyValue keyValue2 : this.bodyParams) {
            if (str == null && keyValue2.key == null) {
                arrayList.add(keyValue2);
            } else if (str != null && str.equals(keyValue2.key)) {
                arrayList.add(keyValue2);
            }
        }
        return arrayList;
    }

    public void clearParams() {
        this.queryStringParams.clear();
        this.bodyParams.clear();
        this.bodyContent = null;
        this.bodyContentType = null;
        this.requestBody = null;
    }

    public void removeParameter(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bodyContent = null;
            this.bodyContentType = null;
        } else {
            Iterator<KeyValue> it = this.queryStringParams.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().key)) {
                    it.remove();
                }
            }
        }
        Iterator<KeyValue> it2 = this.bodyParams.iterator();
        while (it2.hasNext()) {
            KeyValue next = it2.next();
            if (str == null && next.key == null) {
                it2.remove();
            } else if (str != null && str.equals(next.key)) {
                it2.remove();
            }
        }
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public RequestBody getRequestBody() {
        checkBodyParams();
        RequestBody requestBody = this.requestBody;
        if (requestBody != null) {
            return requestBody;
        }
        if (!TextUtils.isEmpty(this.bodyContent)) {
            StringBody stringBody = new StringBody(this.bodyContent, this.charset);
            stringBody.setContentType(this.bodyContentType);
            return stringBody;
        }
        if (this.multipart) {
            MultipartBody multipartBody = new MultipartBody(this.bodyParams, this.charset);
            multipartBody.setContentType(this.bodyContentType);
            return multipartBody;
        }
        if (this.bodyParams.size() == 1) {
            KeyValue keyValue = this.bodyParams.get(0);
            String str = keyValue.key;
            Object obj = keyValue.value;
            String str2 = keyValue instanceof BodyItemWrapper ? ((BodyItemWrapper) keyValue).contentType : null;
            if (TextUtils.isEmpty(str2)) {
                str2 = this.bodyContentType;
            }
            if (obj instanceof File) {
                return new FileBody((File) obj, str2);
            }
            if (obj instanceof InputStream) {
                return new InputStreamBody((InputStream) obj, str2);
            }
            if (obj instanceof byte[]) {
                return new InputStreamBody(new ByteArrayInputStream((byte[]) obj), str2);
            }
            if (TextUtils.isEmpty(str)) {
                StringBody stringBody2 = new StringBody(keyValue.getValueStrOrEmpty(), this.charset);
                stringBody2.setContentType(str2);
                return stringBody2;
            }
            UrlEncodedBody urlEncodedBody = new UrlEncodedBody(this.bodyParams, this.charset);
            urlEncodedBody.setContentType(str2);
            return urlEncodedBody;
        }
        UrlEncodedBody urlEncodedBody2 = new UrlEncodedBody(this.bodyParams, this.charset);
        urlEncodedBody2.setContentType(this.bodyContentType);
        return urlEncodedBody2;
    }

    public String toJSONString() {
        return toJSONString(true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.queryStringParams.isEmpty()) {
            for (KeyValue keyValue : this.queryStringParams) {
                sb.append(keyValue.key).append("=").append(keyValue.value).append(a.n);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (!TextUtils.isEmpty(this.bodyContent)) {
            sb.append("<").append(this.bodyContent).append(">");
        } else if (!this.bodyParams.isEmpty()) {
            sb.append("<");
            for (KeyValue keyValue2 : this.bodyParams) {
                sb.append(keyValue2.key).append("=").append(keyValue2.value).append(a.n);
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(">");
        }
        return sb.toString();
    }

    private synchronized void checkBodyParams() {
        if (this.bodyParams.isEmpty()) {
            return;
        }
        if (this.requestBody == null && HttpMethod.permitsRequestBody(this.method)) {
            if (this.asJsonContent || this.asJsonArrayContent) {
                try {
                    this.bodyContent = toJSONString(false);
                    this.bodyParams.clear();
                } catch (JSONException e) {
                    throw new IllegalArgumentException(e.getMessage(), e);
                }
            } else if (!TextUtils.isEmpty(this.bodyContent)) {
                this.queryStringParams.addAll(this.bodyParams);
                this.bodyParams.clear();
            }
            return;
        }
        this.queryStringParams.addAll(this.bodyParams);
        this.bodyParams.clear();
    }

    private void params2Json(JSONObject jSONObject, List<KeyValue> list) throws JSONException {
        JSONArray jSONArray;
        HashSet hashSet = new HashSet(list.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        for (int i = 0; i < list.size(); i++) {
            KeyValue keyValue = list.get(i);
            String str = keyValue.key;
            if (!TextUtils.isEmpty(str)) {
                if (linkedHashMap.containsKey(str)) {
                    jSONArray = (JSONArray) linkedHashMap.get(str);
                } else {
                    jSONArray = new JSONArray();
                    linkedHashMap.put(str, jSONArray);
                }
                jSONArray.put(RequestParamsHelper.parseJSONObject(keyValue.value));
                if (keyValue instanceof ArrayItem) {
                    hashSet.add(str);
                }
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            JSONArray jSONArray2 = (JSONArray) entry.getValue();
            if (jSONArray2.length() > 1 || hashSet.contains(str2)) {
                jSONObject.put(str2, jSONArray2);
            } else {
                jSONObject.put(str2, jSONArray2.get(0));
            }
        }
    }

    private String toJSONString(boolean z) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = null;
        if (!TextUtils.isEmpty(this.bodyContent)) {
            if (this.bodyContent.trim().startsWith("[")) {
                jSONArray = new JSONArray(this.bodyContent);
                if (jSONArray.length() > 0) {
                    Object obj = jSONArray.get(0);
                    if (obj instanceof JSONObject) {
                        jSONObject = (JSONObject) obj;
                    } else {
                        LogUtil.w("only contains bodyContent");
                        return jSONArray.toString();
                    }
                } else {
                    jSONObject = new JSONObject();
                    jSONArray.put(jSONObject);
                }
            } else {
                jSONObject = new JSONObject(this.bodyContent);
            }
        } else {
            jSONObject = new JSONObject();
            if (this.asJsonArrayContent) {
                jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList(this.queryStringParams.size() + this.bodyParams.size());
            arrayList.addAll(this.queryStringParams);
            arrayList.addAll(this.bodyParams);
            params2Json(jSONObject, arrayList);
        } else {
            params2Json(jSONObject, this.bodyParams);
        }
        return jSONArray != null ? jSONArray.toString() : jSONObject.toString();
    }

    public static final class ArrayItem extends KeyValue {
        public ArrayItem(String str, Object obj) {
            super(str, obj);
        }
    }

    public static final class Header extends KeyValue {
        public final boolean setHeader;

        public Header(String str, String str2, boolean z) {
            super(str, str2);
            this.setHeader = z;
        }
    }

    public static final class BodyItemWrapper extends KeyValue {
        public final String contentType;
        public final String fileName;

        public BodyItemWrapper(String str, Object obj, String str2, String str3) {
            super(str, obj);
            if (TextUtils.isEmpty(str2)) {
                this.contentType = MediaTypeUtils.APPLICATION_OCTET_STREAM;
            } else {
                this.contentType = str2;
            }
            this.fileName = str3;
        }
    }
}
