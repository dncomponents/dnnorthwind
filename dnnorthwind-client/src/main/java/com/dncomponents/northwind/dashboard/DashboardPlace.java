package com.dncomponents.northwind.dashboard;

import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;

public class DashboardPlace extends Place {

    public static final class DashboardPlaceRegister extends PlaceRegister<DashboardPlace> {

        private static final String TOKEN = "Dashboard".toLowerCase();

        public static DashboardPlaceRegister instance = new DashboardPlaceRegister();

        private DashboardPlaceRegister() {
        }

        @Override
        public String getHistoryToken() {
            return TOKEN;
        }

        @Override
        public DashboardPlace getPlaceFromToken(String token) {
            return new DashboardPlace();
        }

        @Override
        public String getTokenFromPlace(DashboardPlace place) {
            return TOKEN;
        }

        @Override
        public AbstractActivity getActivity(DashboardPlace place) {
            return new DashboardActivity(DashboardViewImpl.getInstance(), place);
        }

        @Override
        public Class<? extends Place> forPlace() {
            return DashboardPlace.class;
        }

    }

}
