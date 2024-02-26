import React from "react";
import "./home.css";
import Fondo from "../../components/assets/Fondo_Home.svg";

function Home() {
  return (
    <>
      <div className="container">
        <div className="Contenedor-Text1">
          <div className="bar-container"></div>
          <p>TODOS PODEMOS HACER ALGO POR NUESTRO PAÍS</p>
        </div>
        <div className="Contenedor-Text2">
          <h1>
            Los árboles ya hacen mucho por nosotros ¿y tú, qué vas a hacer por
            ellos?
          </h1>
        </div>
        <div className="btt-container">
          <button className="btt">APADRINAR UN ÁRBOL</button>
          <button className="btt">SER VOLUNTARIO</button>
        </div>
      </div>
    </>
  );
}

export default Home;
