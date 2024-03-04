import React from "react";
import "./Login.css";
import logoLogin from "../../components/assets/logo.png";
import { Link } from "react-router-dom";

function Login() {
  return (
    <>
      <div className="contenedor-hiddenNavbar">
        <div className="contenedorLogoLogin">
          <img className="logoLogin" src={logoLogin} alt="logo para login" />
        </div>
        <div className="contenedor-volver">
          <a className="volver" href="/">
            Volver
          </a>
        </div>
        <div className="contenedor-login">
          <form action="" className="form-login">
            <h1 className="titulo-login">Iniciar Sesión</h1>
            <div className="inputContainerLogin">
              <input
                type="text"
                className="input"
                id="email-login"
                placeholder="a"
              />
              <label htmlFor="email-login" className="label">
                Email
              </label>
            </div>

            <div className="inputContainerLogin">
              <input
                type="text"
                className="input"
                id="contraseña-login"
                placeholder="a"
              />
              <label htmlFor="contraseña-login" className="label">
                Contraseña
              </label>
            </div>
            <input type="submit" className="submitBtn" value="Conectarme" />
            <p className="text-login">¿No tienes cuenta? </p>
            <p className="text-login2">
              <Link to="/registro">Registrate aqui.</Link>
            </p>
          </form>
        </div>
      </div>
    </>
  );
}

export default Login;
