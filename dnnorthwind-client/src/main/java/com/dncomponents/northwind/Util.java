package com.dncomponents.northwind;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.RequestInit;
import elemental2.dom.Response;
import jsinterop.base.JsPropertyMap;

import static elemental2.core.Global.JSON;


public class Util {

    public static <T> void get(String input, AsyncCallBack<T> callBack) {
        DomGlobal.fetch(input)
                .then(Response::json)
                .then(data -> {
                    checkForErrors(data, callBack);
                    callBack.onSuccess((T) data);
                    return null;
                }).
                catch_(error -> {
                    callBack.onFailure(new Exception(error.toString()));
                    return null;
                });
    }

    public static <T> void put(String input, Object bodyObj, AsyncCallBack<T> callBack) {
        call("PUT", input, bodyObj, callBack);
    }

    public static void delete(String input, AsyncCallBack callBack) {
        DomGlobal.fetch(input, request("DELETE", null))
                .then(data -> {
                    checkForErrors(data, callBack);
                    callBack.onSuccess("");
                    return null;
                }).
                catch_(error -> {
                    callBack.onFailure(new Exception(error.toString()));
                    return null;
                });
    }

    public static void call(String method, String input, Object bodyObj, AsyncCallBack callBack) {
        DomGlobal.fetch(input, request(method, bodyObj))
                .then(Response::json)
                .then(data -> {
                    checkForErrors(data, callBack);
                    callBack.onSuccess(data);
                    return null;
                }).catch_(error -> {
            callBack.onFailure(new Exception(error.toString()));
            return null;
        });
    }

    public static RequestInit request(String method, Object arg) {
        final RequestInit requestInit = RequestInit.create();
        requestInit.setMethod(method);
        if (arg != null)
            requestInit.setBody(JSON.stringify(arg));
        JsArray<JsArray<String>> s = new JsArray<>();
        s.push(JsArray.of("content-type", "application/json"));
        requestInit.setHeaders(s);
        return requestInit;
    }

    private static void checkForErrors(Object data, AsyncCallBack callBack) {
        JsPropertyMap map = (JsPropertyMap) data;
        if (map.get("error") != null) {
            throw new Error(map.get("error").toString() + "  " + map.get("message"));
        }
    }

}
