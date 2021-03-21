package com.dncomponents.northwind.customer;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.IsElement;
import com.dncomponents.client.views.appview.HasPresenter;
import com.dncomponents.client.views.appview.Presenter;
import com.dncomponents.northwind.dto.CustomerDTO;

public interface CustomersView extends IsElement, HasPresenter<CustomersActivity> {

    void setCustomers(CustomerDTO[] customers);

    void showError(String message);

    interface CustomersPresenter extends Presenter {

        void updateModel(CustomerDTO model, AsyncCallBack<CustomerDTO> callback);

        void addNewCustomer(CustomerDTO model, AsyncCallBack<CustomerDTO> callBack);

        void removeCustomer(Integer id, AsyncCallBack callBack);
    }

}
