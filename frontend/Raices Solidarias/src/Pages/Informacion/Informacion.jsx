import { useState } from "react";
import "./informacion.css";
import imagenFondo from "../../components/assets/ArbolInformacion.svg";

function Informacion() {
  const [openTab, setOpenTab] = useState("informacion1");
  const [cambiarColor, setColor] = useState("btt-tabs");

  return (
    <>
      <div className="container-principalInformaciones">
        <div className="container-tabuladores">
          <div className="tabuladores">
            <ul className="tab-menu">
              <button
                className={
                  cambiarColor === "btt-tabs1" ? "btt-tabs1" : "btt-tabs"
                }
                onClick={() => {
                  setOpenTab("informacion1");
                  setColor("btt-tabs1");
                }}
              >
                Texto1
              </button>
              <button
                className={
                  cambiarColor === "btt-tabs2" ? "btt-tabs2" : "btt-tabs"
                }
                onClick={() => {
                  setOpenTab("informacion2");
                  setColor("btt-tabs2");
                }}
              >
                Texto2
              </button>
              <button
                className={
                  cambiarColor === "btt-tabs3" ? "btt-tabs3" : "btt-tabs"
                }
                onClick={() => {
                  setOpenTab("informacion3");
                  setColor("btt-tabs3");
                }}
              >
                Texto3
              </button>
              <button
                className={
                  cambiarColor === "btt-tabs4" ? "btt-tabs4" : "btt-tabs"
                }
                onClick={() => {
                  setOpenTab("informacion4");
                  setColor("btt-tabs4");
                }}
              >
                Texto4
              </button>
              <button
                className={
                  cambiarColor === "btt-tabs5" ? "btt-tabs5" : "btt-tabs"
                }
                onClick={() => {
                  setOpenTab("informacion5");
                  setColor("btt-tabs5");
                }}
              >
                Texto5
              </button>
            </ul>
          </div>
          <div className="container-info">
            <>
              {openTab === "informacion1" ? (
                <h2 className="titulo-info">Titulo1</h2>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion2" ? (
                <h2 className="titulo-info">Titulo2</h2>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion3" ? (
                <h2 className="titulo-info">Titulo3</h2>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion4" ? (
                <h2 className="titulo-info">Titulo4</h2>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion5" ? (
                <h2 className="titulo-info">Titulo5</h2>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion1" ? (
                <p className="text-info">hola</p>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion2" ? (
                <p className="text-info">gente</p>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion3" ? (
                <p className="text-info">del yutu</p>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion4" ? (
                <p className="text-info">como</p>
              ) : (
                <></>
              )}
            </>
            <>
              {openTab === "informacion5" ? (
                <p className="text-info">estamos?</p>
              ) : (
                <></>
              )}
            </>
          </div>
          <img className="imagen-info" src={imagenFondo} alt="Imagen-Info" />
        </div>
      </div>
    </>
  );
}

export default Informacion;
