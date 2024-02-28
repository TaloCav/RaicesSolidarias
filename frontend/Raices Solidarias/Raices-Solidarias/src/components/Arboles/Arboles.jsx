import React, { useEffect, useState } from "react";
import "./Arboles.css";
import Arbol from "../assets/deciduous-tree.svg";
import axios from "axios";

function Arboles() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/arbol/todos").then((response) => {
      setData(response.data);
    });
  }, []);

  return (
    <>
      <div className="container-perfil">
        <h2>Árboles</h2>
        {data &&
          data.map((item) => (
            <div key={item.id} className="card">
              <img src={Arbol} alt="Arbolito" />
              <div>
                <p>Nombre comun:{item.nombreComun}</p>
                <p>Nombre Cientifico{item.nombreCientifico}:</p>
              </div>
            </div>
          ))}
      </div>
    </>
  );
}
export default Arboles;
