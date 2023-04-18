import React, { useState } from "react";

export default function AddMessage() {

    const [formData, setFormData] = useState({
       message_id: "", 
       message_text: ""
    });

    const [formSubmitted, setFormSubmitted] = useState(false);

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(formData),
            redirect: 'follow'
        };

        fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/message/message', requestOptions)
        .then((response) => response.json())
        .then((data) => {
            console.log(data)
            setFormSubmitted(true);
        }) .catch((error) => {
            console.log(error);
        });
    }
    

    return(
        <React.Fragment>
            <form 
                method="POST" 
                action="https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/message/message"
                onSubmit={handleSubmit}
            >
                <label>
                    Id:
                    <input 
                        type="number"
                        name="message_id"
                        value={formData.message_id}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Text:
                    <input 
                        type="text"
                        name="message_text"
                        value={formData.message_text}
                        onChange={handleInputChange}
                    />
                </label>

                <button type="submit">Submit</button>
                {formSubmitted ? <p>Reload page</p> : null}
            </form>
        </React.Fragment>
    );
};