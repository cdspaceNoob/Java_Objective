import React from "react";
import Book from "./book";

function Library(props) {
  return (
    <div>
      <Book name="책1" numOfPage={100}></Book>
      <Book name="책2" numOfPage={200}></Book>
      <Book name="책3" numOfPage={300}></Book>
    </div>
  );
}
export default Library;
