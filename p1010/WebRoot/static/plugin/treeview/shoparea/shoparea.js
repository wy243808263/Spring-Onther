

/** ajax获取商店配送地区树**/
function InitAreaParent() {
	jQuery.post("/admin/area_shopArea", "ver=" + new Date().getTime() + "&area.level=1", function (data) {
		jQuery("#parent").html("").append(data);
	});
}

/** ajax添加商店配送地区**/
function insertArea(id, name) {
	var shopArea = document.getElementById("shopArea_" + id);
	if (shopArea == null) {
		var shopid = document.getElementById("shop.id").value;
		jQuery.post("/admin/shopArea_add", "ver=" + new Date().getTime() + "&shopArea.shop.id=" + shopid + "&shopArea.area.id=" + id, function (data) {
			jQuery("#areaInfo").append("<div id='shopArea_" + id + "' class='submit'>" + name + "  <a href='#' onclick=removeArea('"+id+"')><img src='/apply/pattern/images/frame/gtk-del.png'></a></div>");
		});
	}
}

/** ajax删除商店配送地区**/
function removeArea(id) {
	jQuery.post("/admin/shopArea_removeByArea", "ver=" + new Date().getTime()+"&shopArea.area.id="+id, function (data) {
	   jQuery("#shopArea_"+id).removeClass("submit");
	   jQuery("#shopArea_"+id).html('');
	});
}

