Ext.define('Project1.project1.smartdevice.com.view.newbc.newdomain.AdditionMain', {
     "xtype": "additionMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AdditionMainController",
     "restURL": "/Addition",
     "requires": ["Project1.project1.shared.com.model.newbc.newdomain.AdditionModel", "Project1.project1.smartdevice.com.controller.newbc.newdomain.AdditionMainController", "Project1.project1.shared.com.viewmodel.newbc.newdomain.AdditionViewModel"],
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
               "itemId": "AdditionTree",
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
                    "viewModel": "AdditionViewModel",
                    "xtype": "form",
                    "displayName": "addition",
                    "title": "addition",
                    "name": "Addition",
                    "itemId": "Addition",
                    "bodyPadding": 10,
                    "items": [{
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
                         "columnWidth": 1
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
                         "columnWidth": 1
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
                         "customId": 262,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 262,
                              "customId": 180
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 262,
                              "customId": 181,
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
                              "parentId": 262,
                              "customId": 182,
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