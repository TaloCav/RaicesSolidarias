import "./Navbar.css";
import logo from "../assets/logo.png";
import React from "react";

function NavBar() {
  return (
    <header>
      <div className="contenedor-nav">
        <div className="nav-logo">
          <img className="logo" src={logo} alt="Raices Logo" />
        </div>
        <div className="navbar">
          <ul className="nav-menu">
            <li>¿Quiénes Somos?</li>
            <li>Infórmate</li>
            <li>Nuestras Actividades</li>
          </ul>
        </div>
        <button className="Contactame">CONECTARME</button>
      </div>
    </header>
  );
}

export default NavBar;
