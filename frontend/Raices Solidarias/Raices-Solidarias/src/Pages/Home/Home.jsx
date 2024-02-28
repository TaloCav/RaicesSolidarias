import React from "react";
import "./home.css";
import ImagenPag2 from "../../components/assets/RegandoPlaneta.svg";
import ImagenPag3 from "../../components/assets/ManitosPlanta.svg";
import ImagenPag4 from "../../components/assets/SeñoraPlantando.svg";

function Home() {
  return (
    <>
      <div className="container">
        <div className="contenedor-Text1">
          <div className="bar-container"></div>
          <p>TODOS PODEMOS HACER ALGO POR NUESTRO PAÍS</p>
        </div>
        <div className="contenedor-Text2">
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
      <div className="container-home2">
        <div className="contenedor-Textos">
          <h2>¿Quiénes somos?</h2>
          <p>
            En Raíces Solidarias, nos comprometemos fervientemente con la
            restauración de los bosques nativos en Chile. A través de nuestra
            plataforma, puedes contribuir de manera cercana y cómoda a la
            reforestación. Además, encontrarás información de calidad para que
            descubras la belleza y la diversidad de la flora y fauna autóctona
            de Chile. ¡Recuerda que cada árbol que plantamos representa una
            esperanza para un mañana más verde y sostenible!
          </p>
          <button>leer mucho mucho sobre mucha gente</button>
        </div>
        <img className="tamañoImagen" src={ImagenPag2} alt="Imagen pag 2" />
      </div>
      <div className="container-home3">
        <img className="tamañoImagen" src={ImagenPag3} alt="Imagen pag 3" />
        <div className="contenedor-Textos">
          <h2>Infórmate</h2>
          <p>
            ¡Únete a nuestra comunidad y sumérgete en el corazón de los bosques
            chilenos! Contribuimos a la preservación de los bosques nativos a
            través de la reforestación colaborativa y la educación activa. En
            Raíces Solidarias, no solo plantamos árboles, sino que cultivamos un
            futuro sostenible para las nuevas generaciones.
          </p>
          <button>leer mucho mucho sobre mucha gente</button>
        </div>
      </div>

      <div className="container-home4">
        <div className="contenedor-Textos">
          <h2>Nuestras Actividades</h2>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
            ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
            aliquip ex ea commodo consequat. Duis aute irure dolor in
            reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
            pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
            culpa qui officia deserunt mollit anim id est laborum.
          </p>
          <button>leer mucho mucho sobre mucha gente</button>
        </div>
        <img className="tamañoImagen" src={ImagenPag4} alt="Imagen pag 4" />
      </div>
    </>
  );
}

export default Home;
