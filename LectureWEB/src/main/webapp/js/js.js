/**
 * 
 */

function is_number(number){
	let result = false;
	let count = 0;
	for(i=0; i<=number; i++){
		if(number%i===0){
			count++;
		}
	}
	if(count===2){
		result = true;
	}
	if(result === true){
		console.log(number+" is true");
	}else{
		console.log(number+" is not true");
	}
	return result;
}

is_number(77);
is_number(47);

function is_year_check(year){
	let result = false;
	let con1 = false;
	let con2 = false;
	let con3 = false;
	
	if(year%4 === 0){
		con1 = true;
	}
	
	if(year%100 === 0){
		con2 = true;
	}
	
	if(year%400 === 0){
		con3 = true;
	}
	
	if(con1==true && con2==true && con3==true){
		result = true;
		console.log(year+" is true");
	}else{
	console.log(year+" is not true");
	}
	return result;
}

is_year_check(2022);
is_year_check(2400);

      function view_month1() {
        console.log("\t\t 8월");
        console.log("일\t월\t화\t수\t목\t금\t토\t");
        let none = 1;
        let len = 31;
        let arr = "";
        for (i = 0; i < none; i++) {
          arr = arr + "\t";
        }
        for (i = 1; i <= len; i++) {
          arr = day + i + "\t";
          if ((i + none) % 7 === 0) {
            console.log(arr);
            arr = "";
          }
        }
        console.log(arr);
      }
      


function view_month(){
	console.log("\t\t8월");
	console.log("일\t월\t화\t수\t목\t금\t토");
	let space = 1;
	let day	= 1;
	let week ="";
	for(let i = 0; i<space; i++){
		week = week + "\t";
	}
	for(let i = 0; i<31; i++){
		week = week + day + "\t";
		if((space+day)%7===0){
			console.log(week);
			week="";
		}
		day = day+1;
	}
	console.log(week);
}

view_month();