import "./Navbar.css";
import logo from "../assets/logo.png";
import React from "react";
import { Link } from "react-router-dom";

function NavBar() {
  return (
    <header>
      <div className="contenedor-nav">
        <div className="nav-logo">
          <img className="logo" src={logo} alt="Raices Logo" />
        </div>
        <div className="navbar">
          <ul className="nav-menu">
            <li>
              <a className="text-liA" href="#quienesSomosHref">
                ¿Quiénes Somos?
              </a>
            </li>
            <li>
              <a className="text-liA" href="#informateHref">
                Infórmate
              </a>
            </li>
            <li>
              <a className="text-liA" href="#nuestrasActividadesHref">
                Nuestras Actividades
              </a>
            </li>
          </ul>
        </div>
        <a href="/login">
          <button className="Contactame">CONECTARME</button>
        </a>
      </div>
    </header>
  );
}

export default NavBar;
