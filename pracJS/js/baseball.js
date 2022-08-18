function game_start() {
  document.getElementById("select_difficulty").style.display = "none";

  let check01 = document.getElementById("radio_difficulty1").checked;
  let check02 = document.getElementById("radio_difficulty2").checked;
  let check03 = document.getElementById("radio_difficulty3").checked;

  //   if (check01 == false || check02 == false || check03 == false) {
  //     alert("난이도를 선택해야 합니다");
  //     return;
  //   }

  if (document.getElementById("radio_difficulty1").checked) {
    alert("난이도 '하'입니다");
    document.getElementById("display_difficulty").innerHTML = "하";
  }
  if (document.getElementById("radio_difficulty2").checked) {
    alert("난이도 '중'입니다");
    document.getElementById("display_difficulty").innerHTML = "중";
  }
  if (document.getElementById("radio_difficulty3").checked) {
    alert("난이도 '상'입니다");
    document.getElementById("display_difficulty").innerHTML = "상";
  }

  document.getElementsByClassName("left")[0].style.display = "block";
  document.getElementsByClassName("right")[0].style.display = "block";

  set_answer();
  set_try_count();
  dp_cnt();
}

function set_answer() {
  const number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

  let value01 = Math.floor(Math.random() * (10 - 1) + 1);
  document.getElementById("answer_box_1").value = number[value01];
  number.splice(value01, 1);
  alert(document.getElementById("answer_box_1").value);

  let value02 = Math.floor(Math.random() * (9 - 0) + 1);
  document.getElementById("answer_box_2").value = number[value02];
  number.splice(value02, 1);
  alert(document.getElementById("answer_box_2").value);

  let value03 = Math.floor(Math.random() * (8 - 0) + 1);
  document.getElementById("answer_box_3").value = number[value03];
  number.splice(value03, 1);
  alert(document.getElementById("answer_box_3").value);

  let value04 = Math.floor(Math.random() * (7 - 0) + 1);
  document.getElementById("answer_box_4").value = number[value04];
  number.splice(value04, 1);
  alert(document.getElementById("answer_box_4").value);

  let arr_answer = [];
  arr_answer.push(document.getElementById("answer_box_1").value);
  arr_answer.push(document.getElementById("answer_box_2").value);
  arr_answer.push(document.getElementById("answer_box_3").value);
  arr_answer.push(document.getElementById("answer_box_4").value);

  if (arr_answer[0] == undefined) {
    const temp_number = [1, 2, 3, 4, 5, 6, 7, 8, 9];
    temp_number.splice(document.getElementById("answer_box_2").value);
    temp_number.splice(document.getElementById("answer_box_3").value);
    temp_number.splice(document.getElementById("answer_box_4").value);
    arr_answer[i] = temp_number[Math.floor(Math.random() * (6 - 0) + 1)];
  }

  if (arr_answer[1] == undefined) {
    const temp_number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    temp_number.splice(document.getElementById("answer_box_1").value);
    temp_number.splice(document.getElementById("answer_box_3").value);
    temp_number.splice(document.getElementById("answer_box_4").value);
    arr_answer[i] = temp_number[Math.floor(Math.random() * (6 - 0) + 1)];
  }

  if (arr_answer[2] == undefined) {
    const temp_number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    temp_number.splice(document.getElementById("answer_box_1").value);
    temp_number.splice(document.getElementById("answer_box_2").value);
    temp_number.splice(document.getElementById("answer_box_4").value);
    arr_answer[i] = temp_number[Math.floor(Math.random() * (6 - 0) + 1)];
  }

  if (arr_answer[3] == undefined) {
    const temp_number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    temp_number.splice(document.getElementById("answer_box_1").value);
    temp_number.splice(document.getElementById("answer_box_2").value);
    temp_number.splice(document.getElementById("answer_box_3").value);
    arr_answer[i] = temp_number[Math.floor(Math.random() * (6 - 0) + 1)];
  }
}

function match_number() {
  let strike = 0;
  let ball = 0;

  let count = document.getElementById("trycnt_display").innerHTML;
  document.getElementById("trycnt_display").innerHTML = count - 1;
  if (document.getElementById("trycnt_display").innerHTML == 0) {
    alert("게임에서 패배했습니다");
    document.getElementsByClassName("right")[0].style.display = "none";
    document.getElementsByClassName("left")[0].style.display = "none";
    document.getElementById("select_difficulty").style.display = "block";
    document.getElementById("radio_difficulty1").checked = false;
    document.getElementById("radio_difficulty2").checked = false;
    document.getElementById("radio_difficulty3").checked = false;
    return;
  }

  const try_box = [];
  try_box.push(document.getElementById("try_box_1").value);
  try_box.push(document.getElementById("try_box_2").value);
  try_box.push(document.getElementById("try_box_3").value);
  try_box.push(document.getElementById("try_box_4").value);

  alert(try_box);
  const answer_box = [];
  answer_box.push(document.getElementById("answer_box_1").value);
  answer_box.push(document.getElementById("answer_box_2").value);
  answer_box.push(document.getElementById("answer_box_3").value);
  answer_box.push(document.getElementById("answer_box_4").value);

  console.log(try_box);
  console.log(answer_box);

  for (let i = 0; i < 4; i++) {
    if (try_box[i] == answer_box[i]) {
      strike++;
    } else if (answer_box.includes(try_box[i])) {
      ball++;
    }
  }
  alert("strike:" + strike + " " + "ball" + ball);
  if (strike == 4) {
    alert("게임에서 승리했습니다");
    document.getElementsByClassName("right")[0].style.display = "none";
    document.getElementsByClassName("left")[0].style.display = "none";
    document.getElementById("select_difficulty").style.display = "block";
    document.getElementById("radio_difficulty1").checked = false;
    document.getElementById("radio_difficulty2").checked = false;
    document.getElementById("radio_difficulty3").checked = false;
  }
  let result = "strike: " + strike + " " + "ball: " + ball;
  write_record(try_box, result);
}

function set_try_count() {
  let count = 0;
  if (document.getElementById("radio_difficulty1").checked) {
    count = 30;
  } else if (document.getElementById("radio_difficulty2").checked) {
    count = 20;
  } else if (document.getElementById("radio_difficulty3").checked) {
    count = 7;
  }
  //document.getElementById("trycnt_display").innerHTML =
  return count;
}

function dp_cnt() {
  let count = set_try_count();
  document.getElementById("trycnt_display").innerHTML = count;
}

function gg() {
  alert(
    document.getElementById("answer_box_1").value +
      document.getElementById("answer_box_2").value +
      document.getElementById("answer_box_3").value +
      document.getElementById("answer_box_4").value
  );
  document.getElementsByClassName("right")[0].style.display = "none";
  document.getElementsByClassName("left")[0].style.display = "none";
  document.getElementById("select_difficulty").style.display = "block";
  document.getElementById("radio_difficulty1").checked = false;
  document.getElementById("radio_difficulty2").checked = false;
  document.getElementById("radio_difficulty3").checked = false;
}

function write_record(param, result) {
  document.getElementById("records").innerHTML +=
    "<P>" + param + "<br>" + result + "<br></P>";
}
