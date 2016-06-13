Ext.define('Project1.project1.smartdevice.com.view.newbc.newdomain.ProductMain', {
     "xtype": "productMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProductMainController",
     "restURL": "/Product",
     "requires": ["Project1.project1.shared.com.model.newbc.newdomain.ProductModel", "Project1.project1.smartdevice.com.controller.newbc.newdomain.ProductMainController", "Project1.project1.shared.com.viewmodel.newbc.newdomain.ProductViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "margin": 5,
     "tabBar": {
          "hidden": true
     },
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "treepanel",
               "customWidgetType": "vdTree",
               "title": "List",
               "useArrows": true,
               "rowLines": true,
               "columnLines": true,
               "rootVisible": false,
               "itemId": "ProductTree",
               "listeners": {
                    "select": "treeClick"
               },
               "tbar": [{
                    "xtype": "triggerfield",
                    "customWidgetType": "vdTriggerField",
                    "width": "90%",
                    "height": "35",
                    "emptyText": "Search",
                    "triggerCls": "",
                    "listeners": {
                         "change": "onTriggerfieldChange",
                         "buffer": 250
                    }
               }, "->", {
                    "xtype": "tool",
                    "type": "refresh",
                    "tooltip": "Refresh Tree Data",
                    "handler": "onTreeRefreshClick"
               }],
               "region": "south",
               "height": "100%",
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": true
          }, {
               "region": "center",
               "layout": "border",
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "ProductViewModel",
                    "xtype": "form",
                    "displayName": "Product",
                    "title": "Product",
                    "name": "Product",
                    "itemId": "Product",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "pName",
                         "itemId": "pName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "pName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "pName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BA65F580-894B-49CE-8DA4-2FC3EEFCB97F",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "pName",
                         "columnWidth": 1
                    }, {
                         "name": "pDate",
                         "itemId": "pDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "pDate",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "pDate<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "079EEBF9-8675-452C-9A43-F04DE535A2E7",
                         "bindable": "pDate",
                         "columnWidth": 1
                    }, {
                         "name": "pdatetime",
                         "itemId": "pdatetime",
                         "xtype": "customdatetimefield",
                         "customWidgetType": "customdatetimefield",
                         "displayName": "pdatetime",
                         "margin": "5 5 5 5",
                         "submitFormat": "d-m-Y H:i:s",
                         "format": "d-m-Y H:i:s",
                         "fieldLabel": "pdatetime<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A4AFF150-6E71-4511-8847-C29588946D7C",
                         "bindable": "pdatetime",
                         "columnWidth": 1
                    }, {
                         "name": "image",
                         "itemId": "image",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "image",
                         "margin": "5 5 5 5",
                         "fieldLabel": "image<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "78C6989C-993D-409D-B9A9-1185DAE5FA4F",
                         "bindable": "image",
                         "columnWidth": 1
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 422,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 422,
                              "customId": 913
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 422,
                              "customId": 914,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 422,
                              "customId": 915,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5",
                              "flex": 1,
                              "height": 30
                         }
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }]
          }]
     }]
});