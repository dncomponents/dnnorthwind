package com.dncomponents.northwind.products;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.IsElement;
import com.dncomponents.client.views.appview.HasPresenter;
import com.dncomponents.client.views.appview.Presenter;
import com.dncomponents.northwind.dto.ProductDTO;

public interface ProductsView extends IsElement, HasPresenter<ProductsActivity> {

    void showError(String message);

    void setProducts(ProductDTO[] customers);

    interface ProductsPresenter extends Presenter {
        void updateProduct(ProductDTO model, AsyncCallBack<ProductDTO> callback);

        void addNewProduct(ProductDTO model, AsyncCallBack<ProductDTO> callBack);

        void removeProduct(Integer id, AsyncCallBack callBack);

    }

}
