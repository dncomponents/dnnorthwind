package com.dncomponents.northwind.dashboard;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.northwind.Util;
import elemental2.core.JsObject;

import static com.dncomponents.northwind.dto.Api.ORDERS;
import static com.dncomponents.northwind.dto.Api.r;

public class DashboardActivity extends AbstractActivity<DashboardView, DashboardPlace> implements DashboardView.DashboardPresenter {

    public DashboardActivity(DashboardView view, DashboardPlace place) {
        super(view, place);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showCountriesStat();
    }

    private void showCountriesStat() {
        Util.get(r(ORDERS + "/stat"), new AsyncCallBack() {
            @Override
            public void onSuccess(Object result) {
                view.showCountries((JsObject[]) result, "orders", "#cd4f90", "Orders by countries");
            }

            @Override
            public void onFailure(Throwable caught) {

            }
        });
    }
}
