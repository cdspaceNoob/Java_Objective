import React, { useEffect, useState } from "react";

// hook(useState사용)
function Counter(props) {
  let [count, setCount] = useState(0);
  let [cnt, setCnt] = useState(0);

  useEffect(() => {
    setCount(count + 1);
    console.log(count);
    return () => console.log("unmount");
  }, [cnt]);
  return (
    <div>
      <p>총 {count} 번 클릭했습니다.</p>
      <button
        onClick={() => {
          // setCount((count += 1));
          setCnt((cnt += 1));
        }}
      >
        클릭
      </button>
    </div>
  );
}

// export default Counter;

// js 기본 코드 사용
// function Counter(props) {
//   let count = 0;
//   return (
//     <div>
//       <p>총 {count} 번 클릭했습니다.</p>
//       <button
//         onClick={() => {
//           count += 1;
//           console.log(count);
//         }}
//       >
//         클릭
//       </button>
//     </div>
//   );
// }

export default Counter;
