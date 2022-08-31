import React, { useState } from "react";
import BoilingVerdict from "./BoilingVerdict";

function Calculator(props) {
  const [temp, setTemp] = useState("");
  const handlerChange = (event) => {
    setTemp(event.target.value);
  };
  return (
    <fieldset>
      <legend>섭씨 온도를 입력하세요.</legend>
      <input value={temp} onChange={handlerChange} />
      <BoilingVerdict celsius={parseFloat(temp)} />
    </fieldset>
  );
}

export default Calculator;
