import React from "react";
import ReactDOM from "react-dom/client";
// import AttendenceBook from "./chapter_10/AttendenceBook";
import NameForm from "./chapter_11/NameForm";
import FruitSelector from "./chapter_11/Select";
import "./index.css";
// import App from "./App";
import reportWebVitals from "./reportWebVitals";
// import Library from "./chapter_03/Library";
// import CommentList from "./chapter_05/CommentList";
// import Counter from "./chapter_07/Counter";
// import Accomodate from "./chapter_07/Accomodate";
// import Login from "./chapter_09/login";
import Calculator from "./chapter_12/Calculator";
import MainPage from "./chapter_15/MainPage";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <MainPage />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
