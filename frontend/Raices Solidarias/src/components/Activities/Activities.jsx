import React, { useEffect, useState } from "react";
import "./Activities.css";
import imgActividades from "../../components/assets/imgActividades.jpg";
import axios from "axios";

function Activities() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/actividad/todos").then((respuesta) => {
      setData(respuesta.data);
    });
  }, []);

  return (
    <>
      <div className="container-actividades">
        {data &&
          data.map((item) => (
            <div key={item.id} className="card-actividades">
              <img
                className="imgActividades"
                src={imgActividades}
                alt="actividades"
              />
              <div className="container-textActividades">
                <p>Nombre: {item.nombre}</p>
                <p>Fecha: {item.fecha}</p>
                <p>Descripcion: {item.descripcion}</p>
                <p>Árboles Sembrados: {item.arbolesSembrados}</p>
              </div>
            </div>
          ))}
      </div>
    </>
  );
}

export default Activities;
