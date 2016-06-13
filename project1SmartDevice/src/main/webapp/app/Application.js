/**
 * The main application class. An instance of this class is created by app.js
 * when it calls Ext.application(). This is the ideal place to handle
 * application launch and initialization details.
 */
Ext.define('Project1.Application', {
	extend : 'Ext.app.Application',

	name : 'Project1',

requires : ["Ext.button.*","Ext.container.*","Ext.dashboard.*","Ext.dd.*","Ext.dom.*","Ext.event.*","Ext.flash.*","Ext.form.*","Ext.fx.*","Ext.grid.*","Ext.layout.*","Ext.menu.*","Ext.panel.*","Ext.picker.*","Ext.plugin.*","Ext.resizer.*","Ext.rtl.*","Ext.selection.*","Ext.slider.*","Ext.sparkline.*","Ext.state.*","Ext.tab.*","Ext.tip.*","Ext.toolbar.*","Ext.tree.*","Ext.util.*","Ext.view.*","Ext.window.*","Ext.Action","Ext.Component","Ext.ComponentLoader","Ext.ElementLoader","Ext.EventManager","Ext.FocusManager","Ext.Img","Ext.LoadMask","Ext.ProgressBar","Ext.ProgressBarWidget","Ext.ZIndexManager","Project1.view.fw.component.DateFields","Project1.view.fw.component.CustomCheckBoxGroup","Project1.view.fw.component.CustomRadioGroup","Project1.view.fw.component.DateTimeField","Project1.view.fw.component.DateTimePicker","Project1.view.fw.component.FileUploadComponent","Project1.view.fw.component.Grids","Project1.view.fw.component.ListViewBaseView","Project1.view.fw.DateRange","Ext.data.Model","Ext.app.ViewModel"],
	
	views : [],

	controllers : [],

	stores : [],

	launch : function() { }

});

Ext.Ajax.timeout = 180000; 
var sessionTimeOutFlag = false;

/**isMultiForm**/var isMultiTab = true;

Ext.Ajax.on('beforerequest', function(connection, options, eOpts) {

	if (options.maskEnable) {
		if (options.maskEle != null) {
			options.maskEle.mask('Request processing...');
		} else {
			Ext.getBody().mask('Request processing...');
		}
	}
});

Ext.Ajax.on('requestcomplete', function(conn, response, options, eOpts) {
		
	try {
		if (options.maskEnable) {
			if (options.maskEle != null) {
				options.maskEle.unmask();
			} else {
				Ext.getBody().unmask();
			}
		}
	} catch(e) {
		console.log("requestcomplete >> e -- " +e);
	}
});

Ext.Ajax.on('requestexception', function(conn, response, options, eOpts) {
	
	try{
		var responseText = Ext.JSON.decode(response.responseText);
		if (responseText.alarm) {
			if (responseText.alarm.alarmID == "ABSAA254905401" && !sessionTimeOutFlag) {
				sessionTimeOutFlag = true;
				var loginWindow = Ext.create('Project1.view.login.SessionLogin').center();
				loginWindow.currentRequest = options;
				loginWindow.show();
			}
		}
	} catch(e){ 
		console.log("requestexception >> e -- " +e);
	}
	
	try{
		if (options.maskEnable) {
			if (options.maskEle != null) {
				options.maskEle.unmask();
			} else {
				Ext.getBody().unmask();
			}
		}
	} catch(e1) {
		console.log("requestexception >> e1 -- " +e1);
	}
});
