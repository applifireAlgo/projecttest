Ext.define('Project1.view.desktop.design.menubar.menu.AppMenuBarController', {
    extend: 'Ext.app.ViewController',
 
    alias: 'controller.appMenuBar',
    appMenuBar:undefined,
    homeScreenMenuItem:undefined,
    init:function(){
    	this.appMenuBar = this.getView();
    },
    onAppMenuBarItemClick : function(  menuitem,e){
        menuitem.up('button').menu.hide();
        var sender = this;
        var nodedata = menuitem.menuConfig;

        if(nodedata.menuId && nodedata.menuAction!==""){
        
         var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
         var clickedAction = appMainTabPanel.down("[menuId='"+nodedata.menuId+"']");

         if(clickedAction){
            appMainTabPanel.setActiveItem(clickedAction);
         }else{

         var addedForm = appMainTabPanel.add(Ext.create(nodedata.menuAction,{
             closable:true,
              nodedata:nodedata,
             title:nodedata.menuName,
             menuId:nodedata.menuId,
             sender:sender,
        	 refId:nodedata.hasOwnProperty('refId')?nodedata.refId:"",
             listeners:{ 
                            close: function(tab){
                                tab.sender.removeClosedTabFromSavedTabs(tab.nodedata);
                            }
            }
         }));
         appMainTabPanel.setActiveItem(addedForm);
         this.saveFormAsStoredTab(nodedata);
         }
     }
    },
   
    onMenuBarAfterRender : function(appMenuBar){
       
        var sender = this;
        
        Ext.Ajax.request({
                     url : "secure/MenuService/findMainScreenMenus",
                     method:'POST', 
                     sender:sender,
                     jsonData:{
                     },
                     success : function(response,scope){
                    	 var sender = scope.sender;
                         var responseJson = Ext.JSON.decode(response.responseText);
                          
                          var data = Ext.decode(responseJson.response.data);
                          
                          sender.configureAppMenu(sender,data.menus);
                          sender.pushHomeScreen(data);

                          sender.fetchAndPushStoredTabs();
                     },
                     failure : function(response,scope){
                    	   var pathName=this.location.pathname;
                           var initialPath=pathName.slice(0,pathName.lastIndexOf("/"));
                        
                        Ext.util.Cookies.clear('changePwd',initialPath);
                        Ext.util.Cookies.clear('XA_TID', initialPath);
                        Ext.util.Cookies.clear('XA_ID', initialPath);
                        Ext.util.Cookies.clear('JSESSIONID', initialPath);
                        Ext.util.Cookies.clear('userInfo', initialPath);
                        
                        this.location.href=this.location.origin+initialPath+"/";
                        
                   }
                 },sender);     
    },
    saveFormAsStoredTab : function(config){

           if(config){
                    var json = {};
                    json.id = config.menuId;
                    json.value = config.menuAction;
                    
                     Ext.Ajax.request({
                         url : "secure/MenuService/storeMenu",
                         method:'POST', 
                         jsonData: json,
                         success : function(response){
                         },
                         failure : function(response){
                         }
                     });    
            }
    },
    removeClosedTabFromSavedTabs : function(config){
                    var json = {};
                    
                    json.id = config.menuId;
                    json.value = config.menuAction;
                    
                     Ext.Ajax.request({
                         url : "secure/MenuService/deleteMenu",
                         method:'POST', 
                         jsonData: json,
                         success : function(response){
                            
                         },
                         failure : function(response){
                         }
                     });            
                    
    },
    fetchAndPushStoredTabs :function(){
        var sender = this;
        
        var loadMask = new Ext.LoadMask({
            msg    : 'Please wait...',
            target : Ext.getCmp('appMainTabPanel')
        }).show();

        Ext.Ajax.request({
            url : "secure/MenuService/fetchStoreMenu",
            method:'POST', 
            scope:sender,
            loadMask:loadMask,
            success : function(response,sender){
                var scope = sender.scope;
                var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
        
                var menus = Ext.decode(response.responseText);
                var data = Ext.decode(menus.response.data);
                    
                    var appMenuBar = scope.appMenuBar ;
                    

                    for (var i = 0; i < data.length; i++) {
                        var menuObj = data[i];
                        var menuNode = appMenuBar.down('displayfield[menuBarItemId="'+menuObj.menuId+'"]');

                        
                        if(menuNode){
                            var nodedata = menuNode.menuConfig;

                        var addedForm = appMainTabPanel.add(Ext.create(nodedata.menuAction,{
                            closable:true,
                            title:nodedata.menuName,
                            menuId:nodedata.menuId,
                            nodedata:nodedata,
                            sender:scope,
                            refId:nodedata.hasOwnProperty('refId')?nodedata.refId:"",
                            listeners:{ 
                                close: function(tab){
                                tab.sender.removeClosedTabFromSavedTabs(tab.nodedata);
                            }
                            }
                        }));

                        appMainTabPanel.setActiveItem(addedForm);

                        }
                    }
                sender.loadMask.hide();
                },
            failure : function(response,sender){
                sender.loadMask.hide();
            }
        },sender);      

    },
    removeClosedTabFromSavedTabs : function(config){
                    var json = {};
                    
                    json.id = config.menuId;
                    json.value = config.menuAction;
                    
                     Ext.Ajax.request({
                         url : "secure/MenuService/deleteMenu",
                         method:'POST', 
                         jsonData: json,
                         success : function(response){
                            
                         },
                         failure : function(response){
                         }
                     });            
                    
    },
    pushHomeScreen : function(data){
    	
    	var homescreenlist = data.homeScreenMenus;
		
    	if(homescreenlist) {
    		
				try {
					var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
		            appMainTabPanel.removeAll();
		            
					
					for(var i=0; i < homescreenlist.length; i++) {
						var config = homescreenlist[i];
						var addedtab = appMainTabPanel.add(Ext.create(config.menuAction, {
							closable : false,
							title : config.text,
							refId : config.refId,
							menuid : config.menuId
						}));
						appMainTabPanel.setActiveItem(addedtab);
					}
				} catch(e) {	
					
				}
		}
    },
    configureAppMenu: function(scope,menus){
        var menubar = scope.view;
            for (var i = 0; i < menus.length; i++) {
              
               var mObj = menus[i];
               var menuItems = scope.formAppMenuJson(scope,scope.view,menus[i],true);
               if(menuItems.length>0){
                   
               menubar.add({
                text:"<span class='menu-bar-item-cls'><b>"+mObj.menuName+"</b></span>",
                height:35,
                menu:{
                                title:"",
                                shrinkWrap:3,
                                items:menuItems,
                                layout:'hbox',
                                bodyPadding:10,
                                maxHeight:600,
                                autoScroll:true,
                                defaults:{
                                    layout:'hbox', flex:1
                                },
                                floating:true
                            }
               });
               }
            }  
    },
    formAppMenuJson : function(scope,menubar,menuitem,isHeader){
       
        var allNodes = new Array();
        if( menuitem.hasOwnProperty('children')){
            var allChild= new Array();
              for (var i = 0; i <menuitem.children.length; i++) {
                   var child = menuitem.children[i];
                   allChild = allChild.concat(scope.formAppMenuJson(scope,menubar,child,false));
                }  
                var folderNodes = Ext.Array.filter(menuitem.children,function(item){return item.leaf == false;});
              

           allNodes = allNodes.concat({
                config:menuitem,
                //menu:allChild,
                items:allChild,
                xtype:'panel',
                bodyPadding:5,
                header:{hidden:true},
                layout:folderNodes.length>0 ? "hbox":"vbox",
                tbar:[{xtype:'displayfield',value:menuitem.menuName,hidden:isHeader?true:false,fieldCls:'menu-bar-item-header-cls'}],
                margin:10,
                autoScroll:false,
                title:isHeader?"":menuitem.menuName,
             });
           

        }else if(menuitem.leaf ){

            return {
                value:menuitem.menuName,
                xtype:'displayfield',
                menuConfig : menuitem,
                menuBarItemId:menuitem.menuId,
                fieldCls:'menu-bar-inner-item-cls',
                overCls:'menu-bar-inner-item-over-cls',
                listeners:{
                    afterrender :function(menuitem){
                        
                        menuitem.el.on('click',function(el){
                            
                            scope.onAppMenuBarItemClick(this.component,el);
                        });
                        
                    },
                    click:'onAppMenuBarItemClick'
                }
            };
        }
        return allNodes;
    },
    configureStandardAppMenu: function(scope,menus){

            for (var i = 0; i < menus.length; i++) {
                scope.formAppMenuJson(scope,scope.view,menus[i],true);
            }  
    },
    formStandardAppMenuJson : function(scope,menubar,menuitem,isHeader){
       
        var allNodes = new Array();
        if( menuitem.hasOwnProperty('children') && menuitem.children.length>0){
            var allChild= new Array();
              for (var i = 0; i <menuitem.children.length; i++) {
                   var child = menuitem.children[i];
                   allChild = allChild.concat(scope.formAppMenuJson(scope,menubar,child,false));
                }  
           allNodes = allNodes.concat({
                config:menuitem,
                menu:allChild,
                height:38,
                text: isHeader?"<span class='menu-bar-item-cls'><b>"+menuitem.menuName+"</b></span>":menuitem.menuName
           });
           if(isHeader){
                menubar.add(allNodes);
           }

        }else{
            return {
                text:menuitem.menuName,
                config : menuitem,
                height:38,
                listeners:{
                    click:'onAppMenuBarItemClick'
                }
            };
        }
        return allNodes;
    }
    
});
