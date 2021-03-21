package com.dncomponents.northwind.customer;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;
import com.dncomponents.northwind.Util;
import com.dncomponents.northwind.dto.CustomerDTO;

import static com.dncomponents.northwind.dto.Api.CUSTOMERS;
import static com.dncomponents.northwind.dto.Api.r;

public class CustomersActivity extends AbstractActivity<CustomersView, Place>
        implements CustomersView.CustomersPresenter {

    public CustomersActivity(CustomersView view, Place place) {
        super(view, place);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadCustomers();
    }

    @Override
    protected boolean onStop() {
        return super.onStop();
    }

    private void loadCustomers() {
        Util.get(r(CUSTOMERS), new AsyncCallBack<CustomerDTO[]>() {
            @Override
            public void onSuccess(CustomerDTO[] result) {
                view.setCustomers(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                view.showError(caught.getMessage());
            }
        });
    }

    @Override
    public void updateModel(CustomerDTO model, AsyncCallBack<CustomerDTO> callback) {
        Util.put(r(CUSTOMERS), model, callback);
    }

    @Override
    public void addNewCustomer(CustomerDTO model, AsyncCallBack<CustomerDTO> callBack) {
        Util.put(r(CUSTOMERS), model, callBack);
    }

    @Override
    public void removeCustomer(Integer id, AsyncCallBack callBack) {
        Util.delete(r(CUSTOMERS) + "/" + id, callBack);
    }

}
