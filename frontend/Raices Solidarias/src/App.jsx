import NavBar from "./components/NavBar/NavBar";
import Home from "./Pages/Home/Home";
import "./App.css";
import { Routes, Route, useLocation } from "react-router-dom";
import Login from "./Pages/Login/Login";
import Register from "./Pages/Registro/Register";
import Perfil from "./Pages/Perfil/PerfilUsuario";
import Informacion from "./Pages/Informacion/Informacion";
import QuienesSomos from "./Pages/QuienesSomos/Team";
import Actividades from "./Pages/Actividades/Actividades";
import { useState } from "react";

function App() {
  const [user, setUser] = useState(null);
  /*  {useLocation} */

  let { pathname } = useLocation();
  const myRuts = () => {
    let isValid = true;
    if (pathname === "/") isValid = false;
    if (pathname === "/informacion") isValid = false;
    if (pathname === "/quienesSomos") isValid = false;
    return isValid;
  };
  console.log(pathname);
  return (
    <>
      <div className="lazyImg">
        <div className="container-principal">
          <NavBar />
          {myRuts() && user === null && <Login />}
          <Routes>
            <Route path="/" element={<Home />}></Route>
            <Route path="/registro" element={<Register />}></Route>
            <Route path="/perfil" element={<Perfil />}></Route>
            <Route path="/informacion" element={<Informacion />}></Route>
            <Route path="/quienesSomos" element={<QuienesSomos />}></Route>
            <Route path="/actividades" element={<Actividades />}></Route>
          </Routes>
        </div>
      </div>
    </>
  );
}

export default App;
