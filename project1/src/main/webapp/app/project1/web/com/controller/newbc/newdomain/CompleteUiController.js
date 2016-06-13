Ext.define('Project1.project1.web.com.controller.newbc.newdomain.CompleteUiController', {
     extend: 'Project1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.CompleteUiController',
     onSavrClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_18970'), this.view.down('#combo_ext_18979'), this.view.down('#radiogroup_ext_19077'), this.view.down('#textfield_ext_19003'), this.view.down('#datefield_ext_19018'), this.view.down('#radiogroup_ext_19122'), this.view.down('#radiogroup_ext_19149'), this.view.down('#radiogroup_ext_19179'), this.view.down('#radiogroup_ext_19098'), this.view.down('#textareafield_ext_19054')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.candidateName = this.view.down('#textfield_ext_18970').getValue();
          jsonData.interviewere = this.view.down('#combo_ext_18979').getValue();
          jsonData.recommendHire = this.view.down('#radiogroup_ext_19077').getCmpValue();
          jsonData.emailid = this.view.down('#textfield_ext_19003').getValue();
          jsonData.datee = this.view.down('#datefield_ext_19018').getValues();
          jsonData.skillFit = this.view.down('#radiogroup_ext_19122').getCmpValue();
          jsonData.cultureFit = this.view.down('#radiogroup_ext_19149').getCmpValue();
          jsonData.growthPotential = this.view.down('#radiogroup_ext_19179').getCmpValue();
          jsonData.star = this.view.down('#radiogroup_ext_19098').getCmpValue();
          jsonData.note = this.view.down('#textareafield_ext_19054').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Candidate/',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    } else if (!sessionTimeOutFlag) {
                         scope.sender.controller.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    if (!sessionTimeOutFlag) {
                         var responseText = Ext.JSON.decode(response.responseText);
                         scope.sender.controller.responseHandler(responseText);
                    }
               }
          }, scope);
     }
});