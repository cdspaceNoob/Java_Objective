import React, { useEffect, useState } from "react";
import Toolbar from "./Toolbar";

function Login(props) {
  const [isLogedIn, setIsLogedIn] = useState(true);
  const handlerLogin = () => {
    setIsLogedIn(true);
    console.log(isLogedIn);
  };
  const handlerLogOut = () => {
    setIsLogedIn(false);
    console.log(isLogedIn);
  };

  return (
    <div>
      <Toolbar
        isLogedIn={isLogedIn}
        onClickLogIn={handlerLogin}
        onClickLogOut={handlerLogOut}
      />
      <br />
    </div>
  );
}

export default Login;
