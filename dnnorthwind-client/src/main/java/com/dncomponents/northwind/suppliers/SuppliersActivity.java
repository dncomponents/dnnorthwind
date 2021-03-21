package com.dncomponents.northwind.suppliers;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.northwind.Util;
import com.dncomponents.northwind.dto.SupplierDTO;

import static com.dncomponents.northwind.dto.Api.SUPPLIERS;
import static com.dncomponents.northwind.dto.Api.r;

public class SuppliersActivity extends AbstractActivity<SuppliersView, SuppliersPlace> implements SuppliersView.SuppliersPresenter {

    public SuppliersActivity(SuppliersView view, SuppliersPlace place) {
        super(view, place);
    }

    private void loadSuppliers() {
        Util.get(r(SUPPLIERS), new AsyncCallBack<SupplierDTO[]>() {
            @Override
            public void onSuccess(SupplierDTO[] result) {
                view.setSuppliers(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                view.showError(caught.getMessage());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadSuppliers();
    }

    @Override
    public void updateSupplier(SupplierDTO model, AsyncCallBack<SupplierDTO> callback) {
        Util.put(r(SUPPLIERS), model, callback);
    }

    @Override
    public void addNewSupplier(SupplierDTO model, AsyncCallBack<SupplierDTO> callBack) {
        Util.put(r(SUPPLIERS), model, callBack);
    }

    @Override
    public void removeSupplier(Integer id, AsyncCallBack callBack) {
        Util.delete(r(SUPPLIERS) + "/" + id, callBack);
    }

}
