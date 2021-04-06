package com.dncomponents.northwind.dashboard;

import com.dncomponents.UiField;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.views.appview.AbstractView;
import elemental2.core.JsObject;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLElement;
import jsinterop.annotations.JsMethod;

import static jsinterop.annotations.JsPackage.GLOBAL;

public class DashboardViewImpl extends AbstractView<DashboardActivity> implements DashboardView {
    private static DashboardViewImpl instance;

    @UiField
    HTMLElement root;
    @UiField
    HTMLCanvasElement canvas;

    {
        HtmlBinder.get(DashboardViewImpl.class, this).bind();
    }

    private DashboardViewImpl() {
        init();
    }

    @JsMethod(namespace = GLOBAL)
    public static native void showStatsJs(HTMLCanvasElement canvas, JsObject[] a, String label, String color, String title);

    public static DashboardViewImpl getInstance() {
        if (instance == null)
            instance = new DashboardViewImpl();
        return instance;
    }

    private void init() {

    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    @Override
    public void showCountries(JsObject[] arr, String label, String color, String title) {
        showStatsJs(canvas, arr, label, color, title);
    }

}
