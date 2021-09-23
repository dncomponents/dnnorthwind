package com.dncomponents.northwind.employees;

import com.dncomponents.UiField;
import com.dncomponents.client.components.ColumnConfig;
import com.dncomponents.client.components.Table;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.components.core.validation.validators.EmptyValidator;
import com.dncomponents.client.components.modal.Dialog;
import com.dncomponents.client.components.table.columnclasses.TableCellDate;
import com.dncomponents.client.components.table.columnclasses.editcolumn.ColumnEdit;
import com.dncomponents.client.views.appview.AbstractView;
import com.dncomponents.northwind.dto.EmployeeDTO;
import elemental2.dom.HTMLElement;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.dncomponents.client.components.core.DnI18n.t;


public class EmployeesViewImpl extends AbstractView<EmployeesActivity> implements EmployeesView {
    private static EmployeesViewImpl instance;

    @UiField
    HTMLElement root;
    HtmlBinder<?> binder = HtmlBinder.get(EmployeesViewImpl.class, this);
    @UiField
    Table<EmployeeDTO> employeesTable;

    public EmployeesViewImpl() {
        binder.bind();
        //create
        employeesTable.addRowAddedHandler(event -> {
            presenter.addNewEmployee(event.getRow().getModel(), new AsyncCallBack<EmployeeDTO>() {
                @Override
                public void onSuccess(EmployeeDTO result) {
                    event.updateModel(result);
                    Dialog.show("Success", "Record added!");
                }

                @Override
                public void onFailure(Throwable caught) {
                    Dialog.show("Error", caught.getMessage());
                    event.removeAddedRow();
                }
            });
        });
        //update
        employeesTable.addRowValueChangedHandler(event ->
                presenter.updateEmployee(event.getRow().getModel(), new AsyncCallBack<EmployeeDTO>() {
                    @Override
                    public void onSuccess(EmployeeDTO result) {
                        Dialog.show("Success", "Record updated!");
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        Dialog.show("Error", caught.getMessage());
                        event.revertChanges();
                    }
                }));

        //remove
        employeesTable.addRowRemovedHandler(event -> {
            final Integer id = event.getRow().getModel().getEmployee_id();
            presenter.removeEmployee(id, new AsyncCallBack() {
                @Override
                public void onSuccess(Object result) {
                    Dialog.show("Success", "Record removed!");
                }

                @Override
                public void onFailure(Throwable caught) {
                    Dialog.show("Error", caught.getMessage());
                    event.revertDeletedRow();
                }
            });
        });
        init();
    }

    public static EmployeesViewImpl getInstance() {
        if (instance == null)
            instance = new EmployeesViewImpl();
        return instance;
    }

    private void init() {
        ColumnConfig<EmployeeDTO, String> firstNameColumn = new ColumnConfig.Builder<EmployeeDTO, String>()
                .setFieldGetter(employeeDTO -> employeeDTO.getFirst_name())
                .setFieldSetter((employeeDTO, s) -> employeeDTO.setFirst_name(s))
                .setClazz(String.class)
                .setEditable(true)
                .setColumnWidth("180px")
                .setValidator(new EmptyValidator<>())
                .setName(t("first_name"))
                .build();

        ColumnConfig<EmployeeDTO, String> lastNameColumn = new ColumnConfig.Builder<EmployeeDTO, String>()
                .setFieldGetter(employeeDTO -> employeeDTO.getLast_name())
                .setFieldSetter((employeeDTO, s) -> employeeDTO.setLast_name(s))
                .setColumnWidth("180px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("last_name"))
                .build();

        ColumnConfig<EmployeeDTO, String> titleColumn = new ColumnConfig.Builder<EmployeeDTO, String>()
                .setFieldGetter(employeeDTO -> employeeDTO.getTitle())
                .setFieldSetter((employeeDTO, s) -> employeeDTO.setTitle(s))
                .setColumnWidth("180px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("title"))
                .build();

        ColumnConfig<EmployeeDTO, Date> birthDayColumn = new ColumnConfig.Builder<EmployeeDTO, Date>()
                .setFieldGetter(employeeDTO -> employeeDTO.getBirth_date())
                .setFieldSetter((employeeDTO, s) -> employeeDTO.setBirth_date(s))
                .setColumnWidth("100px")
                .setEditable(true)
                .setCellFactory(c -> new TableCellDate<>())
                .setName(t("birth_day"))
                .build();

        ColumnConfig<EmployeeDTO, Date> hireDayColumn = new ColumnConfig.Builder<EmployeeDTO, Date>()
                .setFieldGetter(employeeDTO -> employeeDTO.getHire_date())
                .setFieldSetter((employeeDTO, s) -> employeeDTO.setHire_date(s))
                .setColumnWidth("100px")
                .setCellFactory(c -> new TableCellDate<>())
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("hire_day"))
                .build();

        ColumnConfig<EmployeeDTO, String> cityColumn = new ColumnConfig.Builder<EmployeeDTO, String>()
                .setFieldGetter(employeeDTO -> employeeDTO.getCity())
                .setFieldSetter((employeeDTO, s) -> employeeDTO.setCity(s))
                .setColumnWidth("100px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("city"))
                .build();

        ColumnConfig<EmployeeDTO, String> countryColumn = new ColumnConfig.Builder<EmployeeDTO, String>()
                .setFieldGetter(employeeDTO -> employeeDTO.getCountry())
                .setFieldSetter((employeeDTO, s) -> employeeDTO.setCountry(s))
                .setColumnWidth("100px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("country"))
                .build();

        ColumnEdit<EmployeeDTO> columnEdit = new ColumnEdit<>(EmployeeDTO::new, false);
        columnEdit.setColumnWidth("120px");
        employeesTable.addColumn(firstNameColumn, lastNameColumn,
                titleColumn, birthDayColumn,
                hireDayColumn, cityColumn, countryColumn, columnEdit);
        employeesTable.setMultiSorting(true);
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    @Override
    public void showError(String message) {
        Dialog.show("Error", message);
    }

    @Override
    public void setEmployees(EmployeeDTO[] customers) {
        final List<EmployeeDTO> employeeDTOS = Arrays.asList(customers);
        employeesTable.setRowsData(employeeDTOS);
        employeesTable.drawData();
    }

}
