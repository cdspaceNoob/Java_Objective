import React from "react";
import Comment from "./Comment";

const comments = [
  {
    name: "voyager01",
    comment: "1호기",
  },
  {
    name: "voyager02",
    comment: "2호기",
  },
  {
    name: "voyager03",
    comment: "3호기",
  },
];

function CommentList(props) {
  return (
    <div>
      {comments.map((item) => {
        return <Comment name={item.name} comment={item.comment} />;
      })}
    </div>
  );
}

export default CommentList;
