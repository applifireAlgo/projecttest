Ext.define('Project1.project1.web.com.view.newbc.newdomain.TestFGMain', {
     "xtype": "testFGMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestFGMainController",
     "restURL": "/TestFG",
     "defaults": {
          "split": true
     },
     "requires": ["Project1.project1.shared.com.model.newbc.newdomain.TestFGModel", "Project1.project1.web.com.controller.newbc.newdomain.TestFGMainController", "Project1.view.fw.component.DateTimeField", "Project1.view.fw.component.DateTimePicker", "Project1.view.fw.component.Grids", "Project1.project1.shared.com.viewmodel.newbc.newdomain.TestFGViewModel"],
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
               "displayName": "TestFG",
               "name": "TestFGTreeContainer",
               "itemId": "TestFGTreeContainer",
               "restURL": "/TestFG",
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
                    "itemId": "TestFGTree",
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
                    "displayName": "TestFG",
                    "title": "TestFG",
                    "name": "TestFG",
                    "itemId": "TestFGForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "testFGid",
                         "itemId": "testFGid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testFGid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testFGid<font color='red'> *<\/font>",
                         "fieldId": "3AD87B42-05C4-4511-B66D-7B56655EA424",
                         "hidden": true,
                         "value": "",
                         "bindable": "testFGid"
                    }, {
                         "name": "fgName",
                         "itemId": "fgName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "fgName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "fgName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5C416EB5-B0AF-4F18-B0E5-DA47C769E842",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "fgName",
                         "columnWidth": 0.5
                    }, {
                         "name": "fgDate",
                         "itemId": "fgDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "fgDate",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "fgDate<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "27EB97D3-B5E7-43DF-98D1-5479A371DA37",
                         "bindable": "fgDate",
                         "columnWidth": 0.5
                    }, {
                         "name": "fgDatetime",
                         "itemId": "fgDatetime",
                         "xtype": "customdatetimefield",
                         "customWidgetType": "customdatetimefield",
                         "displayName": "fgDatetime",
                         "margin": "5 5 5 5",
                         "submitFormat": "d-m-Y H:i:s",
                         "format": "d-m-Y H:i:s",
                         "fieldLabel": "fgDatetime<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "840DB2EC-A2E0-4584-BEE1-C41B180EEDCA",
                         "bindable": "fgDatetime",
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
                         "fieldId": "6DAC2FDF-6EB2-4391-91B4-B660B24C26CD",
                         "bindable": "versionId",
                         "hidden": true
                    }, {
                         "customWidgetType": "vdColumnLayout",
                         "xtype": "form",
                         "displayName": "FGPT",
                         "title": "FGPT",
                         "name": "FGPT",
                         "itemId": "FGPTForm",
                         "bodyPadding": 10,
                         "items": [{
                              "name": "ptPk",
                              "itemId": "ptPk",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "ptPk",
                              "margin": "5 5 5 5",
                              "fieldLabel": "ptPk<font color='red'> *<\/font>",
                              "fieldId": "4AE3872E-DB54-4089-8F0C-CA66C2556175",
                              "hidden": true,
                              "value": "",
                              "bindable": "fGPT.ptPk"
                         }, {
                              "name": "ptName",
                              "itemId": "ptName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "ptName",
                              "margin": "5 5 5 5",
                              "fieldLabel": "ptName<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "EE214011-B331-4EB3-AF4F-08EDD01FBF8C",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "fGPT.ptName",
                              "columnWidth": 0.5
                         }, {
                              "name": "ptDate",
                              "itemId": "ptDate",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "ptDate",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "ptDate<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "89725355-C585-4A59-847B-2AC51CE44389",
                              "bindable": "fGPT.ptDate",
                              "columnWidth": 0.5
                         }, {
                              "name": "ptDatetime",
                              "itemId": "ptDatetime",
                              "xtype": "customdatetimefield",
                              "customWidgetType": "customdatetimefield",
                              "displayName": "ptDatetime",
                              "margin": "5 5 5 5",
                              "submitFormat": "d-m-Y H:i:s",
                              "format": "d-m-Y H:i:s",
                              "fieldLabel": "ptDatetime<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "AF8EB85B-B79A-40A2-A4C1-EA594D6A8C7B",
                              "bindable": "fGPT.ptDatetime",
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
                              "fieldId": "62C6EE5C-3A90-4576-B703-C65D9BF30EEA",
                              "bindable": "fGPT.versionId",
                              "hidden": true
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 99,
                              "text": "Add FGPT",
                              "handler": "addFGPT"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "FGPT",
                              "columnWidth": 1,
                              "itemId": "FGPTGrid",
                              "fieldLabel": "List",
                              "bindLevel": "fGPT",
                              "bindable": "fGPT",
                              "listeners": {
                                   "select": "onFGPTGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "ptPk",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "ptPk",
                                   "dataIndex": "ptPk",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "ptName",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "ptName",
                                   "dataIndex": "ptName",
                                   "flex": 1
                              }, {
                                   "header": "ptDate",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "ptDate",
                                   "dataIndex": "ptDate",
                                   "flex": 1
                              }, {
                                   "header": "ptDatetime",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "ptDatetime",
                                   "dataIndex": "ptDatetime",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "createdBy",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "createdDate",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "updatedBy",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "updatedDate",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "versionId",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "activeStatus",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
                                   "text": "txnAccessCode",
                                   "dataIndex": "txnAccessCode",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "xtype": "actioncolumn",
                                   "customWidgetType": "vdActionColumn",
                                   "width": 30,
                                   "sortable": false,
                                   "menuDisable": true,
                                   "items": [{
                                        "icon": "images/delete.gif",
                                        "tooltip": "Delete Record",
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "columnWidth": 1,
                         "layout": "column"
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
                         "customId": 545,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 545,
                              "customId": 378
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 545,
                              "customId": 379,
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
                              "parentId": 545,
                              "customId": 380,
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
                    "displayName": "TestFG",
                    "title": "Details Grid",
                    "name": "TestFGGrid",
                    "itemId": "TestFGGrid",
                    "restURL": "/TestFG",
                    "store": [],
                    "columns": [{
                         "header": "testFGid",
                         "dataIndex": "testFGid",
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
                         "header": "fgName",
                         "dataIndex": "fgName",
                         "flex": 1
                    }, {
                         "header": "fgDate",
                         "dataIndex": "fgDate",
                         "flex": 1
                    }, {
                         "header": "fgDatetime",
                         "dataIndex": "fgDatetime",
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
               "displayName": "TestFG",
               "title": "TestFG",
               "name": "TestFG",
               "itemId": "TestFGForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "testFGid",
                    "itemId": "testFGid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testFGid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testFGid<font color='red'> *<\/font>",
                    "fieldId": "3AD87B42-05C4-4511-B66D-7B56655EA424",
                    "hidden": true,
                    "value": "",
                    "bindable": "testFGid"
               }, {
                    "name": "fgName",
                    "itemId": "fgName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "fgName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "fgName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5C416EB5-B0AF-4F18-B0E5-DA47C769E842",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "fgName",
                    "columnWidth": 0.5
               }, {
                    "name": "fgDate",
                    "itemId": "fgDate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "fgDate",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "fgDate<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "27EB97D3-B5E7-43DF-98D1-5479A371DA37",
                    "bindable": "fgDate",
                    "columnWidth": 0.5
               }, {
                    "name": "fgDatetime",
                    "itemId": "fgDatetime",
                    "xtype": "customdatetimefield",
                    "customWidgetType": "customdatetimefield",
                    "displayName": "fgDatetime",
                    "margin": "5 5 5 5",
                    "submitFormat": "d-m-Y H:i:s",
                    "format": "d-m-Y H:i:s",
                    "fieldLabel": "fgDatetime<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "840DB2EC-A2E0-4584-BEE1-C41B180EEDCA",
                    "bindable": "fgDatetime",
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
                    "fieldId": "6DAC2FDF-6EB2-4391-91B4-B660B24C26CD",
                    "bindable": "versionId",
                    "hidden": true
               }, {
                    "customWidgetType": "vdColumnLayout",
                    "xtype": "form",
                    "displayName": "FGPT",
                    "title": "FGPT",
                    "name": "FGPT",
                    "itemId": "FGPTForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "ptPk",
                         "itemId": "ptPk",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "ptPk",
                         "margin": "5 5 5 5",
                         "fieldLabel": "ptPk<font color='red'> *<\/font>",
                         "fieldId": "4AE3872E-DB54-4089-8F0C-CA66C2556175",
                         "hidden": true,
                         "value": "",
                         "bindable": "fGPT.ptPk"
                    }, {
                         "name": "ptName",
                         "itemId": "ptName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "ptName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "ptName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "EE214011-B331-4EB3-AF4F-08EDD01FBF8C",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "fGPT.ptName",
                         "columnWidth": 0.5
                    }, {
                         "name": "ptDate",
                         "itemId": "ptDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "ptDate",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "ptDate<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "89725355-C585-4A59-847B-2AC51CE44389",
                         "bindable": "fGPT.ptDate",
                         "columnWidth": 0.5
                    }, {
                         "name": "ptDatetime",
                         "itemId": "ptDatetime",
                         "xtype": "customdatetimefield",
                         "customWidgetType": "customdatetimefield",
                         "displayName": "ptDatetime",
                         "margin": "5 5 5 5",
                         "submitFormat": "d-m-Y H:i:s",
                         "format": "d-m-Y H:i:s",
                         "fieldLabel": "ptDatetime<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AF8EB85B-B79A-40A2-A4C1-EA594D6A8C7B",
                         "bindable": "fGPT.ptDatetime",
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
                         "fieldId": "62C6EE5C-3A90-4576-B703-C65D9BF30EEA",
                         "bindable": "fGPT.versionId",
                         "hidden": true
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 99,
                         "text": "Add FGPT",
                         "handler": "addFGPT"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "FGPT",
                         "columnWidth": 1,
                         "itemId": "FGPTGrid",
                         "fieldLabel": "List",
                         "bindLevel": "fGPT",
                         "bindable": "fGPT",
                         "listeners": {
                              "select": "onFGPTGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "ptPk",
                              "customWidgetType": "vdGridColumn",
                              "text": "ptPk",
                              "dataIndex": "ptPk",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "ptName",
                              "customWidgetType": "vdGridColumn",
                              "text": "ptName",
                              "dataIndex": "ptName",
                              "flex": 1
                         }, {
                              "header": "ptDate",
                              "customWidgetType": "vdGridColumn",
                              "text": "ptDate",
                              "dataIndex": "ptDate",
                              "flex": 1
                         }, {
                              "header": "ptDatetime",
                              "customWidgetType": "vdGridColumn",
                              "text": "ptDatetime",
                              "dataIndex": "ptDatetime",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "text": "createdBy",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "text": "createdDate",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "text": "updatedBy",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "text": "updatedDate",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "text": "versionId",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "text": "activeStatus",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
                              "text": "txnAccessCode",
                              "dataIndex": "txnAccessCode",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "xtype": "actioncolumn",
                              "customWidgetType": "vdActionColumn",
                              "width": 30,
                              "sortable": false,
                              "menuDisable": true,
                              "items": [{
                                   "icon": "images/delete.gif",
                                   "tooltip": "Delete Record",
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "columnWidth": 1,
                    "layout": "column"
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
                    "customId": 545,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 545,
                         "customId": 378
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 545,
                         "customId": 379,
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
                         "parentId": 545,
                         "customId": 380,
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