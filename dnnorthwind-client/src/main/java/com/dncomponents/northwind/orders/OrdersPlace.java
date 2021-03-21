package com.dncomponents.northwind.orders;

import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;

public class OrdersPlace extends Place {

    public static final class OrdersPlaceRegister extends PlaceRegister<OrdersPlace> {

        private static final String TOKEN = "orders";

        public static OrdersPlaceRegister instance = new OrdersPlaceRegister();

        private OrdersPlaceRegister() {
        }

        @Override
        public String getHistoryToken() {
            return TOKEN;
        }

        @Override
        public OrdersPlace getPlaceFromToken(String token) {
            return new OrdersPlace();
        }

        @Override
        public String getTokenFromPlace(OrdersPlace place) {
            return TOKEN;
        }

        @Override
        public AbstractActivity getActivity(OrdersPlace place) {
            return new OrdersActivity(OrdersViewImpl.getInstance(), place);
        }

        @Override
        public Class<? extends Place> forPlace() {
            return OrdersPlace.class;
        }

    }

}
