package org.insset.client.calculator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.SubmitButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author talend
 */
public class CalculatorDecimalPresenter extends Composite {

    //CHECKSTYLE:OFF
    /**
     * Menu : accueil
     */
    @UiField
    public SubmitButton boutonEnregistrer;

    private void initPage() {
        boutonEnregistrer.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                History.newItem("addition", true);
            }
        });
    }

    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorDecimalPresenter> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);

    public CalculatorDecimalPresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initPage();
    }

}
