var countUrl = ""; // 记录数请求路径
var listUrl = ""; // 分页数据请求路径
var offset = 0; // 分页索引
var limit = 10; // 默认显示条数
var params = ""; // 附加参数

var container_full = "#pagination"; // 分页容器节点
var container_count = "#total"; // 总记录数节点
var container_offset = "#offset"; // 索引节点
var container_limit = "#limit"; // 显示数目节点
var container_substance = "#substance"; // 数据显示节点

// 初始化分页
function initPage(p_countUrl, p_listUrl, p_offset, p_limit, p_params) {

	countUrl = p_countUrl;
	listUrl = p_listUrl;

	if (p_offset != undefined && p_offset != null && p_offset != 0)
		offset = p_offset;

	if (p_limit != undefined && p_limit != null && p_limit != 0)
		limit = p_limit;

	if (p_params != undefined && p_params != null && p_params.length != 0
			&& p_params != "" && p_params != 0)
		params = "&" + params;
	else
		params = "";

	jQuery.ajax({
				type : "post",
				url : countUrl,
				data : "offset=" + offset + "&limit=" + limit + "&action=count"
						+ params,
				success : function(data) {
					if (!data) {
						alert("初始化分页记录数失败,请尝试刷新!");
						return false;
					}
					jQuery(container_count).text(data);
					initPagination(listUrl, offset, params);
				},
				error : errorTip
			});
}

// 初始化分页数据
function initPagination(url, offset, params) {
	var p_total = initTotal();
	if (p_total == undefined || p_total == null || p_total == "") {
		alert("分页初始化失败,请尝试重新刷新页面!");
		return false;
	}
	offset = offset - 1;
	jQuery(container_full).pagination(p_total, {
				callback : pageCallback, // 回调函数
				prev_text : '上页', // 上页按钮
				next_text : '下页 ', // 下页按钮
				items_per_page : limit, // 显示条数
				num_display_entries : 5, // 连续分页主体部分分页条目数
				current_page : offset, // 当前页索引
				isSum : false,
				num_edge_entries : 3,// 两侧首尾分页条目数
				jump_text : "跳转",
				jump_format_text : "请输入正确的页码",
				jump_outofrange_text : "页码超出了范围",
				jump_null_text : "请输入页码再点击跳转"
			});

	// 按钮触发回调函数
	function pageCallback(index, jq) {
		initData(url, index, jq, params, p_total);
	}
}

// 分页数据加载
function initData(url, index, jq, params, p_total) {
	index++;
	jQuery.ajax({
				type : "post",
				url : url,
				data : "offset=" + index + "&limit=" + limit + "&total="
						+ p_total + "&action=list" + params,
				beforeSend : loading,
				success : function(data) {
					if (!data) {
						alert("加载分页数据失败,请尝试刷新!");
						return false;
					}
					jQuery(container_offset).val(index);
					jQuery(container_limit).val(limit);
					jQuery(container_substance).html('').append(data);
				},
				error : errorTip
			});
}

// 打开子窗口
function openWin(url, value, height, width, param) {
	var top = (window.screen.availHeight - 20 - height) / 2;
	var left = (window.screen.availWidth - 10 - width) / 2;
	param += "dialogHeight:" + height + "px;dialogWidth:" + width
			+ "px;dialogLeft:" + left + "px;dialogTop:" + top + "px;";
	window.showModalDialog(url, value, param);
}

// 新增记录
function toAdd(url, height, width) {
	var param = "status:0;help:0;scroll:0;resizable:0;center:1;";
	var obj = openWin(url, window, height, width, param);
}

// 修改记录
function toModify(url, height, width) {
	var param = "status:0;help:0;scroll:0;resizable:0;center:1;";
	var obj = openWin(url, window, height, width, param);
}

// 重新计算页码数
function pageRefresh(val) {
	var old_total = initTotal();
	var new_total = 0;
	if (old_total - val > 0)
		new_total = old_total - val;
	else
		new_total = 1;
	var page1 = Math.ceil(old_total / limit); // 删除前页码数
	var page2 = Math.ceil(new_total / limit); // 删除后页码数
	if (page1 - page2 > 0) {
		var offset = jQuery(container_offset).val();
		jQuery(container__offset).val(offset - 1);
	}
}

// 删除记录
function removeById(url, id) {
	var f = confirm("确定要删除该记录?");
	if (!f)
		return false;
	jQuery.ajax({
				type : "post",
				url : url,
				data : "ver=" + new Date().getTime(),
				success : function(data) {
					data = eval('(' + data + ')');
					if (data.success) {
						alert(data.message);
						pageRefresh(1);
						pageMain(); // 回调分页主函数
					} else {
						alert(data.message);
						return false;
					}
				},
				error : errorTip
			});
}

// 批量删除
function removeForAll(url) {
	var array = new Array();
	jQuery('.subBox:checked').each(function(index) {
				array[index] = jQuery(this).val();
			});
	if (array.length <= 0) {
		alert('请至少选择一个记录!');
		return false;
	}
	var f = confirm("确定要删除所选中的记录?");
	if (!f)
		return false;
	jQuery.ajax({
				type : "post",
				url : url,
				data : "ver=" + new Date().getTime() + "&array=" + array,
				success : function(data) {
					data = eval('(' + data + ')');
					if (data.success) {
						alert(data.message);
						jQuery('#allBox').attr('checked', false);
						pageRefresh(array.length);
						pageMain(); // 回调分页主函数
					} else {
						alert(data.message);
						return false;
					}
				},
				error : errorTip
			});
}

// 更改默认节点位置
function changeDefDom(p_container_full, p_container_count, p_container_offset,
		p_container_limit, p_container_substance) {

	if (p_container_full != undefined && p_container_full != null
			&& p_container_full != "")
		container_full = p_container_full; // 分页容器节点

	if (p_container_count != undefined && p_container_count != null
			&& p_container_count != "")
		container_count = p_container_count; // 总记录数节点

	if (p_container_offset != undefined && p_container_offset != null
			&& p_container_offset != "")
		container_offset = p_container_offset; // 索引节点

	if (p_container_limit != undefined && p_container_limit != null
			&& p_container_limit != "")
		container_limit = p_container_limit; // 显示数目节点

	if (p_container_substance != undefined && p_container_substance != null
			&& p_container_substance != "")
		container_substance = p_container_substance; // 数据显示节点
}

// 获取记录总数
function initTotal() {
	var obj1 = null;
	var obj2 = null;
	obj1 = $(container_count).text();
	obj2 = $(container_count).val();
	if (obj1 != "") // 判断是用val还是text方法获取到值
		return obj1;
	if (obj2 != "")
		return obj2;
}

// 加载错误提示
function errorTip() {
	return false;
}

// 加载中显示
function loading() {
	var td = jQuery(".theader").length;
	jQuery(container_substance)
			.html("<tr align='center' bgcolor='#FFFFFF'><td colspan='"
					+ td
					+ "'><div align='center'><img src='/static/skin/server/images/common/loading.gif'/></div></td></tr>");
}

// checkbox全选/反选
function checkBoxClick() {
	jQuery('#allBox').click(function() {
				var clicked = jQuery(this).attr('checked');
				if (clicked)
					jQuery('.subBox').attr('checked', true);
				else
					jQuery('.subBox').attr('checked', false);
			});
}

// 变更显示记录条数
function changeTotalWav(id) {
	var wav = $(id).val();
	limit = wav;
	jQuery(container_limit).val(wav);
	initPage(countUrl, listUrl, offset, limit, params);
}

// 初始化页面完成后操作
jQuery(document).ready(function() {
	checkBoxClick();
		// jQuery.ajaxSetup({timeout:3000}); // 请求超时
	});