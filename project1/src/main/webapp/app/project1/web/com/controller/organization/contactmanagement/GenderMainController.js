Ext.define('Project1.project1.web.com.controller.organization.contactmanagement.GenderMainController', {
     extend: 'Project1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.GenderMainController',
     /*********************Main Controller Functions*********************************/
     init: function() {
          var but = this.view.down('#resetFormButton');
          but.up('form').reset();
          if (this.view.disableDB != null && this.view.disableDB) {
               this.view.down('#saveFormButton').setText('Update');
               this.hideDataBrowser();
          } else {
               this.view.down('#saveFormButton').setText('Save');
               this.renderTreeGridData();
          }
     },
     fetchDataAjaxCall: function() {
          var url = this.getView().restURL;
          var me = this;
          var data = null;
          Ext.Ajax.request({
               url: 'secure' + url + '/findAll',
               method: 'GET',
               maskEnable: true,
               async: false,
               jsonData: {},
               success: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    data = responseData;
                    me.addCommunicationLog(response, true);
               },
               failure: function(response, scope) {
                    me.addCommunicationLog(response, false);
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         me.responseHandler(responseText);
                    }
               }
          }, this);
          return data;
     },
     onTreeRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          var tree = this.view.down('#GenderTree');
          var rootNode = tree.getRootNode();
          rootNode.removeAll();
          for (var counter = 0; counter < data.length; counter++) {
               var childNode = {
                    text: data[counter].primaryDisplay,
                    bConfig: data[counter],
                    leaf: true,
                    icon: 'images/table_icon.png'
               };
               rootNode.appendChild(childNode);
          }
          tree.getStore().sort('text', 'ASC');
     },
     onGridRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          this.setGridData(data);
     },
     refreshMainForm: function(but, data, method) {
          var formPanel = this.view.down('#GenderForm');
          this.updateFormUI(formPanel, 'Save', true); /** Adding data to tree and grid */
          if (data != null) {
               var grid = this.view.down('#GenderGrid');
               var tree = this.view.down('#GenderTree');
               if (method == 'PUT') {
                    if (!(data instanceof Object)) {
                         var data = {
                              'findKey': data
                         };
                    }
                    data = this.findRecordById(this.view.restURL, data);
                    grid.getSelectionModel().selected.items[0].data = data;
                    grid.reconfigure();
                    var node = this.findChild(tree.getRootNode(), 'primaryKey', data.primaryKey);
                    if (node) {
                         node.set('text', data.primaryDisplay);
                         node.bConfig = data;
                         tree.reconfigure();
                    }
               } else {
                    grid.store.add(data);
                    var rootNode = tree.getRootNode();
                    var childNode = {
                         text: data.primaryDisplay,
                         bConfig: data,
                         leaf: true,
                         icon: 'images/table_icon.png'
                    };
                    rootNode.appendChild(childNode);
               }
          } else {
               if (method == 'DELETE') {
                    this.onGridRefreshClick();
                    this.onTreeRefreshClick();
               }
          }
          if (but != null) {
               this.resetForm(but);
          } else {
               var but = this.view.down('#resetFormButton');
               this.resetForm(but);
          }
     },
     hideDataBrowser: function() {
          var form = this.view.down('#GenderForm');
          var grid = this.view.down('#GenderGrid');
          var tree = this.view.down('#GenderTreeContainer');
          grid.setHidden(true);
          this.view.down('#addNewForm').destroy();
          tree.setHidden(true);
          if (this.view.primaryKey != null) {
               this.findById(this.view.primaryKey);
          }
     },
     renderTreeGridData: function(responseData) {
          if (responseData == null) {
               responseData = this.fetchDataAjaxCall();
          }
          if (responseData.response.success) {
               var data = responseData.response.data;
               var tree = this.view.down('#GenderTree');
               var rootNode = tree.getRootNode();
               rootNode.removeAll();
               for (var counter = 0; counter < data.length; counter++) {
                    var childNode = {
                         text: data[counter].primaryDisplay,
                         bConfig: data[counter],
                         leaf: true,
                         icon: 'images/table_icon.png'
                    };
                    rootNode.appendChild(childNode);
               }
               tree.getStore().sort('text', 'ASC');
               this.setGridData(data);
          } else if (!sessionTimeOutFlag) {
               this.responseHandler(responseData);
          }
     },
     /********************************Tree Controller Functions**********************************/
     onFilterClick: function(but, evt) {
          var me = this;
          var currentObject = this.getView();
          var form = but.up('form');
          if (!form.isValid()) {
               return;
          }
          var searchData = this.getData(form);
          Ext.Ajax.request({
               url: 'secure' + currentObject.restURL + '/search',
               method: 'POST',
               maskEnable: true,
               maskEle: currentObject,
               maskMsg: 'Filtering data ...',
               view: currentObject,
               jsonData: Ext.JSON.encode(searchData),
               success: function(response, opts) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         me.renderTreeGridData(responseText);
                    } else if (!sessionTimeOutFlag) {
                         me.responseHandler(responseText);
                    }
               },
               failure: function(response, eopts) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         me.responseHandler(responseText);
                    }
               }
          });
     },
     treeClick: function(me, record, item, index, e, eOpts) {
          if (record.data.leaf) {
               var primaryKey = record.data.bConfig.primaryKey;
               var gridPanel = this.view.up().down('#GenderGrid');
               var foundRecord = gridPanel.store.findRecord('primaryKey', primaryKey);
               if (gridPanel && foundRecord) {
                    gridPanel.setSelection(foundRecord);
               }
               var formPanel = this.getView().up().down('#GenderForm');
               jsonData = {
                    'findKey': primaryKey
               }
               var data = this.findRecordById(this.view.restURL, jsonData);
               this.modifyComponents(data, formPanel);
               this.updateFormUI(formPanel, 'Update', true);
          }
     },
     /********************************Grid Controller Functions***********************************/
     onGridItemClick: function(me, record, item, index, e, eOpts) {
          var primaryKey = record.data.primaryKey; /** Finding record by id */
          jsonData = {
               'findKey': primaryKey
          };
          var data = this.findRecordById(this.view.restURL, jsonData);
          var treePanel = this.view.up().up().down('#GenderTree');
          var foundNode = this.findChild(treePanel.getRootNode(), 'primaryKey', primaryKey);
          if (treePanel && foundNode) {
               treePanel.setSelection(foundNode);
          } else {
               var formPanel = this.getView().up().down('#GenderForm');
               formPanel.down('#saveFormButton').setText('Update');
               this.modifyComponents(data, formPanel);
               this.updateFormUI(formPanel, 'Update', true);
          }
     },
     updateFormUI: function(form, status, butText) {
          for (var counter = 0; counter < form.items.items.length; counter++) {
               var item = form.items.items[counter];
               if (item.xtype == 'form' || item.xtype == 'panel') {
                    this.updateFormUI(item, status);
               }
               if (item.isCompositeKey) {
                    if (status == 'Save') {
                         item.setDisabled(false);
                    } else if (status == 'Update') {
                         item.setDisabled(true);
                    }
               }
          }
          if (butText) {
               if (status == 'Save') {
                    form.down('#saveFormButton').setText('Save');
               } else if (status == 'Update') {
                    form.down('#saveFormButton').setText('Update');
               }
          }
     },
     renderFormValue: function(val, me) {
          store = this.view.up().down('#GenderForm').down('#' + me.column.dataIndex + '').store;
          if (store.data.length == 0) {
               return '';
          }
          var displayValue = store.findRecord('primaryKey', val).data.primaryDisplay;
          return displayValue != null ? displayValue : '';
     },
     setGridData: function(data) {
          var gridStore = this.view.down('#GenderGrid').store;
          gridStore.removeAll();
          gridStore.setData(data);
          gridStore.sort('primaryDisplay', 'ASC');
     },
     findChild: function(node, key, value) {
          var dNode = node;
          if (node.data.bConfig != null && node.data.bConfig[key] == value) {
               return node;
          } else if (node.childNodes) {
               for (var counter = 0; counter < node.childNodes.length; counter++) {
                    dNode = this.findChild(node.childNodes[counter], key, value);
                    if (dNode) {
                         return dNode;
                    }
               }
          } else {
               return null;
          }
     },
     onDeleteActionColumnClickMainGrid: function(grid, rowIndex) {
          var recordId = grid.store.data.items[rowIndex].data.primaryKey;
          me = this;
          Ext.MessageBox.confirm({
               title: 'Confirm',
               msg: 'Delete Record',
               buttons: Ext.MessageBox.YESNO,
               fn: function(clickedButtonId) {
                    if (clickedButtonId == 'yes') {
                         me.deleteRecord(recordId);
                    }
               },
               animateTarget: this,
               icon: Ext.MessageBox.QUESTION
          })
     },
     deleteRecord: function(recordId) {
          var me = this;
          var restURL = this.view.restURL;
          var url = 'secure' + restURL + '/' + recordId;
          var jsonData = {};
          Ext.Ajax.request({
               url: url,
               method: 'DELETE',
               jsonData: jsonData,
               success: function(response, opts) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                         me.refreshMainForm(null, null, opts.method);
                    } else if (!sessionTimeOutFlag) {
                         me.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    me.addCommunicationLog(response, false);
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         me.responseHandler(responseText);
                    }
               }
          });
     },
     /********************************Form Controller Functions***********************************/
     findById: function(primaryKey) {
          var me = this;
          var restURL = this.view.restURL;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/findById',
               method: 'POST',
               jsonData: {
                    'findKey': primaryKey
               },
               success: function(response, opts) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         me.loadData(responseText);
                    } else if (!sessionTimeOutFlag) {
                         me.responseHandler(responseText);
                    }
               },
               failure: function(response, opts) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         me.responseHandler(responseText);
                    }
               }
          });
     },
     loadData: function(responseText) {
          var formPanel = this.getView().up().down('#GenderForm');
          this.modifyComponents(responseText.response.data, formPanel);
     },
     renderFormValue: function(value, metaData, record, row, col, store, gridView) {
          try {
               var comboStore = this.getView().down('#' + metaData.column.dataIndex).getStore();
               var pos = comboStore.findExact('primaryKey', value);
               return comboStore.getAt(pos).data.primaryDisplay;
          } catch (e) {
               return value;
          }
     },
     resetForm: function(but) {
          var form = but.up('form');
          form.down('#saveFormButton').setText('Save');
          form.reset();
          var grid = this.view.down('#GenderGrid');
          var tree = this.view.down('#GenderTree');
          tree.setSelection();
          grid.setSelection();
     },
     saveForm: function(but, evt) {
          var form = but.up('form');
          if (!form.isValid()) {
               return;
          }
          var jsonData = this.getData(form);
          var method;
          if (but.text == 'Save') {
               method = 'POST'
          } else if (but.text == 'Update') {
               method = 'PUT';
               jsonData.systemInfo = {
                    'activeStatus': 1
               }
          }
          restURL = this.view.restURL;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/',
               but: but,
               method: method,
               maskEnable: true,
               maskEle: form,
               maskMsg: 'Data saving ...',
               jsonData: jsonData,
               success: function(response, opts) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                         if (me.view.disableDB != null && me.view.disableDB) {
                              if (me.view.drillDownWindow) {
                                   me.view.drillDownWindow.close();
                              } else {
                                   me.view.close();
                              }
                         } else {
                              me.refreshMainForm(but, responseText.response.data, opts.method);
                         }
                    } else if (!sessionTimeOutFlag) {
                         me.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    me.addCommunicationLog(response, false);
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         me.responseHandler(responseText);
                    }
               }
          });
     },
});