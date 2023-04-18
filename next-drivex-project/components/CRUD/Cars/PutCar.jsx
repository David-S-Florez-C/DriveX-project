import React, { useState } from "react";

export default function PutCar() {

    const [formData, setFormData] = useState({
       brand: "",
       model: "",
       category_id: "",
       car_id: "" 
    });

    const [formSubmitted, setFormSubmitted] = useState(false);

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let requestOptions = {
            method: 'PUT',
            headers: myHeaders,
            body: JSON.stringify(formData),
            redirect: 'follow'
        };

        try {
            const response = await fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car', requestOptions)
            console.log(response.status)
            if(response.status == 200) {
                const data = await response.json();
                console.log(data);
                setFormSubmitted(true);
            } else {
                console.log(`Error al enviar el formulario. Estado HTTP: ${response.status}`);
            }
        } catch(error) {
            console.log(error);
        };
    }
    

    return(
        <React.Fragment>
            <form 
                method="PUT" 
                action="https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car"
                onSubmit={handleSubmit}
            >
                <label>
                    Brand:
                    <input 
                        type="text"
                        name="brand"
                        value={formData.brand}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Model:
                    <input 
                        type="number"
                        name="model"
                        value={formData.model}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Category:
                    <input 
                        type="number"
                        name="category_id"
                        value={formData.category_id}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Id:
                    <input 
                        type="number"
                        name="car_id"
                        value={formData.car_id}
                        onChange={handleInputChange}
                    />
                </label>

                <button type="submit">Actualizar</button>
                {formSubmitted ? <p>Actualizado</p> : <p>La liaste</p>}
            </form>
        </React.Fragment>
    );
};