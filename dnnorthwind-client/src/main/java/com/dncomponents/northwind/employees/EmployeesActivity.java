package com.dncomponents.northwind.employees;

import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.views.appview.AbstractActivity;
import com.dncomponents.client.views.appview.Place;
import com.dncomponents.northwind.Util;
import com.dncomponents.northwind.dto.EmployeeDTO;

import static com.dncomponents.northwind.dto.Api.EMPLOYEES;
import static com.dncomponents.northwind.dto.Api.r;

public class EmployeesActivity extends AbstractActivity<EmployeesView, Place>
        implements EmployeesView.EmployeesPresenter {

    public EmployeesActivity(EmployeesView view, EmployeesPlace place) {
        super(view, place);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadEmployees();
    }

    @Override
    protected boolean onStop() {
        return super.onStop();
    }

    private void loadEmployees() {
        Util.get(r(EMPLOYEES), new AsyncCallBack<EmployeeDTO[]>() {
            @Override
            public void onSuccess(EmployeeDTO[] result) {
                view.setEmployees(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                view.showError(caught.getMessage());
            }
        });

    }

    @Override
    public void updateEmployee(EmployeeDTO model, AsyncCallBack<EmployeeDTO> callback) {
        Util.put(r(EMPLOYEES), model, callback);
    }

    @Override
    public void addNewEmployee(EmployeeDTO model, AsyncCallBack<EmployeeDTO> callBack) {
        Util.put(r(EMPLOYEES), model, callBack);
    }

    @Override
    public void removeEmployee(Integer id, AsyncCallBack callBack) {
        Util.delete(r(EMPLOYEES) + "/" + id, callBack);
    }

}
