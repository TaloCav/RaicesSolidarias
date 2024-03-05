import "./Navbar.css";
import logo from "../assets/logo.png";
import React from "react";
import { Link } from "react-router-dom";

function NavBar({ user }) {
  Link;

  return (
    <header>
      <div className="contenedor-nav">
        <div className="nav-logo">
          <img className="logo" src={logo} alt="Raices Logo" />
        </div>
        <div className="navbar">
          <ul className="nav-menu">
            <li>
              <Link className="text-liA" to="/quienesSomos">
                ¿Quiénes Somos?
              </Link>
            </li>
            <li>
              <Link className="text-liA" to="/informacion">
                Infórmate
              </Link>
            </li>
            <li>
              <Link className="text-liA" to="/actividades">
                Nuestras Actividades
              </Link>
            </li>
          </ul>
        </div>
        {!user && (
          <button className="btt-perfil-usuario">
            <Link to="/login">CONECTARME</Link>
          </button>
        )}
        {user && (
          <button className="Conectarme">
            <Link to="/pefil">MI PERFIL</Link>
          </button>
        )}
      </div>
    </header>
  );
}

export default NavBar;
