/**
 * 
 */
$(function(){
	$("#signupForm").validate({
		// 검증할 규치겡 대해서 rules 아래 기재
		rules:{
			firstname: "required",
			lastname: "required",
			username:{
					required:true,
					minlength:2
				},
				password:{
					required:true,
					minlength: 5
				},
				confirm_password:{
					required:true,
					minlength:5,
					equalTo:"#password"
				},
				email:{
					required:true,
					email:true
				},
				topic:{
					required:"#newsletter:checked",
					minlength:2 //최소 2개를 체크해야됨
				},
				agree:"required"
		},
		messages:{ //기본으로 보여지는 메세지 말고 개발자가 원하는 메시지 띄우기
			firstname:"첫번째 이름을 입력하세요",
			lastname:"마지막 이름을 입력하세요",
			username:{
				required:"이름은 필수 요소 입니다.",
				minlength:"이름은 최소 2자리입니다."
			},
			password:{
				required:"비밀번호는 필수요소입니다.",
				minlength:"비밀번호는 최소 5자리입니다"
			},
			confirm_password:{
				required:"비밀번호는 필수요소입니다.",
				minlength:"비밀번호는 최소 5자리입니다.",
				equalTo:"이전 비밀번호랑 다릅니다."
			},
			email:"올바른 이메일 주소를 입력하세요",
			agree:"우리의 정책에 동의를 필요로 합니다.",
			topic:"관심사를 적어도 2개는 표시하세요"
		}
	});
});