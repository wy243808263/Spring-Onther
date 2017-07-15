        var img;
        var show;
        var id;
        
        function uploadImage(url){
        	 jQuery("#filedata").uploadify({
                'uploader'       : '/plugin/uploadify/uploadify.swf?var='+(new Date()).getTime(), //是组件自带的flash，用于打开选取本地文件的按钮 
                /*'buttonImg'	 : '/plugin/uploadify/upload.jpg',
                'width' 		 : 120,
                'height'		 : 30,*/
                'wmode'			 : 'opaque',
                'script'         : url+'?ver='+new Date().getTime(),//处理上传的路径，这里使用Struts2是XXX.action 
                'cancelImg'      : '/plugin/uploadify/cancel.png',//取消上传文件的按钮图片，就是个叉叉
                'sizeLimit' 	 : 20971520,     //允许文件上传的大小  20M
                'fileDataName'   : 'filedata',//和input的name属性值保持一致就好，Struts2就能处理了
                'queueID'        : 'fileQueue',
                'auto'			 : false,//是否选取文件后自动上传
                'multi'			 : true,//是否支持多文件上传
                'queueSizeLimit' : 1, //默认上传文件数
                'simUploadLimit' : 1,//每次最大上传文件数
                'buttonText'     : 'UPLOAD FILE',//按钮上的文字
                'displayData'    : 'percentage',//有speed和percentage两种，一个显示速度，一个显示完成百分比 
                'rollover' 		 : false,
                'fileDesc'       : 'jpg/gif/jpeg/png/bmp.',//'支持格式:jpg/gif/jpeg/png/bmp.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的 
                'fileExt'        : '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式,'*.jpg;*.gif;*.jpeg;*.png;*.bmp' '*.doc;*.pdf;*.rar'
                'onComplete'     : function (event, queueID, fileObj, response, data){
                	  jQuery("#"+show).append("<img src='"+response+"'/>");
                	  jQuery("#"+img).val(response);
	                  jQuery("#result").html("您已成功上传了文件!");//显示上传成功结果
	                  setInterval("showResult()",2000);//三秒后删除显示的上传成功结果
	                  jQuery("#"+id).html('');
                },
                'onSelect'   : function(event, queueID, fileObj){
                },
                'onCancel' : function(event, queueId, fileObj, data){
                	jQuery('#filedata').uploadifyCancel(queueId);
                },
                'onQueueFull' : function (event, data){
                }
            });
        }
        function showResult(){//删除显示的上传成功结果
             jQuery("#result").html("");
        }
        
        function uploadFile(s,i,d){//上传文件
             show =s;
             img =i;
             id = d;
        	 jQuery('#filedata').uploadifyUpload();
		}
		function cancleUpload(){
			 jQuery('#filedata').uploadifyClearQueue();
		}
		
