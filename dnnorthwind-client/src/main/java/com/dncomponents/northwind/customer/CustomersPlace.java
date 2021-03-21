package com.dncomponents.northwind.customer;

import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;

public class CustomersPlace extends Place {

    public static final class CustomersPlaceRegister extends PlaceRegister<CustomersPlace> {

        private static final String TOKEN = "customers";

        public static CustomersPlaceRegister instance = new CustomersPlaceRegister();

        private CustomersPlaceRegister() {
        }

        @Override
        public String getHistoryToken() {
            return TOKEN;
        }

        @Override
        public CustomersPlace getPlaceFromToken(String token) {
            return new CustomersPlace();
        }

        @Override
        public String getTokenFromPlace(CustomersPlace place) {
            return TOKEN;
        }

        @Override
        public AbstractActivity getActivity(CustomersPlace place) {
            return new CustomersActivity(CustomersViewImpl.getInstance(), place);
        }

        @Override
        public Class<? extends Place> forPlace() {
            return CustomersPlace.class;
        }

    }
}
