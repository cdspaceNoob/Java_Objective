import React from "react";

//isLogedIn?인지 뭐에 따라 상태가 변화
function Toolbar(props) {
  //set은 모르것다
  const numbers = [1, 2, 3, 4, 5];
  const items = numbers.map((number) => <li>{number}</li>);
  return (
    <div>
      {props.isLogedIn && <span>안녕하세요</span>}
      {props.isLogedIn ? (
        <button onClick={props.onClickLogIn}>log in</button>
      ) : (
        <button onClick={props.onClickLogOut}>log out</button>
      )}
      {items}
    </div>
  );
}

export default Toolbar;
