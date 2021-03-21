package com.dncomponents.northwind.orders;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.northwind.Util;
import com.dncomponents.northwind.dto.OrderDTO;
import com.dncomponents.northwind.dto.OrderDetailDTO;

import static com.dncomponents.northwind.dto.Api.*;

public class OrdersActivity extends AbstractActivity<OrdersView, OrdersPlace> implements OrdersView.OrdersPresenter {

    public OrdersActivity(OrdersView view, OrdersPlace place) {
        super(view, place);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadOrders();
    }

    @Override
    protected boolean onStop() {
        return super.onStop();
    }

    private void loadOrders() {
        Util.get(r(ORDERS), new AsyncCallBack<OrderDTO[]>() {
            @Override
            public void onSuccess(OrderDTO[] result) {
                view.setOrders(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                view.showError(caught.getMessage());
            }
        });

    }

    @Override
    public void updateOrder(OrderDTO model, AsyncCallBack<OrderDTO> callback) {

    }

    @Override
    public void addNewOrder(OrderDTO model, AsyncCallBack<OrderDTO> callBack) {

    }

    @Override
    public void showOrderDetail(Integer id, AsyncCallBack<OrderDetailDTO[]> callBack) {
        Util.get(r(ORDER_DETAILS) + "/" + id, callBack);
    }

    @Override
    public void removeOrder(Integer id, AsyncCallBack callBack) {

    }
}
