Ext.define('Project1.project1.web.com.view.newbc.newdomain.AdditionMain', {
     "xtype": "additionMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AdditionMainController",
     "restURL": "/Addition",
     "defaults": {
          "split": true
     },
     "requires": ["Project1.project1.shared.com.model.newbc.newdomain.AdditionModel", "Project1.project1.web.com.controller.newbc.newdomain.AdditionMainController", "Project1.project1.shared.com.viewmodel.newbc.newdomain.AdditionViewModel"],
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
               "displayName": "addition",
               "name": "AdditionTreeContainer",
               "itemId": "AdditionTreeContainer",
               "restURL": "/Addition",
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
                    "itemId": "AdditionTree",
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
                    "displayName": "addition",
                    "title": "addition",
                    "name": "Addition",
                    "itemId": "AdditionForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "additionId",
                         "itemId": "additionId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "additionId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "additionId<font color='red'> *<\/font>",
                         "fieldId": "9CF845E7-2CAA-4038-BD8B-73833367929E",
                         "hidden": true,
                         "value": "",
                         "bindable": "additionId"
                    }, {
                         "name": "num1",
                         "itemId": "num1",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "num1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "num1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "34CAA444-E146-4610-BB8A-C938E9691CD9",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "num1",
                         "columnWidth": 0.5
                    }, {
                         "name": "num2",
                         "itemId": "num2",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "num2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "num2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C396D9FC-3E7F-4600-87A5-E14345FEFE1E",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "num2",
                         "columnWidth": 0.5
                    }, {
                         "name": "total",
                         "itemId": "total",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "total",
                         "fieldId": "55ACA8A4-3B97-4F0A-8DBC-89C6C7257196",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "total",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "A181A25E-E6B6-408F-86B4-DF1004A5EFC7",
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
                         "customId": 314,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 314,
                              "customId": 563
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 314,
                              "customId": 564,
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
                              "parentId": 314,
                              "customId": 565,
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
                    "displayName": "addition",
                    "title": "Details Grid",
                    "name": "AdditionGrid",
                    "itemId": "AdditionGrid",
                    "restURL": "/Addition",
                    "store": [],
                    "columns": [{
                         "header": "additionId",
                         "dataIndex": "additionId",
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
                         "header": "num1",
                         "dataIndex": "num1",
                         "flex": 1
                    }, {
                         "header": "num2",
                         "dataIndex": "num2",
                         "flex": 1
                    }, {
                         "header": "total",
                         "dataIndex": "total",
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
               "displayName": "addition",
               "title": "addition",
               "name": "Addition",
               "itemId": "AdditionForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "additionId",
                    "itemId": "additionId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "additionId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "additionId<font color='red'> *<\/font>",
                    "fieldId": "9CF845E7-2CAA-4038-BD8B-73833367929E",
                    "hidden": true,
                    "value": "",
                    "bindable": "additionId"
               }, {
                    "name": "num1",
                    "itemId": "num1",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "num1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "num1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "34CAA444-E146-4610-BB8A-C938E9691CD9",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "num1",
                    "columnWidth": 0.5
               }, {
                    "name": "num2",
                    "itemId": "num2",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "num2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "num2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C396D9FC-3E7F-4600-87A5-E14345FEFE1E",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "num2",
                    "columnWidth": 0.5
               }, {
                    "name": "total",
                    "itemId": "total",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "total",
                    "margin": "5 5 5 5",
                    "fieldLabel": "total",
                    "fieldId": "55ACA8A4-3B97-4F0A-8DBC-89C6C7257196",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "total",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "A181A25E-E6B6-408F-86B4-DF1004A5EFC7",
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
                    "customId": 314,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 314,
                         "customId": 563
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 314,
                         "customId": 564,
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
                         "parentId": 314,
                         "customId": 565,
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