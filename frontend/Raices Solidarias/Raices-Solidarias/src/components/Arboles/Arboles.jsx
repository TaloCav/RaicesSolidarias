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
  const dataToShow = data.slice(0, 4);

  return (
    <>
      <div className="container-arbol">
        <h2>Árboles</h2>
         {data &&
          dataToShow.map((item) => ( 
            <div  key={item.id}  className="card">
              <img src={Arbol} alt="Arbolito" />
              <div>
                <p>Nombre : { item.nombreComun }</p>
                <p>Tipo :{ item.tipo}</p>
                
              </div>
            </div>
           ))} 
      </div>
    
    </>
  );
}
export default Arboles;
