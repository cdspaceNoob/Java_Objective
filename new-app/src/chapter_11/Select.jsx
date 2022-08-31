import React, { useState } from "react";

function FruitSelector(props) {
  const [value, setValue] = useState("grape");

  const handlerChange = (event) => {
    setValue(event.target.value);
  };

  const handlerSubmit = (event) => {
    alert("선택한 과일은: " + value);
    event.preventDefault();
  };

  return (
    <form onSubmit={handlerSubmit}>
      <label>
        과일 선택
        <select value={value} onChange={handlerChange}>
          <option value="apple">사과</option>
          <option value="banana">바나나</option>
          <option value="tomato">토마토</option>
        </select>
      </label>
      <button type="submit">제출</button>
    </form>
  );
}

export default FruitSelector;
