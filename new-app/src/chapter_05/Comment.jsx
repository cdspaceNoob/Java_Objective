import React from "react";

function Comment(props) {
  return (
    <div>
      <span>{props.name}</span>
      <br />
      <span>{props.comment}</span>
    </div>
  );
}

export default Comment;
