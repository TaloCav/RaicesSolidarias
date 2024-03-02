import React from "react";
import "./Team.css";
import ImagenTeam from "../../components/assets/ArbolesTeam.svg";
import ImagenTeam2 from "../../components/assets/RastrilloTeam.svg";
import ImagenTeam3 from "../../components/assets/BosqueTeam.svg";
import BannerTeam from "../../components/assets/BANNER.jpg";
import Participacion from "../../components/assets/Participacion.svg";
import Compromiso from "../../components/assets/Compromiso.svg";
import Responsabilidad from "../../components/assets/Responsabilidad.svg";
import Ecoeficiencia from "../../components/assets/Ecoeficiencia.svg";

function Team() {
  return (
    <>
      <div>
        <div className="container-team">
          <img className="tamañoImg-Team" src={ImagenTeam} alt="ImagenTeam1" />
          <div className="container-TextTeam">
            <h2>Quienes somos</h2>
            <p>
              En Raíces Solidarias, nos comprometemos fervientemente con la
              restauración de los bosques nativos en Chile. A través de nuestra
              plataforma, puedes contribuir de manera cercana y cómoda a la
              reforestación. Además, encontrarás información de calidad para que
              descubras la belleza y la diversidad de la flora y fauna autóctona
              de Chile. ¡Recuerda que cada árbol que plantamos representa una
              esperanza para un mañana más verde y sostenible!
            </p>
          </div>
        </div>
        <div className="container-team">
          <div className="container-TextTeam">
            <h2>Misión</h2>
            <p>
              Nuestra misión es contribuir a la restauración de los bosques
              nativos en Chile mediante la reforestación activa de árboles
              autóctonos. Nos comprometemos a preservar la biodiversidad de
              nuestros bosques, fomentando una cultura respetuosa centrada en la
              colaboración y la formación de sólidas conexiones entre las
              comunidades locales. Aspiramos a forjar un legado de
              sostenibilidad para las nuevas generaciones.
            </p>
          </div>
          <img className="tamañoImg-Team" src={ImagenTeam2} alt="ImagenTeam2" />
        </div>
        <div className="container-team">
          <img className="tamañoImg-Team" src={ImagenTeam3} alt="ImagenTeam3" />
          <div className="container-TextTeam">
            <h2>Visión</h2>
            <p>
              En Raíces Solidarias deseamos un futuro donde los bosques nativos
              de Chile recuperan su vitalidad y grandeza gracias a nuestra
              misión. Visualizamos bosques ricos en biodiversidad, donde cada
              árbol plantado por nuestra comunidad se convierte en un pilar
              fundamental de la resistencia ambiental. Aspiramos a que Raíces
              Solidarias sea un faro de esperanza, inspirando a otras
              iniciativas y contribuyendo a un Chile más ecológico y sostenible
              para las futuras generaciones.
            </p>
          </div>
        </div>
        <div className="banner-Team"></div> {/* poner fotos aca dps */}
        <div>
          <div className="container-team-nuestrosValores">
            <h2>Nuestros Valores</h2>
          </div>
          <div className="container-imgTeam">
            <div className="container-imgText">
              <img
                className="tamaño-nuestrosValores"
                src={Participacion}
                alt="Nuestros-Valores-Img"
              />
              <h2>Participacion</h2>
            </div>
            <div className="container-imgText">
              <img
                className="tamaño-nuestrosValores"
                src={Compromiso}
                alt="Nuestros-Valores-Img"
              />
              <h2>Compromiso</h2>
            </div>
            <div className="container-imgText">
              <img
                className="tamaño-responsabilidad"
                src={Responsabilidad}
                alt="Nuestros-Valores-Img"
              />
              <h2>Responsabilidad</h2>
            </div>
            <div className="container-imgText">
              <img
                className="tamaño-nuestrosValores"
                src={Ecoeficiencia}
                alt="Nuestros-Valores-Img"
              />
              <h2>Ecoeficiencia</h2>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Team;
