package com.dncomponents.northwind.products;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.northwind.Util;
import com.dncomponents.northwind.dto.ProductDTO;

import static com.dncomponents.northwind.dto.Api.PRODUCTS;
import static com.dncomponents.northwind.dto.Api.r;

public class ProductsActivity extends AbstractActivity<ProductsView, ProductsPlace> implements ProductsView.ProductsPresenter {

    public ProductsActivity(ProductsView view, ProductsPlace place) {
        super(view, place);
    }

    private void loadProducts() {
        Util.get(r(PRODUCTS), new AsyncCallBack<ProductDTO[]>() {
            @Override
            public void onSuccess(ProductDTO[] result) {
                view.setProducts(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                view.showError(caught.getMessage());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadProducts();
    }

    @Override
    public void updateProduct(ProductDTO model, AsyncCallBack<ProductDTO> callback) {
        Util.put(r(PRODUCTS), model, callback);
    }

    @Override
    public void addNewProduct(ProductDTO model, AsyncCallBack<ProductDTO> callBack) {
        Util.put(r(PRODUCTS), model, callBack);
    }

    @Override
    public void removeProduct(Integer id, AsyncCallBack callBack) {
        Util.delete(r(PRODUCTS) + "/" + id, callBack);
    }

}
