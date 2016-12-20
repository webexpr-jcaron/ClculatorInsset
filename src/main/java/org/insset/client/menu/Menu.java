/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.MenuItem;

/**
 *
 * @author user
 */
public class Menu extends Composite {

    //CHECKSTYLE:OFF
    /**
     * Menu : accueil
     */
    @UiField
    public MenuItem accueil;
    /**
     * Menu : accueil
     */
    @UiField
    public MenuItem addition;
    /**
     * Menu : accueil
     */
    @UiField
    public MenuItem soustraction;

    interface MenuUiBinder extends UiBinder<HTMLPanel, Menu> {
    }

    private static MenuUiBinder ourUiBinder = GWT.create(MenuUiBinder.class);

    public Menu() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initEditor();
    }

    private void initEditor() {
        accueil.setScheduledCommand(new Scheduler.ScheduledCommand() {

            @Override
            public void execute() {

                Window.alert("Acceuil");
            }
        });
        addition.setScheduledCommand(new Scheduler.ScheduledCommand() {

            @Override
            public void execute() {

                Window.alert("Add!!");
            }
        });
        soustraction.setScheduledCommand(new Scheduler.ScheduledCommand() {

            @Override
            public void execute() {

                Window.alert("-------");
            }
        });
    }
}
