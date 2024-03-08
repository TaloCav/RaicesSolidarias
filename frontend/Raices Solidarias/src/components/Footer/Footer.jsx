import React from "react";
import "./Footer.css";
import logoFooter from "../../components/assets/logo.png";
import { Link } from "react-router-dom";

function Footer() {
  return (
    <>
      <footer className="container-footer">
        <div className="container-imgFooter">
          <img className="logoFooter" src={logoFooter} alt="logo footer" />
          <p>Copyright 2024 Raíces Solidarias</p>
        </div>
        <div className="container-navFooter">
          <div className="container-FootInformate">
            <h2 className="titulo-footer">Infórmate</h2>
            <ul className="nav-footer">
              <Link className="linkFooter" to="/informacion">
                <li>Deforestación</li>
              </Link>
              <Link className="linkFooter" to="/informacion">
                <li>Tala Ilegal</li>
              </Link>
              <Link className="linkFooter" to="/informacion">
                <li>Árboles nativos de Chile</li>
              </Link>
              <Link className="linkFooter" to="/informacion">
                <li>Plantación de árboles</li>
              </Link>
              <Link className="linkFooter" to="/informacion">
                <li>Manejo sostenible</li>
              </Link>
            </ul>
          </div>
          <div className="container-FootRaicesSolidarias">
            <h2 className="titulo-footer">Raíces Solidarias</h2>
            <ul className="nav-footer">
              <Link className="linkFooter" to="/quienesSomos">
                <li>El Equipo</li>
              </Link>
              <Link className="linkFooter" to="/quienesSomos">
                <li>Misión & Visión</li>
              </Link>
              <Link className="linkFooter" to="/registro">
                <li>Únete a la Causa</li>
              </Link>
            </ul>
          </div>
        </div>
      </footer>
    </>
  );
}

export default Footer;
