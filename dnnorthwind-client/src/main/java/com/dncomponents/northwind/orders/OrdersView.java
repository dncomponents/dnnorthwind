package com.dncomponents.northwind.orders;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.IsElement;
import com.dncomponents.client.views.appview.HasPresenter;
import com.dncomponents.client.views.appview.Presenter;
import com.dncomponents.northwind.dto.OrderDTO;
import com.dncomponents.northwind.dto.OrderDetailDTO;

public interface OrdersView extends IsElement, HasPresenter<OrdersActivity> {

    void showError(String message);

    void setOrders(OrderDTO[] customers);

    interface OrdersPresenter extends Presenter {
        void updateOrder(OrderDTO model, AsyncCallBack<OrderDTO> callback);

        void addNewOrder(OrderDTO model, AsyncCallBack<OrderDTO> callBack);

        void showOrderDetail(Integer orderId, AsyncCallBack<OrderDetailDTO[]> callBack);

        void removeOrder(Integer id, AsyncCallBack callBack);

    }

}
