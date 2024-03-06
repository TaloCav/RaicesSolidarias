import React, { useEffect, useState } from "react";
import "./Donar.css";
import imgDonar from "../../components/assets/deciduous-tree.svg";
import axios from "axios";
import { Link } from "react-router-dom";

function Donar() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/arbol/todos").then((response) => {
      setData(response.data);
    });
  }, []);
  const dataDonacion = data.slice(0, 20);

  const handleDonarClick = () => {
    window.location.href = "https://www.mercadopago.cl/"; // Reemplaza con la URL de Mercado Pago
  };

  return (
    <>
      <div className="container-fix">
        <div className="donar-container">
          {data &&
            dataDonacion.map((item) => (
              <div key={item.id} className="card-Donar">
                <div>
                  <img className="tamañoImgDonar" src={imgDonar} alt="" />
                </div>
                <div className="informacion-Donar">
                  <p>Nombre : {item.nombreComun}</p>
                  <p>Tipo : {item.tipo}</p>
                  <p>Precio : {item.precio}</p>
                </div>
                <button className="donar-button" onClick={handleDonarClick}>
                  APADRINAR CON MERCADO PAGO
                </button>
              </div>
            ))}
        </div>
      </div>
    </>
  );
}

export default Donar;
