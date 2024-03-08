import React, { useEffect, useState } from "react";
import "./Donar.css";
import imgDonar from "../../components/assets/deciduous-tree.svg";
import axios from "axios";

function Donar() {
  const [data, setData] = useState([]);
  const [userEmail, setUserEmail] = useState(""); // Estado para almacenar el email del usuario

  useEffect(() => {
    axios.get("http://localhost:8080/arbol/todos").then((response) => {
      setData(response.data);
    });
    
    // Obtener el correo electrónico del usuario del almacenamiento local (localStorage)
    const storedUser = localStorage.getItem("user");
    if (storedUser) {
      const userData = JSON.parse(storedUser);
      setUserEmail(userData.email);
    }
  }, []);

  const dataDonacion = data.slice(0, 20);

  const handleDonarClick = (arbolId) => {
    // Enviar una solicitud HTTP al backend con el email del usuario y el ID del árbol
    axios.post("http://localhost:8080/usuario/asignar-arbol", { email: userEmail, arbolId })
      .then((response) => {
        console.log("Arbol asignado correctamente:", response.data);
        // Aquí puedes manejar la respuesta del backend, si es necesario
      })
      .catch((error) => {
        console.error("Error al asignar el árbol:", error);
        // Aquí puedes manejar los errores de la solicitud HTTP, si es necesario
      });
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
                {/* Pasar el ID del árbol al hacer clic en el botón */}
                <button className="donar-button" onClick={() => handleDonarClick(item.id)}>
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