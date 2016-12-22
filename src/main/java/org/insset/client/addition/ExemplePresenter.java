/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.addition;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.Messages;
import org.insset.client.service.GreetingService;
import org.insset.client.service.GreetingServiceAsync;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author user
 */
public class ExemplePresenter extends Composite {

    @UiField
    public ResetButton boutonClear;
    @UiField
    public SubmitButton boutonEnregistrer;
    @UiField
    public TextBox nom;
    @UiField
    public Label errorLabel;
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    private final Messages messages = GWT.create(Messages.class);

    interface AddUiBinder extends UiBinder<HTMLPanel, ExemplePresenter> {
    }

    private static AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);

    public ExemplePresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    protected void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                nom.setText("");
                errorLabel.setText("");
            }
        });
        boutonEnregistrer.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                contacterService();
            }

        });
//        
//        final Button sendButton = new Button(messages.sendButton());
//        final TextBox nameField = new TextBox();
//        nameField.setText(messages.nameField());
//        final Label errorLabel = new Label();
//
//        // We can add style names to widgets
//        sendButton.addStyleName("sendButton");
//
//        // Add the nameField and sendButton to the RootPanel
//        // Use RootPanel.get() to get the entire body element
////        RootPanel.get().add(new Menu());
//        RootPanel.get("nameFieldContainer").add(nameField);
//        RootPanel.get("sendButtonContainer").add(sendButton);
//        RootPanel.get("errorLabelContainer").add(errorLabel);
//
//        // Focus the cursor on the name field when the app loads
//        nameField.setFocus(true);
//        nameField.selectAll();
//
//        // Create the popup dialog box
//        final DialogBox dialogBox = new DialogBox();
//        dialogBox.setText("Remote Procedure Call");
//        dialogBox.setAnimationEnabled(true);
//        final Button closeButton = new Button("Close");
//        // We can set the id of a widget by accessing its Element
//        closeButton.getElement().setId("closeButton");
//        final Label textToServerLabel = new Label();
//        final HTML serverResponseLabel = new HTML();
//        VerticalPanel dialogVPanel = new VerticalPanel();
//        dialogVPanel.addStyleName("dialogVPanel");
//        dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
//        dialogVPanel.add(textToServerLabel);
//        dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
//        dialogVPanel.add(serverResponseLabel);
//        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
//        dialogVPanel.add(closeButton);
//        dialogBox.setWidget(dialogVPanel);
//
//        // Add a handler to close the DialogBox
//        closeButton.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                dialogBox.hide();
//                sendButton.setEnabled(true);
//                sendButton.setFocus(true);
//            }
//        });
//
//        // Create a handler for the sendButton and nameField
//        class MyHandler implements ClickHandler, KeyUpHandler {
//
//            /**
//             * Fired when the user clicks on the sendButton.
//             */
//            public void onClick(ClickEvent event) {
//                sendNameToServer();
//            }
//
//            /**
//             * Fired when the user types in the nameField.
//             */
//            public void onKeyUp(KeyUpEvent event) {
//                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
//                    sendNameToServer();
//                }
//            }
//
//            /**
//             * Send the name from the nameField to the server and wait for a
//             * response.
//             */
//            private void sendNameToServer() {
//                // First, we validate the input.
//                errorLabel.setText("");
//                String textToServer = nameField.getText();
//                if (!FieldVerifier.isValidName(textToServer)) {
//                    errorLabel.setText("Please enter at least four characters");
//                    return;
//                }
//
//                // Then, we send the input to the server.
//                sendButton.setEnabled(false);
//                textToServerLabel.setText(textToServer);
//                serverResponseLabel.setText("");
//                greetingService.greetServer(textToServer, new AsyncCallback<String>() {
//                    public void onFailure(Throwable caught) {
//                        // Show the RPC error message to the user
//                        dialogBox.setText("Remote Procedure Call - Failure");
//                        serverResponseLabel.addStyleName("serverResponseLabelError");
//                        serverResponseLabel.setHTML(SERVER_ERROR);
//                        dialogBox.center();
//                        closeButton.setFocus(true);
//                    }
//                    
//                    public void onSuccess(String result) {
//                        dialogBox.setText("Remote Procedure Call");
//                        serverResponseLabel.removeStyleName("serverResponseLabelError");
//                        serverResponseLabel.setHTML(result);
//                        dialogBox.center();
//                        closeButton.setFocus(true);
//                    }
//                });
//            }
//        }
//
//        // Add a handler to send the name to the server
//        MyHandler handler = new MyHandler();
//        sendButton.addClickHandler(handler);
//        nameField.addKeyUpHandler(handler);
    }

    private void contacterService() {
        errorLabel.setText("");
        String textToServer = nom.getText();
        if (!FieldVerifier.isValidName(textToServer)) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Aucun texte entré!!");
            return;
        }
        greetingService.greetServer(textToServer, new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                // Show the RPC error message to the user
//                dialogBox.setText("Remote Procedure Call - Failure");
//                serverResponseLabel.addStyleName("serverResponseLabelError");
//                serverResponseLabel.setHTML(SERVER_ERROR);
//                dialogBox.center();
//                closeButton.setFocus(true);
            }

            public void onSuccess(String result) {
//                dialogBox.setText("Remote Procedure Call");
//                serverResponseLabel.removeStyleName("serverResponseLabelError");
//                serverResponseLabel.setHTML(result);
//                dialogBox.center();
//                closeButton.setFocus(true);
                Window.alert(result);
            }
        });
    }
}
