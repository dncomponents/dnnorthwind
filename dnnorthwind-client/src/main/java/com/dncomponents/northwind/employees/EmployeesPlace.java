package com.dncomponents.northwind.employees;

import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;

public class EmployeesPlace extends Place {

    public static final class EmployeesPlaceRegister extends PlaceRegister<EmployeesPlace> {

        private static final String TOKEN = "employees";

        public static EmployeesPlaceRegister instance = new EmployeesPlaceRegister();

        private EmployeesPlaceRegister() {
        }

        @Override
        public String getHistoryToken() {
            return TOKEN;
        }

        @Override
        public EmployeesPlace getPlaceFromToken(String token) {
            return new EmployeesPlace();
        }

        @Override
        public String getTokenFromPlace(EmployeesPlace place) {
            return TOKEN;
        }

        @Override
        public AbstractActivity getActivity(EmployeesPlace place) {
            return new EmployeesActivity(EmployeesViewImpl.getInstance(), place);
        }

        @Override
        public Class<? extends Place> forPlace() {
            return EmployeesPlace.class;
        }

    }

}
