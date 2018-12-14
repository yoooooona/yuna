/**
 * 
 */
$(function() {
	$("#join").validate({
		rules : {
			user_id : {
				required : true,
				validId : true
			},
			user_pw : {
				required : true,
				validPwd : true
			},
			confirm_pw : {
				required : true,
				validPwd : true,
				equalTo : "#user_pw"
			},
			gender : {
				required : true,
				minlength : 1
			},
			email : {
				required : true,
				validEmail : true
			},
			tel : {
				required : true,
				validTel : true
			},
			hobby:"required",
			job:"required"
		},
		messages:{
			user_id:{
				required:"아이디는 필수요소 입니다."
			},
			user_pw:{
				required:"비밀번호는 필수요소입니다."
			},
			confirm_pw:{
				required:"비밀번호는 필수요소입니다.",
				equalTo:"이전 비밀번호와 다릅니다."
			},
			email:{
				required:"이메일 주소를 입력하세요"
			},
			gender:"성별을 체크하세요",
			tel:{
				required:"핸드폰 번호를 확인하세요"
			},
			hobby:"취미를 입력하세요",
			job:"직업을 선택하세요"
		}
	});
});

$.validator
		.addMethod(
				"validId",
				function(value) {
					// 아이디는 6~12자리, 영대소문자 포함, 숫자 포함, 특수문자 포함
					var regId = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{6,12}$/;
					return regId.test(value);
				}, "아이디는 영문자, 숫자, 특수문자의 조합으로 6~12자리 이하로 만들어야 합니다.");

$.validator.addMethod("validPwd", function(value) {
	// 비밀번호는 8~15자리, 영대소문자포함, 숫자포함
	var regPwd = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,15}$/;
	return regPwd.test(value);
}, "비밀번호는 영문자, 숫자조합으로 8~15자리 이하로 만들어야 합니다.");

$.validator
		.addMethod(
				"validEmail",
				function(value) {
					// 이메일은 6~12자리, 영대소문자 포함, 숫자 포함, 특수문자 포함
					var regEmail = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
					return regEmail.test(value);
				}, "이메일 형식이 다릅니다.");

$.validator.addMethod("validTel", function(value) {
	// 전화번호는 ex)01023115964
	var regTel = /^\d{2,3}\d{3,4}\d{4}$/;
	return regTel.test(value);
}, "-를 제외한 번호만 입력해주세요.");
