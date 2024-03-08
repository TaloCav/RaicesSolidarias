import React, { useState } from "react";
import "./Login.css";
import logoLogin from "../../components/assets/logo.png";
import { Link } from "react-router-dom";
import axios from "axios";

function Login({ setUser }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/api/auth/login", {
        email: email,
        password: password,
      })
      .then((resp) => {
        setUser(resp.data);
        // Almacena solo el correo electrónico en localStorage
        localStorage.setItem("user", JSON.stringify({ email: email }));
      })
      .catch((error) => setUser(resp.data));
  };

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
          <form
            className="form-login"
            onSubmit={(e) => handleLogin(e)}
            method="post"
          >
            <h1 className="titulo-login">Iniciar Sesión</h1>
            <div className="inputContainerLogin">
              <input
                type="text"
                className="input"
                id="email-login"
                placeholder="Correo electrónico"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
              <label htmlFor="email-login" className="label">
                Email
              </label>
            </div>

            <div className="inputContainerLogin">
              <input
                type="password"
                className="input"
                id="contraseña-login"
                placeholder="Contraseña"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
              <label htmlFor="contraseña-login" className="label">
                Contraseña
              </label>
            </div>
            <input type="submit" className="submitBtn" value="Conectarme" />
            <p className="text-login">¿No tienes cuenta? </p>
            <p className="text-login2">
              <Link to="/registro">Regístrate aquí.</Link>
            </p>
          </form>
        </div>
      </div>
    </>
  );
}

export default Login;