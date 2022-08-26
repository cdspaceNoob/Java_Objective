import React from "react";
import Comment from "./Comment";

function CommentList() {
  return (
    <div>
      <Comment name={"voyager01"} comment={"first react app"} />
      <Comment name={"voyager02"} comment={"second flight"} />
    </div>
  );
}

export default CommentList;
