function InitCategory(){
   jQuery.post('/admin/category_level','ver='+new Date().getTime()+'&category.level=1',function(data){
   jQuery('#parent').html('').append(data);
		});
 }
 
 function selCategory(id,level,name){
   jQuery('#pid').val(id);
   jQuery('#level').val(level);
   jQuery('#pname').val(name);
 }
 
 
 function InitFoodCategory(){
   jQuery.post('/admin/category_foodCategory','ver='+new Date().getTime()+'&category.level=1',function(data){
   jQuery('#parent').html('').append(data);
		});
 }


 