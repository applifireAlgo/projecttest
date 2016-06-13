Ext.define('Project1.project1.web.com.view.newbc.newdomain.ProductMain', {
     "xtype": "productMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProductMainController",
     "restURL": "/Product",
     "defaults": {
          "split": true
     },
     "requires": ["Project1.project1.shared.com.model.newbc.newdomain.ProductModel", "Project1.project1.web.com.controller.newbc.newdomain.ProductMainController", "Project1.view.fw.component.DateTimeField", "Project1.view.fw.component.DateTimePicker", "Project1.view.fw.component.FileUploadComponent", "Project1.project1.shared.com.viewmodel.newbc.newdomain.ProductViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Product",
               "name": "ProductTreeContainer",
               "itemId": "ProductTreeContainer",
               "restURL": "/Product",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "ProductTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
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
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Product",
                    "title": "Product",
                    "name": "Product",
                    "itemId": "ProductForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "productId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "productId<font color='red'> *<\/font>",
                         "fieldId": "AD63A936-D9FF-47C6-AF08-475E49155203",
                         "hidden": true,
                         "value": "",
                         "bindable": "productId"
                    }, {
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
                         "columnWidth": 0.5
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
                         "columnWidth": 0.5
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
                         "columnWidth": 0.5
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
                         "columnWidth": 0.5,
                         "title": "image<font color='red'> *<\/font>"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "03B76693-09BB-41AD-91AA-5BD328E4336F",
                         "bindable": "versionId",
                         "hidden": true
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
                         "ui": "footer",
                         "isToolBar": true,
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 333,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 333,
                              "customId": 340
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 333,
                              "customId": 341,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": 5,
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 333,
                              "customId": 342,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }]
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Product",
                    "title": "Details Grid",
                    "name": "ProductGrid",
                    "itemId": "ProductGrid",
                    "restURL": "/Product",
                    "store": [],
                    "columns": [{
                         "header": "productId",
                         "dataIndex": "productId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "pName",
                         "dataIndex": "pName",
                         "flex": 1
                    }, {
                         "header": "pDate",
                         "dataIndex": "pDate",
                         "flex": 1
                    }, {
                         "header": "pdatetime",
                         "dataIndex": "pdatetime",
                         "flex": 1
                    }, {
                         "header": "image",
                         "dataIndex": "image",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Product",
               "title": "Product",
               "name": "Product",
               "itemId": "ProductForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "productId",
                    "itemId": "productId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "productId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "productId<font color='red'> *<\/font>",
                    "fieldId": "AD63A936-D9FF-47C6-AF08-475E49155203",
                    "hidden": true,
                    "value": "",
                    "bindable": "productId"
               }, {
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
                    "columnWidth": 0.5
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
                    "columnWidth": 0.5
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
                    "columnWidth": 0.5
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
                    "columnWidth": 0.5,
                    "title": "image<font color='red'> *<\/font>"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "03B76693-09BB-41AD-91AA-5BD328E4336F",
                    "bindable": "versionId",
                    "hidden": true
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
                    "ui": "footer",
                    "isToolBar": true,
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 333,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 333,
                         "customId": 340
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 333,
                         "customId": 341,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": 5,
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 333,
                         "customId": 342,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }]
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});