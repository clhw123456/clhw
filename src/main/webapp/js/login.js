//自定义登录表单验证规则
$.extend($.fn.validatebox.defaults.rules, {
    length: {
    	//value是获取到输入框的值，param是自己添加的验证参数
		validator: function(value, param){
			
			return value.length >= param[0] && value.length<= param[1];
		},
		message: '密码至少{0}位，最多{1}位'
    }
});