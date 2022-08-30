import React from "react";

const students = [
  {
    id: 1,
    name: "ninja",
  },
  {
    id: 2,
    name: "samurai",
  },
  {
    id: 3,
    name: "blader",
  },
];

// name 속성만 있으면 key가 없다고 나온다
// react_devtools_backend.js:4026 Warning: Each child in a list should have a unique "key" prop.
function AttendenceBook(props) {
  return (
    <div>
      {students.map((student, index) => {
        // return <li key={student.id}>{student.name}</li>;

        // map 함수에 기본적으로 포함되어 있는 index를 사용할 수도 있다
        return <li key={index}>{student.name}</li>;
      })}
    </div>
  );
}

export default AttendenceBook;
