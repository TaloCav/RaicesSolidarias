import React, { useEffect, useState } from "react";
import "./Arboles.css";
import Arbol from "../assets/deciduous-tree.svg";
import axios from "axios";

function Arboles() {
  const [data, setData] = useState([]);
  const [emailUsuario, setEmailUsuario] = useState("");

  useEffect(() => {
    // Obtener el email del usuario almacenado en localStorage
    const emailUsuarioStorage = JSON.parse(localStorage.getItem("user")).email;
    setEmailUsuario(emailUsuarioStorage);

    // Obtener los árboles asociados al usuario con el email obtenido
    axios.get(`http://localhost:8080/usuario/${emailUsuarioStorage}/arboles`)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error("Error al obtener los árboles:", error);
      });
  }, []);

  const dataToShow = data.slice(0, 4);

  return (
    <>
      <div className="container-arbol">
        <h2>Árboles</h2>
        {dataToShow.map((item) => (
          <div key={item.id} className="card">
            <img src={Arbol} alt="Arbolito" />
            <div>
              <p>Nombre : {item.nombreComun}</p>
              <p>Tipo :{item.tipo}</p>
            </div>
          </div>
        ))}

      </div>
    </>
  );
}

export default Arboles;