/**
 * 
 */
$(function(){
	$("#joinform").validate({
		errorPlacement:function(error,element){
			$(element).closest("form").
				find("small[id='"+element.attr("id")+"']").append(error);
		},
		rules:{
			userid:{
				required:true,
				validId : true,
				remote:{   //$.ajax() 같은 역할
					url : "../checkId.do",  //*.do
					type : "post",
					data :{ 
						userid:function(){
							return $("#userid").val();
					    }
					}
				}
			},		
			password:{
				required:true,
				validPwd:true
			},
			confirm_password:{
				required:true,
				validPwd:true,
				equalTo:"#confirm_password"
			},
			name:{
				required:true,
				minlength:2
			},
			gender:{
				required:true,
				minlength:1
			},		
			email:{
				required:true,
				validEmail:true
			}
		},
		messages:{
			userid:{
				required:"아이디는 필수요소 입니다.",
				remote:"아이디가 중복되었습니다."
			},
			password:{
				required:"비밀번호는 필수요소입니다."
			},
			confirm_password:{
				required:"비밀번호는 필수요소입니다.",
				equalTo:"이전 비밀번호와 다릅니다."
			},
			name:{
				required:"이름은 필수요소입니다.",
				minlength:"최소 2자리 이상입니다."
			},
			email:{
				required:"이메일 주소를 입력하세요"
			},
			gender : "성별을 체크하세요"			
		}
	});
});

$.validator.addMethod("validId",function(value){
	//아이디는 6~12자리, 영대소문자 포함, 숫자 포함
	var regId=/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,12}$/;
	return regId.test(value);
},"아이디는 영문자,숫자의 조합으로 6~12자리 이하로 만들어야 합니다.");

$.validator.addMethod("validPwd",function(value){
	//비밀번호는 8~15자리, 영대소문자 포함, 숫자 포함
	var regPwd=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,15}$/;
	return regPwd.test(value);
},"비밀번호는 영문자, 숫자, 특수문자의 조합으로 8~15자리 이하로 만들어야 합니다.");

$.validator.addMethod("validEmail",function(value){
	//비밀번호는 8~15자리, 영대소문자 포함, 숫자 포함
	var regEmail=/^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	return regEmail.test(value);
},"이메일 형식이 다릅니다.");















