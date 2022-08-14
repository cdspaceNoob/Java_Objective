function alert_prac() {
  alert("연결 됐습니다");
}

function calendar(year, month) {
  const d1 = new Date(year, month - 1, 1);
  const d2 = new Date(year, month, 0);
  document.getElementById("year_month").innerHTML =
    "\t\t" + year + "년 " + month + "월";

  let blank = d1.getDay();
  let last = d2.getDay();
  let date = 1;
  let week = "";
  let result = "";

  for (i = 0; i < blank; i++) {
    week = week + "\t";
  }
}
