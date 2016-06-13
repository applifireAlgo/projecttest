Ext.define('Project1.project1.web.com.view.newbc.newdomain.CompUII', {
     "xtype": "compUIIView",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "lp",
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "CB002DC9-E200-4D48-AC2D-58514986C1C7",
               "uiClass": "Project1.project1.web.com.view.newbc.newdomain.TestVd",
               "uiType": 2,
               "url": "secure/Candidate/findAll",
               "serviceId": "83186C2F-2E09-4842-A0C3-A43C90C6740A",
               "serviceType": 1,
               "serviceOperationId": "40D890B3-AEEF-428B-A840-29FC46A9A79A",
               "operationName": "findAll",
               "operationDisplayName": "findAll",
               "requestMethodType": "GET"
          },
          "title": "ListPanel",
          "padding": 0,
          "margin": 5,
          "itemId": "panel_ext_22599",
          "dockedItems": []
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_22589",
     "dockedItems": [],
     "requires": ["Project1.project1.web.com.view.newbc.newdomain.TestVd", "Project1.project1.web.com.controller.newbc.newdomain.CompUIIController", "Project1.project1.shared.com.viewmodel.newbc.newdomain.CompUIIViewModel", "Project1.project1.shared.com.model.newbc.newdomain.CompUIIModel", "Project1.view.fw.component.ListViewBaseView", "Project1.view.fw.component.DateFields", "Project1.view.fw.component.CustomRadioGroup", "Project1.view.fw.component.CustomRadioGroup", "Project1.view.fw.component.CustomRadioGroup", "Project1.view.fw.component.CustomRadioGroup", "Project1.view.fw.component.CustomRadioGroup"],
     "extend": "Ext.form.Panel",
     "viewModel": "CompUIIViewModel",
     "controller": "CompUIIController"
});