import NavBar from "./components/NavBar/NavBar";
import Home from "./Pages/Home/Home";
import "./App.css";
import { Routes, Route } from "react-router-dom";
import Login from "./Pages/Login/Login";
import Register from "./Pages/Registro/Register";
import Perfil from "./Pages/Perfil/PerfilUsuario";
import Informacion from "./Pages/Informacion/Informacion";
import QuienesSomos from "./Pages/QuienesSomos/Team";
import Actividades from "./Pages/Actividades/Actividades";

function App() {
  return (
    <>
      <div className="superposicion">
        <div className="container-principal">
          <div className="superposicion">
            <NavBar />
            <Routes>
              <Route path="/" element={<Home />}></Route>
              <Route path="/login" element={<Login />}></Route>
              <Route path="/registro" element={<Register />}></Route>
              <Route path="/perfil" element={<Perfil />}></Route>
              <Route path="/informacion" element={<Informacion />}></Route>
              <Route path="/quienesSomos" element={<QuienesSomos />}></Route>
              <Route path="/actividades" element={<Actividades />}></Route>
            </Routes>
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
