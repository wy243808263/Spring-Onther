// 加载头部文件
$(function() {
	$("#head").load("/static/html/server/head.html");
});

// 灰化按钮
function disabledBtn() {
	$("#submitBtn").attr("disabled", "disabled").text("loading...");
	$("#resetBtn").attr("disabled", "disabled");
}

// 启用按钮
function undisabledBtn() {
	$("#submitBtn").removeAttr("disabled").text("提交");
	$("#resetBtn").removeAttr("disabled");
}

// 字符转JSON对象
function toJSON(data){
	try{
		return eval('('+data+')');
	}catch(e){
		alert('转换JSON对象时出错');
		return null;
	}
}

// 提交表单
function submitForm(url, form){
	$(form).validate({
		submitHandler:function(form1){
			// 按钮灰化
			disabledBtn();
			// 表单提交
			$.ajax({
			   type: "post",
			   url: url,
			   data: $(form).serialize(),
			   success: function(data){
				    data = eval('('+data+')');
					if(data.success){
						var f = confirm(data.message);
						if(f){
							var p = window.dialogArguments;
							if(p != null)
							  p.pageMain();
							else
							  window.opener.pageMain();
						}
						window.close();
					}
			   },
			   error: function(){
				   alert("提交失败,请尝试重新提交!");
				   undisabledBtn();
				   return false;
			   }
			}); 
			return false;
		}
	});
}