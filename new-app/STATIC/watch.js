let clock;

function display_now() {
  const root = document.getElementById("root");

  clock = setInterval(() => {
    root.innerHTML = new Date().toLocaleTimeString();
  }, 1000);
  //setInterval(함수, ms)
}

function control_time(flag) {
  if (flag == true) {
    display_now();
  } else {
    clearInterval(clock);
  }
}
