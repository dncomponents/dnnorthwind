package com.dncomponents.northwind.products;

import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;

public class ProductsPlace extends Place {

    public static final class ProductsPlaceRegister extends PlaceRegister<ProductsPlace> {

        private static final String TOKEN = "Products".toLowerCase();

        public static ProductsPlaceRegister instance = new ProductsPlaceRegister();

        private ProductsPlaceRegister() {
        }

        @Override
        public String getHistoryToken() {
            return TOKEN;
        }

        @Override
        public ProductsPlace getPlaceFromToken(String token) {
            return new ProductsPlace();
        }

        @Override
        public String getTokenFromPlace(ProductsPlace place) {
            return TOKEN;
        }

        @Override
        public AbstractActivity getActivity(ProductsPlace place) {
            return new ProductsActivity(ProductsViewImpl.getInstance(), place);
        }

        @Override
        public Class<? extends Place> forPlace() {
            return ProductsPlace.class;
        }

    }

}
