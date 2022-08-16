/**
 * 
 */
 
function check_id(){
	let id = document.getElementById("input_id").value;
	alert(id);
}

function select_number(){
	let number = document.getElementById("selection").value;
	if (number==1){
		alert("1번 선택하셨습니다");
	}else if(number==2){
		alert("2번 선택하셨습니다");
	}else if(number==3){
		alert("3번 선택하셨습니다");
	}else if(number==4){
		alert("4번 선택하셨습니다");
	}
}

function get_content(){
	// 배열은 고정이므로 const로 선언해준다
	const con = document.getElementsByClassName("t_area");
	alert(con[0].value);
	return false;
}

function radio_check(){
	// 배열은 고정이므로 const로 선언해준다
	const radios = document.getElementsByName("radio_check");
	for(i=0; i<radios.length; i++){
		alert(radios[i].checked);
	}
}

function checkbox(){
	// 배열은 고정이므로 const로 선언해준다
	const boxes = document.getElementsByName("checkbox");  
	let counts = 0;
	for(let i=0; i<boxes.length; i++){
		if(boxes[i].checked){
			alert((i+1)+"번째 박스의 값은 "+boxes[i].value);
			counts+=1;
		}
	}
	if(counts<=2){
		alert("최소 3개는 선택해야 해요!")
		return false;
	}
	alert("총 "+counts+"개 체크되었어요!");
}