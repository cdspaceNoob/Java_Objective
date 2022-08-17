function game_start() {
  document.getElementById("select_difficulty").style.display = "none";

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
  set_answer();
  set_try_count();
  dp_cnt();
}

function set_answer() {
  const number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

  let value01 = Math.floor(Math.random() * (10 - 1) + 1);
  document.getElementById("answer_box_1").value = number[value01];
  number.splice(number[value01], 1);
  alert(document.getElementById("answer_box_1").value);

  let value02 = Math.floor(Math.random() * (9 - 0) + 1);
  document.getElementById("answer_box_2").value = number[value02];
  number.splice(number[value02], 1);
  alert(document.getElementById("answer_box_2").value);

  let value03 = Math.floor(Math.random() * (8 - 0) + 1);
  document.getElementById("answer_box_3").value = number[value03];
  number.splice(number[value03], 1);
  alert(document.getElementById("answer_box_3").value);

  let value04 = Math.floor(Math.random() * (7 - 0) + 1);
  document.getElementById("answer_box_4").value = number[value04];
  number.splice(number[value04], 1);
  alert(document.getElementById("answer_box_4").value);
}

function match_number() {
  let strike = 0;
  let ball = 0;

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
