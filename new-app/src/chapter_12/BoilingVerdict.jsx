import React from "react";

function BoilingVerdict(props) {
  if (props.celsius >= 100) {
    return <p>물이 끓습니다.</p>;
  } else {
    return <p>물이 안 끓어요.</p>;
  }
}

export default BoilingVerdict;