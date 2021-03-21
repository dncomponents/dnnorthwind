package com.dncomponents.northwind.suppliers;

import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;

public class SuppliersPlace extends Place {

    public static final class SuppliersPlaceRegister extends PlaceRegister<SuppliersPlace> {

        private static final String TOKEN = "Suppliers".toLowerCase();

        public static SuppliersPlaceRegister instance = new SuppliersPlaceRegister();

        private SuppliersPlaceRegister() {
        }

        @Override
        public String getHistoryToken() {
            return TOKEN;
        }

        @Override
        public SuppliersPlace getPlaceFromToken(String token) {
            return new SuppliersPlace();
        }

        @Override
        public String getTokenFromPlace(SuppliersPlace place) {
            return TOKEN;
        }

        @Override
        public AbstractActivity getActivity(SuppliersPlace place) {
            return new SuppliersActivity(SuppliersViewImpl.getInstance(), place);
        }

        @Override
        public Class<? extends Place> forPlace() {
            return SuppliersPlace.class;
        }

    }

}
