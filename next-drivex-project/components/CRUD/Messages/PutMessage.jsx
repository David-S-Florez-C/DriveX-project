import React, { useState } from "react";

export default function PutMessage() {

    const [formData, setFormData] = useState({
       message_text: "",
       message_id: "" 
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
            const response = await fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/message/message', requestOptions)
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
                action="https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/message/message"
                onSubmit={handleSubmit}
            >
                <label>
                    Text:
                    <input 
                        type="text"
                        name="message_text"
                        value={formData.message_text}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Id:
                    <input 
                        type="number"
                        name="message_id"
                        value={formData.message_id}
                        onChange={handleInputChange}
                    />
                </label>

                <button type="submit">Actualizar</button>
                {formSubmitted ? <p>Actualizado</p> : <p>La liaste</p>}
            </form>
        </React.Fragment>
    );
};