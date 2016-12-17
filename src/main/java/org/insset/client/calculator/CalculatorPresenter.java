package org.insset.client.calculator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author talend
 */
public class CalculatorPresenter extends Composite {
      interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorPresenter> {
      }

      private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);

      public CalculatorPresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
      }
    
}
