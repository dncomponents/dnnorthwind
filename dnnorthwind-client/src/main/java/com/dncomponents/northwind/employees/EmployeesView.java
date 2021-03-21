package com.dncomponents.northwind.employees;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.IsElement;
import com.dncomponents.client.views.appview.HasPresenter;
import com.dncomponents.client.views.appview.Presenter;
import com.dncomponents.northwind.dto.EmployeeDTO;

public interface EmployeesView extends IsElement, HasPresenter<EmployeesActivity> {

    void showError(String message);

    void setEmployees(EmployeeDTO[] customers);

    interface EmployeesPresenter extends Presenter {

        void updateEmployee(EmployeeDTO model, AsyncCallBack<EmployeeDTO> callback);

        void addNewEmployee(EmployeeDTO model, AsyncCallBack<EmployeeDTO> callBack);

        void removeEmployee(Integer id, AsyncCallBack callBack);

    }

}
