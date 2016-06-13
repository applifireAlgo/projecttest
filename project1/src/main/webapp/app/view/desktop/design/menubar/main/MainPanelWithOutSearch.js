Ext.define('Project1.view.desktop.design.menubar.main.MainPanel', {
    extend : 'Ext.panel.Panel',
    xtype : 'mainPanel',
    requires : ['Project1.view.desktop.design.menubar.main.MainPanelController','Project1.view.desktop.design.menubar.menu.AppMenuBar'],
    userinfo:{},
    id:'mainPanel',
    controller:'mainPanel',
   
    layout: {
        type: 'border'
    },
    bodyStyle:{
        background:"#f6f6f6"
    },
    items: [
            {
                region : 'center',
                xtype:'tabpanel',
                id:'appMainTabPanel',
                itemId:'appMainTabPanel',
                layout:'fit',
                tabBar:{
                             border:0,
                             margin:'5 0 0 0',
                             style:{"border-width":"0px !important","border-radius":"0px !important"},
                             height:48,
                             defaults:{
                                 height:32
                             }
                            
                 },
                bodyStyle:{
                                 background:"#f6f6f6"
                },
                header:{
                         titlePosition:2,
                         style:{
                            "background":"#ffffff",
                            "box-shadow": "0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23)"
                         },
                      tools:[{
                        xtype:'displayfield',
                        id:'userNameDField',
                        itemId:'userNameDField',
                        value:"",
                        margin:'0 0 0 30',
                        height:20,
                        style:"word-break: break-word; word-wrap: break-word;",
                        fieldStyle:{
                            color:"#424242",
                            "font-weight":"normal",
                            "font-size":"18px"
                        },listeners:{
                        	afterrender:'displayUserDetail'
                        }
             
                    
                        },{
                            xtype: 'button',
                            scale:'large',
                            arrowVisible:false,
                            margin:'0 0 0 5',
                            style:{
                                  borderWidth:'0px',
                                  borderRadius:'50%',background:'transparent'
                               },
                            icon:'resources/appicons/ic_user_settings_grey.png',
                            arrowAlign:'bottom',
                            listeners : {mouseover : function() { this.menu.showBy(this); } },
                            menu:{
                                items : [
                                                            {
                                                                xtype : 'menuitem',
                                                                height : 38,
                                                                text : '<span class="user-settings-menu-item-cls">My Profile<span>',
                                                                listeners : {
                                                                    click : 'onMyProfileClick'
                                                                }
                                                            },
                                                            {
                                                                xtype : 'menuitem',
                                                                height : 38,
                                                                text : '<span class="user-settings-menu-item-cls">Change Password<span>',
                                                                listeners : {
                                                                    click : 'onChangePwdClick'
                                                                }
                                                            },
                                                            {
                                                                xtype : 'menuitem',
                                                                text : '<span class="user-settings-menu-item-cls">Cloud Drive<span>',
                                                                height : 38,
                                                                /*Disable Cloud on addOn basis*/
                                                                listeners : {
                                                                    click : 'onCloudClick'
                                                                }
                                                            },
                                                            {
                                                                xtype : 'menuitem',
                                                                text : '<span class="user-settings-menu-item-cls">Log Out<span>',
                                                                height : 38,
                                                                listeners : {
                                                                    click : 'onLogoutClick'
                                                                }
                                                            }]
                            }
                         }],
                         items:[
                            {
                                xtype : 'image',
                                src : 'images/logo.png',
                                id : 'userImg',
                                scale:'small',
                                height : 38,
                                width : 38
                             },
                            {
                                xtype:'appMenuBar'
                            }
                         ]
                }
                

            }
    ],
    listeners:{
    	boxready:'onMainPanelAfterRender'
    }

});
