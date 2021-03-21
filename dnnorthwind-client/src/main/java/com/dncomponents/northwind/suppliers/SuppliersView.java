package com.dncomponents.northwind.suppliers;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.IsElement;
import com.dncomponents.client.views.appview.HasPresenter;
import com.dncomponents.client.views.appview.Presenter;
import com.dncomponents.northwind.dto.SupplierDTO;

public interface SuppliersView extends IsElement, HasPresenter<SuppliersActivity> {

    void showError(String message);

    void setSuppliers(SupplierDTO[] customers);

    interface SuppliersPresenter extends Presenter {
        void updateSupplier(SupplierDTO model, AsyncCallBack<SupplierDTO> callback);

        void addNewSupplier(SupplierDTO model, AsyncCallBack<SupplierDTO> callBack);

        void removeSupplier(Integer id, AsyncCallBack callBack);

    }

}
