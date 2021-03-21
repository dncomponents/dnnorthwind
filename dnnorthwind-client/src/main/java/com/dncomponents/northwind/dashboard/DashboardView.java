package com.dncomponents.northwind.dashboard;

import com.dncomponents.client.views.IsElement;
import com.dncomponents.client.views.appview.HasPresenter;
import com.dncomponents.client.views.appview.Presenter;
import elemental2.core.JsObject;

public interface DashboardView extends IsElement, HasPresenter<DashboardActivity> {

    void showCountries(JsObject[] arr, String label, String color, String title);

    interface DashboardPresenter extends Presenter {
    }
}
