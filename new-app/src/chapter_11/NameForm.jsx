import React, { useState } from "react";

function NameForm(props) {
  const [value, setValue] = useState("요청 사항을 입력하세요");

  const handleChange = (event) => {
    setValue(event.target.value);
  };

  const handleSubmit = (event) => {
    alert("입력한 이름: " + value);
    event.preverntDefault();
  };
  return (
    <form onSubmit={handleSubmit}>
      <label>
        이름:
        <textarea value={value} onChange={handleChange} />
      </label>
      <button type="submit">제출</button>
    </form>
  );
}

export default NameForm;
