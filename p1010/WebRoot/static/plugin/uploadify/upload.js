		function mytxt(url, id){
        	 
        }
        function showResult(){//删除显示的上传成功结果
          jQuery("#result").html("");
        }
        
        function uploadFile(){//上传文件
        		jQuery('#filedata').uploadifyUpload();
		}
		function cancleUpload(){
			 jQuery('#filedata').uploadifyClearQueue();
		}
